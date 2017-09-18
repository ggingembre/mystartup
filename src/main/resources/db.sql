-- -----------------------------------------------------
-- Schema STARTUP
-- -----------------------------------------------------
-- DROP SCHEMA IF EXISTS `STARTUP` ;

-- -----------------------------------------------------
-- Schema STARTUP
-- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS `STARTUP` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ; --

-- ДОПИСАТЬ FOREIGN KEYS, INDEXES, ПРОВЕРИТЬ ДЛИНУ ПЕРЕМЕННЫХ

CREATE TABLE IF NOT EXISTS contact
(
  id          BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  email       VARCHAR(45)  NOT NULL,
  phoneNumber VARCHAR(455) NULL,
  city        VARCHAR(455) NULL,
  country     VARCHAR(455) NULL
);
CREATE TABLE IF NOT EXISTS user
(
  username             VARCHAR(45)  NOT NULL
    PRIMARY KEY,
  password             VARCHAR(455) NOT NULL,
  profileFotoLink      VARCHAR(455) NULL,
  personalPageFotoLink VARCHAR(455) NULL,
  youtubeLink          VARCHAR(455) NULL,
  aboutMe              VARCHAR(455) NULL,
  skills               VARCHAR(455) NULL,
  contact_id           BIGINT       NULL,
  CONSTRAINT user_contact_id_fk
  FOREIGN KEY (contact_id) REFERENCES contact (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS user_roles
(
  user_username VARCHAR(45) NOT NULL,
  role          VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_username, role)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `experience` (
  `id`             BIGINT PRIMARY KEY                              AUTO_INCREMENT,
  `company`        VARCHAR(45)                                     DEFAULT NULL,
  `position`       VARCHAR(455)                                    DEFAULT NULL,
  `responsibility` VARCHAR(455)                                    DEFAULT NULL,
--    `from`           DATE                                            DEFAULT NULL,
--    `until`          DATE                                            DEFAULT NULL,
  CONSTRAINT experience_id_uindex UNIQUE (id)
);


CREATE TABLE IF NOT EXISTS user_experience
(
  user_username  VARCHAR(45) NOT NULL,
  experiences_id BIGINT      NOT NULL,
  CONSTRAINT user_experience_user_username_fk
  FOREIGN KEY (user_username) REFERENCES user (username),
  CONSTRAINT user_experience_experiences_id_fk
  FOREIGN KEY (experiences_id) REFERENCES experience (id)
);


CREATE TABLE IF NOT EXISTS `education` (
  `id`                     BIGINT PRIMARY KEY                              AUTO_INCREMENT,
  `educationalInstitution` VARCHAR(455)                                    DEFAULT NULL,
  `educationalStage`       VARCHAR(455)                                    DEFAULT NULL,
  `faculty`                VARCHAR(455)                                    DEFAULT NULL,
  `fieldOfStudy`           VARCHAR(455)                                    DEFAULT NULL,
  `modeOfStudy`            VARCHAR(45)                                     DEFAULT NULL,
--   `from`                   DATE                                            DEFAULT NULL,
--   `until`                  DATE                                            DEFAULT NULL,
  CONSTRAINT experience_id_uindex UNIQUE (id)
);

CREATE TABLE IF NOT EXISTS user_education
(
  user_username  VARCHAR(45) NOT NULL,
  educations_id BIGINT      NOT NULL,
  CONSTRAINT user_education_user_username_fk
  FOREIGN KEY (user_username) REFERENCES user (username),
  CONSTRAINT user_education_educations_id_fk
  FOREIGN KEY (educations_id) REFERENCES education (id)
);
