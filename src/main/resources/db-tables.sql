CREATE TABLE users (
ID int PRIMARY KEY,
login varchar(25) NOT NULL ,
password varchar(25) NOT NULL,
role varchar(25),
active varchar(25)
);

CREATE TABLE orders (
order_id int PRIMARY KEY,
user_id int REFERENCES users (ID)
);

CREATE TABLE categories (
category_id int PRIMARY KEY,
name VARCHAR
);

CREATE TABLE items (
item_id int PRIMARY KEY,
category_id int REFERENCES categories (category_id),
price int,
available int
);

CREATE TABLE item_orders (
item_id int REFERENCES items (item_id),
order_id int REFERENCES orders (order_id),
count int
);