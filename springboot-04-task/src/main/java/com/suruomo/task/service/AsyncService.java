package com.suruomo.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author suruomo
 * @date 2020/7/23 9:01
 * @description:
 */

@Service
public class AsyncService {

    @Async
    public void hello(){
        System.out.println(2);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(3);
    }
}
