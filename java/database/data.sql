BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('jake', '$2a$10$W7X.AYDyXG76KJxaOEzfPeG.dOrwUx04yvDoo5juxV7nVl/kj0xjy','ROLE_USER'); --jakepass
INSERT INTO users (username,password_hash,role) VALUES ('anas', '$2a$10$mLgwlTYmplFMwQm3UC0P5e2ZFnF5Z3GPHa6WVsU6scrR2hJ68Q3HW','ROLE_USER'); --user3pass
INSERT INTO users (username,password_hash,role) VALUES ('rachel', '$2a$10$O88nAv2jgL.10G5bPtktmOzfvEXq5Z7XKXJnKukctbQRag31c1glC','ROLE_USER'); --user4pass
INSERT INTO users (username,password_hash,role) VALUES ('scott', '$2a$10$2DDYr/ku/ixJoJxwylgzbuCzjIcJP7StrOrSrACCgkQPhsEZYo3oa','ROLE_USER'); --user5pass
INSERT INTO users (username,password_hash,role) VALUES ('monique', '$2a$10$jCAsJHmtxEOOqKgunqP48.9Gwp/M9Li0phzBQSQij8IyBqHv0h0pO','ROLE_USER'); --user6pass
INSERT INTO users (username,password_hash,role) VALUES ('yoav', '$2a$10$qJx0yVOwQPjR7htTFY8n2ezyR13p3y.OlONn5tuxONjycnBN3nNG.','ROLE_USER'); --user7pass
INSERT INTO users (username,password_hash,role) VALUES ('tara', '$2a$10$lmhlGQ5GNVhNo.xcNuQ4.eZZbq6j4Z6.pJnzpCUX6IBQaWyP12ch6','ROLE_USER'); --user8pass

INSERT INTO trade_type (trade_type_id, trade_type_desc) VALUES (1,'BUY');
INSERT INTO trade_type (trade_type_id, trade_type_desc) VALUES (2,'SELL');

INSERT INTO stock (ticker, current_price, name, pull_date) VALUES ('DIS', 92.78, 'The Walt Disney Company', '2022-12-08');
INSERT INTO stock (ticker, current_price, name, pull_date) VALUES ('PTON', 11.92, 'Peloton Interactive, Inc.', '2022-12-08');
INSERT INTO stock (ticker, current_price, name, pull_date) VALUES ('LRN', 33.26, 'Stride, Inc.', '2022-12-08');

INSERT INTO game VALUES (DEFAULT, 'Moniques Game', '2022-07-14 00:00:00', '2022-12-25 00:00:00');

INSERT INTO account VALUES (DEFAULT, 100000,
	(SELECT user_id FROM users WHERE username = 'monique'),
	(SELECT game_id FROM game WHERE game_name = 'Moniques Game')
);




COMMIT TRANSACTION;
