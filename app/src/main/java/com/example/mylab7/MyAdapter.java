package com.example.mylab7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    LayoutInflater mInflater;
    private ArrayList<Article> articleList;
    public MyAdapter(Context context, ArrayList<Article> list){
        mInflater = LayoutInflater.from(context);
        this.articleList = list;
    }
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.article_layout, parent, false);
        ArticleViewHolder holder = new ArticleViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.tTitle.setText(article.getTitle());
        holder.tContent.setText(article.getContent());
        holder.tView.setText("View: " + article.getView());
        holder.imgCover.setImageResource(article.getImg_cover());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
    public Article getArticle(int position) {

        return articleList.get(position);
    }

    public ArrayList<Article> getArticleList() {

        return articleList;
    }
}
