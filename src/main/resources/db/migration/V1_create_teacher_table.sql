CREATE TABLE teacher
(
    t_id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    father_name   VARCHAR(255),
    mother_name   VARCHAR(255),
    mobile        VARCHAR(20)  NOT NULL,
    qualification VARCHAR(255),
    subject       VARCHAR(255),
    gender        VARCHAR(50)  NOT NULL,
    department    VARCHAR(100) NOT NULL,
    nationality   VARCHAR(100),
    salary        DOUBLE,
    dob           DATE,
    joining_date  DATE,
    end_date      DATE,
    remarks       TEXT,
    photo         LONGBLOB,
    attachment    LONGBLOB
);
