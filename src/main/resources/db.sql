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
  contact_id bigint null,
  constraint user_contact_id_fk
  foreign key(contact_id) references contact (id)
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

CREATE TABLE IF NOT EXISTS `experience` (
  `id`             BIGINT PRIMARY KEY                              AUTO_INCREMENT,
  `company`        VARCHAR(45)                                      DEFAULT NULL,
  `position`       VARCHAR(455)                                     DEFAULT NULL,
  `responsibility` VARCHAR(455)                                     DEFAULT NULL,
  `from`           TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL,
  `until`          TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL,
  CONSTRAINT experience_id_uindex UNIQUE (id)
);


create table user_experience
(
  user_username varchar(45) not null,
  experiences_id bigint not null,
  constraint user_experience_user_USERNAME_fk
  foreign key (user_username) references startup.user (USERNAME),
  constraint user_experience_experience_id_fk
  foreign key (experiences_id) references startup.experience (id)
)
;

create index user_experience_experience_id_fk
  on user_experience (experiences_id)
;

create index user_experience_user_USERNAME_fk
  on user_experience (user_username)
;