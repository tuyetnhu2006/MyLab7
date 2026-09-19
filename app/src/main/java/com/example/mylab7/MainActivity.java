package com.example.mylab7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btLoad;
    ArrayList<Article> articleList = new ArrayList<>();
    MyAdapter myAdapter;
    private static final int DETAIL_REQUEST = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Tạo dữ liệu bài viết ban đầu
        articleList.add(
                new Article(
                        "Công nghệ thông tin",
                        "Công nghệ thông tin là lĩnh vực nghiên cứu và ứng dụng máy tính, phần mềm và hệ thống thông tin.",
                        R.drawable.article1,
                        0
                )
        );

        articleList.add(
                new Article(
                        "Trí tuệ nhân tạo",
                        "Trí tuệ nhân tạo là một lĩnh vực của khoa học máy tính nhằm xây dựng các hệ thống có khả năng thực hiện những nhiệm vụ thông minh.",
                        R.drawable.article2,
                        0
                )
        );

        articleList.add(
                new Article(
                        "Lập trình Android",
                        "Android Studio là môi trường phát triển được sử dụng để xây dựng các ứng dụng Android.",
                        R.drawable.article3,
                        0
                )
        );

        articleList.add(
                new Article(
                        "RecyclerView",
                        "RecyclerView giúp hiển thị danh sách dữ liệu một cách hiệu quả và có thể tái sử dụng các View.",
                        R.drawable.article4,
                        0
                )
        );
        recyclerView = findViewById(R.id.recyclerView);
        btLoad = findViewById(R.id.btload);
        btLoad.setOnClickListener(v -> {
            MyAdapter myAdapter = new MyAdapter(MainActivity.this, articleList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(myAdapter);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DETAIL_REQUEST
                && resultCode == RESULT_OK
                && data != null) {

            ArrayList<Article> newList =
                    (ArrayList<Article>)
                            data.getSerializableExtra(
                                    "EXTRA_ARTICLE_LIST"
                            );
            if (newList != null) {

                articleList = newList;

                myAdapter = new MyAdapter(
                        MainActivity.this,
                        articleList
                );

                recyclerView.setAdapter(myAdapter);
            }
        }
    }
}