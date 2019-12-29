package com.orderseat.test;

import com.orderseat.facade.SeatInfoService;
import com.orderseat.facade.dto.SeatInfoDto;
import com.orderseat.facade.request.SeatInfoRequest;
import com.orderseat.facade.response.SeatInfoResponse;
import org.apache.thrift.TException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: tyoukai
 * @date: 2019-12-14 19:37
 * @description: 占座测试类
 * @version: v1.0
 */
public class SeatInfoClient {
    public static void main(String[] args) throws TException {
        SeatInfoDto seatInfoDto = new SeatInfoDto();
        // 座位id
//        seatInfoDto.setId("1");
        // 建筑id
        seatInfoDto.setBuildingId("2");
        // 楼层
        seatInfoDto.setFloorId("3");
        // 座位类型
        seatInfoDto.setSeatType("1");

        SeatInfoRequest seatInfoRequest = new SeatInfoRequest();
        seatInfoRequest.setSeatInfoDto(seatInfoDto);
        // 座位开始位置
        seatInfoRequest.setPageNum(1);
        // 总共返回的条数
        seatInfoRequest.setPageSize(1);

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");

        SeatInfoService.Iface client = (SeatInfoService.Iface) beanFactory.getBean("SeatInfoClient");

        // 查询到的座位信息
//        SeatInfoResponse seatInfoResponse = client.search(seatInfoRequest);
//        SeatInfoResponse seatInfoResponse = client.deleteSeat(seatInfoRequest);
        SeatInfoResponse seatInfoResponse = client.add(seatInfoRequest);

        List<SeatInfoDto> list = seatInfoResponse.getSeatInfoDtoList();

        for (SeatInfoDto seatInfoDto1 : list) {
            System.out.println("座位id：" + seatInfoDto1.getId());
            System.out.println("建筑id：" + seatInfoDto1.getBuildingId());
            System.out.println("楼层id：" + seatInfoDto1.getFloorId());
            System.out.println("座位类型：" + seatInfoDto1.getSeatType());
            System.out.println("座位描述：" + seatInfoDto1.getDesc());

        }
        System.out.println("座位状态：" + seatInfoResponse.getResultCode());
        System.out.println("座位描述：" + seatInfoResponse.getDesc());

    }
}
