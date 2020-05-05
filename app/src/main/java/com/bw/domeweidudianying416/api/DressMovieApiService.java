package com.bw.domeweidudianying416.api;

import com.bw.domeweidudianying416.entity.FuMovieEntity;
import com.bw.domeweidudianying416.entity.TuiMovieEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * 时间：2020/4/25
 * 作者：徐黎明
 * 类的作用：
 */
public interface DressMovieApiService {
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TuiMovieEntity> gettui(@Header("userId")int userId, @Header("sessionId")String sessionId,
                                      @Query("page") int page,@Query("count") int count);

    @GET("cinema/v1/findNearbyCinemas")
    Observable<FuMovieEntity> getfu(@Header("userId")int userId, @Header("sessionId")String sessionId,
                                    @Query("longitude")String longitude,@Query("latitude")String latitude,
                                    @Query("page") int page,@Query("count") int count);
}
