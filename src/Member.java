public class Member extends User {

    public Member(String nama) {
        super(nama);
    }

    // Menampilkan semua lagu
    public void lihatPlaylist(Lagu[] playlist) {
        System.out.println("\n=== DAFTAR PLAYLIST ===");

        boolean adaLagu = false;

        for (Lagu lagu : playlist) {
            if (lagu != null) {
                lagu.tampilkanInfo();
                adaLagu = true;
            }
        }

        if (!adaLagu) {
            System.out.println("Playlist masih kosong.");
        }
    }

    // Mencari lagu berdasarkan judul
    public void cariLagu(Lagu[] playlist, String judulCari) {
        boolean ditemukan = false;

        for (Lagu lagu : playlist) {
            if (lagu != null &&
                    lagu.getJudul().equalsIgnoreCase(judulCari)) {

                System.out.println("\n=== LAGU DITEMUKAN ===");
                lagu.tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu tidak ditemukan.");
        }
    }

    // Menghitung rata-rata durasi lagu
    public double rataRataDurasi(Lagu[] playlist) {
        double total = 0;
        int jumlah = 0;

        for (Lagu lagu : playlist) {
            if (lagu != null) {
                total += lagu.getDurasi();
                jumlah++;
            }
        }

        if (jumlah == 0) {
            return 0;
        }

        return total / jumlah;
    }

    // Polymorphism
    @Override
    public void tampilkanPeran() {
        System.out.println("Saya adalah Member Playlist.");
    }
}