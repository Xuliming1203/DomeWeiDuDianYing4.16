package com.bw.domeweidudianying416.presenter;

import com.bw.domeweidudianying416.base.BasePresenter;
import com.bw.domeweidudianying416.contracl.DressMovieContracl;
import com.bw.domeweidudianying416.model.DressMovieModel;

/**
 * 时间：2020/4/25
 * 作者：徐黎明
 * 类的作用：
 */
public class DressMoviePresenter extends BasePresenter<DressMovieModel, DressMovieContracl.View> implements DressMovieContracl.Presenter {
    @Override
    protected DressMovieModel initModel() {
        return new DressMovieModel();
    }

    @Override
    public void gettui(int userId, String sessionId, int page, int count) {
        initModel().gettui(userId, sessionId, page, count, new DressMovieContracl.ModelCallBack() {
            @Override
            public void sucess(Object object) {
                if (getView() != null) {
                    getView().sucess(object);
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
    public void getfu(int userId, String sessionId, String longitude, String latitude, int page, int count) {
            initModel().getfu(userId, sessionId, longitude, latitude, page, count, new DressMovieContracl.ModelCallBack() {
                @Override
                public void sucess(Object object) {
                    if (getView() != null) {
                        getView().sucess(object);
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
