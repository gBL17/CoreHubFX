package br.com.corehub.agibank.corefx.dao.transacoes;

import br.com.corehub.agibank.corefx.beans.transacoes.TipoTransacao;
import br.com.corehub.agibank.corefx.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoTransacaoDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public TipoTransacaoDAO() throws SQLException {
        con = Conexao.getConexao();
    }

    public void fecharConexao() throws SQLException{
        con.close();
    }

    public int criarTipoTransacao(String tipoTransacao) throws SQLException {
        final String sql = "INSERT INTO Tipo_Transacao (tipo) VALUES (?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1,tipoTransacao);
        return stmt.executeUpdate();
    }

    public TipoTransacao buscarTipoTransacao(int id) throws SQLException {
        TipoTransacao tipoTransacao = new TipoTransacao();
        final String sql = "SELECT * FROM Tipo_Transacao WHERE id_tipo_transacao = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if (rs.next()){
            tipoTransacao.setId(rs.getInt("id_tipo_trasacao"));
            tipoTransacao.setTipoTransacao(rs.getString("tipo"));
        }

        return tipoTransacao;
    }

    public int atualizarTipoTransacao(int id, String tipoTransacao) throws SQLException {
        final String sql = "UPDATE Tipo_Transacao SET tipo = ? WHERE id_tipo_transacao = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, tipoTransacao);
        stmt.setInt(2, id);
        return stmt.executeUpdate();
    }

    public int deletarTipoTransacao(int id) throws SQLException {
        final String sql = "DELETE FROM Tipo_Transacao WHERE id_tipo_transacao = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1,id);
        return stmt.executeUpdate();
    }
}
