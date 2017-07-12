/*
Navicat MySQL Data Transfer

Source Server         : 我的数据库
Source Server Version : 50718
Source Host           : 47.94.13.79:3309
Source Database       : chaoyueshidai

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-12 11:37:50
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of files
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of note
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'oejSSwDJnyK3JFT2GqJd4YNPzvIQ', null, null, '0', null, null, null, '2017-07-12 11:06:47', '0', '2017-07-12 11:06:47', '2017-07-12 11:06:47', null);
