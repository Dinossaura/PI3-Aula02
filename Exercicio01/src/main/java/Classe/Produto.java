/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author Mayra Pereira
 */
public class Produto {
    private Integer cod_prod;
    private String nome;
    private String desc;
    private float vVenda;
    private float vCompra;
    private String categoria;
    private Date dataCadastro;

    public Integer getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(Integer cod_prod) {
        this.cod_prod = cod_prod;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getvVenda() {
        return vVenda;
    }

    public void setvVenda(float vVenda) {
        this.vVenda = vVenda;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    public float getvCompra() {
        return vCompra;
    }

    public void setvCompra(float vCompra) {
        this.vCompra = vCompra;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    
    
}
