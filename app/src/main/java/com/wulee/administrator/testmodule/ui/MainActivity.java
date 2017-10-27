package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.ui.tabfragmnet.TabeTestActivity;
import com.wulee.administrator.testmodule.utils.LocationUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget);

        LocationUtils.getInstance(getApplicationContext()).startGetLocation();

        findViewById(R.id.btn_camer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TakePicResultActivity.class));
            }
        });
        findViewById(R.id.btn_get_server_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NetTimeActivity.class));
            }
        });
        findViewById(R.id.btn_expandable_textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExpendableTvActivity.class));
            }
        });
        findViewById(R.id.btn_media_player).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MediaPlayActivity.class));
            }
        });
        findViewById(R.id.btn_datetime_picker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DateTimePickerActivity.class));
            }
        });
        findViewById(R.id.btn_love).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TwinkleLoveActivity.class));
            }
        });
        findViewById(R.id.btn_parse_html).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ParseHtmlActivity.class));
            }
        });
        findViewById(R.id.btn_applaud_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ApplaudAnimationActivity.class));
            }
        });
        findViewById(R.id.btn_cakeview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CakeViewActivity.class));
            }
        });
        findViewById(R.id.btn_powerImageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PowerImageViewActivity.class));
            }
        });
        findViewById(R.id.btn_badgedView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BadgedViewActivity.class));
            }
        });
        findViewById(R.id.btn_richTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RichTextViewActivity.class));
            }
        });
        findViewById(R.id.btn_zoomImageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ClickZoomImageViewActivity.class));
            }
        });
        findViewById(R.id.btn_animation_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AnimationTestActivity.class));
            }
        });
        findViewById(R.id.btn_rollviewpager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RollViewPagerActivity.class));
            }
        });
        findViewById(R.id.btn_panelview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PanelViewActivity.class));
            }
        });
        findViewById(R.id.btn_clockview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ClockViewActivity.class));
            }
        });
        findViewById(R.id.btn_draw_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DrawTestActivity.class));
            }
        });
        findViewById(R.id.btn_gallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });
        findViewById(R.id.btn_circleimageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CircleImageViewActivity.class));
            }
        });
        findViewById(R.id.btn_flowlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FlowLayoutActivity.class));
            }
        });
        findViewById(R.id.btn_qq_health_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QQHealthActivity.class));
            }
        });
        findViewById(R.id.btn_grid_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GridLayoutActivity.class));
            }
        });
        findViewById(R.id.btn_guide_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GuidePageActivity.class));
            }
        });
        findViewById(R.id.btn_timeline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TimeLineActivity.class));
            }
        });
        findViewById(R.id.btn_timecount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TimeCountActivity.class));
            }
        });
        findViewById(R.id.btn_stick_listview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, XuanFuListView.class));
            }
        });
        findViewById(R.id.btn_sidebar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SideBarActivity.class));
            }
        });
        findViewById(R.id.btn_contacts_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityViewListLocal.class));
            }
        });
        findViewById(R.id.btn_actionbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActionBarActivity.class));
            }
        });
        findViewById(R.id.btn_curtain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CurtainActivity.class));
            }
        });
        findViewById(R.id.btn_dragview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DrawTestActivity.class));
            }
        });
        findViewById(R.id.btn_drawtextonpath).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DrawTextOnPathActivity.class));
            }
        });
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });
        findViewById(R.id.btn_coordinator_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CoordinatorTest.class));
            }
        });
        findViewById(R.id.btn_xml_to_json).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, XmlToJsonActivity.class));
            }
        });
        findViewById(R.id.btn_draw_line).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DrawLineTest.class));
            }
        });
        findViewById(R.id.btn_radar_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RadarViewActivity.class));
            }
        });
        findViewById(R.id.btn_zxing_qr_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ZxingQRCodeActivity.class));
            }
        });
        findViewById(R.id.btn_keyboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, KeyBoardMainActivity.class));
            }
        });
        findViewById(R.id.btn_tabfragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TabeTestActivity.class));
            }
        });
        findViewById(R.id.btn_imageview_auto_zoom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImageAutoZoomActivity.class));
            }
        });
        findViewById(R.id.btn_ad_count_down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdCountdownActiviy.class));
            }
        });
        findViewById(R.id.btn_num_edittext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NumEditTextActivity.class));
            }
        });
        findViewById(R.id.btn_zoom_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ZoomImageViewActivity.class));
            }
        });
        findViewById(R.id.btn_lableview).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LableViewActivity.class));
            }
        });
        findViewById(R.id.di_zhen_bo_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SeismicWaveViewActivity.class));
            }
        });
        findViewById(R.id.jin_du_tiao).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CBProgressActivity.class));
            }
        });
        findViewById(R.id.goo_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GooViewActivity.class));
            }
        });
        findViewById(R.id.headerview).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HeaderViewActivity.class));
            }
        });
        findViewById(R.id.surfaceview_test).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SurfaceViewTest.class));
            }
        });
        findViewById(R.id.gps_location).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GpsLocationActivity.class));
            }
        });
        findViewById(R.id.faceview).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FaceViewActivity.class));
            }
        });
    }

}
