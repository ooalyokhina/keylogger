package ru.hse.spb.keylogger;

import org.springframework.stereotype.Component;

public class IdGenerator {
    private static Long lastId = 0L;

    public static Long getId() {
        lastId++;
        return lastId;
    }
}
