package com.cooldatasoft.repository;

import com.cooldatasoft.data.SampleEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import javax.inject.Named;
import java.util.List;

@Named
public interface SampleRepository extends CassandraRepository<SampleEntity> {


    @Query("SELECT count(*) FROM sample")
    public long testMethod();

    @Query("SELECT * FROM sample WHERE name = ?0")
    public List<SampleEntity> findByName(String testName);
}
