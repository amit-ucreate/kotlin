package com.kotlinrecyclerview.retrofit

import com.google.gson.annotations.SerializedName

/**
 * Created by Amit Agnihotri on 8/28/2018.
 */
class Category {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("parent")
    var parent: Int = 0

    @SerializedName("post_count")
    var post_count: Int = 0
}