package com.example.album;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {
    private int[] photos = {R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4, R.drawable.photo_5,
            R.drawable.photo_6, R.drawable.photo_7, R.drawable.photo_8,
            R.drawable.photo_9, R.drawable.photo_10, R.drawable.photo_11,
            R.drawable.photo_12, R.drawable.photo_13};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        RecyclerView rv_list = findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        AlbumAdapter adapter = new AlbumAdapter(MainActivity.this, photos);
        rv_list.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(5);
        rv_list.addItemDecoration(decoration);
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;
        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }
}