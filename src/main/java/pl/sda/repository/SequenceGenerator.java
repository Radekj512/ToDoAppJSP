package pl.sda.repository;

import java.util.concurrent.atomic.AtomicLong;

public class SequenceGenerator {
    private static AtomicLong value = new AtomicLong(0);

    public static Long getNextValue(){
        return value.getAndIncrement();
    }
}
