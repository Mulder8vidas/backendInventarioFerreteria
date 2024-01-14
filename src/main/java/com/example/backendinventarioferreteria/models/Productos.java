package com.example.backendinventarioferreteria.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false )
    private String nombre;


    @Column(name = "categoria",nullable = false)
    private String categoria;

    @Column(name = "marca")
    private String marca;

    @Column(name = "precio",nullable = false)
    private Double precio;

    @Column(name = "cantidad_en_stock",nullable = false)
    private int cantidadEnStock;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;
    public Productos(){

    }

    public Productos(Long id, String nombre, String categoria,String marca, Double precio, int cantidadEnStock, String imagenUrl, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca=marca;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.imagenUrl = imagenUrl;
        this.descripcion = descripcion;
    }
}
