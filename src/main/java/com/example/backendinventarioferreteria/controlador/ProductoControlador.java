package com.example.backendinventarioferreteria.controlador;
import com.example.backendinventarioferreteria.excepciones.ResourcesNotFoundExceptions;
import com.example.backendinventarioferreteria.models.Productos;
import com.example.backendinventarioferreteria.repository.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class ProductoControlador {
    @Autowired
    private ProductosRepositorio repositorio;
    @GetMapping("/productos/busqueda/{txt}")
    public  List<Productos>Busqueda(@PathVariable("txt")String txt){
        return repositorio.findByNombreContainsIgnoreCaseOrMarcaContainsIgnoreCase(txt,txt);
    }

    @GetMapping("/productos")
    public List<Productos> listarTodosLosProductos(){
        return repositorio.findAll();
    }

    @PostMapping("/productos")
    public Productos guardarProductos(@RequestBody Productos productos){
        return repositorio.save(productos);
    }

    @GetMapping("/productos/{id}")

    public ResponseEntity<Productos> obtenerProductoPorId(@PathVariable Long id){

        Productos productos = repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions("No existe el producto con el ID: " + id));
        return ResponseEntity.ok(productos);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Long id,@RequestBody Productos detallesProductos){
        Productos productos =repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions("No existe el producto con el ID: " + id));
        productos.setNombre(detallesProductos.getNombre());
        productos.setCategoria(detallesProductos.getCategoria());
        productos.setMarca(detallesProductos.getMarca());
        productos.setCantidadEnStock(detallesProductos.getCantidadEnStock());
        productos.setDescripcion(detallesProductos.getDescripcion());
        productos.setImagenUrl(detallesProductos.getImagenUrl());
        productos.setPrecio(detallesProductos.getPrecio());

        Productos productoActualizado = repositorio.save(productos);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        Productos productos = repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions("No existe el producto con el ID: " + id));

        repositorio.delete(productos);

        return ResponseEntity.ok().build();
    }


}
