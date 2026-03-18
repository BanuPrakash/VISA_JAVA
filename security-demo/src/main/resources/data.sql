insert into users (username, password, enabled) values ('rita', '$2a$12$JnsilxLFJ5w40qgCTx0usOXO97koYct.jbji2otAV7UBZZRyxzfyC', 1);
insert into users (username, password, enabled) values ('kim', '$2a$12$dFz4JcGXU415CsgI7GP.2OWi/qV4QPN16wBj2rpwH5dQ12YNoF6A6', 1);

insert into authorities (username, authority) values ('rita', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('rita', 'ROLE_USER');

insert into authorities (username, authority) values ('kim', 'ROLE_USER');
