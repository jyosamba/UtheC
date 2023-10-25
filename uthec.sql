USE uthec;


CREATE TABLE Authors(
name VARCHAR(255),
authorID INT NOT NULL AUTO_INCREMENT,
dead BOOLEAN,
alias VARCHAR(255),
PRIMARY KEY (authorID)
);

CREATE TABLE Publishers(
company_name VARCHAR(255),
copyright BOOLEAN,
publisherID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (publisherID)
);

CREATE TABLE Genres(
genreID INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
fiction BOOLEAN,
PRIMARY KEY (genreID)
);

CREATE TABLE Books(
bookID INT NOT NULL AUTO_INCREMENT,
title VARCHAR(255),
authorID INT,
genreID INT,
publisherID INT,
ISBN VARCHAR(100),
hardcover boolean,
quantity INT,
price DECIMAL(6,2),
FOREIGN KEY (authorID) REFERENCES Authors(authorID),
FOREIGN KEY (genreID) REFERENCES Genres(genreID),
FOREIGN KEY (publisherID) REFERENCES Publishers(publisherID),
PRIMARY KEY (bookID)
);

CREATE TABLE Customers(
forename VARCHAR(255),
surname VARCHAR(255),
address VARCHAR(255),
dob DATE,
phone_number VARCHAR(255),
email VARCHAR(255),
customerID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (customerID)
);

CREATE TABLE payments(
date_of_order DATE,
amount DECIMAL,
paymentID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (paymentID)
);

CREATE TABLE Orders(
orderID INT NOT NULL AUTO_INCREMENT,
customerID INT,
order_date Date,
bookID INT,
paymentID INT,
FOREIGN KEY (bookID) REFERENCES Books(bookID),
FOREIGN KEY (paymentID) REFERENCES Payments(paymentID),
FOREIGN KEY (customerID) REFERENCES Customers(customerID),
PRIMARY KEY(orderID)
);

CREATE TABLE OrderDetails(
orderDetails INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
orderID INT,
bookID INT,
quantity INT,
price_per_book DECIMAL,
FOREIGN KEY (orderID) REFERENCES Orders(orderID),
FOREIGN KEY (bookID) REFERENCES Books(bookID)
);


CREATE TABLE users(
username VARCHAR(255),
password VARCHAR(255)
);
SELECT * FROM users;
DELIMITER //
CREATE PROCEDURE createNewUser(IN inputUsername VARCHAR(255), IN inputPass VARCHAR(255))
INSERT INTO users(username, password) VALUES(inputUsername, SHA2(inputPass, 512));
//


