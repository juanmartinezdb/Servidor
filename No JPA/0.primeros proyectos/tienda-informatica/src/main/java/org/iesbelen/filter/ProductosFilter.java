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
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.iesbelen.model.Usuario;

/**
 * Servlet Filter implementation class ProductosFilter
 */
@WebFilter(
        urlPatterns = { "/tienda/productos/*" },
        initParams = {
                @WebInitParam(name = "acceso-concedido-a-rol", value = "administrador")
        })
public class ProductosFilter extends HttpFilter implements Filter {

    private String rolAcceso;

    /**
     * @see HttpFilter#HttpFilter()
     */
    public ProductosFilter() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
//CARGA EL ROL CONCEDIDO QUE ES ADMINISTRADOR ESTO LO PILLA DE LA ANOTACION
        this.rolAcceso = fConfig.getInitParameter("acceso-concedido-a-rol");
    }
    /**
     * @see Filter#destroy()
     */

    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        //Cast de ServletRequest a HttpServletRequest, el único tipo implementado
        //en el contenedor de Servlet: HttpServletRequest & HttpServletReponse
        HttpServletRequest httpRequest =(HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;


        //Accediendo al objeto de sesión
        HttpSession session = httpRequest.getSession();

        //Obteniendo la url
        String url = httpRequest.getRequestURL().toString();

        Usuario usuario = null;

        if (session != null
                && (usuario = (Usuario)session.getAttribute("usuario") )!= null
                && "administrador".equals(usuario.getRol())) {

            //Si eres administrador acceso a cualquier página del filtro
            chain.doFilter(request, response);
            return;

        } else if (url.endsWith("/productos/crear")
                || url.contains("/productos/editar")
                || url.contains("/productos/borrar")) {

            // Usuario no administrador trata de acceder a páginas de crear y editar, y el filtro lo redirige a login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/tienda/usuarios/login");
            return;

        } else {

            // Otras rutas /fabricantes y /fabricantes/{id} se dan paso a cualquier rol

            //RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/WEB-INF/jsp/productos.jsp");
            //dispatcher.forward(httpRequest, httpResponse);
            chain.doFilter(request, response);
            return;

        }
    }
}
