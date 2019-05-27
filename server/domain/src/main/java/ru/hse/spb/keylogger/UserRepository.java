package ru.hse.spb.keylogger;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;
import ru.hse.spb.keylogger.db.tables.Worker;

import javax.inject.Inject;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    //TODO вот это все в properties
    String user = "keylogger_user";
    String pass = "password";
    String url = "jdbc:postgresql://localhost:5432/keylogger";

    private final TransactionTemplate transactionTemplate;
    private final DSLContext dslContext;

    @Inject
    public UserRepository(final TransactionTemplate transactionTemplate,
                          final DSLContext dslContext) {
        this.transactionTemplate = transactionTemplate;
        this.dslContext = dslContext;

    }

    public Optional<String> getToken(final String login) {
        List<String> tokens = transactionTemplate.execute(x ->
                dslContext.select(Worker.WORKER.TOKEN)
                        .from(Worker.WORKER)
                        .where(Worker.WORKER.LOGIN.eq(login))
                        .fetch(Worker.WORKER.TOKEN)
        );
        if (tokens.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(tokens.get(0));
    }

    public Optional<Long> getIdByToken(final String token) {
        List<Long> tokens = transactionTemplate.execute(x ->
                dslContext.select(Worker.WORKER.ID)
                        .from(Worker.WORKER)
                        .where(Worker.WORKER.TOKEN.eq(token))
                        .fetch(Worker.WORKER.ID)
        );
        if (tokens.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(tokens.get(0));
        }
    }

    public String addUser(final String login,
                          final String password) {
        final Optional<String> tokenOpt = getToken(login);
        return tokenOpt.orElseGet(() -> transactionTemplate.execute(x -> {
                    final String token = generateToken();
                    dslContext.insertInto(Worker.WORKER)
                            .columns(Worker.WORKER.LOGIN, Worker.WORKER.PASSWORD, Worker.WORKER.TOKEN)
                            .values(login, password, token)
                            .execute();
                    return token;
                }
        ));
    }

    private String generateToken() {
        String token;
        do {
            SecureRandom random = new SecureRandom();
            byte bytes[] = new byte[20];
            random.nextBytes(bytes);
            token = bytes.toString();
        } while (getIdByToken(token).isPresent());
        return token;
    }


}
