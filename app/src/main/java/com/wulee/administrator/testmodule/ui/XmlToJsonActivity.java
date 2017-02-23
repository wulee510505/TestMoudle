package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wulee.administrator.testmodule.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 * Created by wulee on 2016/9/14 13:38
 */

public class XmlToJsonActivity extends Activity {

    private String xmlStr = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
            "<rowset>\n" +
            "  <row>\n" +
            "    <HK3000>HK3002</HK3000>\n" +
            "    <HK3100>1</HK3100>\n" +
            "    <PP0000>万燕萍</PP0000>\n" +
            "    <PK0010>2</PK0010>\n" +
            "    <PK0160>2001-05-27</PK0160>\n" +
            "    <PK0000>330182200801180000</PK0000>\n" +
            "    <DK0000>CHN</DK0000>\n" +
            "    <DK0010>NULL</DK0010>\n" +
            "    <DK0011>NULL</DK0011>\n" +
            "    <DK0100>NULL</DK0100>\n" +
            "    <DK0101>NULL</DK0101>\n" +
            "    <PK0040>1</PK0040>\n" +
            "    <PK0050>1</PK0050>\n" +
            "    <PK0060>NULL</PK0060>\n" +
            "    <PK0170>NULL</PK0170>\n" +
            "    <PK0070>NULL</PK0070>\n" +
            "    <PK0080>NULL</PK0080>\n" +
            "    <PP0120>NULL</PP0120>\n" +
            "    <PP0130>NULL</PP0130>\n" +
            "    <PP0140>NULL</PP0140>\n" +
            "    <PP0150>13588368696</PP0150>\n" +
            "    <PP0180>NULL</PP0180>\n" +
            "    <BK0000>30395862</BK0000>\n" +
            "    <BK0010>330182D156000005001D9DEADF188001</BK0010>\n" +
            "    <BK0020>2</BK0020>\n" +
            "    <BK0030>92</BK0030>\n" +
            "  </row>\n" +
            "</rowset>";

