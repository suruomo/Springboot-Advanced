package com.suruomo.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author suruomo
 * @date 2020/7/24 19:00
 * @description:
 */
@Component
@Service
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "厉害了我的锅";
    }
}
