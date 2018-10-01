# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             emp
# Server version:       5.1.37
# Server OS:            Win32
# Target-Compatibility: MySQL 4.0
# Extended INSERTs:     Y
# max_allowed_packet:   1048576
# HeidiSQL version:     3.0 Revision: 572
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1*/;


#
# Database structure for database 'emp'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `emp` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `emp`;


#
# Table structure for table 'addpanel'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `addpanel` (
  `Name` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



#
# Dumping data for table 'addpanel'
#

/*!40000 ALTER TABLE `addpanel` DISABLE KEYS*/;
LOCK TABLES `addpanel` WRITE;
REPLACE INTO `addpanel` (`Name`, `Password`, `Gender`, `Contact`, `email`) VALUES ('Kirtika','kirtika',NULL,'8908908900','kirtika@90'),
	('Rashi','rashi',NULL,'8908908900','rashi@09'),
	('Ruchi','ruchi',NULL,'9809876456','ruchi@09'),
	('ABC','abc',NULL,'7890789090','abc@09');
UNLOCK TABLES;
/*!40000 ALTER TABLE `addpanel` ENABLE KEYS*/;


#
# Table structure for table 'damaged'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `damaged` (
  `ProductNo` varchar(50) DEFAULT NULL,
  `Price` int(10) unsigned DEFAULT NULL,
  `Quantity` int(10) unsigned DEFAULT NULL,
  `Date` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



#
# Dumping data for table 'damaged'
#

/*!40000 ALTER TABLE `damaged` DISABLE KEYS*/;
LOCK TABLES `damaged` WRITE;
REPLACE INTO `damaged` (`ProductNo`, `Price`, `Quantity`, `Date`) VALUES ('103S','350','1','26/7/17'),
	('100P','80','1','26/7/17'),
	('103S','350','1','26/7/17'),
	('101N','100','5','03/05/2017'),
	('103S','350','2','5/3/17'),
	('101N','100','1','27-June-2017');
UNLOCK TABLES;
/*!40000 ALTER TABLE `damaged` ENABLE KEYS*/;


#
# Table structure for table 'enquiryonly'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `enquiryonly` (
  `Name` varchar(50) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `Enquired` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



#
# Dumping data for table 'enquiryonly'
#

/*!40000 ALTER TABLE `enquiryonly` DISABLE KEYS*/;
LOCK TABLES `enquiryonly` WRITE;
REPLACE INTO `enquiryonly` (`Name`, `Contact`, `Enquired`) VALUES ('Vishi','9089087690','Nailpaint available?'),
	('Kirtika','9876786780','Sunscreen available or not?'),
	('shubham','8938970130','Car '),
	('Rachana','8908908900','Nailpaint available?'),
	('Rashi','8907654321','HandBag'),
	('Arachana','8908908907','Loreal shampoo?'),
	('Vaaibhavi','8907654531','Towels?'),
	('rahul','89456','Mobile\t'),
	('Nitish','9876543210','Redmi Note4');
UNLOCK TABLES;
/*!40000 ALTER TABLE `enquiryonly` ENABLE KEYS*/;


#
# Table structure for table 'producttable'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `producttable` (
  `ProductName` varchar(50) DEFAULT NULL,
  `ProductNo` varchar(50) DEFAULT NULL,
  `Quantity` int(10) unsigned DEFAULT NULL,
  `Price` int(10) unsigned DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



#
# Dumping data for table 'producttable'
#

/*!40000 ALTER TABLE `producttable` DISABLE KEYS*/;
LOCK TABLES `producttable` WRITE;
REPLACE INTO `producttable` (`ProductName`, `ProductNo`, `Quantity`, `Price`) VALUES ('Pantene Shampoo','100P','19','80'),
	('Nail Paint','101N','20','100'),
	('Hair Dryer','102H','16','400'),
	('SunScreen','103S','29','350'),
	('Deodrant','104D','9','500'),
	('Casrol','105C','8','800'),
	('HeadPhones','106HD','10','800'),
	('Liquid Handwash','107L','30','100'),
	('BedSheets','108BD','16','200'),
	('Towel','109T','30','150'),
	('Ice-cream','1010I','50','40'),
	('Hair Band','1011HD','50','20'),
	('Fair and Lovely BB Cream','1023C','30','120'),
	('Hair Dryer','1010D','6','500'),
	('Toothpaste','1024T','30','50'),
	('Toothbrush','1012T','30','30'),
	('lap105','123456','1','1400'),
	('lappy','12345','5','100');
UNLOCK TABLES;
/*!40000 ALTER TABLE `producttable` ENABLE KEYS*/;


#
# Table structure for table 'sales'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `sales` (
  `Name` varchar(50) DEFAULT NULL,
  `ContactNumber` varchar(50) DEFAULT NULL,
  `ProductName` varchar(50) DEFAULT NULL,
  `Quantity` int(10) unsigned DEFAULT NULL,
  `ProductNo` varchar(50) DEFAULT NULL,
  `Price per item` int(10) unsigned DEFAULT NULL,
  `Amount` int(10) unsigned DEFAULT NULL,
  `Date` varchar(50) DEFAULT NULL,
  `BillNumber` int(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



#
# Dumping data for table 'sales'
#

/*!40000 ALTER TABLE `sales` DISABLE KEYS*/;
LOCK TABLES `sales` WRITE;
REPLACE INTO `sales` (`Name`, `ContactNumber`, `ProductName`, `Quantity`, `ProductNo`, `Price per item`, `Amount`, `Date`, `BillNumber`, `Address`) VALUES ('Kirtika','9428677882','Nail Paint','2','101N','100','200','27-06-2017',1,'Aadarsh Colony'),
	('Rachana','1234567890','Deodrant','1','104D','500','500','27-06-2017',2,'Hyderabad'),
	('Shubham','8938970130','lap105','4','123456','1400','5600','28-06-2017',4,'Muzaffarnagar'),
	('Rachana','1234567890','Nail Paint','4','101N','100','400','27-06-2017',3,'Hyderabad'),
	('Shubham','8938970130','Hair Dryer','2','102H','400','800','28-06-2017',65520419,'Muzaffarnagar');
UNLOCK TABLES;
/*!40000 ALTER TABLE `sales` ENABLE KEYS*/;
