package com.alekseysamoylov.bootsalad.service;


import com.alekseysamoylov.bootsalad.annotation.CustomTransactional;
import com.alekseysamoylov.bootsalad.annotation.InjectRandomInt;

@CustomTransactional
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 1, max = 5)
    private int repeat;

    private String quote;

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public void sayQuote() {
        System.out.println("message = " + quote);

        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + quote);
        }
    }

}
