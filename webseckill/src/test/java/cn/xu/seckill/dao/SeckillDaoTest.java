package cn.xu.seckill.dao;

import cn.xu.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和Junit整合，让Junit启动时自动加载springIOC容器
 * spring-test依赖，方便spring测试的依赖，junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**告诉junit，spring的配置文件位置*/
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖,@Resource回去spring容器中查找相应的实现类。
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        /**
         * Caused by: org.apache.ibatis.binding.BindingException: Parameter 'offet' not found. Available parameters are [0, 1, param1, param2]
         * List<Seckill> queryAll(int offet,int limit);
         * java没有保存形参的记录，在运行过程queryAll(int offet,int limit)会变成queryAll(arg0,arg1),需要通过@params("参数名")
         */
        List<Seckill> seckills =  seckillDao.queryAll(0,100);
        for(Seckill seckill:seckills){
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int i = seckillDao.reduceNumber(1000L,killTime);
        System.out.println("----------------" + i);
    }
}