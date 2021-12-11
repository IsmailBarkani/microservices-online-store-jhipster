package com.mycompany.store.cucumber;

import com.mycompany.store.ProductorderApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ProductorderApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
