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
