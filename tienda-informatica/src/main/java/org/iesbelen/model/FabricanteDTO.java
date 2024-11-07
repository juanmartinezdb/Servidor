package org.iesbelen.model;

import java.util.Optional;

public class FabricanteDTO extends Fabricante {

    private int numProductos;

    public FabricanteDTO() {

    }
    public FabricanteDTO(Fabricante fabricante, int numProductos) {
        this.setNombre(fabricante.getNombre());
        this.setIdFabricante(fabricante.getIdFabricante());
        this.numProductos = numProductos;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    @Override
    public String toString() {
        return "FabricanteDTO{" +
                "numProductos=" + numProductos +
                '}';
    }
}
