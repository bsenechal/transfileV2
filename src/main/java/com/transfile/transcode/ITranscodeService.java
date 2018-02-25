/*
 * 
 */
package com.transfile.transcode;

public interface ITranscodeService {
    public String getChargebackNormalise(final String valeurDB, VariableType variableType);

    public String getMatchingNormalise(final String valeurDB, VariableType variableType);

    public String getOperationNormalise(final String valeurDB, VariableType variableType);

    public String getSOBRequestNormalise(final String valeurDB, VariableType variableType);

    public String getSOBResponseNormalise(final String valeurDB, VariableType variableType);

    public String getSUBRequestNormalise(final String valeurDB, VariableType variableType);

    public String getSUBResponseNormalise(final String valeurDB, VariableType variableType);

    public String getTransactionNormalise(final String valeurDB, VariableType variableType);

    public String getWalletNormalise(final String valeurDB, VariableType variableType);
}
