CREATE TABLE users (
user_id SERIAL PRIMARY KEY,
login varchar(25) NOT NULL ,
password varchar(25) NOT NULL,
role varchar(25),
active boolean
);

CREATE TABLE orders (
order_id SERIAL PRIMARY KEY,
user_id int REFERENCES useintrs (user_id)
);

CREATE TABLE categories (
category_id SERIAL PRIMARY KEY,
name varchar(25)
);

CREATE TABLE items (
item_id SERIAL PRIMARY KEY,
name varchar(25),
category_id int REFERENCES categories (category_id),
price int,
available int,
image varchar(25)
);

CREATE TABLE item_orders (
item_order_id SERIAL,
item_id int REFERENCES items (item_id),
order_id int REFERENCES orders (order_id),
quantity int
);

CREATE TABLE IF NOT EXISTS cart (
id SERIAL PRIMARY KEY,
user_id int REFERENCES users (user_id),
item_id int REFERENCES items (item_id),
quantity int
);