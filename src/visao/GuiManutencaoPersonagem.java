package visao;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PersonagemVO;
import servicos.PersonagemServicos;
import servicos.ServicosFactory;

/**
 *
 * @author Douglas
 */
public class GuiManutencaoPersonagem extends javax.swing.JInternalFrame {

    /* Criando um modelo de tabela padrão 
     com o nome das colunas */
    DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Código", "Nome", "Sexo", "Idade", "Cidade", "Insignias", "Pokemons Capturados", "acessoSaffari"});

    public GuiManutencaoPersonagem() {
        initComponents();
        preencherTabela();
    }

    private void preencherTabela() {
        try {

            //Buscando objeto PersonagemServicos     
            PersonagemServicos ps = ServicosFactory.getPersonagemServicos();

            /* Criando um ArrayList<PersonagemVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<PersonagemVO> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em personagems
            prod = ps.buscarPersonagem();

            for (int i = 0; i < prod.size(); i++) {
                dtm.addRow(new String[]{
                    String.valueOf(prod.get(i).getIdPersonagem()),
                    prod.get(i).getNome(),
                    String.valueOf(prod.get(i).getSexo()),
                    String.valueOf(prod.get(i).getIdade()),
                    String.valueOf(prod.get(i).getCidade()),
                    String.valueOf(prod.get(i).getInsignia()),
                    String.valueOf(prod.get(i).getPokemonsCapturado()),
                    String.valueOf(prod.get(i).getSaffari())
                });
            }//fecha for

            /* Adicionando o modelo de tabela 
             com os dados na tabela personagems */
            jtablePersonagem.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "ERROuuuuuuuuuu! " + e.getMessage());
        }//fecha catch
    }//fecha preencherTabela

    private void limparTabela() {
        /* Para limpar a tabela temos que setar o número de
           linhas para zero no default table model */
        dtm.setNumRows(0);
    }//fecha limparTabela

    private void deletar() {
        try {
            int linha = jtablePersonagem.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(
                        rootPane,
                        "Selecione uma linha!");
            } else {
                String id = jtablePersonagem.getValueAt(linha, 0).toString();
                PersonagemServicos PS = ServicosFactory.getPersonagemServicos();
                PS.deletarPersonagem(Long.parseLong(id));

                JOptionPane.showMessageDialog(
                        rootPane,
                        "Personagem excluido com sucesso!");
            }//fecha else
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    rootPane,
                    "Erro! " + e.getMessage());
        }//fecha catch
    }//fecha deletar
   



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jtPesq = new javax.swing.JTextField();
        jcomboFiltro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablePersonagem = new javax.swing.JTable();
        jlPesq = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jbPreencher = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPesqKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPesqKeyReleased(evt);
            }
        });

        jcomboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "Sexo", "Idade", "Cidade", "Insígnia", "Pokemons Capturados", "Saffari" }));
        jcomboFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcomboFiltroItemStateChanged(evt);
            }
        });
        jcomboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboFiltroActionPerformed(evt);
            }
        });

        jtablePersonagem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtablePersonagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6", "Título 7"
            }
        ));
        jtablePersonagem.setToolTipText("");
        jScrollPane1.setViewportView(jtablePersonagem);

        jlPesq.setText("Pesquisa no BD:");

        jLayeredPane1.setLayer(jtPesq, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jcomboFiltro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jlPesq, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jcomboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbPreencher.setText("Preencher");
        jbPreencher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPreencherActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbDeletar.setText("Deletar");
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jbPreencher, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jbLimpar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jbDeletar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264)
                .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(jbDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2)
                    .addComponent(jLayeredPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPesqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesqKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_jtPesqKeyPressed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limparTabela();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jcomboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboFiltroActionPerformed

    private void jbPreencherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPreencherActionPerformed
        limparTabela();
        preencherTabela();
    }//GEN-LAST:event_jbPreencherActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        deletar();
        limparTabela();
        preencherTabela();
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jtPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesqKeyReleased
        limparTabela();
        
    }//GEN-LAST:event_jtPesqKeyReleased

    private void jcomboFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcomboFiltroItemStateChanged
         limparTabela();
        
    }//GEN-LAST:event_jcomboFiltroItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbPreencher;
    private javax.swing.JComboBox<String> jcomboFiltro;
    private javax.swing.JLabel jlPesq;
    private javax.swing.JTextField jtPesq;
    private javax.swing.JTable jtablePersonagem;
    // End of variables declaration//GEN-END:variables
}