package com.example.cacharrito.repositorio;

import com.example.cacharrito.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuarios,Long> {
 
}