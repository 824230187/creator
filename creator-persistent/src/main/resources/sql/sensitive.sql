CREATE TABLE `key_word` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key_word` varchar(100) NOT NULL COMMENT '敏感词',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_key_word` (`key_word`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*通过经纬度计算距离*/
ROUND(6378.138*2*ASIN(SQRT(POW(SIN((#{order.latitude}*PI()/180-oi.latitude*PI()/180)/2),2)+COS(#{order.latitude}*PI()/180)*COS(oi.latitude*PI()/180)*POW(SIN((#{order.longitude}*PI()/180-oi.longitude*PI()/180)/2),2)))*1000) AS distance
/*根据距离筛选附近XXkm（range）*/
 <![CDATA[
    AND (oi.longitude < #{order.longitude} + #{order.range} and
    oi.longitude > #{order.longitude} - #{order.range}) and
    (oi.latitude < #{order.latitude} + #{order.range} and
    oi.latitude > #{order.latitude} - #{order.range})
]]>