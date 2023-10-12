public class MyVariable {
    public static void main(String[] args) {
        int umur; //deklarasi
        umur = 30; //inisiasi
        //Konstanta memiliki nilai tetap yang tidak dapat diubah setelah diinisialisasi.
        final double PI = 3.14159; //konstanta
        boolean javaMenyenangkan = true;
        char nilai = 'A';
        //Inferensi Tipe (Java 10+):
        var hitung = 42; // Disimpulkan sebagai int
        String nama = "John"; // String adalah sebuah kelas
        int[] angka = {1, 2, 3, 4}; // Array dari bilangan bulat
        System.out.println(nama);
    }
}