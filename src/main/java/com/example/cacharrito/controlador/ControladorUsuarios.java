package com.example.cacharrito.controlador;

import com.example.cacharrito.modelo.Usuarios;
import com.example.cacharrito.repositorio.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuarios {

	@Autowired
	  private RepositorioUsuarios repositorio;
	  
	  @GetMapping("/verTodos")
	  public List<Usuarios> verTodosLosUsuarrios(){
		  return repositorio.findAll();
	  }
	  
	  @GetMapping("/buscarId")
	  public Optional<Usuarios> verUsuarios(@RequestBody Usuarios usuario) {
		  return repositorio.findById(usuario.getCedula());
	  }
	  
	  
	  @PostMapping("/guardar")
	  public Usuarios guardarUsuarios(@RequestBody  Usuarios  usuario ) {
		  return repositorio.save(usuario);
		  
	  }
	  
	  @DeleteMapping("/borrar")
	  public  ResponseEntity<String> borrarUsuarios(@RequestBody Usuarios usuario) {
	      try {
	          repositorio.deleteById(usuario.getCedula());
	          return ResponseEntity.ok(" Usuarios eliminados correctamente");
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario: " + e.getMessage());
	      }
	  }
   
	   @PatchMapping("/actualizar")
	   public ResponseEntity<String> actualizarUsuarios(@RequestBody Usuarios usuarios){
		   try {
		          repositorio.save(usuarios);
		          return ResponseEntity.ok("Usuarios actualizados correctamente");
		      } catch (Exception e) {
		          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar los usuarios : " + e.getMessage());
		      }
		   
	   }
}