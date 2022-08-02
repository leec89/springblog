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
insert into posts (user_id, title, body) values (3, 'Duobam', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.');
insert into posts (user_id, title, body) values (3, 'Voyatouch', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.');
insert into posts (user_id, title, body) values (3, 'Cardify', 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.');
insert into posts (user_id, title, body) values (3, 'Flowdesk', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.');
insert into posts (user_id, title, body) values (3, 'Prodder', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.');
insert into posts (user_id, title, body) values (4, 'Flexidy', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.');
insert into posts (user_id, title, body) values (4, 'Sub-Ex', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.');
insert into posts (user_id, title, body) values (4, 'Prodder', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.');
insert into posts (user_id, title, body) values (4, 'Rank', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.');
insert into posts (user_id, title, body) values (4, 'Zoolab', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.');
insert into posts (user_id, title, body) values (5, 'Ronstring', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.');
insert into posts (user_id, title, body) values (5, 'Cookley', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.');
insert into posts (user_id, title, body) values (5, 'Cardguard', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.');
insert into posts (user_id, title, body) values (5, 'Matsoft', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.');
insert into posts (user_id, title, body) values (5, 'Rank', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.');
insert into posts (user_id, title, body) values (6, 'Cookley', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.');
insert into posts (user_id, title, body) values (6, 'Ventosanzap', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.');
insert into posts (user_id, title, body) values (6, 'Pannier', 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.');
insert into posts (user_id, title, body) values (6, 'Treeflex', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices sit amet lobortis sapien sapien non mi. Integer ac neque.');
insert into posts (user_id, title, body) values (6, 'Subin', 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.');
insert into posts (user_id, title, body) values (7, 'Stim', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.');
insert into posts (user_id, title, body) values (7, 'Bigtax', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.');
insert into posts (user_id, title, body) values (7, 'Subin', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.');
insert into posts (user_id, title, body) values (7, 'Tin', 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.');
insert into posts (user_id, title, body) values (7, 'Zaam-Dox', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.');
insert into posts (user_id, title, body) values (8, 'Tempsoft', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.');
insert into posts (user_id, title, body) values (8, 'Sonsing', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.');
insert into posts (user_id, title, body) values (8, 'Opela', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.');
insert into posts (user_id, title, body) values (8, 'Veribet', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.');
insert into posts (user_id, title, body) values (8, 'Zamit', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.');
insert into posts (user_id, title, body) values (9, 'Tresom', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.');
insert into posts (user_id, title, body) values (9, 'Zontrax', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.');
insert into posts (user_id, title, body) values (9, 'Flexidy', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.');
insert into posts (user_id, title, body) values (9, 'Solarbreeze', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.');
insert into posts (user_id, title, body) values (9, 'Zamit', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.');
insert into posts (user_id, title, body) values (10, 'Daltfresh', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.');
insert into posts (user_id, title, body) values (10, 'Subin', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.');
insert into posts (user_id, title, body) values (10, 'Sonsing', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.');
insert into posts (user_id, title, body) values (10, 'Temp', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.');
insert into posts (user_id, title, body) values (10, 'Daltfresh', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.');
