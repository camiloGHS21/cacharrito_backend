package com.example.cacharrito.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cacharrito.modelo.Automoviles;
import com.example.cacharrito.repositorio.RepositorioAutomoviles ;

@RestController
@RequestMapping("/automoviles")
public class ControladorAutomoviles {
	
	@Autowired
	  private RepositorioAutomoviles repositorio;
	
	@GetMapping("/verTodos")
	public List<Automoviles> verTodosAutomoviles(){
		return repositorio.findAll();
	}
	  
	 @GetMapping("/buscarId")
	  public Optional<Automoviles> verAutomovil(@RequestBody Automoviles automovil) {
		  return repositorio.findById(automovil.getNumero_de_automovil());
		  
	  }
	  
	  
	  @PostMapping("/guardar")
	  public Automoviles guardarAutomovil(@RequestBody Automoviles automovil ) {
		  return repositorio.save(automovil);
		  
	  }
	  
	  @DeleteMapping("/borrar")
	  public  ResponseEntity<String> borrarAutomovil(@RequestBody Automoviles automovil) {
	      try {
	          repositorio.deleteById(automovil.getNumero_de_automovil());
	          return ResponseEntity.ok("Automovil eliminada correctamente");
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la Automovil: " + e.getMessage());
	      }
	  }
    
	   @PatchMapping("/actualizar")
	   public ResponseEntity<String> actualizarAutomovil(@RequestBody Automoviles automovil){
		   try {
		          repositorio.save(automovil);
		          return ResponseEntity.ok("Reservación actualizada correctamente");
		      } catch (Exception e) {
		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la Automovil: " + e.getMessage());
		      }
		   
	   }
	   
}
