package com.psc.view.frmcategoria;

import com.psc.dao.CategoriaDAO;
import com.psc.dao.ProdutoDAO;
import com.psc.model.Categoria;
import com.psc.model.EmbalagemProduto;
import com.psc.model.Produto;
import com.psc.model.TamanhoProduto;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Janela para gerenciar categorias de produto.
 *
 * <p>Permite listar todas as categorias cadastradas, cadastrar novas,
 * editar e excluir categorias. Utiliza {@link CategoriaDAO} para operações
 * de acesso a dados.</p>
 *
 * @author AguiarFabricio
 * @version 1.0
 */
public class FrmGerenciaCategoria extends javax.swing.JFrame {

    /**
     * DAO responsável pelas operações de CRUD em {@link Categoria}.
     */
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    /**
     * DAO responsável pelas operações de CRUD em {@link Produto}.
     */
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    /**
     * Construtor da janela de gerenciamento de categorias.
     * <p>Inicializa componentes da interface e carrega a tabela de categorias.</p>
     */
    public FrmGerenciaCategoria() {
        initComponents();
        carregarTabela();
    }

    /**
     * Carrega todas as categorias existentes no banco de dados e popula a tabela {@code jTableCategoria}.
     * <p>Para cada categoria retornada por {@link CategoriaDAO#listar()}, adiciona uma linha contendo:</p>
     * <ul>
     *   <li>ID da categoria</li>
     *   <li>Nome da categoria</li>
     *   <li>Tamanho (valor de {@link TamanhoProduto})</li>
     *   <li>Embalagem (valor de {@link EmbalagemProduto})</li>
     * </ul>
     */
    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTableCategoria.getModel();
        modelo.setRowCount(0); // limpa as linhas da tabela

