package com.example.retrodemo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrodemo.repository.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(private val retrofitRepo: RetrofitRepository) :
    ViewModel() {

//    private var response = mutableStateOf<TvResponse?>(null)

    private var _tvResponse = MutableStateFlow<Response<TvResponse>?>(null)
    val tvResponse = _tvResponse

    fun getTvs(key: String, id: Int) {
        viewModelScope.launch(Dispatchers.IO) {

            val call = retrofitRepo.getTv(key, id)
            call.enqueue(object : Callback<TvResponse> {
                override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                    if (response.isSuccessful) {
                        val tvResponse = response.body()
                        Log.d("Response", tvResponse.toString())
                    }
                }

                override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        }
    }
}