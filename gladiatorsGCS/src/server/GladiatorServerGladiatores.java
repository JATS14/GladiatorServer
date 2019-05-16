package server;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/population/gladiators")
public class GladiatorServerGladiatores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final ServerDirector serverDirector = new ServerDirector();
	List<Gladiador> ListaActualGladiadores = new List<Gladiador>();
	
	
	 public GladiatorServerGladiatores() {
	        super();
	    }
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(ListaActualGladiadores.length() == 0) {
			 response.getWriter().println("Su respuesta se esta Procesando");
		 }else {
			String respuesta = serverDirector.getestadoGladiadores(ListaActualGladiadores);
			response.getWriter().println(respuesta);
			}
		}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BufferedReader a = request.getReader();
			String entrada = a.readLine();
			String[] accion = entrada.split(" ");
			String r = "";
			for(int i = 1; i < accion.length; i++) {
				r = r + accion[i];
			}
			String respg = serverDirector.obtenerNuevaGeneracionGladiadores(r);
			ListaActualGladiadores = serverDirector.ListaActualGladiadores;
			response.getWriter().println(respg);
	 }
	 

}
