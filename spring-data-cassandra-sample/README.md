CREATE KEYSPACE cooldatasoft WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

create table sample (id bigint PRIMARY KEY , name varchar, surname varchar );

CREATE INDEX ON sample (name) ;


