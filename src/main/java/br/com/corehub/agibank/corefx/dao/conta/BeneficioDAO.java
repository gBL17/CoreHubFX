package br.com.corehub.agibank.corefx.dao.conta;


import br.com.corehub.agibank.corefx.beans.conta.Beneficio;
import br.com.corehub.agibank.corefx.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BeneficioDAO {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public BeneficioDAO() throws SQLException {
        con = Conexao.getConexao();
    }

    public void fecharConexao() throws SQLException {
        con.close();
    }

    public int cadastrarBeneficio(String classe, String descricao) throws SQLException {

        final String sql = "INSERT INTO Beneficio(classe, descricao) VALUES(?,?)";

        stmt = con.prepareStatement(sql);
        stmt.setString(1, classe);
        stmt.setString(2, descricao);

        return stmt.executeUpdate();
    }

    public String buscarBeneficio(int id) throws SQLException {

        final String sql = "SELECT * FROM Beneficio WHERE id_beneficio = ?";

        Beneficio beneficio = new Beneficio();

        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if(rs.next()){

            beneficio.setIdBeneficio(rs.getInt("id_beneficio"));
            beneficio.setClasse(rs.getString("classe"));
            beneficio.setDescricao(rs.getString("descricao"));

            return beneficio.toString();

        }else return "Deu errado irmao";

    }

    public int atualizarBeneficio(String classe, String descricao, int id) throws SQLException {

        final String sql = "UPDATE Beneficio SET score = ?, descricao = ? WHERE id_beneficio = ?";

        stmt = con.prepareStatement(sql);

        stmt.setString(1, classe);
        stmt.setString(2, descricao);
        stmt.setInt(3, id);

        return stmt.executeUpdate();
    }

    public int deletarBeneficio(int id) throws SQLException {

        final String sql = "DELETE FROM Beneficio WHERE id_beneficio = ?";

        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        return stmt.executeUpdate();

    }

}
