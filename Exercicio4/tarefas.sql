CREATE DATABASE tarefas;
USE tarefas;

CREATE TABLE user (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE task (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(200) NOT NULL,
    date DATE NOT NULL,
    user_id BIGINT(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT email, password FROM user;