public class BubbleSorter implements  Sorter {
    @Override
    public void sort(Queue queue) {
        Huluwa huluwa;
        Position[] positions = queue.getPositions();

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
}
