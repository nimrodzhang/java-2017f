public class Huluwa {

    public COLOR color;
    public SEIORITY seniority;

    Huluwa(COLOR color, SEIORITY seiority){
        this.color = color;
        this.seniority = seiority;
    }

    public void report(){
        System.out.print(this.seniority.toString()+":"+this.color.toString()+"; ");
    }

}

enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SEIORITY {
    一, 二, 三, 四, 五, 六, 七
}