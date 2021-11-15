-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: bdbarmr9bpoyjedn4yyi-mysql.services.clever-cloud.com:3306
-- Generation Time: Nov 11, 2021 at 11:30 PM
-- Server version: 8.0.22-13
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdbarmr9bpoyjedn4yyi`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int NOT NULL,
  `employeeNumber` int DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `isActive` tinyint NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`idAdmin`, `employeeNumber`, `firstName`, `lastName`, `email`, `address`, `username`, `password`, `isActive`) VALUES
(6, 1, 'Billy', 'Crawford', 'thuexcursionbill@gmail.com', 'Plathvilles', 'billcrawford', 'confidential', 1),
(7, 2, 'Bill', 'Scroggins', 'BillFScroggins@jourrapide.com', '753 Desert Broom Court', 'billscrogg', 'confidential', 1),
(8, 3, 'Shiloh', 'Gonzaga', 'shilohgonzaga@jourrapide.com', '753 Desert Broom Court', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `idBooking` int NOT NULL,
  `bookingDate` datetime DEFAULT NULL,
  `bookedBy` int NOT NULL,
  `idExcursion` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `excursion`
--

CREATE TABLE `excursion` (
  `idExcursion` int NOT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `DateAdded` datetime DEFAULT NULL,
  `MaxParticipants` int DEFAULT NULL,
  `RegDeadline` datetime DEFAULT NULL,
  `DeregDeadline` datetime DEFAULT NULL,
  `MeetingDetails` varchar(255) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `RequestedBy` int DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `excursion`
--

INSERT INTO `excursion` (`idExcursion`, `Description`, `DateAdded`, `MaxParticipants`, `RegDeadline`, `DeregDeadline`, `MeetingDetails`, `Title`, `RequestedBy`, `destination`) VALUES
(1, 'Day Trip to Neuschwanstein and Linderhof Castles from Munich', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Neuschwanstein and Linderhof Castles', 1, NULL),
(2, '2 Hour Sightseeing Tour in classic VW Bus', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Berlin', 1, NULL),
(3, 'An Evening of Bavarian Beer and Food Culture', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Munich', 1, NULL),
(4, '2-Hour Segway Tour of Dusseldorf, or VIP Segway Tour', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Dusseldorf', 1, NULL),
(5, '6-Hour Tour from Frankfurt', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Heidelberg', 1, NULL),
(6, '6-Hour Tour from Frankfurt', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Heidelberg', 1, NULL),
(7, '6-Hour Tour from Frankfurt', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Heidelberg', 1, NULL),
(8, '6-Hour Tour from Frankfurt', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Heidelberg', 1, NULL),
(9, '6-Hour Tour from Frankfurt', '9999-12-31 23:59:59', 25, '9999-12-31 23:59:59', '9999-12-31 23:59:59', 'Ulm HBF', 'Heidelberg', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `excursionapproval`
--

CREATE TABLE `excursionapproval` (
  `idExcursionApproval` int NOT NULL,
  `is_approved` tinyint NOT NULL DEFAULT '0',
  `dateReviewed` datetime DEFAULT NULL,
  `reviewedBy` int DEFAULT NULL,
  `excursion_idExcursion` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `excursionapproval`
--

INSERT INTO `excursionapproval` (`idExcursionApproval`, `is_approved`, `dateReviewed`, `reviewedBy`, `excursion_idExcursion`) VALUES
(1, 0, '9999-12-31 23:59:59', 6, 1),
(2, 0, '9999-12-31 23:59:59', 6, 2),
(3, 0, '9999-12-31 23:59:59', 6, 3),
(4, 0, '9999-12-31 23:59:59', 6, 4),
(5, 0, '9999-12-31 23:59:59', 6, 5),
(6, 0, '9999-12-31 23:59:59', 6, 6),
(7, 0, '9999-12-31 23:59:59', 6, 7),
(8, 0, '9999-12-31 23:59:59', 6, 8),
(9, 0, '9999-12-31 23:59:59', 6, 9);

-- --------------------------------------------------------

--
-- Table structure for table `organizer`
--

CREATE TABLE `organizer` (
  `idOrganizer` int NOT NULL,
  `employeeNumber` int DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `isActive` tinyint NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `organizer`
--

INSERT INTO `organizer` (`idOrganizer`, `employeeNumber`, `firstName`, `lastName`, `email`, `address`, `username`, `password`, `isActive`) VALUES
(2, 55512, 'Christopher', 'Lawrence', 'ChristopherMLawrence@jourrapide.com', '4921 Doe Meadow Drive', 'Princeed', 'OhZ0yaigh6', 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `idStudent` int NOT NULL,
  `matriculationNumber` int DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `isActive` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `uni_number` int DEFAULT NULL,
  `user_type` char(2) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `uni_number`, `user_type`, `username`, `password`, `is_active`) VALUES
(1, 6, 'a', 'billcrawford', 'confidential', NULL),
(2, 55512, 'o', 'chrislawrence', 'complex', NULL),
(3, 313001, 's', 'shilogonzaga', 'complex', NULL),
(4, 313001, 'z', 'lunafox', 'confidential', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `usertype`
--

CREATE TABLE `usertype` (
  `id` int NOT NULL,
  `user_type` char(2) DEFAULT NULL,
  `user_description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usertype`
--

INSERT INTO `usertype` (`id`, `user_type`, `user_description`) VALUES
(1, 'a', 'admin'),
(2, 'o', 'organizer'),
(3, 's', 'student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`idBooking`,`bookedBy`),
  ADD KEY `fk_Booking_Student1_idx` (`bookedBy`);

--
-- Indexes for table `excursion`
--
ALTER TABLE `excursion`
  ADD PRIMARY KEY (`idExcursion`);

--
-- Indexes for table `excursionapproval`
--
ALTER TABLE `excursionapproval`
  ADD PRIMARY KEY (`idExcursionApproval`),
  ADD KEY `fk_ExcursionApproval_Excursion_idx` (`excursion_idExcursion`);

--
-- Indexes for table `organizer`
--
ALTER TABLE `organizer`
  ADD PRIMARY KEY (`idOrganizer`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`idStudent`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_type_fk_id` (`user_type`),
  ADD KEY `user_type_fk_idx` (`user_type`);

--
-- Indexes for table `usertype`
--
ALTER TABLE `usertype`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `idBooking` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `excursion`
--
ALTER TABLE `excursion`
  MODIFY `idExcursion` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `excursionapproval`
--
ALTER TABLE `excursionapproval`
  MODIFY `idExcursionApproval` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `organizer`
--
ALTER TABLE `organizer`
  MODIFY `idOrganizer` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `idStudent` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `fk_Booking_Student1` FOREIGN KEY (`bookedBy`) REFERENCES `student` (`idStudent`);

--
-- Constraints for table `excursionapproval`
--
ALTER TABLE `excursionapproval`
  ADD CONSTRAINT `fk_ExcursionApproval_Excursion` FOREIGN KEY (`excursion_idExcursion`) REFERENCES `excursion` (`idExcursion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
