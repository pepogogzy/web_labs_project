create table album (id bigserial not null, genre varchar(255) not null, name varchar(255) not null, release_year varchar(255) not null, primary key (id));
create table artist (id bigserial not null, bio varchar(255) not null, first_name varchar(255) not null, last_name varchar(255) not null, primary key (id));
create table song (id bigserial not null, genre varchar(255) not null, release_year integer not null, title varchar(255) not null, track_id varchar(255) not null, album_id bigint, primary key (id));
alter table if exists song add constraint FKrcjmk41yqj3pl3iyii40niab0 foreign key (album_id) references album;
create table album (id bigint generated by default as identity, genre varchar(255) not null, name varchar(255) not null, release_year varchar(255) not null, primary key (id));
create table artist (id bigint generated by default as identity, bio varchar(255) not null, first_name varchar(255) not null, last_name varchar(255) not null, primary key (id));
create table song (id bigint generated by default as identity, genre varchar(255) not null, release_year integer not null, title varchar(255) not null, track_id varchar(255) not null, album_id bigint, primary key (id));
alter table if exists song add constraint FKrcjmk41yqj3pl3iyii40niab0 foreign key (album_id) references album;
create table album (id bigint generated by default as identity, genre varchar(255) not null, name varchar(255) not null, release_year varchar(255) not null, primary key (id));
create table artist (id bigint generated by default as identity, bio varchar(255) not null, first_name varchar(255) not null, last_name varchar(255) not null, primary key (id));
create table song (id bigint generated by default as identity, genre varchar(255) not null, release_year integer not null, title varchar(255) not null, track_id varchar(255) not null, album_id bigint, primary key (id));
alter table if exists song add constraint FKrcjmk41yqj3pl3iyii40niab0 foreign key (album_id) references album;
create table album (id bigint generated by default as identity, genre varchar(255) not null, name varchar(255) not null, release_year varchar(255) not null, primary key (id));
create table artist (id bigint generated by default as identity, bio varchar(255) not null, first_name varchar(255) not null, last_name varchar(255) not null, primary key (id));
create table song (id bigint generated by default as identity, genre varchar(255) not null, release_year integer not null, title varchar(255) not null, track_id varchar(255) not null, album_id bigint, primary key (id));
alter table if exists song add constraint FKrcjmk41yqj3pl3iyii40niab0 foreign key (album_id) references album;
