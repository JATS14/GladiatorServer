package server;

public class ControladorTorretas {
	//Para Primera Generacion
	int tamanoPrimeraRonda    = 10;
	int danoInferiorMax       = 100;
    int danoSuperiorMax       = 100;
    int potenciaMax           = 100;
    int tipobalaMax           = 100;
    int fuerzalanzadorMax     = 100;
    int velocidadlanzadorMax  = 100;
    int altotorreMax          = 100;
    RandomNameGeneratorTowers rn = new RandomNameGeneratorTowers();
    
  //Para genetico
    int cantidadEliminaryGenerar = 2;
    int cantidadMezclar = 2;
    int probabilidadMutacion = 50;
    int maximaMejoraEnMutacion = 50;
    
	public List<Torreta> primeraGeneracionT(){
		List<Torreta> list = new List<Torreta>();
		for (int i = 1; i <= tamanoPrimeraRonda; i++ ) {
    		String name = rn.getRandomName();
    		int danoInferior = (int) (Math.random() * (danoInferiorMax)) + 1;
    		int danoSuperior = (int) (Math.random() * (danoSuperiorMax)) + 1;
    		int generaciones = 1;
    		int potencia = (int) (Math.random() * (potenciaMax)) + 1;
    		int tipobala = (int) (Math.random() * (tipobalaMax)) + 1;
    		int fuerzalanzador = (int) (Math.random() * (fuerzalanzadorMax)) + 1;
    		int velocidadlanzador = (int) (Math.random() * (velocidadlanzadorMax)) + 1;
    		int altotorre = (int) (Math.random() * (altotorreMax)) + 1;
    		Torreta gl = new Torreta(name, generaciones, danoInferior,
    				danoSuperior, potencia, tipobala,
    				fuerzalanzador, velocidadlanzador , altotorre);
    		list.addLast(gl);
    	}
		return list;
	}
	public List<Torreta> aplicarFitness(List<Torreta> list){
    	for(int i = 0; i < (list.length()); i++) {
    		int cf = list.getData(i).danoInferior;int e = list.getData(i).danoSuperior;
    		int pS = list.getData(i).potencia;int iE = list.getData(i).tipobala;
    		int fS = list.getData(i).fuerzalanzador;int fI = list.getData(i).velocidadlanzador;
    		int x = list.getData(i).altotorre;int y = list.getData(i).dano;
    		int alc = list.getData(i).fitness;
    		int fit = cf + e + pS + iE + fS + fI + x + y + alc;
    		fit = fit / 9;
    		list.getData(i).fitness = fit;
    	}
    	return list;
    }
	public List<Torreta> algoritmoGenetico(List<Torreta> list){
    	aplicarFitness(list);
    	List<Torreta> listMejores = buscarMejores(list);
    	List<Torreta> nuevos = generarNuevosG(listMejores);
    	list = buscarPeoresyEliminarlos(list , nuevos);
    	return list;
    }
	
	public List<Torreta> buscarMejores(List<Torreta> list){
    	List<Torreta> listMejores = new List<Torreta>();
    	List<Torreta> list2 = selectionSort(list);
    	for (int i = 1; i <= cantidadMezclar; i++) {
    		listMejores.addLast(list2.getData(list2.length()-i));
    	}
    	return listMejores;
    }
	public List<Torreta> buscarPeoresyEliminarlos(List<Torreta> list, List<Torreta> nuevos){
    	List<Torreta> list2 = selectionSort(list);
    	for (int i = 0; i <= (cantidadEliminaryGenerar-1); i++) {
    		list2.changeData(i,nuevos.getData(i));
    	}
    	return list2;
    }
	 public List<Torreta> generarNuevosG(List<Torreta> listMejores){
	    	List<Torreta> nuevos = new List<Torreta>();
	    	for(int i = 0; i <= (cantidadEliminaryGenerar-1); i++) {
	    		String name = rn.getRandomName();
	    		int e = (int) (Math.random() * (listMejores.length()));int ps = (int) (Math.random() * (listMejores.length()));
	    		int g = (int) (Math.random() * (listMejores.length()));int ie = (int) (Math.random() * (listMejores.length()));
	    		int cf = (int) (Math.random() * (listMejores.length()));int fs = (int) (Math.random() * (listMejores.length()));
	    		int fi = (int) (Math.random() * (listMejores.length()));
	    		int danoInferior = listMejores.getData(e).danoInferior;                  danoInferior = mutacion(danoInferior);
	    		int danoSuperior = listMejores.getData(ps).danoSuperior;               danoSuperior = mutacion(danoSuperior);
	    		int generaciones = listMejores.getData(g).generaciones;
	    		int potencia = listMejores.getData(ie).potencia;                         potencia = mutacion(potencia);
	    		int tipobala = listMejores.getData(cf).tipobala;                         tipobala = mutacion(tipobala);
	    		int fuerzalanzador = listMejores.getData(fs).fuerzalanzador;             fuerzalanzador = mutacion(fuerzalanzador);
	    		int velocidadlanzador = listMejores.getData(fi).velocidadlanzador;       velocidadlanzador = mutacion(velocidadlanzador);
	    		int altotorre = listMejores.getData(fi).altotorre;                       altotorre = mutacion(altotorre);
	    	
	    		Torreta gl = new Torreta(name, generaciones, danoInferior,
	    				danoSuperior, potencia, tipobala,
	    				fuerzalanzador, velocidadlanzador , altotorre);
	    		nuevos.addLast(gl);
	    		
	    	}
	    	return nuevos;
	    }
	
	private int mutacion(int valor) {
    	int valorMutado = 0;
    	int pm = (int) (Math.random() * (100)) + 1;
    	if(pm <= probabilidadMutacion ) {
    		int mejora = (int) (Math.random() * (maximaMejoraEnMutacion)) + 1;
    		valorMutado = valor + mejora;
    	}else {
    		valorMutado = valor;
    	}
    	return valorMutado;
    }
	
	private List<Torreta> selectionSort(List<Torreta> list) {
		int n = list.length();
		for (int i = 0; i < (n-1); i++) {
			int mIndex = i;
			for (int j = i+1; j < n; j++) {
				if(list.getData(j).fitness < list.getData(mIndex).fitness) {
					mIndex = j;
				}	
			}
			Torreta temp = list.getData(mIndex);
			list.changeData(mIndex,list.getData(i));
			list.changeData(i,temp);
		}
		return list;
}
	public void printFitness(List<Torreta> list) {
    	String fit = "";
    	int suma = 0;
    	list = aplicarFitness(list);
    	for (int i = 0; i <= (list.length()-1);i++) {
    		if(fit == "") {
    			fit = Integer.toString(list.getData(i).fitness);
    		}else {
    		fit = fit + " - " + Integer.toString(list.getData(i).fitness);
    		}
    		suma = suma + list.getData(i).fitness;
    	}
    	
    	System.out.println("Lista: " + fit + ", Promedio General: " + (suma/(list.length()-1)) );
    }
	
	public String FitnessString(List<Torreta> list) {
    	String fit = "";
    	int suma = 0;
    	list = aplicarFitness(list);
    	for (int i = 0; i <= (list.length()-1);i++) {
    		if(fit == "") {
    			fit = Integer.toString(list.getData(i).fitness);
    		}else {
    		fit = fit + " - " + Integer.toString(list.getData(i).fitness);
    		}
    		suma = suma + list.getData(i).fitness;
    	}
    	String ret = "Lista: " + fit + ", Promedio General: " + (suma/(list.length()-1));
    	return ret;
    }
	
}
