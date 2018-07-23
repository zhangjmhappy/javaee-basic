CREATE TABLE `test_demo`.`shop`(
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `shop_name` VARCHAR(50) NOT NULL COMMENT '店铺名称',
  `contactName` VARCHAR(50) COMMENT '联系人姓名',
  `contactPhone` VARCHAR(50) COMMENT '联系人手机haom',
  PRIMARY KEY (`id`)
);

ALTER TABLE `test_demo`.`shop`
  CHANGE `contactName` `contact_name` VARCHAR(50) CHARSET latin1 COLLATE latin1_swedish_ci NULL COMMENT '联系人姓名',
  CHANGE `contactPhone` `contact_phone` VARCHAR(50) CHARSET latin1 COLLATE latin1_swedish_ci NULL COMMENT '联系人手机号码',
  CHARSET=utf8, COLLATE=utf8_general_ci;
