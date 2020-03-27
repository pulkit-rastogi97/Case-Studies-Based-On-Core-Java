
drop database if exists productdb;

create database productdb;

use  productdb;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;


CREATE TABLE `categories` (
    `categoryId` INT AUTO_INCREMENT PRIMARY KEY,
    `categoryName` VARCHAR(100) NOT NULL
) ;


--
-- Dumping data for table `categories`
--


INSERT INTO categories VALUES ( default, ‘Electronics’);
INSERT INTO categories VALUES ( default, ‘Clothings’);
INSERT INTO categories VALUES ( default, ‘Books’);
INSERT INTO categories VALUES ( default, ‘Toys’);


--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;


CREATE TABLE `products` (

   `productId` INT AUTO_INCREMENT PRIMARY KEY,
   `productName` varchar(100) not null,
   `categoryId` INT,
    CONSTRAINT fk_category
    FOREIGN KEY (categoryId) 
        REFERENCES categories(categoryId)

);
