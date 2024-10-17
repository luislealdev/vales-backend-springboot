CREATE DATABASE IF NOT EXISTS vouchers_db;
USE vouchers_db;

-- Table for Distributors
CREATE TABLE distributor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- Store hashed passwords
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for Customers
CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    distributor_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (distributor_id) REFERENCES distributor(id) ON DELETE CASCADE
);

-- Table for Vouchers
CREATE TABLE voucher (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(36) NOT NULL UNIQUE, -- UUID for voucher codes
    amount DECIMAL(10, 2) NOT NULL,
    issue_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    is_paid BOOLEAN NOT NULL DEFAULT FALSE,
    customer_id BIGINT,
    distributor_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE,
    FOREIGN KEY (distributor_id) REFERENCES distributor(id) ON DELETE CASCADE
);

-- Table for Payments
CREATE TABLE payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    payment_date DATE NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    voucher_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (voucher_id) REFERENCES voucher(id) ON DELETE CASCADE
);

-- Insert example data
INSERT INTO distributor (name, email, password) VALUES
('Distributor A', 'distributorA@example.com', '$2a$10$EixZaYVK1fsbw1Zfbx3OXePaWxn96p36.9k4rK9nbmWkmYHbNgVqO'), -- bcrypt-hashed password
('Distributor B', 'distributorB@example.com', '$2a$10$EixZaYVK1fsbw1Zfbx3OXePaWxn96p36.9k4rK9nbmWkmYHbNgVqO');

INSERT INTO customer (name, email, distributor_id) VALUES
('Customer 1', 'customer1@example.com', 1),
('Customer 2', 'customer2@example.com', 1),
('Customer 3', 'customer3@example.com', 2);

INSERT INTO voucher (code, amount, issue_date, expiration_date, is_paid, customer_id, distributor_id) VALUES
('abc123', 100.00, '2024-01-01', '2024-06-01', FALSE, 1, 1),
('def456', 200.00, '2024-01-01', '2024-06-01', TRUE, 2, 1),
('ghi789', 150.00, '2024-01-01', '2024-06-01', FALSE, 3, 2);

INSERT INTO payment (payment_date, amount, voucher_id) VALUES
('2024-01-05', 100.00, 2);