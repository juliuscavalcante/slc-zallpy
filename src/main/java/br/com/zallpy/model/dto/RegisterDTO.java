package br.com.zallpy.model.dto;

import br.com.zallpy.model.entity.Register;


import java.io.Serial;
import java.io.Serializable;


public class RegisterDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4171489978411142620L;

    private Long id;

    private String identLinhaBilat;

    private String tpDebCred;

    private Long ispPbifCredtd;

    private Long ispPbifDebtd;

    private Double vlrLanc;

    private Long cnpjNLiqdantDebtd;

    private String nomeCliDebtd;

    private String cnpjNLiqdantCredt;

    private String nomeCliCredtd;

    private Integer tpTranscSLC;

    public RegisterDTO() {
    }

    public RegisterDTO(Long id, String identLinhaBilat, String tpDebCred, Long ispPbifCredtd, Long ispPbifDebtd, Double vlrLanc, Long cnpjNLiqdantDebtd, String nomeCliDebtd, String cnpjNLiqdantCredt, String nomeCliCredtd, Integer tpTranscSLC) {
        this.id = id;
        this.identLinhaBilat = identLinhaBilat;
        this.tpDebCred = tpDebCred;
        this.ispPbifCredtd = ispPbifCredtd;
        this.ispPbifDebtd = ispPbifDebtd;
        this.vlrLanc = vlrLanc;
        this.cnpjNLiqdantDebtd = cnpjNLiqdantDebtd;
        this.nomeCliDebtd = nomeCliDebtd;
        this.cnpjNLiqdantCredt = cnpjNLiqdantCredt;
        this.nomeCliCredtd = nomeCliCredtd;
        this.tpTranscSLC = tpTranscSLC;
    }

    public RegisterDTO(Register register) {
        this.id = register.getId();
        this.identLinhaBilat = register.getIdentLinhaBilat();
        this.tpDebCred = register.getTpDebCred();
        this.ispPbifCredtd = register.getIspPbifCredtd();
        this.ispPbifDebtd = register.getIspPbifDebtd();
        this.vlrLanc = register.getVlrLanc();
        this.cnpjNLiqdantDebtd = register.getCnpjNLiqdantDebtd();
        this.nomeCliDebtd= register.getNomeCliDebtd();
        this.cnpjNLiqdantCredt = register.getCnpjNLiqdantCredt();
        this.nomeCliCredtd = register.getNomeCliCredtd();
        this.tpTranscSLC = register.getTpTranscSLC();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentLinhaBilat() {
        return identLinhaBilat;
    }

    public void setIdentLinhaBilat(String identLinhaBilat) {
        this.identLinhaBilat = identLinhaBilat;
    }

    public String getTpDebCred() {
        return tpDebCred;
    }

    public void setTpDebCred(String tpDebCred) {
        this.tpDebCred = tpDebCred;
    }

    public Long getIspPbifCredtd() {
        return ispPbifCredtd;
    }

    public void setIspPbifCredtd(Long ispPbifCredtd) {
        this.ispPbifCredtd = ispPbifCredtd;
    }

    public Long getIspPbifDebtd() {
        return ispPbifDebtd;
    }

    public void setIspPbifDebtd(Long ispPbifDebtd) {
        this.ispPbifDebtd = ispPbifDebtd;
    }

    public Double getVlrLanc() {
        return vlrLanc;
    }

    public void setVlrLanc(Double vlrLanc) {
        this.vlrLanc = vlrLanc;
    }

    public Long getCnpjNLiqdantDebtd() {
        return cnpjNLiqdantDebtd;
    }

    public void setCnpjNLiqdantDebtd(Long cnpjNLiqdantDebtd) {
        this.cnpjNLiqdantDebtd = cnpjNLiqdantDebtd;
    }

    public String getNomeCliDebtd() {
        return nomeCliDebtd;
    }

    public void setNomeCliDebtd(String nomeCliDebtd) {
        this.nomeCliDebtd = nomeCliDebtd;
    }

    public String getCnpjNLiqdantCredt() {
        return cnpjNLiqdantCredt;
    }

    public void setCnpjNLiqdantCredt(String cnpjNLiqdantCredt) {
        this.cnpjNLiqdantCredt = cnpjNLiqdantCredt;
    }

    public String getNomeCliCredtd() {
        return nomeCliCredtd;
    }

    public void setNomeCliCredtd(String nomeCliCredtd) {
        this.nomeCliCredtd = nomeCliCredtd;
    }

    public Integer getTpTranscSLC() {
        return tpTranscSLC;
    }

    public void setTpTranscSLC(Integer tpTranscSLC) {
        this.tpTranscSLC = tpTranscSLC;
    }
}
