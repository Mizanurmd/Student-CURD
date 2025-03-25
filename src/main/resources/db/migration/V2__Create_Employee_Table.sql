-- Create ENUM for Department
CREATE TYPE department_enum AS ENUM (
    'SCIENCE',
    'ARTS',
    'COMMERCE',
    'IT',
    'ACCOUNTING',
    'FINANCE',
    'ENGINEERING',
    'BUSINESS',
    'ENGINEERING_SCIENCE',
    'ENGLISH',
    'POLITICAL_SCIENCE',
    'OTHER'
    );

-- Create ENUM for Gender
CREATE TYPE gender_enum AS ENUM (
    'MALE',
    'FEMALE',
    'OTHER'
    );

CREATE TABLE employee
(
    id          INT PRIMARY KEY,
    name        VARCHAR(255)        NOT NULL,
    surname     VARCHAR(255)        NOT NULL,
    designation VARCHAR(255),
    salary      DOUBLE PRECISION    NOT NULL,
    department  department_enum     NOT NULL,
    gender      gender_enum         NOT NULL,
    email       VARCHAR(255) UNIQUE NOT NULL,
    phone       VARCHAR(20),
    photo       BYTEA,
    address_id  INT UNIQUE,
    CONSTRAINT fk_employee_address FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE CASCADE
);
