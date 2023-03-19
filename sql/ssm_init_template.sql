/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : ssm_init_template

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 16/03/2023 20:38:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filepath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` double NULL DEFAULT NULL,
  `updatetime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, '1ed515c9-1aa3-420b-a07c-e67a530ab657.sql', '/upload/1ed515c9-1aa3-420b-a07c-e67a530ab657.sql', 935, '2023-03-15 14:10:55');
INSERT INTO `file` VALUES (2, '79d7f22a-1661-476c-bb38-49a1925efd6f.sql', '/upload/79d7f22a-1661-476c-bb38-49a1925efd6f.sql', 1213, '2023-03-15 14:10:55');
INSERT INTO `file` VALUES (3, '92e93c38-c831-4e98-bf1d-866f36f14fe3.sql', '/upload/92e93c38-c831-4e98-bf1d-866f36f14fe3.sql', 997, '2023-03-15 14:10:55');
INSERT INTO `file` VALUES (4, '3dafca97-7090-49c2-bc27-f2e8d1423e32.sql', '/upload/3dafca97-7090-49c2-bc27-f2e8d1423e32.sql', 935, '2023-03-15 14:11:27');
INSERT INTO `file` VALUES (5, '69db2743-1648-4cf8-92ef-c713da181840.sql', '/upload/69db2743-1648-4cf8-92ef-c713da181840.sql', 1213, '2023-03-15 14:11:27');
INSERT INTO `file` VALUES (6, 'cb3ca5d8-60c8-4945-b55f-3f43d3de05d9.sql', '/upload/cb3ca5d8-60c8-4945-b55f-3f43d3de05d9.sql', 997, '2023-03-15 14:11:27');
INSERT INTO `file` VALUES (7, '85708067-9808-46d4-8187-9642a04ef010.sql', '/upload/85708067-9808-46d4-8187-9642a04ef010.sql', 935, '2023-03-15 14:12:08');
INSERT INTO `file` VALUES (8, '42d632d4-dbaa-44c5-873e-cc12103123cf.sql', '/upload/42d632d4-dbaa-44c5-873e-cc12103123cf.sql', 1213, '2023-03-15 14:12:08');
INSERT INTO `file` VALUES (9, 'd551397a-732b-4671-b188-9e7da3008726.sql', '/upload/d551397a-732b-4671-b188-9e7da3008726.sql', 997, '2023-03-15 14:12:08');
INSERT INTO `file` VALUES (10, '37245eca-71a9-4325-8a94-4a0d31fae60a.sql', '/upload/37245eca-71a9-4325-8a94-4a0d31fae60a.sql', 935, '2023-03-15 14:21:06');
INSERT INTO `file` VALUES (11, '34b600ef-5cca-4cdf-8465-5d5d89c0d968.sql', '/upload/34b600ef-5cca-4cdf-8465-5d5d89c0d968.sql', 1213, '2023-03-15 14:21:06');
INSERT INTO `file` VALUES (12, 'ceb290e2-3823-40b8-a048-b465d70d4794.sql', '/upload/ceb290e2-3823-40b8-a048-b465d70d4794.sql', 997, '2023-03-15 14:21:06');
INSERT INTO `file` VALUES (13, 'fe6428ed-6de0-47d0-9ce9-6f0a9278a2c4.docx', '/upload/fe6428ed-6de0-47d0-9ce9-6f0a9278a2c4.docx', 142193, '2023-03-15 14:24:53');
INSERT INTO `file` VALUES (14, 'ab676e87-b569-48f2-9fbe-202085d127b0.docx', '/upload/ab676e87-b569-48f2-9fbe-202085d127b0.docx', 1356763, '2023-03-15 14:24:53');
INSERT INTO `file` VALUES (15, '218fce15-e755-4361-bbc6-3eed38834ff5.exe', '/upload/218fce15-e755-4361-bbc6-3eed38834ff5.exe', 1575742, '2023-03-15 14:28:21');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `controller` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, '0:0:0:0:0:0:0:1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-09 11:10:49', 'GET', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (2, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-09 11:18:43', 'GET', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (3, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-09 12:53:04', 'POST', '{}');
INSERT INTO `log` VALUES (4, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-09 12:53:07', 'POST', '{}');
INSERT INTO `log` VALUES (5, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-09 12:54:26', 'POST', '{}');
INSERT INTO `log` VALUES (6, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-09 12:57:29', 'POST', '{}');
INSERT INTO `log` VALUES (7, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-09 12:59:44', 'POST', '{}');
INSERT INTO `log` VALUES (8, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-09 13:03:37', 'POST', '{}');
INSERT INTO `log` VALUES (9, '127.0.0.1', 'cn.chenmanman.ssm.controller.MenuController', '/menu', '2023-03-13 15:08:01', 'POST', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (10, '127.0.0.1', 'cn.chenmanman.ssm.controller.MenuController', '/menu', '2023-03-13 15:10:12', 'POST', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (11, '127.0.0.1', 'cn.chenmanman.ssm.controller.MenuController', '/menu', '2023-03-13 15:12:09', 'POST', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (12, '127.0.0.1', 'cn.chenmanman.ssm.controller.MenuController', '/menu', '2023-03-13 15:13:01', 'POST', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (13, '127.0.0.1', 'cn.chenmanman.ssm.controller.MenuController', '/menu', '2023-03-13 15:14:51', 'POST', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (14, '127.0.0.1', 'cn.chenmanman.ssm.controller.MenuController', '/menu', '2023-03-13 15:16:41', 'POST', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (15, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user', '2023-03-13 15:17:17', 'GET', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (16, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 15:43:17', 'POST', '{}');
INSERT INTO `log` VALUES (17, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 15:43:24', 'POST', '{}');
INSERT INTO `log` VALUES (18, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 15:43:50', 'POST', '{}');
INSERT INTO `log` VALUES (19, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 15:44:12', 'POST', '{}');
INSERT INTO `log` VALUES (20, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 15:58:30', 'POST', '{}');
INSERT INTO `log` VALUES (21, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 15:58:38', 'POST', '{}');
INSERT INTO `log` VALUES (22, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 15:58:49', 'POST', '{}');
INSERT INTO `log` VALUES (23, '127.0.0.1', 'cn.chenmanman.ssm.controller.MenuController', '/menu', '2023-03-13 16:11:44', 'POST', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (24, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 19:57:32', 'POST', '{}');
INSERT INTO `log` VALUES (25, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-13 19:58:07', 'GET', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (26, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-13 21:58:21', 'GET', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (27, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-13 21:58:27', 'GET', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (28, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-05-13 21:58:46', 'GET', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');
INSERT INTO `log` VALUES (29, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/login', '2023-03-13 20:07:00', 'POST', '{}');
INSERT INTO `log` VALUES (30, '127.0.0.1', 'cn.chenmanman.ssm.controller.UserController', '/user/', '2023-03-13 20:35:33', 'GET', '{\"pageNum\":[\"1\"],\"pageSize\":[\"10\"]}');

-- ----------------------------
-- Table structure for man_menu
-- ----------------------------
DROP TABLE IF EXISTS `man_menu`;
CREATE TABLE `man_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint NULL DEFAULT 0,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order` int NULL DEFAULT NULL,
  `status` tinyint NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` bigint NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` bigint NULL DEFAULT NULL,
  `del_flag` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of man_menu
-- ----------------------------
INSERT INTO `man_menu` VALUES (1, 0, '系统管理', NULL, '/sys/', '/sys/index', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, 0);
INSERT INTO `man_menu` VALUES (2, 1, '用户管理', NULL, '/sys/user', '/sys/user/index', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, 0);
INSERT INTO `man_menu` VALUES (3, 1, '角色管理', NULL, '/sys/role', '/sys/role/index', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, 0);
INSERT INTO `man_menu` VALUES (4, 1, '菜单管理', NULL, '/sys/menu', '/sys/menu/index', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for man_role
-- ----------------------------
DROP TABLE IF EXISTS `man_role`;
CREATE TABLE `man_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` bigint NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` bigint NULL DEFAULT NULL,
  `status` tinyint NULL DEFAULT 0,
  `del_flag` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of man_role
-- ----------------------------
INSERT INTO `man_role` VALUES (1, '超级管理员', '2023-03-12 22:49:00', NULL, NULL, NULL, 0, 0);
INSERT INTO `man_role` VALUES (2, '用户管理员', '2023-03-12 22:49:31', NULL, NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for man_user
-- ----------------------------
DROP TABLE IF EXISTS `man_user`;
CREATE TABLE `man_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` tinyint NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` bigint NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` bigint NULL DEFAULT NULL,
  `status` tinyint NULL DEFAULT 0,
  `del_flag` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of man_user
-- ----------------------------
INSERT INTO `man_user` VALUES (1, 'admin', 'huanyuan', 96, 'j.umij@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (4, 'chenmanman', 'Lorem', 18, 'p.ytko@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (5, 'Brenda', '786881', 78, 'k.fuik@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (6, 'Kevin', 'huanyuan', 11, 'w.ono@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (7, 'Dorothy', '45617855', 38, 'x.usky@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (8, 'Karen', '4236264', 70, 'x.ced@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (9, 'John', '21475', 5, 'q.ldihb@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (10, 'Maria', '9234222362', 13, 'w.mmhwfsgxo@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (11, 'Charles', '9542583', 50, 'j.toufqyksyo@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (12, 'Michelle', '11754117', 93, 'r.yqkvy@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (13, 'Mary', '8624219', 60, 'x.qtbdmznn@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (14, 'David', '46056935', 41, 'j.hwhxfwgqi@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (15, 'Donald', '40811', 7, 'p.klkqat@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (16, 'Carol', '59730', 51, 'k.dxiaajd@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (17, 'Ruth', '238325435', 25, 'p.pfewt@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (18, 'Anthony', '5612155', 90, 'c.wletu@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (19, 'Deborah', '92525138', 38, 'b.bsmznkd@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (20, 'John', '1629436', 24, 'b.yyzomerqgu@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (21, 'Carol', '54663604', 98, 'd.yfvoiljg@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (22, 'Jason', '3376886', 43, 'w.ewwdnimyt@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (23, 'Paul', '3058546', 36, 'o.ijxjpp@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 1);
INSERT INTO `man_user` VALUES (24, 'Gary', '286646', 88, 'h.eojdtzjhc@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 1);
INSERT INTO `man_user` VALUES (25, 'George', '3215534', 95, 'e.kylz@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 1);
INSERT INTO `man_user` VALUES (26, 'Lisa', '756765', 58, 'y.ocgs@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (27, 'Jason', '212234126', 92, 'd.kpjotevgvm@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (28, 'Kevin', '145972451', 46, 'x.wbrruw@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `man_user` VALUES (29, 'Joseph', '8524685', 61, 'h.yyrlwhlh@qq.com', 'http://dummyimage.com/100x100', NULL, NULL, NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (2, 1);
INSERT INTO `role_menu` VALUES (2, 2);

-- ----------------------------
-- Table structure for s_student
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `cid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES (1, '陈慢慢', 21, 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (5, 1);
INSERT INTO `user_role` VALUES (4, 2);
INSERT INTO `user_role` VALUES (5, 2);

SET FOREIGN_KEY_CHECKS = 1;
