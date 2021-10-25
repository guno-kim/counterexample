-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema counterexample
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema counterexample
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `counterexample` DEFAULT CHARACTER SET utf8 ;
USE `counterexample` ;

-- -----------------------------------------------------
-- Table `counterexample`.`USERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `counterexample`.`USERS` (
  `user_id` BIGINT NOT NULL,
  `name` VARCHAR(45) NULL,
  `created_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `counterexample`.`PROBLEMS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `counterexample`.`PROBLEMS` (
  `problem_id` BIGINT NOT NULL,
  `created_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  `problem_type` VARCHAR(45) NULL,
  `problem_num` INT NULL,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `user_id` BIGINT NOT NULL,
  `answer_code` VARCHAR(45) NULL,
  PRIMARY KEY (`problem_id`, `user_id`),
  INDEX `fk_PROBLEMS_USERS1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_PROBLEMS_USERS1`
    FOREIGN KEY (`user_id`)
    REFERENCES `counterexample`.`USERS` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `counterexample`.`INT_VARIABLES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `counterexample`.`INT_VARIABLES` (
  `variable_id` BIGINT NOT NULL,
  `max` VARCHAR(20) NULL,
  `min` VARCHAR(20) NULL,
  `fix` TINYINT NULL,
  `problem_id` BIGINT NOT NULL,
  `name` VARCHAR(1) NULL,
  PRIMARY KEY (`variable_id`, `problem_id`),
  INDEX `fk_INT_VARIABLES_PROBLEMS1_idx` (`problem_id` ASC) VISIBLE,
  CONSTRAINT `fk_INT_VARIABLES_PROBLEMS1`
    FOREIGN KEY (`problem_id`)
    REFERENCES `counterexample`.`PROBLEMS` (`problem_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `counterexample`.`PROBLEM_LIKE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `counterexample`.`PROBLEM_LIKE` (
  `user_id` BIGINT NOT NULL,
  `problem_id` BIGINT NOT NULL,
  `like` TINYINT NULL,
  PRIMARY KEY (`user_id`, `problem_id`),
  INDEX `fk_USERS_has_PROBLEMS_PROBLEMS1_idx` (`problem_id` ASC) VISIBLE,
  INDEX `fk_USERS_has_PROBLEMS_USERS_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_USERS_has_PROBLEMS_USERS`
    FOREIGN KEY (`user_id`)
    REFERENCES `counterexample`.`USERS` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USERS_has_PROBLEMS_PROBLEMS1`
    FOREIGN KEY (`problem_id`)
    REFERENCES `counterexample`.`PROBLEMS` (`problem_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `counterexample`.`CHAR_VARIABLES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `counterexample`.`CHAR_VARIABLES` (
  `name` VARCHAR(1) NOT NULL,
  `variable_id` BIGINT NOT NULL,
  `candidates` JSON NULL,
  `problem_id` BIGINT NOT NULL,
  PRIMARY KEY (`variable_id`, `problem_id`),
  INDEX `fk_CHAR_VARIABLES_PROBLEMS1_idx` (`problem_id` ASC) VISIBLE,
  CONSTRAINT `fk_CHAR_VARIABLES_PROBLEMS1`
    FOREIGN KEY (`problem_id`)
    REFERENCES `counterexample`.`PROBLEMS` (`problem_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `counterexample`.`BLOCKS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `counterexample`.`BLOCKS` (
  `block_id` BIGINT NOT NULL,
  `content` JSON NULL,
  `vertical_rep` INT NULL,
  `horizonal_rep` INT NULL,
  `space` TINYINT NULL,
  `problem_id` BIGINT NOT NULL,
  PRIMARY KEY (`block_id`, `problem_id`),
  INDEX `fk_BLOCKS_PROBLEMS1_idx` (`problem_id` ASC) VISIBLE,
  CONSTRAINT `fk_BLOCKS_PROBLEMS1`
    FOREIGN KEY (`problem_id`)
    REFERENCES `counterexample`.`PROBLEMS` (`problem_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `counterexample`.`TESTCASES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `counterexample`.`TESTCASES` (
  `testcase_id` BIGINT NOT NULL,
  `input` VARCHAR(45) NULL,
  `problem_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`testcase_id`, `problem_id`, `user_id`),
  INDEX `fk_TESTCASES_PROBLEMS1_idx` (`problem_id` ASC, `user_id` ASC) VISIBLE,
  CONSTRAINT `fk_TESTCASES_PROBLEMS1`
    FOREIGN KEY (`problem_id` , `user_id`)
    REFERENCES `counterexample`.`PROBLEMS` (`problem_id` , `user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `counterexample`.`TEST_RESULTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `counterexample`.`TEST_RESULTS` (
  `test_result_id` BIGINT NOT NULL,
  `test_code` VARCHAR(45) NULL,
  `test_time` INT NULL,
  `answer_time` INT NULL,
  `error_message` VARCHAR(45) NULL,
  `test_output` VARCHAR(45) NULL,
  `answer_output` VARCHAR(45) NULL,
  `testcase_id` BIGINT NOT NULL,
  `problem_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`test_result_id`, `testcase_id`, `problem_id`, `user_id`),
  INDEX `fk_TEST_RESULTS_TESTCASES1_idx` (`testcase_id` ASC, `problem_id` ASC, `user_id` ASC) VISIBLE,
  CONSTRAINT `fk_TEST_RESULTS_TESTCASES1`
    FOREIGN KEY (`testcase_id` , `problem_id` , `user_id`)
    REFERENCES `counterexample`.`TESTCASES` (`testcase_id` , `problem_id` , `user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


