package com.example.cacharrito.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cacharrito.modelo.Reservaciones;
import com.example.cacharrito.repositorio.RepositorioReservaciones;


@RestController
@RequestMapping("/reservaciones")
public class ControladorReservaciones {

	  @Autowired
	  private RepositorioReservaciones repositorio;
	  
	  @GetMapping("/verTodos")
	  public List<Reservaciones> verTodasReservaciones(){
		  return repositorio.findAll();
	  }
	  
	  @GetMapping("/buscarId")
	  public Optional<Reservaciones> verReservacion(@RequestBody Reservaciones reservacion) {
		  return repositorio.findById(reservacion.getId_de_reserva());
	  }
	  
	  
	  @PostMapping("/guardar")
	  public Reservaciones guardarReservacion(@RequestBody Reservaciones reservacion ) {
		  return repositorio.save(reservacion);
		  
	  }
	  
	  @DeleteMapping("/borrar")
	  public  ResponseEntity<String> borrarReservacion(@RequestBody Reservaciones reservacion) {
	      try {
	          repositorio.deleteById(reservacion.getId_de_reserva());
	          return ResponseEntity.ok("Reservación eliminada correctamente");
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la reservación: " + e.getMessage());
	      }
	  }
     
	   @PatchMapping("/actualizar")
	   public ResponseEntity<String> actualizarReservacion(@RequestBody Reservaciones reservacion){
		   try {
		          repositorio.save(reservacion);
		          return ResponseEntity.ok("Reservación actualizada correctamente");
		      } catch (Exception e) {
		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la reservación: " + e.getMessage());
		      }
		   
	   }
	   
}
