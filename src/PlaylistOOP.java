import java.util.Scanner;

public class PlaylistOOP {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Lagu[] playlist = new Lagu[10];

        Admin admin = new Admin("Admin");
        Member member = new Member("Member");

        admin.tambahLagu(
                playlist,
                new Lagu("Serana", "For Revenge", 4.10),
                0
        );

        admin.tambahLagu(
                playlist,
                new Lagu("Mistikus Cinta", "Dewa 19", 5.37),
                1
        );

        admin.tambahLagu(
                playlist,
                new Lagu("Tak Akan Ada Cinta Yang Lain", "Dewa 19", 4.29),
                2
        );

        admin.tambahLagu(
                playlist,
                new Lagu("The One That Got Away", "Katy Perry", 3.47),
                3
        );

        admin.tambahLagu(
                playlist,
                new Lagu("Just Give Me a Reason", "Pink feat.Nate Ruess", 4.02),
                4
        );

        admin.tambahLagu(
                playlist,
                new Lagu("Penyangkalan", "For Revenge", 4.48),
                5
        );

        admin.tambahLagu(
                playlist,
                new Lagu("Duka", "Last Child", 5.25),
                6
        );

        admin.tambahLagu(
                playlist,
                new Lagu("When I See You Smile", "Bad English", 4.17),
                7
        );

        admin.tambahLagu(
                playlist,
                new Lagu("Pangeran Cinta", "Dewa 19", 4.40),
                8
        );

        int pilihan;

        do {
            System.out.println("   SISTEM PLAYLIST MUSIK");
            System.out.println("");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Daftar Lagu");
            System.out.println("3. Cari Lagu");
            System.out.println("4. Rata-rata Durasi Lagu");
            System.out.println("5. Lihat Peran User");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    int posisi = -1;

                    for (int i = 0; i < playlist.length; i++) {
                        if (playlist[i] == null) {
                            posisi = i;
                            break;
                        }
                    }

                    if (posisi == -1) {
                        System.out.println("Playlist sudah penuh.");
                        break;
                    }

                    System.out.print("Masukkan judul lagu : ");
                    String judul = input.nextLine();

                    System.out.print("Masukkan nama artis : ");
                    String artis = input.nextLine();

                    System.out.print("Masukkan durasi (menit) : ");
                    double durasi = input.nextDouble();

                    Lagu laguBaru = new Lagu(judul, artis, durasi);

                    admin.tambahLagu(
                            playlist,
                            laguBaru,
                            posisi
                    );
                    break;

                case 2:
                    member.lihatPlaylist(playlist);
                    break;

                case 3:
                    System.out.print("Masukkan judul lagu yang dicari: ");
                    String cari = input.nextLine();

                    member.cariLagu(playlist, cari);
                    break;

                case 4:
                    double rata = member.rataRataDurasi(playlist);

                    System.out.printf(
                            "Rata-rata durasi lagu: %.2f menit%n",
                            rata
                    );
                    break;

                case 5:
                    System.out.println("\n=== PERAN USER ===");

                    User user1 = admin;
                    User user2 = member;

                    user1.tampilkanPeran();
                    user2.tampilkanPeran();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);

        input.close();
    }
}