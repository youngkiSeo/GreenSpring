-- 사용자
-- pk 값: iuser
-- user id 
-- upw
-- nm
-- gender
-- addr
-- main_pic
-- created_at
-- updated_at
DROP TABLE t_user;
DROP TABLE t_board;
DROP TABLE t_board_cmt;
CREATE TABLE t_user(
	iuser BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	uid VARCHAR(20) NOT NULL UNIQUE,
	upw VARCHAR(100) NOT NULL,
	nm VARCHAR(30) NOT NULL,
	gender CHAR(1) NOT NULL CHECK(gender IN('M','F')),
	addr VARCHAR(100) NOT NULL,
	main_pic VARCHAR(100),
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE t_board(
	iboard BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	ctnt TEXT NOT NULL,
	iuser BIGINT UNSIGNED COMMENT '작성자',
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY(iuser) REFERENCES t_user(iuser)
);
-- 게시판 
-- pk 제목, 내용, 작성자, 작성일시

-- 댓글
-- pk, iboard,작성자, 내용, 작성일시

CREATE TABLE t_board_cmt(
	iboard_cmt BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	iboard BIGINT UNSIGNED not null COMMENT '글번호',
	iuser BIGINT UNSIGNED not null COMMENT '작성자',
	ctnt VARCHAR(255) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY(iboard) REFERENCES t_board(iboard),
	FOREIGN KEY(iuser) REFERENCES t_user(iuser)
);

SELECT CEIl(COUNT(iboard)/50) FROM t_board;
SELECT COUNT(iboard)/50 FROM t_board;

SELECT * FROM t_user;
SELECT * FROM t_board
ORDER BY iboard desc;
SELECT * FROM t_board_cmt 
ORDER BY iboard_cmt DESC;

SELECT * FROM t_board_cmt
WHERE iboard = 1;

SELECT iboard,title, ctnt, iuser,updated_at
FROM t_board
LIMIT 1,30
;

