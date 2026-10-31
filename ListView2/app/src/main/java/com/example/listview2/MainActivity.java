package com.example.listview2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView ListView;
    private String[] names={"手撕面包", "华夫饼", "小麻花", "每日坚果", "盐焗鸡蛋", "原味肉松饼"};
    private String[] prices={"¥32.90", "¥36.90", "¥18.80", "¥19.90", "¥30.70", "¥34.90"};
    private int[] pictures={R.drawable.tear_bread, R.drawable.waffle,
            R.drawable.dough_twist, R.drawable.daily_nuts,
            R.drawable.salt_baked_eggs, R.drawable.meat_floss};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView=findViewById(R.id.lv);
        MyBaseAdapter mAdapter=new MyBaseAdapter(this);
        ListView.setAdapter(mAdapter);
    }

    class MyBaseAdapter extends BaseAdapter {
        private Context Context;
        public MyBaseAdapter(Context context) {
            this.Context=context;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = LayoutInflater.from(Context).inflate(R.layout.list_item, null);
//            TextView tv_goods_name=convertView.findViewById(R.id.title);
//            TextView tv_price=convertView.findViewById(R.id.tv_price);
//            ImageView iv_img=convertView.findViewById(R.id.iv);
//
//            tv_goods_name.setText(names[position]);
//            tv_price.setText(prices[position]);
//            iv_img.setBackgroundResource(pictures[position]);
//            return convertView;
            ViewHolder holder=null;
            if(convertView==null){
                convertView=View.inflate(MainActivity.this,R.layout.list_item,null);
                holder=new ViewHolder();
                holder.title=convertView.findViewById(R.id.title);
                holder.tv_price=convertView.findViewById(R.id.tv_price);
                holder.iv=convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder) convertView.getTag();
            }
            holder.title.setText(names[position]);
            holder.tv_price.setText(prices[position]);
            holder.iv.setBackgroundResource(pictures[position]);
            return convertView;
        }
    }
    class ViewHolder{
        TextView title;
        TextView tv_price;
        ImageView iv;
    }
}