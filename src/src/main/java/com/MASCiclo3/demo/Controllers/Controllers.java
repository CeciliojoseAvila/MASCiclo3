package com.MASCiclo3.demo.Controllers;

import com.MASCiclo3.demo.Modelos.Empresa;
import com.MASCiclo3.demo.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

 //@RestController
@Controller
public class Controllers {
   /* @GetMapping(value = "/HOLA")
    public String HOLA(){
        return "ESTO SI ES PROGRAMAR EN CICLO 3 DE MISION TIC 2022";
    } //SUPRIMO ESTE CODIGO PORQUE NECESITAMOS UN NUEVO CONTROLLERS*/

    @Autowired
    EmpresaService empresaService;
    @GetMapping ({"/VerEmpresas"})
    public String viewEmpresas(Model model){

        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();
        model.addAttribute("emplist",listaEmpresas);

        return "VerEmpresas"; //Llamamos al html

    }

}



