package br.com.zallpy.service;

import br.com.zallpy.model.dto.RegisterDTO;
import br.com.zallpy.model.entity.Register;
import br.com.zallpy.repository.RegisterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class RegisterServiceTest {

    private static final Long ID = 1L;
    private static final String IDENT_LINHA_BILAT = "12345678CBC1633012";
    private static final String TP_DEB_CRED = "C";
    private static final Long ISP_PBIF_CREDTD = 99999999L;
    private static final Long ISP_PBIF_DEBTD = 99999999L;
    private static final Double VLR_LANC = 21446.69;
    private static final Long CNPJNLIQDANT_DEBTD = 74816392000106L;
    private static final String NOME_CLI_DEBTD = "BANCOBOB";
    private static final String CNPJNLIQDANT_CREDT = "30101382000100";
    private static final String NOME_CLI_CREDTD = "TRIANGULOBANCO";
    private static final Integer TP_TRANSCSLC = 3;

    @InjectMocks
    private RegisterService registerService;

    @Mock
    private RegisterRepository registerRepository;

    private Register register;
    private RegisterDTO registerDTO;
    private Optional<Register> registerOptional;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startRegister();
    }

    @Test
    void whenFindAllThenReturnAnListOfRegisters() {
        when(registerRepository.findAll()).thenReturn(List.of(register));

        List<Register> response = registerService.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Register.class, response.get(0).getClass());

        assertEquals(ID, response.get(0).getId());
        assertEquals(IDENT_LINHA_BILAT, response.get(0).getIdentLinhaBilat());
        assertEquals(TP_DEB_CRED, response.get(0).getTpDebCred());
        assertEquals(ISP_PBIF_CREDTD, response.get(0).getIspPbifCredtd());
        assertEquals(ISP_PBIF_DEBTD, response.get(0).getIspPbifDebtd());
        assertEquals(VLR_LANC, response.get(0).getVlrLanc());
        assertEquals(CNPJNLIQDANT_DEBTD, response.get(0).getCnpjNLiqdantDebtd());
        assertEquals(NOME_CLI_DEBTD, response.get(0).getNomeCliDebtd());
        assertEquals(CNPJNLIQDANT_CREDT, response.get(0).getCnpjNLiqdantCredt());
        assertEquals(NOME_CLI_CREDTD, response.get(0).getNomeCliCredtd());
        assertEquals(TP_TRANSCSLC, response.get(0).getTpTranscSLC());
    }

    @Test
    void whenFindByIdReturnAnRegister() {
        when(registerRepository.findById(anyLong())).thenReturn(registerOptional);

        Register response = registerService.findById(ID);

        assertNotNull(response);

        assertEquals(ID, response.getId());
        assertEquals(IDENT_LINHA_BILAT, response.getIdentLinhaBilat());
        assertEquals(TP_DEB_CRED, response.getTpDebCred());
        assertEquals(ISP_PBIF_CREDTD, response.getIspPbifCredtd());
        assertEquals(ISP_PBIF_DEBTD, response.getIspPbifDebtd());
        assertEquals(VLR_LANC, response.getVlrLanc());
        assertEquals(CNPJNLIQDANT_DEBTD, response.getCnpjNLiqdantDebtd());
        assertEquals(NOME_CLI_DEBTD, response.getNomeCliDebtd());
        assertEquals(CNPJNLIQDANT_CREDT, response.getCnpjNLiqdantCredt());
        assertEquals(NOME_CLI_CREDTD, response.getNomeCliCredtd());
        assertEquals(TP_TRANSCSLC, response.getTpTranscSLC());
    }

    @Test
    void whenUpdateARegisterThenReturnSuccess() {
        when(registerRepository.save(any())).thenReturn(register);
        when(registerRepository.findById(anyLong())).thenReturn(registerOptional);

        Register response = registerService.update(ID, registerDTO);

        assertNotNull(response);
        assertEquals(Register.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(IDENT_LINHA_BILAT, response.getIdentLinhaBilat());
        assertEquals(TP_DEB_CRED, response.getTpDebCred());
        assertEquals(ISP_PBIF_CREDTD, response.getIspPbifCredtd());
        assertEquals(ISP_PBIF_DEBTD, response.getIspPbifDebtd());
        assertEquals(VLR_LANC, response.getVlrLanc());
        assertEquals(CNPJNLIQDANT_DEBTD, response.getCnpjNLiqdantDebtd());
        assertEquals(NOME_CLI_DEBTD, response.getNomeCliDebtd());
        assertEquals(CNPJNLIQDANT_CREDT, response.getCnpjNLiqdantCredt());
        assertEquals(NOME_CLI_CREDTD, response.getNomeCliCredtd());
        assertEquals(TP_TRANSCSLC, response.getTpTranscSLC());
    }

    @Test
    void deleteWithSuccess() {
        when(registerRepository.findById(anyLong())).thenReturn(registerOptional);
        doNothing().when(registerRepository).deleteById(anyLong());
        registerService.delete(ID);
        verify(registerRepository, times(1)).deleteById(anyLong());
    }

    private void startRegister() {
        register = new Register(ID, IDENT_LINHA_BILAT, TP_DEB_CRED, ISP_PBIF_CREDTD, ISP_PBIF_DEBTD, VLR_LANC,
                CNPJNLIQDANT_DEBTD, NOME_CLI_DEBTD, CNPJNLIQDANT_CREDT, NOME_CLI_CREDTD, TP_TRANSCSLC);

        registerDTO = new RegisterDTO(ID, IDENT_LINHA_BILAT, TP_DEB_CRED, ISP_PBIF_CREDTD, ISP_PBIF_DEBTD,
                VLR_LANC, CNPJNLIQDANT_DEBTD, NOME_CLI_DEBTD, CNPJNLIQDANT_CREDT, NOME_CLI_CREDTD, TP_TRANSCSLC);

        registerOptional = Optional.of(new Register(ID, IDENT_LINHA_BILAT, TP_DEB_CRED, ISP_PBIF_CREDTD, ISP_PBIF_DEBTD,
                VLR_LANC, CNPJNLIQDANT_DEBTD, NOME_CLI_DEBTD, CNPJNLIQDANT_CREDT, NOME_CLI_CREDTD, TP_TRANSCSLC));
    }
}
