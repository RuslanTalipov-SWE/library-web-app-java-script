CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `e_book`;
DROP TABLE IF EXISTS `e_user`;
DROP TABLE IF EXISTS `e_issuebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_book` (
  `callno` int (11) NOT NULL AUTO_INCREMENT,
  `name` varchar(4000) DEFAULT NULL,
  `author` varchar(4000) DEFAULT NULL,
  `publisher` varchar(4000) DEFAULT NULL,
  `quantity` int (11) DEFAULT NULL,
  `issued` int (11) DEFAULT NULL,
  PRIMARY KEY (`callno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `e_user` (
  `id` int (11) NOT NULL AUTO_INCREMENT,
  `name` varchar(4000) DEFAULT NULL,
  `password` varchar(4000) DEFAULT NULL,
  `email` varchar(4000) DEFAULT NULL,
  `mobile` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `e_issuebook` (
  `callno` int (11) NOT NULL AUTO_INCREMENT,
  `studentid` int (11) DEFAULT NULL,
  `studentname` varchar(4000) DEFAULT NULL,
  `studentmobile` bigint DEFAULT NULL,
  `issuedate` date DEFAULT NULL,
  `returnstatus` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`callno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

ALTER TABLE e_book CONVERT TO CHARACTER SET utf8;
ALTER TABLE e_issuebook CONVERT TO CHARACTER SET utf8;
ALTER TABLE e_user CONVERT TO CHARACTER SET utf8;