package org.iesbelen.service;

import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.net.server.Client;
import org.iesbelen.dao.EquipoDAO;
import org.iesbelen.modelo.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {

    @Autowired
    private EquipoDAO equipoDAO;

    public List<Equipo> listAll() {

        return equipoDAO.getAll();

    }

    public Equipo one(String nombre) {
        Optional<Equipo> equipo = equipoDAO.find(nombre);
        if (equipo.isPresent())
            return equipo.get();
        else
            return null;
    }

    public void newEquipo(Equipo equipo) {

        equipoDAO.create(equipo);

    }

    public void replaceEquipo(Equipo equipo) {

        equipoDAO.update(equipo);

    }

    public void deleteEquipo(String nombre) {

        equipoDAO.delete(nombre);

    }

}
