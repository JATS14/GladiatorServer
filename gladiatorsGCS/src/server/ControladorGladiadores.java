package server;

public class ControladorGladiadores {
	
	int tamanoPrimeraRonda  =         10;
	int edadMaxima =                  100;
	int probSupervivenciaMaxima =     100;
    int inteligenciaEmocionalMaxima = 100;
    int condFisicaMaxima =            100;
    int fuerzaSuperiorMaxima =        100;
    int fuerzaInferiorMaxima =        100;
    RandomNameGenerator rn = new RandomNameGenerator();
    
    public List<Gladiador> primeraGeneracionG(){
    	List<Gladiador> list = new List<Gladiador>();
    	for (int i = 0; i <= tamanoPrimeraRonda; i++ ) {
    		String name = rn.getRandomName();
    		int edad = (int) (Math.random() * (edadMaxima)) + 1;
    		int probSupervivencia = (int) (Math.random() * (probSupervivenciaMaxima)) + 1;
    		int generaciones = 1;
    		int inteligenciaEmocional = (int) (Math.random() * (inteligenciaEmocionalMaxima)) + 1;
    		int condFisica = (int) (Math.random() * (condFisicaMaxima)) + 1;
    		int fuerzaSuperior = (int) (Math.random() * (fuerzaSuperiorMaxima)) + 1;
    		int fuerzaInferior = (int) (Math.random() * (fuerzaInferiorMaxima)) + 1;
    		int x = 0;
    		int y = 0;
    		Gladiador gl = new Gladiador(name, edad, probSupervivencia,
    				generaciones, inteligenciaEmocional, condFisica,
    				fuerzaSuperior, fuerzaInferior , x , y);
    		list.addLast(gl);
    	}
    	return list;
    }
	

}
