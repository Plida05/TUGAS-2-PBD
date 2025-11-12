# Aplikasi Restoran Sederhana (Tugas Praktik 2)

Proyek ini adalah aplikasi konsol (console application) berbasis Java yang dibuat untuk memenuhi Tugas Praktik 2. Aplikasi ini menyimulasikan sistem pemesanan dan manajemen menu sederhana untuk sebuah restoran.

## 🎯 Indikator Capaian Tugas

Tujuan dari tugas ini adalah agar mahasiswa mampu:

* Mengimplementasikan penggunaan tipe data, variabel, identifier, dan keyword pada class, object, dan method.
* Mengimplementasikan Array dan/atau String dalam method.
* Mengimplementasikan struktur keputusan (seperti `if`, `if-else`, `if-else if`, `switch case`, `nested if`).
* Mengimplementasikan struktur perulangan (seperti `for`, `for-each`, `while`, dan `do-while`).

---

## ✨ Fitur Utama

Aplikasi ini memiliki dua mode utama: mode Pelanggan (Pemesanan) dan mode Admin (Manajemen Menu).

### 1. Mode Pemesanan (Pelanggan)

* **Pemesanan Menu:**
    * Pelanggan dapat melihat daftar menu yang dikelompokkan berdasarkan kategori (Makanan, Minuman).
    * Pelanggan dapat memesan beberapa item tanpa batas.
    * Proses pemesanan berhenti ketika pelanggan menginput ‘selesai’.
    * Jika pelanggan menginput nama menu yang tidak ada di daftar, sistem akan terus meminta input kembali.
* **Perhitungan Total Biaya:**
    * Program menghitung total biaya pesanan.
    * Menambahkan **Pajak 10%** dari total biaya.
    * Menambahkan **Biaya Pelayanan** sebesar **Rp 20.000,-**.
* **Sistem Diskon & Penawaran:**
    * **Diskon 10%:** Diberikan jika total biaya keseluruhan pesanan (sebelum pajak dan layanan) melebihi Rp 100.000,-.
    * **Beli 1 Gratis 1:** Diberikan untuk salah satu kategori minuman jika total biaya keseluruhan pesanan melebihi Rp 50.000,-.
* **Cetak Struk Pesanan:**
    * Program mencetak struk ke layar konsol.
    * Struk mencantumkan:
        * Item yang dipesan dan jumlahnya.
        * Harga per item dan total harga per item.
        * Total biaya pemesanan.
        * Informasi Pajak, Biaya Pelayanan, dan Diskon (jika berlaku).
        * Total akhir yang harus dibayar.

### 2. Mode Manajemen Menu (Admin)

* **Navigasi Menu:**
    * Admin dapat memilih menu untuk mengelola data menu restoran.
    * Terdapat fungsionalitas untuk kembali ke menu utama (parent).
* **Tambah Menu Baru:**
    * Admin dapat menambahkan menu baru (nama, harga, kategori) ke dalam array.
    * Dimungkinkan untuk menambahkan beberapa menu baru sekaligus (menggunakan perulangan).
* **Ubah Harga Menu:**
    * Admin dapat mengubah harga menu yang sudah ada.
    * Sistem akan menampilkan daftar menu, meminta admin memilih nomor menu yang akan diubah.
* **Hapus Menu:**
    * Admin dapat menghapus menu dari daftar.
    * Sistem akan menampilkan daftar menu, meminta admin memilih nomor menu yang akan dihapus.
* **Konfirmasi:**
    * Setiap aksi **ubah** atau **hapus** akan meminta konfirmasi ("Ya") sebelum dieksekusi untuk memastikan tidak ada kesalahan.

---

## 📂 Struktur Proyek

Sesuai petunjuk pengerjaan, proyek ini dibangun menggunakan struktur kelas berikut:

* **`Menu.java`**
    * Sebuah *class* yang merepresentasikan menu makanan dan minuman.
    * Memiliki atribut seperti `nama`, `harga`, dan `kategori`.
* **`Main.java`**
    * Kelas utama yang berisi `main method`.
    * Berisi semua *method* untuk menjalankan logika aplikasi, seperti:
        * Menampilkan menu (dikelompokkan per kategori)
        * Menerima dan mengolah pesanan pelanggan
        * Menghitung total biaya (termasuk pajak, layanan, dan diskon)
        * Mencetak struk pesanan
        * Menjalankan menu manajemen (tambah, ubah, hapus data menu)

## 🛠️ Teknologi yang Digunakan

* **Java**
* **Array:** Digunakan untuk mengelola daftar menu dan daftar pesanan pelanggan.
* **Struktur Keputusan (Control Flow):** `if-else`, `switch case` untuk logika perhitungan diskon, pajak, dan navigasi menu.
* **Struktur Perulangan:** `while`, `do-while`, dan `for` untuk proses input pesanan, menampilkan menu, dan validasi input.

## ▶️ Cara Menjalankan

1.  Pastikan Anda memiliki **Java Development Kit (JDK)** terinstal di komputer Anda.
2.  *Clone* repositori ini:
    ```bash
    git clone [URL_REPOSITORI_ANDA]
    ```
3.  Buka proyek di IDE Java favorit Anda (Contoh: IntelliJ IDEA, Eclipse, VS Code).
4.  Compile dan jalankan file `Main.java`.
