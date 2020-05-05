package com.bw.domeweidudianying416.api;

import com.bw.domeweidudianying416.entity.JJSYEntity;
import com.bw.domeweidudianying416.entity.RMDYEntity;
import com.bw.domeweidudianying416.entity.XBannerEntity;
import com.bw.domeweidudianying416.entity.ZZRYEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * 时间：2020/4/19
 * 作者：徐黎明
 * 类的作用：
 */
public interface MovieApiService {
    @GET("tool/v2/banner")
    Observable<XBannerEntity> getxbanner();
    @GET("movie/v2/findReleaseMovieList")
    Observable<ZZRYEntity> getzzry(@Query("page")int page,@Query("count") int count);
    @GET("movie/v2/findComingSoonMovieList")
    Observable<JJSYEntity> getjjsy(@Header("userId")int userId,@Header("sessionId")String sessionId,
                                   @Query("page")int page,@Query("count")int count);
    @GET("movie/v2/findHotMovieList")
    Observable<RMDYEntity> getrmdy(@Query("page")int page,@Query("count") int count);
}
