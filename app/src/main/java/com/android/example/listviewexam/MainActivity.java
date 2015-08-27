
package com.android.example.listviewexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> mData;
    private ArrayAdapter<String> mAdapter;
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

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            mData.add("Item" + 1);
        }
    }

    private void initAdapter() {
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mData);
    }

    private void initListView() {
        mListView = (ListView) findViewById(R.id.List_view);
        mListView.setAdapter(mAdapter);
    }
}
