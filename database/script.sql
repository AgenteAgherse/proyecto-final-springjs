CREATE TABLE personas (
  identification INTEGER UNSIGNED  NOT NULL  ,
  document_type VARCHAR(8)  NOT NULL  ,
  names VARCHAR(100)  NOT NULL  ,
  surname VARCHAR(100)  NOT NULL  ,
  working_on VARCHAR(50)  NOT NULL  ,
  email VARCHAR(100)  NOT NULL  ,
  saves_percent INTEGER UNSIGNED  NOT NULL  ,
  birthday DATE  NOT NULL    ,
PRIMARY KEY(identification));



CREATE TABLE users (
  user_id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  person_id INTEGER UNSIGNED  NOT NULL  ,
  passcode TEXT  NOT NULL    ,
PRIMARY KEY(user_id)  ,
INDEX users_FKIndex1(person_id),
  FOREIGN KEY(person_id)
    REFERENCES personas(identification)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE estadisticas (
  register_id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  person_id INTEGER UNSIGNED  NOT NULL  ,
  created_at DATE  NOT NULL  ,
  utilities DOUBLE  NOT NULL DEFAULT 0 ,
  saves DOUBLE  NOT NULL DEFAULT 0   ,
PRIMARY KEY(register_id)  ,
INDEX estadisticas_FKIndex1(person_id),
  FOREIGN KEY(person_id)
    REFERENCES personas(identification)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE actualizations (
  id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  person_id INTEGER UNSIGNED  NOT NULL  ,
  earns DOUBLE  NOT NULL DEFAULT 0 ,
  spends DOUBLE  NOT NULL DEFAULT 0 ,
  created_at DATE  NOT NULL    ,
PRIMARY KEY(id)  ,
INDEX actualizations_FKIndex1(person_id),
  FOREIGN KEY(person_id)
    REFERENCES personas(identification)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE comments (
  comment_id INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  details_id INTEGER UNSIGNED  NOT NULL  ,
  description TEXT  NOT NULL  ,
  created_at DATE  NOT NULL    ,
PRIMARY KEY(comment_id)  ,
INDEX comments_FKIndex1(details_id),
  FOREIGN KEY(details_id)
    REFERENCES actualizations(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);




