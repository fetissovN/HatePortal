DROP DATABASE IF EXISTS hate;

CREATE DATABASE IF NOT EXISTS hate;

USE hate;


-- Table: users

CREATE TABLE hate.users(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  nickname VARCHAR(100) NOT NULL ,
  username VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  surname VARCHAR(255) NOT NULL ,
  email VARCHAR(100) NOT NULL UNIQUE ,
  phone VARCHAR(100) NOT NULL ,
  rate INT NOT NULL,
  role INT NOT NULL
)
  ENGINE = InnoDB;

-- Table: user roles

# CREATE TABLE roles(
#   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
#   role_name VARCHAR(100) NOT NULL
# )
#   ENGINE = InnoDB;

-- Table: company

CREATE TABLE hate.companies(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(255) NOT NULL ,
  lable VARCHAR(255) NOT NULL ,
  adress VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL

)
  ENGINE InnoDB;

-- Table: user mapping roles

# CREATE TABLE user_roles(
#   user_id INT NOT NULL ,
#   role_id INT NOT NULL ,
#
#   FOREIGN KEY (id_user) REFERENCES users(id),
#   FOREIGN KEY (role_id) REFERENCES roles(id),
#
#   UNIQUE (id_user,role_id)
# )
#   ENGINE = InnoDB;


-- Table: users posts

CREATE TABLE hate.users_posts(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  target VARCHAR(255) NOT NULL ,
  title VARCHAR(100) NOT NULL ,
  post VARCHAR(1000) NOT NULL ,
  user_id INT ,
  post_date DATETIME NOT NULL,
  like_count INT NOT NULL DEFAULT 0,
  photo LONGBLOB,

  FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE
)
  ENGINE = InnoDB;

CREATE TABLE hate.users_messages(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  message VARCHAR(300) NOT NULL ,
  user_id INT NOT NULL ,
  post_id INT NOT NULL ,
  like_count INT NOT NULL DEFAULT 0,
  message_date DATETIME NOT NULL,

  FOREIGN KEY (post_id) REFERENCES users_posts(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE
)
  ENGINE = InnoDB;

-- Table: response of companies

CREATE TABLE hate.companies_response(
  id INT NOT NULL PRIMARY KEY ,
  post VARCHAR(1000) NOT NULL ,
  post_id INT NOT NULL ,

  FOREIGN KEY (post_id) REFERENCES users_posts(id) ON UPDATE CASCADE ON DELETE CASCADE
)
  ENGINE = InnoDB;


