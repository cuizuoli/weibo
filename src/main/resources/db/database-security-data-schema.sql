-- User
INSERT INTO users(username,password,enabled) VALUES ('cuizuoli','9be905a930b921785b0f4cb2c89525075784733c','1');
INSERT INTO users(username,password,enabled) VALUES ('appranking','e36caa269e897e90ed3c3737f2a1a7ea56d02b71','1');
-- GROUP
INSERT INTO groups(id,group_name) VALUES (1,'GROUP_ADMIN');
INSERT INTO groups(id,group_name) VALUES (2,'GROUP_WEIBO');
INSERT INTO group_authorities(group_id,authority) VALUES (1,'ROLE_ADMIN');
INSERT INTO group_authorities(group_id,authority) VALUES (1,'ROLE_WEIBO');
INSERT INTO group_authorities(group_id,authority) VALUES (2,'ROLE_WEIBO');
INSERT INTO group_members(username,group_id) VALUES ('cuizuoli',1);
INSERT INTO group_members(username,group_id) VALUES ('appranking',2);
