package controller;

import modelo.Entrenador;

public class SingletonEntrenador {

    private static SingletonEntrenador instance;
    public Entrenador value;

    private SingletonEntrenador(Entrenador value){
        this.value = value;
    }

    public static SingletonEntrenador getInstance(Entrenador value){
        if(instance == null){
            instance = new SingletonEntrenador(value);
        }
        return instance;
    }
}
