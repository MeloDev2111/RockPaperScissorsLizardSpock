package Modelo;

class Logica {

    Jugada analizar(Jugada jugada_Jugador1, Jugada jugada_Jugador2) {
        switch (jugada_Jugador1.getJugada_Seleccionada()) {
            case ROCK:
                switch (jugada_Jugador2.getJugada_Seleccionada()) {
                    case ROCK:
                        return null;
                    case PAPER:
                        return jugada_Jugador2;
                    case SCISSOR:
                        return jugada_Jugador1;
                }
                break;

            case PAPER:
                switch (jugada_Jugador2.getJugada_Seleccionada()) {
                    case ROCK:
                        return jugada_Jugador1;
                    case PAPER:
                        return null;
                    case SCISSOR:
                        return jugada_Jugador2;
                }
                break;

            case SCISSOR:
                switch (jugada_Jugador2.getJugada_Seleccionada()) {
                    case ROCK:
                        return jugada_Jugador2;
                    case PAPER:
                        return jugada_Jugador1;
                    case SCISSOR:
                        return null;
                }

        }
        System.out.println("ESTO NO TIENE QUE PASAR - REVISA LOGICA.ANALIZAR()");
        return null;
    };
    
}
