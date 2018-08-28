package com.kotlinrecyclerview.retrofit

import com.google.gson.annotations.SerializedName

/**
 * Created by Amit Agnihotri on 8/28/2018.
 */
class CategoryResponse {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("count")
    var count: Int = 0

    @SerializedName("categories")
    var categories: ArrayList<Category>? = null

}