/*
 *
 */
package com.transfile.stats;

import com.transfile.logtype.LogType;

/**
 */
@FunctionalInterface
public interface IStatsService {

    public void checkNbLines(final LogType logType, final Integer nbLines) throws StatsException;
}
