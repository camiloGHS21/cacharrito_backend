package com.example.cacharrito.controlador;

import com.example.cacharrito.modelo.Administrador;
import com.example.cacharrito.servicios.ServicioMiDetallesDeUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api ")
public class ControladorAdministrador{

	 @Autowired
	    private ServicioMiDetallesDeUsuario authService;
	  

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Administrador request) {
        if (authService.authenticate(request.getUsuario(), request.getContraseña())) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}