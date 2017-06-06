package plazmid.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by soroush on 6/5/2017 AD.
 */

public class NewsAdapterByModel extends BaseAdapter {


    Context mContext;
    List<NewsModel> newsModels;

    public NewsAdapterByModel() {
    }

    public NewsAdapterByModel(Context mContext, List<NewsModel> newsModels) {
        this.mContext = mContext;
        this.newsModels = newsModels;
    }

    @Override
    public int getCount() {
        return newsModels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = LayoutInflater.from(mContext).inflate(R.layout.item_model_view, parent, false);

        TextView item_title = (TextView) rowView.findViewById(R.id.itm_title);
        TextView item_content = (TextView) rowView.findViewById(R.id.itm_content);


        item_content.setText(newsModels.get(position).getContent());
        item_title.setText(newsModels.get(position).getTitle());

        return rowView;
    }
}
