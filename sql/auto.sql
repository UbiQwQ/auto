/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : auto

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 10/01/2019 10:06:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_access_log
-- ----------------------------
DROP TABLE IF EXISTS `app_access_log`;
CREATE TABLE `app_access_log`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `target_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '访问的url',
  `query_params` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'get和post参数 ',
  `ua` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '访问的ua',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '访问ip',
  `note` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'json格式备注字段',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户访问记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `user_id` int(11) NOT NULL COMMENT '作者id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `text_body` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章正文',
  `agree_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '点赞数',
  `disagree_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反对数',
  `clicks` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '点击量',
  `custom_tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自定义标签',
  `classification_id` int(11) NULL DEFAULT NULL COMMENT '分类',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 1, '铃木GSX-250R升级款的300cc跑车CG图曝光', '2019-01-04 22:37:19', '由豪爵生产的铃木GSX-250R作为铃木旗下的250cc入门级跑车在国内是日系四大厂250cc级别最具性价比的一台小跑车，因为国产的强大优势，它的售价也比当时大陆内的竞品Ninja250要低不少，关键是，版花骚啊~', '100', '6', '16756', NULL, NULL, '/static/img/j1.7922510.jpg');
INSERT INTO `article` VALUES (2, 1, '游戏平台 LuckyMe、GameBet 遭攻击，黑客团伙共获利3132.65 EOS', '2019-01-06 18:26:47', '同一拨人，使用的是升级版的攻击技术。', '65', '5', '672', NULL, NULL, '/static/img/j2.9a0a332.jpg');
INSERT INTO `article` VALUES (3, 1, '测试Nginx图片服务器', '2019-01-05 22:42:58', '测试Nginx图片服务器啊啊啊', '45', '6', '56765', NULL, NULL, 'http://localhost:8000/atomBG.jpg');
INSERT INTO `article` VALUES (30, 29, '1', '2019-01-10 10:01:35', '1', '0', '0', '0', NULL, NULL, 'http://localhost:8000/935b74bc-4544-4341-a3c1-d18422d83e05.jpg');
INSERT INTO `article` VALUES (31, 29, '1', '2019-01-10 10:01:48', '1', '0', '0', '0', NULL, NULL, 'http://localhost:8000/52c714b5-efba-40f8-8e22-78a3936ef54f.jpg');
INSERT INTO `article` VALUES (32, 29, '22', '2019-01-10 10:01:54', '2', '0', '0', '0', NULL, NULL, 'http://localhost:8000/59d7a724-62c1-4cc2-bf4a-f3f66ea9528b.jpg');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL,
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类 名称',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏表 文章-用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (3, 3, 1, '2019-01-07 13:45:16');
INSERT INTO `collection` VALUES (8, 1, 1, '2019-01-09 20:20:40');
INSERT INTO `collection` VALUES (10, 3, 32, '2019-01-09 21:19:11');
INSERT INTO `collection` VALUES (12, 3, 29, '2019-01-10 10:03:35');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `agree_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '赞同数',
  `disagree_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反对数',
  `reference_id` int(11) NULL DEFAULT NULL COMMENT '被该评论引用的id',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 1, '贼溜', '0', '0', 0, '2019-01-06 21:19:30');
