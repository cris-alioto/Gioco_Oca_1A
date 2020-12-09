
import java.util.Scanner;

public class Gioco {

    /**
     * giocatore contiene l'oggetto Giocatori che agisce sui giocatori e sui turni
     * tab contiene il Tabellone che gestisce gli effetti delle caselle
     */
    private static Giocatori giocatore = new Giocatori();
    private static Tabellone tab = new Tabellone();

    /**
     * Serve solo all'inizio del gioco
     */
    public static void inizio(){
        Scanner in = new Scanner(System.in);
        String nome; char key;
        System.out.println(" Benvenuto nel gioco dell'oca! ");
        System.out.println("Premi 'c' per caricare una partita già esistente");
        System.out.println("premi 'n' per iniziare una nuova partita");
        do{ key = in.next().charAt(0); }while(key!='n' && key!='c');
        if(key=='c') System.out.println(Salvataggio.carica(giocatore));
        else{
            System.out.println("Inserisci il tuo nome: ");
            do{ nome = in.nextLine(); }while(nome.isEmpty());
            System.out.println(giocatore.aggiungiGiocatore(nome));
        }
        System.out.println("Buon divertimento!" + "\n");
    }

    /**
     * Rappresenta il menù di gioco
     */
    public static void menu(){
        Scanner in = new Scanner(System.in);
        String nome; char key;
        System.out.println(" ***             Menù             *** ");
        System.out.println("Premi 'g' per giocare");
        System.out.println("Premi 'a' per aggiungere un giocatore");
        System.out.println("Premi 'm' per mostrare i giocatori in partita");
        System.out.println("Premi 's' per salvare il gioco");
        System.out.println("Premi 'e' per uscire dal gioco");
        System.out.println("premi 'q' per terminare il gioco (per tutti)");
        do{
             key = in.next().charAt(0);
             switch(key){
                 case 'a' -> {
                     if(giocatore.checkPosti()){
                         System.out.println("Inserisci il nome del giocatore: ");
                         do{ nome = in.nextLine(); }while(nome.isEmpty());
                         giocatore.aggiungiGiocatore(nome);
                     }
                     else System.out.println("Limite dei giocatori raggiunto");
                     menu(); return;
                 }
                 case 'm' -> {
                     System.out.println(giocatore);
                     System.out.println(giocatore.aggiornaPodio());
                 }
                 case 's' -> { System.out.println(Salvataggio.salva(giocatore)); }
                 case 'e' -> { System.out.println(Salvataggio.esci(giocatore)); }
                 case 'q' -> { System.exit(0); }
             }
        }while(key!='g');
    }

    /**
     * Gestisce l'intero programma gestendo i turni, i giocatori e richiamando gli effetti delle caselle
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String temp; char key;
        inizio();
        do {
            menu();
            do {
                System.out.println("\nè il turno di " + giocatore.getNome() + '!');
                System.out.println("Premi 'c' per continuare");
                System.out.println("Premi 'm' per andare al menù principale");
                System.out.println("Premi 'q' per terminare la partita (per tutti)");
                do {
                    key = in.next().charAt(0);
                } while (key != 'c' && key != 'm' && key != 'q');
                if (key == 'm') menu();
                if (key == 'c') {
                    if (giocatore.isBloccato().equals("il giocatore " + giocatore.getNome() + " non è più bloccato")) {
                        System.out.println(giocatore.muovi());
                        if (giocatore.getPosizione() == 63) {
                            giocatore.aggiornaVittoria();
                            giocatore.aggiornaPodio();
                            key = 'q';
                        }
                        else System.out.println(tab.getPercorso()[giocatore.getN()[giocatore.getTurno()].getPosizione()].
                                fai_Effetto(giocatore, giocatore.getN(), giocatore.getCounter(),0));
                    } else System.out.println(giocatore.aggiornaBloccato());
                    giocatore.aggiornaTurno();
                }
            } while (key != 'q');
            System.out.println("vuoi/volete giocare di nuovo? s - n");
            do {
                key = in.next().charAt(0);
            } while (key != 's' && key != 'n');
        }while(key!='n');
    }

}
