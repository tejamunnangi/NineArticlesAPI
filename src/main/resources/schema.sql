CREATE TABLE article (
  article_id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  updated_date DATE  NOT NULL,
  body CLOB DEFAULT NULL
);

CREATE TABLE tag (
  tag VARCHAR(250) PRIMARY KEY,
  updated_date DATE NOT NULL
);

CREATE TABLE article_tag (
  article_id INT NOT NULL,
  tag VARCHAR(250) NOT NULL
);

ALTER TABLE article_tag add primary key(article_id, tag);