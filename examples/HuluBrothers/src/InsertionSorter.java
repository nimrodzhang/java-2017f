public class InsertionSorter implements Sorter {
    @Override
    public void sort(Queue queue) {
        Position[] positions = queue.getPositions();
        Huluwa huluwa = null;
        int j;
        for (int i = 1; i < positions.length; i++) {
            for (j = i; j > 0; j--) {
                if (positions[j].getHolder().getSeniority().ordinal() < positions[j - 1].getHolder().getSeniority().ordinal()) {
                    huluwa = positions[j].getHolder();
                    positions[j - 1].getHolder().setPosition(positions[j]);
                    huluwa.setPosition(positions[j - 1]);
                }
            }
        }
    }
}
