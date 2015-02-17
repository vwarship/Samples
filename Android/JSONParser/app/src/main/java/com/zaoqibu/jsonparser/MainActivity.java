package com.zaoqibu.jsonparser;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ReadJSONTask().execute("http://m.weather.com.cn/data/101010100.html");
    }

    private class ReadJSONTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String jsonString = downloadText(params[0]);
            return jsonParse(jsonString);
        }

        @Override
        protected void onPostExecute(String s) {
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(s);
        }
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

    /*
     * {"weatherinfo":{"city":"北京","city_en":"beijing","date_y":"2014年3月4日","date":"","week":"星期二","fchh":"11","cityid":"101010100","temp1":"8℃~-3℃","temp2":"8℃~-3℃","temp3":"7℃~-3℃","temp4":"8℃~-1℃","temp5":"10℃~1℃","temp6":"10℃~2℃","tempF1":"46.4℉~26.6℉","tempF2":"46.4℉~26.6℉","tempF3":"44.6℉~26.6℉","tempF4":"46.4℉~30.2℉","tempF5":"50℉~33.8℉","tempF6":"50℉~35.6℉","weather1":"晴","weather2":"晴","weather3":"晴","weather4":"晴转多云","weather5":"多云","weather6":"多云","img1":"0","img2":"99","img3":"0","img4":"99","img5":"0","img6":"99","img7":"0","img8":"1","img9":"1","img10":"99","img11":"1","img12":"99","img_single":"0","img_title1":"晴","img_title2":"晴","img_title3":"晴","img_title4":"晴","img_title5":"晴","img_title6":"晴","img_title7":"晴","img_title8":"多云","img_title9":"多云","img_title10":"多云","img_title11":"多云","img_title12":"多云","img_title_single":"晴","wind1":"北风4-5级转微风","wind2":"微风","wind3":"微风","wind4":"微风","wind5":"微风","wind6":"微风","fx1":"北风","fx2":"微风","fl1":"4-5级转小于3级","fl2":"小于3级","fl3":"小于3级","fl4":"小于3级","fl5":"小于3级","fl6":"小于3级","index":"寒冷","index_d":"天气寒冷，建议着厚羽绒服、毛皮大衣加厚毛衣等隆冬服装。年老体弱者尤其要注意保暖防冻。","index48":"冷","index48_d":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。","index_uv":"中等","index48_uv":"中等","index_xc":"较适宜","index_tr":"一般","index_co":"较舒适","st1":"7","st2":"-3","st3":"8","st4":"0","st5":"7","st6":"-1","index_cl":"较不宜","index_ls":"基本适宜","index_ag":"易发"}}
     */
    private String jsonParse(String jsonString) {
        StringBuilder sb = new StringBuilder();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject obj = jsonObject.getJSONObject("weatherinfo");

            sb.append(obj.getString("city")).append("\n")
                    .append(obj.getString("date_y")).append("\n")
                    .append(obj.getString("week")).append("\n")
                    .append(obj.getString("temp1")).append("\n")
                    .append(obj.getString("weather1")).append("\n")
                    .append(obj.getString("index_d"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sb.toString();
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
