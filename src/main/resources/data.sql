DROP TABLE IF EXISTS appliances;

CREATE TABLE appliances (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  serial_number VARCHAR(250) NOT NULL,
  brand VARCHAR(250) NOT NULL,
  model VARCHAR(250) NOT NULL,
  date_bought DATETIME DEFAULT NULL,
  status VARCHAR(10) DEFAULT NULL
);

--INSERT INTO appliances (serial_number, brand, model, date_bought, status) VALUES
--  ('test1', 'test1', 'test1', '2020-02-03', 'ACTIVE');
--  ('test2', 'test2', 'test2', '2020-02-03', 'ACTIVE'),
--  ('test3', 'test3', 'test3', '2020-02-03', 'ACTIVE'),;
