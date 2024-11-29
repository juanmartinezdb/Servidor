package org.iesbelen.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(
        urlPatterns = "/usuarios/*",
        initParams = @WebInitParam(name = "acceso-concedido-a-rol", value = "administrador")
)
public class UsuariosFilter implements Filter {

    private String rolAcceso;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

 /*
TO-DO Leer de filterConfig el init-param acceso-concedido-a-rol y guardar en variable privada
*/
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

 /*
TO-DO Control de sesión con usuario con rol de administrador.
 si no existe bean usuario en sesión o el bean es de rol distinto de administrador realiza un response.sendRedirect LOGIN
 si el bean de usuario en sesión es de tipo administrador hacer

chain.doFilter(request, response);
*/

    }

    @Override
    public void destroy() {

    }
}

