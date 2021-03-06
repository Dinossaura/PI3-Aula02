/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio01;

import Classe.Produto;
import Service.ServicoProduto;
import Exceptions.ProdutoException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.exercicio01.CadastroProduto;

/**
 *
 * @author mayra.jpereira
 */
public class TelaPesquisarProduto extends javax.swing.JFrame {
    
     private TelaPrincipal telaPrinc;
     private TelaPesquisarProduto telaPesqui;
     //Armazena a ultima pesquisa
     String ultimaPesquisa = null;
     
     //Instancia do Form CadastrarProduto para efetuar alteracoes
     CadastroProduto cadastroProduto = new CadastroProduto();
    /**
     * Creates new form TelaPesquisarProduto
     */
    public TelaPesquisarProduto() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePesquisar = new javax.swing.JTable();
        txtPesqNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bttPesquisar = new javax.swing.JButton();
        bttvoltar = new javax.swing.JButton();
        bttExcluir = new javax.swing.JButton();
        bttAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Produto"));

        TablePesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Descrição", "Valor compra", "Valor venda", "Categoria", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablePesquisar);
        if (TablePesquisar.getColumnModel().getColumnCount() > 0) {
            TablePesquisar.getColumnModel().getColumn(0).setResizable(false);
            TablePesquisar.getColumnModel().getColumn(1).setResizable(false);
            TablePesquisar.getColumnModel().getColumn(2).setResizable(false);
            TablePesquisar.getColumnModel().getColumn(3).setResizable(false);
            TablePesquisar.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Nome: ");

        bttPesquisar.setText("Pesquisar");
        bttPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttPesquisarActionPerformed(evt);
            }
        });

        bttvoltar.setText("Voltar");
        bttvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttvoltarActionPerformed(evt);
            }
        });

        bttExcluir.setText("Excluir");
        bttExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttExcluirActionPerformed(evt);
            }
        });

        bttAlterar.setText("Alterar");
        bttAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(bttPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bttPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttvoltar)
                    .addComponent(bttExcluir)
                    .addComponent(bttAlterar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttPesquisarActionPerformed
        // TODO add your handling code here:
                boolean resultadoPesquisa = false;
        
        //Pega valor da pesquisa e atribui a variavel para efetuar busca
        ultimaPesquisa = txtPesqNome.getText();
        
        try {
            resultadoPesquisa = refreshListProdutos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!resultadoPesquisa) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ",
                    "Sem resultados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bttPesquisarActionPerformed

    //Atualiza a lista de Produtos. Pode ser chamado por outras telas
    public boolean refreshListProdutos() throws ProdutoException, Exception {
        //Realiza a pesquisa de produtos com o último valor de pesquisa
        //para atualizar a lista
        List<Produto> resultado = ServicoProduto.procurarProduto(ultimaPesquisa);

        //Obtém o elemento representante do conteúdo da tabela na tela
        DefaultTableModel model = (DefaultTableModel) TablePesquisar.getModel();
        //Indica que a tabela deve excluir todos seus elementos
        //Isto limpará a lista, mesmo que a pesquisa não tenha sucesso
        model.setRowCount(0);

        //Verifica se não existiram resultados. Caso afirmativo, encerra a
        //atualização e indica ao elemento acionador o não sucesso da pesquisa
        if (resultado == null || resultado.size() <= 0) {
            return false;
        }

        //Percorre a lista de resultados e os adiciona na tabela
        for (int i = 0; i < resultado.size(); i++) {
            Produto pro = resultado.get(i);
            if (pro != null) {
                Object[] row = new Object[13];
                row[0] = pro.getCod_prod();
                row[1] = pro.getNome();
                row[2] = pro.getDesc();
                row[3] = pro.getvCompra();
                row[4] = pro.getvVenda();
                row[5] = pro.getCategoria();
                row[6] = pro.getDataCadastro();
                model.addRow(row);
            }
        }

        //Se chegamos até aqui, a pesquisa teve sucesso, então
        //retornamos "true" para o elemento acionante, indicando
        //que não devem ser exibidas mensagens de erro
        return true;
    }
    private void bttvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttvoltarActionPerformed
        // TODO add your handling code here:
        if (telaPrinc == null || !telaPrinc.isDisplayable() ) {
            telaPrinc = new TelaPrincipal();
            telaPrinc.setVisible(true);
        }
        
        this.setVisible(false);
        telaPrinc.toFront();
        
        
    }//GEN-LAST:event_bttvoltarActionPerformed

    private void bttExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttExcluirActionPerformed
        // TODO add your handling code here:
        //Verifica se há itens selecionados para exclusão.
        //Caso negativo, ignora o comando
        if (TablePesquisar.getSelectedRow() >= 0) {
            
            //Obtém a linha do item selecionado
            final int row = TablePesquisar.getSelectedRow();
            //Obtém o nome do produto da linha indicada para exibição
            //de mensagem de confirmação de exclusão utilizando seu nome
            String nome = (String) TablePesquisar.getValueAt(row, 1);
            //Mostra o diálogo de confirmação de exclusão
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                "Excluir o produto \"" + nome + "\"?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            //Se o valor de resposta for "Sim" para a exclusão
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    //Obtém o ID do produto
                    Integer codigo = (Integer) TablePesquisar.getValueAt(row, 0);
                    //Solicita ao serviço a inativação do cliente com o ID
                    ServicoProduto.excluirProduto(codigo);
                    //Atualiza a lista após a "exclusão"
                    this.refreshListProdutos();
                } catch (Exception e) {
                    //Se ocorrer algum erro técnico, mostra-o no console,
                    //mas esconde-o do usuário
                    e.printStackTrace();
                    //Exibe uma mensagem de erro genérica ao usuário
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                            "Falha na Exclusão", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_bttExcluirActionPerformed

    private void bttAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAlterarActionPerformed
        // TODO add your handling code here:
        try {
            //Obtém a linha selecionada na tabela de resultados
            final int row = TablePesquisar.getSelectedRow();
            //Verifica se há linha selecionada na tabela
            if (row >= 0) {
                //Obtém a linha selecionada na tabela
                Integer codigo = (Integer) TablePesquisar.getValueAt(row, 0);
                
                //Solicita ao serviço a obtenção do cliente a partir do
                //ID selecionado na tabela
                Produto produto = ServicoProduto.encontrarProdutoPorCodigo(codigo);
                cadastroProduto = new CadastroProduto();   
                cadastroProduto.populateFields(produto);
              

                cadastroProduto.invalidate();
                cadastroProduto.validate();
                cadastroProduto.repaint();
                cadastroProduto.setProduto(produto);  
                this.dispose();
                this.setVisible(false);
                cadastroProduto.setVisible(true); 
                            
               // formAlterar.toFront();
                
            }
        } catch (Exception e) {
            //Se ocorrer algum erro técnico, mostra-o no console,
            //mas esconde-o do usuário
            e.printStackTrace();
            //Exibe uma mensagem de erro genérica ao usuário
            JOptionPane.showMessageDialog(rootPane, "Não é possível "
                + "exibir os detalhes deste produto.",
                "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bttAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablePesquisar;
    private javax.swing.JButton bttAlterar;
    private javax.swing.JButton bttExcluir;
    private javax.swing.JButton bttPesquisar;
    private javax.swing.JButton bttvoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPesqNome;
    // End of variables declaration//GEN-END:variables
}
