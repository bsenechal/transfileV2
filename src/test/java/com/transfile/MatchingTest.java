//package com.transfile;
//
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.transfile.client.Client;
//import com.transfile.configuration.Configuration;
//import com.transfile.configuration.ConfigurationService;
//import com.transfile.logtype.LogType;
//import com.transfile.logtype.Matching;
//import com.transfile.transcode.TranscodeService;
//import com.transfile.transcode.VariableType;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Matching.class)
//@AutoConfigureMockMvc
//public class MatchingTest {
//    private final static String EXPECTED_RESULT = "ubz-wallet.expiring.000000000000003-Metallica.*:CARTE-ECHUES:ubzrock.ftp_b.EXTRACT1..ZIP:extract1.${e_date}:atosftp:::" + System.getProperty("line.separator");
//    
//    @Autowired
//    private Matching matching;
//    
//    @MockBean
//    private ConfigurationService configurationService;
//    
//    @MockBean
//    private TranscodeService transcodeService;
//    
//    private Configuration configuration;
//    
//    private Client client;
//    
//    @Test
//    public void testGetContent() {
//        List<Configuration> configurations = new ArrayList<Configuration>();
//        configurations.add(configuration);
//        
//        when(configurationService.findByLogType(LogType.matching.getValue())).thenReturn(configurations);
//        
//        when(transcodeService.getMatchingNormalise("zip", VariableType.EXT)).thenReturn(".ZIP");
//        when(transcodeService.getMatchingNormalise("yymmdd", VariableType.DATE_FORMAT)).thenReturn("${e_date}");
//        when(transcodeService.getMatchingNormalise("ftp", VariableType.PROTOCOL)).thenReturn("atosftp");
//        when(transcodeService.getMatchingNormalise(null, VariableType.DELETE)).thenReturn(null);
//        when(transcodeService.getMatchingNormalise(null, VariableType.MULTIPLE)).thenReturn(null);
//        
//        Assert.assertEquals(EXPECTED_RESULT,
//                matching.getContent());
//        
//    }
//    
//    @Before
//    public void initObjects() {
//        configuration = new Configuration(1, "wallet", "CARTE-ECHUES", "extract", "EXTRACT", null, null, 1, null, "tpsips53v;tpsips53s;tpsips54v;tpsips54s", "1.0.1", null, null, "zip", "yymmdd", "1");
//        client = new Client(3, "000000000000003", "Metallica", "production", "ftp", "SIPS", "ubzrock");
//        
//        configuration.setClient(client);
//    }
//    
//}
