package ru.hse.spb.keylogger;

import org.jooq.DSLContext;
import org.springframework.transaction.support.TransactionTemplate;
import ru.hse.spb.keylogger.model.Diff;

import javax.inject.Inject;

public class WorklogRepository {
    private final TransactionTemplate transactionTemplate;
    private final DSLContext dslContext;


    @Inject
    public WorklogRepository(final TransactionTemplate transactionTemplate,
                             final DSLContext dslContext) {
        this.transactionTemplate = transactionTemplate;
        this.dslContext = dslContext;

    }

    public boolean addDiff(final Diff diff) {
        return true;
    }
}
