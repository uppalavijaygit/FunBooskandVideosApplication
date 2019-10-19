DROP TABLE IF EXISTS USER_MEMBERSHIP;
DROP TABLE IF EXISTS USER_ADDRESS;
 
CREATE TABLE USER_MEMBERSHIP (
  CUSTOMER_ID INT PRIMARY KEY NOT NULL,
  membership_type VARCHAR(250),
  member_ship_start_date DATE,
  member_ship_expiry_date DATE,
  is_active BOOLEAN,
);

CREATE TABLE USER_ADDRESS(
  CUSTOMER_ID INT PRIMARY KEY NOT NULL,
  ADDRESS_TYPE VARCHAR(250),
  HNO VARCHAR(250),
  Street_NAME VARCHAR(250),
  area VARCHAR(250),
  county VARCHAR(250),
  PIN_CODE VARCHAR(250)
);

INSERT INTO USER_ADDRESS (CUSTOMER_ID, ADDRESS_TYPE, HNO,Street_NAME,area,county,PIN_CODE)
VALUES ('101','HOME', '16', 'medway road','dartford','kent','DA14PN');
INSERT INTO USER_ADDRESS (CUSTOMER_ID, ADDRESS_TYPE, HNO,Street_NAME,area,county,PIN_CODE)
VALUES ('102','HOME', '17', 'medway road','dartford','kent','DA14PN');
INSERT INTO USER_ADDRESS (CUSTOMER_ID, ADDRESS_TYPE, HNO,Street_NAME,area,county,PIN_CODE)
VALUES ('103','HOME', '18', 'medway road','dartford','kent','DA14PN');
INSERT INTO USER_ADDRESS (CUSTOMER_ID, ADDRESS_TYPE, HNO,Street_NAME,area,county,PIN_CODE)
VALUES ('104','HOME', '19', 'medway road','dartford','kent','DA14PN');
INSERT INTO USER_ADDRESS (CUSTOMER_ID, ADDRESS_TYPE, HNO,Street_NAME,area,county,PIN_CODE)
VALUES ('105','HOME', '20', 'medway road','dartford','kent','DA14PN');

INSERT INTO USER_MEMBERSHIP (CUSTOMER_ID, membership_type, member_ship_start_date,member_ship_expiry_date,is_active)
VALUES ('101',NULL, NULL, NULL,'FALSE');
INSERT INTO USER_MEMBERSHIP (CUSTOMER_ID, membership_type, member_ship_start_date,member_ship_expiry_date,is_active)
VALUES ('102',NULL, NULL, NULL,'FALSE');
INSERT INTO USER_MEMBERSHIP (CUSTOMER_ID, membership_type, member_ship_start_date,member_ship_expiry_date,is_active)
VALUES ('103',NULL, NULL, NULL,'FALSE');
INSERT INTO USER_MEMBERSHIP (CUSTOMER_ID, membership_type, member_ship_start_date,member_ship_expiry_date,is_active)
VALUES ('104',NULL, NULL, NULL,'FALSE');
INSERT INTO USER_MEMBERSHIP (CUSTOMER_ID, membership_type, member_ship_start_date,member_ship_expiry_date,is_active)
VALUES ('105',NULL, NULL, NULL,'FALSE');

