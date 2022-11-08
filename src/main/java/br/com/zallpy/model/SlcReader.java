package br.com.zallpy.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SlcReader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String codProdt;

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

    private LocalDateTime dtHrSLC;

    private LocalDate dtMovto;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SlcReader slcReader = (SlcReader) o;
        return id != null && Objects.equals(id, slcReader.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
