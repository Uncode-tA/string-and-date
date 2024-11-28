import java.text.SimpleDateFormat; // Import untuk memformat tanggal dan waktu
import java.util.Date; // Import untuk mendapatkan waktu saat ini
import java.util.Scanner; // Import untuk membaca input dari pengguna

// Parent class untuk informasi dasar transaksi
class Transaksi {
    protected String noFaktur; // Nomor faktur transaksi
    protected String kodeBarang; // Kode barang
    protected String namaBarang; // Nama barang
    protected double hargaBarang; // Harga barang
    protected int jumlahBeli; // Jumlah barang yang dibeli

    // Konstruktor untuk menginisialisasi data transaksi
    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        this.noFaktur = noFaktur; // Inisialisasi nomor faktur
        this.kodeBarang = kodeBarang; // Inisialisasi kode barang
        this.namaBarang = namaBarang; // Inisialisasi nama barang
        this.hargaBarang = hargaBarang; // Inisialisasi harga barang
        this.jumlahBeli = jumlahBeli; // Inisialisasi jumlah beli
    }

    // Method untuk menghitung total harga (harga barang * jumlah beli)
    public double hitungTotal() {
        return hargaBarang * jumlahBeli; // Mengembalikan hasil perkalian harga dan jumlah beli
    }
}

// Subclass untuk validasi transaksi (Inheritance)
class TransaksiValidasi extends Transaksi {

    // Konstruktor untuk menginisialisasi data transaksi (memanggil konstruktor parent class)
    public TransaksiValidasi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli); // Memanggil konstruktor dari parent class
    }

    // Method untuk validasi input data transaksi
    public void validasiInput() throws Exception {
        if (hargaBarang < 0) { // Validasi jika harga barang negatif
            throw new Exception("Harga barang tidak boleh negatif!"); // Melempar exception jika harga invalid
        }
        if (jumlahBeli <= 0) { // Validasi jika jumlah beli kurang dari atau sama dengan nol
            throw new Exception("Jumlah beli harus lebih besar dari 0!"); // Melempar exception jika jumlah invalid
        }
    }
}

// Main class (kelas utama dengan method main)
public class ProgramTransaksi {

    // Method untuk mendapatkan waktu saat ini
    public static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Format tanggal dan waktu
        return formatter.format(new Date()); // Mengembalikan waktu saat ini dalam format yang diatur
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna

        // Bagian login
        String username = "Trici"; // Username yang valid
        String password = "101010"; // Password yang valid
        boolean loginSuccess = false; // Status login

        System.out.println("=== LOGIN MODERNMART ===");
        while (!loginSuccess) {
            System.out.print("Username: ");
            String inputUsername = scanner.nextLine(); // Membaca input username

            System.out.print("Password: ");
            String inputPassword = scanner.nextLine(); // Membaca input password

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                loginSuccess = true; // Login berhasil
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Login gagal. Silakan coba lagi."); // Login gagal, ulangi
            }
        }

        try {
            System.out.println("\n=== Transaksi ==="); // 
            System.out.println("Tanggal dan Waktu: " + getCurrentDateTime()); // Menampilkan waktu saat ini

            // Input data transaksi dari pengguna
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine(); // Membaca nomor faktur

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine(); // Membaca kode barang

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine(); // Membaca nama barang

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble(); // Membaca harga barang

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt(); // Membaca jumlah beli

            // Membuat objek transaksi dengan data yang diinputkan
            TransaksiValidasi transaksi = new TransaksiValidasi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Melakukan validasi input data
            transaksi.validasiInput();

            // Menghitung total harga transaksi
            double total = transaksi.hitungTotal();

            // Menampilkan detail transaksi
            System.out.println("\n=== Selamat Datang Di MODERNMART ===");
            System.out.println("Tanggal dan Waktu: " + getCurrentDateTime()); // Menampilkan waktu saat ini
            System.out.println("No Faktur       : " + transaksi.noFaktur); // Menampilkan nomor faktur
            System.out.println("Kode Barang     : " + transaksi.kodeBarang); // Menampilkan kode barang
            System.out.println("Nama Barang     : " + transaksi.namaBarang); // Menampilkan nama barang
            System.out.println("Harga Barang    : " + transaksi.hargaBarang); // Menampilkan harga barang
            System.out.println("Jumlah Beli     : " + transaksi.jumlahBeli); // Menampilkan jumlah beli
            System.out.println("TOTAL           : " + total); // Menampilkan total harga
            System.out.println("Kasir           : Trici"); // Menampilkan nama kasir
            System.out.println("=============================================");
        } catch (Exception e) {
            // Menangani kesalahan input atau validasi
            System.out.println("Kesalahan: " + e.getMessage()); // Menampilkan pesan kesalahan
        } finally {
            // Menutup scanner untuk mencegah kebocoran resource
            scanner.close();
        }
    }
}
