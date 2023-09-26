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
  `enabled` TINYINT NOT NULL,
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
  `address_id` INT NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `date_of_birth` DATE NULL,
  `role` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `description` TEXT NULL,
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
-- Table `location_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location_type` ;

CREATE TABLE IF NOT EXISTS `location_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(2000) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `location_type_id` INT NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_location_address1_idx` (`address_id` ASC),
  INDEX `fk_location_location_type1_idx` (`location_type_id` ASC),
  CONSTRAINT `fk_location_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_location_type1`
    FOREIGN KEY (`location_type_id`)
    REFERENCES `location_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `discipline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `discipline` ;

CREATE TABLE IF NOT EXISTS `discipline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `experience_level`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `experience_level` ;

CREATE TABLE IF NOT EXISTS `experience_level` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fighting_stance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fighting_stance` ;

CREATE TABLE IF NOT EXISTS `fighting_stance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stance` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_discipline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_discipline` ;

CREATE TABLE IF NOT EXISTS `user_discipline` (
  `user_id` INT NOT NULL,
  `discipline_id` INT NOT NULL,
  `experience_level_id` INT NOT NULL,
  `fighting_stance_id` INT NOT NULL,
  `description` TEXT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  PRIMARY KEY (`user_id`, `discipline_id`),
  INDEX `fk_user_has_discipline_discipline1_idx` (`discipline_id` ASC),
  INDEX `fk_user_has_discipline_user_idx` (`user_id` ASC),
  INDEX `fk_user_has_discipline_experience_level1_idx` (`experience_level_id` ASC),
  INDEX `fk_user_has_discipline_fighting_stance1_idx` (`fighting_stance_id` ASC),
  CONSTRAINT `fk_user_has_discipline_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_discipline_discipline1`
    FOREIGN KEY (`discipline_id`)
    REFERENCES `discipline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_discipline_experience_level1`
    FOREIGN KEY (`experience_level_id`)
    REFERENCES `experience_level` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_discipline_fighting_stance1`
    FOREIGN KEY (`fighting_stance_id`)
    REFERENCES `fighting_stance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rumble`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rumble` ;

CREATE TABLE IF NOT EXISTS `rumble` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `host_id` INT NOT NULL,
  `guest_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  `host_rating_comment` VARCHAR(150) NULL,
  `host_rating_scale` INT NOT NULL,
  `guest_rating_comment` VARCHAR(150) NULL,
  `guest_rating_scale` INT NOT NULL,
  `rumble_date` DATE NULL,
  `start_time` TIME NULL,
  `end_time` TIME NULL,
  `create_date` DATE NULL,
  `last_update` DATETIME NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `open_to_public` TINYINT NULL,
  `discipline_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rumble_user1_idx` (`host_id` ASC),
  INDEX `fk_rumble_user2_idx` (`guest_id` ASC),
  INDEX `fk_rumble_location1_idx` (`location_id` ASC),
  INDEX `fk_rumble_discipline1_idx` (`discipline_id` ASC),
  CONSTRAINT `fk_rumble_user1`
    FOREIGN KEY (`host_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rumble_user2`
    FOREIGN KEY (`guest_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rumble_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rumble_discipline1`
    FOREIGN KEY (`discipline_id`)
    REFERENCES `discipline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_friend`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_friend` ;

CREATE TABLE IF NOT EXISTS `user_has_friend` (
  `user_id` INT NOT NULL,
  `friend_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `friend_id`),
  INDEX `fk_user_has_user_user2_idx` (`friend_id` ASC),
  INDEX `fk_user_has_user_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_user_user2`
    FOREIGN KEY (`friend_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location_rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location_rating` ;

CREATE TABLE IF NOT EXISTS `location_rating` (
  `user_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  `rating_scale` INT NOT NULL,
  `rating_comment` TEXT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`, `location_id`),
  INDEX `fk_user_has_location_location1_idx` (`location_id` ASC),
  INDEX `fk_user_has_location_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_location_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_location_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rumble_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rumble_message` ;

CREATE TABLE IF NOT EXISTS `rumble_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message_date` DATETIME NULL,
  `content` TEXT NULL,
  `create_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `rumble_id` INT NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_rumble_message_user1_idx` (`user_id` ASC),
  INDEX `fk_rumble_message_rumble1_idx` (`rumble_id` ASC),
  CONSTRAINT `fk_rumble_message_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rumble_message_rumble1`
    FOREIGN KEY (`rumble_id`)
    REFERENCES `rumble` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `direct_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `direct_message` ;

CREATE TABLE IF NOT EXISTS `direct_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `create_date` DATETIME NULL,
  `content` TEXT NULL,
  `sender_id` INT NOT NULL,
  `recipient_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_direct_message_user1_idx` (`sender_id` ASC),
  INDEX `fk_direct_message_user2_idx` (`recipient_id` ASC),
  CONSTRAINT `fk_direct_message_user1`
    FOREIGN KEY (`sender_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_direct_message_user2`
    FOREIGN KEY (`recipient_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_post` ;

CREATE TABLE IF NOT EXISTS `blog_post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `create_date` DATETIME NULL,
  `content` TEXT NULL,
  `last_update` DATETIME NULL,
  `user_id` INT NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_blog_post_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_blog_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
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
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`, `enabled`) VALUES (1, '123 Fake St', NULL, 'Austin', 'Texas', '78704', NULL, 1);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`, `enabled`) VALUES (2, '360 High Kick Dr', NULL, 'Los Angeles', 'California', '90210', NULL, 1);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`, `enabled`) VALUES (3, '4444 Boxing Blvd', NULL, 'Austin', 'Texas', '78704', NULL, 1);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`, `enabled`) VALUES (4, '1800 Ocean Front Walk', NULL, 'Venice', 'California', '90291', NULL, 1);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`, `enabled`) VALUES (5, '700 WrestleMania Rd', NULL, 'Beverly Hills', 'California', '90210', NULL, 1);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`, `enabled`) VALUES (6, '246 Openwight Circle', NULL, 'Austin', 'Texas', '78704', NULL, 1);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`, `enabled`) VALUES (7, '2401 Thornton Rd', 'A1', 'Austin', 'Texas', '78704', '5128400177', 1);
INSERT INTO `address` (`id`, `street`, `street2`, `city`, `state`, `zip_code`, `phone`, `enabled`) VALUES (8, '9663 Santa Monica Blvd', '440', 'Beverly Hills', 'California', '90210', '4243247444', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `profile_image_url`, `height_in_inches`, `weight_in_pounds`, `address_id`, `enabled`, `date_of_birth`, `role`, `create_date`, `last_update`, `description`) VALUES (1, 'admin', 'admin', 'admin', 'admin', NULL, 1, 1, 1, 1, NULL, 'admin', NULL, NULL, NULL);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `profile_image_url`, `height_in_inches`, `weight_in_pounds`, `address_id`, `enabled`, `date_of_birth`, `role`, `create_date`, `last_update`, `description`) VALUES (2, 'Jackie', 'Chan', 'jchan', 'jchan', 'https://hips.hearstapps.com/hmg-prod/images/jackie-chan-news-photo-83389121-1567001252.jpg?crop=0.784xw:1.00xh;0.0255xw,0&resize=1200:*', 67, 143, 2, 1, '1953-04-07', 'user', '2023-09-22', '2023-09-22', 'hi-ya!');
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `profile_image_url`, `height_in_inches`, `weight_in_pounds`, `address_id`, `enabled`, `date_of_birth`, `role`, `create_date`, `last_update`, `description`) VALUES (3, 'Mike', 'Tyson', 'mtyson', 'mtyson', 'https://cdn.europosters.eu/image/750/art-photo/mike-tyson-i135277.jpg', 70, 220, 3, 1, '1966-06-30', 'user', '2023-09-22', '2023-09-22', 'check out my tattoo');
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `profile_image_url`, `height_in_inches`, `weight_in_pounds`, `address_id`, `enabled`, `date_of_birth`, `role`, `create_date`, `last_update`, `description`) VALUES (4, 'Ronda', 'Rousey', 'rrousey', 'rrousey', 'https://media-cldnry.s-nbcnews.com/image/upload/t_fit-1500w,f_auto,q_auto:best/newscms/2018_05/2308511/180129-ronda-rousey-mc-8452.JPG', 66, 135, 5, 1, '1987-02-01', 'user', '2023-09-26', '2023-09-26', 'first female fighter signed to UFC');
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `profile_image_url`, `height_in_inches`, `weight_in_pounds`, `address_id`, `enabled`, `date_of_birth`, `role`, `create_date`, `last_update`, `description`) VALUES (5, 'Royce', 'Gracie', 'rgracie', 'rgracie', 'https://cdn.shopify.com/s/files/1/0030/3742/9849/files/Royce_Gracie_s_Details.jpg?v=1676565294', 73, 176, 6, 1, '1966-12-01', 'user', '2023-09-26', '2023-09-26', 'mixed martial arts and Brazilian jiu-jitsu master');

