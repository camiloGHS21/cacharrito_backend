package com.example.cacharrito.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@ Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @Column(name = "cedula")
    private long cedula;

    @OneToMany
    @JoinColumn(name = "id_reserva")
    private Reservaciones reservaciones;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "telefeno")
    private String telefono;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    // Constructor, getters y setters

    public Usuarios() {}

    public Usuarios(Long cedula, Reservaciones reservaciones , String nombre, String apellido, String telefono, String fechaNacimiento) {
        this.cedula = cedula;
        this.reservaciones = reservaciones;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
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

    public String getTelefono() {
        return telefono;
    }

    public Reservaciones getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(Reservaciones reservaciones) {
		this.reservaciones = reservaciones;
	}

	public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
