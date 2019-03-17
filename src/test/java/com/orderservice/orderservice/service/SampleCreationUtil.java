package com.orderservice.orderservice.service;

import com.orderservice.orderservice.model.dbEntity.Customer;
import com.orderservice.orderservice.model.dbEntity.Orders;
import com.orderservice.orderservice.model.dbEntity.OrdersItem;
import com.orderservice.orderservice.model.dbEntity.Production;
import com.orderservice.orderservice.web.dto.OrdersItemTo;
import com.orderservice.orderservice.web.dto.output.OrdersTo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleCreationUtil {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static OrdersItem createOrderItem() {

        OrdersItem oi = new OrdersItem();

        oi.setId(1L);
        Orders orders = new Orders();
        orders.setId(1L);
        oi.setOrders(null);
        Production production = new Production();
        production.setId(5L);
        oi.setProduction(production);
        oi.setQuantity(100);

        return oi;
    }

    public static OrdersItemTo createOrderItemTo() {

        OrdersItemTo oit = new OrdersItemTo();

        oit.setId(1L);
        oit.setProductionId(1L);
        oit.setQuantity(200);

        return oit;
    }

    public static Orders createOrders() throws Exception {

        Orders o = new Orders();
        Date date = DATE_FORMAT.parse("2017-01-01");

        o.setId(11L);
        o.setRegistrationDate(date);
        Customer c = new Customer();
        c.setId(10L);
        c.setUsername("francesco");
        c.setPhoneNo("23332332");
        o.setCustomer(c);

        return o;
    }


    public static OrdersTo createOrdersTo() throws Exception {

        OrdersTo oTo = new OrdersTo();
        Date date = DATE_FORMAT.parse("2017-01-01");

        oTo.setId(11L);
        oTo.setCustomerId(10L);
        oTo.setRegistrationDate(date);
        oTo.setOrdersItems(null);

        return oTo;
    }
}
