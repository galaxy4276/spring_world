use spring_world;

CREATE TABLE IF NOT EXISTS users (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(12) NOT NULL UNIQUE,
	password VARCHAR(64) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(5) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_roles (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	role_id INT(11) UNSIGNED NOT NULL,
	user_id INT(11) UNSIGNED NOT NULL,
	FOREIGN KEY (role_id) REFERENCES roles (id),
	FOREIGN KEY (user_id) REFERENCES users (id),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS forgot_password_service (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	one_time_pw VARCHAR(36) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	user_id INT(11) UNSIGNED NOT NULL,
	CONSTRAINT fk_forgot_pw_log_user_id
		FOREIGN KEY (user_id) REFERENCES users (id),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS forgot_password_service_log (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	is_success_change BOOLEAN NOT NULL DEFAULT FALSE,
	user_id INT(11) UNSIGNED NOT NULL,
	CONSTRAINT fk_forgot_pw_svc_user_id
		FOREIGN KEY (user_id) REFERENCES users (id),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS boards (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	user_id INT(11) UNSIGNED NOT NULL,
	title VARCHAR(50) NOT NULL,
	content VARCHAR(500) NOT NULL,
	type ENUM('S', 'Q', 'CS') NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL,
	CONSTRAINT fk_boards_user_id
		FOREIGN KEY (user_id) REFERENCES users (id),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS likes (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	board_id INT(11) UNSIGNED NOT NULL,
	user_id INT(11) UNSIGNED NOT NULL,
	CONSTRAINT fk_likes_board_id
		FOREIGN KEY (board_id) REFERENCES boards (id),
	CONSTRAINT fk_likes_user_id
		FOREIGN KEY (user_id) REFERENCES users (id),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS answer_boards (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	board_id INT(11) UNSIGNED NOT NULL,
	user_id INT(11) UNSIGNED NOT NULL,
	content VARCHAR(500) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL,
	CONSTRAINT fk_answer_boards_board_id
		FOREIGN KEY (board_id) REFERENCES boards (id),
	CONSTRAINT fk_answer_boards_user_id
		FOREIGN KEY (user_id) REFERENCES users (id),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS comments (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	board_id INT(11) UNSIGNED NOT NULL,
	user_id INT(11) UNSIGNED NOT NULL,
	content VARCHAR(255) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL,
	CONSTRAINT fk_comment_board_id
		FOREIGN KEY (board_id) REFERENCES boards (id),
	CONSTRAINT fk_comment_user_id
		FOREIGN KEY (user_id) REFERENCES users (id),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS replies (
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	comment_id INT(11) UNSIGNED NOT NULL,
	board_id INT(11) UNSIGNED NOT NULL,
	user_id INT(11) UNSIGNED NOT NULL,
	content VARCHAR(255) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL,
	CONSTRAINT fk_reply_parent_comment_id
		FOREIGN KEY (comment_id) REFERENCES comments (id),
	CONSTRAINT fk_reply_board_id
		FOREIGN KEY (board_id) REFERENCES boards (id),
	CONSTRAINT fk_reply_user_id
		FOREIGN KEY (user_id) REFERENCES users (id),
	PRIMARY KEY (id)
);


