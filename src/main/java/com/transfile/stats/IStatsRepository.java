/*
 *
 */
package com.transfile.stats;

import org.springframework.data.repository.CrudRepository;

public interface IStatsRepository extends CrudRepository<Stats, Long> {

    public Stats findByLogType(String logType);
}
