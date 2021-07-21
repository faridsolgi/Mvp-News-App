package com.glorysys.mvpnewsapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.glorysys.mvpnewsapp.R;
import com.glorysys.mvpnewsapp.model.ObjNews;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<ObjNews> objNewsList;

    public NewsAdapter(Context context, List<ObjNews> objNewsList) {
        this.context = context;
        this.objNewsList = objNewsList;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.recyclearview_news_model,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  NewsAdapter.ViewHolder holder, int position) {
        holder.onBind(objNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return objNewsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
        }
        void  onBind(ObjNews objNews){
            textView=itemView.findViewById(R.id.textview_newsModel_newsArticle);
            textView.setText(objNews.getNewsSource()+"\n"
                    +objNews.getNewsAuthor()+"\n"+
                    objNews.getNewsTitle()+"\n"+
                    objNews.getNewsDescription());



        }


    }
}
