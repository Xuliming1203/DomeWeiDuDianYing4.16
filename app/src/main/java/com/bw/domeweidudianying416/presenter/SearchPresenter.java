package com.bw.domeweidudianying416.presenter;

import com.bw.domeweidudianying416.base.BasePresenter;
import com.bw.domeweidudianying416.contracl.SearchContracl;
import com.bw.domeweidudianying416.model.SearchModel;

/**
 * 时间：2020/5/5
 * 作者：徐黎明
 * 类的作用：
 */
public class SearchPresenter extends BasePresenter<SearchModel, SearchContracl.View> implements SearchContracl.Presenter {
    @Override
    protected SearchModel initModel() {
        return new SearchModel();
    }

    @Override
    public void moviesearch(String keyword, int page, int count) {
      initModel().moviesearch(keyword, page, count, new SearchContracl.ModelCallBack() {
          @Override
          public void success(Object object) {
              if (getView() != null) {
                  getView().success(object);
              }
          }

          @Override
          public void fshibai(Throwable throwable) {
              if (getView() != null) {
                  getView().fshibai(throwable);
              }
          }
      });
    }

    @Override
    public void cinemasearch(int page, int count, String cinemaName) {
        initModel().cinemasearch(page, count, cinemaName, new SearchContracl.ModelCallBack() {
            @Override
            public void success(Object object) {
                if (getView() != null) {
                    getView().success(object);
                }
            }

            @Override
            public void fshibai(Throwable throwable) {
                if (getView() != null) {
                    getView().fshibai(throwable);
                }
            }
        });
    }
}
