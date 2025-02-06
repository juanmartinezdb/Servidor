package org.iesbelen.dao;

import java.util.List;
import java.util.Optional;

import org.iesbelen.modelo.Partido;

public interface PartidoDAO {

    public void create(Partido partido);
    public List<Partido> getAll();
    public Optional<Partido>  find(int id);
    public void update(Partido partido);
    public void delete(long id);

}
