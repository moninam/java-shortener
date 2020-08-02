DROP TABLE IF EXISTS url_shortener;

CREATE TABLE url_shortener (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  url VARCHAR(250) NOT NULL,
  alias VARCHAR(250) NOT NULL
);

INSERT INTO url_shortener (url, alias) VALUES
  ('Aliko', 'Dangote'),
  ('Bill', 'Gates'),
  ('Folrunsho', 'Alakija');