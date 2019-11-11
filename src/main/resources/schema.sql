CREATE TABLE article (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  updated_date DATE  NOT NULL,
  body CLOB DEFAULT NULL
);

CREATE TABLE tag (
  article_id INT NOT NULL,
  tag VARCHAR(250) NOT NULL
);

ALTER TABLE tag ADD PRIMARY KEY (article_id, tag);