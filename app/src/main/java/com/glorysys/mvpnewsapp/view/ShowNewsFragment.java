package com.glorysys.mvpnewsapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.glorysys.mvpnewsapp.R;
import com.glorysys.mvpnewsapp.contract.NewsContract;
import com.glorysys.mvpnewsapp.model.ObjNews;
import com.glorysys.mvpnewsapp.presenter.NewsPresenter;

import java.util.List;


public class ShowNewsFragment extends Fragment implements NewsContract.InewsView {
    private TextView textViewNoData;
private NewsAdapter newsAdapter;
private RecyclerView recyclerView;
private NewsContract.InewsPresenter inewsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_show_news, container, false);
        ////
        defineVariables(view);
inewsPresenter=new NewsPresenter(getContext(),this);
inewsPresenter.onGetNewsPresenter();




        return view;
    }





    void defineVariables(View view){
        recyclerView=view.findViewById(R.id.rv_newsFragment_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        textViewNoData=view.findViewById(R.id.tv_newsFragment_noData);

    }

    @Override
    public void onShowNewsSuccess(List<ObjNews> objNews) {
        textViewNoData.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        newsAdapter=new NewsAdapter(getContext(),objNews);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void onShowNewsError(String error) {
        recyclerView.setVisibility(View.GONE);
        textViewNoData.setVisibility(View.VISIBLE);
    }
}