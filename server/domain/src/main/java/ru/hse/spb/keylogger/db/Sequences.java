/*
 * This file is generated by jOOQ.
 */
package ru.hse.spb.keylogger.db;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.worker_id_seq</code>
     */
    public static final Sequence<Long> WORKER_ID_SEQ = new SequenceImpl<Long>("worker_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.worklog_id_seq</code>
     */
    public static final Sequence<Long> WORKLOG_ID_SEQ = new SequenceImpl<Long>("worklog_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
