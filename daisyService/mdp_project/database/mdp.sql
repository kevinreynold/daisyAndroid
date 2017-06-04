-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2017 at 02:19 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mdp`
--

-- --------------------------------------------------------

--
-- Table structure for table `d_like_moment`
--

CREATE TABLE `d_like_moment` (
  `id_moment` int(11) NOT NULL,
  `id_user` int(50) NOT NULL,
  `tanggal` date NOT NULL,
  `waktu` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `d_like_moment`
--

INSERT INTO `d_like_moment` (`id_moment`, `id_user`, `tanggal`, `waktu`) VALUES
(2, 1, '2017-06-08', '23:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `friend`
--

CREATE TABLE `friend` (
  `id_user1` int(50) NOT NULL,
  `id_user2` int(50) NOT NULL,
  `status_accept` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `h_comment`
--

CREATE TABLE `h_comment` (
  `id_comment` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `waktu` time NOT NULL,
  `message` varchar(255) NOT NULL,
  `id_moment` int(11) NOT NULL,
  `id_user` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `h_comment`
--

INSERT INTO `h_comment` (`id_comment`, `tanggal`, `waktu`, `message`, `id_moment`, `id_user`) VALUES
(1, '2017-06-08', '08:14:15', 'Mantap', 2, 2),
(2, '2017-06-08', '15:12:33', 'Gila wkakaka', 2, 1),
(3, '2017-06-14', '05:00:00', '...', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `h_moment`
--

CREATE TABLE `h_moment` (
  `id_moment` int(11) NOT NULL,
  `description` varchar(144) NOT NULL,
  `tanggal` date NOT NULL,
  `waktu` time NOT NULL,
  `like_count` int(5) NOT NULL,
  `comment_count` int(5) NOT NULL,
  `id_user` int(50) NOT NULL,
  `media_url` varchar(75) DEFAULT NULL,
  `longitude` varchar(50) DEFAULT NULL,
  `latitude` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `h_moment`
--

INSERT INTO `h_moment` (`id_moment`, `description`, `tanggal`, `waktu`, `like_count`, `comment_count`, `id_user`, `media_url`, `longitude`, `latitude`) VALUES
(1, 'Halo Semua', '2017-06-04', '18:20:00', 0, 0, 1, NULL, NULL, NULL),
(2, 'Bosan dirumah :(', '2017-06-05', '21:10:30', 0, 0, 1, NULL, '-7.31313', '112.76408'),
(3, 'Ayo mainn!!', '2017-06-05', '12:05:11', 0, 0, 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(50) NOT NULL,
  `nama_user` varchar(50) NOT NULL,
  `email` varchar(75) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profile_foto_url` varchar(75) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama_user`, `email`, `password`, `profile_foto_url`, `status`) VALUES
(1, 'Reynold Kevin', 'reynoldkevin@gmail.com', '1234', 'default', '1'),
(2, 'Budi', 'budibudi@gmail.com', '1234', 'default', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `d_like_moment`
--
ALTER TABLE `d_like_moment`
  ADD PRIMARY KEY (`id_moment`,`id_user`);

--
-- Indexes for table `friend`
--
ALTER TABLE `friend`
  ADD PRIMARY KEY (`id_user1`,`id_user2`);

--
-- Indexes for table `h_comment`
--
ALTER TABLE `h_comment`
  ADD PRIMARY KEY (`id_comment`);

--
-- Indexes for table `h_moment`
--
ALTER TABLE `h_moment`
  ADD PRIMARY KEY (`id_moment`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `h_comment`
--
ALTER TABLE `h_comment`
  MODIFY `id_comment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `h_moment`
--
ALTER TABLE `h_moment`
  MODIFY `id_moment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
