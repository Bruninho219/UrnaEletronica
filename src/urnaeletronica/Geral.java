package urnaeletronica;
import java.sql.*;
import BD.ConexaoBD;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Geral extends javax.swing.JFrame
{
    Connection conecta = null;
    PreparedStatement pst = null;
    ResultSet rs = null; 
        
    public Geral() throws ClassNotFoundException
    {
        initComponents();
        conecta = ConexaoBD.conecta();
        ListarTabela();
        this.setResizable(false);
    }
    
    public void TabelaFull() throws ClassNotFoundException
    {
        ResultadoGeral j = new ResultadoGeral();  
        j.setVisible(true);
        dispose();
    }
    
    public void Deletar(int del) throws SQLException
    {
        String sql = "delete from politico where idpolitico= " + del;
        pst = conecta.prepareStatement(sql);
        JOptionPane.showMessageDialog(null, "Usuário deletado!");
        NumeroCad.setText("");
        pst.execute();
    }
    
    public void Cadastrar()
    {
        String sql = "Insert into politico(idpolitico, nome, curso, voto) values(?, ?, ?, ?)";
        int id=0, voto=0;
        boolean condNum=false;
        
        String num = NumeroCad.getText();
        
        //VALIDA INTEIRO
        for(int i=0; i<999; i++)
        {
            String j = Integer.toString(i);
            
            if(num.equals(j))
            {
                condNum=true;
                id = Integer.parseInt(num);
            }
            else
            {
                condNum = condNum==true;
            }
        }
        
        if(condNum==false)
        {
            JOptionPane.showMessageDialog(null, "Informe um Código válido!");
            NumeroCad.setText("");
        }
        
        else
        {     
            try
            {
                pst = conecta.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setString(2, NomeCad.getText());
                pst.setString(3, CursoCad.getText());
                pst.setInt(4, voto);
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Usuário " + NomeCad.getText() + " cadastrado!");
                ListarTabela();
                NumeroCad.setText("");
                CursoCad.setText("");
                NomeCad.setText("");
            }
            catch (SQLException error)
            {
                //AQUI ONDE ESTA O PK REPITIDA
                JOptionPane.showMessageDialog(null, "Verifique a quantidade de caracteres, ou tente outro número", "ERRO", HEIGHT, null);
            }
        }
    }
    
    public void ListarTabela()
    {
        String sql;
        sql = "Select idpolitico as Numero, nome as Nome, curso as Curso, voto as Votos from politico";
        
        try
        {
            pst=conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            Tabela.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NomeCad = new java.awt.TextField();
        NumeroCad = new java.awt.TextField();
        CursoCad = new java.awt.TextField();
        btnDeletar = new java.awt.Button();
        btnCadastrar = new java.awt.Button();
        btnRelatorio = new java.awt.Button();
        Voltar = new java.awt.Button();
        Atualiza = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabela);

        jLabel5.setText("Nome:");

        jLabel3.setText("Codigo:");

        jLabel6.setText("Curso:");

        btnDeletar.setLabel("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeletarActionPerformed(evt);
            }
        });

        btnCadastrar.setLabel("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnRelatorio.setLabel("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRelatorioActionPerformed(evt);
            }
        });

        Voltar.setLabel("<<");
        Voltar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                VoltarActionPerformed(evt);
            }
        });

        Atualiza.setLabel("Atualiza");
        Atualiza.setName(""); // NOI18N
        Atualiza.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AtualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NumeroCad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CursoCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(NomeCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomeCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CursoCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumeroCad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6))))
                    .addComponent(Atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        try
        {
            TabelaFull();
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Geral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        Main m;
        try
        {
            m = new Main();
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ResultadoGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        //JOptionPane.showMessageDialog(null, "Em breve");
        String d=NumeroCad.getText();
        int del;
        del = Integer.parseInt(d);
        try
        {
            Deletar(del);
            ListarTabela();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Geral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void AtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizaActionPerformed
        ListarTabela();
    }//GEN-LAST:event_AtualizaActionPerformed


    public static void main(String args[])
    {
  
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                try
                {
                    new Geral().setVisible(true);
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(Geral.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Atualiza;
    private java.awt.TextField CursoCad;
    private java.awt.TextField NomeCad;
    private java.awt.TextField NumeroCad;
    private javax.swing.JTable Tabela;
    private java.awt.Button Voltar;
    private java.awt.Button btnCadastrar;
    private java.awt.Button btnDeletar;
    private java.awt.Button btnRelatorio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}