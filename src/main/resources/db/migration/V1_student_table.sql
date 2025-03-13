-- V1__Create_student_table.sql

CREATE TABLE student
(
    sId          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    father_name VARCHAR(255),
    mother_name VARCHAR(255),
    dob         DATE,
    phone       VARCHAR(20),
    remark      TEXT,
    gender      VARCHAR(10) CHECK (gender IN ('MALE', 'FEMALE', 'OTHER')),
    country_id  INT NULL,
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country (cId) ON DELETE SET NULL
);
