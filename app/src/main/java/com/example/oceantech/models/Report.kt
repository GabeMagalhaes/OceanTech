package com.example.oceantech.models

import com.google.gson.annotations.SerializedName

data class Report (

    @SerializedName("goal")val id: String,
    @SerializedName("goal")val goal: String,
    @SerializedName("target")val target: String,
    @SerializedName("indicator")val indicator: String,
    @SerializedName("seriesCode")val seriesCode: String,
    @SerializedName("seriesDescription")val seriesDescription: String,
    @SerializedName("geoArea")val geoArea: String,
    @SerializedName("timePeriod")val timePeriod: String,
    @SerializedName("value")val value: String

)
