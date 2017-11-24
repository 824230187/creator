CREATE TABLE `key_word` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key_word` varchar(100) NOT NULL COMMENT '敏感词',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_key_word` (`key_word`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
