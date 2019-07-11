--passoword for admin and user is 123

INSERT INTO Book VALUES(1,'978-0-306-40615-7', 'Long 1', 1000,'Book 1');
INSERT INTO Book VALUES(2,'978-3-16-148410-0', 'Long 2', 1200,'Book 2');
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_USER', 2);
INSERT INTO `user` (`id`, `created_Date`, `password`,`username`) VALUES (1,'2019-01-15 22:14:54','$2a$10$3VKl6oHUxxdOjmWRQLRvheREu19a7wZCZzlyGlYAdiogyGQngTMXa','admin');
INSERT INTO `user` (`id`, `created_Date`, `password`,`username`) VALUES (2,'2019-05-15 22:14:54','$2a$10$BrrlWL0gvcxfnwxijLtfCe.4L2Ak/RuuFRL0QYBpecNZicX2WNNXO','user');
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 2);