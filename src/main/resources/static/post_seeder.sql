use springblog_db;

drop table posts;

CREATE TABLE posts (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       title VARCHAR(100) NOT NULL,
                       body VARCHAR(255),
                       user_id INT UNSIGNED NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (user_id) REFERENCES users(id)
);

set foreign_key_checks = 0;

insert into posts (user_id, title, body) values (1, 'Rank', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.');
insert into posts (user_id, title, body) values (1, 'Ventosanzap', 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.');
insert into posts (user_id, title, body) values (1, 'Bytecard', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.');
insert into posts (user_id, title, body) values (1, 'Tres-Zap', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.');
insert into posts (user_id, title, body) values (1, 'Kanlam', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.');
insert into posts (user_id, title, body) values (2, 'Alpha', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.');
insert into posts (user_id, title, body) values (2, 'Y-Solowarm', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.');
insert into posts (user_id, title, body) values (2, 'Job', 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.');
insert into posts (user_id, title, body) values (2, 'Temp', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.');
insert into posts (user_id, title, body) values (2, 'Pannier', 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.');
insert into posts (user_id, title, body) values (1, 'Duobam', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.');
insert into posts (user_id, title, body) values (1, 'Voyatouch', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.');
insert into posts (user_id, title, body) values (1, 'Cardify', 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.');
insert into posts (user_id, title, body) values (1, 'Flowdesk', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.');
insert into posts (user_id, title, body) values (1, 'Prodder', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.');
insert into posts (user_id, title, body) values (2, 'Flexidy', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.');
insert into posts (user_id, title, body) values (2, 'Sub-Ex', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.');
insert into posts (user_id, title, body) values (2, 'Prodder', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.');
insert into posts (user_id, title, body) values (2, 'Rank', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.');
insert into posts (user_id, title, body) values (2, 'Zoolab', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.');
