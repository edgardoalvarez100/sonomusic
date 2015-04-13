/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Cl_Almacen;
import Clases.Cl_Conectar;
import Clases.Cl_Productos;
import Clases.Cl_Varios;
import Clases.table_render;
import Forms.frm_reg_almacen;
import Forms.frm_rpt_fechas;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lorenzo
 */
public class frm_ver_almacen extends javax.swing.JInternalFrame {

    Cl_Conectar con = new Cl_Conectar();
    Cl_Varios ven = new Cl_Varios();
    Cl_Productos pro = new Cl_Productos();
    Cl_Almacen alm = new Cl_Almacen();
    DefaultTableModel mostrar;
    Integer i;
    public static String ventana = "almacen";

    /**
     * Creates new form frm_ver_almacen
     */
    public frm_ver_almacen() {
        initComponents();

        String query = "select * from almacen order by nom_alm asc";
        ver_almacen(query);
    }

    private void ver_almacen(String query) {
        try {
            mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            Statement st = con.conexion();
            ResultSet rs = con.consulta(st, query);
            mostrar.addColumn("Id");
            mostrar.addColumn("Nombre");
            mostrar.addColumn("Direccion");
            mostrar.addColumn("Ruc");
            mostrar.addColumn("Razon Social");
            mostrar.addColumn("Ciudad");
            mostrar.addColumn("Estado");

            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getObject("idAlmacen");
                fila[1] = rs.getObject("nom_alm");
                fila[2] = rs.getObject("dir_alm");
                fila[3] = rs.getObject("ruc");
                fila[4] = rs.getObject("raz_soc");
                fila[5] = rs.getObject("ciudad");
                if (rs.getString("estado").equals("1")) {
                    fila[6] = "ACTIVO";
                } else {
                    fila[6] = "-";
                }

                mostrar.addRow(fila);
            }
            con.cerrar(st);
            con.cerrar(rs);
            t_almacen.setModel(mostrar);
            t_almacen.getColumnModel().getColumn(0).setPreferredWidth(20);
            t_almacen.getColumnModel().getColumn(1).setPreferredWidth(100);
            t_almacen.getColumnModel().getColumn(2).setPreferredWidth(250);
            t_almacen.getColumnModel().getColumn(3).setPreferredWidth(100);
            t_almacen.getColumnModel().getColumn(4).setPreferredWidth(250);
            t_almacen.getColumnModel().getColumn(5).setPreferredWidth(80);
            t_almacen.getColumnModel().getColumn(6).setPreferredWidth(80);
            mostrar.fireTableDataChanged();
        } catch (SQLException e) {
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

        btn_mod = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_almacen = new javax.swing.JTable();
        btn_pred = new javax.swing.JButton();
        btn_ver = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));
        setClosable(true);
        setTitle("Ver Almacen");

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_edit.png"))); // NOI18N
        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Buscar:");

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_almacen.setModel(new javax.swing.table.DefaultTableModel(
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
        t_almacen.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        t_almacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_almacenMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_almacenMousePressed(evt);
            }
        });
        t_almacen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_almacenKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_almacen);

        btn_pred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/house.png"))); // NOI18N
        btn_pred.setText("Predeterminar");
        btn_pred.setEnabled(false);
        btn_pred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_predActionPerformed(evt);
            }
        });

        btn_ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/sockets.png"))); // NOI18N
        btn_ver.setText("Ver Materiales");
        btn_ver.setEnabled(false);
        btn_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verActionPerformed(evt);
            }
        });

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
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mod))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_pred)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pred, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        frm_reg_almacen almacen = new frm_reg_almacen();
        ven.llamar_ventana(almacen);
        this.dispose();
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void t_almacenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_almacenMousePressed
        i = t_almacen.getSelectedRow();
        btn_pred.setEnabled(true);
        btn_ver.setEnabled(true);
    }//GEN-LAST:event_t_almacenMousePressed

    private void btn_predActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_predActionPerformed
        try {
            alm.setNom(t_almacen.getValueAt(i, 1).toString());
            String ruta = "almacen.txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            if (archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(alm.getNom());
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(alm.getNom());
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Se ha establecido correctamente.\nReingrese al Sistema");
            System.exit(0);
        } catch (IOException ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event_btn_predActionPerformed


    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        frm_ver_prod_alm mat = new frm_ver_prod_alm();
        mat.txt_ida.setText(t_almacen.getValueAt(i, 0).toString());
        mat.txt_noma.setText(t_almacen.getValueAt(i, 1).toString());

        String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, p.costo_compra, p.estado, c.desc_clas, "
                + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos "
                + "inner join clasificacion as c on p.id_clas=c.id_clas inner join und_medida as u on "
                + "p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + t_almacen.getValueAt(i, 0).toString() + "' order by p.desc_pro asc";
        pro.mostrar_productos(query);
        mat.t_productos.setDefaultRenderer(Object.class, new table_render());
        ven.llamar_ventana(mat);
        this.dispose();

    }//GEN-LAST:event_btn_verActionPerformed

    private void t_almacenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_almacenKeyPressed

    }//GEN-LAST:event_t_almacenKeyPressed

    private void t_almacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_almacenMouseClicked
        if (evt.getClickCount() == 2) {

            if (ventana.equals("rpt_venta_alm")) {
                frm_rpt_fechas fec = new frm_rpt_fechas();
                fec.rpt = "venta_almacen";
                int id = (int) t_almacen.getValueAt(i, 0);
                fec.alm.setId(id);
                ven.llamar_ventana(fec);
                ventana = "";
                this.dispose();
            }
            // REPORTE DE PRODUCTO EN ALMACEN
            if (ventana.equals("rpt_prod_alm")) {
                int id = (int) t_almacen.getValueAt(i, 0);
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("idalm", id);
                ven.ver_reporte("rpt_prod_alm", parametros);
                this.dispose();
            }
            // GANANCIA EN ALMACEN
            if (ventana.equals("rpt_ganancia_almacen")) {
                int id = (int) t_almacen.getValueAt(i, 0);
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("idalm", id);
                ven.ver_reporte("rpt_utilidad_almacen", parametros);
                this.dispose();
            }
        }

    }//GEN-LAST:event_t_almacenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_pred;
    private javax.swing.JButton btn_reg;
    private javax.swing.JButton btn_ver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_almacen;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
}
