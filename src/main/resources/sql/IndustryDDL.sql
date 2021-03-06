CREATE TABLE `lds_user_industry` (
  `id_key` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `industry_id` CHAR(50) NOT NULL COMMENT '行业Id',
  `industry` CHAR(50) NOT NULL COMMENT '行业名称',
  `industry_parentId` CHAR(50) DEFAULT NULL COMMENT '行业的父级ID',
  `created_by` CHAR(10) DEFAULT NULL COMMENT '创建人',
  `updated_by` CHAR(10) DEFAULT NULL COMMENT '更新人',
  `created_date` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `updated_date` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '更新时间',
  PRIMARY KEY (`id_key`),
  UNIQUE KEY `UQINDX_LDS_USER_INDUSTRY_0` (`industry_id`),
  UNIQUE KEY `UQINDX_LDS_USER_INDUSTRY_1` (`industry`),
  KEY `FK_LDS_USER_INDUSTRY_0` (`industry_parentId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户行业表'