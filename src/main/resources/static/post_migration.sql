use springblog_db;

CREATE TABLE posts (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       title VARCHAR(100) NOT NULL,
                       body VARCHAR(255),
                       user_id INT UNSIGNED NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       username VARCHAR(100) NOT NULL,
                       PRIMARY KEY (id),
);