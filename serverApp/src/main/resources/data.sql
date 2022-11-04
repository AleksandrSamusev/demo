INSERT INTO users (first_name, second_name, email, phone_number)
VALUES ('user1.first_name', 'user1.second_name', 'user1@user1@yy', 8080808080);

INSERT INTO users (first_name, second_name, email, phone_number)
VALUES ('user2.first_name', 'user2.second_name', 'user2@user2@yy', 8181818181);

INSERT INTO users (first_name, second_name, email, phone_number)
VALUES ('user3.first_name', 'user3.second_name', 'user3@user3@yy', 8282828282);

INSERT INTO products (name, description, price)
VALUES ('apple', 'the best apple ever', 17.30);

INSERT INTO products (name, description, price)
VALUES ('banana', 'the best banana ever', 9.85);

INSERT INTO products (name, description, price)
VALUES ('yogurt', 'the best yogurt ever', 99.90);



INSERT INTO orders (user_id, order_date, delivery_date)
VALUES (1, current_timestamp, '2023-09-12 10:10:00');

INSERT INTO orders (user_id, order_date, delivery_date)
VALUES (3, current_timestamp, '2023-02-24 12:10:00');

INSERT INTO orders (user_id, order_date, delivery_date)
VALUES (4, current_timestamp, '2023-01-02 18:50:00');


INSERT INTO order_lines (order_id, product_id, quantity, measure_unit)
VALUES (1, 1, 40, 'PCS');

INSERT INTO order_lines (order_id, product_id, quantity, measure_unit)
VALUES (3, 2, 20, 'KG');

INSERT INTO order_lines (order_id, product_id, quantity, measure_unit)
VALUES (4, 3, 10, 'PCS');


INSERT INTO addresses (user_id, country, city, street, house_number, flat_number)
VALUES (1, 'RUSSIA', 'MOSCOW', 'POKROVSKAYA', '4B', '335');

INSERT INTO addresses (user_id, country, city, street, house_number, flat_number)
VALUES (3, 'USA', 'NEW JERSEY', 'LINCOLN', '33', '2');

INSERT INTO addresses (user_id, country, city, street, house_number, flat_number)
VALUES (3, 'AUSTRALIA', 'SYDNEY', 'BIGSTREET', '2', '23');