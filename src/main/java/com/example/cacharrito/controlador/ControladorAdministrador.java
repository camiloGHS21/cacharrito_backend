package com.example.cacharrito.controlador;

import com.example.cacharrito.modelo.Administrador;
import com.example.cacharrito.repositorio.RepositorioAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Administrador ")
public class ControladorAdministrador{

	@Autowired
	  private RepositorioAdministrador repositorio;
	  
	  @GetMapping("/verTodos")
	  public List<Administrador> verTodosLosAdmisnitrador(){
		  return repositorio.findAll();
	  }
	  
	  @GetMapping("/buscarId")
	  public Optional<Administrador> verAdministrador(@RequestBody Administrador administrador) {
		  return repositorio.findById(administrador.getIdAdministrador());
	  }
	  
	  
	  @PostMapping("/guardar")
	  public Administrador guardarAdministrador(@RequestBody  Administrador  administrador ) {
		  return repositorio.save(administrador);
		  
	  }
	  
	  @DeleteMapping("/borrar")
	  public  ResponseEntity<String> borrarAdministrador(@RequestBody Administrador administrador) {
	      try {
	          repositorio.deleteById(administrador.getIdAdministrador());
	          return ResponseEntity.ok(" Administrador eliminado correctamente");
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el administrador : " + e.getMessage());
	      }
	  }
   
	   @PatchMapping("/actualizar")
	   public ResponseEntity<String> actualizarAdministrador(@RequestBody Administrador administrador){
		   try {
		          repositorio.save(administrador);
		          return ResponseEntity.ok("Administrador  actualizados correctamente");
		      } catch (Exception e) {
		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el administrador : " + e.getMessage());
		      }
		   
	   }
}