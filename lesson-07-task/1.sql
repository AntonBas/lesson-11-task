DROP DATABASE IF EXISTS brick_factory;
CREATE DATABASE brick_factory;
USE brick_factory;

CREATE TABLE user (
    id int (11) NOT NULL AUTO_INCREMENT,
    email varchar (50) NOT NULL, 
    first_name varchar (255) NOT NULL, 
    last_name varchar (255) NOT NULL, 
    role varchar (255) NOT NULL, 
    password varchar (255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    position VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE bricks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    price_per_unit DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_first_name VARCHAR(30) NOT NULL,
    customer_last_name VARCHAR (30) NOT NULL,
    order_date DATE NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE order_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    brick_id INT NOT NULL,
    quantity INT NOT NULL,
    price_per_unit DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(id) ON DELETE CASCADE,
    FOREIGN KEY (brick_id) REFERENCES Bricks(id) ON DELETE CASCADE
);