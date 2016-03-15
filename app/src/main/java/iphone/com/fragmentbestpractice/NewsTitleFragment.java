package iphone.com.fragmentbestpractice;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzw12 on  0015.
 */
public class NewsTitleFragment extends Fragment {
    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;

    public void onAttch(Activity activity){
        super.onAttach(activity);
        newsList = getNews();//初始化新闻数据
        adapter = new NewsAdapter(activity,R.layout.news_item,newsList);

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
    }
    public void onItemClick(AdapterView<?>parent,View view,int position,long id){
        News news = newsList.get(position);
        if(isTwoPane){
            //如果是双页模式，则刷新NewsContentFragment中的内容
            NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
                    .findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        }else{
            //如果是单页模式，则直接启动NewsContentActivity
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
        }
    }
    private List<News> getNews(){
        List<News> newsList1 = new ArrayList<News>();
        News news1 = new News();
        news1.setTitle("酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷酷");
        news1.setContent("靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠" +
                "靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠" +
                "靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠靠啦啦啦啦啦啦啦啦啦啦啦啦啦" +
                "咩咩咩咩咩咩咩咩咩咩咩咩咩咩咩密密麻麻");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("咩咩咩咩咩咩咩咩咩咩咩咩咩咩咩密密麻麻");
        news2.setContent("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈吼吼吼吼吼吼吼吼吼" +
                "跟鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼跟鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼鬼" +
                "hhhhhhhhhhhhhhddddd方法烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦" +
                "水水水水水水水水水水水水水水水水水水水");
        newsList.add(news2);
        return newsList;

    }
}
