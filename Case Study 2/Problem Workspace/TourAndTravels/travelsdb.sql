
drop database if exists travlesdb;

create database travelsdb;

use  travelsdb;

--
-- Table structure for table `BusDetails`
--

DROP TABLE IF EXISTS `BusDetails`;


CREATE TABLE `BusDetails` ( 
	`busId` int AUTO_INCREMENT PRIMARY KEY, 
	`busType` text(20), 
	`FROM`  text(20), 
	`To` text(20), 
	`Date` Date, 
	`noOfSeats` int
);


--
-- Dumping data for table `BusDetails`
--


INSERT INTO BusDetails VALUES(110, ‘AC-Shivneri’, ‘Pune’,’Dadar’,’26-Mar-2020’,50);
INSERT INTO BusDetails VALUES(111, ‘Ashwamedh’, ‘Dadar’,’Pune’,’27-Mar-2020’,40);
INSERT INTO BusDetails VALUES(112, ‘AC-Shivneri’, ‘Borivali’,’Pune’,’27-Mar-2020’,40);
INSERT INTO BusDetails VALUES(113, ‘Shivshahi’, ‘Pune’,’Thane’,’26-Mar-2020’,40);
INSERT INTO BusDetails VALUES(114, ‘AC-Shivneri’, ‘Pune’,’Thane’,’26-Mar-2020’,40);
INSERT INTO BusDetails VALUES(115, ‘AC-Shivneri’, ‘Pune’,’Borivali’,26-Mar-2020’,40);

