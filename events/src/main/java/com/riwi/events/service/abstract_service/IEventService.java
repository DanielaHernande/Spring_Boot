package com.riwi.events.service.abstract_service;

import java.util.List;

import com.riwi.events.entities.Event;

public interface IEventService {

    // Metodo para insertar nuevos datos
    public Event save(Event objEvent);

    // Metodo para Listar los datos
    public List<Event> getAll();

    // Metodo para buscar por id
    public Event getById(String id);

    // Metodo para actualizar un evento
    public Event update(Event objEvent);

    // Metodo para eliminar
    public void delete(String id);
    
}
