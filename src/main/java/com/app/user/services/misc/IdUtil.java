package com.app.user.services.misc;

import java.util.UUID;

public class IdUtil {

    private IdUtil() {

    }

    private static final String ID = UUID.randomUUID().toString();

    public static String getId() {
        return ID;
    }
}
