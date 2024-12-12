package juan.proyectotienda.dao;

import juan.proyectotienda.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoDAO {
    public void create(Pedido pedido);
    public List<Pedido> getAll();
    public Optional<Pedido> find(int id);
    public void update(Pedido pedido);
    public void delete(int id);

    //no se si en update hacer esto o tener metodos diferentes
    //agregar articulo al pedido?
    //eliminar articulo del pedido?
    //modificar cantidad de articulos de un pedido?


}
