package com.bw.domeweidudianying416.api;

import com.bw.domeweidudianying416.entity.CinemaSearchEntity;
import com.bw.domeweidudianying416.entity.MovieSearchEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 时间：2020/5/5
 * 作者：徐黎明
 * 类的作用：
 */
public interface SearchApiService {
    @GET("movie/v2/findMovieByKeyword")
    Observable<MovieSearchEntity> moviesearch(@Query("keyword")String keyword,
                                               @Query("page") int page,
                                               @Query("count") int count
                                               );
    @GET("cinema/v1/findAllCinema")
    Observable<CinemaSearchEntity> cinemasearch(@Query("page") int page,
                                                @Query("count") int count,
                                                @Query("cinemaName")String cinemaName);
}
