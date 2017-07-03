/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : chaoyueshidai

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-03 17:22:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `userid` int(11) NOT NULL,
  `value` longtext,
  `last_value` longtext,
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for example
-- ----------------------------
DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(50) DEFAULT NULL,
  `legend` longtext,
  `url` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `suffix` varchar(10) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` longtext,
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subscribe` int(1) DEFAULT '0',
  `openid` varchar(34) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `sex` int(1) DEFAULT '0',
  `city` varchar(10) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL,
  `language` varchar(10) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `subscribe_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `unionid` varchar(34) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `groupid` int(2) DEFAULT '0',
  `username` varchar(100) DEFAULT NULL,
  `pwd` varchar(34) DEFAULT NULL,
  `type` int(1) DEFAULT '0',
  `login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
