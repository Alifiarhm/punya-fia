CREATE DATABASE db_penjualan;
USE db_penjualan;
CREATE TABLE pelanggan (
 id_pelanggan INT PRIMARY KEY AUTO_INCREMENT,
 nama_pelanggan VARCHAR(100) NOT NULL,
 kota VARCHAR(50),
 no_telepon VARCHAR(20),
 alamat VARCHAR(150)
);
CREATE TABLE kategori (
 id_kategori INT PRIMARY KEY AUTO_INCREMENT,
 nama_kategori VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE produk (
 id_produk INT PRIMARY KEY AUTO_INCREMENT,
 nama_produk VARCHAR(100) NOT NULL,
 id_kategori INT,
 harga DECIMAL(10,2) NOT NULL CHECK (harga > 0),
 stok INT NOT NULL DEFAULT 0,
 FOREIGN KEY (id_kategori) REFERENCES kategori(id_kategori)
);
CREATE TABLE transaksi (
 id_transaksi INT PRIMARY KEY AUTO_INCREMENT,
 id_pelanggan INT,
 tanggal_transaksi DATE NOT NULL,
 status_transaksi VARCHAR(20) DEFAULT 'selesai',
 FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan)
);
CREATE TABLE detail_transaksi (
 id_detail INT PRIMARY KEY AUTO_INCREMENT,
 id_transaksi INT,
 id_produk INT,
 jumlah INT NOT NULL CHECK (jumlah > 0),
 subtotal DECIMAL(10,2) NOT NULL,
 FOREIGN KEY (id_transaksi) REFERENCES transaksi(id_transaksi),
 FOREIGN KEY (id_produk) REFERENCES produk(id_produk)
);
CREATE TABLE log_stok (
 id_log INT PRIMARY KEY AUTO_INCREMENT,
 id_produk INT,
 stok_sebelum INT,
 stok_sesudah INT,
 keterangan VARCHAR(100),
 waktu_log DATETIME DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (id_produk) REFERENCES produk(id_produk)
 );
 
 -- Data pelanggan (10 baris; salah satu belum pernah bertransaksi)
INSERT INTO pelanggan (nama_pelanggan, kota, no_telepon, alamat) VALUES
('Dewi Anggraini', 'Surabaya', '081234500001', 'Jl. Kertajaya No. 12'),
('Budi Santoso', 'Sidoarjo', '081234500002', 'Jl. Jenggolo No. 5'),
('Siti Rahma', 'Surabaya', '081234500003', 'Jl. Mulyosari No. 8'),
('Andi Wijaya', 'Malang', '081234500004', 'Jl. Ijen No. 21'),
('Rina Kusuma', 'Sidoarjo', '081234500005', 'Jl. Gajah Mada No. 3'),
('Fajar Nugroho', 'Surabaya', '081234500006', 'Jl. Dharmahusada No. 45'),
('Lestari Putri', 'Gresik', '081234500007', 'Jl. Veteran No. 9'),
('Hendra Kurniawan', 'Surabaya', '081234500008', 'Jl. Kenjeran No. 18'),
('Maya Sari', 'Malang', '081234500009', 'Jl. Soekarno Hatta No. 2'),
('Agus Setiawan', 'Sidoarjo', '081234500010', 'Jl. Pahlawan No. 7');
-- Catatan: Agus Setiawan (id_pelanggan = 10) sengaja tidak pernah bertransaksi

INSERT INTO kategori (nama_kategori) VALUES
('Sembako'), ('Minuman'), ('Alat Tulis'), ('Elektronik'), ('Perawatan');

-- Data produk (15 baris; 2 produk sengaja tidak pernah terjual)
INSERT INTO produk (nama_produk, id_kategori, harga, stok) VALUES
('Beras 5kg', 1, 65000, 50),
('Minyak Goreng 2L', 1, 32000, 40),
('Gula Pasir 1kg', 1, 14000, 60),
('Teh Botol 450ml', 2, 5000, 100),
('Kopi Sachet 20pcs', 2, 18000, 70),
('Air Mineral 600ml', 2, 3000, 150),
('Pulpen Standar', 3, 3500, 80),
('Buku Tulis 38 Lembar', 3, 4000, 90),
('Penggaris 30cm', 3, 2500, 60),
('Kabel Data USB-C', 4, 45000, 30),
('Power Bank 10000mAh', 4, 150000, 15),
('Lampu LED 9W', 4, 22000, 25),
('Sabun Mandi Batang', 5, 6000, 50),
('Shampo Sachet', 5, 2000, 100),
('Tisu Basah', 5, 12000, 20);
-- Catatan: 'Lampu LED 9W' dan 'Tisu Basah' sengaja tidak pernah muncul di detail_transaksi

-- Data transaksi (15 baris; jumlah per pelanggan dibuat tidak merata)
INSERT INTO transaksi (id_pelanggan, tanggal_transaksi, status_transaksi) VALUES
(1, '2025-01-03', 'selesai'),
(1, '2025-01-15', 'selesai'),
(2, '2025-01-04', 'selesai'),
(3, '2025-01-05', 'selesai'),
(3, '2025-01-20', 'selesai'),
(3, '2025-01-25', 'selesai'),
(4, '2025-01-06', 'selesai'),
(5, '2025-01-07', 'selesai'),
(6, '2025-01-08', 'selesai'),
(6, '2025-01-18', 'selesai'),
(7, '2025-01-09', 'selesai'),
(8, '2025-01-10', 'selesai'),
(8, '2025-01-22', 'selesai'),
(9, '2025-01-11', 'selesai'),
(2, '2025-01-27', 'selesai');
-- Catatan: pelanggan id 3 memiliki transaksi terbanyak (3 kali)
-- Data detail_transaksi (bervariasi 1-4 baris per transaksi)
INSERT INTO detail_transaksi (id_transaksi, id_produk, jumlah, subtotal)
VALUES
(1, 1, 2, 130000), (1, 4, 5, 25000),
(2, 7, 3, 10500),
(3, 2, 1, 32000), (3, 6, 10, 30000),
(4, 3, 2, 28000),
(5, 9, 4, 10000), (5, 13, 2, 12000),
(6, 5, 1, 18000),
(7, 10, 1, 45000), (7, 8, 3, 12000),
(8, 11, 1, 150000),
(9, 1, 1, 65000), (9, 4, 2, 10000), (9, 6, 5, 15000),
(10, 12, 2, 44000),
(11, 3, 1, 14000),
(12, 2, 2, 64000),
(13, 8, 5, 20000), (13, 9, 2, 5000),
(14, 6, 8, 24000), (14, 7, 4, 14000), (14, 4, 3, 15000),
(15, 1, 1, 65000);

select * from detail_transaksi