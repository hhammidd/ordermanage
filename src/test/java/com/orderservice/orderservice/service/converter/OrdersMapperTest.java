package com.orderservice.orderservice.service.converter;


import com.orderservice.orderservice.service.SampleCreationUtil;
import com.orderservice.orderservice.web.dto.output.OrdersTo;
import com.orderservice.orderservice.model.dbEntity.Customer;
import com.orderservice.orderservice.model.dbEntity.Orders;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdersMapperTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static OrdersMapper om;
    private static OrdersTo ordersTo;
    public static Orders orders;

    @BeforeClass
    public static void startup() {
        om = new OrdersMapper();
        ordersTo = new OrdersTo();
        orders = new Orders();
    }

    @Test
    public void convertToDtoTest() throws Exception {

        Date date = DATE_FORMAT.parse("2017-01-01");
        orders = SampleCreationUtil.createOrders();

        OrdersTo convetedDto = om.convertToDto(orders);
        assertEquals(new Long(10), convetedDto.getCustomerId());
        assertEquals( date, convetedDto.getRegistrationDate());
        assertEquals(new Long(11), convetedDto.getId());
        assertNull(convetedDto.getOrdersItems());

    }


    @Test
    public void convertToDomainTest() throws Exception {

        ordersTo = SampleCreationUtil.createOrdersTo();

        Orders ordersAfter = om.convertToDomain(ordersTo);
        assertEquals(new Long(11), ordersAfter.getId());
        assertEquals(new Long(10), ordersAfter.getCustomer().getId());
        assertNull(ordersAfter.getRegistrationDate());
    }
}
