-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 07, 2025 at 08:07 PM
-- Server version: 8.0.30
-- PHP Version: 8.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_java_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `budi`
--

CREATE TABLE `budi` (
  `id` int NOT NULL,
  `nama_pakaian` varchar(32) DEFAULT NULL,
  `warna` varchar(16) DEFAULT NULL,
  `kategori` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `outfit_budi`
--

CREATE TABLE `outfit_budi` (
  `id` int NOT NULL,
  `nama_outfit` varchar(32) NOT NULL,
  `pakaian` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_admin`
--

CREATE TABLE `tb_admin` (
  `id` int NOT NULL,
  `nama_admin` varchar(64) NOT NULL,
  `alamat_admin` varchar(64) NOT NULL,
  `nomor_admin` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_admin`
--

INSERT INTO `tb_admin` (`id`, `nama_admin`, `alamat_admin`, `nomor_admin`) VALUES
(1, 'Baqiyatus', 'Bangkalan', '088888888881'),
(2, 'Sholah', 'Sampang', '088888888882');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengguna`
--

CREATE TABLE `tb_pengguna` (
  `username` varchar(16) NOT NULL,
  `pass_user` varchar(64) NOT NULL,
  `nama_user` varchar(64) NOT NULL,
  `nomor_user` varchar(64) NOT NULL,
  `alamat_user` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_pengguna`
--

INSERT INTO `tb_pengguna` (`username`, `pass_user`, `nama_user`, `nomor_user`, `alamat_user`) VALUES
('budi', 'budi123', 'Budi Susanto', '088888888881', 'Bangkalan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `budi`
--
ALTER TABLE `budi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `outfit_budi`
--
ALTER TABLE `outfit_budi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_pengguna`
--
ALTER TABLE `tb_pengguna`
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `budi`
--
ALTER TABLE `budi`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `outfit_budi`
--
ALTER TABLE `outfit_budi`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
