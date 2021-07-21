package com.glorysys.mvpnewsapp.contract;

import com.glorysys.mvpnewsapp.model.ObjNews;

import java.util.List;

public interface NewsContract {
interface IgetNewsFromServer{
    void onGetNewsSuccess(List<ObjNews> lists);
    void onGetNewsError();
}

    interface InewsPresenter{
            void onGetNewsPresenter();
    }

    interface InewsView{
        void onShowNewsSuccess(List<ObjNews> objNews);
        void onShowNewsError(String error);
    }

}
