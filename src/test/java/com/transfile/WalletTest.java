package com.transfile;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.configuration.ConfigurationService;
import com.transfile.logtype.LogType;
import com.transfile.logtype.Wallet;
import com.transfile.stats.IStatsService;
import com.transfile.stats.StatsException;
import com.transfile.transcode.TranscodeService;
import com.transfile.transcode.VariableType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Wallet.class)
@AutoConfigureMockMvc
public class WalletTest {
    private final static String EXPECTED_RESULT = "ubz-wallet.expiring.000000000000003-Metallica.*:CARTE-ECHUES:ubzrock.ftp_b.EXTRACT1..ZIP:extract1.${e_date}:atosftp:::"
            + System.getProperty("line.separator");
    
    @Autowired
    private Wallet wallet;
    
    @MockBean
    private ConfigurationService configurationService;
    
    @MockBean
    private TranscodeService transcodeService;
    
    @MockBean
    private IStatsService statsService;
    
    private Configuration configuration;
    
    private Client client;
    
    @Before
    public void initObjects() {
        configuration = new Configuration(1, "wallet", "CARTE-ECHUES", "extract", "EXTRACT", null, null, 1, null,
                "tpsips53v;tpsips53s;tpsips54v;tpsips54s", "1.0.1", null, null, "zip", "yymmdd", "1");
        client = new Client(3, "000000000000003", "Metallica", "production", "ftp", "SIPS", "ubzrock");
        
        configuration.setClient(client);
    }
    
    @Test
    public void testGetContent() {
        final List<Configuration> configurations = new ArrayList<>();
        configurations.add(configuration);
        
        Mockito.when(configurationService.findByLogType(LogType.wallet.getValue())).thenReturn(configurations);
        
        Mockito.when(transcodeService.getWalletNormalise("zip", VariableType.EXT)).thenReturn(".ZIP");
        Mockito.when(transcodeService.getWalletNormalise("yymmdd", VariableType.DATE_FORMAT)).thenReturn("${e_date}");
        Mockito.when(transcodeService.getWalletNormalise("ftp", VariableType.PROTOCOL)).thenReturn("atosftp");
        Mockito.when(transcodeService.getWalletNormalise(null, VariableType.DELETE)).thenReturn(null);
        Mockito.when(transcodeService.getWalletNormalise(null, VariableType.MULTIPLE)).thenReturn(null);
        
        try {
            Assert.assertEquals(WalletTest.EXPECTED_RESULT, wallet.getContent());
        } catch (StatsException e) {
           Assert.fail(e.getMessage());
        }
    }
    
}
