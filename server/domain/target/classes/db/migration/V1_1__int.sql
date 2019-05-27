create table worker (
  id bigserial  primary key,
  login varchar(96) not null unique ,
  password varchar(96) not null,
  token varchar(96)not null
);

create index idx_worker__login on worker(login);
create index idx_worker__token on worker(token);


create table worklog (
  id bigserial primary key,
  changes jsonb,
  file_name text not null,
  project_name text not null,
  timestamp bigint not null,
  action text,
  params jsonb,
  worker_id bigint not null
);

create index idx_worklog__worker_id on worklog(worker_id);
create index idx_worklog__timestamp on worklog(timestamp);