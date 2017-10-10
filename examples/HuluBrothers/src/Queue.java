import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {


    private Position[] positions;

    public Position[] getPositions() {
        return positions;
    }


    public Huluwa[] getBrothers() {
        return brothers;
    }



    private Huluwa[] brothers;

    public Queue(Huluwa[] brothers) {


        this.positions = new Position[brothers.length];

        this.brothers = brothers;

        for (int i = 0; i < brothers.length; i++) {

            this.positions[i] = new Position(i);
            this.brothers[i].setPosition(this.positions[i]);
        }
    }


    public void rollCall() {
        for (Huluwa huluwa : this.brothers) {
            huluwa.report();
        }
        System.out.println();
        System.out.flush();

        for (Position position : this.positions) {

            position.getHolder().report();
        }

        System.out.println("\n");
        System.out.flush();
    }

    private void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = brothers.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position position = brothers[index].getPosition();
            brothers[index].setPosition(brothers[i].getPosition());
            brothers[i].setPosition(position);
        }
    }

    public static void main(String[] args) {

        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SEIORITY.values()[i]);
        }

        Queue queue = new Queue(brothers);

        queue.rollCall();

        queue.shuffle();


        queue.rollCall();

        new InsertionSorter().sort(queue);

        queue.rollCall();

        queue.shuffle();


        queue.rollCall();

        new BubbleSorter().sort(queue);
        queue.rollCall();


    }
}

