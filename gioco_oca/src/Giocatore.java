import java.util.Random;
public class Giocatore {

    String nome;
    boolean online;
    int posizione;
    int bloccato;
    int vittorie;

    int tiraDado() {
        Random rand = new Random();
        int a = rand.nextInt(6) + 1;
        int b = rand.nextInt(6) + 1;
        int c = a + b;
        return c;
    }
        String muovi(){
int dado=tiraDado();
posizione=posizione+dado;
return "il giocatore si muove di"+tiraDado()+"caselle";

        }
    public Giocatore(String nome){
        this.nome = nome;
    }


    public Giocatore(String nome, boolean online, int posizione, int bloccato, int vittorie) {
        this.nome = nome;
        this.online = online;
        this.posizione = posizione;
        this.bloccato = bloccato;
        this.vittorie = vittorie;
    }

    public String getNome() {
        return nome;
    }

    public boolean isOnline() {
        return online;
    }

    public int getPosizione() {
        return posizione;
    }

    public int getBloccato() {
        return bloccato;
    }

    public int getVittorie() {
        return vittorie;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public void setBloccato(int bloccato) {
        this.bloccato = bloccato;
    }

    public void setVittorie(int vittorie) {
        this.vittorie = vittorie;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "nome='" + nome + '\'' +
                ", online=" + online +
                ", posizione=" + posizione +
                ", bloccato=" + bloccato +
                ", vittorie=" + vittorie +
                '}';
    }

}
