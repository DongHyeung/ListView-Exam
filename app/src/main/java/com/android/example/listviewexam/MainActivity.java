
package com.android.example.listviewexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<People> mData;
    private CustomAdapter mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 데이터 준비
        initData();

        // 2.Adapter 준비
        initAdapter();

        // 3.ListView 에 Adapter 준비
        initListView();

    }

    private void initListView() {
        mListView = (ListView) findViewById(R.id.List_view);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Item 이 클릭되었을 때 동작 하는 부분
                Toast.makeText(MainActivity.this, "position : " + position, Toast.LENGTH_SHORT)
                        .show();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
                        + mData.get(position).getPhoneNumber()));

                startActivity(intent);
            }
        });
    }

    public void initAdapter() {
        mAdapter = new CustomAdapter(getApplicationContext(), mData);
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new People(R.drawable.elsa, "엘사", "01090912781"));
        mData.add(new People(R.drawable.elsa, "엘사2", "00113121313"));
        for (int i = 1; i <= 100; i++) {
            mData.add(new People(R.mipmap.ic_launcher, "아무개" + 1, "번호없음"));
        }
    }
}
