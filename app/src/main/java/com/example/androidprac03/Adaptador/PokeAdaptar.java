package com.example.androidprac03.Adaptador;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidprac03.AtributosPoke;
import com.example.androidprac03.Entidad.Pokemon;
import com.example.androidprac03.Factor.RetroFactor;
import com.example.androidprac03.R;
import com.example.androidprac03.Servicio.PokeServicio;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PokeAdaptar extends RecyclerView.Adapter<PokeAdaptar.PokeHolder> {

    List<Pokemon> poke ;
    public PokeAdaptar(List<Pokemon> poke){
        this.poke = poke;
    }

    @NonNull
    @Override
    public PokeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poke_mues,parent,false);
        PokeHolder holder = new PokeHolder(vista);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PokeHolder holder, int position) {

        View ver = holder.itemView;

        Pokemon pok = poke.get(position);
        TextView TvId = ver.findViewById(R.id.PokeMuesId);
        TextView TvNombre = ver.findViewById(R.id.PokeMuesNombre);

        TvId.setText(pok.Tipo);
        TvNombre.setText(pok.nombre);
        /*

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retro = RetroFactor.Links();
                PokeServicio servicio = retro.create(PokeServicio.class);

                Call<Pokemon> call = servicio.FinalPoke(pok.id);
                call .enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        if(response.isSuccessful()){
                            Log.i("App_Pokemon",new Gson().toJson(response.body()));
                            Intent intent = new Intent(ver.getContext(), AtributosPoke.class);
                            ver.getContext().startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Log.e("App_Pokemon","No Hubo conectividad");
                    }
                });

            }
        });
        */



    }

    @Override
    public int getItemCount() {
        return poke.size();
    }

    class PokeHolder extends RecyclerView.ViewHolder{

        public PokeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
