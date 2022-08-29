package com.MASCiclo3.demo.Modelos;


import javax.persistence.*;

@Entity
@Table(name = "Movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long monto;
    private String dconcepto;

    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Empleado usuario;

    public MovimientoDinero() {
    }

    public MovimientoDinero(long monto, String dconcepto, Empleado empleado) {
        this.monto = monto;
        this.dconcepto = dconcepto;
        this.usuario = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getDconcepto() {
        return dconcepto;
    }

    public void setDconcepto(String dconcepto) {
        this.dconcepto = dconcepto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }
}
