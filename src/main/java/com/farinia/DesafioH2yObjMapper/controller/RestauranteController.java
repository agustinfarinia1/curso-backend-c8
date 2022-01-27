package com.farinia.DesafioH2yObjMapper.controller;

import com.farinia.DesafioH2yObjMapper.model.Ciudad;
import com.farinia.DesafioH2yObjMapper.model.Producto;
import com.farinia.DesafioH2yObjMapper.model.Restaurante;
import com.farinia.DesafioH2yObjMapper.service.RestauranteServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/farinia")
public class RestauranteController {

    private final RestauranteServiceInterface service;

    @GetMapping("/restaurante/ej")
    public String getEjemplo() {
        return "restaurante";
    }

    @GetMapping("/restaurante")
    public List<Restaurante> getRestaurante() {
        return service.findAll();
    }

    @PostMapping("/restaurante")
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        return service.createRestaurante(restaurante);
    }

    @PostMapping("/restaurante/map")
    public void restaurantetoMap(@RequestBody Restaurante restaurante) throws JsonProcessingException {
        service.mapperToMap(restaurante);
    }
}
