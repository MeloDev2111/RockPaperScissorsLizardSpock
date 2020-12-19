package Modelo;

public enum OpcionesJugada {
    ROCK('R'), PAPER('P'), SCISSOR('S');
    private char caracter;
    
    OpcionesJugada(char c){
        this.caracter=c;
    }

    public char getCaracter() {
        return caracter;
    }
}
