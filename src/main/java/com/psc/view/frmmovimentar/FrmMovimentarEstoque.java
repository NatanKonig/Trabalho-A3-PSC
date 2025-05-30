package com.psc.view.frmmovimentar;

import javax.swing.JOptionPane;


import com.psc.model.Produto;
import com.psc.dao.MovimentacaoDAO;
import com.psc.dao.ProdutoDAO;
import com.psc.dao.CategoriaDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



public class FrmMovimentarEstoque extends javax.swing.JFrame {

    
    public FrmMovimentarEstoque() {
        initComponents();
      carregarProdutosNoComboBox(); 
    
    }
    
    private void carregarProdutosNoComboBox() {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    ArrayList<Produto> produtos = produtoDAO.listar();

    JComboBox.removeAllItems(); // Limpa o ComboBox

    for (Produto p : produtos) {
        JComboBox.addItem(p);
    }
}

    // Método para obter o produto atualmente selecionado no ComboBox.
private Produto obterProdutoSelecionado() {
    Object selectedItem = JComboBox.getSelectedItem();

    if (selectedItem == null || !(selectedItem instanceof Produto)) {
        JOptionPane.showMessageDialog(this, "Nenhum produto selecionado ou seleção inválida.");
        return null;
    }

    return (Produto) selectedItem;
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        JComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JEntrada = new javax.swing.JRadioButton();
        JSaida = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        JTextQtd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTxtObs = new javax.swing.JTextField();
        JBConfirmar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JTextData = new javax.swing.JTextField();
        JProdutos = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableList = new javax.swing.JTable();
        JBPesquisar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selecionar Produto:");

        JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de Movimentação:");

        JEntrada.setText("Entrada");
        JEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEntradaActionPerformed(evt);
            }
        });

        JSaida.setText("Saida");
        JSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSaidaActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade a movimentar:");

        JTextQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextQtdActionPerformed(evt);
            }
        });

        jLabel4.setText("Movimentar estoque:");

        jLabel5.setText("Obeservação:");

        JTxtObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtObsActionPerformed(evt);
            }
        });

        JBConfirmar.setText("Confirmar");
        JBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfirmarActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Data:");

        JProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JProdutosActionPerformed(evt);
            }
        });

        JTableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Preço", "Unidade", "Qtd. Atual", "Categoria", "Status"
            }
        ));
        jScrollPane1.setViewportView(JTableList);

        jScrollPane3.setViewportView(jScrollPane1);

        JBPesquisar.setText("Pesquisar");
        JBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPesquisarActionPerformed(evt);
            }
        });

        jLabel7.setText("Produtos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JTextQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(184, 184, 184)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JTextData, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JTxtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addComponent(JBCancelar)
                                        .addGap(101, 101, 101)
                                        .addComponent(JBConfirmar))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JBPesquisar)))))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBPesquisar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSaida)
                            .addComponent(JEntrada, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(JTextQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JTextData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTxtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBConfirmar)
                    .addComponent(JBCancelar))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEntradaActionPerformed
                                                                                                                           
    Produto produto = obterProdutoSelecionado();

    if (produto == null) {
        JOptionPane.showMessageDialog(this, "Selecione um produto.");
        return; // Se não tiver produto, sai do método.
    }

    String qtdText = JTextQtd.getText().trim();
    if (qtdText.isEmpty() || !qtdText.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Informe uma quantidade válida.");
        return;
    }

    int quantidade = Integer.parseInt(qtdText);
    int produtoId = produto.getId();

    MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
    boolean sucesso = movimentacaoDAO.movimentarEstoque(produtoId, quantidade, "ENTRADA");

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Entrada registrada com sucesso!");
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao registrar entrada.");
    }
    }//GEN-LAST:event_JEntradaActionPerformed

    private void JTextQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextQtdActionPerformed

    private void JSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSaidaActionPerformed
        // TODO add your handling code here:                                                                      
    Produto produto = obterProdutoSelecionado();

    if (produto == null) {
        JOptionPane.showMessageDialog(this, "Selecione um produto.");
        return;
    }

    String qtdText = JTextQtd.getText().trim();
    if (qtdText.isEmpty() || !qtdText.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Informe uma quantidade válida.");
        return;
    }

    int quantidade = Integer.parseInt(qtdText);
    int produtoId = produto.getId();

    MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
    boolean sucesso = movimentacaoDAO.movimentarEstoque(produtoId, quantidade, "SAIDA");

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Saída registrada com sucesso!");
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao registrar saída.");
    }



    }//GEN-LAST:event_JSaidaActionPerformed

    private void JTxtObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtObsActionPerformed

    private void JBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfirmarActionPerformed
    //Validação dos campos
        if(JComboBox.getSelectedIndex() == -1){
           JOptionPane.showMessageDialog(this, "selecione um produto.");
           return;
       }
       if(!JEntrada.isSelected() && !JSaida.isSelected()){
           JOptionPane.showMessageDialog(this, "Selecionde o tipo de movimentação");
           return;
       }       
               
    String qtdText = JTextQtd.getText().trim();
    if (qtdText.isEmpty() || !qtdText.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Informe uma quantidade válida.");
        return;
       }
      // Processar movimentação
    Produto produto = obterProdutoSelecionado();
    int produtoId = produto.getId();
    int quantidade = Integer.parseInt(qtdText);
    String tipo = JEntrada.isSelected() ? "ENTRADA" : "SAIDA";

    MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
    boolean sucesso = movimentacaoDAO.movimentarEstoque(produtoId, quantidade, tipo);

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Movimentação realizada: \ntipo: " + tipo + "\nquantidade: " + quantidade);
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao realizar a movimentação!");
    }

    }//GEN-LAST:event_JBConfirmarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
    //fecha a janela
    this.dispose();
  // TODO add your handling code here:
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPesquisarActionPerformed
                                            
    String nomePesquisa = JProdutos.getText().trim();

    if (nomePesquisa.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Digite um nome para pesquisar.");
        return;
    }

    ProdutoDAO produtoDAO = new ProdutoDAO();
    ArrayList<Produto> produtos = produtoDAO.buscarPorNome(nomePesquisa);

    if (produtos.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nenhum produto encontrado.");
        return;
    }

    // Preenche a JTableList
    DefaultTableModel model = (DefaultTableModel) JTableList.getModel();
    model.setRowCount(0);  // Limpa a tabela antes de adicionar novas linhas

    for (Produto p : produtos) {
        String status = "OK";
        if (p.getQuantidadeEstoque() < p.getQuantidadeMinima()) {
            status = "⚠️ Abaixo do Mínimo";
        } else if (p.getQuantidadeEstoque() > p.getQuantidadeMaxima()) {
            status = "⚠️ Acima do Máximo";
        }

        model.addRow(new Object[]{
            p.getNome(),
            p.getPrecoUnitario(),
            p.getUnidade(),
            p.getQuantidadeEstoque(),
            p.getCategoria(), // ou p.getCategoria().getNome() se for um objeto Categoria
            status
        });
    }
    }//GEN-LAST:event_JBPesquisarActionPerformed

    private void JProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JProdutosActionPerformed

    private void JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxActionPerformed
                                         
    Produto produtoSelecionado = (Produto) JComboBox.getSelectedItem();
    if (produtoSelecionado != null) {
        JOptionPane.showMessageDialog(this, "Produto selecionado: " + produtoSelecionado.getNome());
    }
     
    
    }//GEN-LAST:event_JComboBoxActionPerformed


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
            java.util.logging.Logger.getLogger(FrmMovimentarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMovimentarEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBConfirmar;
    private javax.swing.JButton JBPesquisar;
    private javax.swing.JComboBox<Produto> JComboBox;
    private javax.swing.JRadioButton JEntrada;
    private javax.swing.JTextField JProdutos;
    private javax.swing.JRadioButton JSaida;
    private javax.swing.JTable JTableList;
    private javax.swing.JTextField JTextData;
    private javax.swing.JTextField JTextQtd;
    private javax.swing.JTextField JTxtObs;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
