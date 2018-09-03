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

insert into products (id, name) values (1, "LG V30");
insert into products (id, name) values (2, "Nokia 7 Plus");
insert into products (id, name) values (3, "Huawei Mate 10 Pro");
insert into products (id, name) values (4, "Xiaomi Pocophone F1");

insert into shops (id, name) values (1, "eMag");
insert into shops (id, name) values (2, "PC Garage");

insert into shop_entries(id, product_id, shop_id, url) VALUES (1, 1, 1, "https://www.emag.ro/telefon-mobil-lg-v30-64gb-4g-cloud-silver-lg-v30-silver/pd/DMC2VHBBM/");
insert into shop_entries(id, product_id, shop_id, url) VALUES (2, 1, 2, "https://www.pcgarage.ro/smartphone/lg/v30-ecran-quad-hd-plus-gorilla-glass-5-snapdragon-835-245-ghz-octa-core-64gb-4gb-ram-single-sim-4g-tri-camera-16-plus-13-mpx-plus-5-mpx-quick-charge-30-cloud-silver/");

insert into shop_entries(id, product_id, shop_id, url) VALUES (3, 2, 1, "https://www.emag.ro/telefon-mobil-nokia-7-plus-dual-sim-64gb-4g-black-copper-11b2nb01a05/pd/DHTFPFBBM/?path=telefon-mobil-nokia-7-plus-dual-sim-64gb-4g-black-copper-11b2nb01a05/pd/DHTFPFBBM");
insert into shop_entries(id, product_id, shop_id, url) VALUES (4, 2, 2, "https://www.pcgarage.ro/smartphone/nokia/7-plus-android-one-ecran-full-hd-snapdragon-22-ghz-octa-core-64gb-4gb-ram-dual-sim-4g-nfc-tri-camera-16-mpx-plus-12-mpx-plus-12-mpx-fast-charge-black-copper/");

insert into shop_entries(id, product_id, shop_id, url) VALUES (5, 3, 1, "https://www.emag.ro/telefon-mobil-huawei-mate-10-pro-dual-sim-128gb-4g-titanium-grey-mate-10-pro-ds-grey/pd/DG1R30BBM/#Titanium%20Grey");
insert into shop_entries(id, product_id, shop_id, url) VALUES (6, 3, 2, "https://www.emag.ro/telefon-mobil-huawei-mate-10-pro-dual-sim-128gb-4g-titanium-grey-mate-10-pro-ds-grey/pd/DG1R30BBM/#Titanium%20Grey");

insert into shop_entries(id, product_id, shop_id, url) VALUES (7, 4, 1, "https://www.emag.ro/telefon-mobil-pocophone-f1-dual-sim-64-gb-4g-black-19879f1/pd/D9V12VBBM/");
insert into shop_entries(id, product_id, shop_id, url) VALUES (8, 4, 2, "https://www.pcgarage.ro/smartphone/xiaomi/pocophone-f1-snapdragon-845-28ghz-octa-core-64gb-6gb-ram-dual-sim-4g-tri-camera-20-mpx-plus-15-mpx-plus-5-mpx-quick-charge-30-baterie-4000-mah-liquid-cooling-system-graphite-black/");

insert into price_history(id, shop_entry_id, price, currency) values (1, 7, 1799.99, "Lei");