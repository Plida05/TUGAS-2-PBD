import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Menu[] daftarMenu = new Menu[100];
    static int jumlahMenu = 0;

    public static void main(String[] args) {
        inisialisasiMenu();

        int pilihan;
        do {
            System.out.println("\n===== APLIKASI RESTORAN =====");
            System.out.println("1. Menu Pelanggan");
            System.out.println("2. Menu Pemilik Restoran");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> menuPelanggan();
                case 2 -> menuPemilik();
                case 3 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);
    }

    static void inisialisasiMenu() {
        daftarMenu[jumlahMenu++] = new Menu("Nasi Goreng", "Makanan", 25000);
        daftarMenu[jumlahMenu++] = new Menu("Mie Ayam", "Makanan", 20000);
        daftarMenu[jumlahMenu++] = new Menu("Sate Ayam", "Makanan", 30000);
        daftarMenu[jumlahMenu++] = new Menu("Ayam Geprek", "Makanan", 27000);
        daftarMenu[jumlahMenu++] = new Menu("Es Teh", "Minuman", 8000);
        daftarMenu[jumlahMenu++] = new Menu("Es Jeruk", "Minuman", 10000);
        daftarMenu[jumlahMenu++] = new Menu("Kopi", "Minuman", 15000);
        daftarMenu[jumlahMenu++] = new Menu("Susu Coklat", "Minuman", 12000);
    }

    static void menuPelanggan() {
        ArrayList<Menu> pesanan = new ArrayList<>();
        ArrayList<Integer> jumlah = new ArrayList<>();

        while (true) {
            tampilkanMenu();
            System.out.print("Masukkan nama menu (atau 'selesai'): ");
            String nama = input.nextLine();

            if (nama.equalsIgnoreCase("selesai")) break;

            Menu menuDipilih = cariMenu(nama);
            if (menuDipilih == null) {
                System.out.println("Menu tidak ditemukan!");
                continue;
            }

            System.out.print("Jumlah: ");
            int qty = input.nextInt();
            input.nextLine();

            pesanan.add(menuDipilih);
            jumlah.add(qty);
        }

        hitungDanCetakStruk(pesanan, jumlah);
    }

    static Menu cariMenu(String nama) {
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getNama().equalsIgnoreCase(nama)) {
                return daftarMenu[i];
            }
        }
        return null;
    }

    static void hitungDanCetakStruk(ArrayList<Menu> pesanan, ArrayList<Integer> jumlah) {
        double total = 0;

        System.out.println("\n===== STRUK PEMESANAN =====");
        for (int i = 0; i < pesanan.size(); i++) {
            Menu m = pesanan.get(i);
            int qty = jumlah.get(i);
            double subtotal = m.getHarga() * qty;
            System.out.printf("%-20s x%d  Rp %.0f\n", m.getNama(), qty, subtotal);
            total += subtotal;
        }

        double pajak = total * 0.1;
        double pelayanan = 20000;
        double diskon = 0;

        if (total > 100000) {
            diskon = total * 0.1;
            System.out.println("Diskon 10% diterapkan!");
        } else if (total > 50000) {
            System.out.println("Promo: Beli satu gratis satu kategori minuman!");
        }

        double totalAkhir = total - diskon + pajak + pelayanan;

        System.out.println("----------------------------");
        System.out.printf("Subtotal\t: Rp %.0f\n", total);
        System.out.printf("Pajak (10%%)\t: Rp %.0f\n", pajak);
        System.out.printf("Pelayanan\t: Rp %.0f\n", pelayanan);
        System.out.printf("Diskon\t\t: Rp %.0f\n", diskon);
        System.out.printf("TOTAL AKHIR\t: Rp %.0f\n", totalAkhir);
    }

    static void menuPemilik() {
        int pilih;
        do {
            System.out.println("\n=== MENU PEMILIK ===");
            System.out.println("1. Tampilkan Menu");
            System.out.println("2. Tambah Menu");
            System.out.println("3. Ubah Harga");
            System.out.println("4. Hapus Menu");
            System.out.println("5. Kembali");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> tampilkanMenu();
                case 2 -> tambahMenu();
                case 3 -> ubahHarga();
                case 4 -> hapusMenu();
                case 5 -> System.out.println("Kembali...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 5);
    }

    static void tampilkanMenu() {
        System.out.println("\n=== DAFTAR MENU ===");
        System.out.println("Makanan:");
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getKategori().equalsIgnoreCase("Makanan")) {
                System.out.println((i + 1) + ". " + daftarMenu[i]);
            }
        }

        System.out.println("\nMinuman:");
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getKategori().equalsIgnoreCase("Minuman")) {
                System.out.println((i + 1) + ". " + daftarMenu[i]);
            }
        }
    }

    static void tambahMenu() {
        System.out.print("Masukkan nama menu: ");
        String nama = input.nextLine();
        System.out.print("Kategori (Makanan/Minuman): ");
        String kategori = input.nextLine();
        System.out.print("Harga: ");
        double harga = input.nextDouble();
        input.nextLine();

        daftarMenu[jumlahMenu++] = new Menu(nama, kategori, harga);
        System.out.println("Menu berhasil ditambahkan!");
    }

    static void ubahHarga() {
        tampilkanMenu();
        System.out.print("Masukkan nomor menu yang ingin diubah: ");
        int no = input.nextInt() - 1;
        input.nextLine();

        if (no >= 0 && no < jumlahMenu) {
            System.out.print("Masukkan harga baru: ");
            double hargaBaru = input.nextDouble();
            input.nextLine();
            System.out.print("Yakin ubah? (Ya/Tidak): ");
            String konfirmasi = input.nextLine();

            if (konfirmasi.equalsIgnoreCase("Ya")) {
                daftarMenu[no].setHarga(hargaBaru);
                System.out.println("Harga berhasil diubah!");
            }
        } else {
            System.out.println("Nomor menu tidak valid!");
        }
    }

    static void hapusMenu() {
        tampilkanMenu();
        System.out.print("Masukkan nomor menu yang ingin dihapus: ");
        int no = input.nextInt() - 1;
        input.nextLine();

        if (no >= 0 && no < jumlahMenu) {
            System.out.print("Yakin hapus? (Ya/Tidak): ");
            String konfirmasi = input.nextLine();

            if (konfirmasi.equalsIgnoreCase("Ya")) {
                for (int i = no; i < jumlahMenu - 1; i++) {
                    daftarMenu[i] = daftarMenu[i + 1];
                }
                jumlahMenu--;
                System.out.println("Menu berhasil dihapus!");
            }
        } else {
            System.out.println("Nomor menu tidak valid!");
        }
    }   
}