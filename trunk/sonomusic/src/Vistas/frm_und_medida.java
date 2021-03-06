/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Cl_Conectar;
import Clases.Cl_Medida;
import Clases.Cl_Varios;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis-d
 */
public class frm_und_medida extends javax.swing.JInternalFrame {
Cl_Conectar con = new Cl_Conectar();
Cl_Varios ven = new Cl_Varios();
Cl_Medida ume = new Cl_Medida();
DefaultTableModel mostrar;
Integer i;
    /**
     * Creates new form frm_und_medida
     */
    public frm_und_medida() {
        initComponents();
        
        String query = "select * from und_medida order by desc_und asc";
        ver_und(query);
    }

    
     private void ver_und (String query){
      try {
        mostrar = new DefaultTableModel()
 {@Override
     public boolean isCellEditable (int fila, int columna) {
         return false;
     }
 };
        Statement st= con.conexion();
        ResultSet rs = con.consulta(st, query);
        mostrar.addColumn("Id");
        mostrar.addColumn("Descripcion");
        
        //Creando las filas para el JTable
        while (rs.next()) {
            Object[] fila = new Object[2];
            fila[0]=rs.getObject("idUnd_Medida");
            fila[1]=rs.getObject("desc_und");
            

            mostrar.addRow(fila);
        }
        con.cerrar(st);
        con.cerrar(rs);
        t_medida.setModel(mostrar);
        t_medida.getColumnModel().getColumn(0).setPreferredWidth(20);
        t_medida.getColumnModel().getColumn(1).setPreferredWidth(100);
        mostrar.fireTableDataChanged();
    }
    catch (SQLException e) {
        System.out.print(e);
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

        btn_gra = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        btn_cer1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_desc = new javax.swing.JTextField();
        btn_mod = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_medida = new javax.swing.JTable();

        setBackground(new java.awt.Color(254, 254, 254));
        setClosable(true);
        setTitle("Ver Und. Medida");

        btn_gra.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_gra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/disk.png"))); // NOI18N
        btn_gra.setText("Grabar");
        btn_gra.setEnabled(false);
        btn_gra.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btn_gra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_graActionPerformed(evt);
            }
        });

        btn_reg.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_cer1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_cer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer1.setText("Cerrar");
        btn_cer1.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btn_cer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cer1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Id:");

        txt_id.setEditable(false);

        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Descripcion:");

        btn_mod.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_edit.png"))); // NOI18N
        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);
        btn_mod.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_medida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        t_medida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_medidaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_medida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_reg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_mod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btn_cer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_gra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_desc, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btn_gra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btn_cer1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenar () {
    ume.setDes_med(txt_desc.getText());
    }
    
    private void btn_cer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cer1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cer1ActionPerformed

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        Statement st = con.conexion();
        String ins_med = "insert into und_medida Values (null, '"+ume.getDes_med()+"')";
        con.actualiza(st, ins_med);
        con.cerrar(st);
        ume.setDes_med("");
        txt_desc.setText("");
        txt_desc.requestFocus();
        String query = "select * from und_medida order by desc_und asc";
        ver_und(query);
        
                
    }//GEN-LAST:event_btn_regActionPerformed

    private void t_medidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_medidaMousePressed
        i = t_medida.getSelectedRow();
        btn_mod.setEnabled(true);
    }//GEN-LAST:event_t_medidaMousePressed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        btn_reg.setEnabled(false);
        btn_mod.setEnabled(false);
        btn_gra.setEnabled(true);
        
        ume.setId_med(Integer.parseInt(t_medida.getValueAt(i, 0).toString()));
        ume.setDes_med(t_medida.getValueAt(i, 1).toString());
        
        txt_id.setText(""+ume.getId_med());
        txt_desc.setText(ume.getDes_med());
        
    }//GEN-LAST:event_btn_modActionPerformed

    private void btn_graActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_graActionPerformed
    llenar();
    try {
        Statement st = con.conexion();
        String upd_med = "update und_medida set desc_und = '"+ume.getDes_med()+"' where idUnd_Medida = '"+ume.getId_med()+"'";
        con.actualiza(st, upd_med);
        con.cerrar(st);
    } catch (Exception ex) {
        System.out.print(ex);
    }
    String query = "select * from und_medida order by desc_und asc";
    ver_und(query);
    btn_reg.setEnabled(true);
    btn_gra.setEnabled(false);
    }//GEN-LAST:event_btn_graActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer1;
    private javax.swing.JButton btn_gra;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_reg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_medida;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
