CREATE SCHEMA `Boten` ;

CREATE TABLE `Boten`.`Klant` (
  `klantnummer` INT NOT NULL AUTO_INCREMENT,
  `klantnaam` VARCHAR(45) NOT NULL,
  `emailadres` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`klantnummer`));

INSERT INTO `Boten`.`Klant` (`klantnaam`,  `emailadres`) VALUES ('Smit', 'smit@smit.nl');
INSERT INTO `Boten`.`Klant` (`klantnaam`,  `emailadres`) VALUES ('Vertonghen', 'vertonghen@xs4all.nl');
INSERT INTO `Boten`.`Klant` (`klantnaam`,  `emailadres`) VALUES ('Robertson', 'rob@knp.nl');

CREATE USER 'userBoten'@'localhost' IDENTIFIED BY 'userBotenPW';
GRANT ALL PRIVILEGES ON Boten.* TO 'userBoten'@'localhost';