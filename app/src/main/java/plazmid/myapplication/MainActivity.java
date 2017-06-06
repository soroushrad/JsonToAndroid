package plazmid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private ListView my_list;
    private StringBuffer finalBufferedData = new StringBuffer();
    private StringBuffer finalbufferdata2 = new StringBuffer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://192.168.1.9/wordpress/api/get_recent_posts/";
        my_list = (ListView) findViewById(R.id.my_list);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StringBuffer[] name = {

                        finalBufferedData

                };


                Integer icon[] = {

                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher


                };

                ListAdapter listAdapter = new ListAdapter(MainActivity.this, name, icon);

                my_list.setAdapter(listAdapter);
            }
        });


    }


    private void GetValueByAssync(String url) {

        AsyncHttpClient contact_client = new AsyncHttpClient();
        contact_client.post(url, null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                getJSON(response);

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

    }


    private String getJSON(JSONObject response) {

        try {

            String content_str = null;
            String title_str = null;

            JSONObject all_obj = new JSONObject(String.valueOf(response));
            JSONArray posts_arry = all_obj.getJSONArray("posts");


            for (int i = 0; i < posts_arry.length(); i++) {
                JSONObject jsonobject = posts_arry.getJSONObject(i);

                content_str = jsonobject.getString("content");
                title_str = jsonobject.getString("title");
                Object image_int = jsonobject.get("thumbnail");


            }
            finalBufferedData.append(content_str);
            finalbufferdata2.append(title_str);


            return finalBufferedData.toString();


        } catch (Exception e) {

            Toast.makeText(this, "Error" + e, Toast.LENGTH_SHORT).show();


        }


        return null;
    }
}
