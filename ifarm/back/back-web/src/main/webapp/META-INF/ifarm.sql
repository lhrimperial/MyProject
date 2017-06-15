/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : ifarm

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-06-09 18:19:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_super_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_super_resource`;
CREATE TABLE `t_super_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `res_code` varchar(50) NOT NULL COMMENT '权限编码',
  `res_name` varchar(100) NOT NULL COMMENT '权限名称',
  `entry_url` varchar(255) DEFAULT NULL COMMENT '权限入口URI',
  `res_level` tinyint(1) unsigned NOT NULL COMMENT '功能层级(1：子系统 2：模块 3：菜单 4：按钮)',
  `parent_res` varchar(50) DEFAULT NULL COMMENT '上级权限',
  `res_type` tinyint(1) unsigned NOT NULL COMMENT '权限类型(1：子系统 2：模块 3：菜单 4：按钮)',
  `display_order` tinyint(1) unsigned DEFAULT NULL COMMENT '显示顺序',
  `checked` tinyint(1) DEFAULT NULL COMMENT '是否权限检查',
  `leaf_flag` tinyint(1) unsigned DEFAULT NULL COMMENT '是否叶子节点',
  `node_cls` varchar(50) DEFAULT NULL COMMENT '节点的CSS样式',
  `icon_cls` varchar(50) DEFAULT NULL COMMENT '图标的CSS样式',
  `system_code` varchar(50) DEFAULT NULL COMMENT '所属系统类型',
  `notes` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `version_no` decimal(15,0) DEFAULT NULL COMMENT '数据版本',
  `is_deleted` tinyint(1) unsigned DEFAULT NULL COMMENT '逻辑删除',
  `create_user` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_user` varchar(50) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_resource_code` (`res_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_super_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_super_role
-- ----------------------------
DROP TABLE IF EXISTS `t_super_role`;
CREATE TABLE `t_super_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL COMMENT '角色CODE',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `system_code` varchar(50) DEFAULT NULL COMMENT '系统编码',
  `type` varchar(50) DEFAULT NULL COMMENT '角色类型',
  `notes` varchar(255) DEFAULT NULL,
  `version_no` decimal(15,0) DEFAULT NULL COMMENT '数据版本',
  `is_deleted` tinyint(1) unsigned DEFAULT NULL COMMENT '逻辑删除（1：是 0：否）',
  `create_user` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_user` varchar(50) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_super_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_super_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_super_role_resource`;
CREATE TABLE `t_super_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `res_code` varchar(50) NOT NULL,
  `version_no` decimal(15,0) DEFAULT NULL,
  `is_deleted` tinyint(1) unsigned DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_user` varchar(50) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_role_code` (`role_code`),
  KEY `idx_res_code` (`res_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_super_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_super_user
-- ----------------------------
DROP TABLE IF EXISTS `t_super_user`;
CREATE TABLE `t_super_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL COMMENT '登录用户名',
  `pass_word` varchar(100) NOT NULL COMMENT '登录密码',
  `emp_code` varchar(50) DEFAULT NULL COMMENT '员工工号',
  `emp_name` varchar(100) DEFAULT NULL COMMENT '员工姓名',
  `org_code` varchar(50) DEFAULT NULL COMMENT '组织编码',
  `is_emp` tinyint(1) unsigned DEFAULT NULL COMMENT '是否是本公司员工(1：是 0：否)',
  `last_login` datetime DEFAULT NULL COMMENT '上次登录时间',
  `notes` varchar(255) DEFAULT NULL COMMENT '备注',
  `version_no` decimal(15,0) DEFAULT NULL COMMENT '数据版本',
  `is_deleted` tinyint(1) unsigned DEFAULT NULL COMMENT '逻辑删除（1：是 0：否）',
  `create_user` varchar(50) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `modify_user` varchar(50) DEFAULT '',
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_code` (`user_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_super_user
-- ----------------------------
INSERT INTO `t_super_user` VALUES ('5', '275688', 'E10ADC3949BA59ABBE56E057F20F883E', '275688', '龙海仁', 'DP0001', '1', null, null, '1496999073298', '0', 'admin', '2017-06-09 17:04:33', 'admin', '2017-06-09 17:04:33');

-- ----------------------------
-- Table structure for t_super_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_super_user_role`;
CREATE TABLE `t_super_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL COMMENT '用户编码',
  `org_code` varchar(50) NOT NULL COMMENT '组织编码',
  `role_code` varchar(50) NOT NULL COMMENT '角色编码',
  `version_no` decimal(15,0) DEFAULT NULL COMMENT '数据版本',
  `is_deleted` tinyint(1) unsigned DEFAULT NULL COMMENT '逻辑删除',
  `create_user` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_user` varchar(50) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_code` (`user_code`),
  KEY `idx_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_super_user_role
-- ----------------------------