        for (Categoria cat : categoriaDAO.listar()) {
            modelo.addRow(new Object[] {
                    cat.getId(),
                    cat.getNome(),
                    cat.getTamanho(),
                    cat.getEmbalagem()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNomeEditar = new javax.swing.JTextField();
        jBCancelar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTFNomeCadastro = new javax.swing.JTextField();
        JBLimpar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();
        JCBTamanho = new javax.swing.JComboBox<>();
        JCBEmbalagem = new javax.swing.JComboBox<>();
        jCBEmbalagem2 = new javax.swing.JComboBox<>();
        jCBTamanho2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Categorias");

        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Tamanho", "Embalagem"
            }
        ));
        jTableCategoria.setToolTipText("");
        jTableCategoria.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableCategoriaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCategoria);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel2.setText("Tamanho");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel3.setText("Embalagem");

        jTFNomeEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeEditarActionPerformed(evt);
            }
        });

        jBCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBAlterar.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        JBApagar.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel4.setText("Gerenciar Categorias");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel5.setText("Cadastrar Categoria");

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel7.setText("Nome");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel8.setText("Tamanho");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel9.setText("Embalagem");

        JBLimpar.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        JBCadastrar.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        JCBTamanho.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        JCBTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(TamanhoProduto.values()));
        JCBTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBTamanhoActionPerformed(evt);
            }
        });

        JCBEmbalagem.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        JCBEmbalagem.setModel(new javax.swing.DefaultComboBoxModel<>(EmbalagemProduto.values()));

        jCBEmbalagem2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jCBEmbalagem2.setModel(new javax.swing.DefaultComboBoxModel<>(EmbalagemProduto.values()));

        jCBTamanho2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jCBTamanho2.setModel(new javax.swing.DefaultComboBoxModel<>(TamanhoProduto.values()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(237, 237, 237)
                        .addComponent(jLabel4)
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JCBTamanho, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JCBEmbalagem, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(JBCadastrar))
                                            .addComponent(JTFNomeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(197, 197, 197)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(jBAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(JBApagar)
                                .addGap(61, 61, 61))
                            .addComponent(jScrollPane1)
                            .addComponent(jTFNomeEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBTamanho2, 0, 456, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBEmbalagem2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFNomeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNomeEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBTamanho2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JCBTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCBEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBLimpar)
                            .addComponent(JBCadastrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBCancelar)
                            .addComponent(jBAlterar)
                            .addComponent(JBApagar))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBEmbalagem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNomeEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeEditarActionPerformed

    /**
     * Ação executada ao clicar no botão "Cancelar".
     * <p>Fecha a janela atual liberando todos os recursos da interface gráfica.</p>
     *
     * @param evt evento de clique no botão Cancelar
     */
    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    /**
     * Ação executada ao clicar no botão "Limpar".
     * <p>Limpa os campos de cadastro, resetando o campo de texto para o nome
     * e definindo o primeiro item nos JComboBox de tamanho e embalagem.</p>
     *
     * @param evt evento de clique no botão Limpar
     */
    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        JTFNomeCadastro.setText("");
        JCBTamanho.setSelectedIndex(0);
        JCBEmbalagem.setSelectedIndex(0);
    }//GEN-LAST:event_JBLimparActionPerformed

    /**
     * Evento chamado quando a tabela de categorias é adicionada ao ancestor.
     * <p>Não implementado atualmente.</p>
     *
     * @param evt evento de ancestralidade adicionado à JTable
     */
    private void jTableCategoriaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableCategoriaAncestorAdded
        // Não implementado
    }//GEN-LAST:event_jTableCategoriaAncestorAdded

    /**
     * Ação executada ao clicar no botão "Cadastrar".
     * <p>Valida o nome informado, seleciona os itens de tamanho e embalagem
     * e cria uma nova {@link Categoria}. Em seguida, persiste no banco de dados
     * via {@link CategoriaDAO#inserir(Categoria)}, atualiza a tabela e exibe mensagem
     * de sucesso ou erro em caso de exceção.</p>
     *
     * @param evt evento de clique no botão Cadastrar
     */
    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        try {
            if (JTFNomeCadastro.getText().length() < 2) {
                throw new Exception("O nome da categoria deve ter ao menos 2 caracteres.");
            }

            String nome = JTFNomeCadastro.getText();
            TamanhoProduto tamanhoSelecionado = (TamanhoProduto) JCBTamanho.getSelectedItem();
            EmbalagemProduto embalagemSelecionada = (EmbalagemProduto) JCBEmbalagem.getSelectedItem();

            Categoria novaCategoria = new Categoria(0, nome, tamanhoSelecionado, embalagemSelecionada);
            categoriaDAO.inserir(novaCategoria);
            carregarTabela();
            JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_JBCadastrarActionPerformed

    /**
     * Ação executada ao alterar seleção no JComboBox de tamanho no cadastro.
     * <p>Não implementado atualmente.</p>
     *
     * @param evt evento de seleção no JComboBox JCBTamanho
     */
    private void JCBTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBTamanhoActionPerformed
        // Não implementado
    }//GEN-LAST:event_JCBTamanhoActionPerformed

    /**
     * Evento executado ao clicar em uma linha da tabela de categorias.
     * <p>Preenche os campos de edição (nome, tamanho e embalagem) com os valores
     * da categoria selecionada, facilitando a operação de atualização.</p>
     *
     * @param evt evento de clique na JTable jTableCategoria
     */
    private void jTableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCategoriaMouseClicked
        int linhaSelecionada = jTableCategoria.getSelectedRow();

        if (linhaSelecionada != -1) {
            String nome = jTableCategoria.getValueAt(linhaSelecionada, 1).toString();
            TamanhoProduto tamanho = (TamanhoProduto) jTableCategoria.getValueAt(linhaSelecionada, 2);
            EmbalagemProduto embalagem = (EmbalagemProduto) jTableCategoria.getValueAt(linhaSelecionada, 3);

            jTFNomeEditar.setText(nome);
            jCBTamanho2.setSelectedItem(tamanho);
            jCBEmbalagem2.setSelectedItem(embalagem);
        }
    }//GEN-LAST:event_jTableCategoriaMouseClicked

    /**
     * Ação executada ao clicar no botão "Alterar".
     * <p>Verifica se uma categoria está selecionada na tabela, lê os novos dados
     * dos campos de edição, cria um objeto {@link Categoria} atualizado e o envia
     * ao {@link CategoriaDAO#atualizar(Categoria)}. Exibe mensagem de sucesso ou erro
     * conforme o resultado e atualiza a tabela de categorias.</p>
     *
     * @param evt evento de clique no botão Alterar
     */
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        int selectedRow = jTableCategoria.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma categoria para alterar.");
            return;
        }

        int id = Integer.parseInt(jTableCategoria.getValueAt(selectedRow, 0).toString());
        String nome = jTFNomeEditar.getText();
        TamanhoProduto tamanho = (TamanhoProduto) jCBTamanho2.getSelectedItem();
        EmbalagemProduto embalagem = (EmbalagemProduto) jCBEmbalagem2.getSelectedItem();

        Categoria categoriaAtualizada = new Categoria(id, nome, tamanho, embalagem);
        boolean sucesso = categoriaDAO.atualizar(categoriaAtualizada);

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso!");
            carregarTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar categoria.");
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    /**
     * Ação executada ao clicar no botão "Apagar".
     * <p>Verifica se uma categoria está selecionada, solicita confirmação ao usuário
     * e, em caso afirmativo, chama {@link CategoriaDAO#deletar(int)} para remover a categoria.
     * Exibe mensagem de sucesso ou erro e atualiza a tabela sempre ao final.</p>
     *
     * @param evt evento de clique no botão Apagar
     */
    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        try {
            int id;
            if (jTableCategoria.getSelectedRow() == -1) {
                throw new Exception("Primeiro selecione uma categoria para APAGAR.");
            } else {
                id = Integer.parseInt(jTableCategoria.getValueAt(jTableCategoria.getSelectedRow(), 0).toString());
            }

            List<Produto> produtos = produtoDAO.listar();
            boolean temProdutoNaCategoria = produtos.stream()
                    .anyMatch(p -> p.getCategoria().getId() == id);

            if (temProdutoNaCategoria) {
                JOptionPane.showMessageDialog(this, "Não é possível apagar esta categoria porque há produtos associados a ela.\n"
                        + "Por favor, exclua ou altere a categoria desses produtos primeiro.");
                return;
            }

            int respostaUsuario = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja apagar esta categoria?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (respostaUsuario == JOptionPane.YES_OPTION) {
                if (categoriaDAO.deletar(id)) {
                    JOptionPane.showMessageDialog(this, "Categoria apagada com sucesso!");
                    jTFNomeEditar.setText("");
                    jCBTamanho2.setSelectedIndex(-1);
                    jCBEmbalagem2.setSelectedIndex(-1);
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao apagar a categoria.");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            carregarTabela();
        }
    }//GEN-LAST:event_JBApagarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGerenciaCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBLimpar;
    private javax.swing.JComboBox<EmbalagemProduto> JCBEmbalagem;
    private javax.swing.JComboBox<TamanhoProduto> JCBTamanho;
    private javax.swing.JTextField JTFNomeCadastro;
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JComboBox<EmbalagemProduto> jCBEmbalagem2;
    private javax.swing.JComboBox<TamanhoProduto> jCBTamanho2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNomeEditar;
    private javax.swing.JTable jTableCategoria;
    // End of variables declaration//GEN-END:variables
}
