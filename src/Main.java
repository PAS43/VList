import java.util.ArrayList;

/**
 * Created by Def on 02/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        VList v = new VList();

        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);
        v.add(60);
        v.add(70);
        v.add(80);
        v.add(90);
        v.add(100);
    }

}

class VList{
    private VList next;
    private ArrayList<Integer> numbers = new ArrayList();
    private int currentValue = 0;
    private static int amountOfLists = 0;
    private final static int maxValue = 5;

    public void add(Integer i){
        if(currentValue < maxValue) {
            numbers.add(currentValue, i);
            currentValue++;
        } else {
            amountOfLists++;
            currentValue = 0;
            next = new VList();
            

        }
    }

}
