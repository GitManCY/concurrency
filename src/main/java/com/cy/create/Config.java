package com.cy.create;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.cy.create")
@EnableAsync
public class Config {

}
