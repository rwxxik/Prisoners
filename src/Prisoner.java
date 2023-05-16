import java.util.ArrayList;
import java.util.List;

public class Prisoner {
    private int id;
    private boolean match;

    public Prisoner(int id) {
        this.id = id;
        this.match = false;
    }



    public static List<Prisoner> getPrisonerList(int amount) {
        List<Prisoner> prisonerList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            prisonerList.add(new Prisoner(i));
        }
        return prisonerList;
    }

    public boolean isMatchSuccsess(Box box) {
        if (this.id == box.getNote()) {
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public boolean getMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "id=" + id +
                ", match=" + match +
                '}';
    }
}
