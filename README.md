# The Meal MVVM Kotlin Android Architecture Example
Contoh aplikasi Android sederhana untuk menunjukkan cara kerja arsitektur MVVM, menggunakan Kotlin, Retrofit2, Rx Java2, Lifecycle, Room, & Dagger.

$~~$

## MVVM
**MVVM** adalah akronim dari Model, View, ViewModel. Secara garis besar MVVM merupakan salah satu architectural patterns yang membagi tanggung jawab kepada tiga komponen utama yaitu Model, View, dan View-Model.

![MVVM3](https://upload.wikimedia.org/wikipedia/commons/8/87/MVVMPattern.png)

Masing-masing dari komponen tersebut memiliki tanggung jawab sebagai berikut :

1. **Model**: Bertanggung jawab untuk menyediakan data yang di butuhkan oleh aplikasi.
   Model / entity adalah representasi dari data yang digunakan pada business logic, dapat berupa Plain Old Java Object (POJO), Kotlin Data Classes.
   Salah satu dari strategi implementasi model adalah membuat model dapat terbuka melalui observables agar terpisah antara ViewModel atau observer/ consumer.

2. **View**: Bertanggung jawab untuk merepresentasikan data yang berisi User Interface pada aplikasi.
   Representasi dari User Interface (UI) dari sebuah aplikasi, pada Android sendiri view ini dapat berupa Activity atau Fragment.

3. **View-Model**: Bertanggung jawab untuk menyimpan dan mengambil data dari Model untuk nantinya digunakan dan ditampilkan oleh View, Komponen ini merupakan inti dari Architectural Patterns MVVM. ViewModel berinteraksi dengan model dan juga menyiapkan observables yang akan diobservasi oleh View. ViewModel dapat menyediakan hooks untuk view dan mem-pass events kepada model, salah satu implementasi strategi dari ViewModel adalah untuk memisahkannya dengan View. Contohnya ViewModel tidak seharusnya mengetahui view berinteraksi dengan siapa. ViewModel bertanggung jawab untuk menyiapkan data untuk UI/View/Tampilan. ViewModel merupakan base class yang baik untuk membuat ViewModel karena setiap class yang mengextendnya akan secara otomatis memiliki holding data ketika terjadi perubahan.

$~$

**Kelebihan MVVM:**
- Tidak ada hubungan erat antar view dan view model.
- Tidak ada interface antara viwe dan model.
- Mudah untuk menulis unit testing dan kodenya pun event-driven.

**Kekurangan:**
- Harus membuat observable untuk setiap komponen UI.
- Kode yang ditulis bisa banyak.

$~$

**Praktik Terbaik MVVM:**
- Hindari referensi ke Views di ViewModels.
- Alih-alih mendorong data ke UI, biarkan UI mengamati perubahannya.
- Bagikan tanggung jawab, tambahkan lapisan domain jika diperlukan.
- Tambahkan repositori data sebagai entri titik tunggal ke data Anda.
- Mengekspos informasi tentang status data Anda menggunakan pembungkus atau LiveData lainnya.
- Pertimbangkan kasus tepi, kebocoran, dan seberapa lama operasi yang berjalan dapat memengaruhi instans dalam arsitektur Anda.
- Jangan menempatkan logika di ViewModel yang sangat penting untuk menyimpan status bersih atau terkait dengan data. Panggilan apa pun yang Anda lakukan dari ViewModel bisa menjadi yang terakhir.

$~~~$

## Kotlin
**Kotlin** adalah bahasa pemrograman modern, disajikan secara statis yang berjalan pada platform Java Virtual Machine (JVM). 
Kotlin menggunakan compiler LLVM yang artinya, dapat dikompilasi ke dalam kode JavaScript. 
Dan Kotlin merupakan bahasa kelas utama (first class language) dalam pembuatan aplikasi Android (Google I/O, Mei 2017).

$~$

**Kelebihan Kotlin:**
- Open Source.
- Mudah Dipelajari.
- Kotlin Lebih Ringan daripada Java.
- Bahasanya Simpel dan Ringkas.
- Lebih Aman dari Kesalahan Error
- Interoperable.
- Kotlin Tidak Hanya untuk Android.

**Kekurangan Kotlin:**
- Kecepatan kompilasi yang berfluktuasi.
- Komunitas Kotlin masih cukup sedikit.
- Kotlin developer masih sulit ditemukan.

$~~~$

## Retrofit2
Retrofit adalah library REST client untuk Android yang mengubah API endpoint menjadi sebuah Java interface API service.

[Documentasi Retrofit](https://square.github.io/retrofit/)

$~~~$

## RxJava2
**RxJava** sendiri adalah bagian dari library yang dikembangkan oleh ReactiveX, dimana kegunaan library ini bertujuan untuk melakukan proses asynchronous pada sebuah program dengan konsep observables sequence(sebuah sequence/urutan yang teramati).

[Documentasi RxJava](https://github.com/ReactiveX/RxJava/wiki)

$~~~$

## Lifecycle

## Room

## Dagger
