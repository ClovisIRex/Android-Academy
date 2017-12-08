package dev.tal.exercise5tal.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tal on 11/29/17.
 */

public interface PixabayService {

    @GET("/api")
    Call<ImageSearchResult> searchImage(@Query("q") String queryValue, @Query("page") int page);

}
