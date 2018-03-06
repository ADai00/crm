/*
MySQL Backup
Source Server Version: 5.6.32
Source Database: crm
Date: 2017/8/18 17:31:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cusetName` varchar(255) DEFAULT NULL,
  `custSource` varchar(255) DEFAULT NULL,
  `custPhone` varchar(255) DEFAULT NULL,
  `custMobile` varchar(255) DEFAULT NULL,
  `dictCustLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK3x8tjcnhumyio9jm06xqc4r0b` (`dictCustLevel`),
  CONSTRAINT `FK3x8tjcnhumyio9jm06xqc4r0b` FOREIGN KEY (`dictCustLevel`) REFERENCES `t_dict` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_dict`
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_linkman`
-- ----------------------------
DROP TABLE IF EXISTS `t_linkman`;
CREATE TABLE `t_linkman` (
  `linkid` int(11) NOT NULL AUTO_INCREMENT,
  `lkmName` varchar(20) DEFAULT NULL,
  `lkmGender` varchar(2) DEFAULT NULL,
  `lkmPhone` varchar(10) DEFAULT NULL,
  `lkmMobile` varchar(20) DEFAULT NULL,
  `clid` int(11) DEFAULT NULL,
  PRIMARY KEY (`linkid`),
  KEY `FKinxafh64kvgx8vfajibp3fvgy` (`clid`),
  CONSTRAINT `FKinxafh64kvgx8vfajibp3fvgy` FOREIGN KEY (`clid`) REFERENCES `t_customer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_visit`
-- ----------------------------
DROP TABLE IF EXISTS `t_visit`;
CREATE TABLE `t_visit` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `vaddress` varchar(30) DEFAULT NULL,
  `vcontent` varchar(255) DEFAULT NULL,
  `uvid` int(11) DEFAULT NULL,
  `cvid` int(11) DEFAULT NULL,
  PRIMARY KEY (`vid`),
  KEY `FKnbsiiqbdcpvtugygwe4vj42s0` (`uvid`),
  KEY `FKfq1vs5t876wufr6l5tctnopps` (`cvid`),
  CONSTRAINT `FKfq1vs5t876wufr6l5tctnopps` FOREIGN KEY (`cvid`) REFERENCES `t_customer` (`cid`),
  CONSTRAINT `FKnbsiiqbdcpvtugygwe4vj42s0` FOREIGN KEY (`uvid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1','百度','网络','11111','11111','2'), ('2','阿里巴巴','网络','22222','22222','3'), ('3','腾讯','报纸','33333','33333','1'), ('4','网易','手机','44444','44444','2'), ('5','新浪','报纸','66666','66666','2'), ('6','小钱积分','网络','5200','5200','3'), ('7','谷歌','广播','77777','77777','1'), ('8','Facebook','电视','88888','88888','1'), ('9','SUN','手机','41846','984164','2'), ('10','IBM','电视','8413216','74616','1'), ('11','Oracle','广播','43164','84654','3');
INSERT INTO `t_dict` VALUES ('1','普通客户'), ('2','vip客户'), ('3','超级vip客户');
INSERT INTO `t_user` VALUES ('1','xhm','xhm5200','山东烟台'), ('2','dhl','dhl5200','南极无人区');
