package com.transfile.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @Column(name = "CLIENT_ID", precision = 11, scale = 0)
    private Integer clientId;
    
    @Column(name = "MERCHANT_ID", length = 25)
    private String merchantId;
    
    @Column(name = "SIPS_ALIAS", length = 25)
    private String sipsAlias;
    
    @Column(name = "ENVIRONMENT", length = 25)
    private String environment;
    
    @Column(name = "PROTOCOL", length = 25)
    private String protocol;
    
    @Column(name = "BANK_NAME", length = 25)
    private String bankName;
    
    @Column(name = "MERCHANT_FTP", length = 25)
    private String merchantFtp;
    
    @OneToMany
    private List<Configuration> configurations ;
    
    /**
     * @return the clientId
     */
    public Integer getClientId() {
        return clientId;
    }
    
    /**
     * @param clientId
     *            the clientId to set
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
    
    /**
     * @return the merchantId
     */
    public String getMerchantId() {
        return merchantId;
    }
    
    /**
     * @param merchantId
     *            the merchantId to set
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    
    /**
     * @return the sipsAlias
     */
    public String getSipsAlias() {
        return sipsAlias;
    }
    
    /**
     * @param sipsAlias
     *            the sipsAlias to set
     */
    public void setSipsAlias(String sipsAlias) {
        this.sipsAlias = sipsAlias;
    }
    
    /**
     * @return the environment
     */
    public String getEnvironment() {
        return environment;
    }
    
    /**
     * @param environment
     *            the environment to set
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    
    /**
     * @return the protocol
     */
    public String getProtocol() {
        return protocol;
    }
    
    /**
     * @param protocol
     *            the protocol to set
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
    
    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }
    
    /**
     * @param bankName
     *            the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    /**
     * @return the merchantFtp
     */
    public String getMerchantFtp() {
        return merchantFtp;
    }
    
    /**
     * @param merchantFtp
     *            the merchantFtp to set
     */
    public void setMerchantFtp(String merchantFtp) {
        this.merchantFtp = merchantFtp;
    }
    
}
