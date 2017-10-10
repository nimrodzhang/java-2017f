public class Huluwa {

    private COLOR color;
    private SEIORITY seniority;
    private Position position;

    public COLOR getColor() {
        return color;
    }

    public SEIORITY getSeniority() {
        return seniority;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    Huluwa(COLOR color, SEIORITY seiority) {
        this.color = color;
        this.seniority = seiority;
    }

    public void report() {
        System.out.print(this.seniority.toString() + "(" + this.color.toString() + ")@" + this.position.getX() + ";");
    }

}

enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SEIORITY {
    一, 二, 三, 四, 五, 六, 七
}