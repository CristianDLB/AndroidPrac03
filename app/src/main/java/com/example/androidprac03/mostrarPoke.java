package com.example.androidprac03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.androidprac03.Adaptador.PokeAdaptar;
import com.example.androidprac03.Entidad.Pokemon;
import com.example.androidprac03.Factor.RetroFactor;
import com.example.androidprac03.Servicio.PokeServicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mostrarPoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_poke);

        Retrofit retro = RetroFactor.Links();

        PokeServicio serP = retro.create(PokeServicio.class);
        Call<List<Pokemon>> call = serP.GetPokemon();

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if(!response.isSuccessful()){
                    Log.e("App_Pokemon","ERROR APP");
                } else {
                    Log.i("App_Pokemon","Me Conecteeee :)");

                    List<Pokemon> pokemonss = response.body();
                    PokeAdaptar adapter = new PokeAdaptar(pokemonss);

                    RecyclerView rv = findViewById(R.id.rvPokemon);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                Log.e("App_Pokemon","No Hubo conectividad");
            }
        });


    }
}