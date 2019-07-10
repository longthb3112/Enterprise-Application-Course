
INSERT INTO Book VALUES(1,'123', 'Long 1', 1000,'Book 1');
INSERT INTO Book VALUES(2,'124', 'Long 2', 1200,'Book 2');
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_USER', 2);
INSERT INTO `user` (`id`, `username`, `password`, `dateCreated`) VALUES (1,'admin','$2a$10$3VKl6oHUxxdOjmWRQLRvheREu19a7wZCZzlyGlYAdiogyGQngTMXa','2019-01-15 22:14:54');
INSERT INTO `user` (`id`, `username`, `password`, `dateCreated`) VALUES (2,'user','$2a$10$BrrlWL0gvcxfnwxijLtfCe.4L2Ak/RuuFRL0QYBpecNZicX2WNNXO','2019-05-15 22:14:54');
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 2);