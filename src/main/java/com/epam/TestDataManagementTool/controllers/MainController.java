package com.epam.TestDataManagementTool.controllers;

import com.epam.TestDataManagementTool.db.*;
import com.epam.TestDataManagementTool.models.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.IntStream;

import static com.epam.TestDataManagementTool.DataUtils.timestamp;
import static com.epam.TestDataManagementTool.DataUtils.timestampInt;

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

    /*
    TRUNCATE customers CASCADE
    TRUNCATE employees CASCADE
    TRUNCATE offices CASCADE
    TRUNCATE order_details CASCADE
    TRUNCATE orders CASCADE
    TRUNCATE payments CASCADE
    TRUNCATE product_lines CASCADE
    TRUNCATE products CASCADE
    */

    @PostMapping("/generate")
    public ModelAndView generateDatabase(@ModelAttribute("uiRequest") UiRequest uiRequest) {
        ModelAndView modelAndView = new ModelAndView();
        /*
        ProductLine -> Product
        */
        final List<ProductLine> productLines = IntStream.range(0, uiRequest.getProductLinesAmount())
                .mapToObj(i -> ProductLine.builder()
                        .productLine(timestampInt())
                        .build()).toList();
        productLineRepository.saveAll(productLines);
        final List<Product> products = IntStream.range(0, uiRequest.getProductsAmount())
                .mapToObj(i -> Product.builder()
                        .productCode(timestampInt())
                        .productLine(productLines.get(FAKER.random().nextInt(uiRequest.getProductLinesAmount())))
                        .build())
                .toList();
        productRepository.saveAll(products);
        /*
        Office -> Employee
        */
        final List<Office> offices = IntStream.range(0, uiRequest.getOfficesAmount())
                .mapToObj(i -> Office.builder()
                        .officeCode(Long.toString(timestamp()))
                        .build()).toList();
        officeRepository.saveAll(offices);
        final List<Employee> employees = IntStream.range(0, uiRequest.getEmployeesAmount())
                .mapToObj(i -> Employee.builder()
                        .employeeNumber(timestampInt())
                        .officeCode(offices.get(FAKER.random().nextInt(uiRequest.getOfficesAmount())))
                        .build())
                .toList();
        final List<Employee> employeesResultList = employees.stream()
                .peek(emp -> emp.setReportsTo(employees.get(FAKER.random().nextInt(uiRequest.getEmployeesAmount())))).toList();
        employeeRepository.saveAll(employeesResultList);
        /*
        Customer -> Payment
        */
        final List<Customer> customers = IntStream.range(0, uiRequest.getCustomersAmount())
                .mapToObj(i -> Customer.builder()
                        .customerNumber(timestampInt())
                        .salesRepEmployeeNumber(employees.get(FAKER.random().nextInt(uiRequest.getEmployeesAmount())))
                        .build())
                .toList();
        customersRepository.saveAll(customers);
        final List<Payment> payments = IntStream.range(0, uiRequest.getPaymentsAmount())
                .mapToObj(i -> Payment.builder()
                        .customerNumber(customers.get(FAKER.random().nextInt(uiRequest.getCustomersAmount())))
                        .checkNumber(timestampInt())
                        .build())
                .toList();
        paymentRepository.saveAll(payments);
        /*
        Order -> OrderDetails
        */
        final List<Order> orders = IntStream.range(0, uiRequest.getOrdersAmount())
                .mapToObj(i -> Order.builder()
                        .customerNumber(customers.get(FAKER.random().nextInt(uiRequest.getCustomersAmount())))
                        .orderNumber(timestampInt())
                        .build())
                .toList();
        orderRepository.saveAll(orders);
        final List<OrderDetails> orderDetails = IntStream.range(0, uiRequest.getOrderDetailsAmount())
                .mapToObj(i -> OrderDetails.builder()
                        .orderNumber(orders.get(i))
                        .productCode(products.get(FAKER.random().nextInt(uiRequest.getProductsAmount())))
                        .build())
                .toList();
        orderDetailsRepository.saveAll(orderDetails);
        modelAndView.setViewName("table");
        return modelAndView;
    }

}
