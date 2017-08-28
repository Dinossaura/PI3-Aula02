/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Classe.Produto;
import Dao.DaoProduto;
import Exceptions.DataSourceException;
import Exceptions.ProdutoException;
import Validador.ValidadorProduto;
import java.util.List;
/**
 *
 * @author Magno
 */
public class ServicoProduto {
   //DaoProduto DaoProduto = new Dao.DaoProduto();
    
    public static void cadastrarProduto(Produto produto) throws ProdutoException, DataSourceException{
        
        ValidadorProduto.validar(produto);

        try {
            //Realiza a chamada de inserção na fonte de dados
           DaoProduto.inserir(produto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //Atualiza um produto na fonte de dados
    public static void atualizarProduto(Produto produto) throws ProdutoException, DataSourceException {
        ValidadorProduto.validar(produto);

        try {
            DaoProduto.updateProduto(produto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
     public static List<Produto> procurarProduto(String nome) throws ProdutoException, DataSourceException {
        try {
        return DaoProduto.listar(nome);
          
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
     
     public static void excluirProduto(Integer id) throws ProdutoException, DataSourceException {
        try {
            DaoProduto.deletarProduto(id);
        } catch (Exception e) {
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    
}
