package co.edu.uniquindio.inventario.Excepciones;

public class BodegaNoRegistradaException extends RuntimeException {
    public BodegaNoRegistradaException(String mensaje) {
        super(mensaje);
    }
}
