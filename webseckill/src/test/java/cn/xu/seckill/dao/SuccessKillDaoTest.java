package cn.xu.seckill.dao;

import cn.xu.seckill.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
/**告诉junit，spring的配置文件位置*/
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKillDaoTest {

    @Resource
    private SuccessKillDao successKillDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        int ins = successKillDao.insertSuccessKilled(1001,15024619056L);
        System.out.println("--------------" + ins);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        SuccessKilled successKilled = successKillDao.queryByIdWithSeckill(1001,15024619056L);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}