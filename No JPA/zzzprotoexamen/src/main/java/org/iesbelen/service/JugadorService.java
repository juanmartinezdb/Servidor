package org.iesbelen.service;

import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.net.server.Client;
import org.iesbelen.dao.JugadorDAO;
import org.iesbelen.modelo.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {

    @Autowired
    private JugadorDAO jugadorDAO;

    public List<Jugador> listAll() {

        return jugadorDAO.getAll();

    }

    public Jugador one(Integer id) {
        Optional<Jugador> optClie = jugadorDAO.find(id);
        if (optClie.isPresent())
            return optClie.get();
        else
            return null;
    }

    public void newJugador(Jugador jugador) {

        jugadorDAO.create(jugador);

    }

    public void replaceJugador(Jugador jugador) {

        jugadorDAO.update(jugador);

    }

    public void deleteJugador(int id) {

        jugadorDAO.delete(id);

    }

}
