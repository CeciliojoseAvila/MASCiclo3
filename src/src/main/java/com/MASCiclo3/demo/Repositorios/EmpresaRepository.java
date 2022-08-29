package com.MASCiclo3.demo.Repositorios;

import com.MASCiclo3.demo.Modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Anotacion que le dice a spring que esta clase es un repositorio

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    static void finAll() {
    }
}
