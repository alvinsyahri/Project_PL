-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 07 Jul 2022 pada 04.01
-- Versi server: 5.7.33
-- Versi PHP: 8.1.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffeshopsarena`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(25) NOT NULL,
  `harga_barang` int(20) NOT NULL,
  `stok` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga_barang`, `stok`) VALUES
(1, 'Cappucino', 8000, 6),
(2, 'Luwak White Coffe', 7000, 5),
(3, 'Sanger', 10000, 13),
(4, 'Chocolatos', 5000, 6),
(5, 'Ekspresso', 10000, 21),
(6, 'Blue Ocean', 15000, 3),
(7, 'Ristretto', 7000, 60),
(8, 'Macchiato', 7000, 55),
(9, 'Kopi Latte', 8000, 45),
(10, 'Piccolo Latte', 9000, 35),
(11, 'Mocha', 7500, 28),
(12, 'Teh ', 5000, 145),
(13, 'Nutrisari', 5000, 89),
(14, 'Pop ice', 5000, 120),
(15, 'Kukubima', 6000, 155),
(16, 'Milo', 5000, 167),
(18, 'Es Sirup', 5000, 167),
(19, 'Mix Tea', 7000, 189),
(20, 'Susu', 8000, 153);

-- --------------------------------------------------------

--
-- Struktur dari tabel `gaji`
--

CREATE TABLE `gaji` (
  `id_gaji` int(10) NOT NULL,
  `karyawan` int(10) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gaji`
--

INSERT INTO `gaji` (`id_gaji`, `karyawan`, `tanggal`) VALUES
(2, 2, '2022-01-20'),
(6, 2, '2022-06-09'),
(9, 3, '2022-06-07'),
(11, 2, '2022-06-10');

-- --------------------------------------------------------

--
-- Struktur dari tabel `input_data_karyawan`
--

CREATE TABLE `input_data_karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `agama` varchar(15) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `jabatan` int(10) NOT NULL,
  `TGL` varchar(50) NOT NULL DEFAULT '',
  `Email` varchar(100) NOT NULL DEFAULT '',
  `no_hp` varchar(13) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `input_data_karyawan`
--

INSERT INTO `input_data_karyawan` (`id_karyawan`, `nama`, `jenis_kelamin`, `agama`, `alamat`, `jabatan`, `TGL`, `Email`, `no_hp`) VALUES
(1, 'Alvin Syahri', 'Laki Laki', 'Islam', 'Lhokseumawe', 1, '2002-05-31', 'alvinsyahri@gmail.com', '0123456789123'),
(2, 'Al-Khaidar', 'Laki-Laki', 'Islam', 'Bireun12', 3, '2002-04-21', 'alkhaidar@gmail.com', '0123456789456'),
(3, 'Saskia Febrianti', 'Perempuan', 'Islam', 'Medan', 2, '2002-02-05', 'saskia@gmail.com', '0123456789789'),
(4, 'Adillah', 'Perempuan', 'Islam', 'Alu Awe', 2, '2002-03-20', 'adillah@gmail.com', '0123456789012'),
(9, 'Zacky Shifa', 'Laki-Laki', 'Islam', 'asda', 1, '2022-06-03', 'qwdsda', '123132'),
(10, 'Putri', 'Perempuan', 'Islam', 'Cunda', 3, '2022-06-16', 'putri@gmail.com', '082354678129');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` int(11) NOT NULL,
  `nama_jabatan` varchar(25) NOT NULL,
  `Nominal_Gaji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `nama_jabatan`, `Nominal_Gaji`) VALUES
(1, 'Manager', 200000),
(2, 'Admin', 150000),
(3, 'Manajer', 500000),
(4, 'Admin', 400000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `id_login` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`id_login`, `username`, `password`, `level`) VALUES
(1, 'alvin_23', '12345', '1'),
(2, 'khaidarSarena', '12345', '2'),
(3, 'Bosku_76', '12345', '3');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_supplier`
--

CREATE TABLE `tb_supplier` (
  `id_supplier` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `barang` int(11) NOT NULL,
  `harga_satuan` int(255) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `harga_total` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_supplier`
--

