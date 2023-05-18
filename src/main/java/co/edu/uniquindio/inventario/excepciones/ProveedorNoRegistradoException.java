package co.edu.uniquindio.inventario.excepciones;

public class ProveedorNoRegistradoException extends RuntimeException{
    public ProveedorNoRegistradoException(String mensaje) {
        super(mensaje);
    }
}
