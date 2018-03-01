/*
 *
 */
package com.transfile.transcode;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfile.logtype.LogType;

@Service
@Transactional
public class TranscodeService implements ITranscodeService {
    
    /**
     * Map de toutes les valeurs de transcodage.
     */
    private final Map<LogType, Map<VariableType, Map<String, String>>> transcodageContainer = new EnumMap<>(LogType.class);
    
    @Autowired
    private ITranscodeRepository transcodeRepository;
    
    @Override
    public String getChargebackNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.chargeback, variableType, valeurDB);
    }
    
    @Override
    public String getMatchingNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.matching, variableType, valeurDB);
    }
    
    @Override
    public String getOperationNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.operation, variableType, valeurDB);
    }
    
    @Override
    public String getSOBRequestNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.SOB_request, variableType, valeurDB);
    }
    
    @Override
    public String getSOBResponseNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.SOB_response, variableType, valeurDB);
    }
    
    @Override
    public String getSUBRequestNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.SUB_request, variableType, valeurDB);
    }
    
    @Override
    public String getSUBResponseNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.SUB_response, variableType, valeurDB);
    }
    
    @Override
    public String getTransactionNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.transaction, variableType, valeurDB);
    }
    
    private String getValeurNormalise(final LogType logType, final VariableType variableType, final String valeurDB) {
        
        if (valeurDB == null) {
            return null;
        }
        
        final Map<VariableType, Map<String, String>> logTypes = transcodageContainer.get(logType);
        
        if (logTypes != null) {
            final Map<String, String> variableTypes = logTypes.get(variableType);
            
            if (variableTypes != null) {
                final String result = variableTypes.get(valeurDB);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
    
    @Override
    public String getWalletNormalise(final String valeurDB, final VariableType variableType) {
        return getValeurNormalise(LogType.wallet, variableType, valeurDB);
    }
    
    @PostConstruct
    private void initialize() {
        final List<Transcode> transcodes = transcodeRepository.findAll();
        
        for (final Transcode transcode : transcodes) {
            Map<VariableType, Map<String, String>> logtypes = transcodageContainer.get(transcode.getLogType());
            if (logtypes == null) {
                logtypes = new EnumMap<>(VariableType.class);
                transcodageContainer.put(transcode.getLogType(), logtypes);
            }
            
            Map<String, String> variableTypes = logtypes.get(transcode.getVariableType());
            if (variableTypes == null) {
                variableTypes = new HashMap<>();
                logtypes.put(transcode.getVariableType(), variableTypes);
            }
            variableTypes.put(transcode.getDbValue(), transcode.getConfValue());
        }
    }
    
}
