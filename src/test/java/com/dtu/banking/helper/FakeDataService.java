package com.dtu.banking.helper;

import com.dtu.banking.customer.domain.Customer;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
public class FakeDataService {

    private Faker faker;

    @PostConstruct
    private void fill() {
        this.faker = new Faker(new Locale("en-US"));
    }

    public Customer createCustomer(String phone) {
        return new Customer(faker.idNumber().hashCode(), faker.name().name(), phone, faker.address().fullAddress());
    }
}
