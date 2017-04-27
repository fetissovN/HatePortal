-- Table: users

CREATE TABLE users(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  username VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  surname VARCHAR(255) NOT NULL ,
  email VARCHAR(100) NOT NULL ,
  phone VARCHAR(100) NOT NULL ,
  rate INT NOT NULL
)
  ENGINE = InnoDB;

-- Table: user roles

CREATE TABLE roles(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  role_name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table: company

CREATE TABLE companies(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(255) NOT NULL ,
  lable VARCHAR(255) NOT NULL ,
  adress VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL ,

)
  ENGINE InnoDB;

-- Table: user mapping roles

CREATE TABLE user_roles(
  user_id INT NOT NULL ,
  role_id INT NOT NULL ,

  FOREIGN KEY (id_user) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),

  UNIQUE (id_user,role_id)
)
  ENGINE = InnoDB;


-- Table: users posts

CREATE TABLE users_posts(
  id INT NOT NULL PRIMARY KEY ,
  title VARCHAR(100) NOT NULL ,
  post VARCHAR(1000) NOT NULL ,

  FOREIGN KEY (id) REFERENCES users(id)
)
  ENGINE = InnoDB;

-- Table: response of companies

CREATE TABLE companies_response(
  id INT NOT NULL PRIMARY KEY ,
  post VARCHAR(1000) NOT NULL
)
  ENGINE = InnoDB;
