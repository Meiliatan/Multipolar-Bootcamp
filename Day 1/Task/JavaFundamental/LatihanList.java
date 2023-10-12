import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LatihanList {
    public static void main(String[] args) {
        // Buat List angka
        List<Integer> A = Arrays.asList(1, 2, 3);
        List<Integer> B = Arrays.asList(2, 3, 4);

        //CARA CEPAT
        List<Integer> C = new ArrayList<Integer>(A);

        C.retainAll(B);
        System.out.println(C);

        //CARA PEMBANDINGAN


        // stream
        C = A.stream()
                .filter(B::contains)
                .collect(Collectors.toList());
    }

}

