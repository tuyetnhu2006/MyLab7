package com.example.mylab7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ImageView imgCover;
    TextView tTitle;
    TextView tContent;
    TextView tView;
    Button btBack;
    ArrayList<Article> articleList;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        imgCover = findViewById(R.id.imgCover);
        tTitle = findViewById(R.id.tTitle);
        tContent = findViewById(R.id.tContent);
        tView = findViewById(R.id.tView);
        btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();

        articleList =
                (ArrayList<Article>)
                        intent.getSerializableExtra(
                                "EXTRA_ARTICLE_LIST"
                        );

        position =
                intent.getIntExtra(
                        "EXTRA_POSITION",
                        0
                );

        Article article =
                articleList.get(position);

        imgCover.setImageResource(
                article.getImg_cover()
        );

        tTitle.setText(
                article.getTitle()
        );

        tContent.setText(
                article.getContent()
        );

        tView.setText(
                "View: " + article.getView()
        );
    }

    @Override
    public void finish() {

        Intent intent = new Intent();

        intent.putExtra(
                "EXTRA_ARTICLE_LIST",
                articleList
        );

        setResult(
                RESULT_OK,
                intent
        );

        super.finish();
    }
}