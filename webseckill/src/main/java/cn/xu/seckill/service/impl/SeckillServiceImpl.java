package cn.xu.seckill.service.impl;

import cn.xu.seckill.dao.SeckillDao;
import cn.xu.seckill.dao.SuccessKillDao;
import cn.xu.seckill.dto.Exposer;
import cn.xu.seckill.dto.SeckillExecution;
import cn.xu.seckill.entity.Seckill;
import cn.xu.seckill.entity.SuccessKilled;
import cn.xu.seckill.exception.RepeatKillException;
import cn.xu.seckill.exception.SeckillCloseException;
import cn.xu.seckill.exception.SeckillException;
import cn.xu.seckill.service.SeckillService;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

public class SeckillServiceImpl implements SeckillService{

    //md5盐值字符串，用于混淆MD5
    private final String salt = "daadfjklsflafnvamvv,v ,s";

    private SeckillDao seckillDao;

    private SuccessKillDao successKillDao;

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = getById(seckillId);
        if(seckill == null)
            return new Exposer(false,seckillId);
        Date nowTime = new Date();
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        if(nowTime.getTime()<startTime.getTime() || nowTime.getTime()>endTime.getTime())
            return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
        //转化特定字符串加密，不可逆
        String md5 = getMd5(seckillId);
        return new Exposer(true,md5,seckillId);
    }

    private String getMd5(long seckillId){
        String base = seckillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    public SeckillExecution executeSeckill(long seckllId, long userPhone, String md5) throws SeckillException, SeckillCloseException, RepeatKillException {
        return null;
    }
}
