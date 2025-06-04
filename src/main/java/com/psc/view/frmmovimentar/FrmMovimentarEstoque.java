package com.psc.view.frmmovimentar;

import javax.swing.JOptionPane;


import com.psc.model.Movimentacao;
import com.psc.model.Produto;
import com.psc.dao.MovimentacaoDAO;
import com.psc.dao.ProdutoDAO;
import com.psc.model.TipoMovimentacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 * Janela para gerenciar movimentações de estoque.
 *
 * <p>Permite visualizar o histórico de movimentações, selecionar um produto,
 * escolher o tipo de movimentação (entrada ou saída), informar a quantidade
 * e registrar essa movimentação no banco de dados.</p>
 *
 * @author EvelynYs2
 * @version 1.0
 */
public class FrmMovimentarEstoque extends javax.swing.JFrame {

    /**
     * DAO para manipulação das movimentações no banco de dados.
     */
    MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();

    /**
     * DAO para manipulação dos produtos no banco de dados.
     */
    ProdutoDAO produtoDAO = new ProdutoDAO();

    /**
     * Construtor padrão que inicializa os componentes gráficos,
     * carrega os produtos no comboBox e o histórico de movimentações,
     * além de definir a data/hora atual no campo de data.
     */
    public FrmMovimentarEstoque() {
        initComponents();
        carregarProdutosNoComboBox();
        carregarTabelaMovimentacao();
        JTextData.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss")));
    }

    /**
     * Carrega a lista de produtos disponíveis no banco de dados e
     * os adiciona ao comboBox de seleção de produtos.
     */
    private void carregarProdutosNoComboBox() {
        ArrayList<Produto> produtos = produtoDAO.listar();
        comboProdutos.removeAllItems(); // Limpa o comboProdutos
        for (Produto p : produtos) {
            comboProdutos.addItem(p);
        }
    }

    /**
     * Atualiza a tabela exibindo o histórico das movimentações realizadas,
     * buscando as movimentações no banco de dados e exibindo seus dados
     * formatados.
     */
    private void carregarTabelaMovimentacao() {
        DefaultTableModel modelo = (DefaultTableModel) JTableHistoricoMovimentacoes.getModel();
        modelo.setRowCount(0);

        for (Movimentacao movimentacao : movimentacaoDAO.listar()) {
            modelo.addRow(new Object[]{
                    movimentacao.getId(),
                    movimentacao.getProduto().getNome(),
                    movimentacao.getQuantidade(),
                    movimentacao.getTipo(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(movimentacao.getData())
            });
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        comboProdutos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JEntrada = new javax.swing.JRadioButton();
        JSaida = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        JTextQtd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JBConfirmar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JTextData = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableHistoricoMovimentacoes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jToggleButton1.setText("jToggleButton1");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Movimentações do Estoque");

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel1.setText("Selecionar Produto:");

        comboProdutos.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        comboProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProdutosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel2.setText("Tipo de Movimentação:");

        buttonGroup1.add(JEntrada);
        JEntrada.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JEntrada.setText("Entrada");
        JEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEntradaActionPerformed(evt);
            }
        });

        buttonGroup1.add(JSaida);
        JSaida.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JSaida.setText("Saida");
        JSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSaidaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel3.setText("Quantidade a movimentar:");

        JTextQtd.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        JTextQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextQtdActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        jLabel4.setText("Movimentar estoque:");

        JBConfirmar.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBConfirmar.setText("Confirmar");
        JBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfirmarActionPerformed(evt);
            }
        });

        JBCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBCancelar.setText("Voltar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel6.setText("Data:");

        JTextData.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        jLabel7.setText("Gerenciamento de movimentações");

        JTableHistoricoMovimentacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID movimentação", "Nome produto", "Quantidade movimentada", "Tipo movimentacao", "Data"
            }
        ));
        jScrollPane2.setViewportView(JTableHistoricoMovimentacoes);

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel5.setText("Historico de movimentações:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBCancelar)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5)
                                .addComponent(JBConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTextData, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JTextQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JSaida)
                    .addComponent(JEntrada))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTextQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTextData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(JBConfirmar)
                .addGap(33, 33, 33)
                .addComponent(JBCancelar)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEntradaActionPerformed
        if (JSaida.isSelected()) {
            JSaida.setSelected(false);
        }
    }//GEN-LAST:event_JEntradaActionPerformed

    private void JTextQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextQtdActionPerformed

    private void JSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSaidaActionPerformed
        if (JEntrada.isSelected()) {
            JEntrada.setSelected(false);
        }
    }//GEN-LAST:event_JSaidaActionPerformed

    private void JBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfirmarActionPerformed
        Produto produtoSelecionado = (Produto) comboProdutos.getSelectedItem();
        TipoMovimentacao tipoMovimentacao = JEntrada.isSelected() ? TipoMovimentacao.ENTRADA : JSaida.isSelected() ? TipoMovimentacao.SAIDA : null;
        String qtdStr = JTextQtd.getText().trim();

        try {
            if (produtoSelecionado == null || tipoMovimentacao == null || qtdStr.isEmpty() || JTextData.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }
            LocalDateTime data = LocalDateTime.parse(JTextData.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss"));
            int quantidade = Integer.parseInt(qtdStr);

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.");
                return;
            }

            int estoqueAtual = produtoSelecionado.getQuantidadeEstoque();
            int novaQuantidade;

            if (tipoMovimentacao == TipoMovimentacao.SAIDA) {
                if (quantidade > estoqueAtual) {
                    JOptionPane.showMessageDialog(this, "Quantidade de saída excede o estoque atual (" + estoqueAtual + ").");
                    return;
                }
                novaQuantidade = estoqueAtual - quantidade;
            } else {
                novaQuantidade = estoqueAtual + quantidade;
                if (novaQuantidade > produtoSelecionado.getQuantidadeMaxima()) {
                    JOptionPane.showMessageDialog(this, "Quantidade total após entrada excede o limite máximo (" + produtoSelecionado.getQuantidadeMaxima() + ").");
                    return;
                }
            }

            Movimentacao m = new Movimentacao(0, quantidade, tipoMovimentacao, data, produtoSelecionado);

            boolean retorno = movimentacaoDAO.movimentarEstoque(m);

            if (retorno) {
                JOptionPane.showMessageDialog(this, "Movimentação registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao realizar a movimentação!");
            }

            carregarTabelaMovimentacao();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao registrar movimentação.");
        } finally {
            JTextData.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss")));
            carregarProdutosNoComboBox();
        }
    }//GEN-LAST:event_JBConfirmarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        //fecha a janela
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void comboProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProdutosActionPerformed
    }//GEN-LAST:event_comboProdutosActionPerformed


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
    private javax.swing.JRadioButton JEntrada;
    private javax.swing.JRadioButton JSaida;
    private javax.swing.JTable JTableHistoricoMovimentacoes;
    private javax.swing.JTextField JTextData;
    private javax.swing.JTextField JTextQtd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Produto> comboProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
