-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2017 at 12:28 PM
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
  `media_url` varchar(75) NOT NULL,
  `longitude` varchar(50) NOT NULL,
  `latitude` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'Reynold Kevin', 'reynoldkevin@gmail.com', '1234', 'default', '1');

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
  MODIFY `id_comment` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `h_moment`
--
ALTER TABLE `h_moment`
  MODIFY `id_moment` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
