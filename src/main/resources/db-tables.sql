CREATE TABLE users (
user_id int SERIAL,
login varchar(25) NOT NULL ,
password varchar(25) NOT NULL,
role varchar(25),
active boolean
);

CREATE TABLE orders (
order_id SERIAL PRIMARY KEY,
user_id int REFERENCES users (ID)
);

CREATE TABLE categories (
category_id SERIAL PRIMARY KEY,
name VARCHAR
);

CREATE TABLE items (
item_id SERIAL PRIMARY KEY,
name VARCHAR(25),
category_id int REFERENCES categories (category_id),
price int,
available int
);

CREATE TABLE item_orders (
item_id int REFERENCES items (item_id),
order_id int REFERENCES orders (order_id),
count int
);

