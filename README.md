# Warteg Console Application

## Fitur Utama

- Lihat Menu
- Keranjang
- Checkout (Cash or Qris)
---

## Struktur Class dan Arsitektur


### Penjelasan Masing-Masing Class

| Layer / Kategori | Nama Class / Interface | Deskripsi & Peran |
| :--- | :--- | :--- |
| **Interface** | `IPaymentable` | Mendefinisikan kontrak method wajib bagi setiap sistem pembayaran (`Pay`, `PaymentName`, `NominalPay`, `Kembalian`). |
| **Model (Abstraksi)** | `Payment` | Kelas abstrak (*abstract base class*) yang mengimplementasikan `IPaymentable`. Menjadi cetak biru bagi metode pembayaran turunan. |
| **Model (Konkrit)** | `CashPayment` | Turunan dari `Payment` untuk transaksi tunai. Memvalidasi nominal uang pembeli dan menghitung sisa kembalian. |
| **Model (Konkrit)** | `QrisPayment` | Turunan dari `Payment` untuk transaksi QRIS digital. Mengonfirmasi pembayaran instan (kembalian bernilai 0). |
| **Model (Base)** | `Menu` | Entitas dasar item warteg yang menyimpan informasi nama, harga, dan stok, serta enkapsulasi manipulasi stok (`ReduceStock`, `AddStock`). |
| **Model (Turunan)** | `Category` | Pewarisan dari `Menu` yang menambahkan metadata kategori (seperti *"Makanan"* atau *"Minuman"*). |
| **Model** | `Cart` | Merepresentasikan baris item dalam keranjang belanja, menampung referensi objek `Menu` dan jumlah kuantitas (`Quantity`) yang dipesan. |
| **Service** | `MenuServices` | Layanan statis untuk mengisi data menu default warteg dan menampilkannya dalam format bernomor di layar konsol. |
| **Service** | `CartServices` | Layanan bisnis untuk mengelola keranjang: menambahkan pesanan baru, menggabungkan item yang sama, dan menampilkan ringkasan belanjaan beserta total harga. |
| **Service** | `CheckoutServices` | Layanan proses transaksi checkout: memilih metode pembayaran, memproses pemotongan stok barang, dan mencetak struk belanja resmi (*Receipt*). |
| **Program** | `Program.cs` | Titik awal eksekusi program (*entry point*), mengatur navigasi menu utama menggunakan perulangan `while` dan struktur kontrol `switch-case`. |

---

## Penerapan Konsep OOP

### 1. Encapsulation (Enkapsulasi)(*access modifier*).
- **Pembatasan Properti**:
  ```csharp
  public decimal Price { get; private set; } = price;
  public int Stock { get; private set; } = stock;
  ```
- **Validasi Data**:
  ```csharp
  public void ReduceStock(int quantity)
  {
      if(Stock <= 0 || quantity < 0)
      {
          throw new ArgumentException("Stok not valid");
      }
      Stock -= quantity;
  }
  ```
- **Proteksi Nilai Transaksi**:
  Pada CashPayment dan QrisPayment, properti Nominal dan Change juga berstatus private set, sehingga hanya dapat diubah oleh logika internal method Pay().

### 2. Inheritance (Pewarisan)
- **Category mewarisi Menu**:
  ```csharp
  public class Category(string name, decimal price, int stock, string categoryName) 
      : Menu(name, price, stock)
  {
      public string CategoryName { get; set; } = categoryName;
  }
  ```
- **CashPayment dan QrisPayment mewarisi Payment**:
  Kedua metode pembayaran mewarisi struktur kelas dasar Payment.

### 3. Polymorphism (Polimorfisme)
- **Polymorphism (Method Overriding)**:
  
  ```csharp
  Payment payment;
  switch (metode)
  {
      case 1:
          payment = new CashPayment();
          break;
      case 2:
          payment = new QrisPayment();
          break;
      default:
          return;
  }

  bool success = payment.Pay(total);
  ```

### 4. Abstraction (Abstraksi)
- **Interface IPaymentable**:
  ```csharp
  public interface IPaymentable
  {
      bool Pay(decimal total);
      string PaymentName();
      decimal NominalPay();
      decimal Kembalian();
  }
  ```
- **Abstract Class Payment**:
  ```csharp
  public abstract class Payment : IPaymentable
  {
      public abstract bool Pay(decimal total);
      public abstract string PaymentName();
      public abstract decimal NominalPay();
      public abstract decimal Kembalian();
  }
  ```

### 5. Association & Data Integrity
- **LINQ & Functional Query**: CartServices dan CheckoutServices memanfaatkan fitur LINQ C# (Sum, FirstOrDefault) untuk kalkulasi harga dan pencarian item secara efisien.
  ```csharp
  decimal total = carts.Sum(item => item.Menus.Price * item.Quantity);
  ```



## Cara Menjalankan Aplikasi

### Versi C# (.NET)

#### Langkah Menjalankan
1. Buka terminal / command prompt / PowerShell.
2. Arahkan direktori ke folder proyek konsol Warteg:
   ```bash
   cd "koda-b1-homework4-.net/src/Warteg.Console"
   ```
3. Kompilasi dan jalankan aplikasi dengan perintah:
   ```bash
   dotnet run
   ```
4. Atau jika ingin melakukan build terlebih dahulu:
   ```bash
   dotnet build
   dotnet run --no-build
   ```

---

### Versi Java

#### Langkah Menjalankan
1. Masuk ke direktori proyek Java:
   ```bash
   cd "koda-b1-homework4-java"
   ```
2. Jalankan perintah Maven:
   ```bash
   mvn compile
   java -cp target/classes com.koda.App
   ```

---

## Screenshot Hasil Program

### 1. Lihat Menu, Penambahan ke Keranjang, dan Tampilan Keranjang

![Tampilan Menu dan Keranjang](image/ss1.png)

---

### 2. Proses Checkout, Pembayaran Cash, dan Struk Transaksi (Receipt)

![Tampilan Checkout dan Struk](image/ss2.png)
