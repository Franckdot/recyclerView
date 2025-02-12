package com.example.lista.interfaces;

import com.example.lista.modelo.User;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("users")
    Call<List<User>> getUsers();
}
