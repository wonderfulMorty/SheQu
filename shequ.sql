/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : shequ

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 18/04/2020 12:32:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '管理员', 'admin', '123');

-- ----------------------------
-- Table structure for choice
-- ----------------------------
DROP TABLE IF EXISTS `choice`;
CREATE TABLE `choice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `q_id` int(11) NULL DEFAULT NULL,
  `moption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of choice
-- ----------------------------
INSERT INTO `choice` VALUES (33, 14, 'A.0-5次', '');
INSERT INTO `choice` VALUES (34, 14, 'B.6-10次', '');
INSERT INTO `choice` VALUES (35, 14, 'C.从来不买', '');
INSERT INTO `choice` VALUES (36, 14, 'D.有钱任性，想买就买', '');
INSERT INTO `choice` VALUES (37, 15, 'A.0-3次', '');
INSERT INTO `choice` VALUES (38, 15, 'B.4-10次', '');
INSERT INTO `choice` VALUES (39, 15, 'C.从来不', '');
INSERT INTO `choice` VALUES (40, 15, 'D.有钱任性，数不过来多少次', '');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_price` double(10, 2) NULL DEFAULT NULL,
  `publisher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (11, 'JcALgfD3O1anEu8J', '小米', '小米促销', '21cfd8848b7247d38bd6b1c3398c79ad.jpg', 1444.00, 'admin', '2020-03-20 23:33:50');

-- ----------------------------
-- Table structure for goodspay
-- ----------------------------
DROP TABLE IF EXISTS `goodspay`;
CREATE TABLE `goodspay`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodspay
-- ----------------------------
INSERT INTO `goodspay` VALUES (16, 'JcALgfD3O1anEu8J', 'NLAHQNt4607V594q');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime(0) NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (21, '2020-03-20 23:30:58', 'morty', '广州女子核酸阴性.xml', 'Snipaste_2019-05-27_13-53-04.png', '广州女子核酸阴性', '-28d0b2dd59677413.jpg');
INSERT INTO `message` VALUES (22, '2020-03-20 23:32:54', 'morty', '油价暴跌对中国经济的冲击.xml', 'Snipaste_2019-05-27_13-52-35.png', '油价暴跌对中国经济的冲击', '-28d0b2dd59677413.jpg');

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `itemName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payment` double(255, 0) NULL DEFAULT NULL,
  `paytime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES (14, 'NLAHQNt4607V594q', '电费', 111, '2020-03-20 23:40:00');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (14, '一年买多少次衣服？');
INSERT INTO `question` VALUES (15, '一年出国几次旅游');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `my_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `my_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic0` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (8, 'NLAHQNt4607V594q', '热水器坏了', '公共区域', 'wxc89c0d8edfb74c95.o6zAJs6Y7zorwYFeP25h3w93UO8w.i5uNZ83uKUJ1d2da2e13c8cd8de78fec96de8aaf5a23.png', NULL, NULL);

-- ----------------------------
-- Table structure for sur_que
-- ----------------------------
DROP TABLE IF EXISTS `sur_que`;
CREATE TABLE `sur_que`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `su_id` int(11) NULL DEFAULT NULL,
  `qid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sur_que
-- ----------------------------
INSERT INTO `sur_que` VALUES (19, 17, 14);
INSERT INTO `sur_que` VALUES (20, 17, 15);

-- ----------------------------
-- Table structure for survey
-- ----------------------------
DROP TABLE IF EXISTS `survey`;
CREATE TABLE `survey`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调查标题',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES (17, '你的生活质量？');
INSERT INTO `survey` VALUES (18, '你健康吗');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buildingNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unitNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roomNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roomId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('NLAHQNt4607V594q', 'rick', '男', '02', '02', '102', '13986544321', '123456', '0202102');

-- ----------------------------
-- Table structure for user_sur
-- ----------------------------
DROP TABLE IF EXISTS `user_sur`;
CREATE TABLE `user_sur`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qid` int(11) NULL DEFAULT NULL,
  `su_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_sur
-- ----------------------------
INSERT INTO `user_sur` VALUES (49, 'NLAHQNt4607V594q', 14, 17);
INSERT INTO `user_sur` VALUES (50, 'NLAHQNt4607V594q', 15, 17);

-- ----------------------------
-- Table structure for user_sur_opt
-- ----------------------------
DROP TABLE IF EXISTS `user_sur_opt`;
CREATE TABLE `user_sur_opt`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_sur_id` int(11) NULL DEFAULT NULL,
  `opt_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_sur_opt
-- ----------------------------
INSERT INTO `user_sur_opt` VALUES (45, 49, 35);
INSERT INTO `user_sur_opt` VALUES (46, 50, 38);

SET FOREIGN_KEY_CHECKS = 1;
