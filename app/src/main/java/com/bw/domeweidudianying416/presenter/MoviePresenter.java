package com.bw.domeweidudianying416.presenter;

import com.bw.domeweidudianying416.base.BasePresenter;
import com.bw.domeweidudianying416.contracl.MovieContracl;
import com.bw.domeweidudianying416.model.MovieModel;

/**
 * 时间：2020/4/19
 * 作者：徐黎明
 * 类的作用：
 */
public class MoviePresenter extends BasePresenter<MovieModel, MovieContracl.View> implements MovieContracl.Presenter {
    @Override
    protected MovieModel initModel() {
        return new MovieModel();
    }

    @Override
    public void getxbanner() {
        initModel().getxbanner(new MovieContracl.ModelCallBack() {
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
    public void getzzry(int page, int count) {
        initModel().getzzry(page, count, new MovieContracl.ModelCallBack() {
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
    public void getjjsy(int userId, String sessionId, int page, int count) {
        initModel().getjjsy(userId, sessionId, page, count, new MovieContracl.ModelCallBack() {
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
    public void getrmzy(int page, int count) {
        initModel().getrmzy(page, count, new MovieContracl.ModelCallBack() {
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
