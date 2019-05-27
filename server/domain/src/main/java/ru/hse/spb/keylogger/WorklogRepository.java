package ru.hse.spb.keylogger;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;
import ru.hse.spb.keylogger.db.tables.Worklog;
import ru.hse.spb.keylogger.model.Diff;

import javax.inject.Inject;

@Repository
public class WorklogRepository {
    private final TransactionTemplate transactionTemplate;
    private final DSLContext dslContext;
    private static final ObjectMapper _J = new ObjectMapper();

    @Inject
    public WorklogRepository(final TransactionTemplate transactionTemplate,
                             final DSLContext dslContext) {
        this.transactionTemplate = transactionTemplate;
        this.dslContext = dslContext;

    }

    public String toString(Object o) {
        String value = "";
        try {
            value = _J.writeValueAsString(o);
        } catch (Exception ignored) {
        }
        return value;
    }

    public Long addDiff(final Diff diff) {
        final String changes = toString(diff.getChanges());
        final String params = toString(diff.getParams());
        return transactionTemplate.execute(x -> {
                    Long id = IdGenerator.getId();
                    dslContext.insertInto(Worklog.WORKLOG)
                            .columns(Worklog.WORKLOG.ID,
                                    Worklog.WORKLOG.CHANGES,
                                    Worklog.WORKLOG.ACTION,
                                    Worklog.WORKLOG.FILE_NAME,
                                    Worklog.WORKLOG.PROJECT_NAME,
                                    Worklog.WORKLOG.PARAMS,
                                    Worklog.WORKLOG.WORKER_ID,
                                    Worklog.WORKLOG.TIMESTAMP)
                            .values(id,
                                    changes,
                                    diff.getAction(),
                                    diff.getFileName(),
                                    diff.getProjectName(),
                                    params,
                                    diff.getuserId(),
                                    diff.getTimestamp())
                            .execute();
                    return id;
                }
        );
    }
}
