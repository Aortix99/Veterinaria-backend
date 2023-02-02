package com.firstspring.demo.dto;

public class DuenoDto {
    private int identificacion;
    private String tipoIdDueno;
    private String telefono;
    private String ciudad;
    private String Direccion;
    private String Nombre;
    private int idPaciente;

    public String getTipoIdDueno() {
        return tipoIdDueno;
    }

    public void setTipoIdDueno(String tipoIdDueno) {
        this.tipoIdDueno = tipoIdDueno;
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

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
