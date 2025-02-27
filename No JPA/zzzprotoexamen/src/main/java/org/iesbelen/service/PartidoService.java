package org.iesbelen.service;

import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.net.server.Client;
import org.iesbelen.dao.PartidoDAO;
import org.iesbelen.modelo.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {

    @Autowired
    private PartidoDAO partidoDAO;

    public List<Partido> listAll() {

        return partidoDAO.getAll();

    }

    public Partido one(Integer id) {
        Optional<Partido> optClie = partidoDAO.find(id);
        if (optClie.isPresent())
            return optClie.get();
        else
            return null;
    }

    public void newPartido(Partido partido) {

        partidoDAO.create(partido);

    }

    public void replacePartido(Partido partido) {

        partidoDAO.update(partido);

    }

    public void deletePartido(int id) {

        partidoDAO.delete(id);

    }

}
