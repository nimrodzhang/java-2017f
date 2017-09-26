public class Queue {

    public Position[] positions;

    public Queue() {
        positions = new Position[0];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = new Position();
            positions[i].index = i;
            positions[i].holder = null;
        }
    }

    public void enqueue(Huluwa[] huluwas) {

        if (huluwas.length > this.positions.length) {
            return; //actually should throw exception
        }

        positions[1].holder = huluwas[0];
        positions[2].holder = huluwas[2];
        positions[3].holder = huluwas[6];
        positions[4].holder = huluwas[4];
        positions[5].holder = huluwas[3];
        positions[6].holder = huluwas[5];
        positions[7].holder = huluwas[5];

        //留个空位
        positions[0].holder = null;

        //...

    }

    public void sort() {

        Huluwa huluwa;
        int j;
        for (int i = 1; i < positions.length; i++) {
            huluwa = positions[i].holder;
            j = i - 1;
            //如果huluwa小于后端数，那后端的数要顺移
            while (j >= 0 && huluwa.seniority < positions[j].holder.seniority) {
                positions[j + 1].holder = positions[j--].holder;
            }
            //将huluwa插入到指定位置
            positions[j + 1].holder = huluwa;
        }
    }
}

class Position {
    public int index;
    public Huluwa holder;
}
