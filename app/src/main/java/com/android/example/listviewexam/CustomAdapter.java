
package com.android.example.listviewexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Choi on 2015-08-31.
 */
public class CustomAdapter extends BaseAdapter {

    private List<People> mData;
    private Context mContext;

    public CustomAdapter(Context context, List<People> data) {
        mContext = context;
        mData = data;
    }

    // 아이템의 갯수
    @Override
    public int getCount() {
        return mData.size();
    }

    // 해당 포지션에 위치하는 아이템
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    // 해당 포지션에 위치하는 아이템의 ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 각 아이템의 레이아웃을 결정
     * 
     * @param position 포지션
     * @param convertView 포지션의 View
     * @param parent 부모
     * @return 완성 된 레이아웃
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        // 1. 레이아웃 구성

        // convertView 처음 로딩 될 때 초기화 과정을 거쳐서 viewHolder에 저장
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_people, parent,
                    false);

            // 각 View를 소스로 연결
            ImageView image = (ImageView) convertView.findViewById(R.id.elsa_image_view);
            TextView name = (TextView) convertView.findViewById(R.id.elsa_text_view);
            TextView phoneNumber = (TextView) convertView.findViewById(R.id.test_text_view);

            // ViewHolder 를 생성 후, 가져온 View를 연결
            viewHolder = new ViewHolder();
            viewHolder.image = image;
            viewHolder.name = name;
            viewHolder.phone = phoneNumber;

            // ViewHolder 를 convertView 의 태그로 저장
            convertView.setTag(viewHolder);

        } else {
            // convertView 가 다시 로딩 될 때에는 viewHolder에서 꺼내와서 재사용
            // 이점 : 속도가 빠르다
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 2. 레이아웃에 데이터를 바인딩
        People people = (People) getItem(position);
        viewHolder.image.setImageResource(people.getImageResourceId());
        viewHolder.name.setText(people.getName());
        viewHolder.phone.setText(people.getPhoneNumber());

        // 3. 완성된 View를 리턴
        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
    }
}
