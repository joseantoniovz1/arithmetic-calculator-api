INSERT INTO users (email, password, status) VALUES ('michael@scott.com', 'michael', 'active');
INSERT INTO users (email, password, status) VALUES ('dwight@schrute.com', 'dwight', 'inactive');
INSERT INTO users (email, password, status) VALUES ('pam@beasley.com', 'pam', 'active');
INSERT INTO users (email, password, status) VALUES ('jim@halpert.com', 'jim', 'inactive');

INSERT INTO credit (id, user_id, credit) VALUES (1, 1, 99.99);

INSERT INTO operation (type, cost) VALUES ('Addition', 10);
INSERT INTO operation (type, cost) VALUES ('Substraction', 20);
INSERT INTO operation (type, cost) VALUES ('Multiplication', 30);
INSERT INTO operation (type, cost) VALUES ('Division', 40);
INSERT INTO operation (type, cost) VALUES ('Square Root', 50);
INSERT INTO operation (type, cost) VALUES ('Random String', 60);

INSERT INTO record (operation_id, user_id, amount, user_balance, date) VALUES (1, 1, 10.10, 5.5, current_date);
INSERT INTO record (operation_id, user_id, amount, user_balance, date) VALUES (2, 2, 20.20, 10.10, current_date);
INSERT INTO record (operation_id, user_id, amount, user_balance, date) VALUES (3, 3, 30.30, 15.15, current_date);
INSERT INTO record (operation_id, user_id, amount, user_balance, date) VALUES (4, 4, 10.10, 5.5, current_date);
INSERT INTO record (operation_id, user_id, amount, user_balance, date) VALUES (5, 2, 20.20, 10.10, current_date);
INSERT INTO record (operation_id, user_id, amount, user_balance, date) VALUES (6, 3, 30.30, 15.15, current_date);