INSERT INTO `comment` VALUES (2, 1, 1, '666', '0', '0', 0, '2019-01-06 22:34:17');
INSERT INTO `comment` VALUES (3, 1, 1, '贼溜', '0', '0', 0, '2019-01-06 22:34:10');
INSERT INTO `comment` VALUES (5, 1, 1, '李香兰', '0', '0', 0, '2019-01-06 22:35:44');
INSERT INTO `comment` VALUES (24, 1, 1, '那是真的牛皮', NULL, NULL, NULL, '2019-01-09 22:39:36');
INSERT INTO `comment` VALUES (25, 30, 1, 'ssss', NULL, NULL, NULL, '2019-01-10 09:14:58');
INSERT INTO `comment` VALUES (26, 30, 2, '...', NULL, NULL, NULL, '2019-01-10 09:18:22');
INSERT INTO `comment` VALUES (27, 29, 1, '1', NULL, NULL, NULL, '2019-01-10 10:02:18');
INSERT INTO `comment` VALUES (28, 29, 3, '1', NULL, NULL, NULL, '2019-01-10 10:03:27');

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'countryId',
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国家名',
  `ccode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'countryCode',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 210 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, '美国', '1');
INSERT INTO `country` VALUES (2, '俄罗斯', '7');
INSERT INTO `country` VALUES (3, '中国', '20');
INSERT INTO `country` VALUES (4, '南非', '27');
INSERT INTO `country` VALUES (5, '希腊', '30');
INSERT INTO `country` VALUES (6, '荷兰', '31');
INSERT INTO `country` VALUES (7, '比利时', '32');
INSERT INTO `country` VALUES (8, '法国', '33');
INSERT INTO `country` VALUES (9, '西班牙', '34');
INSERT INTO `country` VALUES (10, '匈牙利', '36');
INSERT INTO `country` VALUES (11, '意大利', '39');
INSERT INTO `country` VALUES (12, '罗马尼亚', '40');
INSERT INTO `country` VALUES (13, '瑞士', '41');
INSERT INTO `country` VALUES (14, '奥地利', '43');
INSERT INTO `country` VALUES (15, '根西，马恩，泽西，英国', '44');
INSERT INTO `country` VALUES (16, '丹麦', '45');
INSERT INTO `country` VALUES (17, '瑞典', '46');
INSERT INTO `country` VALUES (18, '挪威', '47');
INSERT INTO `country` VALUES (19, '波兰', '48');
INSERT INTO `country` VALUES (20, '德国', '49');
INSERT INTO `country` VALUES (21, '秘鲁', '51');
INSERT INTO `country` VALUES (22, '墨西哥', '52');
INSERT INTO `country` VALUES (23, '古巴', '53');
INSERT INTO `country` VALUES (24, '阿根廷', '54');
INSERT INTO `country` VALUES (25, '巴西', '55');
INSERT INTO `country` VALUES (26, '智利', '56');
INSERT INTO `country` VALUES (27, '哥伦比亚', '57');
INSERT INTO `country` VALUES (28, '委内瑞拉', '58');
INSERT INTO `country` VALUES (29, '马来西亚', '60');
INSERT INTO `country` VALUES (30, '澳大利亚', '61');
INSERT INTO `country` VALUES (31, '印度尼西亚', '62');
INSERT INTO `country` VALUES (32, '菲律宾', '63');
INSERT INTO `country` VALUES (33, '新西兰', '64');
INSERT INTO `country` VALUES (34, '新加坡', '65');
INSERT INTO `country` VALUES (35, '泰国', '66');
INSERT INTO `country` VALUES (36, '日本', '81');
INSERT INTO `country` VALUES (37, '韩国', '82');
INSERT INTO `country` VALUES (38, '越南', '84');
INSERT INTO `country` VALUES (39, '土耳其', '90');
INSERT INTO `country` VALUES (40, '印度', '91');
INSERT INTO `country` VALUES (41, '巴基斯坦', '92');
INSERT INTO `country` VALUES (42, '阿富汗', '93');
INSERT INTO `country` VALUES (43, '斯里兰卡', '94');
INSERT INTO `country` VALUES (44, '缅甸', '95');
INSERT INTO `country` VALUES (45, '伊朗', '98');
INSERT INTO `country` VALUES (46, '南苏丹', '211');
INSERT INTO `country` VALUES (47, '摩洛哥', '212');
INSERT INTO `country` VALUES (48, '阿尔及利亚', '213');
INSERT INTO `country` VALUES (49, '突尼斯', '216');
INSERT INTO `country` VALUES (50, '利比亚', '218');
INSERT INTO `country` VALUES (51, '冈比亚', '220');
INSERT INTO `country` VALUES (52, '塞内加尔', '221');
INSERT INTO `country` VALUES (53, '毛里塔尼亚', '222');
INSERT INTO `country` VALUES (54, '马里', '223');
INSERT INTO `country` VALUES (55, '科特迪瓦', '225');
INSERT INTO `country` VALUES (56, '布基纳法索', '226');
INSERT INTO `country` VALUES (57, '尼日尔', '227');
INSERT INTO `country` VALUES (58, '多哥', '228');
INSERT INTO `country` VALUES (59, '贝宁', '229');
INSERT INTO `country` VALUES (60, '毛里求斯', '230');
INSERT INTO `country` VALUES (61, '利比里亚', '231');
INSERT INTO `country` VALUES (62, '塞拉利昂', '232');
INSERT INTO `country` VALUES (63, '加纳', '233');
INSERT INTO `country` VALUES (64, '尼日利亚', '234');
INSERT INTO `country` VALUES (65, '乍得', '235');
INSERT INTO `country` VALUES (66, '中非共和国', '236');
INSERT INTO `country` VALUES (67, '喀麦隆', '237');
INSERT INTO `country` VALUES (68, '佛得角', '238');
INSERT INTO `country` VALUES (69, '赤道几内亚', '240');
INSERT INTO `country` VALUES (70, '加蓬', '241');
INSERT INTO `country` VALUES (71, '刚果', '242');
INSERT INTO `country` VALUES (72, '刚果民主共和国', '243');
INSERT INTO `country` VALUES (73, '安哥拉', '244');
INSERT INTO `country` VALUES (74, '几内亚比绍共和国', '245');
INSERT INTO `country` VALUES (75, '塞舌尔', '248');
INSERT INTO `country` VALUES (76, '苏丹', '249');
INSERT INTO `country` VALUES (77, '卢旺达', '250');
INSERT INTO `country` VALUES (78, '埃塞俄比亚', '251');
INSERT INTO `country` VALUES (79, '索马里', '252');
INSERT INTO `country` VALUES (80, '吉布提', '253');
INSERT INTO `country` VALUES (81, '肯尼亚', '254');
INSERT INTO `country` VALUES (82, '坦桑尼亚', '255');
INSERT INTO `country` VALUES (83, '乌干达', '256');
INSERT INTO `country` VALUES (84, '布隆迪', '257');
INSERT INTO `country` VALUES (85, '莫桑比克', '258');
INSERT INTO `country` VALUES (86, '赞比亚', '260');
INSERT INTO `country` VALUES (87, '马达加斯加', '261');
INSERT INTO `country` VALUES (88, '留尼旺', '262');
INSERT INTO `country` VALUES (89, '津巴布韦', '263');
INSERT INTO `country` VALUES (90, '纳米比亚', '264');
INSERT INTO `country` VALUES (91, '马拉维', '265');
INSERT INTO `country` VALUES (92, '莱索托', '266');
INSERT INTO `country` VALUES (93, '博茨瓦纳', '267');
INSERT INTO `country` VALUES (94, '斯威士兰', '268');
INSERT INTO `country` VALUES (95, '科摩罗', '269');
INSERT INTO `country` VALUES (96, '厄立特里亚', '291');
INSERT INTO `country` VALUES (97, '阿鲁巴', '297');
INSERT INTO `country` VALUES (98, '法罗群岛', '298');
INSERT INTO `country` VALUES (99, '格陵兰岛', '299');
INSERT INTO `country` VALUES (100, '直布罗陀', '350');
INSERT INTO `country` VALUES (101, '葡萄牙', '351');
INSERT INTO `country` VALUES (102, '卢森堡', '352');
INSERT INTO `country` VALUES (103, '爱尔兰', '353');
INSERT INTO `country` VALUES (104, '冰岛', '354');
INSERT INTO `country` VALUES (105, '阿尔巴尼亚', '355');
INSERT INTO `country` VALUES (106, '马耳他', '356');
INSERT INTO `country` VALUES (107, '塞浦路斯', '357');
INSERT INTO `country` VALUES (108, '芬兰', '358');
INSERT INTO `country` VALUES (109, '保加利亚', '359');
INSERT INTO `country` VALUES (110, '立陶宛', '370');
INSERT INTO `country` VALUES (111, '拉脱维亚', '371');
INSERT INTO `country` VALUES (112, '爱沙尼亚', '372');
INSERT INTO `country` VALUES (113, '摩尔多瓦', '373');
INSERT INTO `country` VALUES (114, '亚美尼亚', '374');
INSERT INTO `country` VALUES (115, '白俄罗斯', '375');
INSERT INTO `country` VALUES (116, '安道尔', '376');
INSERT INTO `country` VALUES (117, '摩纳哥', '377');
INSERT INTO `country` VALUES (118, '圣马力诺', '378');
INSERT INTO `country` VALUES (119, '乌克兰', '380');
INSERT INTO `country` VALUES (120, '科索沃，塞尔维亚', '381');
INSERT INTO `country` VALUES (121, '黑山共和国', '382');
INSERT INTO `country` VALUES (122, '克罗地亚', '385');
INSERT INTO `country` VALUES (123, '斯洛文尼亚', '386');
INSERT INTO `country` VALUES (124, '波黑', '387');
INSERT INTO `country` VALUES (125, '马其顿王国', '389');
INSERT INTO `country` VALUES (126, '捷克共和国', '420');
INSERT INTO `country` VALUES (127, '斯洛伐克', '421');
INSERT INTO `country` VALUES (128, '列支敦斯登', '423');
INSERT INTO `country` VALUES (129, '福克兰群岛', '500');
INSERT INTO `country` VALUES (130, '伯利兹', '501');
INSERT INTO `country` VALUES (131, '危地马拉', '502');
INSERT INTO `country` VALUES (132, '萨尔瓦多', '503');
INSERT INTO `country` VALUES (133, '洪都拉斯', '504');
INSERT INTO `country` VALUES (134, '尼加拉瓜', '505');
INSERT INTO `country` VALUES (135, '哥斯达黎加', '506');
INSERT INTO `country` VALUES (136, '巴拿马', '507');
INSERT INTO `country` VALUES (137, '海地', '509');
INSERT INTO `country` VALUES (138, '瓜德罗普', '590');
INSERT INTO `country` VALUES (139, '玻利维亚', '591');
INSERT INTO `country` VALUES (140, '圭亚那', '592');
INSERT INTO `country` VALUES (141, '厄瓜多尔', '593');
INSERT INTO `country` VALUES (142, '法属圭亚那', '594');
INSERT INTO `country` VALUES (143, '巴拉圭', '595');
INSERT INTO `country` VALUES (144, '马提尼克', '596');
INSERT INTO `country` VALUES (145, '苏里南', '597');
INSERT INTO `country` VALUES (146, '乌拉圭', '598');
INSERT INTO `country` VALUES (147, '荷属安德列斯群岛', '599');
INSERT INTO `country` VALUES (148, '东帝汶', '670');
INSERT INTO `country` VALUES (149, '关岛', '671');
INSERT INTO `country` VALUES (150, '文莱达鲁萨兰国', '673');
INSERT INTO `country` VALUES (151, '几内亚,巴布亚新几内亚', '675');
INSERT INTO `country` VALUES (152, '汤加', '676');
INSERT INTO `country` VALUES (153, '所罗门群岛', '677');
INSERT INTO `country` VALUES (154, '瓦努阿图', '678');
INSERT INTO `country` VALUES (155, '斐济', '679');
INSERT INTO `country` VALUES (156, '帕劳', '680');
INSERT INTO `country` VALUES (157, '库克群岛', '682');
INSERT INTO `country` VALUES (158, '美属萨摩亚,萨摩亚群岛', '684');
INSERT INTO `country` VALUES (159, '新喀里多尼亚', '687');
INSERT INTO `country` VALUES (160, '法属玻利尼西亚', '689');
INSERT INTO `country` VALUES (161, '朝鲜', '850');
INSERT INTO `country` VALUES (162, '中国香港', '852');
INSERT INTO `country` VALUES (163, '中国澳门', '853');
INSERT INTO `country` VALUES (164, '柬埔寨', '855');
INSERT INTO `country` VALUES (165, '老挝', '856');
INSERT INTO `country` VALUES (166, '孟加拉国', '880');
INSERT INTO `country` VALUES (167, '中国台湾', '886');
INSERT INTO `country` VALUES (168, '马尔代夫', '960');
INSERT INTO `country` VALUES (169, '黎巴嫩', '961');
INSERT INTO `country` VALUES (170, '约旦', '962');
INSERT INTO `country` VALUES (171, '阿拉伯叙利亚共和国', '963');
INSERT INTO `country` VALUES (172, '伊拉克', '964');
INSERT INTO `country` VALUES (173, '科威特', '965');
INSERT INTO `country` VALUES (174, '沙特阿拉伯', '966');
INSERT INTO `country` VALUES (175, '也门', '967');
INSERT INTO `country` VALUES (176, '阿曼', '968');
INSERT INTO `country` VALUES (177, '阿拉伯联合酋长国', '971');
INSERT INTO `country` VALUES (178, '以色列', '972');
INSERT INTO `country` VALUES (179, '巴林', '973');
INSERT INTO `country` VALUES (180, '卡塔尔', '974');
INSERT INTO `country` VALUES (181, '不丹', '975');
INSERT INTO `country` VALUES (182, '蒙古', '976');
INSERT INTO `country` VALUES (183, '尼泊尔', '977');
INSERT INTO `country` VALUES (184, '塔吉克斯坦', '992');
INSERT INTO `country` VALUES (185, '土库曼斯坦', '993');
INSERT INTO `country` VALUES (186, '阿塞拜疆', '994');
INSERT INTO `country` VALUES (187, '格鲁吉亚', '995');
INSERT INTO `country` VALUES (188, '吉尔吉斯斯坦', '996');
INSERT INTO `country` VALUES (189, '乌兹别克斯坦', '998');
INSERT INTO `country` VALUES (190, '巴哈马群岛', '1242');
INSERT INTO `country` VALUES (191, '巴巴多斯', '1246');
INSERT INTO `country` VALUES (192, '安圭拉岛', '1264');
INSERT INTO `country` VALUES (193, '安提瓜和巴布达', '1268');
INSERT INTO `country` VALUES (194, '英属维尔京群岛', '1340');
INSERT INTO `country` VALUES (195, '开曼群岛', '1345');
INSERT INTO `country` VALUES (196, '百慕大群岛', '1441');
INSERT INTO `country` VALUES (197, '特克斯和凯科斯群岛', '1649');
INSERT INTO `country` VALUES (198, '蒙特塞拉特岛', '1664');
INSERT INTO `country` VALUES (199, '圣卢西亚岛', '1758');
INSERT INTO `country` VALUES (200, '多米尼克', '1767');
INSERT INTO `country` VALUES (201, '圣文森特和格林纳丁斯', '1784');
INSERT INTO `country` VALUES (202, '波多黎各', '1787');
INSERT INTO `country` VALUES (203, '格林纳达,特立尼达和多巴哥', '1809');
INSERT INTO `country` VALUES (204, '圣基茨和尼维斯', '1869');
INSERT INTO `country` VALUES (205, '牙买加', '1876');
INSERT INTO `country` VALUES (206, '多米尼亚共和国', '1890');
INSERT INTO `country` VALUES (207, '加拿大', '2000');
INSERT INTO `country` VALUES (208, '哈萨克斯坦', '2001');
INSERT INTO `country` VALUES (209, '埃及', '2002');

-- ----------------------------
-- Table structure for dic
-- ----------------------------
DROP TABLE IF EXISTS `dic`;
CREATE TABLE `dic`  (
  `dic_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `partition_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分区代码',
  `partition_desc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分区描述',
  `dic_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '枚举项代码',
  `dic_label` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '枚举项名称',
  `del_flg` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '删除标志：0-删除1-未删除',
  PRIMARY KEY (`dic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `follow_id` int(11) NOT NULL COMMENT '被关注的人的id',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关注表 用户-用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE `manufacturer`  (
  `id` int(11) NOT NULL,
  `manufacturer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '厂商名称',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '厂商介绍',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '厂商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for motor_info
-- ----------------------------
DROP TABLE IF EXISTS `motor_info`;
CREATE TABLE `motor_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '型号',
  `manufacturer_id` int(11) NOT NULL COMMENT '厂商id',
  `made_country` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '制造国',
  `market_time` datetime(0) NOT NULL COMMENT '上市时间',
  `retail_price` decimal(10, 0) NOT NULL COMMENT '零售价',
  `displacement` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '排量',
  `cylinders_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缸数',
  `stroke` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '冲程',
  `per_cylinder_valve` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '每缸气门',
  `maximum_power` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '最大功率',
  `maximum_torque` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '最大扭矩',
  `fuel_consumption` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '油耗',
  `gear` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '挡位',
  `tank_capacity` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱容积',
  `weight` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '整车重量',
  `brake_system` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '制动系统',
  `instrument` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仪表形式',
  `maximum_speed` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '最高速度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '摩托信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of motor_info
-- ----------------------------
INSERT INTO `motor_info` VALUES (1, '测试', '1', 1, '1', '2018-12-25 09:53:02', 1, '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `urls` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'json数组',
  `status` int(1) NOT NULL COMMENT '状态',
  `updated_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `status` int(1) NOT NULL COMMENT '状态',
  `update_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码+随机字符串的MD5码',
  `birthday` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `random_string` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '随机字符串',
  `gander` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `personal_profile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地',
  `experience` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经验值',
  `head` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `is_admin` int(2) NULL DEFAULT NULL COMMENT '是否是管理员',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `updated_time` timestamp(0) NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `created_time` timestamp(0) NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'atong', '123456', '', '123', '1', '', 'lt1550919167@163.com', 'liupi le ', NULL, NULL, 'http://localhost:8000/fd39791c-4fba-45b1-873f-041549ac6f9c.jpg', NULL, NULL, '2019-01-08 14:58:29', '2019-01-08 14:58:29');
