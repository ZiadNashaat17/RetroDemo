package com.example.retrodemo.repository

import com.example.retrodemo.api.ApiService
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val apiService: ApiService) {
     fun getTv(key: String, id: Int) = apiService.getTVs(key, id)
}