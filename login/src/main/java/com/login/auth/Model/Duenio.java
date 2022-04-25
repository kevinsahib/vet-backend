package com.login.auth.Model;

public class Duenio extends User {

    private int idDuenio;
    private String nombre;
    private String telefono;
    private String direccion;

    public Duenio() {
    }

    public Duenio(int idUser, String email, String password, String rol, int idDuenio, String nombre, String telefono, String direccion) {
        super(idUser, email, password, rol);
        this.idDuenio = idDuenio;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
