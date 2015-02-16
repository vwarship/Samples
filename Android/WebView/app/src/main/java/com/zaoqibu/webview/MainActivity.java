package com.zaoqibu.webview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
//        loadUrlWithWebPage(webView);
//        loadUrlWithRedirectWebPage(webView);
//        loadDataWithDynamicHtml(webView);
//        loadUrlWithWebPageInAssets(webView);
        loadUrlWithJavaScriptInAssets(webView);

        // 支持缩放
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
    }

    private void loadUrlWithWebPage(WebView webView) {
        final String url = "http://politics.people.com.cn/n/2015/0216/c1001-26575574.html";
        webView.loadUrl(url);
    }

    private void loadUrlWithRedirectWebPage(WebView webView) {
        final String url = "http://www.people.com.cn";
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }

    private void loadDataWithDynamicHtml(WebView webView) {
        webView.loadData("<h1>Hello World!</h1>", "text/html", "utf-8");
    }

    private void loadUrlWithWebPageInAssets(WebView webView) {
        webView.loadUrl("file:///android_asset/index.html");
    }

    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }
    private void loadUrlWithJavaScriptInAssets(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        webView.loadUrl("file:///android_asset/javascript.html");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
