
/* DB作成 */
DROP DATABASE IF EXISTS diary_db;
CREATE DATABASE diary_db;

/* ユーザを作成 */
CREATE USER IF NOT EXISTS diaryU IDENTIFIED BY 'diaryP';

/* 権限付与 */
GRANT ALL PRIVILEGES ON diary_db.* TO diaryU;

/* データベースを指定 */
USE diary_db;

/* テーブルの作成 */
create table diary (
id INT(8) AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
content VARCHAR(400) NOT NULL,
    created_at datetime default current_timestamp,
PRIMARY KEY (id)
);

/* テーブルINSERT */

insert into diary (title, content) values ('java', 'むずい');
insert into diary (title, content) values ('javascript', 'Node.jsむずい、ReactとNext.jsが気になる');

