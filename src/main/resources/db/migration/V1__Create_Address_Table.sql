CREATE TABLE address
(
    id      INT PRIMARY KEY,
    street  VARCHAR(255) NOT NULL,
    city    VARCHAR(100) NOT NULL,
    state   VARCHAR(100) NOT NULL,
    zip     VARCHAR(20),
    country VARCHAR(100) NOT NULL
);
