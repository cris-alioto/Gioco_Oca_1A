import java.io.*;
public class Salvataggio {
    public static String Salva (Giocatori g) {
    //questo metodo salva la posizione dei giocatori
        try{
            Giocatore n1 = g.getGiocatore(1);
            Giocatore n2 = g.getGiocatore(2);
            Giocatore n3 = g.getGiocatore(3);
            Giocatore n4 = g.getGiocatore(4);
            g.getTurno();
            g.getPodio();
            //visto che per questa parte mi sono avventurato nell'internet indonesiano, non mi aspetto che sia
            //molto comprensibile. Enjoy
        FileWriter fstream = new FileWriter("Salvataggio.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        out.write("Qui inserirò le informazioni del giocatore");
        out.close();}
    }
    public static String Carica (Giocatori g) {
    //questo metodo carica la posizione dei giocatori
        Giocatore n1 = g.setGiocatore(1);
        Giocatore n2 = g.setGiocatore(2);
        Giocatore n3 = g.setGiocatore(3);
        Giocatore n4 = g.setGiocatore(4);
        g.setTurno();
        g.setPodio();
    }
    public static String Esci (Giocatori g) {
    //questo metodo fa uscire il giocatore
    }
}
