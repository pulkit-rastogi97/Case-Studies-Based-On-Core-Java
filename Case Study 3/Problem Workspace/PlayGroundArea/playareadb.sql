drop database if exists playareadb;

create database playareadb;

use  playareadb;

--
-- Table structure for table `UserGameDetails`
--

DROP TABLE IF EXISTS `UserGameDetails`;


CREATE TABLE `UserGameDetails`( 
	`userId` int PRIMARY KEY, 
	`username` text(20), balance int 
);


--
-- Dumping data for table `UserGameDetails`
--

INSERT INTO UserGameDetails values(101, ‘Pooja’,800);
INSERT INTO UserGameDetails values(102, ‘Ram’,400);
INSERT INTO UserGameDetails values(103, ‘Priti’,700);
INSERT INTO UserGameDetails values(104, ‘kiran’,800);
INSERT INTO UserGameDetails values(105, ‘Prashant’,800);
INSERT INTO UserGameDetails values(106, ‘Poorvi’,800);


