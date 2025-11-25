package tupad.danieldantur.tp8.ejercicio1;

public class TarjetaCredito implements PagoConDescuento {
    
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " con Tarjeta de Crédito.");
        return true;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto;
    }
}
