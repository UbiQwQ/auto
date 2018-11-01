/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : auto

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-29 16:21:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for access
-- ----------------------------
DROP TABLE IF EXISTS `access`;
CREATE TABLE `access` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '权限名称',
  `urls` varchar(1000) NOT NULL COMMENT 'json数组',
  `status` int(1) NOT NULL COMMENT '状态',
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for app_access_log
-- ----------------------------
DROP TABLE IF EXISTS `app_access_log`;
CREATE TABLE `app_access_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `target_url` varchar(255) NOT NULL COMMENT '访问的url',
  `query_params` longtext NOT NULL COMMENT 'get和post参数 ',
  `ua` varchar(255) NOT NULL COMMENT '访问的ua',
  `ip` varchar(32) NOT NULL COMMENT '访问ip',
  `note` varchar(1000) NOT NULL COMMENT 'json格式备注字段',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户访问记录表';

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL COMMENT '文章编号',
  `user_id` int(11) NOT NULL COMMENT '作者id',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `text_body` longtext NOT NULL COMMENT '文章正文',
  `agree_num` varchar(50) NOT NULL COMMENT '点赞数',
  `disagree_num` varchar(50) NOT NULL COMMENT '反对数',
  `clicks` varchar(50) NOT NULL COMMENT '点击量',
  `custom_tags` varchar(255) NOT NULL COMMENT '自定义标签',
  `classification_id` int(11) NOT NULL COMMENT '分类',
  `image` varchar(255) NOT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章信息表';

-- ----------------------------
-- Table structure for classification
-- ----------------------------
DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification` (
  `id` int(11) NOT NULL,
  `classification_name` varchar(50) NOT NULL COMMENT '分类 名称',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表 文章-用户';

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `content` varchar(255) NOT NULL COMMENT '评论内容',
  `agree_num` varchar(50) NOT NULL COMMENT '赞同数',
  `disagree_num` varchar(50) NOT NULL COMMENT '反对数',
  `reference_id` int(11) NOT NULL COMMENT '被该评论引用的id',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Table structure for manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE `manufacturer` (
  `id` int(11) NOT NULL,
  `manufacturer_name` varchar(255) NOT NULL COMMENT '厂商名称',
  `description` text NOT NULL COMMENT '厂商介绍',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='厂商表';

-- ----------------------------
-- Table structure for motor_info
-- ----------------------------
DROP TABLE IF EXISTS `motor_info`;
CREATE TABLE `motor_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `model` varchar(50) NOT NULL COMMENT '型号',
  `manufacturer_id` int(11) NOT NULL COMMENT '厂商id',
  `made_country` varchar(100) NOT NULL COMMENT '制造国',
  `market_time` datetime NOT NULL COMMENT '上市时间',
  `retail_price` decimal(10,0) NOT NULL COMMENT '零售价',
  `displacement` varchar(20) NOT NULL COMMENT '排量',
  `cylinders_num` varchar(5) NOT NULL COMMENT '缸数',
  `stroke` varchar(5) NOT NULL COMMENT '冲程',
  `per_cylinder_valve` varchar(5) NOT NULL COMMENT '每缸气门',
  `maximum_power` varchar(10) NOT NULL COMMENT '最大功率',
  `maximum_torque` varchar(10) NOT NULL COMMENT '最大扭矩',
  `fuel_consumption` varchar(10) NOT NULL COMMENT '油耗',
  `gear` varchar(10) NOT NULL COMMENT '挡位',
  `tank_capacity` varchar(10) NOT NULL COMMENT '邮箱容积',
  `weight` varchar(10) NOT NULL COMMENT '整车重量',
  `
maximum_speed` varchar(10) NOT NULL COMMENT '最高车速',
  `brake_system` varchar(15) NOT NULL COMMENT '制动系统',
  `instrument` varchar(15) NOT NULL COMMENT '仪表形式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='摩托信息表';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `status` int(1) NOT NULL COMMENT '状态',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for role_access
-- ----------------------------
DROP TABLE IF EXISTS `role_access`;
CREATE TABLE `role_access` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `access_id` int(11) NOT NULL COMMENT '权限id',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `password` varchar(20) NOT NULL COMMENT '密码+随机字符串的MD5码',
  `random_string` varchar(10) NOT NULL COMMENT '随机字符串',
  `gander` varchar(5) NOT NULL COMMENT '性别',
  `phone` varchar(13) NOT NULL COMMENT '电话',
  `email` varchar(25) NOT NULL COMMENT '邮箱',
  `personal_profile` varchar(100) NOT NULL COMMENT '个人介绍',
  `location` varchar(100) NOT NULL COMMENT '所在地',
  `experience` varchar(50) NOT NULL COMMENT '经验值',
  `head` varchar(100) NOT NULL COMMENT '头像',
  `is_admin` int(1) NOT NULL COMMENT '是否是管理员',
  `status` int(1) NOT NULL COMMENT '状态',
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for user_concern
-- ----------------------------
DROP TABLE IF EXISTS `user_concern`;
CREATE TABLE `user_concern` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `concern_id` int(11) NOT NULL COMMENT '被关注的人的id',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注表 用户-用户';

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
