package com.luckyteo.jettrivia.repository

import android.util.Log
import com.luckyteo.jettrivia.data.DataOrException
import com.luckyteo.jettrivia.model.QuestionItem
import com.luckyteo.jettrivia.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionAPI,
) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()
    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty())
                dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exc", "GetAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

}