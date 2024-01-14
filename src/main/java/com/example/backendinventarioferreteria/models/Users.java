package com.example.backendinventarioferreteria.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false )
    private String nombre;

    @Column(name = "apellido",nullable = false )
    private String apellido;

    @Column(name = "email",nullable = false,unique = true )
    private String email;

    @Column(name = "Password",nullable = false )
    private String Password;

    @Column(name = "rol",nullable = false )
    private String rol;
    @Column(name = "imagen_url", length = 8000)
    private String imagenUrl;


}
