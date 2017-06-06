package plazmid.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ListViewByModel extends AppCompatActivity {

    private ListView listView;
    private Button show_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_by_model);

        show_btn = (Button) findViewById(R.id.show_btn);

        listView = (ListView) findViewById(R.id.my_list);
        final String url = "http://172.26.92.55/wordpress/api/get_recent_posts/";


        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetValueByAssync(url);

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

            JSONObject all_obj = new JSONObject(String.valueOf(response));
            JSONArray posts_arry = all_obj.getJSONArray("posts");
            final StringBuffer finalBufferedData = new StringBuffer();
            StringBuffer finalbufferdata2 = new StringBuffer();
            String content_str = null;
            String title_str = null;
            List<NewsModel> newsModels = new ArrayList<>();
            NewsAdapterByModel newsAdapterByModel = new NewsAdapterByModel(ListViewByModel.this, newsModels);
            NewsModel JSON_News = null;
            for (int i = 0; i < posts_arry.length(); i++) {
                JSONObject jsonobject = posts_arry.getJSONObject(i);

                content_str = jsonobject.getString("content");
                title_str = jsonobject.getString("title");

                JSON_News = new NewsModel();
                JSON_News.setContent(content_str);
                JSON_News.setTitle(title_str);
                newsModels.add(JSON_News);
                listView.setAdapter(newsAdapterByModel);

            }




            return finalBufferedData.toString();


        } catch (Exception e) {

            Toast.makeText(this, "Error" + e, Toast.LENGTH_SHORT).show();


        }


        return null;
    }

}
