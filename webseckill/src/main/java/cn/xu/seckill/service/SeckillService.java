package cn.xu.seckill.service;


import cn.xu.seckill.dto.Exposer;
import cn.xu.seckill.dto.SeckillExecution;
import cn.xu.seckill.entity.Seckill;
import cn.xu.seckill.exception.RepeatKillException;
import cn.xu.seckill.exception.SeckillCloseException;
import cn.xu.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在‘使用者‘角度设计接口
 * 三个方面：1.方法定义粒度，参数，返回类型（return类型/异常）
 */
public interface SeckillService {

    /**
     * 查询所有秒杀信息列表
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 根据ID查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开始时输出秒杀接口地址，否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckllId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckllId, long userPhone, String md5) throws SeckillException,SeckillCloseException,RepeatKillException;
}
