package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class Vaccine(
    @SerializedName("page") val page: Int,
    @SerializedName("perPage") val perPage: Int,
    @SerializedName("totalCount") val totalCount: Int,
    @SerializedName("currentCount") val currentCount: Int,
    @SerializedName("matchCount") val matchCount: Int,
    @SerializedName("data") val data: List<VaccineBody>
)

data class VaccineBody(
    @SerializedName("id") val id: Int,
    @SerializedName("centerName") val centerName: String,
    @SerializedName("sido") val sido: String,
    @SerializedName("sigungu") val sigungu: String,
    @SerializedName("facilityName") val facilityName: String,
    @SerializedName("zipCode") val zipCode: String,
    @SerializedName("address") val address: String,
    @SerializedName("lat") val lat: String,
    @SerializedName("lng") val lng: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("centerType") val centerType: String,
    @SerializedName("org") val org: String,
    @SerializedName("phoneNumber") val phoneNumber: String
)