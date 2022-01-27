package com.farinia.DesafioH2yObjMapper.service;

import com.farinia.DesafioH2yObjMapper.model.Ciudad;
import com.farinia.DesafioH2yObjMapper.model.Producto;
import com.farinia.DesafioH2yObjMapper.model.Restaurante;
import com.farinia.DesafioH2yObjMapper.repository.CiudadRepository;
import com.farinia.DesafioH2yObjMapper.repository.RestauranteRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestauranteService implements RestauranteServiceInterface{

    @Autowired
    private RestauranteRepository repository;
    @Autowired
    private CiudadRepository repository2;
    private final ObjectMapper mapper;

    @PostConstruct
    private void PostConstruct() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }

    @Override
    public Restaurante createRestaurante(Restaurante restaurante) {
        try {
            mapperToString(restaurante);
            mapperToMap(restaurante);
            mapperToClass(restaurante);

            Ciudad c = repository2.save(restaurante.getCiudad());
            return repository.save(restaurante);
        } catch (JsonProcessingException e) {
            log.error("Error converting message to string", e);
        }
        return restaurante;
    }

    @Override
    public Restaurante getRestauranteById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Restaurante updateRestauranteById(Restaurante restaurante, Long id) {
        restaurante.setId(id);
        return repository.save(restaurante);
    }

    @Override
    public void deleteRestaurante(Restaurante restaurante, Long id) {
        restaurante.setId(id);
        repository.delete(restaurante);
    }

    @Override
    public List<Restaurante> findAll() {
        return (List<Restaurante>) repository.findAll();
    }

    public void mapperToString(Restaurante restaurante) throws JsonProcessingException {
        var userString = mapper.writeValueAsString(restaurante);
        log.info("Mensaje en formato String : {}", userString);
    }
    @Override
    public void mapperToMap(Restaurante restaurante) throws JsonProcessingException {
        var userString = mapper.writeValueAsString(restaurante);
        var userMap = mapper.readValue(userString, Map.class);
        log.info("Mensaje en formato de Mapa : {}", userMap);
    }

    public void mapperToClass(Restaurante restaurante) throws JsonProcessingException {
        var userString = mapper.writeValueAsString(restaurante);
        var userClass = mapper.readValue(userString, Restaurante.class);
        log.info("Mensaje en formato de Clase : {}", userClass);
    }
}
