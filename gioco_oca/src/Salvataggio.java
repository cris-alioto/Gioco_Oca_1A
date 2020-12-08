import java.io.*;

public class Salvataggio implements Serializable {
    public static String salva (Giocatori g) {
        //questo metodo salva la posizione dei giocatori
        Giocatore n1 = g.getGiocatore(1);
        Giocatore n2 = g.getGiocatore(2);
        Giocatore n3 = g.getGiocatore(3);
        Giocatore n4 = g.getGiocatore(4);
        try {
            FileOutputStream fileOut = new FileOutputStream("salvataggio.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in salvataggio.ser");
        } catch (IOException i) {
            i.printStackTrace();
            return "Salvataggio non riuscito";
        }
        return "Salvataggio riuscito";
    }

    public static String carica (Giocatori g) {
    //questo metodo carica la posizione dei giocatori
        //Giocatore n1 = g.setGiocatore(1);  -> sta roba non fa nulla, il set serve a caricare i dati quindi
        //Giocatore n2 = g.setGiocatore(2);  -> nei parametri devi passare il giocatore, non il numero del giocatore
        //Giocatore n3 = g.setGiocatore(3);  -> quindi prima leggi i vari giocatori dal salvataggio.ser
        //Giocatore n4 = g.setGiocatore(4);  -> p.s. fai un file .ser per ogni oggetto
        //g.setTurno();    -> dopo averli letti, assegnandoli a g per i giocatori e n1, n2, n3, n4 per
        //g.setPodio();    -> il giocatore singolo allora passi n1, n2, n3 e n4 come par in g.setGiocatore();

        try {
            FileInputStream fileIn = new FileInputStream("salvataggio.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //g = (Giocatore) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return "Carica del salvataggio non riuscito";
        } catch (NoClassDefFoundError c) {
            c.printStackTrace();
            return "Carica del salvataggio non riuscito";
        }
        return "Carica del salvataggio riuscita";
    }

    public static String esci (Giocatori g) {
        //fai la roba qui
        return "Il giocatore è uscito";
    }
}
