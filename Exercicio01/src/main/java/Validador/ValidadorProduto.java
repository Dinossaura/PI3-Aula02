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
    public static void validar(Produto produto) throws ProdutoException {
        if (produto == null) {
            throw new ProdutoException("Não foi informado um produto");
        }

        if (produto.getNome() == null || "".equals(produto.getNome())) {
            throw new ProdutoException("Não foi informado um nome");
        }

        if (produto.getCategoria() == null || "".equals(produto.getCategoria())) {
            throw new ProdutoException("Não foi informada uma categoria");
        }

        if (produto.getDesc() == null || "".equals(produto.getDesc())) {
            throw new ProdutoException("Não foi informada uma descrição para o produto");
        }

    }
}
