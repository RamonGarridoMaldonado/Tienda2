package com.rgarmal.springproject.tienda.model;

public class Vendedor {

    private int codigo;
    private String nombre;
    private String apellido;
    private String puesto;

    public Vendedor() {
    }

    public Vendedor(int codigo) {
        this.codigo = codigo;
    }

    public Vendedor(int codigo, String nombre, String apellido, String puesto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vendedor other = (Vendedor) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

}
