package org.example.order.processing;

import org.example.order.Ordenation;

import java.util.Date;
import java.util.Random;

public class Processing  implements Runnable{

    private Data data;

    public Processing(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Starting processing thread");
        data.orderArray();
    }

}
