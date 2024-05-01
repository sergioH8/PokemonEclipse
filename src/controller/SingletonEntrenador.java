package controller;

import modelo.Entrenador;

public class SingletonEntrenador {

    // Instancia única de la clase
    private static SingletonEntrenador instance;

    // Atributo para almacenar el objeto Entrenador
    public Entrenador value;

    // Constructor privado para evitar la creación de instancias directamente
    private SingletonEntrenador(Entrenador value){
        this.value = value;
    }

    // Método estático para obtener la instancia única de SingletonEntrenador
    public static SingletonEntrenador getInstance(Entrenador value){
        // Si la instancia aún no ha sido creada, crearla
        if(instance == null){
            instance = new SingletonEntrenador(value);
        }
        // Devolver la instancia existente
        return instance;
    }
}