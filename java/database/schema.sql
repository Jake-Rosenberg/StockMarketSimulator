BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS trade_type;
DROP TABLE IF EXISTS trade;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE game (
	game_id SERIAL,
	game_name varchar(50) NOT NULL UNIQUE,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
	CONSTRAINT pk_game PRIMARY KEY (game_id)
);


CREATE TABLE account (
	account_id SERIAL NOT NULL,
	balance decimal NOT NULL,
	user_id int NOT NULL,
	game_id int NOT NULL,
	CONSTRAINT pk_account PRIMARY KEY (account_id),
	CONSTRAINT fk_account_game FOREIGN KEY (game_id) references game (game_id),
	CONSTRAINT fk_account_users FOREIGN KEY (user_id) references users (user_id)
);

CREATE TABLE stock(
	stock_id SERIAL NOT NULL,
	ticker varchar NOT NULL,
	current_price decimal(13,2) NOT NULL,
	name varchar NOT NULL,
	pull_date timestamp NOT NULL,
	CONSTRAINT pk_stock PRIMARY KEY (stock_id)
);

CREATE TABLE trade_type (
	trade_type_id SERIAL NOT NULL,
	trade_type_desc varchar NOT NULL,
	CONSTRAINT pk_trade_type PRIMARY KEY (trade_type_id)
);

CREATE TABLE trade (
	trade_id SERIAL NOT NULL,
	stock_id int NOT NULL,
	account_id int NOT NULL,
	shares int NOT NULL,
	price decimal NOT NULL,
	trade_type_id int NOT NULL,
	trade_date_time timestamp NOT NULL,
	CONSTRAINT pk_trade PRIMARY KEY (trade_id),
	CONSTRAINT fk_trade_stock FOREIGN KEY (stock_id) references stock (stock_id),
	CONSTRAINT fk_trade_account FOREIGN KEY (account_id) references account (account_id),
	CONSTRAINT fk_trade_trade_type FOREIGN KEY (trade_type_id) references trade_type (trade_type_id)
);

CREATE TABLE cost_basis (
    cost_basis_id SERIAL NOT NULL,
    current_trade_id int NOT NULL,
    remaining_shares int NOT NULL,
    total_shares int NOT NULL,
    cost_basis decimal NOT NULL,
    CONSTRAINT pk_cost_basis PRIMARY KEY (cost_basis_id),
    CONSTRAINT fk_trade_id FOREIGN KEY (current_trade_id) references trade (trade_id)
);

COMMIT TRANSACTION;






