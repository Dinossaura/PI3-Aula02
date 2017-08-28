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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayra.jpereira
 */
public class DaoProduto {
    //Insere novo produto na base de dados
     public static void inserir(Produto p) throws SQLException, Exception {

        String sql = "INSERT INTO produto (nome, descricao, vl_compra, vl_venda, categoria, dt_cadastro) VALUES (?, ?, ?, ?, ?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConexaoBanco.getConnection();
            connection.setAutoCommit(false);
            try {
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, p.getNome());
                preparedStatement.setString(2, p.getDesc());
                preparedStatement.setFloat(3, p.getvCompra());
                preparedStatement.setFloat(4, p.getvVenda());
                preparedStatement.setString(5, p.getCategoria());
                preparedStatement.setDate(6, p.getDataCadastro());

                preparedStatement.execute();
                
                connection.commit();
            }catch (SQLException ex){
                connection.rollback();
                System.err.println(ex.getMessage());
            }finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
           
            }
        }catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }
     
     //Lista os produtos da base de dados
     public static List<Produto> listar(String nome) throws SQLException, Exception {
         String sql = "";
         if((nome == " ")||(nome == null)){
            sql = "SELECT * FROM produto";
        }else{
            sql = "SELECT * FROM produto WHERE nome LIKE ?";
        }
        List<Produto> listaP = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConexaoBanco.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%"+nome+"%");

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
                p.setDataCadastro(result.getDate("dt_cadastro"));
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
     
     //Altera os produtos da base de dados
     public static Produto updateProduto(Produto produto) throws Exception{
        System.out.println("Atualizando produto...");
         String query = "UPDATE produto SET nome=?, descricao=?, vl_compra=?, vl_venda=?, categoria=?, dt_cadastro=? WHERE ID=?";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConexaoBanco.getConnection();
            connection.setAutoCommit(false);
            try {
                preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
                preparedStatement.setString(1, produto.getNome());
                preparedStatement.setString(2, produto.getDesc());
                preparedStatement.setFloat(3, produto.getvCompra());
                preparedStatement.setFloat(4, produto.getvVenda());
                preparedStatement.setString(5, produto.getCategoria());
                preparedStatement.setDate(6, produto.getDataCadastro());
            
                preparedStatement.executeUpdate();
                preparedStatement.close();
                
                connection.commit();
            } catch (SQLException ex) {
                 connection.rollback();
                 System.err.println(ex.getMessage());
                 System.out.println("Erro ao atualizar produto");
                 throw new Exception("Erro ao atualizar produto", ex);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            throw new Exception("Erro ao atualizar produto", ex);
        }

        return produto;
    }
     //Deleta produto da base de dados
     public static void deletarProduto(int id) throws Exception{
            System.out.println("Deletando produto de codigo: "+id);
            String query = "DELETE FROM produto WHERE id=?";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConexaoBanco.getConnection();
            connection.setAutoCommit(false);
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);            
                preparedStatement.execute();
            
            System.out.println("Produto deletado");
            connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                System.err.println(ex.getMessage());
                System.out.println("Erro ao deletar produto");
                throw new Exception("Erro ao deletar produto", ex);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            throw new Exception("Erro ao deletar produto", ex);
        }
    }
   

}
