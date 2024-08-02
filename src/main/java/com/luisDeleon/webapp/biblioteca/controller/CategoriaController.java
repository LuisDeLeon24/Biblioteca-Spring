package com.luisDeleon.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.luisDeleon.webapp.biblioteca.model.Categoria;
import com.luisDeleon.webapp.biblioteca.service.CategoriaService;
 
@Controller
@RestController
@RequestMapping(value = "categoria")
public class CategoriaController {
   
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria>buscarCategoriaPorId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(categoriaService.buscarCategoriaPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

 
    @GetMapping("/")
    public List<Categoria> listarCategoria(){
        return categoriaService.listarCategorias();
    }
 
 
    @PostMapping("/")
    public ResponseEntity<Map<String, Boolean>> agregarCategoria(@RequestBody Categoria categoria){
        Map<String, Boolean> response = new HashMap<>();
        try{
            categoriaService.guardarCategoria(categoria);
            response.put("Se agrego con exito", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("Se agrego con exito", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <Map<String,String>> editarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaNueva){
        Map<String,String> response = new HashMap<>();
        try {
            Categoria categoria = categoriaService.buscarCategoriaPorId(id);
            categoria.setNombreCategoria(categoriaNueva.getNombreCategoria()); //Se sustituye el nuevo valor por el viejo
            categoriaService.guardarCategoria(categoria);//Se manda la categoria vieja, ya que el Id se manda en el path
            response.put("message", "Se editó la categoria correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "No se pudo editar la categoria");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>>eliminarCategoria(@PathVariable Long id){
        Map<String,String> response = new HashMap<>();
        try {
            Categoria categoria = categoriaService.buscarCategoriaPorId(id);
            categoriaService.eliminarCategoria(categoria); 
            response.put("message", "La Categoria Se Elimino Con Exito");
            return ResponseEntity.ok(response); 
        } catch (Exception e) {
            response.put("message", "Hubo Un Error Al Eliminar La Categoria");
            return ResponseEntity.badRequest().body(response);
        }
        

    }
}
