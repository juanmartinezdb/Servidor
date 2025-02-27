package org.iesbelen.dao;

import java.util.List;
import java.util.Optional;

import org.iesbelen.modelo.Jugador;

public interface JugadorDAO {

    public void create(Jugador jugador);
    public List<Jugador> getAll();
    public Optional<Jugador>  find(int id);
    public void update(Jugador jugador);
    public void delete(int id);

}
