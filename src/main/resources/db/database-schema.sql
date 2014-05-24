-- weibo_info
DROP TABLE IF EXISTS `weibo_info`;
CREATE TABLE `weibo_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_id` varchar(30) DEFAULT NULL COMMENT '应用ID',
  `app_key` varchar(20) DEFAULT NULL COMMENT '应用KEY',
  `app_secret` varchar(50) DEFAULT NULL COMMENT '应用SECRET',
  `redirect_uri` varchar(100) DEFAULT NULL COMMENT '重定向URI',
  `app_uri` varchar(200) DEFAULT NULL COMMENT '应用实际URI',
  `app_name` varchar(20) DEFAULT NULL COMMENT '应用名称',
  `app_summary` varchar(30) DEFAULT NULL COMMENT '应用简介',
  `app_intro` varchar(2000) DEFAULT NULL COMMENT '应用介绍',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `creator` varchar(200) NOT NULL COMMENT '创建者',
  `modifier` varchar(200) NOT NULL COMMENT '修改者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `app_id_unique` (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='微博信息';

-- weibo_test
DROP TABLE IF EXISTS `weibo_test`;
CREATE TABLE `weibo_test` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_id` varchar(30) DEFAULT NULL COMMENT '应用ID',
  `nickname` varchar(60) DEFAULT NULL COMMENT '昵称',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `creator` varchar(200) NOT NULL COMMENT '创建者',
  `modifier` varchar(200) NOT NULL COMMENT '修改者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `app_id_nickname_unique` (`app_id`,`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='微博测试信息';
