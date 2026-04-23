class Peserta(
    val idPeserta: String,
    val nama: String
) {
    var statusAktif: Boolean = false
        private set

    fun aktifkanPeserta() {
        statusAktif = true
    }

    fun nonaktifkanPeserta() {
        statusAktif = false
    }

    fun tampilkanInfo() {
        println("Peserta[id=$idPeserta, nama=$nama, statusAktif=$statusAktif]")
    }
}

class Instruktur(
    val idInstruktur: String,
    val nama: String,
    val bidang: String
) {
    fun tampilkanInfo() {
        println("Instruktur[id=$idInstruktur, nama=$nama, bidang=$bidang]")
    }
}

class KelasKursus(
    val kodeKelas: String,
    val namaKelas: String,
    val instruktur: Instruktur,
    private val batasMaksimalPeserta: Int
) {
    private val daftarSiswaAktif: MutableList<Peserta> = mutableListOf()

    val jumlahPeserta: Int
        get() = daftarSiswaAktif.size

    fun tampilkanDaftarSiswaAktif() {
        println("\nDaftar Siswa Aktif - $namaKelas")
        if (daftarSiswaAktif.isEmpty()) {
            println("Belum ada peserta aktif.")
        } else {
            daftarSiswaAktif.forEachIndexed { index, peserta ->
                println("${index + 1}. ${peserta.nama} (${peserta.idPeserta})")
            }
        }
    }

    fun tampilkanInfoKelas() {
        println("KelasKursus[kode=$kodeKelas, nama=$namaKelas, instruktur=${instruktur.nama}, kuota=$jumlahPeserta/$batasMaksimalPeserta]")
    }

    fun daftarPeserta(peserta: Peserta) {
        println("\nProses pendaftaran peserta: ${peserta.nama}")

        if (jumlahPeserta >= batasMaksimalPeserta) {
            println("Pendaftaran ditolak! Kuota kelas '$namaKelas' sudah penuh.")
            return
        }

        if (daftarSiswaAktif.any { it.idPeserta == peserta.idPeserta }) {
            println("Pendaftaran ditolak! Peserta ${peserta.nama} sudah terdaftar di kelas ini.")
            return
        }

        daftarSiswaAktif.add(peserta)
        peserta.aktifkanPeserta()
        println("Pendaftaran berhasil! ${peserta.nama} telah masuk ke Daftar Siswa Aktif.")
    }
}

fun main() {
    // Membuat instruktur
    val instruktur1 = Instruktur(
        idInstruktur = "INS001",
        nama = "Bapak Andi Pratama",
        bidang = "Pemrograman Mobile"
    )

    // Membuat kelas kursus dengan batas maksimal 2 peserta
    val kelasAndroid = KelasKursus(
        kodeKelas = "KLS101",
        namaKelas = "E-Course Android Kotlin ITK",
        instruktur = instruktur1,
        batasMaksimalPeserta = 2
    )

    // Membuat peserta
    val peserta1 = Peserta("P001", "Aulia")
    val peserta2 = Peserta("P002", "Bima")
    val peserta3 = Peserta("P003", "Citra")

    println("=== INFORMASI AWAL ===")
    instruktur1.tampilkanInfo()
    kelasAndroid.tampilkanInfoKelas()
    peserta1.tampilkanInfo()
    peserta2.tampilkanInfo()
    peserta3.tampilkanInfo()

    // =========================
    // SIMULASI SUKSES
    // =========================
    println("\n=== SIMULASI SUKSES ===")
    kelasAndroid.daftarPeserta(peserta1)
    kelasAndroid.daftarPeserta(peserta2)

    kelasAndroid.tampilkanInfoKelas()
    kelasAndroid.tampilkanDaftarSiswaAktif()

    peserta1.tampilkanInfo()
    peserta2.tampilkanInfo()

    
}