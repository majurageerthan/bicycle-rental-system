CREATE USER IF NOT EXISTS 'manager'@'localhost' IDENTIFIED BY '1234';
CREATE USER IF NOT EXISTS 'cashier'@'localhost' IDENTIFIED BY '1234';
CREATE USER IF NOT EXISTS 'customer'@'localhost' IDENTIFIED BY '1234';
GRANT SELECT ON `brs`.`bicycle` TO 'cashier'@'localhost';
GRANT SELECT, INSERT, DELETE, UPDATE ON `brs`.`bicycle` TO 'manager'@'localhost';