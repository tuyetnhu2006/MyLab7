package com.example.mylab7;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private MyAdapter madapter;
    public TextView tTitle;
    public TextView tContent;
    public TextView tView;
    public ImageView imgCover;
    public ArticleViewHolder(View item, MyAdapter adapter){
        super(item);
        this.madapter = adapter;
        tTitle = item.findViewById(R.id.tTitle);
        tContent = item.findViewById(R.id.tContent);
        tView = item.findViewById(R.id.tView);
        imgCover = item.findViewById(R.id.imgCover);
        item.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();

        if (position == RecyclerView.NO_POSITION) {
            return;
        }

        Article article =
                madapter.getArticle(position);

        // Tăng view lên 1
        article.setView(
                article.getView() + 1
        );

        Intent intent =
                new Intent(
                        v.getContext(),
                        DetailActivity.class
                );

        intent.putExtra(
                "EXTRA_ARTICLE_LIST",
                madapter.getArticleList()
        );

        intent.putExtra(
                "EXTRA_POSITION",
                position
        );

        ((MainActivity) v.getContext())
                .startActivityForResult(
                        intent,
                        100
                );
    }
}
