public class Space2D {

    public static final int MAX_X=10;
    public static final int MAX_Y=10;

    private Position[][] positions;

    public Space2D(){

        super();
        positions = new Position[MAX_X][MAX_Y];

        for (int i = 0; i< MAX_X; i++){
            for (int j = 0; j< MAX_Y; j++){
                positions[i][j]= new Position(i,j);
            }
        }

    }

    public void print(){

    }

}
