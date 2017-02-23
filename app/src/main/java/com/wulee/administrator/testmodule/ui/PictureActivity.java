package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wulee on 2016/3/25.
 */
public class PictureActivity extends Activity {
        private TextView tvCamer,tvSelPic,tvCancel;
        /**
         * 照相
         */
        private static final int PHOTO_CAMERA = 11;
        private static final int PHOTO_LOCAL_SELECT = 12;
        private static final int PHOTO_CUT = 13;
        /**
         * 临时的文件
         */
        private String tempPhotoPath;
        /**
         * 剪切时临时的文件
         */
        private String tempCutPath;
        /**
         * 尺寸合适的bitmap
         */
        private Bitmap suitBitmap;

        private static  final String TEMP_FILE_PATH = Environment.getExternalStorageDirectory()+"/aaa/";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_layout);

        tvCamer = (TextView) findViewById(R.id.tv_camer);
        tvSelPic = (TextView) findViewById(R.id.tv_select_pic);
        tvCancel = (TextView) findViewById(R.id.tv_cancel);

            tvCamer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCamara();
            }
        });
        tvSelPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAlbum();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


        /**
         * 启动照相机
         */
    public void startCamara() {
        // 判断临时文件夹是否创建
        File photo = new File(TEMP_FILE_PATH);
        if (!photo.exists()) {
            try {
                photo.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tempPhotoPath = makeTmpPhotoPath();
        File file = new File(tempPhotoPath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Uri imageUri = Uri.fromFile(new File(tempPhotoPath));
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.putExtra("autofocus", true); // 自动对焦
        intent.putExtra("fullScreen", false); // 全屏
        intent.putExtra("showActionIcons", false);
        startActivityForResult(intent, PHOTO_CAMERA); // 没有剪切的动作
    }

    /**
     * 启动照片裁剪
     */
    public void startPhotoCutter(Uri uri) {
        tempCutPath = makeTmpCutPath();
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("scale", true);
        intent.putExtra("return-data", false);
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("crop", "true");
        File file = new File(TEMP_FILE_PATH);// 裁剪后图片保存的地址；
        if (!file.exists())
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(tempCutPath)));
        startActivityForResult(intent, PHOTO_CUT);
    }

    /**
     * 启动媒体库
     */
    public void startAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, PHOTO_LOCAL_SELECT);
    }


    /**
     * 照相时的临时路径
     */
    private String makeTmpPhotoPath() {
        return TEMP_FILE_PATH  + System.currentTimeMillis() + ".jpg";
    }

    /**
     * 剪切时的临时文件
     */
    private String makeTmpCutPath() {
        return TEMP_FILE_PATH  + System.currentTimeMillis() + ".jpg";
    }

    /**
     * 保存的图片路径
     */
    public static String makeSavePhotoPath() {
        return TEMP_FILE_PATH + System.currentTimeMillis() + ".jpg";
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PHOTO_LOCAL_SELECT:
                if (resultCode == Activity.RESULT_OK) {
                    if (data == null)
                        break;
                    Uri selectedImage = data.getData();
                    startPhotoCutter(selectedImage);
                }
                break;
            case PHOTO_CAMERA:
                if (resultCode == Activity.RESULT_OK) {
                    File photo = new File(TEMP_FILE_PATH);
                    if (!photo.exists())
                        try {
                            photo.mkdir();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    try {
                        Uri imageUri = Uri.fromFile(new File(tempPhotoPath));
                        if (imageUri != null) {
                            startPhotoCutter(imageUri);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
                break;
            case PHOTO_CUT:
                if (resultCode == Activity.RESULT_OK) {
                    suitBitmap = resizeBitmapForce(tempCutPath, 300, 300);
                    String savePath =  makeSavePhotoPath();
                    if (savePhotoToSDcard(suitBitmap, savePath)) {
                        Intent intent = new Intent();
                        intent.putExtra("save_path",savePath);
                        setResult(RESULT_OK,intent);
                        this.finish();
                    }
                }
                break;


        }
    }


    /**
     * 压缩图片---等比例缩放图片，当原图尺寸小于目标尺寸（int resampleWidth, int
     * resampleHeight）的时候，原图被拉伸至目标值
     *
     * @param srcFilePath
     * @param resampleWidth
     * @param resampleHeight
     * @return
     */
    public static Bitmap resizeBitmapForce(String srcFilePath, int resampleWidth, int resampleHeight) {
        if (srcFilePath == null)
            throw new IllegalArgumentException("Image file path should not be null");

        Bitmap taget = null;
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inPurgeable = true;
        opts.inJustDecodeBounds = true; // 为true那么将不返回实际的bitmap
        BitmapFactory.decodeFile(srcFilePath, opts);
        opts.inJustDecodeBounds = false;
        opts.inSampleSize = getClosestResampleSize(opts.outWidth, opts.outHeight, Math.max(resampleWidth, resampleHeight));
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(srcFilePath, opts);
            if (bitmap == null) {
                return taget;
            }
            // 拿到图片的旋转值：为了满足有的机型
            int degree = getExifOrientation(srcFilePath);
            Matrix m = new Matrix();

            float qw = ((float) resampleWidth) / bitmap.getWidth();
            float qh = ((float) resampleHeight) / bitmap.getHeight();
            if (qh < qw) {
                float width01 = qh * bitmap.getWidth();
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) width01, (int) resampleHeight, true);
            } else {

                float height01 = qw * bitmap.getHeight();
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) resampleWidth, (int) height01, true);
            }
            if (0 != degree) {
                m.setRotate(degree, (float) bitmap.getWidth() / 2, (float) bitmap.getHeight() / 2);
            }
            taget = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
            if (taget != bitmap) {
                safeReleaseBitmap(bitmap);
            }

        } catch (OutOfMemoryError e) {
            Log.e("e", "resizeBitmap outofMemoryError.", e);
        }
        return taget;
    }

    /*
    * 计算需要压缩的尺寸
    */
    private static int getClosestResampleSize(int cw, int ch, int maxDim) {
        int max = Math.max(cw, ch);

        int resample = 1;
        for (resample = 1; resample < Integer.MAX_VALUE; resample++) {
            if (resample * maxDim > max) {
                resample--;
                break;
            }
        }

        if (resample > 0) {
            return resample;
        }
        return 1;
    }

    /*
    * 检查图片是否需要旋转
    */
    private static int getExifOrientation(String filepath) {
        int degree = 0;
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(filepath);
        } catch (IOException ex) {
            Log.e("", "cannot read exif", ex);
        }

        if (exif != null) {
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);
            if (orientation != -1) {
                switch (orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        degree = 90;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        degree = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        degree = 270;
                        break;
                }
            }
        }
        return degree;
    }

    /**
     * 安全释放Bitmap占用的资源
     *
     * @param bitmap
     */
    public static void safeReleaseBitmap(Bitmap bitmap) {
        if (null == bitmap)
            return;

        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        bitmap = null;
    }

    private boolean savePhotoToSDcard(Bitmap bitmap, String savePath) {
        if (bitmap == null || TextUtils.isEmpty(savePath))
            return false;
        try {
            File dirs = new File(TEMP_FILE_PATH);
            if (!dirs.exists())
                dirs.mkdirs();

            File photo = saveBitmap(bitmap, savePath);
            if (photo != null && photo.exists()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    /**
     * 将图片保存为文件,并返回图片的文件
     *
     * @param  bmp 要保存的图片对象
     * @param  dstFilePath 要保存的文件路径
     * @return File 被保存的图片文件
     */
    public static File saveBitmap(Bitmap bmp, String dstFilePath) throws IOException {
        if (bmp == null)
            throw new IllegalArgumentException("Image should not be null");

        if (dstFilePath == null)
            throw new IllegalArgumentException("File path should not be null");

        File file = new File(dstFilePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file);

        if (bmp != null && fos != null) {
            BufferedOutputStream bos = new BufferedOutputStream(fos, 4096);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.close();
            fos.close();
        }

        return file;
    }
}
