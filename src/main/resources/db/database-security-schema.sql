-- Drop Schema
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `group_authorities`;
DROP TABLE IF EXISTS `group_members`;
DROP TABLE IF EXISTS `groups`;
DROP TABLE IF EXISTS `persistent_logins`;

-- User Schema
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` char(1) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users`(`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Group Authorities
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL auto_increment,
  `group_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `group_authorities` (
  `group_id` bigint(20) NOT NULL,
  `authority` varchar(50) NOT NULL,
  CONSTRAINT `fk_group_authorities_group` FOREIGN KEY (`group_id`) REFERENCES `groups`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `group_members` (
  `id` bigint(20) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  CONSTRAINT `fk_group_members_group` FOREIGN KEY (`group_id`) REFERENCES `groups`(`id`),
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Persistent Login (Remember-Me) Schema
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64),
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY  (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
