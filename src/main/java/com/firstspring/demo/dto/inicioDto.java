package com.firstspring.demo.dto;
import java.sql.Date;
public class inicioDto {
    private int identificacion;
    private String telefono;

    private String ciudad;

    private String Direccion;

    private String Nombre;

    private String raza;

    private String especie;
    private String Npaciente;
    private Date FechaRe;

    private String NombreMascota;

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        NombreMascota = nombreMascota;
    }

    public Date getFechaRe() {
        return FechaRe;
    }

    public void setFechaRe(Date fechaRe) {
        FechaRe = fechaRe;
    }

    private int idPaciente;

    public String getNpaciente() {
        return Npaciente;
    }

    public void setNpaciente(String npaciente) {
        Npaciente = npaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}