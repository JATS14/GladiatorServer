package server;

public class ControladorTorretas {
	
	int ataqueMaximo =   1;
	int alcanceMaximo =  1;
	int tamanoPrimeraG = 6;
	
	public List<Torreta> primeraGeneracionT(){
		if (tamanoPrimeraG/2 != 00) {
			tamanoPrimeraG+=1;
		}
		List<Torreta> list = new List<Torreta>();
		for(int i = 0; i <= tamanoPrimeraG/3; i ++) {
			String tipo = "Sencilla";
			int ataque = 1;
			int alcance = 1;
			Torreta to = new Torreta(tipo,ataque,alcance);
			list.addLast(to);
		}
		for(int i = 0; i <= tamanoPrimeraG/3; i ++) {
			String tipo = "Fuego";
			int ataque = (int) (Math.random() * (ataqueMaximo)) + 1;
			int alcance = (int) (Math.random() * (alcanceMaximo)) + 1;
			Torreta to = new Torreta(tipo,ataque,alcance);
			list.addLast(to);
		}
		for(int i = 0; i <= tamanoPrimeraG/3; i ++) {
			String tipo = "Explosiva";
			int ataque = (int) (Math.random() * (ataqueMaximo)) + 1;
			int alcance = (int) (Math.random() * (alcanceMaximo)) + 1;
			Torreta to = new Torreta(tipo,ataque,alcance);
			list.addLast(to);
		}
		
		return list;
	}

}
