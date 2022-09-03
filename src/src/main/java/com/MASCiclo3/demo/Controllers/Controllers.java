package com.MASCiclo3.demo.Controllers;

import com.MASCiclo3.demo.Modelos.Empresa;
import com.MASCiclo3.demo.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class Controllers{
    @Autowired
    EmpresaService empresaService;

    @GetMapping("/enterprises")
    public List<Empresa> verEnpresas(){
        //return empresaService.getAllEmpresas();
        System.out.println("HOLAAAAA ");
        return null;
    }

    }



