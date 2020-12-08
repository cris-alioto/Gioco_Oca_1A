import java.util.Arrays;

public class Giocatori implements java.io.Serializable {

    private Giocatore[] n = new Giocatore[4];
    private int counter;
    private int turno;
    private int podio;

    /*
    è il Costruttore, inizializza i giocatori "vuoti"
     */
    public Giocatori(){
        counter = 0;
        podio = 0;
        turno = 0;
        for(int i = 0; i<4; i++) n[i] = new Giocatore("vuoto", false, 0, 0, 0);
    }

    /*
    è il toString
    @return restituisce una stringa che elenca i giocatori quando l'oggetto viene richiamato
     */
    @Override
    public String toString() {
        String giocatori = "Giocatori: " + "\n";
        for(int i = 0; i<4; i++) giocatori += n[i];
        return giocatori;
    }

    //Getters
    /* @return il turno attuale */
    public int getTurno(){ return turno; }

    /* @return il nome del giocatore che sta giocando */
    public String getNome(){ return n[turno].getNome(); }

    /* @return boolean bloccato del giocatore che sta giocando */
    public int getBloccato(){ return n[turno].getBloccato(); }

    /* @return una stringa che dice se il giocatore è bloccato oppure no */
    public String isBloccato(){
        if(getBloccato()!=0){
            if(getBloccato()>0)
                return "il giocatore è bloccato per altri " + getBloccato() + " turni";
            else return "il giocatore è nel pozzo";
        }
        return "il giocatore " + getNome() + " non è più bloccato";
    }

    /* @return il nome del giocatore che è sul podio */
    public String getPodio(){ return "Il giocatore " + n[podio].getNome() + " è sul podio con " + n[podio].getVittorie() + " vittore!"; }

    /* @return la posizione del giocatore che sta giocando */
    public int getPosizione(){ return n[turno].getPosizione(); }

    /* @return l'ultimo tiro di dadi che il giocatore attuale ha eseguito */
    public int getRisultato() { return n[turno].getRisultato(); }

    /* @return il numero di giocatori che sta giocando */
    public int getCounter(){ return counter; }

    /* @return l'array di Giocatore */
    public Giocatore[] getN(){ return n; }

    /*
     @param p è la posizione del giocatore
     @return il giocatore alla posizione p
     */
    public Giocatore getGiocatore(int p){ return n[p]; }

    //Setters
    /* @param p è la posizione che si vuole settare al giocatore attuale */
    public void setPosizione(int p){ n[turno].setPosizione(p); }

    /* @param b indica di quanto si vuole bloccare il giocatore (3,0,-1) */
    public void setBloccato(int b){ n[turno].setBloccato(b); }

    //

    /* @return boolean true se ci sono posti disponibili per aggiungere un giocatore */
    public boolean checkPosti(){
        if(counter>3){
            for(int i = 0; i<4; i++){
                if(!n[i].isOnline()) return true;
            }
            return false;
        }
        return true;
    }

    /*
     @param String nome indica il nome che si vuole dare al nuovo giocatore
     @return String che indica se il giocatore è stato aggiunto, sostituito oppure non c'erano posti
     */
    public String aggiungiGiocatore(String nome){
        String sost;
        if(counter<4){
            n[counter] = new Giocatore(nome);
            counter++;
            return "Il giocatore " + nome + " è stato aggiunto.";
        }
        for(int i = 0; i<4; i++){
            if(!n[i].isOnline()){
                sost = n[i].getNome();
                n[i] = new Giocatore(nome);
                return "Il giocatore " + sost + " è stato sostituito da " + nome + ".";
            }
        }
        return null;
    }

    /* @param sono i giocatori da caricare, vengono letti dal proprio file di salvataggio in Salvataggio.java */
    public void caricaGiocatori(Giocatore g0, Giocatore g1, Giocatore g2, Giocatore g3){
        n[0] = g0;
        n[1] = g1;
        n[2] = g2;
        n[3] = g3;
    }

    /* @return String getPodio() dopo aver aggiornato la classifica */
    public String aggiornaPodio(){
        int max = 0;
        for(int i = 0; i<3; i++){
            if(n[i].getVittorie()>n[i+1].getVittorie()) max = i;
            else max = i+1;
        }
        return getPodio();
    }

    /* va avanti di un turno escludendo gli offline */
    public void aggiornaTurno(){
        if(turno<3) turno++;
        else turno = 0;
        if(!n[turno].isOnline()) aggiornaTurno();
    }

    /* @return String che dice se il giocatore è ancora bloccato dopo averlo aggiornato */
    public String aggiornaBloccato(){
        setBloccato(getBloccato()-1);
        return isBloccato();
    }

    /* setta bloccato = 0 a chi era nel pozzo */
    public void azzeraPozzo(){
        for(int i = 0; i<4; i++){
            if(n[i].getBloccato()==-1) n[i].setBloccato(0);
        }
    }

    /* aumenta le vittorie del giocatore attuale di 1 */
    public void aggiornaVittoria(){ n[turno].setVittorie(n[turno].getVittorie()+1); }

    /* @return muovi() del giocatore attuale */
    public String muovi(){ return n[turno].muovi(); }

}
