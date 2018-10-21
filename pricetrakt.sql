drop table if exists price_history;
drop table if exists shop_entries;
drop table if exists shops;
drop table if exists products;

create table products
(
  id   int auto_increment primary key,
  name varchar(50) not null
);

create table shops
(
  id   int auto_increment primary key,
  name varchar(50) not null
);

create table shop_entries
(
  id         int auto_increment primary key,
  product_id int          not null,
  shop_id    int          not null,
  url        varchar(256) not null,
  constraint shop_entries_products_fk
  foreign key (product_id) references products (id),
  constraint shop_entries_shops_fk
  foreign key (shop_id) references shops (id)
);

create table price_history
(
  id int auto_increment primary key,
  shop_entry_id int not null,
  price double not null,
  currency varchar(50) not null,
  capture_time timestamp not null default current_timestamp,
  constraint price_history_shop_entry_fk
  foreign key (shop_entry_id) references shop_entries (id)
);