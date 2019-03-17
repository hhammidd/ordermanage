package com.orderservice.orderservice.service.converter;


import com.orderservice.orderservice.service.SampleCreationUtil;
import com.orderservice.orderservice.web.dto.OrdersItemTo;
import com.orderservice.orderservice.model.dbEntity.Orders;
import com.orderservice.orderservice.model.dbEntity.OrdersItem;
import com.orderservice.orderservice.model.dbEntity.Production;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class OrdersItemMapperTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static OrdersItemMapper oim;

    @BeforeClass
    public static void startup() {
        oim = new OrdersItemMapper();
    }

    @Test
    public void convertToDtoTest() {

        OrdersItem ordersItem = SampleCreationUtil.createOrderItem();

        assertEquals(new Long(1), oim.convertToDto(ordersItem).getId());
        assertEquals(5, oim.convertToDto(ordersItem).getProductionId());
        assertEquals(100.00, oim.convertToDto(ordersItem).getQuantity(), 0.01);

    }

    @Test
    public void convertToDomainTest() {

        OrdersItemTo ordersItemTo = SampleCreationUtil.createOrderItemTo();

        assertEquals(new Long(1), oim.convertToDomain(ordersItemTo).getId());
        assertEquals(new Long(1), oim.convertToDomain(ordersItemTo).getProduction().getId());
        assertEquals(200, oim.convertToDomain(ordersItemTo).getQuantity(), 0.01);

    }
}
