-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: bdbarmr9bpoyjedn4yyi-mysql.services.clever-cloud.com:3306
-- Generation Time: Nov 26, 2021 at 08:51 PM
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
(1, 5, 'charissa', 'morales', 'charissamorales@gmail.om', 'somewhere', 'charissa', 'complex', 1),
(6, 1, 'Billy', 'Crawford', 'thuexcursionbill@gmail.com', 'rissa', 'billcrawford', 'confidential', 1),
(7, 2, 'Bill', 'Scroggins', 'BillFScroggins@jourrapide.com', '753 Desert Broom Court', 'billscrogg', 'confidential', 1);

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

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`idBooking`, `bookingDate`, `bookedBy`, `idExcursion`) VALUES
(1, NULL, 1, 12),
(2, NULL, 1, 13);

-- --------------------------------------------------------

--
-- Table structure for table `excursion`
--

CREATE TABLE `excursion` (
  `idExcursion` int NOT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `dateadded` date DEFAULT NULL,
  `MaxParticipants` int DEFAULT NULL,
  `RegDeadline` date DEFAULT NULL,
  `DeregDeadline` date DEFAULT NULL,
  `MeetingDetails` varchar(255) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `RequestedBy` int DEFAULT NULL,
  `date_of_excursion` date DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `excursion_fee` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `excursion`
--

INSERT INTO `excursion` (`idExcursion`, `Description`, `dateadded`, `MaxParticipants`, `RegDeadline`, `DeregDeadline`, `MeetingDetails`, `Title`, `RequestedBy`, `date_of_excursion`, `destination`, `excursion_fee`) VALUES
(12, 'Neuschwanstein Castle and Linderhof Palace Day Tour from Munich', '2021-01-01', 25, '2021-01-15', '2021-01-30', 'Ulm HBF', 'Neuschwanstein Castle and Linderhof Palace', 1, '2021-02-02', 'Munich', 60),
(13, 'Exclusive and Unique Romantic Road Tour from Munich to Rothenberg', '2021-08-01', 25, '2021-08-15', '2021-08-30', 'Ulm HBF', 'Romantic Road in Rothenberg', 1, '2021-09-04', 'Rothenberg', 25),
(14, 'Private Scenic Transfer from Frankfurt to Munich with 4h of Sightseeing', '2021-11-01', 25, '2021-11-15', '2021-11-27', 'Ulm HBF', 'Sightseeing in Munich', 1, '2021-12-06', 'Munich', 50),
(18, 'Dachau Concentration Camp Memorial Site Tour from Munich by Train', '2022-01-01', 25, '2022-01-15', '2022-01-31', 'Ulm HBF', 'Concentration Camp', 1, '2022-02-08', 'Munich', 90),
(19, 'Heidelberg Half-Day Trip from Frankfurt', '2022-02-01', 25, '2022-02-01', '2022-02-15', 'Ulm HBF', 'Heidelberg Half-day Trip', 1, '2022-02-18', 'Heidelberg', 35),
(20, 'Private Rhine Valley Day Trip from Frankfurt With Wine Tasting', '2022-03-03', 25, '2022-03-15', '2022-03-25', 'Ulm HBF', 'Rhine Valley Day Trip', 1, '2022-03-28', 'Frankfurt', 32),
(21, 'Berlin Complete History All Day Tour', '2023-06-02', 25, '2023-06-17', '2023-06-27', 'Ulm HBF', 'Berlin History Tour', 1, '2023-06-29', 'Berlin', 25),
(22, 'Sachsenhausen Concentration Camp Memorial Tour from Berlin', '2023-08-01', 25, '2023-08-15', '2023-08-29', 'Ulm HBF', 'Sachsenhausen Camp', 1, '2023-09-02', 'Berlin', 36),
(23, 'City Tour Cologne', '2023-09-01', 25, '2023-09-15', '2023-09-25', 'Ulm HBF', 'City Tour in Cologne', 1, '2023-09-26', 'Cologne', 65),
(24, 'Day Trip from Munich to Salzburg', '2023-10-01', 25, '2023-10-15', '2023-10-21', 'Ulm Hbf', 'Day Trip Salzburg', 1, '2023-10-25', 'Salzburg', 20);

-- --------------------------------------------------------

--
-- Table structure for table `excursionapproval`
--

CREATE TABLE `excursionapproval` (
  `idExcursionApproval` int NOT NULL,
  `is_approved` tinyint NOT NULL DEFAULT '0',
  `dateReviewed` date DEFAULT NULL,
  `reviewedBy` int DEFAULT NULL,
  `excursion_idExcursion` int NOT NULL,
  `approval_status` tinyint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `excursionapproval`
--

INSERT INTO `excursionapproval` (`idExcursionApproval`, `is_approved`, `dateReviewed`, `reviewedBy`, `excursion_idExcursion`, `approval_status`) VALUES
(1, 1, '2021-01-02', 0, 12, 1),
(2, 0, '2021-08-02', 0, 13, 1),
(3, 0, '2021-11-02', 0, 14, 1),
(4, 1, '2022-01-02', 6, 18, 1),
(5, 0, '2022-02-02', 6, 19, 1),
(6, 0, '2022-03-04', 6, 20, 0),
(7, 1, '2023-06-03', 6, 21, 0),
(8, 1, '2023-08-02', 6, 22, 0),
(9, 0, '2023-09-02', 6, 23, 2),
(10, 0, '2023-10-02', 6, 24, 2);

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

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`idStudent`, `matriculationNumber`, `firstName`, `lastName`, `email`, `address`, `username`, `password`, `isActive`) VALUES
(1, 1, 'charissa', 'morales', 'sample', 'sample', 'cha', 'cha', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `member_number` int DEFAULT NULL,
  `user_type` char(2) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `member_number`, `user_type`, `username`, `password`, `is_active`) VALUES
(1, 6, 'a', 'billcrawford', 'confidential', 1),
(2, 55512, 'o', 'chrislawrence', 'complex', 1),
(3, 313001, 's', 'shilogonzaga', 'complex', 1),
(4, 313002, 's', 'lunafox', 'confidential', 1);

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
  ADD KEY `fk_excursionapproval_excursion1_idx` (`excursion_idExcursion`);

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
  MODIFY `idAdmin` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `idBooking` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `excursion`
--
ALTER TABLE `excursion`
  MODIFY `idExcursion` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `excursionapproval`
--
ALTER TABLE `excursionapproval`
  MODIFY `idExcursionApproval` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `organizer`
--
ALTER TABLE `organizer`
  MODIFY `idOrganizer` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  ADD CONSTRAINT `fk_excursionapproval_excursion1` FOREIGN KEY (`excursion_idExcursion`) REFERENCES `excursion` (`idExcursion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
