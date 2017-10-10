public class Position {

    private int x;

    public Huluwa getHolder() {
        return holder;
    }

    public void setHolder(Huluwa holder) {
        this.holder = holder;
    }

    private Huluwa holder;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Position(int x){
        super();
        this.x = x;
    }
}
