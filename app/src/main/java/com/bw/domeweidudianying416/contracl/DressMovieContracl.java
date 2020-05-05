package com.bw.domeweidudianying416.contracl;

import com.bw.domeweidudianying416.base.BaseModel;
import com.bw.domeweidudianying416.base.BaseView;

/**
 * 时间：2020/4/25
 * 作者：徐黎明
 * 类的作用：
 */
public interface DressMovieContracl {
    interface Model extends BaseModel {
        void gettui(int userId,String sessionId,int page,int count,ModelCallBack modelCallBack);
        void getfu(int userId,String sessionId,String longitude,String latitude, int page,int count,ModelCallBack modelCallBack);
    }
    interface ModelCallBack {
        void sucess(Object object);
        void fshibai(Throwable throwable);
    }
    interface View extends BaseView {
        void sucess(Object object);
        void fshibai(Throwable throwable);
    }
    interface Presenter {
        void gettui(int userId,String sessionId,int page,int count);
        void getfu(int userId,String sessionId,String longitude,String latitude, int page,int count);
    }
}
