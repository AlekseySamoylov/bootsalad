package com.alekseysamoylov.bootsalad.runner;

import com.alekseysamoylov.bootsalad.service.Quoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MainRunner implements CommandLineRunner {

    @Autowired
    private Quoter quoter;

    @Override
    public void run(String... args) throws Exception {
        quoter.sayQuote();
    }

}