INSERT INTO `user` VALUES (23, 'at', '12345678', '1997-05-09', NULL, '1', NULL, 'lgjr@163.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-01-03 23:30:15');
INSERT INTO `user` VALUES (24, 'at', '12345678', '1997-05-09', NULL, '1', NULL, 'lgjr@163.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-01-03 23:46:48');
INSERT INTO `user` VALUES (25, 'fegeg', 'gegeews', '2018-12-31T16:00:00.000Z', NULL, '1', NULL, 'geg@163.com', NULL, NULL, NULL, NULL, NULL, NULL, '2019-01-08 14:58:33', '2019-01-08 14:58:33');
INSERT INTO `user` VALUES (26, 'mmmm', 'gegeews', '2018-12-31T16:00:00.000Z', NULL, '1', NULL, 'geg@163.com', NULL, NULL, '0', NULL, NULL, NULL, NULL, '2019-01-03 23:53:23');
INSERT INTO `user` VALUES (27, 'dfddf', '123456', '2018-12-31T16:00:00.000Z', NULL, '0', NULL, 'one@163.com', NULL, NULL, '0', NULL, NULL, NULL, NULL, '2019-01-04 13:12:13');
INSERT INTO `user` VALUES (28, 'dsff', 'fdgrkg', '2019-01-02T16:00:00.000Z', NULL, '1', NULL, 'treg@25.com', NULL, NULL, '0', NULL, NULL, NULL, NULL, '2019-01-04 13:21:35');
INSERT INTO `user` VALUES (29, 'wangy', '234567', 'Tue Jan 01 2019 00:00:00 GMT+0800 (中国标准时间)', NULL, '1', '178655221', '1136272716@qq.com', NULL, NULL, '0', 'http://localhost:8000/5f38bae6-1fa0-4673-92c5-fb08876c48c6.jpg', NULL, NULL, '2019-01-08 16:34:12', '2019-01-06 20:57:38');
INSERT INTO `user` VALUES (30, 'lxxyz', 'lxxyx1', '2019-01-13T16:00:00.000Z', NULL, '1', NULL, '123456@qq.com', NULL, NULL, '0', 'http://localhost:8000/b256a060-80f5-4a2a-8860-d6efed80340e.jpg', NULL, NULL, '2019-01-09 12:57:38', '2019-01-09 12:56:11');
INSERT INTO `user` VALUES (32, '1234', '345678', 'Tue Jan 15 2019 00:00:00 GMT+0800 (中国标准时间)', NULL, '1', '17865426506', '113627276@qq.com', NULL, NULL, '0', 'http://localhost:8000/156f2931-3b1a-4590-9abd-7bef130dba99.jpg', NULL, NULL, '2019-01-09 20:56:13', '2019-01-09 20:46:22');
INSERT INTO `user` VALUES (33, 'wangy', '123456', '2018-12-31T16:00:00.000Z', NULL, '1', NULL, '11362727161@qq.com', NULL, NULL, '0', NULL, NULL, NULL, NULL, '2019-01-10 09:56:22');
INSERT INTO `user` VALUES (34, 'wwwl', '123456', '2018-12-31T16:00:00.000Z', NULL, '1', NULL, '11326272716@qq.com', NULL, NULL, '0', NULL, NULL, NULL, NULL, '2019-01-10 09:56:50');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `created_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
