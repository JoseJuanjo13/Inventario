package co.edu.uniquindio.inventario.excepciones;

public class UsuarioServicioException extends RuntimeException{
    public UsuarioServicioException(String mensaje) {
        super(mensaje);
    }
}
