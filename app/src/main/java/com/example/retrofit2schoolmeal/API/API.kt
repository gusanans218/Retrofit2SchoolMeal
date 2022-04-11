package com.example.retrofit2schoolmeal.API

import com.example.retrofit2schoolmeal.model.MealResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("mealServiceDietInfo")
    fun getMealService(
        @Query("KEY") key: String = "37e69aa085c84eae9dc94d6dffbfc3f7",
        @Query("Type") type: String = "json",
        @Query("pIndex") pindex: Int = 1,
        @Query("pSize") psize: Int = 5,
        @Query(" MLSV_YMD") meal_code : String,
        @Query("ATPT_OFCDC_SC_CODE") base_code:String = "F10",
        @Query("SD_SCHUL_CODE") school_code : String = "7380292"
    ): Single<MealResponse>
}