Reflection 1 :
Dalam exercise 1 ini, saya diperkenalkan dengan suatu framework baru yang belum pernah saya gunakan sebelumnya yaitu SpringBoot. Kita diperkenalkan
dengan dasar-dasar SpringBoot dengan mencoba membuat suatu shop sederhana dengan fitur-fitur dasar seperti create, edit, dan delete. Melalui tutorial
ini, kita juga mensimulasikan beberapa cara kerja git seperti konsep merge, pull request, sampai menangani merge conflict. Saya menyadari hal-hal tersebut
sangat penting untuk kita ke depannya jika sedang mengerjakan suatu project bersama tim. Setelah saya meninjau kembali source code yang telah dibuat, ada
beberapa prinsip clean code dan secure coding yang sudah saya terapkan secara tidak langsung :
- Single Responsibilities : Setiap class ataupun method memiliki tanggung jawab yang jelas untuk bagiannya masing-masing
- Penamaan yang jelas : Method - method seperti create, edit, delete, dan findById memiliki nama yang ringkas dan jelas sesuai dengan fungsinya sehingga mudah dibaca dan dipahami
- Kode terstruktur : Pemisahan antara repository, service, controller, dan model membuat kode lebih terstruktur dan mudah dimaintain
- Encapsulation data : Data disimpan sebagai variable private sehingga tidak bisa asal akses dari luar class
- Penggunaan identifier : Proses edit dan delete dilakukan berdasarkan id product yang unik sehingga lebih aman

Namun, saya juga menyadari ada beberapa hal yang masih kurang dari code saya. Hal - hal seperti return null pada beberapa method berpotensi menyebabkan
NullPointerException jika tidak dihandle dengan tepat. Solusinya, kita bisa diganti dengan custom exception agar lebih aman. Lalu, saya juga belum menambahkan validasi input tambahan sehingga masih bisa ditambahkan untuk menghindari hal yang
tidak diinginkan. Terakhir, baik code saya maupun tutorial masih menggunakan ArrayList sebagai penyimpanan dimana tidak ideal karena datanya akan ke reset
setiap kali kita mulai run.

Reflection 2 : 
1. Setelah membuat unit test, saya merasa proses ini membantu saya untuk lebih memahami alur dan logika program karena kita harus memikirkan kemungkinan error 
atau edge case. Tanpa pemahaman alur logika program kita, maka kita tidak bisa membuat edge case tersebut. Unit test juga memberikan rasa percaya diri bahwa
kode yang kita buat sudah benar secara umum. Menurut saya, tidak ada jumlah unit test yang tepat yang harus dibuat dalam satu class. Yang lebih penting yaitu
sebisa mungkin memastikan bahwa setiap method diuji dengan baik. Apapun kemungkinan yang terpikirkan oleh kita harus diujikan. Idealnya, ada dua jenis test case 
yaitu positif (fungsi berjalan sesuai harapan) dan negatif (menghandle kondisi error). Code coverage menjadi salah satu metrik penting yang menunjukkan seberapa
besar bagian kode kita yang telah diuji. Namun, 100% code coverage tidak berarti kode bebas dari bug. Code coverage sebenarnya hanya memastikan bagian tertentu kode kita
dijalankan, tetapi bisa saja test tersebut bisa tidak akurat. Dengan kata lain, test yang tidak memiliki assert yang kuat tetap bisa menghasilkan coverage tinggi tetapi
gagal mendeteksi bug tersembunyi. Oleh karena itu, code coverage sebaiknya digunakan sebagai alat bantu, bukan sebagai satu-satunya acuan. Unit test harus memiliki
assertion yang jelas, mencakup berbagai kemungkinan skenario agar dapat benar-benar menunjukkan kebenaran program.

2. Jika saya membuat functional test suite baru untuk memverifikasi jumlah item pada product list dengan menggunakan struktur, setup, dan instansiasi variable yang mirip dengan sebelumnya, maka dari sisi fungsional tidak akan terpengaruh
apapun dan tetap berjalan dengan baik. Namun, dari sisi clean code, hal ini bisa menimbulkan masalah. Duplikasi kode seperti setup dan konfigurasi base url melanggar prinsip clean code. Jika suatu saat kita ingin melakukan perubahan konfigurasi,
maka perubahan tersebut juga harus dilakukan di banyak class test dimana dapat meningkatkan risiko inkonsistensi dan error. Solusinya, kita bisa memisahkan setup yang bersifat umum ke suatu class dasar (base test class). Dengan pendekatan ini,
setiap functional test hanya berisi skenario pengujian spesifik tanpa harus melakukan setup yang berulang. Kualitas kode pun akan tetap terjaga dan proses pengembangan maupun perubahan di kemudian hari cenderung lebih mudah dan aman. Namun di source code
ini, saya belum menerapkan hal tersebut karena class testnya masih cenderung sedikit. Tetapi, secara best practice, hal ini cukup penting.
