
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
create table category (
    category_id int auto_increment primary key,
    category_name varchar(20) not null
);

create table diary (
    id INT(8) AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    content VARCHAR(400) NOT NULL,
    created_at datetime default current_timestamp,
    updated_at datetime default current_timestamp on update current_timestamp,
    category_id int not null,
    PRIMARY KEY (id),
    foreign key (category_id) references category(category_id)
);

/* テーブルINSERT */

insert into category (category_name) values ('programming');
insert into diary (title, content, category_id) values ('java', 'むずい', 1);
insert into diary (title, content, category_id) values ('javascript', 'Node.jsむずい、ReactとNext.jsが気になる', 1);

