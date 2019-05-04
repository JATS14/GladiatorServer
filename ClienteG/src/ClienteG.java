
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ClienteG {
	
	
	public String getPopulations()throws IOException {
		URL url = new URL("http://localhost:9080/gladiatorsGCS/population");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		InputStreamReader reader = new InputStreamReader((connection.getInputStream()));
		char[] buffer = new char[1024];
		int readChars = 0;
		StringBuilder builder = new StringBuilder();
		while((readChars = reader.read(buffer))>0) {
			builder.append(new String(buffer, 0, readChars));
		}
		return builder.toString();	
	}
	
	public String poblacionGladiadores() throws IOException {
		URL url = new URL("http://localhost:9080/gladiatorsGCS/population/gladiators");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		InputStreamReader reader = new InputStreamReader((connection.getInputStream()));
		char[] buffer = new char[1024];
		int readChars = 0;
		StringBuilder builder = new StringBuilder();
		while((readChars = reader.read(buffer))>0) {
			builder.append(new String(buffer, 0, readChars));
		}
		return builder.toString();
	}
	
	public String poblacionTorretas() throws IOException {
		URL url = new URL("http://localhost:9080/gladiatorsGCS/population/towers");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		InputStreamReader reader = new InputStreamReader((connection.getInputStream()));
		char[] buffer = new char[1024];
		int readChars = 0;
		StringBuilder builder = new StringBuilder();
		while((readChars = reader.read(buffer))>0) {
			builder.append(new String(buffer, 0, readChars));
		}
		return builder.toString();
	}
	
	public String postPoblacionGladiadoresStats(String poblacion) {
		try {
	        URL url = new URL("http://localhost:9080/gladiatorsGCS/population/gladiators");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        //String input = ListSerializer.toJsonString(json);
	        OutputStream os = conn.getOutputStream();
	        os.write(poblacion.getBytes());
	        os.flush();
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        String output = br.readLine();
	        conn.disconnect();
	        return output;
	        
	    } catch (MalformedURLException e) {
	    	System.out.println("Error de URL malformado");
	    	
	    } catch (IOException e) {
	    	System.out.println("Error de IO");
	    }
	 return null;
	}
	
	public String postPoblacionTorretasStats(String poblacionT) {
		try {
	        URL url = new URL("http://localhost:9080/gladiatorsGCS/population/towers");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        //String input = ListSerializer.toJsonString(json);
	        OutputStream os = conn.getOutputStream();
	        os.write(poblacionT.getBytes());
	        os.flush();
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        String output = br.readLine();
	        conn.disconnect();
	        return output;
	        
	    } catch (MalformedURLException e) {
	    	System.out.println("Error de URL malformado");
	    	
	    } catch (IOException e) {
	    	System.out.println("Error de IO");
	    }
	 return null;
	}
	

}
