package org.example.order.processing;

public class ProcessingV2 implements Runnable{

    private DataV2 data;

    public ProcessingV2(DataV2 data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.orderArray();
    }

}
