public class Menu {
    private String nama;
    private String kategori;
    private double harga;

    public Menu(String nama, String kategori, double harga) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return nama + " (" + kategori + ") - Rp " + harga;
    }
}