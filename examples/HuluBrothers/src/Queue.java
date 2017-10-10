import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {


    private Position[] positions;

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


    public void insertSort() {
        Huluwa huluwa = null;
        int j;
        for (int i = 1; i < this.positions.length; i++) {
            for (j = i; j > 0; j--) {
                if (positions[j].getHolder().getSeniority().ordinal() < positions[j - 1].getHolder().getSeniority().ordinal()) {
                    huluwa = positions[j].getHolder();
                    positions[j - 1].getHolder().setPosition(positions[j]);
                    huluwa.setPosition(positions[j - 1]);
                }
            }
        }
    }

    public void bubbleSort() {

        Huluwa huluwa;
        for (int i = 0; i < positions.length - 1; i++) {
            for (int j = 0; j < positions.length - 1 - i; j++) {
                if (positions[j].getHolder().getSeniority().ordinal() > positions[j + 1].getHolder().getSeniority().ordinal()) {
                    huluwa = positions[j].getHolder();
                    positions[j + 1].getHolder().setPosition(positions[j]);
                    huluwa.setPosition(positions[j + 1]);
                }
            }
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

        queue.insertSort();

        queue.rollCall();

        queue.shuffle();


        queue.rollCall();

        queue.bubbleSort();

        queue.rollCall();


    }
}

