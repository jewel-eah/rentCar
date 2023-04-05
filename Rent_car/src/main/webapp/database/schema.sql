create table customer (
cus_code int primary key,
cus_name varchar(20) not null unique,
contact varchar(13) not null,
email varchar(20),
id varchar(20) not null,
`password` varchar(20) not null,
age int not null,
joindate TIMESTAMP not null
);


