package com.MASCiclo3.demo.Controllers;

import com.MASCiclo3.demo.Modelos.Empresa;
import com.MASCiclo3.demo.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

 //@RestControlleresto iba en public class controllers
 //@GetMapping(value = "/HOLA")
    //public String HOLA(){
      //  return "ESTO SI ES PROGRAMAR EN CICLO 3 DE MISION TIC 2022";
    //} SUPRIMO ESTE CODIGO PORQUE NECESITAMOS UN NUEVO CONTROLLERS//
@Controller
public class Controllers{
     @Autowired
     EmpresaService empresaService;

     @GetMapping ({"/","/verEmpresas"})
     public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje){
         List<Empresa> listaEmpresas=empresaService.getAllEmpresas();
         model.addAttribute("emplist",listaEmpresas);
         model.addAttribute("mensaje",mensaje);
         return "verEmpresas"; //Llamamos al HTML
     }

     @GetMapping("/agregarEmpresa")
     public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje){
         Empresa emp= new Empresa();
         model.addAttribute("emp",emp);
         model.addAttribute("mensaje",mensaje);
         return "agregarEmpresa";
     }

     @PostMapping("/GuardarEmpresa")
     public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
         if(empresaService.saveOrUpdateEmpresa(emp)==true){
             redirectAttributes.addFlashAttribute("mensaje","saveOK");
             return "redirect:/verEmpresas";
         }
         redirectAttributes.addFlashAttribute("mensaje","saveError");
         return "redirect:/agregarEmpresa";
     }

     @GetMapping("/editarEmpresa/{id}")
     public String EditarEmpresa(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
         Empresa emp=empresaService.getEmpresaById(id);
         //Creamos un atributo para el modelo, que se llame igualmente emp y es el que ira al html para llenar o alimentar campos
         model.addAttribute("emp",emp);
         model.addAttribute("mensaje", mensaje);
         return "editarEmpresa";
     }


     @PostMapping("/ActualizarEmpresa")
     public String updateEmpresa(@ModelAttribute("emp") Empresa emp, RedirectAttributes redirectAttributes){
         if(empresaService.saveOrUpdateEmpresa(emp)){
             redirectAttributes.addFlashAttribute("mensaje","updateOK");
             return "redirect:/verEmpresas";
         }
         redirectAttributes.addFlashAttribute("mensaje","updateError");
         return "redirect:/editarEmpresa";

     }

     @GetMapping("/EliminarEmpresa/{id}")
     public String EliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes){
         if (empresaService.deleteEmpresa(id)==true){
             redirectAttributes.addFlashAttribute("mensaje","deleteOK");
             return "redirect:/verEmpresas";
         }
         redirectAttributes.addFlashAttribute("mensaje", "deleteError");
         return "redirect:/verEmpresas";
     }


 }



