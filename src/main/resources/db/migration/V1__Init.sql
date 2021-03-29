create table if not exists Todo (
  Id serial primary key,
  Name varchar(30) not null,
  Completed boolean not null default '0'
);