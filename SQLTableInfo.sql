CREATE TABLE customer_details(customer_id INT generated always as identity PRIMARY KEY,
ProjectZeroGJ(# customer_name VARCHAR(30),
ProjectZeroGJ(# customer_email VARCHAR(40),
ProjectZeroGJ(# user_type VARCHAR(20),
ProjectZeroGJ(# customer_removed BOOLEAN);
CREATE TABLE

 SELECT* FROM customer_details;
 customer_id |  customer_name  |     customer_email     | user_type | customer_removed
-------------+-----------------+------------------------+-----------+------------------
           1 | Minnie Pearl    | pearls@ocean.com       | Customer  |
           2 | John Smith      | jsmith@smithsonian.org | Customer  |
           3 | Rod Sterling    | twilightzone@mail.com  | Customer  |
           4 | Miley McConnell | green@ireland.com      | Customer  |
           5 | Sean Conner     | S.Conner@yahoo.com     | Customer  |
(5 rows)

CREATE TABLE employee_details(employee_id INT generated always as identity PRIMARY KEY,
ProjectZeroGJ(# employee_name VARCHAR(30),
ProjectZeroGJ(# employee_email VARCHAR(40),
ProjectZeroGJ(# user_type VARCHAR(20),
ProjectZeroGJ(# employee_removed BOOLEAN);
CREATE TABLE

SELECT* FROM employee_details;
 employee_id | employee_name | employee_email | user_type | employee_removed
-------------+---------------+----------------+-----------+------------------
(0 rows)

CREATE TABLE manager_details(employee_id INT generated always as identity PRIMARY KEY,
ProjectZeroGJ(# manager_name VARCHAR(30),
ProjectZeroGJ(# manager_email VARCHAR(40),
ProjectZeroGJ(# user_type VARCHAR(20),
CREATE TABLE

SELECT* FROM manager_details;
 employee_id | manager_name | manager_email | user_type
-------------+--------------+---------------+-----------
(0 rows)

CREATE TABLE user_details(user_id INT generated always as identity PRIMARY KEY,
ProjectZeroGJ(# user_name VARCHAR(30),
ProjectZeroGJ(# user_email VARCHAR(40),
ProjectZeroGJ(# user_type VARCHAR(20),
ProjectZeroGJ(# user_removed BOOLEAN);
CREATE TABLE

SELECT* FROM user_details;
 user_id |  user_name   |     user_email     | user_type | user_removed
---------+--------------+--------------------+-----------+--------------
       2 | Minnie Mouse | Cheesey@funny.com  | User      |
       1 | Mickey Mouse | cartoons@funny.com | User      |
(2 rows)

CREATE TABLE payment_details(payment_id INT generated always as identity PRIMARY KEY,
ProjectZeroGJ(# payment_date TIMESTAMP,
ProjectZeroGJ(# offer_id INT,
ProjectZeroGJ(# user_id INT,
ProjectZeroGJ(# payment_complete BOOLEAN,
ProjectZeroGJ(# CONSTRAINT fk_offer_id FOREIGN KEY(offer_id) REFERENCES offer_details(offer_id),
ProjectZeroGJ(# CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES user_details(user_id));
CREATE TABLE

SELECT* FROM payment_details;
 payment_id | payment_date | offer_id | user_id | payment_complete
------------+--------------+----------+---------+------------------
(0 rows)

CREATE TABLE item_details(item_id INT generated always as identity PRIMARY KEY,
ProjectZeroGJ(# item_title VARCHAR(40),
ProjectZeroGJ(# item_genre VARCHAR(20),
ProjectZeroGJ(# item_artist VARCHAR(40),
ProjectZeroGJ(# item_cost INT,
ProjectZeroGJ(# item_removed BOOLEAN);
CREATE TABLE

 SELECT* FROM item_details;
 item_id |         item_title          | item_genre  |       item_artist       | item_cost | item_removed
---------+-----------------------------+-------------+-------------------------+-----------+--------------
       1 | Life Is Worth Living        | upbeat rock | Gloria Smith            |        10 |
       2 | Swim Good                   | upbeat jazz | Frank Ocean             |        10 |
       3 | Self Made                   | heavy rock  | Bryson Tiller           |        10 |
       4 | Alaska                      | light rock  | Maggie Rogers           |        10 |
       5 | The Flight of The Bumblebee | classical   | Nikolai Rimsky-Korsakov |        10 |
(5 rows)


CREATE TABLE offer_details(offer_id INT generated always as identity PRIMARY KEY,
ProjectZeroGJ(# item_id INT,
ProjectZeroGJ(# user_id INT,
ProjectZeroGJ(# offer_price INT,
ProjectZeroGJ(# offer_won BOOLEAN,
ProjectZeroGJ(# CONSTRAINT fk_item_id FOREIGN KEY(item_id) REFERENCES item_details(item_id),
ProjectZeroGJ(# CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES user_details(user_id));
CREATE TABLE

SELECT* FROM offer_details;
 offer_id | item_id | user_id | offer_price | offer_won
----------+---------+---------+-------------+-----------
(0 rows)