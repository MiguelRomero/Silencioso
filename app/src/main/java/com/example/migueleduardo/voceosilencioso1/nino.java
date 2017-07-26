package com.example.migueleduardo.voceosilencioso1;

/**
 * Created by MiguelEduardo on 22/07/2017.
 */

public class nino {
     private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    private String matricula;


    public nino(){

    }
    public nino(String nombre, String matricula){
        this.nombre = nombre;
        this.matricula = matricula;
    }
}
