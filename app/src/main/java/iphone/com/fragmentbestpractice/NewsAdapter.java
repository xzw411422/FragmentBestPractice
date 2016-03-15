package iphone.com.fragmentbestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xzw12 on  0015.
 */
public class NewsAdapter extends ArrayAdapter<News>{
    private int resourceId;
    public NewsAdapter(Context context,int textViewResourceId,List<News> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    public View getView(int position,View convertView,ViewGroup parent){
        News news = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        }else{
            view = convertView;
        }
        TextView newsTitleView = (TextView) view.findViewById(R.id.news_title);
        newsTitleView.setText(news.getTitle());
        return view;
    }
}
