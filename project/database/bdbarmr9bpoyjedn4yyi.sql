-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: bdbarmr9bpoyjedn4yyi-mysql.services.clever-cloud.com:3306
-- Generation Time: Oct 23, 2021 at 02:58 PM
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
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `idAdmin` int NOT NULL,
  `employeeNumber` int DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` int NOT NULL,
  `isActive` tinyint NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`idAdmin`, `employeeNumber`, `firstName`, `lastName`, `email`, `address`, `username`, `password`, `isActive`) VALUES
(1, 1, 'Joey', 'Mafukidze', 'thuexcursion@gmail.com', NULL, '', 0, 0),
(2, 3, 'Zara', 'Ali', 'zaraali@testmail.com', 'prittwitstrasse', '', 0, 0),
(3, 3, 'Zara', 'Ali', 'zaraali@testmail.com', 'prittwitstrasse', '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Booking`
--

CREATE TABLE `Booking` (
  `idBooking` int NOT NULL,
  `bookingDate` datetime DEFAULT NULL,
  `bookedBy` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Excursion`
--

CREATE TABLE `Excursion` (
  `idExcursion` int NOT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `DateAdded` datetime DEFAULT NULL,
  `MaxParticipants` int DEFAULT NULL,
  `RegDeadline` datetime DEFAULT NULL,
  `DeregDeadline` datetime DEFAULT NULL,
  `MeetingDetails` varchar(255) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `RequestedBy` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Excursion`
--

INSERT INTO `Excursion` (`idExcursion`, `Description`, `DateAdded`, `MaxParticipants`, `RegDeadline`, `DeregDeadline`, `MeetingDetails`, `Title`, `RequestedBy`) VALUES
(1, 'excursion1', '2021-10-20 23:59:59', 30, '2021-12-30 23:59:59', '2021-12-30 23:59:59', NULL, 'excursion1', 2);

-- --------------------------------------------------------

--
-- Table structure for table `ExcursionApproval`
--

CREATE TABLE `ExcursionApproval` (
  `idExcursionApproval` int NOT NULL,
  `isApproved` tinyint DEFAULT '0',
  `dateReviewed` datetime DEFAULT NULL,
  `reviewedBy` int DEFAULT NULL,
  `Excursion_idExcursion` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Organizer`
--

CREATE TABLE `Organizer` (
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
-- Dumping data for table `Organizer`
--

INSERT INTO `Organizer` (`idOrganizer`, `employeeNumber`, `firstName`, `lastName`, `email`, `address`, `username`, `password`, `isActive`) VALUES
(1, 2, 'Charissa ', 'Morales', 'thuexcursion@gmail.com', 'prittwitstrasse', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

CREATE TABLE `Student` (
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

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`idStudent`, `matriculationNumber`, `firstName`, `lastName`, `email`, `address`, `username`, `password`, `isActive`) VALUES
(1, 3, 'Mistica', 'Someone', 'thuexcursion@gmail.com', 'dort', '', '', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `Booking`
--
ALTER TABLE `Booking`
  ADD PRIMARY KEY (`idBooking`,`bookedBy`),
  ADD KEY `fk_Booking_Student1_idx` (`bookedBy`);

--
-- Indexes for table `Excursion`
--
ALTER TABLE `Excursion`
  ADD PRIMARY KEY (`idExcursion`);

--
-- Indexes for table `ExcursionApproval`
--
ALTER TABLE `ExcursionApproval`
  ADD PRIMARY KEY (`idExcursionApproval`,`Excursion_idExcursion`),
  ADD KEY `fk_ExcursionApproval_Excursion_idx` (`Excursion_idExcursion`);

--
-- Indexes for table `Organizer`
--
ALTER TABLE `Organizer`
  ADD PRIMARY KEY (`idOrganizer`);

--
-- Indexes for table `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`idStudent`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin`
--
ALTER TABLE `Admin`
  MODIFY `idAdmin` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Organizer`
--
ALTER TABLE `Organizer`
  MODIFY `idOrganizer` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Student`
--
ALTER TABLE `Student`
  MODIFY `idStudent` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Booking`
--
ALTER TABLE `Booking`
  ADD CONSTRAINT `fk_Booking_Student1` FOREIGN KEY (`bookedBy`) REFERENCES `Student` (`idStudent`);

--
-- Constraints for table `ExcursionApproval`
--
ALTER TABLE `ExcursionApproval`
  ADD CONSTRAINT `fk_ExcursionApproval_Excursion` FOREIGN KEY (`Excursion_idExcursion`) REFERENCES `Excursion` (`idExcursion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
