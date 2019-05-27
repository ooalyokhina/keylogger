package ru.hse.spb.keylogger;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.hse.spb.keylogger.db.tables.Worker;

import java.sql.Connection;
import java.sql.DriverManager;

@Repository
public class UserRepository {
    String user = "keylogger_user";
    String pass = "password";
    String url = "jdbc:postgresql://localhost:5432/keylogger";

    public UserRepository() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // Create a context for your database
            DSLContext ctx = DSL.using(conn, SQLDialect.POSTGRES_9_4);
            ctx.insertInto(Worker.WORKER)
                    .columns(Worker.WORKER.LOGIN, Worker.WORKER.PASSWORD, Worker.WORKER.TOKEN)
                    .values("a", "b", "c")
                    .execute();
            // Do something useful ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
