package com.MASCiclo3.demo.Service;

import com.MASCiclo3.demo.Modelos.Empresa;
import com.MASCiclo3.demo.Repositorios.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Le decimos a spring que la sgte anotacion es un servicio
@Service
public class EmpresaService {

    @Autowired //Conectamos esta clase con el repositorio de Empresa
    EmpresaRepository empresaRepository; //creamos un objeto de tipo EmpresaRepository para poder usar los metodos de dicha clase

    //método que retornará la lista de empresas, usando metodos heredadis de JpaRepository
   public List<Empresa> getAllEmpresas(){
       List<Empresa> empresaList = new ArrayList<>();

       empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa)); //Recorremos el iterable que regresa el metodo finAll del jpa y lo guardamos en la lista

       return empresaList;
   }
 // METODO QUE ME TRAE UN OBJETO DE TIPO EMPRESA CUANDO CUENTO CON EL ID DE LA MISMA
   public Empresa getEmpresaById(Integer Id){

    return empresaRepository.findById(Id).get();
   }
// METODO PARA ACTUALIZAR OBJETOS DE TIPO EMPRESA

    public boolean saveOrUpdateEmpresa(Empresa empresa){
       Empresa emp = empresaRepository.save(empresa);

       if (empresaRepository.findById(emp.getId()) != null){

           return true;
       }
        return false;
    }
    // metodos para eliminar empresas registradas

    public boolean deleteEmpresa(Integer Id){
       empresaRepository.deleteById(Id);

       if (getEmpresaById(Id) != null){
           return false;
       }
        return true;
    }
}
