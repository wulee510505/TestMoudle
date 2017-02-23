package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2016/4/5.
 */
public class ParseHtmlActivity extends Activity {

    private TextView textView;
    private WebView web1,web2;
    private String htmlcontent = "<html>\n" +
            "\t<head>\n" +
            "\t\t<meta charset=\"utf-8\">\n" +
            "\t\t<title></title>\n" +
            "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no\">\n" +
            "\t\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n" +
            "\t\t<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n" +
            "\t<style>\n" +
            "\t\tbody{\n" +
            "\t\t\tmargin:0;\n" +
            "\t\t\tfont-family: \"微软雅黑\";\n" +
            "\t\t}\n" +
            "        table{\n" +
            "            border: solid #e5e5e5;\n" +
            "            border-width:1px 0px 0px 1px;\n" +
            "        }\n" +
            "        \n" +
            "        td{\n" +
            "        \tborder:solid #e5e5e5; \n" +
            "\t\t\tborder-width:0px 1px 1px 0px;\n" +
            "\t\t\tpadding-top:10px;\n" +
            "\t\t\tpadding-bottom: 10px;\n" +
            "\t\t\ttext-align: center;\n" +
            "\t\t\tfont-size:14px;\n" +
            "            color:#a0a0a0;\n" +
            "        }\n" +
            "        .item_name{\n" +
            "        \tcolor:#4cbbab;\n" +
            "        }\n" +
            "\t</style>\n" +
            "\n" +
            "\t</head>\n" +
            "        <table border=\"1\" cellpadding=\"5\" cellspacing=\"0\" style=\"width: 95%;max-width: 720px;margin: 0 auto; font-size: 14px;color:#333;\" >\n" +
            "            <tr>\n" +
            "               <td width=\"30%\">类别</td>\n" +
            "               <td width=\"40%\">项目</td>\n" +
            "               <td width=\"30%\">价格</td>\n" +
            "            </tr>\n" +
            "            <!---->\n" +
            "            <tr>\n" +
            "                <td rowspan=\"4\" class=\"item_name\">空中急救</td>\n" +
            "                <td>个人急救包</td>\n" +
            "                <td>￥60.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>家庭急救包</td>\n" +
            "                <td>￥120.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>车载急救包</td>\n" +
            "                <td>￥120.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>急救培训</td>\n" +
            "                <td>免费</td>\n" +
            "            </tr>\n" +
            "            <!---->\n" +
            "            <tr>\n" +
            "                <td rowspan=\"9\" class=\"item_name\">单项检测</td>\n" +
            "                <td>医生咨询服务</td>\n" +
            "                <td>￥50.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>生命体征检测</td>\n" +
            "                <td>￥30.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>动态血压检测</td>\n" +
            "                <td>￥150.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>动态心电图</td>\n" +
            "                <td>￥150.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>骨密度检测</td>\n" +
            "                <td>￥80.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>肺功能检测</td>\n" +
            "                <td>￥180.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>体脂检测</td>\n" +
            "                <td>￥10.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>无创心电</td>\n" +
            "                <td>￥20.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>无刺体液</td>\n" +
            "                <td>￥15.00</td>\n" +
            "            </tr>\n" +
            "            <!---->\n" +
            "            <tr>\n" +
            "                <td rowspan=\"9\" class=\"item_name\">医疗通道</td>\n" +
            "                <td>生化检查</td>\n" +
            "                <td>￥10.00</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "                <td>随诊服务</td>\n" +
            "                <td>￥100.00</td>\n" +
            "            </tr>\n" +
            "        </table>\n" +
            "\t<body>\n" +
            "\t</body>\n" +
            "</html>";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_html);

        textView =(TextView) findViewById(R.id.textview);
        web1 = (WebView) findViewById(R.id.webview1);
        web2 = (WebView) findViewById(R.id.webview2);
        WebSettings ws = web1.getSettings();
        ws.setJavaScriptEnabled(true); //这里如果本地html引入了javascript那么需要把这个设置为true
        ws.setDefaultTextEncodingName("utf-8"); //设置文本编码
        ws.setAppCacheEnabled(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);//设置缓存模式

        web1.loadUrl("file:///android_asset/hospitalprice.html");


        ws = web2.getSettings();
        ws.setJavaScriptEnabled(true); //这里如果本地html引入了javascript那么需要把这个设置为true
        ws.setDefaultTextEncodingName("utf-8"); //设置文本编码
        ws.setAppCacheEnabled(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);//设置缓存模式
        web2.loadDataWithBaseURL("", htmlcontent, "text/html", "utf-8", null);
    }
}
