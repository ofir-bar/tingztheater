package com.ofirbar.tingztheater.networking;
import com.ofirbar.tingztheater.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {

    private NetworkUtils(){}

    private static Retrofit retrofitMovies;

    private static Retrofit getRetrofitInstanceForMoviesApi() {
        if (retrofitMovies == null) {

            retrofitMovies = new Retrofit.Builder()
                    .baseUrl(Constants.ANDROID_HIVE_MOVIES_BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitMovies;
    }

    public static AndroidHiveMoviesApi getMoviesApi(){
        return getRetrofitInstanceForMoviesApi().create(AndroidHiveMoviesApi.class);
    }

}