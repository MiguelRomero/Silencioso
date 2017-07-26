package com.example.migueleduardo.voceosilencioso1;

/**
 * Created by MiguelEduardo on 17/07/2017.
 */

public class InformacionAlta {

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreauto() {
        return nombreauto;
    }

    public void setNombreauto(String nombreauto) {
        this.nombreauto = nombreauto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMarcaauto() {
        return marcaauto;
    }

    public void setMarcaauto(String marcaauto) {
        this.marcaauto = marcaauto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getCorreooo() {
        return correooo;
    }

    public void setCorreooo(String correo) {
        this.correooo = correo;
    }



    public String correooo;

    public String getIdusuariobebe() {
        return idusuariobebe;
    }

    public void setIdusuariobebe(String idusuariobebe) {
        this.idusuariobebe = idusuariobebe;
    }

    public String idusuariobebe;

    public String getNombredelniño() {
        return nombredelniño;
    }

    public void setNombredelniño(String nombredelniño) {
        this.nombredelniño = nombredelniño;
    }

    public String nombredelniño;
    public String nombre;
    public String apellidos;
    public String matricula;
    public String nombreauto;
    public String celular;
    public String marcaauto;
    public String color;

    public String getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String idEscuela;



    public InformacionAlta(){

    }

    public InformacionAlta(String nombre, String apellidos, String matricula, String nombreauto, String celular, String marcaauto, String color,String iduser,String correo,String niño,String idEsc) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.matricula = matricula;
        this.nombredelniño = niño;
        this.nombreauto = nombreauto;
        this.celular = celular;
        this.idEscuela = idEsc;
        this.marcaauto = marcaauto;
        this.color = color;
        this.idusuariobebe = iduser;
        this.correooo = correo;
    }
}
