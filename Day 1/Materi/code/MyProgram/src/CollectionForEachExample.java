import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class CollectionForEachExample {
    public static void main(String[] args) {
        // Contoh 1: ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apel");
        arrayList.add("Mangga");
        arrayList.add("Jeruk");
        System.out.println("ArrayList:");
        for (String buah : arrayList) {

            System.out.println(buah);
        }

        // Contoh 2: HashSet
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(30);
        System.out.println("\nHashSet:");
        for (int angka : hashSet) {
            System.out.println(angka);
        }
    }
}