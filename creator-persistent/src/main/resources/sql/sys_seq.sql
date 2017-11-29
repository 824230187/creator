CREATE TABLE `sys_seq` (
      id int(11) NOT NULL AUTO_INCREMENT,
      name varchar(32) DEFAULT NULL COMMENT '序列名称',
      raw_add_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
      PRIMARY KEY (id)
   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `user_test` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sex` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;