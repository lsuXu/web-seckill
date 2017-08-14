package cn.xu.seckill.dto;

/**
 * 暴露秒杀地址DTO(数据传输层)
 */
public class Exposer {

    //是否开启秒杀
    private boolean exposed;

    //加密措施
    private String md5;

    //Id
    private long seckillId;

    //系统当前时间
    private long now;

    //开启时间
    private long state;

    //秒杀结束时间
    private long end;

    public Exposer(boolean exposed, long seckillId, long now, long state, long end) {
        this.exposed = exposed;
        this.now = now;
        this.state = state;
        this.end = end;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
