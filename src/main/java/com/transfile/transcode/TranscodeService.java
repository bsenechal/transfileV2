package com.transfile.transcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfile.log_type.LogType;

@Service
@Transactional
public class TranscodeService implements ITranscodeService {

    /**
     * Map de toutes les valeurs de transcodage.
     */
    private final Map<LogType, Map<String, String>> transcodageContainer = new HashMap<>();

    @Autowired
    private ITranscodeRepository transcodeRepository;

    @Override
    public String getChargebackNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.chargeback, valeurDB);
    }

    @Override
    public String getMatchingNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.matching, valeurDB);
    }

    @Override
    public String getOperationNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.operation, valeurDB);
    }

    @Override
    public String getSOBRequestNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.SOB_request, valeurDB);
    }
    
    @Override
    public String getSOBResponseNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.SOB_response, valeurDB);
    }

    @Override
    public String getSUBRequestNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.SUB_request, valeurDB);
    }

    @Override
    public String getSUBResponseNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.SUB_response, valeurDB);
    }

    
    @Override
    public String getTransactionNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.transaction, valeurDB);
    }

    private String getValeurNormalise(final LogType logType, final String valeurDB) throws TranscodeException {

        if (valeurDB == null) {
            return null;
        }

        final Map<String, String> logTypes = transcodageContainer.get(logType);

        if (logTypes != null) {
            return logTypes.get(valeurDB);
        }

        throw new TranscodeException("LogType : " + logType.getValue() + ": la valeur " + valeurDB
                + " n'a pas de correspondence normalisée.");
    }

    @Override
    public String getWalletNormalise(final String valeurDB) throws TranscodeException {
        return getValeurNormalise(LogType.wallet, valeurDB);
    }

    @PostConstruct
    private void initialize() {
        final List<Transcode> transcodages = transcodeRepository.findAll();

        for (final Transcode transcodage : transcodages) {

            Map<String, String> logtypes = transcodageContainer.get(transcodage.getLogType());

            if (logtypes == null) {
                logtypes = new HashMap<>();
                transcodageContainer.put(transcodage.getLogType(), logtypes);
            }

            logtypes.put(transcodage.getDbValue(), transcodage.getConfValue());
        }
    }

}
