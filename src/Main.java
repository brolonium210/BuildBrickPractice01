import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list1;
        String[] arr1 = {"a", "b", "c", "d", "e", "f", "g", "h"};
        ListsAndStuff listsAndStuff = new ListsAndStuff();
        list1 = listsAndStuff.makeBasicLi(arr1);
        System.out.println(list1.size());
    }
}