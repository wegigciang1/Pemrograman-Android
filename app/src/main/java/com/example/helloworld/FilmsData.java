package com.example.helloworld;

import java.util.ArrayList;

public class FilmsData {
    private static String[] filmNames = {
            "Bakugan: Battle Planet",
            "Black Clover",
            "Boku no Hero Academia 4th Season",
            "Boruto: Naruto Next Generations",
            "Darwin's Game",
            "Dorohedoro",
            "Haikyuu!!: To the Top",
            "Nanatsu no Taizai: Kamigami no Gekirin"
    };

    private static String[] filmDetails = {
            "Serial ini mengikuti pra-remaja Dan Kouzo, Shun Kazami, Wynton Styles, Lia Venegas, dan Petir anjing mereka. Mereka dikenal sebagai \"Yang Luar Biasa\" dan membuat video di situs web ViewTube. Akhirnya, mereka menemukan ras makhluk biomekanik yang disebut Bakugan. Mereka segera berteman dengan Bakugan dan mulai berperang satu sama lain dengan mereka, semua sementara mempertahankan lingkungan mereka dari preman yang menggunakan Bakugan untuk tujuan jahat.",
            "Asta dan Yuno ditinggalkan di gereja yang sama pada hari yang sama. Dibesarkan bersama sebagai anak-anak, mereka mengetahui \"Raja Penyihir\" —judul yang diberikan kepada penyihir terkuat di kerajaan — dan berjanji bahwa mereka akan bersaing satu sama lain untuk mendapatkan posisi Raja Penyihir berikutnya. Namun, ketika mereka tumbuh dewasa, perbedaan mencolok di antara mereka menjadi jelas. Sementara Yuno mampu menggunakan sihir dengan kekuatan dan kontrol yang luar biasa, Asta tidak bisa menggunakan sihir sama sekali dan berusaha keras untuk membangkitkan kekuatannya dengan melatih fisik.\n" +
                    "\n" +
                    "Ketika mereka mencapai usia 15, Yuno dianugerahi Grimoire spektakuler dengan semanggi berdaun empat, sementara Asta tidak menerima apa-apa. Namun, segera setelah itu, Yuno diserang oleh seseorang bernama Lebuty, yang tujuan utamanya adalah untuk mendapatkan Grimoire Yuno. Asta mencoba untuk melawan Lebuty, tetapi dia kalah. Meskipun tanpa harapan dan di ambang kekalahan, dia menemukan kekuatan untuk melanjutkan ketika dia mendengar suara Yuno. Melepaskan emosi batinnya dalam kemarahan, Asta menerima Grimoire lima daun semanggi, \"Semanggi Hitam\" memberinya kekuatan yang cukup untuk mengalahkan Lebuty. Beberapa hari kemudian, kedua sahabat itu pergi ke dunia, keduanya mencari tujuan yang sama — untuk menjadi Raja Penyihir!",
            "Setelah berhasil lulus ujian Lisensi Pahlawan Sementara, Izuku \"Deku\" Midoriya mencari magang ekstrakurikuler dengan agensi pahlawan profesional. Atas rekomendasi mentornya, All Might, Midoriya mendapat posisi di bawah mantan sahabat karib All Might, Sir Nighteye, yang sekarang menjadi pahlawan terkenal dengan haknya sendiri.\n" +
                    "\n" +
                    "Ketika teman-teman sekelas Midoriya mengembangkan kemampuan mereka sendiri melalui berbagai magang, penjahat yang sedang naik daun Kai Chisaki menggunakan kekuatannya yang menakutkan untuk mengumpulkan bantuan di dunia kriminal. Dikenal oleh Overhaul moniker, ambisi Chisaki bertabrakan dengan League of Villains dan pemimpinnya, Tomura Shigaraki.\n" +
                    "\n" +
                    "Melalui karyanya dengan Sir Nighteye, Midoriya menemukan sindikat kejahatan Chisaki dan hubungan permusuhan penjahat dengan seorang gadis muda misterius bernama Eri. Khawatir akan keselamatan anak itu, Midoriya dan kakak kelasnya Mirio Toogata harus bekerja sama untuk mengakhiri pemerintahan teror Chisaki.",
            "Setelah suksesnya Perang Dunia Shinobi Keempat, Konohagakure telah menikmati masa damai, kemakmuran, dan kemajuan teknologi yang luar biasa. Ini semua karena upaya dari Sekutu Shinobi Sekutu dan Hokage Ketujuh desa, Naruto Uzumaki. Sekarang menyerupai metropolis modern, Konohagakure telah berubah, khususnya kehidupan seorang shinobi. Di bawah pengawasan ketat Naruto dan kawan-kawan lamanya, generasi baru shinobi telah melangkah untuk mempelajari cara-cara ninja.\n" +
                    "\n" +
                    "Boruto Uzumaki sering menjadi pusat perhatian sebagai putra Hokage Ketujuh. Meskipun mewarisi perilaku Naruto yang keras dan keras kepala, Boruto dianggap ajaib dan mampu melepaskan potensinya dengan bantuan teman dan keluarga yang mendukung. Sayangnya, ini hanya memperburuk kesombongannya dan keinginannya untuk melampaui Naruto yang, bersama dengan gaya hidup ayahnya yang sibuk, telah mempererat hubungan mereka. Namun, kekuatan jahat yang muncul di dalam desa dapat mengancam kehidupan Boruto yang riang.",
            "Siswa sekolah menengah Kaname Sudou menerima undangan dari teman sekelasnya untuk bermain Game Darwin, sebuah game seluler yang belum pernah dia dengar. Namun, begitu dia membuka aplikasi, seekor ular hijau tiba-tiba muncul dari layar ponselnya dan menggigit lehernya, membuatnya tidak sadarkan diri. Bangun di rumah sakit tanpa tanda-tanda gigitan ular, ia diberitahu oleh sekolah untuk mengambil sisa hari libur. Meskipun ia bingung dengan apa yang telah terjadi, ia menolak pengalaman surealis itu sebagai halusinasi dan menaiki kereta pulang.\n" +
                    "\n" +
                    "Sayangnya, keingintahuannya membaik dan dia menggunakan aplikasi itu sekali lagi. Karena aplikasinya tampaknya sama seperti game pertempuran lainnya, Kaname menghela nafas lega dan memutuskan untuk memulai pertandingan pertamanya. Namun, kejutan yang menyenangkan itu berumur pendek, karena lawannya dalam game tiba-tiba muncul tepat di depannya dan berusaha memburunya dengan pisau.",
            "Hole — distrik yang gelap, jompo, dan tak teratur di mana mangsa yang kuat pada yang lemah dan kematian adalah kejadian biasa — sama sekali tidak sesuai dengan nama yang diberikan padanya. Ranah yang terpisah dari hukum dan etika, ini adalah tempat uji bagi para pengguna sihir yang mendominasinya. Sebagai ras yang menduduki anak tangga tertinggi di masyarakat mereka, pengguna sihir menganggap penghuni Hole tidak lebih dari serangga. Dibunuh, dimutilasi, dan melakukan eksperimen tanpa pikir panjang, penghuni Hole yang tak berdaya itu mengotori aula rumah sakit Hole setiap hari.\n" +
                    "\n" +
                    "Dengan memiliki akses gratis ke dan dari tangki septik, dan dengan sedikit tantangan bagi otoritas mereka, para pengguna sihir nampak gigih bagi sebagian besar — \u200B\u200Bdisisihkan untuk beberapa orang. Kaiman, lebih reptil daripada manusia, adalah salah satu individu tersebut. Dia memburu mereka pada pencarian lalai untuk jawaban dengan hanya sepasang bayonet tepercaya dan kekebalannya terhadap sihir. Terkutuk oleh penampilannya dan tersiksa oleh mimpi buruk, pengguna sihir adalah satu-satunya petunjuk untuk memulihkan hidupnya menjadi normal. Dengan kendala terbesarnya adalah perutnya, teman wanitanya Nikaidou, yang mengelola restoran Hungry Bug, adalah sekutu terbesarnya.",
            "Setelah kemenangan penuh kemenangan mereka atas Akademi Shiratorizawa, tim bola voli Sekolah Menengah Karasuno telah mendapatkan tiket yang telah lama ditunggu-tunggu untuk warga negara. Saat persiapan dimulai, penyiasat genius Tobio Kageyama diundang ke Kamp Pelatihan Pemuda Seluruh Jepang untuk bermain bersama sesama pemain yang diakui secara nasional. Sementara itu, Kei Tsukishima diundang ke kamp pelatihan pemula untuk tahun-tahun pertama di Prefektur Miyagi. Tidak menerima undangan apa pun, Shouyou Hinata yang antusias merasa tertinggal.\n" +
                    "\n" +
                    "Namun, Hinata tidak mundur. Mengubah frustrasinya menjadi motivasi diri, dia dengan berani memutuskan untuk menyelinap dirinya ke dalam kamp pelatihan pemula yang sama seperti Tsukishima. Meskipun Hinata hanya menempatkan dirinya sebagai ball ball, dia melihat ini sebagai peluang emas. Ia mulai tidak hanya merefleksikan keterampilannya sebagai pemain bola voli, tetapi juga menganalisis sejumlah besar informasi yang tersedia di lapangan dan bagaimana ia dapat menerapkannya.",
            "Di dunia yang mirip dengan Abad Pertengahan Eropa, para Kesatria Suci Britania yang ditakuti namun dihormati menggunakan sihir yang sangat kuat untuk melindungi wilayah Britania dan kerajaannya. Namun, sebagian kecil dari para Ksatria seharusnya mengkhianati tanah air mereka dan membalikkan pedang mereka terhadap rekan-rekan mereka dalam upaya untuk menggulingkan penguasa Liones. Mereka dikalahkan oleh Ksatria Suci, tetapi rumor terus bertahan bahwa ksatria legendaris ini, yang disebut \"Tujuh Dosa yang Mematikan,\" masih hidup. Sepuluh tahun kemudian, para Ksatria Suci sendiri melakukan kudeta, dan dengan demikian menjadi penguasa baru, tirani dari Kerajaan Singa.\n" +
                    "\n" +
                    "Berdasarkan seri manga terlaris dengan nama yang sama, Nanatsu no Taizai mengikuti petualangan Elizabeth, putri ketiga dari Kerajaan Singa, dan pencariannya untuk Tujuh Dosa Mematikan. Dengan bantuan mereka, dia berusaha untuk tidak hanya mengambil kembali kerajaannya dari para Ksatria Suci, tetapi juga untuk mencari keadilan di dunia yang tidak adil."
    };

    private static int[] filmsImages = {
            R.drawable.bakugan,
            R.drawable.black_clover,
            R.drawable.boku_no_hero,
            R.drawable.boruto,
            R.drawable.darwin_game,
            R.drawable.dorohedoro,
            R.drawable.haikyuu,
            R.drawable.nanatsu_no_taizai
    };

    static ArrayList<Film> getListData() {
        ArrayList<Film> list = new ArrayList<>();
        for (int position = 0; position < filmNames.length; position++) {
            Film film = new Film();
            film.setName(filmNames[position]);
            film.setDetail(filmDetails[position]);
            film.setPhoto(filmsImages[position]);
            list.add(film);
        }
        return list;
    }
}
