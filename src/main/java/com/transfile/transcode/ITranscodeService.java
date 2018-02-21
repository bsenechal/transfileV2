package com.transfile.transcode;

public interface ITranscodeService {
    public String getChargebackNormalise(String valeurDB) throws TranscodeException;

    public String getMatchingNormalise(String valeurDB) throws TranscodeException;

    public String getOperationNormalise(String valeurDB) throws TranscodeException;

    public String getSOBRequestNormalise(String valeurDB) throws TranscodeException;
    
    public String getSOBResponseNormalise(String valeurDB) throws TranscodeException;

    public String getSUBNormalise(String valeurDB) throws TranscodeException;

    public String getTransactionNormalise(String valeurDB) throws TranscodeException;

    public String getWalletNormalise(String valeurDB) throws TranscodeException;
}
