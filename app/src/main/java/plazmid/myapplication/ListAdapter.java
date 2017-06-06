package plazmid.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by soroush on 6/5/2017 AD.
 */

public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private StringBuffer[] Content;
    private Integer iCons[];


    public ListAdapter(Context mContext, StringBuffer[] content, Integer[] iCons) {
        this.mContext = mContext;
        Content = content;
        this.iCons = iCons;
    }

    @Override
    public int getCount() {
        return Content.length;
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
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.item_list_view, parent, false);

        ImageView itm_img = (ImageView) rowView.findViewById(R.id.item_icon);
        TextView itm_txt = (TextView) rowView.findViewById(R.id.item_txt);

        itm_txt.setText(Content[position]);
        itm_img.setImageResource(iCons[position]);


        return rowView;

    }
}
