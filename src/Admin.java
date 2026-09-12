public class Admin extends User {

    public Admin(String nama) {
        super(nama);
    }

    public void tambahLagu(Lagu[] playlist, Lagu lagu, int posisi) {
        if (posisi < playlist.length) {
            playlist[posisi] = lagu;
            System.out.println("Lagu berhasil ditambahkan.");
        } else {
            System.out.println("Playlist sudah penuh.");
        }
    }

    @Override
    public void tampilkanPeran() {
        System.out.println("Saya Admin Playlist.");
    }
}