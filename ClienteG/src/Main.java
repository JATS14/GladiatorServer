import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ClienteG clienteG = new ClienteG();
		String p = clienteG.getPopulations();
		System.out.println(p);
		
		String statsGladiadores = clienteG.poblacionGladiadores();
		System.out.println(statsGladiadores);
		
		String statsTorres = clienteG.poblacionTorretas();
		System.out.println(statsTorres);
		
		String nuevapoblaGladiadores = clienteG.postPoblacionGladiadoresStats("{Nombre: jis,Vida: 1,fuerza: 10,x: 0,y: 0}");
		System.out.println(nuevapoblaGladiadores);
		
		String nuevapoblaTorretas = clienteG.postPoblacionTorretasStats("{Nombre: jis,Vida: 1,fuerza: 10,x: 0,y: 0}");
		System.out.println(nuevapoblaTorretas);
		
	}

}
