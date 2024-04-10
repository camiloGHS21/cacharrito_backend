package com.example.cacharrito.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacharrito.modelo.Disponibilidad;
import com.example.cacharrito.repositorio.RepositorioDisponibilidad;

@RestController
@RequestMapping("/api/disponibilidad")
public class ControladorDisponibilidad {
	  @Autowired
	  private RepositorioDisponibilidad repositorio;
	  
	  @GetMapping("/verTodos")
	  public List<Disponibilidad> verTodasDisponibilidad(){
		  return repositorio.findAll();
	  }
	  
	  @GetMapping("/buscarId")
	  public Optional<Disponibilidad> verDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
		  return repositorio.findById(disponibilidad.getId_disponibilidad());
	  }
	  
	  
	  @PostMapping("/guardar")
	  public Disponibilidad guardarDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
		  return repositorio.save(disponibilidad);
		  
	  }
	  
	  @DeleteMapping("/borrar")
	  public  ResponseEntity<String> borrarDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
	      try {
	          repositorio.deleteById(disponibilidad.getId_disponibilidad());
	          return ResponseEntity.ok("Disponibilidad eliminada correctamente");
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la Disponibilidad: " + e.getMessage());
	      }
	  }
     
	   @PatchMapping("/actualizar")
	   public ResponseEntity<String> actualizarDisponibilidad(@RequestBody Disponibilidad disponibilidad){
		   try {
		          repositorio.save(disponibilidad);
		          return ResponseEntity.ok("Disponibilidad actualizada correctamente");
		      } catch (Exception e) {
		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la Disponibilidad: " + e.getMessage());
		      }
		   
	   }
}
