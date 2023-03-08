package com.example.storeskilimanjaro.controladores;

import com.example.storeskilimanjaro.entidades.Producto;
import com.example.storeskilimanjaro.servicios.ServicioProducto;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store/api/")


public class ContrloladorProducto {

    @Autowired
    ServicioProducto servicioProducto;

    public ResponseEntity<?> registrarProducto(@RequestBody Producto producto){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(servicioProducto.agregar(producto));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al registrar el producto");

        }


    }

    @GetMapping
    public ResponseEntity<?> buscarTodosProductos(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioProducto.buscarTodos());

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error buscando los productos");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<> buscarProductoPorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioProducto.buscarPorId(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error consultando el producto");
        }
    }



}