INSERT INTO genres(name, fiction) VALUES('Fantasy', true), ('Sci-fi', true), ('Play', true), ('Thriller', true), ('Magical Realism', true), ('Short stories', true), ('Philosophical Fiction', true), ('Science', false);
INSERT INTO authors(name, dead, alias) VALUES('John Ronald Reuel Tolkien', true, 'J. R. R. Tolkien'), ('William Gibson', false, 'Gibson'), ('Joanne Rowling', false, 'J. K. Rowling'), ('Dan Brown', false, 'Brown'), ('Haruki Murakami', false, 'Murakami'), ('John Grisham', false, 'Grisham'), ('Hermann Hesse', true, 'Hesse'), ('Stephen Hawking', true, 'Hawking');
INSERT INTO publishers(company_name) VALUES('Harper Collins'), ('Ace'), ('Bloomsbury'), ('Doubleday'), ('Penguin'), ('Wynwood Press'), ('Penguin Modern Classics'), ('Hodder & Stoughton');
INSERT INTO Books(title, authorId, genreID, publisherID, ISBN, hardcover, quantity, price) VALUES('The Fellowship of The Ring', 1, 1, 1, '9780261102354', true, 50, 14.00), ('The Fellowship of The Ring', 1, 1, 1, '9780261102354', false, 60, 11.00), ('The Two Towers', 1, 1, 1, '9780007203550', true, 50, 14.00), ('The Two Towers', 1, 1, 1, '9780007203550', false, 60, 11.00), ('The Return of The King', 1, 1, 1, '9780007141319', true, 50, 14.00), ('The Return of The King', 1, 1, 1, '9780007141319', false, 60, 11.00), ('The Hobbit', 1, 1, 1, '9780007458424', true, 62, 12.00), ('The Hobbit', 1, 1, 1, '9780007458424', false, 80, 9.00), ('The Silmarillion', 1, 1, 1, '9780544338012', true, 30, 12.00), ('The Silmarillion', 1, 1, 1, '9780544338012', false, 30, 9.00), ('Neuromancer', 2, 2, 2, '978044156959', true, 42, 15.00), ('Neuromancer', 2, 2, 2, '978044156959', false, 54, 11.00), ('Burning Chrome', 2, 2, 2, '9780195305678', true, 42, 15.00), ('Burning Chrome', 2, 2, 2, '9780195305678', false, 54, 11.00), ('The Miracle Worker', 2, 3, 2, '9781416590842', true, 38, 16.00), ('The Miracle Worker', 2, 3, 2, '9781416590842', false, 44, 12.00), ('Harry Potter and The Philosophers Stone', 3, 1, 3, '0747532699', true, 80, 12.00), ('Harry Potter and The Philosophers Stone', 3, 1, 3, '0747532699', false, 100, 8.00), ('Harry Potter and The Chamber of Secrets', 3, 1, 3, '0747538492', true, 80, 12.00), ('Harry Potter and The Chamber of Secrets', 3, 1, 3, '0747538492', false, 100, 8.00), ('Harry Potter and The Prisoner of Azkaban', 3, 1, 3, '0747542155', true, 80, 12.00), ('Harry Potter and The Prisoner of Azkaban', 3, 1, 3, '0747542155', false, 100, 8.00), ('Harry Potter and The Goblet of Fire', 3, 1, 3, '9780747546245', true, 80, 12.00), ('Harry Potter and The Goblet of Fire', 3, 1, 3, '9780747546245', false, 100, 8.00), ('Harry Potter and The Order of The Phoenix', 3, 1, 3, '0747551006', true, 80, 12.00), ('Harry Potter and The Order of The Phoenix', 3, 1, 3, '0747551006', false, 100, 8.00), ('Harry Potter and The Half-Blood Prince', 3, 1, 3, '0747581088', true, 80, 12.00), ('Harry Potter and The Half-Blood Prince', 3, 1, 3, '0747581088', false, 100, 8.00), ('Harry Potter and The Deathly Hallows', 3, 1, 3, '0545010225', true, 80, 12.00), ('Harry Potter and The Deathly Hallows', 3, 1, 3, '0545010225', false, 80, 8.00), ('Fantastic Beasts and Where To Find Them', 3, 1, 3, '9780545850568', true, 60, 11.00), ('Fantastic Beasts and Where To Find Them', 3, 1, 3, '9780545850568', false, 73, 7.00), ('Angels and Demons', 4, 4, 4, '9781416524793', true, 36, 13.00), ('Angels and Demons', 4, 4, 4, '9781416524793', false, 56, 9.50), ('The Davinci code', 4, 4, 4, '9780307277671', true, 36, 13.00), ('The Davinci code', 4, 4, 4, '9780307277671', false, 56, 9.50), ('Inferno', 4, 4, 4, '9780385537858', true, 36, 13.00), ('Inferno', 4, 4, 4, '9780385537858', false, 56, 9.50), ('The Lost Symbol', 4, 4, 4, '0385504225', true, 36, 13.00), ('The Lost Symbol', 4, 4, 4, '0385504225', false, 56, 9.50), ('Origin', 4, 4, 4, '9780385514231', true, 36, 13.00), ('Origin', 4, 4, 4, '9780385514231', false, 56, 9.50), ('Digital Fortress', 4, 4, 4, '9780552159739', true, 36, 13.00), ('Digital Fortress', 4, 4, 4, '9780552159739', false, 56, 9.50), ('Deception Point', 4, 4, 4, '0671027387', true, 36, 13.00), ('Deception Point', 4, 4, 4, '0671027387', false, 56, 9.50), ('Kafka On The Shore', 5, 5, 5, '9781400043668', true, 46, 12.50), ('Kafka On The Shore', 5, 5, 5, '9781400043668', false, 63, 8.50), ('Norwegian Wood', 5, 5, 5, '9780099448822', true, 46, 12.50), ('Norwegian Wood', 5, 5, 5, '9780099448822', false, 63, 8.50), ('First Person Singular', 5, 6, 5, '9781529113594', true, 46, 12.50), ('First Person Singular', 5, 6, 5, '9781529113594', false, 63, 8.50), ('IQ84', 5, 6, 5, '9780099578079', true, 46, 12.50), ('IQ84', 5, 6, 5, '9780099578079', false, 63, 8.50), ('A Time For Mercy', 6, 4, 6, '9781529342321', true, 47, 11.50), ('A Time For Mercy', 6, 4, 6, '9781529342321', false, 77, 9.50), ('Sparring Partners', 6, 4, 6, '9781399708432', true, 47, 11.50),  ('Sparring Partners', 6, 4, 6, '9781399708432', false, 77, 9.50),  ('The Litigators', 6, 4, 6, '9780385535137', true, 47, 11.50), ('The Litigators', 6, 4, 6, '9780385535137', false, 77, 9.50), ('Camino Ghosts', 6, 4, 6, '9780385545990', true, 47, 11.50), ('Camino Ghosts', 6, 4, 6, '9780385545990', false, 77, 9.50), ('Camino Winds', 6, 4, 6, '9781529342499', true, 47, 11.50), ('Camino Winds', 6, 4, 6, '9781529342499', false, 77, 9.50), ('The Reckoning', 6, 4, 6, '9781473684386', true, 47, 11.50), ('The Reckoning', 6, 4, 6, '9781473684386', false, 77, 9.50), ('Camino Island', 6, 4, 6, '9781473663732', true, 47, 11.50), ('Camino Island', 6, 4, 6, '9781473663732', false, 77, 9.50), ('The Whistler', 6, 4, 6, '9780385541190', true, 47, 11.50), ('The Whistler', 6, 4, 6, '9780385541190', false, 77, 9.50), ('The Confession', 6, 4, 6, '9780099545798', true, 47, 11.50), ('The Confession', 6, 4, 6, '9780099545798', false, 77, 9.50), ('Demian', 7, 7, 7, '9789387669567', true, 22, 14.00), ('Demian', 7, 7, 7, '9789387669567', false, 34, 11.00), ('Rosshalde', 7, 7, 7, '9781017799811', true, 22, 14.00), ('Rosshalde', 7, 7, 7, '9781017799811', false, 34, 11.00), ('Siddhartha', 7, 7, 7, '9780141189574', true, 22, 14.00), ('Siddhartha', 7, 7, 7, '9780141189574', false, 34, 11.00), ('Steppenwolf', 7, 7, 7, '0312278675', true, 22, 14.00), ('Steppenwolf', 7, 7, 7, '0312278675', false, 34, 11.00), ('The Glass Bead Game', 7, 7, 7, '9780099283621', true, 22, 14.00), ('The Glass Bead Game', 7, 7, 7, '9780099283621', false, 34, 11.00), ('A Brief History of Time', 8, 8, 8, '9781439503928', true, 24, 18.00), ('A Brief History of Time', 8, 8, 8, '9781439503928', false, 34, 15.00), ('The Theory of Everything', 8, 8, 8, '9780910304900', true, 24, 18.00), ('The Theory of Everything', 8, 8, 8, '9780910304900', false, 34, 15.00), ('The Universe In A Nutshell', 8, 8, 8, '9780553802023', true, 24, 18.00), ('The Universe In A Nutshell', 8, 8, 8, '9780553802023', false, 34, 15.00), ('Brief Answers To The Big Questions', 8, 8, 8, '9781473695986', true, 24, 18.00), ('Brief Answers To The Big Questions', 8, 8, 8, '9781473695986', false, 34, 15.00);

SELECT * FROM books;

delete from Customers;
select * from Customers;
