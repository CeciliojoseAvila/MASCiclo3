package com.MASCiclo3.demo.Modelos;


import javax.persistence.*;

@Entity
@Table
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String dirección;
    private String teléfono;
    private String NIT;

    public Empresa() {
    }

    public Empresa(String nombre, String dirección, String teléfono, String NIT) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.teléfono = teléfono;
        this.NIT = NIT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
}
