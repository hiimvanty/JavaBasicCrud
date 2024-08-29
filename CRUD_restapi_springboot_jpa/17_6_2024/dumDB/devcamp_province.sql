-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2024 at 10:26 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `devcamp_province`
--

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prefix` varchar(255) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`id`, `name`, `prefix`, `province_id`) VALUES
(10, 'Quận Ba Đình', 'quận', 4),
(11, 'Quận Hoàn Kiếm', 'quận', 4),
(26, 'Quận 4', 'Quận', 3),
(27, 'Quận 5', 'Quận', 3),
(31, 'Quận 1', 'Quận', 3),
(59, 'Quy Nhơn', 'Thành Phố', 37),
(60, 'Phường 2', 'Phường', 37),
(61, 'Phường 1', 'Phường', 38),
(62, 'phường 1', 'phường', 39),
(63, 'phường 2', 'phường', 39),
(64, 'phường 3', 'phường', 39),
(65, 'phường 4', 'phường', 39);

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`id`, `code`, `name`) VALUES
(3, 'Tp HCM', 'Tp Hồ Chí Minh'),
(4, 'HN', 'Hà Nội'),
(37, 'BD', 'Bình Định'),
(38, 'DN', 'Đà Nẵng'),
(39, 'BR-VT', 'Bà Rịa Vũng Tàu');

-- --------------------------------------------------------

--
-- Table structure for table `ward`
--

CREATE TABLE `ward` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prefix` varchar(255) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ward`
--

INSERT INTO `ward` (`id`, `name`, `prefix`, `district_id`) VALUES
(6, 'Phường Cống Vị', 'phường', 10),
(7, 'Phường Liễu Giai', 'phường', 10),
(8, 'Phường Ngọc Hà', 'phường', 10),
(9, 'Phường Phúc Xá', 'phường', 10),
(10, 'Phường Quán Thánh', 'phường', 10),
(11, 'Phường Trúc Bạch', 'phường', 10),
(12, 'Phường Vĩnh Phúc', 'phường', 10),
(13, 'Phường Cửa Đông', 'phường', 11),
(14, 'Phường Cửa Nam', 'phường', 11),
(15, 'Phường Hàng Bạc', 'phường', 11),
(16, 'Phường Hàng Bồ', 'phường', 11),
(17, 'Phường Hàng Đào', 'phường', 11),
(18, 'Phường Hàng Gai', 'phường', 11),
(19, 'Phường Hàng Khay', 'phường', 11),
(20, 'Phường Lý Thái Tổ', 'phường', 11),
(21, 'Phường Phan Chu Trinh', 'phường', 11),
(22, 'Phường Tràng Tiền', 'phường', 11),
(23, 'Phường 1', 'Phường', 26),
(24, 'Phường 2', 'Phường', 26),
(25, 'Phường 3', 'Phường', 26),
(26, 'Phường 1', 'Phường', 27),
(27, 'Phường 2', 'Phường', 27),
(28, 'Phường 3', 'Phường', 27),
(29, 'Phố đi bộ Nguyễn Huệ', 'Phố', 31),
(30, 'San Hô', 'Đảo', NULL),
(31, 'Phường 7', 'phường', NULL),
(32, 'QA', 'NE', NULL),
(33, 'Phường 7', 'Phường 7', NULL),
(34, 'Phường 1', 'Phường', 59),
(35, 'Đại Học Đông Á', 'Đại học', 61),
(36, 'Đường Nguyễn Chí Thanh', 'Đường', 65);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK276utu38g5lgqeth6pwfm3rw2` (`province_id`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6k05k4x3elbtlqxrmsuere05q` (`code`);

--
-- Indexes for table `ward`
--
ALTER TABLE `ward`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKslko72wj5nauqvsgefqkvwpsb` (`district_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `district`
--
ALTER TABLE `district`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `ward`
--
ALTER TABLE `ward`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `FK276utu38g5lgqeth6pwfm3rw2` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`);

--
-- Constraints for table `ward`
--
ALTER TABLE `ward`
  ADD CONSTRAINT `FKslko72wj5nauqvsgefqkvwpsb` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
