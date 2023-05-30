SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asmjava3`
--

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `id` int(11) NOT NULL,
  `MaSV` varchar(150) NOT NULL,
  `HoTenSV` varchar(150) NOT NULL,
  `TiengAnh` double NOT NULL,
  `TinHoc` double NOT NULL,
  `GDTC` double NOT NULL,
  `DiemTB` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`id`, `MaSV`, `HoTenSV`, `TiengAnh`, `TinHoc`, `GDTC`, `DiemTB`) VALUES
(4, 'PD54', 'Bui Viet Phi', 9, 9, 10, 9.333333333333334),
(5, 'PD57', 'Mong Thi Loi', 10, 10, 10, 10),
(6, 'PD55', 'Phi Dep Trai', 8.5, 10, 10, 9.5),
(7, 'PD56', 'Banh Thi Lo Lieu', 10, 10, 10, 5.333333333333333);

-- --------------------------------------------------------

--
-- Table structure for table `loginfrom`
--

CREATE TABLE `loginfrom` (
  `id` int(11) DEFAULT NULL,
  `usename` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `role` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loginfrom`
--

INSERT INTO `loginfrom` (`id`, `usename`, `password`, `role`) VALUES
(1, 'adminqlsv', 'admin', 'qlnv'),
(2, 'adminqld', 'admin', 'qld');

-- --------------------------------------------------------

--
-- Table structure for table `sinhvien`
--

CREATE TABLE `sinhvien` (
  `id` int(11) NOT NULL,
  `MaSV` varchar(150) NOT NULL,
  `HoTen` varchar(150) NOT NULL,
  `Email` varchar(150) NOT NULL,
  `SDT` int(11) NOT NULL,
  `GioTinh` varchar(150) NOT NULL,
  `DiaChi` varchar(250) NOT NULL,
  `HinhAnh` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sinhvien`
--


--
-- Indexes for dumped tables
--

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `sinhvien`
--
ALTER TABLE `sinhvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
