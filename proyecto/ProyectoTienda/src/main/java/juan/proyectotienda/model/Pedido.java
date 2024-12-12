package juan.proyectotienda.model;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private List<Producto> productos;
    private Date fecha;
    private double total;


}
