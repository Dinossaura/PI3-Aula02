/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validador;
import Exceptions.ProdutoException;
import Classe.Produto;

/**
 *
 * @author Magno
 */
public class ValidadorProduto {
    //Realiza validação de negócio
    public static void validar(Produto produto) throws ProdutoException{
        if(produto == null){
            throw new ProdutoException("Não foi informado um produto");
        }
        
        if(produto.getNome()== null || "".equals(produto.getNome())){
            throw new ProdutoException("Não foi informado um nome");
        }
        
        if(produto.getCategoria()== null || "".equals(produto.getCategoria())){
            throw new ProdutoException("Não foi informada uma categoria");
        }
        
        if(produto.getDataCadastro()== null || "".equals(produto.getDataCadastro())){
            throw new ProdutoException("Não foi informada uma data de cadastro");
        }
        
        if(produto.getDesc()== null || "".equals(produto.getDesc())){
            throw new ProdutoException("Não foi informada uma descrição para o produto");
        }
        
        try {
            if(String.valueOf(produto.getvCompra())==null || "".equals(produto.getvCompra()))
                throw new ProdutoException("Não foi informado o valor de compra do produto");
        }  catch (NumberFormatException e) {
            throw new ProdutoException("É necessário digitar somente "
                + "números para valor de compra" + e);
        }
        
        try {
            if(String.valueOf(produto.getvVenda())==null || "".equals(produto.getvVenda()))
                throw new ProdutoException("Não foi informado o valor de venda do produto");
        }  catch (NumberFormatException e) {
            throw new ProdutoException("É necessário digitar somente "
                + "números para preço" + e);
        }
        
    }
}
