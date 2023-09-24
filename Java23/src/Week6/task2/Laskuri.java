package Week6.task2;

public class Laskuri extends Thread {
    private int summa = 0;
    private int[] taulukko;
    private int alku;
    private int loppu;

    public Laskuri(int[] taulukko, int alku, int loppu) {
        this.taulukko = taulukko;
        this.alku = alku;
        this.loppu = loppu;
    }

    public int getSumma() {
        return summa;
    }

    @Override
    public void run() {
        for (int i = alku; i < loppu; i++) {
            summa += taulukko[i];
        }
    }
    
}
