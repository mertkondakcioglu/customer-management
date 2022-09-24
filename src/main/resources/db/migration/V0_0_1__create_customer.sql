create table if not exists tbl_customer
(
    id
    bigint
    unsigned
    not
    null
    auto_increment,
    email
    varchar
(
    100
) not null,
    password varchar
(
    100
) not null,
    first_name varchar
(
    100
) not null,
    last_name varchar
(
    100
) not null,
    created_at timestamp null default current_timestamp,
    updated_at timestamp null default null on update current_timestamp,
    primary key
(
    id
),
    unique key uq_customer
(
    email
)
    ) engine = innodb;

