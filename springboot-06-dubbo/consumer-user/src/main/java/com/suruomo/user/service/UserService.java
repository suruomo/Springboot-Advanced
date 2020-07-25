package com.suruomo.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.suruomo.ticket.service.TicketService;
import org.springframework.stereotype.Service;


/**
 * @author suruomo
 * @date 2020/7/24 19:04
 * @description:
 */
@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了："+ticket);
    }

}
