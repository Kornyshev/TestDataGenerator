package com.something.TestDataManagementTool.controllers;

import com.github.javafaker.Faker;
import com.something.TestDataManagementTool.DataUtils;
import com.something.TestDataManagementTool.db.*;
import com.something.TestDataManagementTool.models.Result;
import com.something.TestDataManagementTool.models.UiRequest;
import com.something.TestDataManagementTool.models.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
public class MainController {

    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ProductLineRepository productLineRepository;
    @Autowired
    ProductRepository productRepository;

    private static final Faker FAKER = Faker.instance();

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("uiRequest", new UiRequest());
        return "index";
    }

    @PostMapping("/generate")
    public ModelAndView generateDatabase(@ModelAttribute("uiRequest") UiRequest uiRequest) {
        ModelAndView modelAndView = new ModelAndView();
        /*
        ProductLine -> Product
        */
        final List<ProductLine> productLines = IntStream.range(0, uiRequest.getProductLinesAmount())
                .mapToObj(i -> ProductLine.builder()
                        .productLine(DataUtils.timestampInt())
                        .build()).toList();
        productLineRepository.saveAll(productLines);
        final List<Product> products = IntStream.range(0, uiRequest.getProductsAmount())
                .mapToObj(i -> Product.builder()
                        .productCode(DataUtils.timestampInt())
                        .productLine(productLines.get(FAKER.random().nextInt(uiRequest.getProductLinesAmount())))
                        .build())
                .toList();
        productRepository.saveAll(products);
        /*
        Office -> Employee
        */
        final List<Office> offices = IntStream.range(0, uiRequest.getOfficesAmount())
                .mapToObj(i -> Office.builder()
                        .officeCode(Long.toString(DataUtils.timestamp()))
                        .build()).toList();
        officeRepository.saveAll(offices);
        final List<Employee> employees = IntStream.range(0, uiRequest.getEmployeesAmount())
                .mapToObj(i -> Employee.builder()
                        .employeeNumber(DataUtils.timestampInt())
                        .officeCode(offices.get(FAKER.random().nextInt(uiRequest.getOfficesAmount())))
                        .build())
                .toList();
        employeeRepository.saveAll(employees);
        employees.forEach(empl -> {
            final int nextInt = FAKER.random().nextInt(uiRequest.getEmployeesAmount());
            if (employees.get(nextInt).reportsTo != null && employees.get(nextInt).reportsTo.employeeNumber != empl.employeeNumber) {
                employeeRepository.updateReportsTo(empl.employeeNumber, employees.get(nextInt).employeeNumber);
            }
        });
        /*
        Customer -> Payment
        */
        final List<Customer> customers = IntStream.range(0, uiRequest.getCustomersAmount())
                .mapToObj(i -> Customer.builder()
                        .customerNumber(DataUtils.timestampInt())
                        .salesRepEmployeeNumber(employees.get(FAKER.random().nextInt(uiRequest.getEmployeesAmount())))
                        .build())
                .toList();
        customersRepository.saveAll(customers);
        paymentRepository.saveAll(IntStream.range(0, uiRequest.getPaymentsAmount())
                .mapToObj(i1 -> Payment.builder()
                        .customerNumber(customers.get(FAKER.random().nextInt(uiRequest.getCustomersAmount())))
                        .checkNumber(DataUtils.timestampInt())
                        .build())
                .toList());
        /*
        Order -> OrderDetails
        */
        final List<Order> orders = IntStream.range(0, uiRequest.getOrdersAmount())
                .mapToObj(i -> Order.builder()
                        .customerNumber(customers.get(FAKER.random().nextInt(uiRequest.getCustomersAmount())))
                        .orderNumber(DataUtils.timestampInt())
                        .build())
                .toList();
        orderRepository.saveAll(orders);
        orderDetailsRepository.saveAll(IntStream.range(0, uiRequest.getOrderDetailsAmount())
                .mapToObj(i -> OrderDetails.builder()
                        .orderNumber(orders.get(i))
                        .productCode(products.get(FAKER.random().nextInt(uiRequest.getProductsAmount())))
                        .build())
                .toList());
        modelAndView.addObject("resultOfGeneration", getResults());
        modelAndView.setViewName("result");
        return modelAndView;
    }

    private List<Result> getResults() {
        List<Result> results = new ArrayList<>();
        results.add(Result.builder().tableName("customers").amountOfRecords(customersRepository.findAll().size()).build());
        results.add(Result.builder().tableName("employees").amountOfRecords(employeeRepository.findAll().size()).build());
        results.add(Result.builder().tableName("offices").amountOfRecords(officeRepository.findAll().size()).build());
        results.add(Result.builder().tableName("order_details").amountOfRecords(orderDetailsRepository.findAll().size()).build());
        results.add(Result.builder().tableName("orders").amountOfRecords(orderRepository.findAll().size()).build());
        results.add(Result.builder().tableName("payments").amountOfRecords(paymentRepository.findAll().size()).build());
        results.add(Result.builder().tableName("product_lines").amountOfRecords(productLineRepository.findAll().size()).build());
        results.add(Result.builder().tableName("products").amountOfRecords(productRepository.findAll().size()).build());
        return results;
    }

}
