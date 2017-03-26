-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for libretto
CREATE DATABASE IF NOT EXISTS `libretto` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `libretto`;

-- Dumping structure for table libretto.esame
CREATE TABLE IF NOT EXISTS `esame` (
  `codice` varchar(50) NOT NULL,
  `titolo` varchar(200) NOT NULL,
  `docente` varchar(200) NOT NULL,
  `superato` tinyint(4) NOT NULL DEFAULT '0',
  `voto` int(11) DEFAULT NULL,
  `data_esame` date DEFAULT NULL,
  PRIMARY KEY (`codice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table libretto.esame: ~3 rows (approximately)
DELETE FROM `esame`;
/*!40000 ALTER TABLE `esame` DISABLE KEYS */;
INSERT INTO `esame` (`codice`, `titolo`, `docente`, `superato`, `voto`, `data_esame`) VALUES
	('01QZP', 'Ambient Intelligence', 'Fulvio Corno', 0, NULL, NULL),
	('03FYZ', 'Tecniche di Programmazione', 'Fulvio Corno', 0, NULL, NULL),
	('12BHD', 'Informatica', 'JCDM', 0, NULL, NULL);
/*!40000 ALTER TABLE `esame` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
