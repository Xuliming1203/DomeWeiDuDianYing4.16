package com.bw.domeweidudianying416.utils;

import com.bw.domeweidudianying416.api.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间：2020/4/7
 * 作者：徐黎明
 * 类的作用：
 */
public class RetrofitUtil {
    private static RetrofitUtil instance;
    private final Retrofit retrofit;

    private RetrofitUtil() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            instance=new RetrofitUtil();
        }
        return instance;
    }
        public <T>T createservice(Class<T>tClass){
                T t=retrofit.create(tClass);
                return t;
        }
}
