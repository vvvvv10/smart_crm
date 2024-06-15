package com.smart.crm.customer;

import com.smart.crm.domain.customer.Customer;
import com.smart.crm.domain.customer.gateway.CustomerGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CustomerGatewayImpl implements CustomerGateway {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer getByById(String customerId) {
        return null;
    }

    @Override
    public Customer add(Customer customer) {
        com.smart.crm.customer.Customer customerDO = new com.smart.crm.customer.Customer();
        BeanUtils.copyProperties(customer, customerDO);
        customerDO.setIsDeleted(false);
        customerDO.setCreateTime(new Date());
        customerDO.setUpdateTime(new Date());
        customerMapper.insertSelective(customerDO);
        return null;
    }

    @Override
    public List<Customer> getAllCustomers(Customer customer) {
        CustomerExample customerExample = new CustomerExample();
        List<com.smart.crm.customer.Customer> customers = customerMapper.selectByExample(customerExample);

        List<Customer> list = new ArrayList<>();
        customers.stream().forEach(source -> {
            Customer target = new Customer();
            BeanUtils.copyProperties(source, target);
            list.add(target);
        });

        return list;
    }
}
