CREATE DATABASE IF NOT EXISTS `Service_center`
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


CREATE TABLE IF NOT EXISTS `Service_center`.`Addresses` (
  `id`       SERIAL,
  `city`     VARCHAR(45) NOT NULL,
  `street`   VARCHAR(45) NOT NULL,
  `house`    VARCHAR(5)  NOT NULL,
  `flat`     INT         NULL,
  `entrance` VARCHAR(5)  NULL,
  `floor`    INT         NULL,
  PRIMARY KEY (`id`)
)
  ENGINE InnoDB;


CREATE TABLE IF NOT EXISTS `Service_center`.`Clients` (
  `id`           SERIAL,
  `Addresses_id` BIGINT UNSIGNED NOT NULL,
  `name`         VARCHAR(255)    NOT NULL,
  `phone`        VARCHAR(45)     NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`Addresses_id`)
  REFERENCES `Service_center`.`Addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Service_center`.`Teams` (
  `id`   SERIAL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Service_center`.`Masters` (
  `id`           SERIAL,
  `Addresses_id` BIGINT UNSIGNED NOT NULL,
  `Teams_id`     BIGINT UNSIGNED NOT NULL,
  `name`         VARCHAR(255)    NOT NULL,
  `date`         DATE            NOT NULL,
  `phone`        VARCHAR(45)     NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`Addresses_id`)
  REFERENCES `Service_center`.`Addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (`Teams_id`)
  REFERENCES `Service_center`.`Teams` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Service_center`.`Services` (
  `id`   SERIAL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Service_center`.`Teams_Services` (
  `id`          SERIAL,
  `Services_id` BIGINT UNSIGNED NOT NULL,
  `Teams_id`    BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`Services_id`)
  REFERENCES `Service_center`.`Services` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (`Teams_id`)
  REFERENCES `Service_center`.`Teams` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Service_center`.`States` (
  `id`   SERIAL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Service_center`.`Orders` (
  `id`             SERIAL,
  `Clients_id`     BIGINT UNSIGNED NOT NULL,
  `Services_id`    BIGINT UNSIGNED NOT NULL,
  `States_id`      BIGINT UNSIGNED NOT NULL DEFAULT 1,
  `Teams_id`       BIGINT UNSIGNED NULL,
  `date_order`     TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_execution` DATE            NULL,
  `client_comment` VARCHAR(255)    NULL,
  `master_comment` VARCHAR(255)    NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`Clients_id`)
  REFERENCES `Service_center`.`Clients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (`States_id`)
  REFERENCES `Service_center`.`States` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (`Services_id`)
  REFERENCES `Service_center`.`Services` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (`Teams_id`)
  REFERENCES `Service_center`.`Teams` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;
