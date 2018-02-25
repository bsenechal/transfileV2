/*
 * 
 */
package com.transfile.client;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.transfile.configuration.Configuration;

/**
 * Client bean
 *
 */
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
    private List<Configuration> configurations;

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return the clientId
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * @return the environment
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * @return the merchantFtp
     */
    public String getMerchantFtp() {
        return merchantFtp;
    }

    /**
     * @return the merchantId
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * @return the protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @return the sipsAlias
     */
    public String getSipsAlias() {
        return sipsAlias;
    }

    /**
     * @param bankName
     *            the bankName to set
     */
    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    /**
     * @param clientId
     *            the clientId to set
     */
    public void setClientId(final Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * @param environment
     *            the environment to set
     */
    public void setEnvironment(final String environment) {
        this.environment = environment;
    }

    /**
     * @param merchantFtp
     *            the merchantFtp to set
     */
    public void setMerchantFtp(final String merchantFtp) {
        this.merchantFtp = merchantFtp;
    }

    /**
     * @param merchantId
     *            the merchantId to set
     */
    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @param protocol
     *            the protocol to set
     */
    public void setProtocol(final String protocol) {
        this.protocol = protocol;
    }

    /**
     * @param sipsAlias
     *            the sipsAlias to set
     */
    public void setSipsAlias(final String sipsAlias) {
        this.sipsAlias = sipsAlias;
    }

}
