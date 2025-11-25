package tupad.danieldantur.tp8.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable {

    private final List<Producto> productos;
    private Notificable notificador;
    private String estado;

    public Pedido() {
        this.productos = new ArrayList<>();
        this.estado = "PENDIENTE";
    }

    public void setNotificador(Notificable notificador) {
        this.notificador = notificador;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        if (notificador != null) {
            notificador.notificar("Se ha añadido el producto " + producto.getNombre() + " a su pedido.");
        }
    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.calcularTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido con " + productos.size() + " productos. Estado: " + estado;
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        if (notificador != null) {
            notificador.notificar("El estado de su pedido ha cambiado a: " + nuevoEstado);
        }
    }
}
