package com.example.cacharrito.modelo;


import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="reservaciones")
public class Reservaciones {
	public Reservaciones() {
		super();
	}
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name="id_de_reserva")
   private Long id_de_reserva;
   
   @OneToOne()
   @JoinColumn(name="numero_de_automovil")
   private Automoviles automoviles;
   
   @Column(name="destino")
   private String destino;
   
   
   @Column(name="hora_de_salida")
   private String hora_de_salida;
   
   @Column(name="fecha")
   private Date fecha;
   
   @Column(name="total_a_pagar")
   private Long total_a_pagar;
   
   @Column(name="estado")
   private Boolean estado;
   

public Long getId_de_reserva() {
	return id_de_reserva;
}

public void setId_de_reserva(Long id_de_reserva) {
	this.id_de_reserva = id_de_reserva;
}

public String getDestino() {
	return destino;
}

public void setDestino(String destino) {
	this.destino = destino;
}

public String getHora_de_salida() {
	return hora_de_salida;
}

public void setHora_de_salida(String hora_de_salida) {
	this.hora_de_salida = hora_de_salida;
}

public Date getFecha() {
	return fecha;
}

public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public Long getTotal_a_pagar() {
	return total_a_pagar;
}

public void setTotal_a_pagar(Long total_a_pagar) {
	this.total_a_pagar = total_a_pagar;
}

public Boolean getEstado() {
	return estado;
}

public void setEstado(Boolean estado) {
	this.estado = estado;
}

public Automoviles getAutomoviles() {
	return automoviles;
}

public void setAutomoviles(Automoviles automoviles) {
	this.automoviles = automoviles;
}

public Reservaciones(Long id_de_reserva, String destino, String hora_de_salida, Date fecha, Long total_a_pagar,
		Boolean estado, Automoviles automoviles) {
	this.id_de_reserva = id_de_reserva;
	this.destino = destino;
	this.hora_de_salida = hora_de_salida;
	this.fecha = fecha;
	this.total_a_pagar = total_a_pagar;
	this.estado = estado;
	this.automoviles = automoviles;
}
   
   
   
}
