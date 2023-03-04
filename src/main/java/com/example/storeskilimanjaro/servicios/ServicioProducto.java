package com.example.storeskilimanjaro.servicios;

import com.example.storeskilimanjaro.entidades.Producto;
import com.example.storeskilimanjaro.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicioProducto implements ServicioComun<Producto> {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> buscarTodos() {
        return null;
    }

    @Override
    public Producto buscarPorId(Integer id) {
       try{
           Optional<Producto> producto=productoRepositorio.findById(id);
           return producto.get();

       }catch(Exception error){
           return null;
           //throw new Exception(error.getMessage());
       }
    }

    @Override
    public Producto agregar(Producto datos) {
        return null;
    }

}
