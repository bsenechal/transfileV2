/*
 *
 */
package com.transfile.stats;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.transfile.configuration.IConfigurationService;
import com.transfile.logtype.LogType;

/**
 *
 * Implements {@link IConfigurationService}
 *
 */
@Service
@Transactional
public class StatsService implements IStatsService {
    private static final Logger LOGGER = Logger.getLogger(StatsService.class);

    @Autowired
    private IStatsRepository statsRepository;

    @Override
    public void checkNbLines(final LogType logType, final Integer nbOfLines) throws StatsException {
        Assert.notNull(nbOfLines, "NbLines should not be null");

        Stats stats = statsRepository.findByLogType(logType.getValue());

        Assert.notNull(stats, "Stats should not be null");
        Assert.notNull(stats.getPreviousValue(), "Previous value should not be null");
        Assert.notNull(stats.getDeltaWarning(), "Delta warning should not be null");
        Assert.notNull(stats.getDeltaError(), "Delta error should not be null");

        if (Math.abs(stats.getPreviousValue() - nbOfLines) > stats.getDeltaWarning() ) {
            LOGGER.warn("[" + logType + "] The number of lines seems not to be correct");
        } else if (Math.abs(stats.getPreviousValue() - nbOfLines) > stats.getDeltaError() ) {
            LOGGER.error("[" + logType + "] The number of lines is not correct");
            throw new StatsException("[" + logType + "] The number of lines is not correct");
        }

        stats.setPreviousValue(nbOfLines);
        statsRepository.save(stats);
    }
}
