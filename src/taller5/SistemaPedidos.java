import java.util.ArrayList;

public class SistemaPedidos {
    private ArrayList<Handle<Pedido>> _pedidosPorId;
    private ListaEnlazada<Pedido> _pedidosPorLlegada;

    public SistemaPedidos(){
        _pedidosPorId = new ArrayList<>();
        _pedidosPorLlegada = new ListaEnlazada<>();
    }

    public void agregarPedido(Pedido pedido){
        Handle<Pedido> handle = _pedidosPorLlegada.agregarAtras(pedido);
        agregarOrdenado(handle);
    }

    private void agregarOrdenado(Handle<Pedido> p){
        if (_pedidosPorId.isEmpty()) {
            _pedidosPorId.add(p);
        }
        else {
            int i = 0;

            while (i < _pedidosPorId.size() && p.compareTo(_pedidosPorId.get(i)) < 0) {
                i++;
            }

            _pedidosPorId.add(i, p);
        }
    }

    public Pedido proximoPedidoPorId(){
        Handle<Pedido> ultimoHandle = _pedidosPorId.remove(_pedidosPorId.size()-1);
        Pedido pedido = ultimoHandle.valor();
        ultimoHandle.eliminar();

        return pedido;
    }

    public Pedido proximoPedidoPorLlegada(){
        Pedido pedido = _pedidosPorLlegada.obtenerPrimero();
        _pedidosPorLlegada.eliminar(0);

        int i = 0;

        while (_pedidosPorId.get(i).valor().compareTo(pedido) != 0) {
            i++;
        }

        _pedidosPorId.remove(i);

        return pedido;
    }

    public Pedido pedidoMenorId(){
        return _pedidosPorId.get(_pedidosPorId.size()-1).valor();
    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        return _pedidosPorLlegada.toString();
    }

    public String obtenerPedidosOrdenadosPorId(){
        String res = "[";

        for (int i = _pedidosPorId.size()-1; i > 0; i--) {
            res += _pedidosPorId.get(i).valor().toString() + ", ";
        }

        if (!_pedidosPorId.isEmpty()) {
            res += _pedidosPorId.get(0).valor().toString() + "]";
        } else {
            res += "]";
        }

        return res;
    }
}
