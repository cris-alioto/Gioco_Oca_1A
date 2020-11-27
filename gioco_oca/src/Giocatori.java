import java.util.Arrays;

public class Giocatori {

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
        for(int i = 0; i<4; i++) giocatori += n[i].getNome() + " | Online: " + n[i].isOnline() + "\n";
        return giocatori;
    }

    //Getters
    public String getTurno(){
        if(n[turno].isOnline) return "E' il turno di " + n[turno].getNome();
        aggiornaTurno();
        return getTurno();
    }

    public String getPodio(){
        return "Il giocatore " + n[podio].getNome() + " è sul podio con " + n[podio].getVittorie() + " vittore!";
    }

    //

    public boolean check(){
        if(counter>3){
            for(int i = 0; i<4; i++){
                if(!n[i].isOnline) return true;
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

    public String aggiornaPodio(){
        int max = 0;
        for(int i = 0; i<3; i++){
            if(n[i].getVittorie()>n[i+1].getVittorie) max = i;
            else max = i+1;
        }
        return getPodio();
    }

    public void aggiornaTurno(){
        if(turno<3) turno++;
        else turno = 0;
    }

    public String muovi(){
        String str;
        str = n[turno].muovi();
        aggiornaTurno();
        return str;
    }

}