COMMIT;


-- -----------------------------------------------------
-- Data for table `location_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `location_type` (`id`, `name`, `description`) VALUES (1, 'Business', 'A brick and mortar business');
INSERT INTO `location_type` (`id`, `name`, `description`) VALUES (2, 'Residential', 'A space and user can offer, i.e. a garage');
INSERT INTO `location_type` (`id`, `name`, `description`) VALUES (3, 'Outdoor', 'Parks, beaches, etc.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `location` (`id`, `name`, `address_id`, `description`, `image_url`, `create_date`, `last_update`, `location_type_id`, `enabled`) VALUES (1, 'Fight Town', 1, 'A town to fight!', 'https://images.pexels.com/photos/8736743/pexels-photo-8736743.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2', '2023-09-22', '2023-09-26', 1, 1);
INSERT INTO `location` (`id`, `name`, `address_id`, `description`, `image_url`, `create_date`, `last_update`, `location_type_id`, `enabled`) VALUES (2, 'Venice Beach', 4, 'Muscle Beach outdoor gym', 'https://images.pexels.com/photos/1412235/pexels-photo-1412235.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2', '2023-09-22', '2023-09-22', 3, 1);
INSERT INTO `location` (`id`, `name`, `address_id`, `description`, `image_url`, `create_date`, `last_update`, `location_type_id`, `enabled`) VALUES (3, 'Easley Boxing & Fitness', 7, 'Best boxing gym in Austin, Texas', 'https://lh3.googleusercontent.com/p/AF1QipOa4fZviycKbbrBB-7wtZFHfb6aOA6I7Vh5ANlv=s1360-w1360-h1020', '2023-09-26', '2023-09-26', 1, 1);
INSERT INTO `location` (`id`, `name`, `address_id`, `description`, `image_url`, `create_date`, `last_update`, `location_type_id`, `enabled`) VALUES (4, 'Body Soul Elite', 8, 'Great trainers with motivational talent!', 'https://images.squarespace-cdn.com/content/v1/593f7499e6f2e150bcfe1490/1562705324871-SKT3I3BTS1IDTETRR4P5/IMG_0762.jpg?format=2500w', '2023-09-26', '2023-09-26', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `discipline`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `discipline` (`id`, `name`, `description`, `image_url`) VALUES (1, 'Boxing', 'Fighting with fists and padded gloves', NULL);
INSERT INTO `discipline` (`id`, `name`, `description`, `image_url`) VALUES (2, 'Karate', 'Unarmed combat using the hands and feet to deliver and block blows', NULL);
INSERT INTO `discipline` (`id`, `name`, `description`, `image_url`) VALUES (3, 'Jiu Jitsu', 'A Japanese system of unarmed combat and physical training', NULL);
INSERT INTO `discipline` (`id`, `name`, `description`, `image_url`) VALUES (4, 'Wrestling', 'A martial art and combat sport that involves grappling with an opponent and striving to obtain a position of advantage through different throws or techniques, within a given ruleset.', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `experience_level`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `experience_level` (`id`, `name`) VALUES (1, 'Beginner');
INSERT INTO `experience_level` (`id`, `name`) VALUES (2, 'Intermediate');
INSERT INTO `experience_level` (`id`, `name`) VALUES (3, 'Advanced');

COMMIT;


-- -----------------------------------------------------
-- Data for table `fighting_stance`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `fighting_stance` (`id`, `stance`, `description`) VALUES (1, 'Orthodox', 'Left lead');
INSERT INTO `fighting_stance` (`id`, `stance`, `description`) VALUES (2, 'Southpaw', 'Right lead');
INSERT INTO `fighting_stance` (`id`, `stance`, `description`) VALUES (3, 'Switch', 'Both lead');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_discipline`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `user_discipline` (`user_id`, `discipline_id`, `experience_level_id`, `fighting_stance_id`, `description`, `create_date`, `last_update`) VALUES (2, 2, 3, 1, 'I\'m really good at karate.', NULL, NULL);
INSERT INTO `user_discipline` (`user_id`, `discipline_id`, `experience_level_id`, `fighting_stance_id`, `description`, `create_date`, `last_update`) VALUES (3, 1, 3, 2, 'I\'m really good at boxing.', NULL, NULL);
INSERT INTO `user_discipline` (`user_id`, `discipline_id`, `experience_level_id`, `fighting_stance_id`, `description`, `create_date`, `last_update`) VALUES (5, 3, 3, 3, 'I\'m really good at jiu jitsu.', NULL, NULL);
INSERT INTO `user_discipline` (`user_id`, `discipline_id`, `experience_level_id`, `fighting_stance_id`, `description`, `create_date`, `last_update`) VALUES (5, 1, 2, 3, 'Working on my boxing!', NULL, NULL);
INSERT INTO `user_discipline` (`user_id`, `discipline_id`, `experience_level_id`, `fighting_stance_id`, `description`, `create_date`, `last_update`) VALUES (4, 2, 1, 2, 'Just started karate, looking to get better!', NULL, NULL);
INSERT INTO `user_discipline` (`user_id`, `discipline_id`, `experience_level_id`, `fighting_stance_id`, `description`, `create_date`, `last_update`) VALUES (4, 4, 3, 3, 'I\'m really good at wrestling.', NULL, NULL);
INSERT INTO `user_discipline` (`user_id`, `discipline_id`, `experience_level_id`, `fighting_stance_id`, `description`, `create_date`, `last_update`) VALUES (2, 4, 1, 1, 'Just started wrestling, looking to get better!', NULL, NULL);
INSERT INTO `user_discipline` (`user_id`, `discipline_id`, `experience_level_id`, `fighting_stance_id`, `description`, `create_date`, `last_update`) VALUES (3, 3, 2, 3, 'Working on my jiu jitsu skills!', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rumble`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `rumble` (`id`, `title`, `description`, `host_id`, `guest_id`, `location_id`, `host_rating_comment`, `host_rating_scale`, `guest_rating_comment`, `guest_rating_scale`, `rumble_date`, `start_time`, `end_time`, `create_date`, `last_update`, `enabled`, `open_to_public`, `discipline_id`) VALUES (1, 'First Rumble', 'This is the first rumble.', 2, 3, 2, NULL, 5, NULL, 5, NULL, NULL, NULL, '2023-09-22', NULL, 1, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_has_friend`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `user_has_friend` (`user_id`, `friend_id`) VALUES (2, 3);
INSERT INTO `user_has_friend` (`user_id`, `friend_id`) VALUES (3, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `location_rating`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `location_rating` (`user_id`, `location_id`, `rating_scale`, `rating_comment`, `create_date`, `last_update`, `enabled`) VALUES (3, 2, 5, 'I love this place!', '2023-09-22', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rumble_message`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `rumble_message` (`id`, `message_date`, `content`, `create_date`, `user_id`, `rumble_id`, `enabled`) VALUES (1, '2023-09-22', 'This is the first Rumble message.', '2023-09-22', 2, 1, 1);
INSERT INTO `rumble_message` (`id`, `message_date`, `content`, `create_date`, `user_id`, `rumble_id`, `enabled`) VALUES (2, '2023-09-22', 'This is the second Rumble message.', '2023-09-22', 3, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `direct_message`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `direct_message` (`id`, `create_date`, `content`, `sender_id`, `recipient_id`) VALUES (1, '2023-09-22', 'This is the first direct message.', 2, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `blog_post`
-- -----------------------------------------------------
START TRANSACTION;
USE `rumblerdb`;
INSERT INTO `blog_post` (`id`, `create_date`, `content`, `last_update`, `user_id`, `enabled`) VALUES (1, '2023-09-22', 'This is the first blog post.', '2023-09-22', 2, 1);

COMMIT;

