package Week6.Synchronization.task2;
public class Main {
    public static void main(String[] args) {
        int[] taulukko = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int alku1 = 0;
        int loppu1 = 5;
        int alku2 = 5;
        int loppu2 = 10;

        Laskuri laskuri1 = new Laskuri(taulukko, alku1, loppu1);
        Laskuri laskuri2 = new Laskuri(taulukko, alku2, loppu2);

        laskuri1.start();
        laskuri2.start();

        try {
            laskuri1.join();
            laskuri2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Summa 1: " + laskuri1.getSumma());
        System.out.println("Summa 2: " + laskuri2.getSumma());
    }

}
