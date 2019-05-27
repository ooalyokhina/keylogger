/*
 * This file is generated by jOOQ.
 */
package ru.hse.spb.keylogger.db;


import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import ru.hse.spb.keylogger.db.tables.SchemaVersion;
import ru.hse.spb.keylogger.db.tables.Worker;
import ru.hse.spb.keylogger.db.tables.Worklog;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index SCHEMA_VERSION_CURRENT_VERSION_INDEX = Indexes0.SCHEMA_VERSION_CURRENT_VERSION_INDEX;
    public static final Index SCHEMA_VERSION_PRIMARY_KEY = Indexes0.SCHEMA_VERSION_PRIMARY_KEY;
    public static final Index SCHEMA_VERSION_SCRIPT_UNIQUE = Indexes0.SCHEMA_VERSION_SCRIPT_UNIQUE;
    public static final Index IDX_WORKER__LOGIN = Indexes0.IDX_WORKER__LOGIN;
    public static final Index IDX_WORKER__TOKEN = Indexes0.IDX_WORKER__TOKEN;
    public static final Index WORKER_LOGIN_KEY = Indexes0.WORKER_LOGIN_KEY;
    public static final Index WORKER_PKEY = Indexes0.WORKER_PKEY;
    public static final Index IDX_WORKLOG__WORKER_ID = Indexes0.IDX_WORKLOG__WORKER_ID;
    public static final Index WORKLOG_PKEY = Indexes0.WORKLOG_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index SCHEMA_VERSION_CURRENT_VERSION_INDEX = Internal.createIndex("schema_version_current_version_index", SchemaVersion.SCHEMA_VERSION, new OrderField[] { SchemaVersion.SCHEMA_VERSION.CURRENT_VERSION }, false);
        public static Index SCHEMA_VERSION_PRIMARY_KEY = Internal.createIndex("schema_version_primary_key", SchemaVersion.SCHEMA_VERSION, new OrderField[] { SchemaVersion.SCHEMA_VERSION.VERSION }, true);
        public static Index SCHEMA_VERSION_SCRIPT_UNIQUE = Internal.createIndex("schema_version_script_unique", SchemaVersion.SCHEMA_VERSION, new OrderField[] { SchemaVersion.SCHEMA_VERSION.SCRIPT }, true);
        public static Index IDX_WORKER__LOGIN = Internal.createIndex("idx_worker__login", Worker.WORKER, new OrderField[] { Worker.WORKER.LOGIN }, false);
        public static Index IDX_WORKER__TOKEN = Internal.createIndex("idx_worker__token", Worker.WORKER, new OrderField[] { Worker.WORKER.TOKEN }, false);
        public static Index WORKER_LOGIN_KEY = Internal.createIndex("worker_login_key", Worker.WORKER, new OrderField[] { Worker.WORKER.LOGIN }, true);
        public static Index WORKER_PKEY = Internal.createIndex("worker_pkey", Worker.WORKER, new OrderField[] { Worker.WORKER.ID }, true);
        public static Index IDX_WORKLOG__WORKER_ID = Internal.createIndex("idx_worklog__worker_id", Worklog.WORKLOG, new OrderField[] { Worklog.WORKLOG.WORKER_ID }, false);
        public static Index WORKLOG_PKEY = Internal.createIndex("worklog_pkey", Worklog.WORKLOG, new OrderField[] { Worklog.WORKLOG.ID }, true);
    }
}
