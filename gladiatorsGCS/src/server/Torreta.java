package server;

public class Torreta {
	String tipo;
    int ataque;
    int alcance;

    public Torreta(String tipo, int ataque, int alcance) {
    	this.tipo = tipo;
    	this.ataque = ataque;
    	this.alcance = alcance;
    }
    public void aumentarAtaque(int actual){
        ataque = actual+7;
    }

    public void aumentarAlcance(int actual){
        alcance = actual+2;
    }
}
