-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Jul 2019 pada 13.00
-- Versi server: 10.1.31-MariaDB
-- Versi PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_wp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `alternatif`
--

CREATE TABLE `alternatif` (
  `id_alt` int(11) NOT NULL,
  `nama_alternatif` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `alternatif`
--

INSERT INTO `alternatif` (`id_alt`, `nama_alternatif`) VALUES
(1, 'Nokia 1'),
(2, 'Nokia 2'),
(3, 'Samsung 3'),
(4, 'Samsung 4'),
(5, 'Samsung 5');

-- --------------------------------------------------------

--
-- Struktur dari tabel `hasil`
--

CREATE TABLE `hasil` (
  `id_rank` int(11) NOT NULL,
  `nama_alaternatif` varchar(100) NOT NULL,
  `hasil` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hasil`
--

INSERT INTO `hasil` (`id_rank`, `nama_alaternatif`, `hasil`) VALUES
(1, 'Samsung 5', 0.201773),
(2, 'Samsung 4', 0.20036),
(3, 'Samsung 3', 0.200126),
(4, 'Nokia 1', 0.199589),
(5, 'Nokia 2', 0.198667);

-- --------------------------------------------------------

--
-- Struktur dari tabel `hitung_b`
--

CREATE TABLE `hitung_b` (
  `id_bhitung` int(11) NOT NULL,
  `nilai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `hitung_s`
--

CREATE TABLE `hitung_s` (
  `id_s` int(11) NOT NULL,
  `id_trans` int(11) NOT NULL,
  `id_alt` int(11) NOT NULL,
  `nilai_s` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hitung_s`
--

INSERT INTO `hitung_s` (`id_s`, `id_trans`, `id_alt`, `nilai_s`) VALUES
(1, 1, 1, 12.3096),
(2, 9, 2, 12.2527),
(3, 17, 3, 12.3427),
(4, 25, 4, 12.3571),
(5, 33, 5, 12.4442);

-- --------------------------------------------------------

--
-- Struktur dari tabel `hitung_v`
--

CREATE TABLE `hitung_v` (
  `id_v` int(11) NOT NULL,
  `id_s` int(11) NOT NULL,
  `hasil` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hitung_v`
--

INSERT INTO `hitung_v` (`id_v`, `id_s`, `hasil`) VALUES
(1, 1, 0.199589),
(2, 2, 0.198667),
(3, 3, 0.200126),
(4, 4, 0.20036),
(5, 5, 0.201773);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jumlah_b`
--

CREATE TABLE `jumlah_b` (
  `id_jumlh` int(11) NOT NULL,
  `id_krit` int(11) NOT NULL,
  `nilai` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `jumlah_v`
--

CREATE TABLE `jumlah_v` (
  `id_jumlah` int(11) NOT NULL,
  `id_s` int(11) NOT NULL,
  `hasil` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jumlah_v`
--

INSERT INTO `jumlah_v` (`id_jumlah`, `id_s`, `hasil`) VALUES
(1, 1, 61.6743),
(2, 1, 61.6743),
(3, 1, 61.6743),
(4, 1, 61.7062),
(5, 1, 61.7054),
(6, 1, 61.8128),
(7, 1, 61.9016),
(8, 1, 61.7062),
(9, 1, 61.7062);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kepentingan`
--

CREATE TABLE `kepentingan` (
  `id_kep` int(11) NOT NULL,
  `id_krit` int(11) NOT NULL,
  `id_norm` int(11) NOT NULL,
  `hasil` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kepentingan`
--

INSERT INTO `kepentingan` (`id_kep`, `id_krit`, `id_norm`, `hasil`) VALUES
(1, 1, 1, -0.2),
(2, 2, 2, 0.16),
(3, 3, 3, 0.12),
(4, 4, 4, -0.08),
(5, 5, 5, 0.04),
(6, 6, 6, 0.08),
(7, 7, 7, 0.12),
(8, 8, 8, 0.2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kriteria`
--

CREATE TABLE `kriteria` (
  `id_krit` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `bobot` float NOT NULL,
  `kepentingan` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kriteria`
--

INSERT INTO `kriteria` (`id_krit`, `nama`, `bobot`, `kepentingan`) VALUES
(1, 'Harga', 25, -1),
(2, 'Web', 20, 1),
(3, 'Prosesor', 15, 1),
(4, 'Bobot', 10, -1),
(5, 'Layar', 5, 1),
(6, 'RAM', 10, 1),
(7, 'Kamera', 15, 1),
(8, 'Memori', 25, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilai`
--

CREATE TABLE `nilai` (
  `id_nilai` int(11) NOT NULL,
  `id_alt` int(11) NOT NULL,
  `id_krit` int(11) NOT NULL,
  `nilai` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nilai`
--

INSERT INTO `nilai` (`id_nilai`, `id_alt`, `id_krit`, `nilai`) VALUES
(1, 1, 1, 210000),
(2, 1, 2, 7200),
(3, 1, 3, 800),
(4, 1, 4, 150),
(5, 1, 5, 3.5),
(6, 1, 6, 256),
(7, 1, 7, 3),
(8, 1, 8, 6),
(9, 2, 1, 2000000),
(10, 2, 2, 7200),
(11, 2, 3, 600),
(12, 2, 4, 155),
(13, 2, 5, 3.7),
(14, 2, 6, 512),
(15, 2, 7, 5),
(16, 2, 8, 4),
(17, 3, 1, 2450000),
(18, 3, 2, 7200),
(19, 3, 3, 1000),
(20, 3, 4, 140),
(21, 3, 5, 3.7),
(22, 3, 6, 256),
(23, 3, 7, 3),
(24, 3, 8, 6),
(25, 4, 1, 2500000),
(26, 4, 2, 7200),
(27, 4, 3, 1200),
(28, 4, 4, 140),
(29, 4, 5, 4),
(30, 4, 6, 256),
(31, 4, 7, 5),
(32, 4, 8, 4),
(33, 5, 1, 2600000),
(34, 5, 2, 7200),
(35, 5, 3, 1200),
(36, 5, 4, 135),
(37, 5, 5, 3.7),
(38, 5, 6, 512),
(39, 5, 7, 5),
(40, 5, 8, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `norm_bobot`
--

CREATE TABLE `norm_bobot` (
  `id_norm` int(11) NOT NULL,
  `id_krit` int(11) NOT NULL,
  `bobot_norm` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `norm_bobot`
--

INSERT INTO `norm_bobot` (`id_norm`, `id_krit`, `bobot_norm`) VALUES
(1, 1, 0.2),
(2, 2, 0.16),
(3, 3, 0.12),
(4, 4, 0.08),
(5, 5, 0.04),
(6, 6, 0.08),
(7, 7, 0.12),
(8, 8, 0.2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pangkat`
--

CREATE TABLE `pangkat` (
  `id_pangkat` int(11) NOT NULL,
  `id_trans` int(11) NOT NULL,
  `id_alt` int(11) NOT NULL,
  `pangkat` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pangkat`
--

INSERT INTO `pangkat` (`id_pangkat`, `id_trans`, `id_alt`, `pangkat`) VALUES
(1, 1, 1, 61.6743),
(2, 1, 1, 61.6743),
(3, 1, 1, 61.6743),
(4, 1, 1, 61.7062),
(5, 1, 1, 61.7054),
(6, 1, 1, 61.8128),
(7, 1, 1, 61.9016),
(8, 1, 1, 61.7062),
(9, 1, 1, 61.7062);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_trans` int(11) NOT NULL,
  `id_alt` int(11) NOT NULL,
  `id_krit` int(11) NOT NULL,
  `nilai_alt` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_trans`, `id_alt`, `id_krit`, `nilai_alt`) VALUES
(1, 1, 1, 0.0862097),
(2, 1, 2, 4.14165),
(3, 1, 3, 2.23034),
(4, 1, 4, 0.66975),
(5, 1, 5, 1.05139),
(6, 1, 6, 1.55833),
(7, 1, 7, 1.14092),
(8, 1, 8, 1.43097),
(9, 2, 1, 0.054928),
(10, 2, 2, 4.14165),
(11, 2, 3, 2.15466),
(12, 2, 4, 0.667995),
(13, 2, 5, 1.05373),
(14, 2, 6, 1.64718),
(15, 2, 7, 1.21304),
(16, 2, 8, 1.31951),
(17, 3, 1, 0.0527432),
(18, 3, 2, 4.14165),
(19, 3, 3, 2.29087),
(20, 3, 4, 0.673457),
(21, 3, 5, 1.05373),
(22, 3, 6, 1.55833),
(23, 3, 7, 1.14092),
(24, 3, 8, 1.43097),
(25, 4, 1, 0.0525306),
(26, 4, 2, 4.14165),
(27, 4, 3, 2.34154),
(28, 4, 4, 0.673457),
(29, 4, 5, 1.05702),
(30, 4, 6, 1.55833),
(31, 4, 7, 1.21304),
(32, 4, 8, 1.31951),
(33, 5, 1, 0.0521201),
(34, 5, 2, 4.14165),
(35, 5, 3, 2.34154),
(36, 5, 4, 0.675419),
(37, 5, 5, 1.05373),
(38, 5, 6, 1.64718),
(39, 5, 7, 1.21304),
(40, 5, 8, 1.31951);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `alternatif`
--
ALTER TABLE `alternatif`
  ADD PRIMARY KEY (`id_alt`);

--
-- Indeks untuk tabel `hasil`
--
ALTER TABLE `hasil`
  ADD PRIMARY KEY (`id_rank`);

--
-- Indeks untuk tabel `hitung_b`
--
ALTER TABLE `hitung_b`
  ADD PRIMARY KEY (`id_bhitung`);

--
-- Indeks untuk tabel `hitung_s`
--
ALTER TABLE `hitung_s`
  ADD PRIMARY KEY (`id_s`);

--
-- Indeks untuk tabel `hitung_v`
--
ALTER TABLE `hitung_v`
  ADD PRIMARY KEY (`id_v`);

--
-- Indeks untuk tabel `jumlah_b`
--
ALTER TABLE `jumlah_b`
  ADD PRIMARY KEY (`id_jumlh`);

--
-- Indeks untuk tabel `jumlah_v`
--
ALTER TABLE `jumlah_v`
  ADD PRIMARY KEY (`id_jumlah`);

--
-- Indeks untuk tabel `kepentingan`
--
ALTER TABLE `kepentingan`
  ADD PRIMARY KEY (`id_kep`);

--
-- Indeks untuk tabel `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`id_krit`);

--
-- Indeks untuk tabel `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`id_nilai`);

--
-- Indeks untuk tabel `norm_bobot`
--
ALTER TABLE `norm_bobot`
  ADD PRIMARY KEY (`id_norm`);

--
-- Indeks untuk tabel `pangkat`
--
ALTER TABLE `pangkat`
  ADD PRIMARY KEY (`id_pangkat`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_trans`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `alternatif`
--
ALTER TABLE `alternatif`
  MODIFY `id_alt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `hasil`
--
ALTER TABLE `hasil`
  MODIFY `id_rank` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `hitung_b`
--
ALTER TABLE `hitung_b`
  MODIFY `id_bhitung` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `hitung_s`
--
ALTER TABLE `hitung_s`
  MODIFY `id_s` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `hitung_v`
--
ALTER TABLE `hitung_v`
  MODIFY `id_v` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `jumlah_b`
--
ALTER TABLE `jumlah_b`
  MODIFY `id_jumlh` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `jumlah_v`
--
ALTER TABLE `jumlah_v`
  MODIFY `id_jumlah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `kepentingan`
--
ALTER TABLE `kepentingan`
  MODIFY `id_kep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `kriteria`
--
ALTER TABLE `kriteria`
  MODIFY `id_krit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `nilai`
--
ALTER TABLE `nilai`
  MODIFY `id_nilai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT untuk tabel `norm_bobot`
--
ALTER TABLE `norm_bobot`
  MODIFY `id_norm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `pangkat`
--
ALTER TABLE `pangkat`
  MODIFY `id_pangkat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_trans` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
