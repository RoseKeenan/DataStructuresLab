import java.util.Iterator;

public class Josephus {

    public Josephus(int n, int k) {
        CircularLinkedList<Integer> soldiers = new CircularLinkedList<>();
        for(int j = 1; j <= n; j++) {
            soldiers.add(j);
        }


        // Added some debugging output so it's easier to test
        Iterator<Integer> iterator = soldiers.iterator();
        System.out.println(soldiers);
        while(soldiers.size > 2) {
            Integer deadSoldier = -1;
            for(int i = 0; i < k; i++) {
                deadSoldier = iterator.next();
            }
            System.out.println("Soldier " + deadSoldier + " died! =(");
            iterator.remove();
            System.out.println(soldiers);
        }

    }

    public static void main(String[] args) {

        Josephus one = new Josephus(13,3);
    }
}
