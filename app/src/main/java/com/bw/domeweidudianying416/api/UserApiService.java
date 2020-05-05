package com.bw.domeweidudianying416.api;

import com.bw.domeweidudianying416.entity.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 时间：2020/4/16
 * 作者：徐黎明
 * 类的作用：
 */
public interface UserApiService {
    @POST("user/v2/register")
    @FormUrlEncoded
    Observable<UserEntity> getregis(@Field("nickName")String nickName,
                                    @Field("pwd")String pwd,
                                    @Field("email")String email,
                                    @Field("code")String code);
    @POST("user/v2/login")
    @FormUrlEncoded
    Observable<UserEntity> getlogin(@Field("email")String email,
                                    @Field("pwd")String pwd);
    @POST("user/v2/sendOutEmailCode")
    @FormUrlEncoded
    Observable<UserEntity> getyzm(@Field("email")String email);
}
