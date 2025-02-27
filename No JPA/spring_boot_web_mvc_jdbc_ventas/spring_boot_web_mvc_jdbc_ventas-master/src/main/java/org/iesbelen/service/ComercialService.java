package org.iesbelen.service;

import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.iesbelen.modelo.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercialService {

@Autowired
private ComercialDAO comercialDAO;
    @Autowired
private PedidoDAO pedidoDAO;

public List<PedidoDTO> pedidosComercial(int id_Comercial) {
    Optional<List<PedidoDTO>> optList = pedidoDAO.findByComercial(id_Comercial);
if (optList.isPresent()) {
    return optList.get();
} else {
    return null;
}

}
    public  Integer pedidosTotales(){
        Integer total =  pedidoDAO.totalPedidos();
        return total;
    }

    public Double porcentajePedidos (int id_Comercial){
    Integer total = pedidosTotales();
    return  ((pedidosComercial(id_Comercial).size() / (double) total) * 100);
    }
    public List<Comercial> listAll() {
        return comercialDAO.getAll();
    }

    public Comercial one(Integer id) {
        Optional<Comercial> optCom = comercialDAO.find(id);
        if (optCom.isPresent())
            return optCom.get();
        else
            return null;
    }

    public void newComercial(Comercial comercial) {

        comercialDAO.create(comercial);

    }

    public void replaceComercial(Comercial comercial) {

        comercialDAO.update(comercial);

    }

    public void deleteComercial(int id) {

        comercialDAO.delete(id);

    }


}
