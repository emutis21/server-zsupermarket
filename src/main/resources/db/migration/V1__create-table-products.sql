
create table products(

    id bigint not null auto_increment,
    product_name varchar(100) not null unique,
    product_description varchar(100) not null,
    stock_quantity int not null,
    category varchar(100) not null,
    bar_code varchar(100) not null unique,
    image_url varchar(100) not null,

    primary key(id)
);
