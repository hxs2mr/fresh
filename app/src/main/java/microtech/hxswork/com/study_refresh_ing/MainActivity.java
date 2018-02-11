package microtech.hxswork.com.study_refresh_ing;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yalantis.phoenix.PullToRefreshView;
import com.yalantis.phoenix.refresh_view.SunRefreshView;

public class MainActivity extends AppCompatActivity implements PullToRefreshView.OnRefreshListener {
    RecyclerView recyclerView=null;
    PullToRefreshView pullToRefreshView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refresh);
        recyclerView = findViewById(R.id.recycleview);
        pullToRefreshView = findViewById(R.id.pull_to_refresh);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        pullToRefreshView.setBackgroundColor(Color.parseColor("#ff99cc"));

        pullToRefreshView.setRefreshing(true);//第一次进来刷新
        pullToRefreshView.setOnRefreshListener(this);
        refresh();
    }

    private void refresh()
    {
        pullToRefreshView.postDelayed(

                new Runnable() {
            @Override
            public void run() {
                pullToRefreshView.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        pullToRefreshView.setRefreshing(true);
        pullToRefreshView.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshView.setRefreshing(false);
            }
        }, 2000);
    }
}
