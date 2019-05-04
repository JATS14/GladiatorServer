package server;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/population/towers")
public class GladiatorServerTorretas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final ServerDirector serverDirector = new ServerDirector();
	
	 public GladiatorServerTorretas() {
	        super();
	    }
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String respuesta = serverDirector.getstadoTorretas();
			response.getWriter().println(respuesta);
		}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BufferedReader a = request.getReader();
			String entrada = a.readLine();
			String[] accion = entrada.split(" ");
			String r = "";
			for(int i = 1; i < accion.length; i++) {
				r = r + accion[i];
			}
			String respT = serverDirector.obtenerNuevaGeneracionTorretas(r);
			response.getWriter().println(respT);
	 }
	
}
