## Download Image

### 下载图片
* 1. 在主布局（activity_main.xml）中增加 ImageView 控件。
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent">

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/imageView"
        android:layout_gravity="center_horizontal" />
</LinearLayout>
```

* 2. 在 MainActivity 类中编写代码。
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    new DownloadImageTask().execute(makeURLStringWithGitHub("1"));
}

private String makeURLStringWithGitHub(String filename) {
    String gitHubURLFormat = "https://raw.githubusercontent.com/vwarship/Samples/master/Android/DownloadImage/images/%s.jpg";
    return String.format(gitHubURLFormat, filename);
}

private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... params) {
        String url = params[0];
        return downloadImage(url);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);
    }
}

private Bitmap downloadImage(String urlString) {
    InputStream inputStream = null;
    try {
        inputStream = openHttpConnection(urlString);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return  BitmapFactory.decodeStream(inputStream);
}

private InputStream openHttpConnection(String urlString) throws IOException {
    InputStream inputStream = null;

    URL url = new URL(urlString);
    URLConnection urlConnection = url.openConnection();

    HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
    httpURLConnection.setAllowUserInteraction(false);
    httpURLConnection.setInstanceFollowRedirects(true);
    httpURLConnection.setRequestMethod("GET");

    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        inputStream = httpURLConnection.getInputStream();
    }

    return inputStream;
}
```
Android 3.0 以后不能在主线程下载，需要通过 AsyncTask 在后台下载。

* 3. 在 AndroidManifest.xml 中增加 Internet 权限。
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

![](snapshots/download_image.png)

### 下载多张图片（幻灯片播放）
* 改写 MainActivity 类中的 DownloadImagesTask
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    new DownloadImagesTask().execute(
            makeURLStringWithGitHub("1"),
            makeURLStringWithGitHub("2"),
            makeURLStringWithGitHub("3"),
            makeURLStringWithGitHub("4"),
            makeURLStringWithGitHub("5"),
            makeURLStringWithGitHub("6"),
            makeURLStringWithGitHub("7"));
}

private class DownloadImagesTask extends AsyncTask<String, Bitmap, Void> {

    @Override
    protected Void doInBackground(String... params) {
        final int length = params.length;

        for (String urlString : params) {
            Bitmap bitmap = downloadImage(urlString);
            publishProgress(bitmap);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Bitmap... values) {
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
    }
}
```

![](snapshots/download_images.png)
