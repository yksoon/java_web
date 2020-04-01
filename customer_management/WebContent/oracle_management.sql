CREATE USER management IDENTIFIED BY 1234;
GRANT CONNECT, RESOURCE TO management;
GRANT CREATE VIEW TO management;
ALTER USER management ACCOUNT UNLOCK;

CREATE TABLE customer_tab (
							customerNo INT,
							name VARCHAR2(20) NOT NULL,
							phone VARCHAR2(20) NOT NULL,
							email VARCHAR2(50),
							CONSTRAINT PK_customer_tab PRIMARY KEY(customerNo)
							);
							
CREATE TABLE service_tab (
							serviceNo INT,
							content VARCHAR2(20) NOT NULL,
							price INT NOT NULL,
							CONSTRAINT pk_service_tab PRIMARY KEY(serviceNo)
							);
							
CREATE TABLE main_tab (day DATE PRIMARY KEY,
						name VARCHAR2(20) NOT NULL,
						content VARCHAR2(20) NOT NULL,
						price INT NOT NULL,
						customerNo INT REFERENCES customer_tab(customerNo),
						serviceNo INT REFERENCES service_tab(serviceNo)
						);
						
CREATE TABLE sale_tab (
							day DATE,
							price INT NOT NULL,
							CONSTRAINT PK_sale_tab PRIMARY KEY(day),
							CONSTRAINT FK_sale_tab FOREIGN KEY(day) REFERENCES main_tab(day)
							);
							
SELECT * FROM tab;

CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE service_seq START WITH 1 INCREMENT BY 1;

INSERT INTO customer_tab VALUES (customer_seq.NEXTVAL, '테스트', '010-4444-4444', 'test@naver.com');
SELECT * FROM customer_tab;

INSERT INTO service_tab VALUES (service_seq.NEXTVAL, '시술1', '60000');
SELECT * FROM service_tab;

INSERT INTO main_tab VALUES (SYSDATE, '테스트', '시술1', 60000, 1, 1);
SELECT * FROM main_tab;

DROP TABLE sale_tab;
DROP TABLE main_tab;
DROP TABLE service_tab;
DROP TABLE customer_tab;
DROP SEQUENCE service_seq;
DROP SEQUENCE customer_seq;


SELECT name, phone, email FROM customer_tab WHERE customerNo=1
SELECT serviceNo, content FROM service_tab