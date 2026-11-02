package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NonNls;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;

    private String[] names={"小猫", "哈士奇", "小黄鸭", "小鹿", "老虎"};
    private int[] imgs={R.drawable.cat, R.drawable.siberiankusky,
            R.drawable.yellowduck, R.drawable.fawn, R.drawable.tiger};
    private String[] introduces={
            "猫，属于猫科动物，分家猫、野猫，是全世界家庭中较受欢迎的宠物。",
            "西伯利亚雪橇犬，常见别名哈士奇，昵称为二哈。",
            "鸭的体型相对较小，颈短，有些鸭的嘴要大些。腿位于身体后方，因而步态蹒跚。",
            "鹿科是哺乳纲偶蹄目下的一科动物，体型大小不等，为有角的反刍类。",
            "虎，大型猫科动物；毛色浅黄或棕黄色；长有黑色横纹；头圆，耳短，耳背面黑色。中央有一白斑甚显著；四肢健壮有力；尾粗长，具黑色环纹，尾端黑色。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new HomeAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
        @NonNls
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(MainActivity.this).inflate(
                    R.layout.recycler_item,null);
            MyViewHolder holder=new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv_name.setText(names[position]);
            holder.iv_img.setImageResource(imgs[position]);
            holder.tv_introduce.setText(introduces[position]);
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv_name, tv_introduce;
            ImageView iv_img;
            public MyViewHolder(View view) {
                super(view);
                tv_name=view.findViewById(R.id.name);
                iv_img=view.findViewById(R.id.iv);
                tv_introduce=view.findViewById(R.id.introduce);
            }
        }
    }
}