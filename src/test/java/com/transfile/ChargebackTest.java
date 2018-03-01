package com.transfile;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.configuration.ConfigurationService;
import com.transfile.logtype.Chargeback;
import com.transfile.logtype.LogType;
import com.transfile.transcode.TranscodeService;
import com.transfile.transcode.VariableType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chargeback.class)
@AutoConfigureMockMvc
public class ChargebackTest {
    private final static String EXPECTED_RESULT = "ubz-chargeback.jri-report.BNP-1D-000000000000002-GunsNRoses.*:IMPAYES:ubzrock.ftp_b.:jri01.csv.${e_date}:atossftpr:::" + System.getProperty("line.separator");
    
    @Autowired
    private Chargeback chargeback;
    
    @MockBean
    private ConfigurationService configurationService;
    
    @MockBean
    private TranscodeService transcodeService;
    
    private Configuration configuration;
    
    private Client client;
    
    @Test
    public void testGetContent() {
        List<Configuration> configurations = new ArrayList<Configuration>();
        configurations.add(configuration);
        
        when(configurationService.findByLogType(LogType.chargeback.getValue())).thenReturn(configurations);
        
            when(transcodeService.getChargebackNormalise("csv", VariableType.EXT)).thenReturn(".CSV");
        when(transcodeService.getChargebackNormalise("yymmdd", VariableType.DATE_FORMAT)).thenReturn("${e_date}");
        when(transcodeService.getChargebackNormalise("sftp", VariableType.PROTOCOL)).thenReturn("atossftpr");
        when(transcodeService.getChargebackNormalise("BNP", VariableType.BANK_NAME)).thenReturn("BNP-1D");
        when(transcodeService.getChargebackNormalise(null, VariableType.DELETE)).thenReturn(null);
        when(transcodeService.getChargebackNormalise(null, VariableType.MULTIPLE)).thenReturn(null);
        
        Assert.assertEquals(EXPECTED_RESULT,
                chargeback.getContent());
        
    }
    
    @Before
    public void initObjects() {
        configuration = new Configuration(2, "chargeback", "IMPAYES", null, null, null, null, 0, null, "tpsips53v;tpsips53s;tpsips54v;tpsips54s", "1.0.1", null, "jri01.csv", "csv", "yymmdd", "1");
        client = new Client(2, "000000000000002", "GunsNRoses", "acceptance", "sftp", "BNP", "ubzrock");
        
        configuration.setClient(client);
    }
    
}
