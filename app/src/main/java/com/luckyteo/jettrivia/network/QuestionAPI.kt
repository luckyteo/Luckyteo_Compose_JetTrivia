package com.luckyteo.jettrivia.network

import com.luckyteo.jettrivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {

    @GET("world.json")
    suspend fun getAllQuestions() : Question
}