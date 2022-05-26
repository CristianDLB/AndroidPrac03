package com.example.androidprac03.Entidad;

import java.util.List;

public class Pokemon {

    public int numero;
    public String nombre;
    public String Tipo;
    public String Region;
    public int id;

    public Pokemon() {
    }

    public Pokemon(int numero, String nombre, String tipo, String region, int id) {
        this.numero = numero;
        this.nombre = nombre;
        this.Tipo = tipo;
        this.Region = region;
        this.id = id;
    }
}
