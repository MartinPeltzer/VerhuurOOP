CREATE SCHEMA `Boten` ;

CREATE TABLE `Boten`.`Klant` (
  `klantnummer` INT NOT NULL AUTO_INCREMENT,
  `klantnaam` VARCHAR(45) NOT NULL,
  `emailadres` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`klantnummer`));

INSERT INTO `Boten`.`Klant` (`klantnaam`,  `emailadres`) VALUES ('Hoekstra', 'hoekstra@smit.nl');
INSERT INTO `Boten`.`Klant` (`klantnaam`,  `emailadres`) VALUES ('Veldhuis', 'veldhuis@xs4all.nl');
INSERT INTO `Boten`.`Klant` (`klantnaam`,  `emailadres`) VALUES ('Veenboer', 'veenboer@knp.nl');

CREATE USER 'userVakantiewoningen'@'localhost' IDENTIFIED BY 'userVakantiewoningenPW';
GRANT ALL PRIVILEGES ON Boten.* TO 'userVakantiewoningen'@'localhost';