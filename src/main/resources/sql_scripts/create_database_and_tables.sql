CREATE SCHEMA IF NOT EXISTS `brs` DEFAULT CHARACTER SET utf8;
USE `brs`;

CREATE TABLE IF NOT EXISTS `brs`.`user`
(
  `nic`     VARCHAR(10)     NOT NULL,
  `fname`   VARCHAR(50)     NOT NULL,
  `lname`   VARCHAR(50)     NOT NULL,
  `dob`     DATE            NOT NULL,
  `sex`     ENUM ('M', 'F') NOT NULL,
  `phone`   INT(10)         NOT NULL,
  `email`   VARCHAR(255)    NOT NULL,
  `address` VARCHAR(255)    NOT NULL,
  PRIMARY KEY (`nic`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `brs`.`store_manager`
(
  `nic`       INT         NOT NULL,
  `from_date` DATE        NOT NULL,
  `to_date`   DATE        NOT NULL,
  `user_nic`  VARCHAR(10) NOT NULL,
  PRIMARY KEY (`nic`, `user_nic`),
  INDEX `fk_store_manager_user1_idx` (`user_nic` ASC),
  CONSTRAINT `fk_store_manager_user1`
    FOREIGN KEY (`user_nic`)
      REFERENCES `brs`.`user` (`nic`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `brs`.`store`
(
  `id`                 INT(3)      NOT NULL AUTO_INCREMENT,
  `location`           VARCHAR(50) NOT NULL,
  `number_of_bicycles` INT(5)      NOT NULL DEFAULT 0,
  `store_manager_nic`  INT         NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_store_store_manager1_idx` (`store_manager_nic` ASC),
  CONSTRAINT `fk_store_store_manager1`
    FOREIGN KEY (`store_manager_nic`)
      REFERENCES `brs`.`store_manager` (`nic`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `brs`.`store_cashier`
(
  `nic`       INT         NOT NULL,
  `from_date` DATE        NOT NULL,
  `to_date`   DATE        NOT NULL,
  `user_nic`  VARCHAR(10) NOT NULL,
  `store_id`  INT(3)      NOT NULL,
  PRIMARY KEY (`nic`, `user_nic`),
  INDEX `fk_store_cashier_user1_idx` (`user_nic` ASC),
  INDEX `fk_store_cashier_store1_idx` (`store_id` ASC),
  CONSTRAINT `fk_store_cashier_user1`
    FOREIGN KEY (`user_nic`)
      REFERENCES `brs`.`user` (`nic`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_store_cashier_store1`
    FOREIGN KEY (`store_id`)
      REFERENCES `brs`.`store` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `brs`.`customer`
(
  `nic`              CHAR(10)    NOT NULL,
  `registrationDate` DATE        NOT NULL,
  `lastRentalDate`   DATE        NULL,
  `user_nic`         VARCHAR(10) NOT NULL,
  PRIMARY KEY (`nic`, `user_nic`),
  INDEX `fk_customer_user1_idx` (`user_nic` ASC),
  CONSTRAINT `fk_customer_user1`
    FOREIGN KEY (`user_nic`)
      REFERENCES `brs`.`user` (`nic`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `brs`.`bicycle`
(
  `id`       INT(10)     NOT NULL,
  `model`    VARCHAR(50) NULL,
  `status`   VARCHAR(45) NOT NULL,
  `store_id` INT(3)      NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bicycle_store1_idx` (`store_id` ASC),
  CONSTRAINT `fk_bicycle_store1`
    FOREIGN KEY (`store_id`)
      REFERENCES `brs`.`store` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `brs`.`payment_status`
(
  `id`          INT(1)       NOT NULL,
  `status`      VARCHAR(10)  NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `brs`.`rental`
(
  `id`                INT      NOT NULL AUTO_INCREMENT,
  `rentalDate`        DATE     NULL,
  `returnDate`        DATE     NULL,
  `dailyRentalDate`   FLOAT    NULL,
  `rent_from`         INT(3)   NULL,
  `return_to`         INT(3)   NULL,
  `customer_nic`      CHAR(10) NOT NULL,
  `bicycle_id`        INT(10)  NOT NULL,
  `payment_status_id` INT(1)   NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rental_store1_idx` (`rent_from` ASC),
  INDEX `fk_rental_store2_idx` (`return_to` ASC),
  INDEX `fk_rental_customer1_idx` (`customer_nic` ASC),
  INDEX `fk_rental_bicycle1_idx` (`bicycle_id` ASC),
  INDEX `fk_rental_payment_status1_idx` (`payment_status_id` ASC),
  CONSTRAINT `fk_rental_store1`
    FOREIGN KEY (`rent_from`)
      REFERENCES `brs`.`store` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental_store2`
    FOREIGN KEY (`return_to`)
      REFERENCES `brs`.`store` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental_customer1`
    FOREIGN KEY (`customer_nic`)
      REFERENCES `brs`.`customer` (`nic`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental_bicycle1`
    FOREIGN KEY (`bicycle_id`)
      REFERENCES `brs`.`bicycle` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental_payment_status1`
    FOREIGN KEY (`payment_status_id`)
      REFERENCES `brs`.`payment_status` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
  ENGINE = InnoDB;