package bit.turing.ant_url.service;

import java.util.concurrent.atomic.AtomicLong;

public class IdService {
    private final AtomicLong SEQUENCE  = new AtomicLong(0);
    long lastTime;
    long epoch;
    int timeShift;
    int nodeShift;

    public IdService(){
        this.lastTime = -1L;
        this.epoch = 1767225600000L;
        this.timeShift = 16;
        this.nodeShift = 6;
    }

    public String nextID() {
        return nextID(1L);
    }

    public String nextID(long node){
        long nowTime = (System.currentTimeMillis() - this.epoch);

        if(nowTime == this.lastTime){
            this.SEQUENCE.incrementAndGet();
        } else {
            this.SEQUENCE.set(0);
        }

        this.lastTime = nowTime;

        //Deslocar bits para a esquerda, ex
        //+---------------------------------------------------------------+
        //| Timestamp (48 bits) | Node (10 bits) | SEQUENCE (6 bits) |
        //+---------------------------------------------------------------+
        //      <<16            |   <<6        |    sem deslocar
        long value = ((nowTime << this.timeShift) | (node << this.nodeShift) | SEQUENCE.get()) & Long.MAX_VALUE;

        System.out.println("nowTime: " + nowTime);
        System.out.println("nowTime: " + Long.toBinaryString(nowTime));

        System.out.println("value: " + value);

        return toBASE62(value);
    }

    private String toBASE62(Long value){
        String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder hash = new StringBuilder();

        while (value > 0L) {
            Integer baseId = (int) (value % 62) ;

            hash.append(BASE62.charAt(baseId));

            value /= 62L;
        }

        return hash.reverse().toString();
    }
}