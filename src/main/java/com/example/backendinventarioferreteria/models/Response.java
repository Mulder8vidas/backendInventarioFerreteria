package com.example.backendinventarioferreteria.models;

import java.util.Map;

public record Response(String mensaje, Map<String,Object> data) {
}
