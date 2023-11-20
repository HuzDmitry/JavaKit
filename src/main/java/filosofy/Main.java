package filosofy;

public class Main {
    public static void main(String[] args) {
        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Filosof filosof1 = new Filosof("Fil1", fork1, fork2);
        Filosof filosof2 = new Filosof("Fil2", fork2, fork1);
        filosof1.start();
        filosof2.start();
    }
}
