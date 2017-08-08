-- 数据库初始化脚本

---创建数据库
CREATE DATABASE seckill;
--使用数据库
use seckill;
--创建秒杀库存表
  CREATE TABLE seckill (
  seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  name varchar(120) NOT NULL COMMENT '名字',
  number int NOT NULL COMMENT '库存数量',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  start_time timestamp NOT NULL COMMENT '秒杀开始时间',
  end_time timestamp NOT NULL COMMENT '秒杀结束时间',

  PRIMARY KEY(seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
  )ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT '秒杀库存表';
INSERT INTO
  seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iphone6',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('500元秒杀ipad2',10,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('300元秒杀小米',200,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('200元秒杀努比亚',50,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('100元秒杀华为',30,'2015-11-01 00:00:00','2015-11-02 00:00:00');

--秒杀成功明细表
--用户登录认证信息
CREATE TABLE success_killed(
seckill_id bigint NOT NULL COMMENT '商品库存ID',
user_phone bigint NOT NULL COMMENT '用户手机号',
state tinyint NOT NULL DEFAULT -1 COMMENT '状态标志：-1：无效，0：成功，1：已付款',
create_time TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY(seckill_id,user_phone ),/*联合主键*/
KEY idx_create_time(create_time)

)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='秒杀成功明细表';

--连接数据库控制台
mysql -uroot -p123456