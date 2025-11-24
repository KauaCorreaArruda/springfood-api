    insert into kitchen (name) values ('Thai');
    insert into kitchen (name) values ('Indian');


    insert into restaurant (name, freight_rate, kitchen_id) values ('Thai Gourmet', 10, 1);
    insert into restaurant (name, freight_rate, kitchen_id) values ('Thai Delivery', 9.50, 1);
    insert into restaurant (name, freight_rate, kitchen_id) values ('Tuk Tuk Indian Food', 15, 2);

    insert into state (name) values ('Minas Gerais');
    insert into state (name) values ('Rio de Janeiro');
    insert into state (name) values ('Espirito Santo');

    insert into city (name, state_id) values ('Uberlândia', 1);
    insert into city (name, state_id) values ('Belo Horizonte', 1);
    insert into city (name, state_id) values ('Cabo Frio', 2);
    insert into city (name, state_id) values ('Rio de Janeiro', 2);
    insert into city (name, state_id) values ('Vitória', 3);

    insert into payment_method (description) values ('Credit card');
    insert into payment_method (description) values ('Debit card');
    insert into payment_method (description) values ('Cash');

    insert into permission (name, description) values ('SEARCH_KITCHENS', 'Allow to search for kitchens');
    insert into permission (name, description) values ('EDIT_KITCHENS', 'Allow to edit kitchens');