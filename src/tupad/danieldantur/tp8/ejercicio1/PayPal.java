package tupad.danieldantur.tp8.ejercicio1;

public class PayPal implements PagoConDescuento {

    private double porcentajeDescuento = 10.0;
    
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " con PayPal.");
        return true;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto * (porcentajeDescuento / 100);
    }
}
