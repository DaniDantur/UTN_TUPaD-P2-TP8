package tupad.danieldantur.tp8.ejercicio1;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Creando cliente...");
        Cliente cliente = new Cliente("Juan Pérez");
        System.out.println("Cliente creado: " + cliente.toString());
        System.out.println();

        System.out.println("--- Creando un nuevo pedido...");
        Pedido pedido = new Pedido();
        pedido.setNotificador(cliente);
        System.out.println("Pedido creado. " + pedido);
        System.out.println();

        System.out.println("--- Añadiendo productos al pedido...");
        Producto producto1 = new Producto("Laptop Pro", 1200.50);
        Producto producto2 = new Producto("Mouse Inalámbrico", 25.00);
        
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        System.out.println();

        System.out.println("--- Calculando el total del pedido...");
        double totalPedido = pedido.calcularTotal();
        System.out.println("El total del pedido es: $" + totalPedido);
        System.out.println();

        System.out.println("Paso 5A: Procesando pago con Tarjeta de Crédito...");
        TarjetaCredito tarjeta = new TarjetaCredito();
        if (tarjeta.procesarPago(totalPedido)){
            System.out.println("¡Pago con Tarjeta de Crédito aprobado!");
        }
        System.out.println();

        System.out.println("--- Procesando pago con PayPal...");
        PayPal paypal = new PayPal();

        if (paypal.procesarPago(paypal.aplicarDescuento(totalPedido))) {
            pedido.setEstado("PAGADO");
        }

        System.out.println();
        System.out.println("Proceso de compra finalizado.");
    }
}
