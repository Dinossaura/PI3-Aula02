/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utils.ConexaoBanco;
import Classe.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayra.jpereira
 */
public class DaoProduto {
     public static void inserir(Produto p) throws SQLException, Exception {

         String sql = "INSERT INTO produto (nome, descricao, vl_compra, vl_venda, categoria, dt_cadastro) VALUES (?, ?, ?, ?, ?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConexaoBanco.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, p.getNome());
            preparedStatement.setString(2, p.getDesc());
            preparedStatement.setFloat(3, p.getvCompra());
            preparedStatement.setFloat(4, p.getvVenda());
            preparedStatement.setString(5, p.getCategoria());
            preparedStatement.setDate(6, p.getHora());

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }
     
     public static List<Produto> listar() throws SQLException, Exception {
        String sql = "SELECT * FROM produto";
        List<Produto> listaP = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConexaoBanco.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaP == null) {
                    listaP = new ArrayList<Produto>();
                }
                Produto p = new Produto();
                p.setCod_prod(result.getInt("id"));
                p.setNome(result.getString("nome"));
                p.setDesc(result.getString("descricao"));
                p.setvCompra(result.getFloat("vl_compra"));
                p.setvVenda(result.getFloat("vl_venda"));
                p.setCategoria(result.getString("categoria"));
                p.setHora(result.getDate("dt_cadastro"));
                listaP.add(p);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaP;
    }

}
