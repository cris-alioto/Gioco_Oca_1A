import java.util.Arrays;

public class Giocatori implements java.io.Serializable {

    private Giocatore[] n = new Giocatore[4];
    private int counter;
    private int turno;
    private int podio;

    public Giocatori(){
        counter = 0;
        podio = 0;
        turno = 0;
    }

    @Override
    public String toString() {
        String giocatori = "Giocatori: " + "\n";
        for(int i = 0; i<4; i++) giocatori += n[i].getNome() + " | Online: " + n[i].isOnline() + "\n" + "| vittorie: " + n[i].getVittorie() + " | posizione: " + n[i].getPosizione();
        return giocatori;
    }

    //Getters
    public int getTurno(){ return turno; }

    public String getNome(){ return n[turno].getNome(); }

    public String isBloccato(){
        if(n[turno].getBloccato()!=0){
            if(n[turno].getBloccato()>0)
                return "il giocatore è bloccato per altri " + n[turno].getBloccato() + " turni";
            else return "il giocatore è nel pozzo";
        }
        return null;
    }

    public String getPodio(){
        return "Il giocatore " + n[podio].getNome() + " è sul podio con " + n[podio].getVittorie() + " vittore!";
    }

    public int getPosizione(){
        return n[turno].getPosizione();
    }

    public boolean checkPosti(){
        if(counter>3){
            for(int i = 0; i<4; i++){
                if(!n[i].isOnline()) return true;
            }
            return false;
        }
        return true;
    }

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

    public void caricaGiocatori(Giocatore g0, Giocatore g1, Giocatore g2, Giocatore g3){
        n[0] = g0;
        n[1] = g1;
        n[2] = g2;
        n[3] = g3;
    }

    public Giocatore getGiocatori(int p){ return n[p]; }

    public String aggiornaPodio(){
        int max = 0;
        for(int i = 0; i<3; i++){
            if(n[i].getVittorie()>n[i+1].getVittorie()) max = i;
            else max = i+1;
        }
        return getPodio();
    }

    public void aggiornaTurno(){
        if(turno<3) turno++;
        else turno = 0;
        if(!n[turno].isOnline()) aggiornaTurno();
    }

    public String aggiornaBloccato(){
        n[turno].setBloccato(n[turno].getBloccato()-1);
        return isBloccato();
    }

    public void azzeraPozzo(){
        for(int i = 0; i<4; i++){
            if(n[i].getBloccato()==-1) n[i].setBloccato(0);
        }
    }

    public void aggiornaVittoria(){ n[turno].setVittorie(n[turno].getVittorie()+1); }
    public String muovi(){
        return n[turno].muovi();
    }

}
