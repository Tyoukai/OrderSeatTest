package com.orderseat.test;

import com.orderseat.facade.OrderSeatService;
import com.orderseat.facade.dto.OrderSeatDto;
import com.orderseat.facade.request.OrderSeatRequest;
import com.orderseat.facade.response.OrderSeatResponse;
import org.apache.thrift.TException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class OrderSeatClient {
    public static void main(String[] args) throws TException {
        OrderSeatDto orderSeatDto = new OrderSeatDto();
        orderSeatDto.setId("1");
        orderSeatDto.setStartTime("201912270800");
        orderSeatDto.setEndTime("201912271000");
        orderSeatDto.setUserId("0");
        List<OrderSeatDto> list = new ArrayList<OrderSeatDto>();
        list.add(orderSeatDto);
        OrderSeatRequest orderSeatRequest = new OrderSeatRequest();
        orderSeatRequest.setOrderSeatDtoList(list);
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");

        OrderSeatService.Iface client = (OrderSeatService.Iface) beanFactory.getBean("OrderSeatClient");
        OrderSeatResponse orderSeatResponse = client.orderSeat(orderSeatRequest);
        System.out.println(orderSeatResponse.seatResult);
    }
}
