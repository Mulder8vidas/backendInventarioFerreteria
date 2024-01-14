package com.example.backendinventarioferreteria.controlador;

import com.example.backendinventarioferreteria.models.Login;
import com.example.backendinventarioferreteria.models.Response;
import com.example.backendinventarioferreteria.models.Users;
import com.example.backendinventarioferreteria.repository.UsersRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AuthController {


    @Autowired
    private UsersRepositorio repositorio;


    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> login(@RequestBody Login loginDO){
        System.out.println("llego una peticion");

        Optional<Users> byEmail = this.repositorio.findByEmail(loginDO.getUsername());
        if(byEmail.isEmpty()){
            return ResponseEntity.ok(new Response("Usuario o clave incorrecta", Map.of()));
        }
        Users users = byEmail.get();

        if(!users.getPassword().equalsIgnoreCase(loginDO.getPassword())){
            return ResponseEntity.ok(new Response("Usuario o clave incorrecta", Map.of()));
        }

        Map<String, Object> informacion = new HashMap();
        informacion.put("rol",users.getRol());
        informacion.put("nombre",users.getNombre());
        informacion.put("apellido",users.getApellido());
        informacion.put("url",users.getImagenUrl());
        return ResponseEntity.ok(new Response("Usuario logeado",informacion));


    }





}
