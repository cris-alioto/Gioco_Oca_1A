
import java.util.Scanner;

public class Gioco {

    private static Giocatori giocatore = new Giocatori();
    private static Tabellone tab = new Tabellone();

    public static void inizio(){
        Scanner in = new Scanner(System.in);
        String nome; char key;
        System.out.println(" Benvenuto nel gioco dell'oca! ");
        System.out.println("Premi 'c' per caricare una partita già esistente");
        System.out.println("premi 'n' per iniziare una nuova partita");
        do{ key = in.next().charAt(0); }while(key!='n' && key!='c');
        if(key=='c') Salvataggio.carica(giocatore);
        else{
            System.out.println("Inserisci il tuo nome: ");
            do{ nome = in.nextLine(); }while(nome.isEmpty());
            System.out.println(giocatore.aggiungiGiocatore(nome));
        }
        System.out.println("Buon divertimento!" + "\n");
    }

    public static void menù(){
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
                     if(giocatore.check()){
                         System.out.println("Inserisci il nome del giocatore: ");
                         do{ nome = in.nextLine(); }while(nome.isEmpty());
                         giocatore.aggiungiGiocatore(nome);
                     }
                     else System.out.println("Limite dei giocatori raggiunto");
                     menù(); return;
                 }
                 case 'm' -> { System.out.println(giocatore); }
                 case 's' -> { System.out.println(Salvataggio.salva(giocatore)); }
                 case 'e' -> { System.out.println(Salvataggio.esci(giocatore)); }
                 case 'q' -> { System.exit(0); }
             }
        }while(key!='g');
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char key;
        inizio();
        menù();
        do{
            System.out.print(giocatore.getTurno());
            System.out.println("Premi 't' per tirare i dadi");
            System.out.println("Premi 'm' per andare al menù principale");
            System.out.println("Premi 'q' per terminare il programma (per tutti)");
            do{ key = in.next().charAt(0); }while(key!='t' && key!='m');
            if(key=='m') menù();
            else System.out.println(giocatore.muovi());
        }while(key!='q');
    }

}
