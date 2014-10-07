-- User
INSERT INTO users(username,password,enabled) VALUES ('cuizuoli','9be905a930b921785b0f4cb2c89525075784733c','1');
INSERT INTO users(username,password,enabled) VALUES ('cuiyong','853248bca9d52509dcb029e916d6f3a549558e51','1');
INSERT INTO users(username,password,enabled) VALUES ('appranking','e36caa269e897e90ed3c3737f2a1a7ea56d02b71','1');
-- GROUP
INSERT INTO groups(id,group_name) VALUES (1,'GROUP_ADMIN');
INSERT INTO groups(id,group_name) VALUES (2,'GROUP_GOTOUR');
INSERT INTO groups(id,group_name) VALUES (3,'GROUP_GOTOUR_ADMIN');
INSERT INTO groups(id,group_name) VALUES (4,'GROUP_WEIBO');
INSERT INTO groups(id,group_name) VALUES (5,'GROUP_WEIBO_ADMIN');

INSERT INTO group_authorities(group_id,authority) VALUES (1,'ROLE_GOTOUR');
INSERT INTO group_authorities(group_id,authority) VALUES (1,'ROLE_GOTOUR_ADMIN');
INSERT INTO group_authorities(group_id,authority) VALUES (1,'ROLE_WEIBO');
INSERT INTO group_authorities(group_id,authority) VALUES (1,'ROLE_WEIBO_ADMIN');
INSERT INTO group_authorities(group_id,authority) VALUES (2,'ROLE_GOTOUR');
INSERT INTO group_authorities(group_id,authority) VALUES (3,'ROLE_GOTOUR');
INSERT INTO group_authorities(group_id,authority) VALUES (3,'ROLE_GOTOUR_ADMIN');
INSERT INTO group_authorities(group_id,authority) VALUES (4,'ROLE_WEIBO');
INSERT INTO group_authorities(group_id,authority) VALUES (5,'ROLE_WEIBO');
INSERT INTO group_authorities(group_id,authority) VALUES (5,'ROLE_WEIBO_ADMIN');
INSERT INTO group_members(username,group_id) VALUES ('cuizuoli',1);
INSERT INTO group_members(username,group_id) VALUES ('cuiyong',3);
INSERT INTO group_members(username,group_id) VALUES ('appranking',4);
