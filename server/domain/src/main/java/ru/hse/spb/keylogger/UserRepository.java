package ru.hse.spb.keylogger;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import javax.inject.Inject;

@Repository
public class UserRepository {
    //TODO вот это все в properties
    String user = "keylogger_user";
    String pass = "password";
    String url = "jdbc:postgresql://localhost:5432/keylogger";

    @Inject
    public UserRepository(TransactionTemplate transactionTemplate,
                          DSLContext dslContext) {
//        transactionTemplate.execute(x ->
//                dslContext.insertInto(Worker.WORKER)
//                        .columns(Worker.WORKER.LOGIN, Worker.WORKER.PASSWORD, Worker.WORKER.TOKEN)
//                        .values("a1111", "b1111", "c1111")
//                        .execute()
        //      );
    }


}
