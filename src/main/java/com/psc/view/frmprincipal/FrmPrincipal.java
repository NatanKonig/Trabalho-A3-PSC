package com.psc.view.frmprincipal;

import com.psc.view.frmcategoria.FrmGerenciaCategoria;
import com.psc.view.frmmovimentar.FrmMovimentarEstoque;
import com.psc.view.frmproduto.FrmGerenciarProdutos;
import com.psc.view.frmrelatorio.FrmRelatorio;

/**
 * Janela principal da aplicação, que serve como ponto de entrada para acessar
 * as funcionalidades de gerenciamento de produtos, categorias, movimentação de estoque
 * e geração de relatórios.
 *
 * <p>A partir desta janela, o usuário pode navegar para outras telas específicas
 * clicando nos botões correspondentes.</p>
 *
 * @author NatanKonig
 * @version 1.0
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Construtor padrão que inicializa os componentes da interface.
     */
    public FrmPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBProduto = new javax.swing.JButton();
        JBCategoria = new javax.swing.JButton();
        JBMovimentar = new javax.swing.JButton();
        JBRelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Estoque");

        JBProduto.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/h32create_product.png"))); // NOI18N
        JBProduto.setText("Gerenciar Produtos");
        JBProduto.setMaximumSize(new java.awt.Dimension(243, 32));
        JBProduto.setMinimumSize(new java.awt.Dimension(243, 32));
        JBProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBProdutoActionPerformed(evt);
            }
        });

        JBCategoria.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/h36create_category.png"))); // NOI18N
        JBCategoria.setText("Gerenciar Categorias");
        JBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCategoriaActionPerformed(evt);
            }
        });

        JBMovimentar.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBMovimentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/h40create_movement.png"))); // NOI18N
        JBMovimentar.setText("Movimentar Estoque");
        JBMovimentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMovimentarActionPerformed(evt);
            }
        });

        JBRelatorio.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/h42show_report.png"))); // NOI18N
        JBRelatorio.setText("Vizualizar Relatórios");
        JBRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRelatorioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/h15management_stock.png"))); // NOI18N
        jLabel1.setText("Gerenciamento de Estoque");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBMovimentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBMovimentar))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBRelatorio))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ação executada ao clicar no botão "Produto".
     * <p>Abre a janela de gerenciamento de produtos {@link FrmGerenciarProdutos}.</p>
     *
     * @param evt evento de ação disparado ao clicar no botão Produto
     */
    private void JBProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBProdutoActionPerformed
        FrmGerenciarProdutos janelaGerenciarProdutos = new FrmGerenciarProdutos();
        janelaGerenciarProdutos.setVisible(true);
    }//GEN-LAST:event_JBProdutoActionPerformed

    /**
     * Ação executada ao clicar no botão "Categoria".
     * <p>Abre a janela de gerenciamento de categorias {@link FrmGerenciaCategoria}.</p>
     *
     * @param evt evento de ação disparado ao clicar no botão Categoria
     */
    private void JBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCategoriaActionPerformed
        FrmGerenciaCategoria janelaGerenciarCategorias = new FrmGerenciaCategoria();
        janelaGerenciarCategorias.setVisible(true);
    }//GEN-LAST:event_JBCategoriaActionPerformed

    /**
     * Ação executada ao clicar no botão "Movimentar".
     * <p>Abre a janela de movimentação de estoque {@link FrmMovimentarEstoque}.</p>
     *
     * @param evt evento de ação disparado ao clicar no botão Movimentar
     */
    private void JBMovimentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMovimentarActionPerformed
        FrmMovimentarEstoque janelaMovimentarEstoque = new FrmMovimentarEstoque();
        janelaMovimentarEstoque.setVisible(true);
    }//GEN-LAST:event_JBMovimentarActionPerformed

    /**
     * Ação executada ao clicar no botão "Relatório".
     * <p>Abre a janela de relatórios {@link FrmRelatorio}.</p>
     *
     * @param evt evento de ação disparado ao clicar no botão Relatório
     */
    private void JBRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRelatorioActionPerformed
        FrmRelatorio janelaExibirRelatorios = new FrmRelatorio();
        janelaExibirRelatorios.setVisible(true);
    }//GEN-LAST:event_JBRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCategoria;
    private javax.swing.JButton JBMovimentar;
    private javax.swing.JButton JBProduto;
    private javax.swing.JButton JBRelatorio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
