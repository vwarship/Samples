## Download Text

* 1. 在主布局（activity_main.xml）中添加 TextView 控件。
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" 
    android:layout_width="match_parent"
    android:layout_height="match_parent" tools:context=".MainActivity">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/textView" />
    </ScrollView>

</RelativeLayout>
```

* 2. 在 MainActivity 类中编写下载文本文件的代码。
```java
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new downloadTextTask().execute(makeURLStringWithGitHub("text.txt"));
    }

    private String makeURLStringWithGitHub(String filename) {
        String gitHubURLFormat = "https://raw.githubusercontent.com/vwarship/Samples/master/Android/DownloadText/%s";
        return String.format(gitHubURLFormat, filename);
    }

    private class downloadTextTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return downloadText(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(s);
        }
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

    private String downloadText(String urlString) {
        StringBuilder sb = new StringBuilder();

        final int BUF_SIZE = 4096;
        char[] buf = new char[BUF_SIZE];
        int readedLen = 0;

        try {
            InputStream inputStream = openHttpConnection(urlString);
            InputStreamReader reader = new InputStreamReader(inputStream);

            while ((readedLen = reader.read(buf)) > 0) {
                sb.append(new String(buf, 0, readedLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
```

* 3. 在 AndroidManifest.xml 中增加 Internet 权限。
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

![](snapshots/download_text.png)
![国家信息安全专项及下一代互联网技术研发、产业化和规模商用专项项目清单](text.txt)