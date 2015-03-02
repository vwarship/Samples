package com.zaoqibu.xmlpullparser;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;


public class MainActivity extends ActionBarActivity {
    private TextView tvHello;
    private TextView tvRSS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = (TextView)findViewById(R.id.tvHello);
        parseHello();

        tvRSS = (TextView)findViewById(R.id.tvRSS);
        parseRSS();
    }

    private void parseHello() {
        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xmlPullParser = factory.newPullParser();

            xmlPullParser.setInput(new StringReader("<?xml version='1.0'?>" +
                    "<main><hello>Hello World!</hello></main>"));

            xmlPullParser.next();
            xmlPullParser.require(XmlPullParser.START_TAG, null, "main");
            xmlPullParser.next();
            xmlPullParser.require(XmlPullParser.START_TAG, null, "hello");

            tvHello.setText(xmlPullParser.nextText());

            xmlPullParser.require(XmlPullParser.END_TAG, null, "hello");
            xmlPullParser.next();
            xmlPullParser.require(XmlPullParser.END_TAG, null, "main");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseRSS() {
        StringBuilder sb = new StringBuilder();

        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xmlPullParser = factory.newPullParser();

            xmlPullParser.setInput(getResources().openRawResource(R.raw.tech_qq_rss_11), "gb2312");

            int eventType = xmlPullParser.getEventType();
            while (eventType != xmlPullParser.END_DOCUMENT) {
                if (eventType == xmlPullParser.START_TAG && xmlPullParser.getName().equals("title")) {
                    sb.append("title: ").append(xmlPullParser.nextText()).append("\n\n");
                } else if (eventType == xmlPullParser.START_TAG && xmlPullParser.getName().equals("item")) {
                    while (!(eventType == xmlPullParser.END_TAG && xmlPullParser.getName().equals("item"))) {
                        if (eventType == xmlPullParser.START_TAG) {
                            if (xmlPullParser.getName().equals("title")) {
                                sb.append("title: ").append(xmlPullParser.nextText()).append('\n');
                            } if (xmlPullParser.getName().equals("link")) {
                                sb.append("link: ").append(xmlPullParser.nextText()).append('\n');
                            } if (xmlPullParser.getName().equals("pubDate")) {
                                sb.append("pubDate: ").append(xmlPullParser.nextText()).append('\n');
                            } if (xmlPullParser.getName().equals("description")) {
                                sb.append("description: ").append(xmlPullParser.nextText()).append('\n');
                            }
                        }

                        eventType = xmlPullParser.next();
                    }

                    sb.append('\n');
                }
                else if (eventType == xmlPullParser.START_TAG && xmlPullParser.getName().equals("image")) {
                    while (!(eventType == xmlPullParser.END_TAG && xmlPullParser.getName().equals("image"))) {
                        eventType = xmlPullParser.next();
                    }
                }

                eventType = xmlPullParser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvRSS.setText(sb.toString());
    }

}
