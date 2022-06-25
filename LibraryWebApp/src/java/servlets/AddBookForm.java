CREATE USER 'webstudent'@'localhost' IDENTIFIED BY 'webstudent';
GRANT ALL PRIVILEGES ON * . * TO 'webstudent'@'localhost';
ALTER USER 'webstudent'@'localhost' IDENTIFIED WITH mysql_native_password BY 'webstudent';
