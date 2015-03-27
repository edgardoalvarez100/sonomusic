/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Cl_Conectar;
import Clases.Cl_Proveedor;
import Clases.Cl_Varios;
import Forms.frm_reg_compra_prod;
import Forms.frm_reg_compra_serv;
import Forms.frm_reg_proveedor;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis-d
 */
public class frm_ver_proveedores extends javax.swing.JInternalFrame {
Cl_Conectar con = new Cl_Conectar();
Cl_Varios ven = new Cl_Varios();
Cl_Proveedor pro = new Cl_Proveedor();
DefaultTableModel mostrar;
public static String funcion = "proveedor";
int i;
    /**
     * Creates new form frm_ver_proveedores
     */
    public frm_ver_proveedores() {
        initComponents();
        txt_bus.requestFocus();
        
        String query = "select * from proveedor order by raz_soc_pro asc";
        ver_proveedor(query);
    }

    
    private void ver_proveedor (String query){
      try {
        mostrar = new DefaultTableModel()
 {@Override
     public boolean isCellEditable (int fila, int columna) {
         return false;
     }
 };
        Statement st= con.conexion();
        ResultSet rs = con.consulta(st, query);
        
        //La cantidad de columnas que tiene la consulta
       
        //Establecer como cabezeras el nombre de las colimnas
        mostrar.addColumn("RUC");
        mostrar.addColumn("Razon Social");
        mostrar.addColumn("Telefono");
        mostrar.addColumn("Contacto");
        mostrar.addColumn("Estado");
        
        //Creando las filas para el JTable
        while (rs.next()) {
            Object[] fila = new Object[5];
            fila[0]=rs.getObject("ruc_pro");
            fila[1]=rs.getObject("raz_soc_pro");
            fila[2]=rs.getObject("tel_pro");
            fila[3]=rs.getObject("contacto");
            if (rs.getString("estado").equals("1")) {
                fila[4] = "ACTIVO";
            } else {
                fila[4] = "-";
            }
            mostrar.addRow(fila);
        }
        con.cerrar(st);
        con.cerrar(rs);
        t_proveedor.setModel(mostrar);
        t_proveedor.getColumnModel().getColumn(0).setPreferredWidth(80);
        t_proveedor.getColumnModel().getColumn(1).setPreferredWidth(300);
        t_proveedor.getColumnModel().getColumn(2).setPreferredWidth(150);
        t_proveedor.getColumnModel().getColumn(3).setPreferredWidth(60);
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

        btn_cer = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_proveedor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ver Proveedor");

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_edit.png"))); // NOI18N
        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        t_proveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        t_proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_proveedorMousePressed(evt);
            }
        });
        t_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_proveedorKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_proveedor);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_add.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mod))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frm_reg_proveedor proveedor = new frm_reg_proveedor();
        ven.llamar_ventana(proveedor);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_proveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_proveedorKeyPressed
        int i = t_proveedor.getSelectedRow();
        
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            txt_bus.setText("");
            txt_bus.requestFocus();
        }
        
        if (evt.getKeyCode()==KeyEvent.VK_SPACE) {
            if (funcion.equals("compra_prod")) {
                frm_reg_compra_prod compra_pro = null;
                pro.setRuc(t_proveedor.getValueAt(i, 0).toString());
                try {
                    Statement st = con.conexion();
                    String ver_pro = "select * from proveedor where ruc_pro = '"+pro.getRuc()+"'";
                    ResultSet rs = con.consulta(st, ver_pro);
                    if (rs.next()) {
                        compra_pro.txt_ruc.setText(pro.getRuc());
                        compra_pro.txt_raz.setText(rs.getString("raz_soc_pro"));
                        compra_pro.txt_dir.setText(rs.getString("dir_pro"));
                        compra_pro.txt_tel.setText(rs.getString("tel_pro"));
                        compra_pro.cbx_alm.setEnabled(true);
                        compra_pro.cbx_alm.requestFocus();
                        this.dispose();
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
            
                if (funcion.equals("compra_serv")) {
                frm_reg_compra_serv compra_serv = null;
                pro.setRuc(t_proveedor.getValueAt(i, 0).toString());
                try {
                    Statement st = con.conexion();
                    String ver_pro = "select * from proveedor where ruc_pro = '"+pro.getRuc()+"'";
                    ResultSet rs = con.consulta(st, ver_pro);
                    if (rs.next()) {
                        compra_serv.txt_ruc.setText(pro.getRuc());
                        compra_serv.txt_raz.setText(rs.getString("raz_soc_pro"));
                        compra_serv.txt_dir.setText(rs.getString("dir_pro"));
                        compra_serv.txt_tel.setText(rs.getString("tel_pro"));
                        compra_serv.cbx_tipa.setSelectedIndex(0);
                        compra_serv.cbx_tipa.setEnabled(true);
                        compra_serv.cbx_tipa.requestFocus();
                        this.dispose();
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
                
            } 
                if (funcion.equals("compras_prov")) {
                   pro.setRuc(t_proveedor.getValueAt(i, 0).toString());
                   Map<String, Object> parametros = new HashMap<>();
                   parametros.put("proveedor", pro.getRuc());
                   ven.ver_reporte("rpt_compras_proveedor", parametros);
                   this.dispose();
                }
                funcion = "proveedor";
        }
        
    }//GEN-LAST:event_t_proveedorKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
        String bus = txt_bus.getText();
        String query = "select * from proveedor where ruc_pro like '%"+bus+"%' or "
                + "raz_soc_pro like '%"+bus+"%' order by raz_soc_pro asc";
        ver_proveedor(query);
        }
    }//GEN-LAST:event_txt_busKeyPressed

    private void t_proveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_proveedorMousePressed
        i = t_proveedor.getSelectedRow();
        pro.setRuc(t_proveedor.getValueAt(i, 0).toString());
        btn_mod.setEnabled(true);
    }//GEN-LAST:event_t_proveedorMousePressed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
    }//GEN-LAST:event_btn_modActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_proveedor;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
}
