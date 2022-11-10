package br.com.zallpy.config;

import br.com.zallpy.model.eneity.Register;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterItemPreparedStatementSetter implements ItemPreparedStatementSetter<Register> {

    public void setValues(Register register, PreparedStatement ps) throws SQLException {
        ps.setString(1, register.getIdentLinhaBilat());
        ps.setString(2, register.getTpDebCred());
        ps.setLong(3, register.getIspPbifCredtd());
        ps.setLong(4, register.getIspPbifDebtd());
        ps.setDouble(5, register.getVlrLanc());
        ps.setLong(6, register.getCnpjNLiqdantDebtd());
        ps.setString(7, register.getNomeCliDebtd());
        ps.setString(8, register.getCnpjNLiqdantCredt());
        ps.setString(9, register.getNomeCliCredtd());
        ps.setInt(10, register.getTpTranscSLC());
    }
}