package com.alibaba.demo.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.demo.api.CustomerServiceI;
import com.alibaba.demo.dto.CustomerAddCmd;
import com.alibaba.demo.dto.CustomerListByNameQry;
import com.alibaba.demo.dto.data.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        return "Hello, welcome to COLA world!";
    }

    @PostMapping(value = "/customer")
    public MultiResponse<CustomerDTO> listCustomerByName(@RequestBody CustomerListByNameQry qry){
        return customerService.listByCustomer(qry);
    }

    @PostMapping(value = "/addCustomer")
    public Response addCustomer(@RequestBody CustomerAddCmd cmd){
        return customerService.addCustomer(cmd);
    }
}
