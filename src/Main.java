import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prisoner> prisoners = Prisoner.getPrisonerList(100);

        int attempts = 1000;



        int randomSuccessCount = 0;
        int strategySuccessCount = 0;

        for (int i = 1; i <= attempts; i++) {
            List<Box> boxes = Box.getBoxesList(100);
            startRandomPrisonersTest(boxes, prisoners);
            if (countResults(prisoners, i, "randomly")) {
                randomSuccessCount++;
            }
            startStrategyPrisonersTest(boxes, prisoners);
            if (countResults(prisoners, i, "strategy")) {
                strategySuccessCount++;
            }
        }
        System.out.println("---------------------");
        System.out.println("Total attempts = " + attempts);
        System.out.println("Total random success = " + randomSuccessCount);
        System.out.println("Total strategy success = " + strategySuccessCount);
    }

    public static void startRandomPrisonersTest(List<Box> boxes, List<Prisoner> prisoners) {
        for (Prisoner prisoner :
                prisoners) {
            List<Box> copyOfBoxes = new ArrayList<>(boxes);
            while (copyOfBoxes.size() > 50) {
                int index = (int) (Math.random() * copyOfBoxes.size());
                if (prisoner.isMatchSuccsess(copyOfBoxes.get(index))) {
                    prisoner.setMatch(true);
//                    System.out.println("He got it!");
                    break;
                }
                copyOfBoxes.remove(index);
            }
        }
    }

    public static void startStrategyPrisonersTest(List<Box> boxes, List<Prisoner> prisoners) {
        for (Prisoner prisoner :
                prisoners) {
            int attemptCount = 50;
            int index = prisoner.getId();
            while (attemptCount > 0) {
                if (prisoner.isMatchSuccsess(boxes.get(index))) {
//                    System.out.println("He got it!");
                    prisoner.setMatch(true);
                    break;
                }
                index = boxes.get(index).getNote();
                attemptCount--;

            }
        }
    }

    public static boolean countResults(List<Prisoner> prisoners, int counter, String method) {
        int prisonersPassed = 0;
        for (Prisoner prisoner :
                prisoners) {
            if (prisoner.getMatch()) {
                prisonersPassed++;
            }
            prisoner.setMatch(false);
        }
        boolean result = false;
        if (prisonersPassed == prisoners.size()) {
            result = true;
        }
        System.out.printf("Method=%s attempt=%s passed=%s result=%s \n",
                method, counter, prisonersPassed, result);
        return result;
    }
}