package com.example.retrofit2schoolmeal.model

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("MealServiceDietInfo")
    val mealservicedietinfo:ArrayList<Mealservicedietinfo>
)

data class Mealservicedietinfo(
    val service: ArrayList<Service>? = null //null이 가능한 변수
//데이터 클래스지만 값이 없을 경우를 대비해서 생성자에 미리 ? = null을 썼다.
)

data class Service(
        val KEY : String,
        val Type: String ,
        val pIndex : Int,
        val pSize: Int = 5,
        val  MLSV_YMD : String,
        val ATPT_OFCDC_SC_CODE :String = "F10",
        val SD_SCHUL_CODE: String = "7380292"
)