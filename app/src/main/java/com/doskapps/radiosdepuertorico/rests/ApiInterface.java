package com.doskapps.radiosdepuertorico.rests;

import com.doskapps.radiosdepuertorico.Config;
import com.doskapps.radiosdepuertorico.callbacks.CallbackCategory;
import com.doskapps.radiosdepuertorico.callbacks.CallbackCategoryDetails;
import com.doskapps.radiosdepuertorico.callbacks.CallbackPais;
import com.doskapps.radiosdepuertorico.callbacks.CallbackRadio;
import com.doskapps.radiosdepuertorico.models.Settings;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    String CACHE = "Cache-Control: max-age=0";
    String AGENT = "Data-Agent: Your Radio App";

    @Headers({CACHE, AGENT})
    @GET("api/get_paises?api_key=" + Config.API_KEY)
    Call<CallbackPais> getPaises();

    @Headers({CACHE, AGENT})
    @GET("api/get_recent_radio?api_key=" + Config.API_KEY)
    Call<CallbackRadio> getRecentRadio(
            @Query("page") int page,
            @Query("count") int count,
            @Query("cLocale") String cLocale
    );

    @Headers({CACHE, AGENT})
    @GET("api/get_category_index?api_key=" + Config.API_KEY)
    Call<CallbackCategory> getAllCategories(
            @Query("cLocale") String cLocale
    );

    @Headers({CACHE, AGENT})
    @GET("api/get_category_detail")
    Call<CallbackCategoryDetails> getCategoryDetailsByPage(
            @Query("id") int id,
            @Query("page") int page,
            @Query("count") int count,
            @Query("cLocale") String cLocale
    );

    @Headers({CACHE, AGENT})
    @GET("api/get_search_results?api_key=" + Config.API_KEY)
    Call<CallbackRadio> getSearchPosts(
            @Query("search") String search,
            @Query("count") int count,
            @Query("cLocale") String cLocale
    );

    @Headers({CACHE, AGENT})
    @GET("api/get_privacy_policy")
    Call<Settings> getPrivacyPolicy();

}
