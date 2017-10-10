import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {

    public Position[] positions;

    public Queue() {

    }

    public void enqueue(Huluwa[] brothers) {


        positions = new Position[brothers.length];

        for (int i = 0; i < positions.length; i++) {
            positions[i] = new Position();
            positions[i].holder = brothers[i];
        }

    }


    public void rollCall(){
        for (Position p: this.positions){
            p.holder.report();
        }
        System.out.println();
        System.out.flush();
    }

    private void shuffle()
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = positions.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            Position position = positions[index];
            positions[index] = positions[i];
            positions[i] = position;
        }
    }


    public void insertSort() {
        Huluwa huluwa;
        int j;
        for (int i = 1; i < positions.length; i++) {
            huluwa = positions[i].holder;
            j = i - 1;
            //如果huluwa小于后端数，那后端的数要顺移
            while (j >= 0 && huluwa.seniority.ordinal() < positions[j].holder.seniority.ordinal()) {
                positions[j + 1].holder = positions[j--].holder;
            }
            positions[j + 1].holder = huluwa;
        }
    }

    public static void main(String[] args){

        Huluwa[] brothers = new Huluwa[7];
        for (int i=0;i<brothers.length;i++){
            brothers[i]= new Huluwa(COLOR.values()[i], SEIORITY.values()[i]);
        }

        Queue queue = new Queue();
        queue.enqueue(brothers);

        queue.rollCall();

        queue.shuffle();


        queue.rollCall();

        queue.insertSort();

        queue.rollCall();


    }
}

class Position {
    public Huluwa holder;

}

