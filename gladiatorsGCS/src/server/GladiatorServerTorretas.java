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
	List<Torreta> ListaActualTorretas = new List<Torreta>();
	
	 public GladiatorServerTorretas() {
	        super();
	    }
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Torreta> T = DataBase.getLAT();
		 if(T.length() == 0) {
			 response.getWriter().println("Su respuesta se esta Procesando");
		 }else {
			String respuesta = serverDirector.getstadoTorretas(T);
			response.getWriter().println(respuesta);
		 }
		}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BufferedReader a = request.getReader();
			String entrada = a.readLine();
			String respT = serverDirector.obtenerNuevaGeneracionTorretas(entrada);
			List<Torreta> To = serverDirector.deserializarT(respT);
			DataBase.changeLAT(To);
			response.getWriter().println(respT);
	 }
	
}
