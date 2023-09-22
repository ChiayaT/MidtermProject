-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rumblerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rumblerdb` ;

-- -----------------------------------------------------
-- Schema rumblerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rumblerdb` DEFAULT CHARACTER SET utf8 ;
USE `rumblerdb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `street2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zip_code` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `profile_image_url` VARCHAR(2000) NULL,
  `height_in_inches` INT NULL,
  `weight_in_pounds` INT NULL,
  `fighting_stance` VARCHAR(45) NULL,
  `address_id` INT NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `date_of_birth` DATE NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address1_idx` (`address_id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  CONSTRAINT `fk_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type_of_venue` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_location_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rating` ;

CREATE TABLE IF NOT EXISTS `rating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `scale` INT NOT NULL,
  `comment` VARCHAR(45) NULL,
  `rater_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `experience_level`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `experience_level` ;

CREATE TABLE IF NOT EXISTS `experience_level` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `discipline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `discipline` ;

CREATE TABLE IF NOT EXISTS `discipline` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `experience_level_id` INT NOT NULL,
  PRIMARY KEY (`id`, `experience_level_id`),
  INDEX `fk_discipline_experience_level1_idx` (`experience_level_id` ASC),
  CONSTRAINT `fk_discipline_experience_level1`
    FOREIGN KEY (`experience_level_id`)
    REFERENCES `experience_level` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_discipline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_discipline` ;

CREATE TABLE IF NOT EXISTS `user_has_discipline` (
  `user_id` INT NOT NULL,
  `discipline_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `discipline_id`),
  INDEX `fk_user_has_discipline_discipline1_idx` (`discipline_id` ASC),
  INDEX `fk_user_has_discipline_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_discipline_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_discipline_discipline1`
    FOREIGN KEY (`discipline_id`)
    REFERENCES `discipline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_rating` ;

CREATE TABLE IF NOT EXISTS `user_has_rating` (
  `user_id` INT NOT NULL,
  `rating_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `rating_id`),
  INDEX `fk_user_has_rating_rating1_idx` (`rating_id` ASC),
  INDEX `fk_user_has_rating_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_rating_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_rating_rating1`
    FOREIGN KEY (`rating_id`)
    REFERENCES `rating` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS rumbleruser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'rumbleruser'@'localhost' IDENTIFIED BY 'rumbleruser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'rumbleruser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`) VALUES (1, '123 Fake St', NULL, 'Denver', 'Colorado', '80114', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `profile_image_url`, `height_in_inches`, `weight_in_pounds`, `fighting_stance`, `address_id`, `enabled`, `date_of_birth`, `role`) VALUES (1, 'admin', 'admin', 'admin', 'admin', NULL, NULL, NULL, NULL, 1, 1, NULL, NULL);

COMMIT;

