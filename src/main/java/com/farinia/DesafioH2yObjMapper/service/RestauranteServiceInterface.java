package com.farinia.DesafioH2yObjMapper.service;

import com.farinia.DesafioH2yObjMapper.model.Restaurante;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface RestauranteServiceInterface {
    Restaurante createRestaurante(Restaurante restaurante);
    Restaurante getRestauranteById(Long id);
    Restaurante updateRestauranteById(Restaurante restaurante, Long id);
    void deleteRestaurante(Restaurante restaurante, Long id);
    List<Restaurante> findAll();
    void mapperToMap(Restaurante restaurante) throws JsonProcessingException;
}
