package org.iesbelen.dao;

import org.iesbelen.modelo.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoDAO {
    public void create(Equipo equipo);
    public List<Equipo> getAll();
    public Optional<Equipo> find(String  nombre);
    public void update(Equipo equipo);
    public void delete(String nombre);

}
