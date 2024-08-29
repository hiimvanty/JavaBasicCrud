-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2024 at 09:59 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task_60.70-80_customer_order_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `corder`
--

CREATE TABLE `corder` (
  `id` bigint(20) NOT NULL,
  `order_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `paid` bigint(20) DEFAULT NULL,
  `pizza_size` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pizza_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `voucher_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `corder`
--

INSERT INTO `corder` (`id`, `order_code`, `paid`, `pizza_size`, `pizza_type`, `price`, `voucher_code`, `customer_id`) VALUES
(1, 'order_code_1', 10, 'S', 'Trái Cây', 100, 'voucher_code_10', 1),
(2, 'order_code_2', 200, 'M', 'Hai San', 200, 'voucher_code_2', 2),
(3, 'order_code_3', 300, 'L', 'Pizza Phô Mai Mozzarella không ngon thì trả tiền', 300, 'voucher_code_3', 3);

-- --------------------------------------------------------

--
-- Table structure for table `cproduct`
--

CREATE TABLE `cproduct` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cproduct`
--

INSERT INTO `cproduct` (`id`, `color`, `name`, `price`, `type`, `order_id`) VALUES
(1, 'Vàng', 'Pizza Nhiệt đới', '100', 'Hạnh phúc', 1),
(2, 'Đen', 'Pizza Địa Ngục', '200', 'Hải Sản', 2),
(3, 'Đỏ', 'Pizza Mặt Trời', '300', 'pizza Vuông', 3);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `adress` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `full_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `adress`, `email`, `full_name`, `phone`) VALUES
(1, 'Ha Noi', 'hanoi@gmail.com', 'Nguyen Ha Noi', '030000300'),
(2, 'Sai Hon', 'nguyensaihon@gmail.com', 'Nguyen Sai Hon', '0302010203'),
(3, 'Da Nang', 'danang@gmail.com', 'Nguyen Da Nang', '094562137');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `corder`
--
ALTER TABLE `corder`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK4riftn27vddk008xli0mipwqn` (`order_code`),
  ADD KEY `FKj18fxaqmery6w1og0v5nwoels` (`customer_id`);

--
-- Indexes for table `cproduct`
--
ALTER TABLE `cproduct`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKffihurodwu5tnissnp9kv657w` (`order_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKdwk6cx0afu8bs9o4t536v1j5v` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `corder`
--
ALTER TABLE `corder`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `cproduct`
--
ALTER TABLE `cproduct`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `corder`
--
ALTER TABLE `corder`
  ADD CONSTRAINT `FKj18fxaqmery6w1og0v5nwoels` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Constraints for table `cproduct`
--
ALTER TABLE `cproduct`
  ADD CONSTRAINT `FKffihurodwu5tnissnp9kv657w` FOREIGN KEY (`order_id`) REFERENCES `corder` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
