import java.util.ArrayList;
import java.util.Random;

/**
 * Created by PAS43 on 02/02/2016.
 *
 * VList
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.test();
        System.out.println("stop");
    }

    public void test(){
        VList v = new VList();
        Random r = new Random();
        for(int i = 0; i < 1000; i++){
            v.add(r.nextInt(100));
        }

    }
}

class VList{

    private ArrayList<VList> referenceToLists = new ArrayList<>();
    private Number values = new Number();
    private int currentValue = 0;
    private static int amountOfLists = 0;
    private final static int maxValue = 5;

    VList(){
        referenceToLists.add(this);
    }

    public void add(Integer i){
        if(referenceToLists.get(amountOfLists).getCurrentValue() < maxValue) {
            referenceToLists.get(amountOfLists).values.add(i);
            referenceToLists.get(amountOfLists).incCurrentValue();
        } else {
            referenceToLists.get(amountOfLists).incCurrentValue();
            referenceToLists.get(amountOfLists).setCurrentView(0);
            referenceToLists.add(amountOfLists, new VList());
            referenceToLists.get(amountOfLists).values.add(i);

        }
    }
    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentView(int i){
        this.currentValue = i;
    }

    public void incCurrentValue(){
        currentValue += 1;
    }
}

class Number{
    Integer[] values = new Integer[5];
    int currentIndex = 0;

    public void add(Integer input){
        if(currentIndex < 5) {
            values[currentIndex] = input;
            currentIndex++;
        } else {
            currentIndex = 0;
            System.out.println("Number Index Over 4");
        }
    }
}