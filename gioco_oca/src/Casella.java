
public class Casella {
    private Effetto effetto;
    private boolean speciale;

    public Casella(){
        this.effetto=Effetto.NULLA;
        this.speciale=false;
    }

    public Casella(Effetto effetto){
        this.effetto=effetto;
        this.speciale=true;
    }


    public String fai_Effetto(Giocatore g,Giocatore[] n,int counter,int w){
        if(speciale==false){return "casella normale";}
        else if (getEffetto()==Effetto.OCA) {
            int k=w;
            k++;
            g.setPosizione(g.getPosizione()+g.getRisultato());
            if(k==0){
                fai_Effetto(g,n,counter,k++);
            }
            return "vai avanti del tiro precedente ,posizione="+g.getPosizione();
        }
        else if(getEffetto()==Effetto.CASA){
            g.setBloccato(3);
            return"sei fermo per 3 turni";
        }
        else if(getEffetto()==Effetto.POZZO){
            g.azzeraPozzo();
            g.setBloccato(-1);
            return "fermi fino a quando non arriva nella casella un'altro giocatore";
        }
        else if(getEffetto()==Effetto.LABIRINTO){
            g.setPosizione(39);
            return "torni alla casella 39, posizione="+g.getPosizione();
        }
        else if(getEffetto()==Effetto.SCHELETRO){
            g.setPosizione(1);
            return "torna alla casella 1, posizione="+g.getPosizione();
        }
        else return "tocca al prossimo";
    }

    public Effetto getEffetto() { return effetto; }
    public void setEffetto(Effetto effetto) { this.effetto = effetto; }

}
