## WebView

### 使用
* 1. 在主布局（activity_main.xml）中增加 WebView 控件。
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <WebView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/webView"/>
</RelativeLayout>
```

* 2. 在 MainActivity 类的 onCreate 函数中加载网页。
```java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String url = "http://politics.people.com.cn/n/2015/0216/c1001-26575574.html";

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl(url);
    }
```

* 3. 在 AndroidManifest.xml 中增加访问互联网的权限。
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

### 支持访问网页来源的方式
* 1. 直接加载互联网上的网页。
```java
final String url = "http://politics.people.com.cn/n/2015/0216/c1001-26575574.html";

WebView webView = (WebView)findViewById(R.id.webView);
webView.loadUrl(url);
```
![](snapshots/load_url_web_page.png)

* 2. 加载 assets 目录下的网页。
```java
WebView webView = (WebView)findViewById(R.id.webView);
webView.loadUrl("file:///android_asset/index.html");
```
![](snapshots/load_url_with_asserts.png)

* 3. 加载动态生成的html。
```java
WebView webView = (WebView)findViewById(R.id.webView);
webView.loadData("<h1>Hello World!</h1>", "text/html", "utf-8");
```
![](snapshots/load_data_dynamic.png)

### 支持缩放
```java
WebSettings webSettings = webView.getSettings();
webSettings.setBuiltInZoomControls(true);
```

### 支持重定向。（当加载一个会重定向的页面时，WebView会导致应用程序启动设备的浏览器应用程序来加载所需的页面。）
```java
webView.setWebViewClient(new WebViewClient() {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }
});
```
![](snapshots/load_url_support_redirect.png)

* 如果没增加支持重定向将出现下面的提示
![](snapshots/load_url_not_support_redirect.png)
