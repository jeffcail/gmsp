/*
 Navicat Premium Data Transfer

 Source Server         : docker5.7
 Source Server Type    : MySQL
 Source Server Version : 50736 (5.7.36)
 Source Host           : localhost:3310
 Source Schema         : gmsp

 Target Server Type    : MySQL
 Target Server Version : 50736 (5.7.36)
 File Encoding         : 65001

 Date: 21/05/2023 20:11:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gmsp_file
-- ----------------------------
DROP TABLE IF EXISTS `gmsp_file`;
CREATE TABLE `gmsp_file` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `ext` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `isdelete` tinyint(1) DEFAULT NULL,
  `isenable` tinyint(1) DEFAULT NULL,
  `filemd5` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gmsp_file
-- ----------------------------
BEGIN;
INSERT INTO `gmsp_file` (`id`, `filename`, `ext`, `size`, `url`, `isdelete`, `isenable`, `filemd5`, `created_at`, `updated_at`) VALUES (3, '用户信息.xlsx', 'xlsx', 19456, 'http://localhost:9000/uploads/002e5f24dd8c4ded8b0ae5a5007c74c3.xlsx', 0, 1, 'ae3aeab4802cff668401055cfd82a5e7', '2023-05-21 05:38:44', '2023-05-21 07:24:29');
INSERT INTO `gmsp_file` (`id`, `filename`, `ext`, `size`, `url`, `isdelete`, `isenable`, `filemd5`, `created_at`, `updated_at`) VALUES (7, '用户信息.xlsx', 'xlsx', 19456, 'http://localhost:9000/uploads/8f5db2bbf33b4da1b437e0c618ac0f9a.xlsx', 0, 0, '', '2023-05-21 05:55:03', '2023-05-21 07:18:54');
INSERT INTO `gmsp_file` (`id`, `filename`, `ext`, `size`, `url`, `isdelete`, `isenable`, `filemd5`, `created_at`, `updated_at`) VALUES (8, '用户信息.xlsx', 'xlsx', 19456, 'http://localhost:9000/uploads/247869379c324a32a7d993c4a46b0801.xlsx', 1, 1, '', '2023-05-21 05:55:41', '2023-05-21 07:00:05');
INSERT INTO `gmsp_file` (`id`, `filename`, `ext`, `size`, `url`, `isdelete`, `isenable`, `filemd5`, `created_at`, `updated_at`) VALUES (9, 'avator.jpeg', 'jpeg', 23369, 'http://localhost:9000/uploads/b53811d7a63040369612e3d7a54f28d7.jpeg', 1, 1, '', '2023-05-21 06:46:30', '2023-05-21 07:00:05');
INSERT INTO `gmsp_file` (`id`, `filename`, `ext`, `size`, `url`, `isdelete`, `isenable`, `filemd5`, `created_at`, `updated_at`) VALUES (10, 'file.txt', 'txt', 22, 'http://localhost:9000/uploads/fd9978e87dff447dae0d27212787ecb2.txt', 1, 1, '', '2023-05-21 06:47:55', '2023-05-21 06:59:29');
COMMIT;

-- ----------------------------
-- Table structure for gmsp_menu
-- ----------------------------
DROP TABLE IF EXISTS `gmsp_menu`;
CREATE TABLE `gmsp_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gmsp_menu
-- ----------------------------
BEGIN;
INSERT INTO `gmsp_menu` (`id`, `pid`, `name`, `path`, `icon`, `description`) VALUES (1, NULL, '主页', '/home', 'el-icon-house', '通用后台管理系统首页');
INSERT INTO `gmsp_menu` (`id`, `pid`, `name`, `path`, `icon`, `description`) VALUES (5, NULL, '系统管理', NULL, 'el-icon-menu', '系统管理模块');
INSERT INTO `gmsp_menu` (`id`, `pid`, `name`, `path`, `icon`, `description`) VALUES (6, 5, '用户管理', '/user', 'el-icon-s-custom', '用户管理模块');
INSERT INTO `gmsp_menu` (`id`, `pid`, `name`, `path`, `icon`, `description`) VALUES (7, 5, '角色管理', '/role', 'el-icon-s-custom', '角色管理模块');
INSERT INTO `gmsp_menu` (`id`, `pid`, `name`, `path`, `icon`, `description`) VALUES (8, 5, '菜单管理', '/menu', 'el-icon-s-custom', '菜单管理模块');
INSERT INTO `gmsp_menu` (`id`, `pid`, `name`, `path`, `icon`, `description`) VALUES (9, NULL, '文件管理', NULL, 'el-icon-s-menu', '文件管理模块');
INSERT INTO `gmsp_menu` (`id`, `pid`, `name`, `path`, `icon`, `description`) VALUES (10, 9, '文件管理', '/file', 'el-icon-s-document', '文件管理');
COMMIT;

-- ----------------------------
-- Table structure for gmsp_role
-- ----------------------------
DROP TABLE IF EXISTS `gmsp_role`;
CREATE TABLE `gmsp_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gmsp_role
-- ----------------------------
BEGIN;
INSERT INTO `gmsp_role` (`id`, `name`, `description`, `flag`) VALUES (1, '超级管理员', '超级管理员拥有所有的权限', 'ROLE_ADMIN');
INSERT INTO `gmsp_role` (`id`, `name`, `description`, `flag`) VALUES (2, '系统管理员', '系统管理员的权限仅次于超级管理员', 'ROLE_SYSTEM');
COMMIT;

-- ----------------------------
-- Table structure for gmsp_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `gmsp_role_menu`;
CREATE TABLE `gmsp_role_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gmsp_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `gmsp_role_menu` (`id`, `role_id`, `menu_id`) VALUES (20, 1, 1);
INSERT INTO `gmsp_role_menu` (`id`, `role_id`, `menu_id`) VALUES (21, 1, 5);
INSERT INTO `gmsp_role_menu` (`id`, `role_id`, `menu_id`) VALUES (22, 1, 6);
INSERT INTO `gmsp_role_menu` (`id`, `role_id`, `menu_id`) VALUES (23, 1, 7);
INSERT INTO `gmsp_role_menu` (`id`, `role_id`, `menu_id`) VALUES (24, 1, 8);
INSERT INTO `gmsp_role_menu` (`id`, `role_id`, `menu_id`) VALUES (25, 1, 9);
INSERT INTO `gmsp_role_menu` (`id`, `role_id`, `menu_id`) VALUES (26, 1, 10);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1262592016 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1, 'admin', 'admin', '管理员', '../assets/images/avator.jpeg', 'admin@qq.com', '13988997788', '浙江省杭州市', '1', '2023-05-17 14:00:55', '2023-05-21 11:33:28');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (2, 'ceshi', 'ceshi', '测试', '../assets/images/avator.jpeg', 'ceshi@qq.com', '15626354747', '北京市', '2', '2023-05-17 14:31:55', '2023-05-21 11:55:07');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (3, 'litian', 'litian', '李天111', '../assets/images/avator.jpeg', 'litian@qq.com', '1873746363', '浙江省金华市', '2', '2023-05-17 14:46:08', '2023-05-21 11:55:08');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592007, 'admin5', 'admin5', '管理员5', '../assets/images/avator.jpeg', 'admin@qq.com', '13988997788', '浙江省杭州市', '2', '2023-05-17 14:00:55', '2023-05-21 11:55:09');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592008, 'ceshi6', 'ceshi6', '测试6', '../assets/images/avator.jpeg', 'ceshi@qq.com', '15626354747', '北京市', '2', '2023-05-17 14:31:55', '2023-05-21 11:55:10');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592009, 'litian7', 'litian7', '李天7', '../assets/images/avator.jpeg', 'litian@qq.com', '1873746363', '浙江省金华市', '2', '2023-05-17 14:46:08', '2023-05-21 11:55:10');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592010, 'admin5', 'admin5', '管理员5', '../assets/images/avator.jpeg', 'admin@qq.com', '13988997788', '浙江省杭州市', '2', '2023-05-17 14:00:55', '2023-05-21 11:55:11');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592011, 'ceshi6', 'ceshi6', '测试6', '../assets/images/avator.jpeg', 'ceshi@qq.com', '15626354747', '北京市', '2', '2023-05-17 14:31:55', '2023-05-21 11:55:12');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592012, 'litian7', 'litian7', '李天7', '../assets/images/avator.jpeg', 'litian@qq.com', '1873746363', '浙江省金华市', '2', '2023-05-17 14:46:08', '2023-05-21 11:55:13');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592013, 'admin5', 'admin5', '管理员5', '../assets/images/avator.jpeg', 'admin@qq.com', '13988997788', '浙江省杭州市', '2', '2023-05-17 14:00:55', '2023-05-21 11:55:13');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592014, 'ceshi6', 'ceshi6', '测试6', '../assets/images/avator.jpeg', 'ceshi@qq.com', '15626354747', '北京市', '2', '2023-05-17 14:31:55', '2023-05-21 11:55:14');
INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `avatar`, `email`, `phone`, `address`, `role`, `create_at`, `update_at`) VALUES (1262592015, 'litian7', 'litian7', '李天7', '../assets/images/avator.jpeg', 'litian@qq.com', '1873746363', '浙江省金华市', '2', '2023-05-17 14:46:08', '2023-05-21 11:55:15');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
