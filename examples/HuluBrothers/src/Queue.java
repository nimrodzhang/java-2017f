public class Queue {

    public Position[] positions;

    public Queue(){
        for (int i=0;i <positions.length; i++){
            positions[i]= new Position();
            positions[i].index = i;
            positions[i].holder = null;
        }
    }

    public void enqueue(Object[] objects){

        if (objects.length > this.positions.length){
            return; //actually should throw exception
        }

        positions[0].holder = objects[1];
        //...


    }

}

class Position{
    public int index;
    public Object holder;
}
