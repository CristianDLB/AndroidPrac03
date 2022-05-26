package com.example.androidprac03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidprac03.Entidad.Pokemon;
import com.example.androidprac03.Factor.RetroFactor;
import com.example.androidprac03.Servicio.PokeServicio;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class crearPokes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pokes);

        Button btn = findViewById(R.id.btnAquiCreo);
        EditText edNum = findViewById(R.id.editNumero);
        EditText edNom = findViewById(R.id.editNombre);
        EditText edTipo = findViewById(R.id.editTipo);
        EditText edReg = findViewById(R.id.editRegi);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retro = RetroFactor.Links();

                PokeServicio servicio = retro.create(PokeServicio.class);
                Pokemon poke = new Pokemon();
                poke.numero = Integer.parseInt(edNum.getText().toString());
                poke.nombre = String.valueOf(edNom.getText());
                poke.Tipo = String.valueOf(edTipo.getText());
                poke.Region = String.valueOf(edReg.getText());

                Call<Pokemon> call = servicio.crearP(poke);

                call.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        if (response.isSuccessful()){
                            Log.i("App_Pokemon",new Gson().toJson(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Log.e("App_Pokemon","No Hubo conectividad");
                    }
                });




            }
        });









    }
}