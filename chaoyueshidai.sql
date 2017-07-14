/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : chaoyueshidai

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-13 19:04:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for example
-- ----------------------------
DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '项目标题',
  `legend` longtext COMMENT '项目说明',
  `qrcode` varchar(255) DEFAULT NULL COMMENT '二维码地址',
  `url` varchar(255) DEFAULT NULL COMMENT '项目网址',
  `pic` varchar(255) DEFAULT NULL COMMENT '项目缩略图',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `type` varchar(20) DEFAULT NULL COMMENT '项目类型',
  `start_time` datetime DEFAULT NULL COMMENT '项目开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '项目结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of example
-- ----------------------------

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `suffix` varchar(10) DEFAULT NULL COMMENT '后缀',
  `time` bigint(20) DEFAULT NULL COMMENT '上传所花时间',
  `url` varchar(255) DEFAULT NULL COMMENT '服务器地址',
  `des` varchar(255) DEFAULT NULL COMMENT '文件说明',
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of files
-- ----------------------------
INSERT INTO `files` VALUES ('1', 'me', 'png', '27', '/userfiles/2017/07/13/d93989dbf32b4dd2b54da4cea50157d3.png', null, '2017-07-13 13:16:59');
INSERT INTO `files` VALUES ('2', 'qrcode', 'jpg', '8', '/userfiles/2017/07/13/64f346f2c9464e4c8892855e5f658ea5.jpg', null, '2017-07-13 14:39:17');
INSERT INTO `files` VALUES ('3', 'qrcode', 'jpg', '6', '/userfiles/2017/07/13/600b574cb7bf419ab0dd7ebe063cf121.jpg', null, '2017-07-13 14:50:39');
INSERT INTO `files` VALUES ('4', 'me', 'png', '7', '/userfiles/2017/07/13/ebf2b20824d64c2d9199819a552321e6.png', null, '2017-07-13 15:05:49');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '笔记标题',
  `pic` varchar(255) DEFAULT NULL COMMENT '笔记封面',
  `content` longtext COMMENT '笔记内容',
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` int(11) DEFAULT NULL COMMENT '用户Id',
  `type` varchar(20) DEFAULT NULL COMMENT '笔记类型',
  `share` int(1) DEFAULT '0' COMMENT '是否公开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('2', 'me', '/userfiles/2017/07/13/ebf2b20824d64c2d9199819a552321e6.png', '哈哈哈哈', '2017-07-13 16:30:33', '1', '2', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subscribe` int(1) DEFAULT '0' COMMENT '是否关注订阅号',
  `openid` varchar(36) DEFAULT NULL COMMENT 'openid',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `gender` int(1) DEFAULT '0' COMMENT '性别',
  `province` varchar(10) DEFAULT NULL COMMENT '省',
  `city` varchar(10) DEFAULT NULL COMMENT '市',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `subscribe_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '关注时间',
  `type` int(1) DEFAULT '0' COMMENT '用户类型',
  `login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次登录时间',
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `tel` varchar(20) DEFAULT NULL COMMENT '手机',
  `pwd` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'oejSSwDJnyK3JFT2GqJd4YNPzvIQ', '魏自东', '老魏', '1', '重庆', '重庆', '/userfiles/2017/07/13/600b574cb7bf419ab0dd7ebe063cf121.jpg', '2017-07-12 18:20:50', '0', '2017-07-12 18:20:50', '2017-07-12 18:20:50', '13541305583', '974f7b5e9f70ed6044185c096b356f7e');
