package com.jvhp.app20_github_r_sp.domain

import com.jvhp.app20_github_r_sp.data.model.Github
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("{login}")
    suspend fun buscarUsuario(
        @Path("login") usuario : String
    ) : Response<Github>
}