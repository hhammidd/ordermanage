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

    @BeforeClass
    public static void startup() {
        om = new OrdersMapper();
    }

    @Test
    public void convertToDtoTest() throws Exception {

        Date date = DATE_FORMAT.parse("2017-01-01");
        Orders orders = SampleCreationUtil.createOrders();

        assertEquals(new Long(10), om.convertToDto(orders).getCustomerId());
        assertEquals( date, om.convertToDto(orders).getRegistrationDate());
        assertEquals(new Long(11), om.convertToDto(orders).getId());
        assertNull(om.convertToDto(orders).getOrdersItems());

    }


    @Test
    public void convertToDomainTest() throws Exception {

        OrdersTo ordersTo = SampleCreationUtil.createOrdersTo();

        assertEquals(new Long(11), om.convertToDomain(ordersTo).getId());
        assertEquals(new Long(10), om.convertToDomain(ordersTo).getCustomer().getId());
        assertNull(om.convertToDomain(ordersTo).getRegistrationDate());
    }
}
