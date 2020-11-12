package com.zxin.java.spring.redisson;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author zxin
 */
@Service
public class DLockDemoService {

    @DLock("#hotelId +':'+ #roomType +':'+ #ratePlanCode")
    public void demo1(String hotelId, String roomType, String ratePlanCode){
        System.out.println(Thread.currentThread().getName() + ":" + LocalDateTime.now().toString());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()  + ":end:" + LocalDateTime.now().toString());
    }

    @DLock("#dKey.name +':'+ #dKey.start +':'+ #dKey.age")
    public void demo2(DKey dKey){
        System.out.println(Thread.currentThread().getName() + ":" + LocalDateTime.now().toString());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()  + ":end:" + LocalDateTime.now().toString());
    }

}
