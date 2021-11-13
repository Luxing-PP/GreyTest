drop database if  exists db6;
create database db6;


use db6;
CREATE TABLE if not exists `rules`(
    `id`          int unsigned NOT NULL AUTO_INCREMENT,
    `aid` int,
    `platform` varchar(255),
    `download_url` varchar(255) not null,
    `update_version_code` varchar(255) not null,
    `md5` varchar(255),
#     `device_id_list` varchar(255) not null,
    `min_version` varchar(255),
    `max_version` varchar(255),
    `max_os_api` int,
    `min_os_api` int,
    `cpu_arch` int,
    `channel` varchar(255),
    `title` varchar(255),
    `update_tips` varchar(255),
    `usable` boolean default true,
    PRIMARY KEY (`id`)
)AUTO_INCREMENT=5;
# 同一个APP 测试渠道和CPU架构
INSERT INTO `rules` VALUES (0,1,'IOS','apk1.0.url','感觉没用啊','md5','8.1.3','8.1.4','4','1','32','渠道A','Title','TIPS',true);
INSERT INTO `rules` VALUES (1,1,'IOS','apk1.0.url','感觉没用啊','md5','8.1.3','8.4.2','4','1','64','渠道A','渠道A的64通用解','TIPS',true);
INSERT INTO `rules` VALUES (2,1,'IOS','apk1.0.url','感觉没用啊','md5','8.1.3','8.4.2','4','1','32','渠道A','渠道A的32通用解','TIPS',true);
INSERT INTO `rules` VALUES (3,1,'IOS','apk1.0.url','感觉没用啊','md5','8.1.3','8.4.2','4','1','64','渠道B','渠道B的64通用解','TIPS',true);
INSERT INTO `rules` VALUES (4,1,'IOS','apk1.0.url','感觉没用啊','md5','8.1.3','8.4.2','4','1','32','渠道B','渠道B的32通用解','TIPS',true);

CREATE table IF NOT EXISTS `device_id_list`(
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `device_id` varchar(255) not null ,
    `hit_times` int  default 0,
    PRIMARY KEY (`id`)
);

INSERT INTO `device_id_list` (device_id) VALUES ('BBBB-1234');

# ALTER TABLE device_id_list ADD INDEX index_name(device_id(5));
# CREATE table if not exists `rule_condition`(
#     `id` int unsigned NOT NULL AUTO_INCREMENT,
#     `hit_times` int default 0,
#     `install_times` int default 0,
#     `usable` boolean default true,
#     PRIMARY KEY (`id`)
# )AUTO_INCREMENT=5;
# insert into `rule_condition` values (0,0,0,true);
# insert into `rule_condition` values (1,0,0,true);
# insert into `rule_condition` values (2,0,0,true);
# insert into `rule_condition` values (3,0,0,true);
# insert into `rule_condition` values (4,0,0,true);



