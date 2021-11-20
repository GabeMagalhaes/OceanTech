package com.example.oceantech.webservices

import com.example.oceantech.models.Report
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ReportService {

    @GET("reports/{id}")
    fun getReport(@Path("id") id: String) : Call<Report>

}

class ReportConnection{

    val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:8090/reports")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val reportService = retrofit.create(ReportService::class.java)
}