package org.iesbelen.videoclub.repository;

import jakarta.persistence.EntityManager;
import org.iesbelen.videoclub.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaCustomRepositoryJPQLImpl implements PeliculaCustomRepository {
    @Autowired
    private EntityManager em;


//    @Override
//    public List<Pelicula> pelisOrdenadabyColSentido(Optional<String[]> ColDire) {
//        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Pelicula p");
//        if (ColDire.isPresent()) {
//            String columna = ColDire.get()[0];
//            String direccion = ColDire.get()[1];
//            queryBuilder.append(" ORDER BY ").append("p." +columna+" ").append(direccion);
//        }
//        return em.createQuery(queryBuilder.toString(), Pelicula.class).getResultList();
//    }
    @Override
    public List<Pelicula> pelisOrdenadabyColSentido(Optional<String[]> orden) {
        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Pelicula p");

        if (orden.isPresent()) {
            String[] ordenes = orden.get();
                queryBuilder.append(" ORDER BY ");

                for (int i = 0; i < ordenes.length; i++) {
                    String[] partes = ordenes[i].split(",");
                        String columna = partes[0];
                        String direccion = partes[1];
                        queryBuilder.append("p."+columna+" ").append(direccion);
                        
                        if (i < ordenes.length - 1) {
                            queryBuilder.append(", ");
                        }
                }
        }
        return em.createQuery(queryBuilder.toString(), Pelicula.class).getResultList();
    }
}
