package dev.tal.exercise5tal.rest;

import android.provider.ContactsContract;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tal on 11/30/17.
 */

public class ServiceGenerator {

    static String BASE_URL = "https://pixabay.com/api/";

    /* api key */
    static String apiKey = "7217262-e5d55a4e9a1d99063995eb701";
    static String keyQuery= "?key=" + apiKey;

    /* image_type parameters */
    static String IMAGE_TYPE = "photo";

    private static final int PER_PAGE = 20;

    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalUrl = original.url();

                    HttpUrl url = originalUrl.newBuilder()
                            .addQueryParameter("key", apiKey)
                            .addQueryParameter("image_type", IMAGE_TYPE)
                            .addQueryParameter("per_page", String.valueOf(PER_PAGE))
                            .build();

                    Request.Builder requestBuilder = original.newBuilder().url(url);
                    Request request = requestBuilder.build();

                    return chain.proceed(request);
                }
    });

    static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build());



    public static Retrofit retrofit = retrofitBuilder.build();

    public static int currentPage = 0;
}
