import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.io.*;

//Clase que controla la comunicacion con el servidor
//en java y en cliente en C++, por medio de sockets
public class ConeccionC implements Runnable{
	
	static ClienteG clienteg = new ClienteG();
	private static String population = "";
	private static String stadoGladiador = "";
	private static String stadoTorreta= "";
	private static String nuevaGG = "";
	private static String nuevaGT = "";
	

	public ConeccionC() {
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	public static void main(String[] args) throws IOException{
		new ConeccionC();
	}
	static private void getP() throws IOException {
		population= clienteg.getPopulations();
		return;
	}
	//Funcion que retorna los estados de los gladiadores con la clase
	// CLienteG
	static private void getstatsG() throws IOException{
		stadoGladiador = clienteg.poblacionGladiadores();
	}
	//Funcion que retorna los estados de las Torretas con la clase
		// CLienteG
	static private void getstatsT() throws IOException{
		stadoTorreta = clienteg.poblacionTorretas();
	}
	//Funcion que con un string en formato JSON de Objetos Gladiador
	//Retorna una lista sometida a un algorimo Genetico ,gracias a la clase
	// CLienteG
	static private void nuevaGG(String n) {
		nuevaGG = clienteg.postPoblacionGladiadoresStats(n);	
	}
	//Funcion que con un string en formato JSON de Objetos Torreta
	//Retorna una lista sometida a un algorimo Genetico ,gracias a la clase
	// CLienteG
	static private void nuevaGT(String n) {
		nuevaGT = clienteg.postPoblacionTorretasStats(n);	
	}
	//Creacion y manejo de Sockets
	@Override
	public void run() {
		int port = 6611;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while(true){
                try{
                    System.out.println("Waiting for connection on port: " + port + "\n");
                    Socket socket = serverSocket.accept();
                    OutputStream output = socket.getOutputStream();
                    PrintWriter wr = new PrintWriter(output, true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                    System.out.println("me cago en blen");
                    
                    String inputLine; 
                    inputLine = in.readLine();
                    //Get Population = 1
                    if (inputLine.startsWith("1")) {
                    	System.out.println(inputLine);

                    	getP();
                    	if(population != null) {
                    		wr.println(population);
                    	}
                    }//Get Gladiator Statis = 2
                    if (inputLine.startsWith("2")) {
                    	getP();
                    	getstatsG();
                    	wr.println(stadoGladiador);
                    }//Get Towers Stats = 3
                    if (inputLine.startsWith("3")) {
                    	getP();
                    	getstatsT();
                    	wr.println(stadoTorreta);
                    }//Post Gladiadores
                    if (inputLine.startsWith("$")) {
                    	String lista = inputLine.substring(1);
                    	nuevaGG(lista);
                    	wr.println(nuevaGG);
                    }//Post GladiadoresTorretas
                    if (inputLine.startsWith("#")) {
                    	String lista = inputLine.substring(1);
                    	nuevaGT(lista);
                    	wr.println(nuevaGT);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
      
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
}	
	

}
	
