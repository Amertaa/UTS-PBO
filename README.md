# E-Course ITK - Pendaftaran Pelatihan

## Deskripsi Program

Program ini merupakan simulasi sederhana sistem **E-Course ITK** untuk proses **pendaftaran pelatihan** menggunakan bahasa **Kotlin** dengan pendekatan **Object-Oriented Programming (OOP)**.

Pada sistem ini terdapat tiga entitas utama, yaitu:

- **Peserta**
- **Instruktur**
- **KelasKursus**

Program ini juga menerapkan aturan bisnis utama, yaitu:

- Pendaftaran **ditolak** jika **KelasKursus** telah mencapai **batas maksimal peserta**
- Peserta yang berhasil mendaftar akan otomatis masuk ke **Daftar Siswa Aktif**

---

## Tujuan Program

Program ini dibuat untuk menunjukkan penerapan konsep:

- **Class dan Object**
- **Encapsulation / Data Hiding**
- **Access Modifier**
- **Method / Behavior**
- **Validasi aturan bisnis**
- **Simulasi kondisi sukses dan gagal**

---

## Struktur Class

### 1. Class `Peserta`

Class `Peserta` merepresentasikan data mahasiswa atau calon peserta yang akan mendaftar ke kelas pelatihan.

#### Atribut:

- `idPeserta: String` → identitas unik peserta
- `nama: String` → nama peserta
- `statusAktif: Boolean` → status apakah peserta sudah aktif di kelas atau belum

#### Method:

- `aktifkanPeserta()` → mengubah status peserta menjadi aktif
- `nonaktifkanPeserta()` → mengubah status peserta menjadi tidak aktif
- `tampilkanInfo()` → menampilkan informasi peserta

#### Konsep OOP yang diterapkan:

Pada class ini, atribut `statusAktif` menggunakan `private set`, sehingga nilainya **tidak dapat diubah langsung dari luar class**.  
Perubahan status hanya boleh dilakukan melalui method resmi seperti `aktifkanPeserta()` dan `nonaktifkanPeserta()`.

Contoh:

```kotlin
var statusAktif: Boolean = false
    private set
```

## 2. Class `Instruktur`

Class `Instruktur` digunakan untuk merepresentasikan data pengajar atau pemateri yang bertanggung jawab dalam suatu kelas pelatihan.

Class ini menyimpan informasi dasar mengenai instruktur, seperti identitas, nama, dan bidang keahlian. Dalam sistem E-Course ITK, object `Instruktur` akan dihubungkan dengan object `KelasKursus` untuk menunjukkan siapa yang mengajar pada kelas tersebut.

### Atribut

- `idInstruktur: String`  
  Menyimpan ID unik instruktur sebagai identitas pembeda.

- `nama: String`  
  Menyimpan nama instruktur.

- `bidang: String`  
  Menyimpan bidang keahlian atau spesialisasi instruktur, misalnya Mobile Programming, UI/UX, atau Data Science.

### Method

- `tampilkanInfo(): Unit`  
  Method ini digunakan untuk menampilkan informasi instruktur ke layar, meliputi ID, nama, dan bidang keahlian.

### Peran dalam Sistem

Class `Instruktur` berfungsi sebagai pihak yang mengajar atau memandu jalannya pelatihan.  
Setiap `KelasKursus` memiliki satu instruktur yang bertanggung jawab terhadap kelas tersebut.

### Contoh Implementasi

```kotlin
class Instruktur(
    val idInstruktur: String,
    val nama: String,
    val bidang: String
) {
    fun tampilkanInfo() {
        println("Instruktur[id=$idInstruktur, nama=$nama, bidang=$bidang]")
    }
}
```
