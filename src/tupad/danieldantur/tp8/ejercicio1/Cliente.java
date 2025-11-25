package tupad.danieldantur.tp8.ejercicio1;

public class Cliente implements Notificable {
    private final String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("------------------------------------");
        System.out.println("--- Notificación para " + nombre + " ---");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("------------------------------------");
    }

    @Override
    public String toString() {
        return "Cliente: nombre=" + nombre;
    }
}
