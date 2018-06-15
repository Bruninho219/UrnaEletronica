package urnaeletronica;

import javax.sound.sampled.*;
import java.sql.*;
import BD.ConexaoBD;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Main extends javax.swing.JFrame
{
    Connection conecta = null;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public String user="C:/Users/Bruno/Documents/NetBeansProjects/UrnaEletronica/src/Imagens/user.png";
    private BufferedImage imagem;
    public Clip clip;
    public String ruta = "/Audio/";
    int x=0, y, contx=0;
    int[] vet = new int[3];
    int[] vet2 = new int[1000];
    boolean cond=false;
    boolean anular=false;
    
    public Main() throws ClassNotFoundException
    {
        initComponents();
        setLocationRelativeTo(null);
        //setResizable(false);
        con = ConexaoBD.conecta();
        this.setResizable(false);
    }
    
    /*
    public void AddAdm() throws SQLException
    {
        String sql = "Insert into login(adm, senha) values(?, ?)";
        pst = conecta.prepareStatement(sql);
        pst.setString(1, "");
        pst.setString(2, "");
        pst.execute();
    }
    */
    
    public void Som(String arquivo)
    {
        try
        {
            clip=AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + arquivo + ".wav")));
            clip.start();
            
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e)
        {}
    }
        
    public void Imagem(int y)
    {
        String img = "C:/Users/Bruno/Documents/NetBeansProjects/UrnaEletronica/src/Imagens/" + y + ".png";
        
        imagem=null;
        try
        {
            imagem = ImageIO.read( new File(img));
        }
        catch(IOException exc)
        {
            Imagem.setIcon(new javax.swing.ImageIcon(user));
        }
        
        if(imagem != null)
        {
            Imagem.setIcon(new javax.swing.ImageIcon(img));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        panel2 = new java.awt.Panel();
        panel3 = new java.awt.Panel();
        numero = new java.awt.Label();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        curso = new java.awt.Label();
        label3 = new java.awt.Label();
        nome1 = new java.awt.Label();
        Imagem = new javax.swing.JLabel();
        panel4 = new java.awt.Panel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnConfirma = new javax.swing.JButton();
        btnCorrige = new javax.swing.JButton();
        btnBranco = new javax.swing.JButton();
        btnConfig = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 2147483647, 2147483647));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setBackground(new java.awt.Color(255, 255, 254));

        panel3.setBackground(new java.awt.Color(204, 204, 204));

        numero.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        label1.setText("Nome:");

        label2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        label2.setText("Numero:");

        label3.setText("Curso:");

        Imagem.setBackground(new java.awt.Color(0, 0, 0));
        Imagem.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user.png"))); // NOI18N
        Imagem.setPreferredSize(new java.awt.Dimension(80, 100));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Imagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Imagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 270));

        panel4.setBackground(new java.awt.Color(0, 0, 0));
        panel4.setLayout(null);

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn1ActionPerformed(evt);
            }
        });
        panel4.add(btn1);
        btn1.setBounds(90, 20, 49, 40);

        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn2ActionPerformed(evt);
            }
        });
        panel4.add(btn2);
        btn2.setBounds(150, 20, 49, 40);

        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn3ActionPerformed(evt);
            }
        });
        panel4.add(btn3);
        btn3.setBounds(210, 20, 49, 40);

        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn4ActionPerformed(evt);
            }
        });
        panel4.add(btn4);
        btn4.setBounds(90, 70, 49, 40);

        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn5ActionPerformed(evt);
            }
        });
        panel4.add(btn5);
        btn5.setBounds(150, 70, 49, 40);

        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn6ActionPerformed(evt);
            }
        });
        panel4.add(btn6);
        btn6.setBounds(210, 70, 49, 40);

        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn7ActionPerformed(evt);
            }
        });
        panel4.add(btn7);
        btn7.setBounds(90, 120, 49, 40);

        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn8ActionPerformed(evt);
            }
        });
        panel4.add(btn8);
        btn8.setBounds(150, 120, 49, 40);

        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn9ActionPerformed(evt);
            }
        });
        panel4.add(btn9);
        btn9.setBounds(210, 120, 49, 40);

        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn0ActionPerformed(evt);
            }
        });
        panel4.add(btn0);
        btn0.setBounds(150, 170, 49, 40);

        btnConfirma.setBackground(new java.awt.Color(51, 255, 51));
        btnConfirma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConfirma.setText("CONFIRMA");
        btnConfirma.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnConfirmaActionPerformed(evt);
            }
        });
        panel4.add(btnConfirma);
        btnConfirma.setBounds(230, 210, 100, 40);

        btnCorrige.setBackground(new java.awt.Color(255, 102, 0));
        btnCorrige.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCorrige.setText("CORRIGE");
        btnCorrige.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCorrigeActionPerformed(evt);
            }
        });
        panel4.add(btnCorrige);
        btnCorrige.setBounds(130, 220, 90, 30);

        btnBranco.setBackground(new java.awt.Color(255, 255, 254));
        btnBranco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBranco.setText("BRANCO");
        btnBranco.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBrancoActionPerformed(evt);
            }
        });
        panel4.add(btnBranco);
        btnBranco.setBounds(30, 220, 90, 30);

        btnConfig.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnConfigActionPerformed(evt);
            }
        });
        panel4.add(btnConfig);
        btnConfig.setBounds(330, 0, 10, 10);

        getContentPane().add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 340, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void ExecutarVoto(int y) throws SQLException
    {
        if(anular==true)
        {
            anular=false;
            vet2[contx]=1000;
            contx++;
            String sql="update politico " +
                       "set voto = + 1 " +
                       "where idpolitico= 000";

            pst =  con.prepareStatement(sql);
            pst.executeUpdate(sql);
        }
        else
        {
            vet2[contx]=y;
            contx++;
            String sql="update urna.politico " +
                       "set voto = voto + 1 " +
                       "where idpolitico=" + y + ";";
            
            //pst = con.prepareStatement(sql);
            //rs = pst.executeQuery();
            
            pst =  con.prepareStatement(sql);
            pst.executeUpdate(sql);
        }
    }
    
    public void Registrar(int y) throws SQLException
    {
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        //String date = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(timestamp.getTime());
        String sql = "Insert into historico(id, dataa) values("+ y +",now())";
        
        pst =  con.prepareStatement(sql);
        pst.executeUpdate(sql);
    }
    
    public void Votar(int y)
    {
        Imagem(y);
        String sql;

        String j = Integer.toString(y);
        sql="Select * " +
            "from politico " +
            "where idpolitico=" + j;
        
        try
        {
            PreparedStatement comando =con.prepareStatement(sql);
            ResultSet rs =comando.executeQuery();
            
            if(rs.next())
            {
                this.curso.setText(rs.getString("curso"));
                this.nome1.setText(rs.getString("nome"));
            }
            else
            {
                this.curso.setText("");
                this.nome1.setText("Anular...");
                anular=true;
            }
        }
        catch (SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    private void btn0ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn0ActionPerformed
    {//GEN-HEADEREND:event_btn0ActionPerformed
        if(x<3)
        {
            vet[x]=0;
            x++;
            numero.setText(numero.getText()+ btn0.getText());
        }
        if(x==3)
        {
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn1ActionPerformed
    {//GEN-HEADEREND:event_btn1ActionPerformed
        if(x<3)
        {
            vet[x]=1;
            x++;
            numero.setText(numero.getText()+ btn1.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
        //numero.setText(numero.getText()+ btn1.getText());
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn2ActionPerformed
    {//GEN-HEADEREND:event_btn2ActionPerformed
        if(x<3)
        {
            vet[x]=2;
            x++;
            numero.setText(numero.getText()+ btn2.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn3ActionPerformed
    {//GEN-HEADEREND:event_btn3ActionPerformed
        if(x<3)
        {
            vet[x]=3;
            x++;
            numero.setText(numero.getText()+ btn3.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn4ActionPerformed
    {//GEN-HEADEREND:event_btn4ActionPerformed
        if(x<3)
        {
            vet[x]=4;
            x++;
            numero.setText(numero.getText()+ btn4.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn5ActionPerformed
    {//GEN-HEADEREND:event_btn5ActionPerformed
        if(x<3)
        {
            vet[x]=5;
            x++;
            numero.setText(numero.getText()+ btn5.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn6ActionPerformed
    {//GEN-HEADEREND:event_btn6ActionPerformed
        if(x<3)
        {
            vet[x]=6;
            x++;
            numero.setText(numero.getText()+ btn6.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn7ActionPerformed
    {//GEN-HEADEREND:event_btn7ActionPerformed
        if(x<3)
        {
            vet[x]=7;
            x++;
            numero.setText(numero.getText()+ btn7.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn8ActionPerformed
    {//GEN-HEADEREND:event_btn8ActionPerformed
        if(x<3)
        {
            vet[x]=8;
            x++;
            numero.setText(numero.getText()+ btn8.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn9ActionPerformed
    {//GEN-HEADEREND:event_btn9ActionPerformed
        if(x<3)
        {
            vet[x]=9;
            x++;
            numero.setText(numero.getText()+ btn9.getText());
        }
        if(x==3)
        {
            //faz pesquisa no banco e printa
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            Votar(y);
        }  
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnBrancoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBrancoActionPerformed
    {//GEN-HEADEREND:event_btnBrancoActionPerformed
        if(x==0)
        {
            numero.setText("000");
            vet[0]=0;
            vet[1]=0;
            vet[2]=0;
            x=4;
            cond=true;
            curso.setText("---");
            nome1.setText("Branco");
            Imagem.setIcon(new javax.swing.ImageIcon(user));
        }
    }//GEN-LAST:event_btnBrancoActionPerformed

    private void btnCorrigeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCorrigeActionPerformed
    {//GEN-HEADEREND:event_btnCorrigeActionPerformed
        //PRONTO
        numero.setText("");
        x=0;
        vet[0]=0;
        vet[1]=0;
        vet[2]=0;
        cond=false;
        curso.setText("");
        nome1.setText("");
        Imagem.setIcon(new javax.swing.ImageIcon(user));
    }//GEN-LAST:event_btnCorrigeActionPerformed
    
    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnConfirmaActionPerformed
    {//GEN-HEADEREND:event_btnConfirmaActionPerformed
        if(x==3)
        {
            cond=true;
        }
        if(cond==true)
        {
            //computa o voto no banco
            y= vet[0]*100 + vet[1]* 10 + vet[2];
            try
            {
                ExecutarVoto(y);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try
            {
                Registrar(y);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            Som("Confirma");
            numero.setText("");
            vet[0]=0;
            vet[1]=0;
            vet[2]=0;
            x=0;
            cond=false;
            curso.setText("");
            nome1.setText("");
            Imagem.setIcon(new javax.swing.ImageIcon(user));
        }
    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        try
        {
            Login l = new Login();
            l.setVisible(true);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfigActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new Main().setVisible(true);
                }
                catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBranco;
    private java.awt.Button btnConfig;
    private javax.swing.JButton btnConfirma;
    private javax.swing.JButton btnCorrige;
    private java.awt.Label curso;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label nome1;
    private java.awt.Label numero;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    // End of variables declaration//GEN-END:variables
}