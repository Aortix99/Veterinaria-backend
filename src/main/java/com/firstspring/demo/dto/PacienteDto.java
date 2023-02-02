package com.firstspring.demo.dto;

import java.sql.Date;


public class PacienteDto {
    private int idPaciente;
    private String nombre;
    private Date feNaMascota;
    private Date feRegistro;
    private int idEspecie;
    private int idRaza;

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFeNaMascota() {
        return feNaMascota;
    }

    public void setFeNaMascota(Date feNaMascota) {
        this.feNaMascota = feNaMascota;
    }

    public Date getFeRegistro() {
        return feRegistro;
    }

    public void setFeRegistro(Date feRegistro) {
        this.feRegistro = feRegistro;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }
}
