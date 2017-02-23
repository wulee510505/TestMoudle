package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.RichTextView;

/**
 * Created by wulee on 2016/4/13.
 */
public class RichTextViewActivity extends Activity {
    private static final String SAMPLE_STRING =
            "This text is bold.\n" + // Bold = 13 - 18
                    "This text is italic.\n" + // Italic = 32 - 39
                    "This text is underlined.\n" + // Underlined = 53 - 64
                    "This text is strikethrough.\n" + // strikethrough = 78 - 92
                    "This text is superscript.\n" + // Superscript = 106 - 118
                    "This text is subscript.\n" + // Subscript = 132 - 142
                    "This text is blue.\n" + // Blue = 156 - 161
                    "This highlight is red."; // Red = 180 - 184

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rich_textview);

        RichTextView richTextView = (RichTextView) findViewById(R.id.richtextview);
        richTextView.setText(SAMPLE_STRING);
        richTextView.formatSpan(13, 18, RichTextView.FormatType.BOLD);
        richTextView.formatSpan(32, 39, RichTextView.FormatType.ITALIC);
        richTextView.formatSpan(53, 64, RichTextView.FormatType.UNDERLINE);
        richTextView.formatSpan(78, 92, RichTextView.FormatType.STRIKETHROUGH);
        richTextView.formatSpan(106, 118, RichTextView.FormatType.SUPERSCRIPT);
        richTextView.formatSpan(132, 142, RichTextView.FormatType.SUBSCRIPT);
        richTextView.colorSpan(156, 161, RichTextView.ColorFormatType.FOREGROUND, Color.BLUE);
        // Test formatting to end of string.
        richTextView.colorSpan(180, SAMPLE_STRING.length(), RichTextView.ColorFormatType.HIGHLIGHT, Color.RED);
    }

}
