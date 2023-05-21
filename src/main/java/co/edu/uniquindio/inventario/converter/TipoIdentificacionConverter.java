package co.edu.uniquindio.inventario.converter;

import co.edu.uniquindio.inventario.entidades.TiposIdentificacion;
import co.edu.uniquindio.inventario.excepciones.ConverterException;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class TipoIdentificacionConverter implements Converter<TiposIdentificacion> {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
    public TiposIdentificacion getAsObject(FacesContext context, UIComponent component, String value) {
        TiposIdentificacion tiposIdentificacion;
        try {
            tiposIdentificacion = usuarioServicio.obtenerTipoIdentificacion(Integer.parseInt(value));
        } catch (Exception e) {
            throw new ConverterException(e.getMessage());
        }
        return tiposIdentificacion;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, TiposIdentificacion value) {
        if(value != null){
            return ""+value.getIdTipoIdentificacion();
        }
        return "";
    }
}
