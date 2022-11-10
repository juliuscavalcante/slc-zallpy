package br.com.zallpy.model.eneity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "registers")
@XmlRootElement(name = "Grupo_SLC0001_LiquidProdt")
public class Register implements Serializable {

    @Serial
    private static final long serialVersionUID = -274082532963744320L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    public Register() {
    }

    public Register(Long id, String identLinhaBilat, String tpDebCred, Long ispPbifCredtd, Long ispPbifDebtd, Double vlrLanc, Long cnpjNLiqdantDebtd, String nomeCliDebtd, String cnpjNLiqdantCredt, String nomeCliCredtd, Integer tpTranscSLC) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "IdentdLinhaBilat")
    public String getIdentLinhaBilat() {
        return identLinhaBilat;
    }

    public void setIdentLinhaBilat(String identLinhaBilat) {
        this.identLinhaBilat = identLinhaBilat;
    }

    @XmlElement(name = "TpDeb_Cred")
    public String getTpDebCred() {
        return tpDebCred;
    }

    public void setTpDebCred(String tpDebCred) {
        this.tpDebCred = tpDebCred;
    }

    @XmlElement(name = "ISPBIFCredtd")
    public Long getIspPbifCredtd() {
        return ispPbifCredtd;
    }

    public void setIspPbifCredtd(Long ispPbifCredtd) {
        this.ispPbifCredtd = ispPbifCredtd;
    }

    @XmlElement(name = "ISPBIFDebtd")
    public Long getIspPbifDebtd() {
        return ispPbifDebtd;
    }

    public void setIspPbifDebtd(Long ispPbifDebtd) {
        this.ispPbifDebtd = ispPbifDebtd;
    }

    @XmlElement(name = "VlrLanc")
    public Double getVlrLanc() {
        return vlrLanc;
    }

    public void setVlrLanc(Double vlrLanc) {
        this.vlrLanc = vlrLanc;
    }

    @XmlElement(name = "CNPJNLiqdantDebtd")
    public Long getCnpjNLiqdantDebtd() {
        return cnpjNLiqdantDebtd;
    }

    public void setCnpjNLiqdantDebtd(Long cnpjNLiqdantDebtd) {
        this.cnpjNLiqdantDebtd = cnpjNLiqdantDebtd;
    }

    @XmlElement(name = "NomCliDebtd")
    public String getNomeCliDebtd() {
        return nomeCliDebtd;
    }

    public void setNomeCliDebtd(String nomeCliDebtd) {
        this.nomeCliDebtd = nomeCliDebtd;
    }

    @XmlElement(name = "CNPJNLiqdantCredtd")
    public String getCnpjNLiqdantCredt() {
        return cnpjNLiqdantCredt;
    }

    public void setCnpjNLiqdantCredt(String cnpjNLiqdantCredt) {
        this.cnpjNLiqdantCredt = cnpjNLiqdantCredt;
    }

    @XmlElement(name = "NomCliCredtd")
    public String getNomeCliCredtd() {
        return nomeCliCredtd;
    }

    public void setNomeCliCredtd(String nomeCliCredtd) {
        this.nomeCliCredtd = nomeCliCredtd;
    }

    @XmlElement(name = "TpTranscSLC")
    public Integer getTpTranscSLC() {
        return tpTranscSLC;
    }

    public void setTpTranscSLC(Integer tpTranscSLC) {
        this.tpTranscSLC = tpTranscSLC;
    }


    @Override
    public String toString() {
        return "SLC0001{" +
                "id=" + id +
                ", identLinhaBilat='" + identLinhaBilat + '\'' +
                ", tpDebCred='" + tpDebCred + '\'' +
                ", ispPbifCredtd=" + ispPbifCredtd +
                ", ispPbifDebtd=" + ispPbifDebtd +
                ", vlrLanc=" + vlrLanc +
                ", cnpjNLiqdantDebtd=" + cnpjNLiqdantDebtd +
                ", nomeCliDebtd='" + nomeCliDebtd + '\'' +
                ", cnpjNLiqdantCredt='" + cnpjNLiqdantCredt + '\'' +
                ", nomeCliCredtd='" + nomeCliCredtd + '\'' +
                ", tpTranscSLC=" + tpTranscSLC +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return Objects.equals(id, register.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