    private TextView tvJson;
    private TextView tvJsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_to_json);
        tvJson = (TextView) findViewById(R.id.tv_json);
        tvJsonObject = (TextView) findViewById(R.id.tv_object_string);

        String strJson = xml2JSON(xmlStr);
        tvJson.setText(strJson);

        XMLObject obj = new Gson().fromJson(strJson, XMLObject.class);
        tvJsonObject.setText(obj.toString());
    }

    public String xml2JSON(String xml) {
        try {
            JSONObject obj = XML.toJSONObject(xml);
            return obj.toString();
        } catch (JSONException e) {
            System.err.println("xml->json失败" + e.getLocalizedMessage());
            return "";
        }
    }

    class XMLObject{

        /**
         * row : {"HK3000":"HK3002","HK3100":1,"PP0000":"万燕萍","PK0010":2,"PK0160":"2001-05-27","PK0000":330182200801180000,"DK0000":"CHN","DK0010":null,"DK0011":null,"DK0100":null,"DK0101":null,"PK0040":1,"PK0050":1,"PK0060":null,"PK0170":null,"PK0070":null,"PK0080":null,"PP0120":null,"PP0130":null,"PP0140":null,"PP0150":13588368696,"PP0180":null,"BK0000":30395862,"BK0010":"330182D156000005001D9DEADF188001","BK0020":2,"BK0030":92}
         */

        private RowsetEntity rowset;

        public RowsetEntity getRowset() {
            return rowset;
        }

        public void setRowset(RowsetEntity rowset) {
            this.rowset = rowset;
        }

        public  class RowsetEntity {
            /**
             * HK3000 : HK3002
             * HK3100 : 1
             * PP0000 : 万燕萍
             * PK0010 : 2
             * PK0160 : 2001-05-27
             * PK0000 : 330182200801180000
             * DK0000 : CHN
             * DK0010 : null
             * DK0011 : null
             * DK0100 : null
             * DK0101 : null
             * PK0040 : 1
             * PK0050 : 1
             * PK0060 : null
             * PK0170 : null
             * PK0070 : null
             * PK0080 : null
             * PP0120 : null
             * PP0130 : null
             * PP0140 : null
             * PP0150 : 13588368696
             * PP0180 : null
             * BK0000 : 30395862
             * BK0010 : 330182D156000005001D9DEADF188001
             * BK0020 : 2
             * BK0030 : 92
             */

            private RowEntity row;

            public RowEntity getRow() {
                return row;
            }

            public void setRow(RowEntity row) {
                this.row = row;
            }

            public class RowEntity {
                private String HK3000;
                private int HK3100;
                private String PP0000;
                private int PK0010;
                private String PK0160;
                private long PK0000;
                private String DK0000;
                private Object DK0010;
                private Object DK0011;
                private Object DK0100;
                private Object DK0101;
                private int PK0040;
                private int PK0050;
                private Object PK0060;
                private Object PK0170;
                private Object PK0070;
                private Object PK0080;
                private Object PP0120;
                private Object PP0130;
                private Object PP0140;
                private long PP0150;
                private Object PP0180;
                private int BK0000;
                private String BK0010;
                private int BK0020;
                private int BK0030;

                public String getHK3000() {
                    return HK3000;
                }

                public void setHK3000(String HK3000) {
                    this.HK3000 = HK3000;
                }

                public int getHK3100() {
                    return HK3100;
                }

                public void setHK3100(int HK3100) {
                    this.HK3100 = HK3100;
                }

                public String getPP0000() {
                    return PP0000;
                }

                public void setPP0000(String PP0000) {
                    this.PP0000 = PP0000;
                }

                public int getPK0010() {
                    return PK0010;
                }

                public void setPK0010(int PK0010) {
                    this.PK0010 = PK0010;
                }

                public String getPK0160() {
                    return PK0160;
                }

                public void setPK0160(String PK0160) {
                    this.PK0160 = PK0160;
                }

                public long getPK0000() {
                    return PK0000;
                }

                public void setPK0000(long PK0000) {
                    this.PK0000 = PK0000;
                }

                public String getDK0000() {
                    return DK0000;
                }

                public void setDK0000(String DK0000) {
                    this.DK0000 = DK0000;
                }

                public Object getDK0010() {
                    return DK0010;
                }

                public void setDK0010(Object DK0010) {
                    this.DK0010 = DK0010;
                }

                public Object getDK0011() {
                    return DK0011;
                }

                public void setDK0011(Object DK0011) {
                    this.DK0011 = DK0011;
                }

                public Object getDK0100() {
                    return DK0100;
                }

                public void setDK0100(Object DK0100) {
                    this.DK0100 = DK0100;
                }

                public Object getDK0101() {
                    return DK0101;
                }

                public void setDK0101(Object DK0101) {
                    this.DK0101 = DK0101;
                }

                public int getPK0040() {
                    return PK0040;
                }

                public void setPK0040(int PK0040) {
                    this.PK0040 = PK0040;
                }

                public int getPK0050() {
                    return PK0050;
                }

                public void setPK0050(int PK0050) {
                    this.PK0050 = PK0050;
                }

                public Object getPK0060() {
                    return PK0060;
                }

                public void setPK0060(Object PK0060) {
                    this.PK0060 = PK0060;
                }

                public Object getPK0170() {
                    return PK0170;
                }

                public void setPK0170(Object PK0170) {
                    this.PK0170 = PK0170;
                }

                public Object getPK0070() {
                    return PK0070;
                }

                public void setPK0070(Object PK0070) {
                    this.PK0070 = PK0070;
                }

                public Object getPK0080() {
                    return PK0080;
                }

                public void setPK0080(Object PK0080) {
                    this.PK0080 = PK0080;
                }

                public Object getPP0120() {
                    return PP0120;
                }

                public void setPP0120(Object PP0120) {
                    this.PP0120 = PP0120;
                }

                public Object getPP0130() {
                    return PP0130;
                }

                public void setPP0130(Object PP0130) {
                    this.PP0130 = PP0130;
                }

                public Object getPP0140() {
                    return PP0140;
                }

                public void setPP0140(Object PP0140) {
                    this.PP0140 = PP0140;
                }

                public long getPP0150() {
                    return PP0150;
                }

                public void setPP0150(long PP0150) {
                    this.PP0150 = PP0150;
                }

                public Object getPP0180() {
                    return PP0180;
                }

                public void setPP0180(Object PP0180) {
                    this.PP0180 = PP0180;
                }

                public int getBK0000() {
                    return BK0000;
                }

                public void setBK0000(int BK0000) {
                    this.BK0000 = BK0000;
                }

                public String getBK0010() {
                    return BK0010;
                }

                public void setBK0010(String BK0010) {
                    this.BK0010 = BK0010;
                }

                public int getBK0020() {
                    return BK0020;
                }

                public void setBK0020(int BK0020) {
                    this.BK0020 = BK0020;
                }

                public int getBK0030() {
                    return BK0030;
                }

                public void setBK0030(int BK0030) {
                    this.BK0030 = BK0030;
                }
            }
        }
    }

}
