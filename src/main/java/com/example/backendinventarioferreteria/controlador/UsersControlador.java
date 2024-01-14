package com.example.backendinventarioferreteria.controlador;
import com.example.backendinventarioferreteria.excepciones.ResourcesNotFoundExceptions;
import com.example.backendinventarioferreteria.models.Productos;
import com.example.backendinventarioferreteria.models.Users;
import com.example.backendinventarioferreteria.repository.ProductosRepositorio;
import com.example.backendinventarioferreteria.repository.UsersRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UsersControlador {
    @Autowired
    private UsersRepositorio repositorio;
    @GetMapping("/usuarios")
    public List<Users> listarTodosLosUsuarios(){
        return repositorio.findAll();
    }

    @PostMapping("/usuarios")
    public Users guardarUsuarios(@RequestBody Users usuarios){
        return repositorio.save(usuarios);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Users> obtenerUsuariosPorId(@PathVariable Long id){
        Users usuarios = repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions("No existe el producto con el ID: " + id));
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Users> actualizarUsuarios(@PathVariable Long id,@RequestBody Users detallesUsuarios){
        Users usuarios =repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions("No existe el producto con el ID: " + id));
        usuarios.setNombre(detallesUsuarios.getNombre());
        usuarios.setApellido(detallesUsuarios.getApellido());
        usuarios.setEmail(detallesUsuarios.getEmail());
        usuarios.setPassword(detallesUsuarios.getPassword());
        usuarios.setRol(detallesUsuarios.getRol());
        usuarios.setImagenUrl(detallesUsuarios.getImagenUrl());

        Users UsuarioActualizado = repositorio.save(usuarios);
        return ResponseEntity.ok(UsuarioActualizado);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        Users usuarios = repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions("No existe el producto con el ID: " + id));

        repositorio.delete(usuarios);

        return ResponseEntity.ok().build();
    }

}
