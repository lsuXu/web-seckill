package cn.xu.seckill.dao;

import cn.xu.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface SuccessKillDao {

    /**
     * 插入购买明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id 查询SuccessKilled并携带秒杀对象
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
}
