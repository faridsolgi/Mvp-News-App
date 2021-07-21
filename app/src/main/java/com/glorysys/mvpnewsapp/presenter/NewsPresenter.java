package com.glorysys.mvpnewsapp.presenter;

import android.content.Context;

import com.glorysys.mvpnewsapp.contract.NewsContract;
import com.glorysys.mvpnewsapp.model.ObjNews;
import com.glorysys.mvpnewsapp.model.WebServerRequest;

import java.util.ArrayList;
import java.util.List;

public class NewsPresenter implements NewsContract.InewsPresenter {
    private Context context;
    private NewsContract.InewsView inewsView;

    public NewsPresenter(Context context,NewsContract.InewsView inewsView) {
        this.context = context;
        this.inewsView = inewsView;
    }

    @Override
    public void onGetNewsPresenter() {

          WebServerRequest webServerRequest=new WebServerRequest(context);
webServerRequest.onWebServerRequest(new NewsContract.IgetNewsFromServer() {
    @Override
    public void onGetNewsSuccess(List<ObjNews> lists) {
        inewsView.onShowNewsSuccess(lists);

    }

    @Override
    public void onGetNewsError() {
        inewsView.onShowNewsError("error");
    }
});








    }


}
