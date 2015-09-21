-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema questionario
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema questionario
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `questionario` DEFAULT CHARACTER SET utf8 ;
USE `questionario` ;

-- -----------------------------------------------------
-- Table `questionario`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `questionario`.`users` ;

CREATE TABLE IF NOT EXISTS `questionario`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  `password` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `questionario`.`questionnaries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `questionario`.`questionnaries` ;

CREATE TABLE IF NOT EXISTS `questionario`.`questionnaries` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `id_user` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `id_user_idx` (`id_user` ASC)  COMMENT '',
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `questionario`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `questionario`.`questions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `questionario`.`questions` ;

CREATE TABLE IF NOT EXISTS `questionario`.`questions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `type` TINYINT(1) NOT NULL COMMENT '',
  `id_questionnarie` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `id_questionnarie_idx` (`id_questionnarie` ASC)  COMMENT '',
  CONSTRAINT `id_questionnarie`
    FOREIGN KEY (`id_questionnarie`)
    REFERENCES `questionario`.`questionnaries` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `questionario`.`answers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `questionario`.`answers` ;

CREATE TABLE IF NOT EXISTS `questionario`.`answers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `id_question` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `id_question_idx` (`id_question` ASC)  COMMENT '',
  CONSTRAINT `id_question_answer`
    FOREIGN KEY (`id_question`)
    REFERENCES `questionario`.`questions` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `questionario`.`options`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `questionario`.`options` ;

CREATE TABLE IF NOT EXISTS `questionario`.`options` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `id_question` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `id_question_idx` (`id_question` ASC)  COMMENT '',
  CONSTRAINT `id_question`
    FOREIGN KEY (`id_question`)
    REFERENCES `questionario`.`questions` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;