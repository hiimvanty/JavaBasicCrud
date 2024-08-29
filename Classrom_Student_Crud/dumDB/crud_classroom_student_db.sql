-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2024 at 05:53 AM
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
-- Database: `crud_classroom_student_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `class_rooms`
--

CREATE TABLE `class_rooms` (
  `id` bigint(20) NOT NULL,
  `classroom_code` varchar(255) NOT NULL,
  `classroom_name` varchar(255) NOT NULL,
  `phone_of_teacher` varchar(255) NOT NULL,
  `teacher_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `class_rooms`
--

INSERT INTO `class_rooms` (`id`, `classroom_code`, `classroom_name`, `phone_of_teacher`, `teacher_name`) VALUES
(2, '1720A1', '12A1', '061362649', 'Giáo Viên A1'),
(3, '1720A2', '12A2', '0613626290', 'Giáo Viên A2'),
(7, '1720A5', '12A5', '0312361521', 'Giáo viên A5'),
(10, '1720A11', '12A11', '0975623104', 'Giáo viên A11');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `date_of_birth` datetime(6) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `student_code` varchar(255) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `student_phone` varchar(255) NOT NULL,
  `classroom_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `address`, `date_of_birth`, `gender`, `student_code`, `student_name`, `student_phone`, `classroom_id`) VALUES
(16, 'Hòa Hiệp Bắc', '2002-11-03 07:00:00.000000', 'Nữ', '20200tk', 'Trần Thị Thúy Kiều', '0379896000', 10),
(17, 'Hòa Xuân Tây', '2002-01-06 07:00:00.000000', 'Nam', '20200vt', 'Nguyễn Văn Tỵ', '0975923000', 10),
(18, 'Hòa Hiệp Bắc', '2002-06-13 07:00:00.000000', 'Nữ', '20200td', 'Trương Nguyễn Thục Đoan', '0312645987', 10),
(19, 'Hòa Tân', '2002-05-09 07:00:00.000000', 'Nữ', '20200md', 'Trần Thị Mỹ Duyên', '0312645987', 10),
(20, 'Hòa Tân', '2002-09-06 07:00:00.000000', 'Nữ', '20200ht', 'Nguyễn Thị Hoài Thơ', '0312645982', 10),
(23, 'Thành phố Hồ Chí Minh', '2002-01-01 07:00:00.000000', 'Nam', 'a5st', 'Hoàn Trùng Nguyên', '0312654987', 7),
(24, 'Thủ đô Hà Nội', '2002-01-01 07:00:00.000000', 'Nam', 'a5la', 'Lê Hoàng An', '0123456789', 7),
(25, 'Hoàn Kiếm, Hà Nội', '2002-01-01 07:00:00.000000', 'Nam', 'a2tk', 'Tôn Quốc Kiên', '0123456789', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class_rooms`
--
ALTER TABLE `class_rooms`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKp5qggm6w90f2yqoscwc938xuv` (`classroom_code`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKcgcf3r5xk73o0etbduc1qxnol` (`student_code`),
  ADD KEY `FKpq0o62iqp8d895ksmv3nplcpr` (`classroom_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `class_rooms`
--
ALTER TABLE `class_rooms`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `FKpq0o62iqp8d895ksmv3nplcpr` FOREIGN KEY (`classroom_id`) REFERENCES `class_rooms` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
