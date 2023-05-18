package co.edu.uniquindio.inventario.excepciones;

public class BodegaNoRegistradaException extends RuntimeException {
    public BodegaNoRegistradaException(String mensaje) {
        super(mensaje);
    }
}