INSERT INTO `tb_supplier` (`id_supplier`, `tanggal`, `barang`, `harga_satuan`, `jumlah`, `harga_total`) VALUES
(1, '2022-01-01', 1, 3000, 20, 60000),
(2, '2022-01-10', 2, 5000, 20, 100000),
(3, '2022-01-28', 3, 7000, 10, 70000),
(4, '2022-02-08', 4, 3000, 10, 30000),
(5, '2022-02-27', 5, 7000, 5, 35000),
(6, '2022-03-21', 6, 10000, 5, 50000),
(7, '2022-03-24', 2, 5000, 13, 65000),
(8, '2022-03-31', 4, 3000, 25, 75000),
(9, '2022-04-13', 3, 7000, 15, 105000),
(10, '2022-05-03', 2, 5000, 25, 125000),
(11, '2022-06-28', 6, 10000, 10, 100000),
(12, '2022-06-07', 6, 10000, 17, 170000),
(13, '2022-06-12', 6, 10000, 4, 40000),
(15, '2022-06-16', 4, 3000, 1, 3000),
(17, '2022-06-16', 4, 3000, 5, 15000),
(18, '2022-06-16', 1, 3000, 2, 6000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `barang` int(11) NOT NULL,
  `karyawan` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlah` int(20) NOT NULL,
  `total` int(255) NOT NULL,
  `pembeli` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `barang`, `karyawan`, `tanggal`, `jumlah`, `total`, `pembeli`) VALUES
(1, 1, 1, '2022-01-03', 2, 16000, 0),
(2, 4, 2, '2022-01-07', 3, 15000, 0),
(3, 4, 2, '2022-01-11', 2, 10000, 0),
(4, 5, 1, '2022-01-20', 1, 10000, 0),
(5, 1, 1, '2022-01-28', 2, 16000, 0),
(6, 6, 2, '2022-01-27', 2, 30000, 0),
(7, 3, 1, '2022-02-03', 2, 20000, 0),
(8, 2, 2, '2022-02-10', 3, 21000, 0),
(9, 2, 1, '2022-02-20', 1, 7000, 0),
(10, 4, 1, '2022-02-20', 4, 20000, 0),
(11, 3, 2, '2022-02-22', 2, 20000, 0),
(12, 6, 1, '2022-02-23', 2, 30000, 0),
(13, 6, 1, '2022-02-28', 1, 10000, 0),
(14, 1, 1, '2022-03-09', 2, 16000, 0),
(15, 1, 2, '2022-03-09', 3, 24000, 0),
(16, 6, 2, '2022-03-15', 1, 15000, 0),
(17, 3, 2, '2022-03-16', 3, 30000, 0),
(18, 2, 2, '2022-03-18', 3, 21000, 0),
(19, 6, 1, '2022-04-06', 3, 45000, 0),
(20, 1, 1, '2022-04-17', 2, 16000, 0),
(21, 3, 2, '2022-04-18', 3, 30000, 0),
(22, 5, 1, '2022-04-22', 2, 20000, 0),
(23, 4, 2, '2022-05-05', 4, 20000, 0),
(24, 6, 2, '2022-05-09', 2, 30000, 0),
(25, 6, 1, '2022-05-20', 1, 15000, 0),
(26, 5, 1, '2022-05-12', 3, 30000, 0),
(27, 3, 1, '2022-05-16', 3, 30000, 0),
(28, 2, 2, '2022-05-17', 3, 21000, 0),
(29, 1, 1, '2022-05-12', 2, 16000, 0),
(30, 6, 2, '2022-05-28', 2, 30000, 0),
(31, 6, 1, '2022-05-31', 1, 15000, 0),
(32, 6, 1, '2022-06-01', 2, 30000, 0),
(33, 1, 1, '2022-06-02', 2, 16000, 0),
(34, 5, 1, '2022-06-05', 2, 20000, 0),
(35, 3, 1, '2022-06-07', 1, 10000, 0),
(36, 6, 1, '2022-06-12', 1, 15000, 0),
(37, 1, 1, '2022-06-16', 3, 24000, 0),
(38, 6, 1, '2022-06-16', 3, 45000, 0),
(39, 20, 1, '2022-06-16', 3, 24000, 1);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`id_gaji`),
  ADD KEY `karyawan` (`karyawan`);

--
-- Indeks untuk tabel `input_data_karyawan`
--
ALTER TABLE `input_data_karyawan`
  ADD PRIMARY KEY (`id_karyawan`),
  ADD KEY `jabatan` (`jabatan`);

--
-- Indeks untuk tabel `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_login`);

--
-- Indeks untuk tabel `tb_supplier`
--
ALTER TABLE `tb_supplier`
  ADD PRIMARY KEY (`id_supplier`),
  ADD KEY `barang` (`barang`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `barang` (`barang`),
  ADD KEY `transaksi_ibfk_2` (`karyawan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT untuk tabel `gaji`
--
ALTER TABLE `gaji`
  MODIFY `id_gaji` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `input_data_karyawan`
--
ALTER TABLE `input_data_karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `login`
--
ALTER TABLE `login`
  MODIFY `id_login` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_supplier`
--
ALTER TABLE `tb_supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `gaji`
--
ALTER TABLE `gaji`
  ADD CONSTRAINT `gaji_ibfk_1` FOREIGN KEY (`karyawan`) REFERENCES `input_data_karyawan` (`id_karyawan`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `input_data_karyawan`
--
ALTER TABLE `input_data_karyawan`
  ADD CONSTRAINT `input_data_karyawan_ibfk_1` FOREIGN KEY (`jabatan`) REFERENCES `jabatan` (`id_jabatan`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tb_supplier`
--
ALTER TABLE `tb_supplier`
  ADD CONSTRAINT `tb_supplier_ibfk_1` FOREIGN KEY (`barang`) REFERENCES `barang` (`id_barang`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`barang`) REFERENCES `barang` (`id_barang`) ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`karyawan`) REFERENCES `input_data_karyawan` (`id_karyawan`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
