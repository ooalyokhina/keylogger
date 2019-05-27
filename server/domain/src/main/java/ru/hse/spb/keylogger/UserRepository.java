package ru.hse.spb.keylogger;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final DSLContext create;

    @Autowired
    public UserRepository(DSLContext dslContext) {
        this.create = dslContext;
    }
}
