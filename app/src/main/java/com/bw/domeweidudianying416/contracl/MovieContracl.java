package com.bw.domeweidudianying416.contracl;

import com.bw.domeweidudianying416.base.BaseModel;
import com.bw.domeweidudianying416.base.BaseView;

/**
 * 时间：2020/4/19
 * 作者：徐黎明
 * 类的作用：
 */
public interface MovieContracl {
    interface Model extends BaseModel{
        void getxbanner(ModelCallBack modelCallBack);
        void getzzry(int page,int count,ModelCallBack modelCallBack);
        void getjjsy(int userId,String sessionId,int page,int count,ModelCallBack modelCallBack);
        void getrmzy(int page,int count,ModelCallBack modelCallBack);
    }
    interface ModelCallBack{
        void success(Object object);
        void fshibai(Throwable throwable);
    }
    interface View extends BaseView{
        void success(Object object);
        void fshibai(Throwable throwable);
    }
    interface Presenter{
        void getxbanner();
        void getzzry(int page,int count);
        void getjjsy(int userId,String sessionId,int page,int count);
        void getrmzy(int page,int count);
    }
}
