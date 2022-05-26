package com.example.androidprac03.Servicio;

import com.example.androidprac03.Entidad.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface PokeServicio {

    @GET("pokemons")
    Call<List<Pokemon>>GetPokemon();

    @GET("pokemons/{id}")
    Call<Pokemon> FinalPoke(@Part("id") int id );

    @POST("pokemons")
    Call<Pokemon> crearP(@Body Pokemon pokemon);


}
