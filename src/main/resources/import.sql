    insert into kitchen (id, name) values (1, 'Thai')
    insert into kitchen (id, name) values (2, 'Indian')


    insert into restaurant (id, name, freight_rate, kitchen_id) values (1, 'Thai Gourmet', 10, 1)
    insert into restaurant (id, name, freight_rate, kitchen_id) values (2, 'Thai Delivery', 9.50, 1)
    insert into restaurant (id, name, freight_rate, kitchen_id) values (3, 'Tuk Tuk Indian Food', 15, 2)

    insert into state (id, name) values (1,'Minas Gerais');
    insert into state (id, name) values (2, 'Rio de Janeiro');
    insert into state (id, name) values (3, 'Espirito Santo');

    insert into city (id, name, state_id) values (1, 'Uberlândia', 1)
    insert into city (id, name, state_id) values (2, 'Belo Horizonte', 1)
    insert into city (id, name, state_id) values (3, 'Cabo Frio', 2)
    insert into city (id, name, state_id) values (4, 'Rio de Janeiro', 2)
    insert into city (id, name, state_id) values (5, 'Vitória', 3)

    insert into payment_method (id, description) values (1, 'Credit card')
    insert into payment_method (id, description) values (2, 'Debit card')
    insert into payment_method (id, description) values (3, 'Cash')

    insert into permission (id, name, description) values (1, 'SEARCH_KITCHENS', 'Allow to search for kitchens')
    insert into permission (id, name, description) values (2, 'EDIT_KITCHENS', 'Allow to edit kitchens')