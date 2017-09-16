-- -----------------------------------------------------
-- Schema STARTUP
-- -----------------------------------------------------
-- DROP SCHEMA IF EXISTS `STARTUP` ;

-- -----------------------------------------------------
-- Schema STARTUP
-- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS `STARTUP` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ; --

-- ДОПИСАТЬ FOREIGN KEYS, INDEXES, ПРОВЕРИТЬ ДЛИНУ ПЕРЕМЕННЫХ

create table if not exists user
(
  USERNAME varchar(45) not null
    primary key,
  PASSWORD varchar(455) not null,
  profileFotoLink varchar(455) null,
  personalPageFotoLink varchar(455) null,
  youtubeLink varchar(455) null,
  aboutMe varchar(455) null,
  skills varchar(455) null,
  contact_id bigint null
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table if not exists user_roles
(
  USER_USERNAME varchar(45) not null,
  ROLE varchar(45) not null,
  primary key (USER_USERNAME, ROLE)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists contact
(
  id bigint auto_increment
    primary key,
  email varchar(45) not null,
  phoneNumber varchar(455) null,
  city varchar(455) null,
  country varchar(455) null
)
