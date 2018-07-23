CREATE TABLE `test_demo`.`shop`(
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `shop_name` VARCHAR(50) NOT NULL COMMENT '店铺名称',
  `contact_name` VARCHAR(50) COMMENT '联系人姓名',
  `contact_phone` VARCHAR(50) COMMENT '联系人手机号码',
  PRIMARY KEY (`id`)
);

