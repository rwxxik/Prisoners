import java.util.ArrayList;
import java.util.List;

public class Box {
    private int id;
    private int note;

    public Box(int id, int note) {
        this.id = id;
        this.note = note;
    }

    public static List<Box> getBoxesList(int amount) {
        List<Box> boxes = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < amount; i++) {
            int index = (int) (Math.random() * numbers.size());
            boxes.add(new Box(i, numbers.get(index)));
            numbers.remove(index);
        }

        return boxes;
    }

    public int getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", note=" + note +
                '}';
    }
}
