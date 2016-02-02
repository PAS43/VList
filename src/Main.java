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
            currentValue++;
        } else {
            amountOfLists++;
            currentValue = 0;
            referenceToLists.add(amountOfLists, new VList());
        }
    }


    public ArrayList<VList> getReferenceToLists() {
        return referenceToLists;
    }

    public void setReferenceToLists(ArrayList<VList> referenceToLists) {
        this.referenceToLists = referenceToLists;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public static void setAmountOfLists(int amountOfLists) {
        VList.amountOfLists = amountOfLists;
    }

    public static int getMaxValue() {
        return maxValue;
    }

    public int getAmountOfLists(){ return amountOfLists;}
}

class Number{
    Integer[] values = new Integer[5];
    int currentIndex = 0;

    public void add(Integer input){
        if(currentIndex < 5) {
            values[currentIndex] = input;
            currentIndex++;
        } else {
            System.out.println("Number Index Over 4");
        }
    }
}