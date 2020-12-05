import java.io.*;
public class implements Serializable Salvataggio {
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
        try {
        FileOutputStream fileOut =
        new FileOutputStream("salvataggio.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(e);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in salvataggio.ser");
        } catch (IOException i) {
        i.printStackTrace();
        }
        }
        }
    }
    public static String Carica (Giocatori g) {
    //questo metodo carica la posizione dei giocatori
        Giocatore n1 = g.setGiocatore(1);
        Giocatore n2 = g.setGiocatore(2);
        Giocatore n3 = g.setGiocatore(3);
        Giocatore n4 = g.setGiocatore(4);
        g.setTurno();
        g.setPodio();

        try {
        FileInputStream fileIn = new FileInputStream("salvataggio.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        g = (Giocatore) in.readObject();
        in.close();
        fileIn.close();
        } catch (IOException i) {
        i.printStackTrace();
        return;
        } catch (ClassNotFoundException c) {
        System.out.println("ERRORE SALVATAGGIO NOT FOUND");
        c.printStackTrace();
        return;
        }
    }
    public static String Esci (Giocatori g) {
    //questo metodo fa uscire il giocatore
    }
}
