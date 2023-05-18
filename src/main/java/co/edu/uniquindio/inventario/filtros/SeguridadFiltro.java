package co.edu.uniquindio.inventario.filtros;

import co.edu.uniquindio.inventario.bean.SeguridadBean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class SeguridadFiltro implements Filter {

    private static final Logger logger = Logger.getLogger(SeguridadFiltro.class.getName());
    public static final String PAGINA_INICIO = "/index.xhtml";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            final HttpServletRequest request = (HttpServletRequest) servletRequest;
            final HttpServletResponse response = (HttpServletResponse) servletResponse;
            final String requestURI = request.getRequestURI();
            //Aplicar el filtro a esta carpeta
            if (requestURI.startsWith("/dispensacion/") || requestURI.startsWith("/parametricas/") ) {
                //Obtenemos el objeto seguridadBean de la sesión actual
                SeguridadBean userManager = (SeguridadBean) request.getSession().getAttribute("seguridadBean");
                if (userManager != null) {
                    if (userManager.isAutenticado()) {
                    //El usuario está logueado entonces si puede ver la página solicitada
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                    //El usuario no está logueado, entonces se redirecciona al inicio
                        response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                    }
                } else {
                    //El usuario no está logueado, entonces se redirecciona al inicio
                    response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                }
            } else {
            //La página solicitada no está en la carpeta /usuario entonces el filtro no  aplica
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (Exception e) {
            logger.severe("Ocurrió una excepción: " + e.getMessage());
        }
    }
}
