package com.orderseat.test;

import com.orderseat.facade.OrderSeatService;
import com.orderseat.facade.SeatInfoService;
import com.orderseat.facade.dto.OrderSeatDto;
import com.orderseat.facade.request.OrderSeatRequest;
import org.apache.thrift.TException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class OrderSeatClient {
    public static void main(String[] args) throws TException {
        OrderSeatDto orderSeatDto = new OrderSeatDto();
        orderSeatDto.setId("1");
        orderSeatDto.setStartTime("201912240800");
        orderSeatDto.setEndTime("201912241000");
        orderSeatDto.setUserId("0");
        List<OrderSeatDto> list = new ArrayList<OrderSeatDto>();
        list.add(orderSeatDto);
        OrderSeatRequest orderSeatRequest = new OrderSeatRequest();
        orderSeatRequest.setOrderSeatDtoList(list);
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");

        OrderSeatService.Iface client = (OrderSeatService.Iface) beanFactory.getBean("OrderSeatClient");
        client.orderSeat(orderSeatRequest);
    }
}
