package com.bw.domeweidudianying416.contracl;

import com.bw.domeweidudianying416.base.BaseModel;
import com.bw.domeweidudianying416.base.BaseView;

/**
 * 时间：2020/5/5
 * 作者：徐黎明
 * 类的作用：
 */
public interface SearchContracl {
    interface Model extends BaseModel{
        void moviesearch(String keyword,int page,int count,ModelCallBack modelCallBack);
        void cinemasearch(int page,int count,String cinemaName,ModelCallBack modelCallBack);
    }
    interface ModelCallBack{
        void  success(Object object);
        void fshibai(Throwable throwable);
    }
    interface View extends BaseView{
        void  success(Object object);
        void fshibai(Throwable throwable);
    }
    interface Presenter{
        void moviesearch(String keyword,int page,int count);
        void cinemasearch(int page,int count,String cinemaName);
    }
}
