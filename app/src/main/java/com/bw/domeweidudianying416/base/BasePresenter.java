package com.bw.domeweidudianying416.base;

import java.lang.ref.WeakReference;

/**
 * 时间：2020/4/8
 * 作者：徐黎明
 * 类的作用：
 */
public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {
    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter() {
        model = initModel();
    }
    public void attach(V v){
        weakReference =new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        return weakReference.get();
    }
    protected abstract M initModel();
}
