CREATE TABLE IF NOT EXISTS user
(
    `id` int not null AUTO_INCREMENT,
    `name` varchar(255) not null,
    `balance` float8,
    `telephone` varchar(20) unique not null,
    primary key(`id`)
);