
public class Tabellone {
    static  int Max_cas=63;
    Casella percorso[];

    public Tabellone(){
        percorso=new Casella[Max_cas];
        inizializzaCasella(percorso);
    }

    public Casella[] getPercorso() { return percorso; }
    public void setPercorso(Casella[] percorso) { this.percorso = percorso; }

    public void inizializzaCasella(Casella[] percorso){
        for(int i=0;i<Max_cas;i++){ //switch forse?
            if (i== 6 || i% 9 == 0 || i==5 || i%9==5) {
                percorso[i]=new Casella(Effetto.OCA);
            }
            else if(i==19){
                percorso[i]=new Casella(Effetto.CASA);
            }
            else if(i==31||i==52){
                percorso[i]=new Casella(Effetto.POZZO);
            }
            else if(i==42){
                percorso[i]=new Casella(Effetto.LABIRINTO);
            }
            else if(i==58){
              percorso[i]=new Casella(Effetto.SCHELETRO);
            }
            else percorso[i]=new Casella();
        }
    }

}
