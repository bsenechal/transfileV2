package com.transfile.transcode;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ITranscodeRepository extends CrudRepository<Transcode, Long> {

    @Override
    public List<Transcode> findAll();
}
