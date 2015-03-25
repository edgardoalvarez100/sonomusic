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
import Forms.frm_reg_solicitud;
import Forms.frm_reg_venta;
import Forms.frm_rpt_fechas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis-d
 */
public class frm_ver_prod_alm extends javax.swing.JInternalFrame {

    Cl_Varios ven = new Cl_Varios();
    Cl_Conectar con = new Cl_Conectar();
    Cl_Productos pro = new Cl_Productos();
    Cl_Almacen alm = new Cl_Almacen();
    public static DefaultTableModel mostrar;
    public static String funcion = "producto_almacen";
    Integer i;

    /**
     * Creates new form frm_ver_mat_alm
     */
    public frm_ver_prod_alm() {
        initComponents();

        txt_bus.requestFocus();
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
        t_productos = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_ida = new javax.swing.JTextField();
        txt_noma = new javax.swing.JTextField();
        btn_kar = new javax.swing.JButton();
        cbx_bus = new javax.swing.JComboBox();
        btn_mod = new javax.swing.JButton();

        setTitle("Ver Productos en Almacen");

        t_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        t_productos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t_productos.setRowHeight(20);
        t_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_productosMousePressed(evt);
            }
        });
        t_productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_productosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_productos);

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busKeyTyped(evt);
            }
        });

        jLabel1.setText("Buscar:");

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        jLabel2.setText("Almacen");

        txt_ida.setEditable(false);
        txt_ida.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_noma.setEditable(false);

        btn_kar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/clipboard_text.png"))); // NOI18N
        btn_kar.setText("Ver Kardex");
        btn_kar.setEnabled(false);
        btn_kar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_karActionPerformed(evt);
            }
        });

        cbx_bus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "DISPONIBLES", "POR TERMINAR ", "TERMINADO" }));
        cbx_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_busKeyPressed(evt);
            }
        });

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_edit.png"))); // NOI18N
        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ida, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_noma, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_kar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mod)
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
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_noma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_productosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_productosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txt_bus.setText("");
            txt_bus.requestFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            i = t_productos.getSelectedRow();
            if (funcion.equals("solicitar")) {
                Object fila[] = new Object[5];
                fila[0] = t_productos.getValueAt(i, 0);                                         //COD PRO
                fila[1] = t_productos.getValueAt(i, 1);                                         // DESCRIPCION
                fila[2] = t_productos.getValueAt(i, 2);                                         // MARCA
                fila[3] = t_productos.getValueAt(i, 6);                                         // CANTIDAD
                fila[4] = t_productos.getValueAt(i, 4);                                         // UND MED

                frm_reg_solicitud pedido = null;
                pro.setId_pro((int) t_productos.getValueAt(i, 0));
                Integer filas_tabla = pedido.t_solicitud.getRowCount();
                Integer copiado = 0;
                if (filas_tabla > 0) {
                    for (int x = 0; x < filas_tabla; x++) {
                        Integer id_pro_tabla;
                        id_pro_tabla = Integer.parseInt(pedido.t_solicitud.getValueAt(x, 0).toString());
                        if (id_pro_tabla == pro.getId_pro()) {
                            copiado++;
                        }
                    }
                    if (copiado == 0) {
                        pedido.detalle.addRow(fila);
                        pedido.txt_id_pro.requestFocus();
                        pedido.btn_reg.setEnabled(true);
                        funcion = "material_almacen";
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Se esta escogiendo un producto ya existente");
                    }
                } else {
                    pedido.detalle.addRow(fila);
                    pedido.txt_id_pro.requestFocus();
                    pedido.btn_reg.setEnabled(true);
                    funcion = "material_almacen";
                    this.dispose();
                }
            }
            //venta
            if (funcion.equals("venta")) {
                Object fila[] = new Object[6];
                fila[0] = t_productos.getValueAt(i, 0);                                         //COD PRO
                fila[1] = t_productos.getValueAt(i, 1);                                         // DESCRIPCION
                fila[2] = t_productos.getValueAt(i, 2);                                         // MARCA
                fila[3] = "1.00";                                                               // CANTIDAD
                fila[4] = t_productos.getValueAt(i, 4);                                         // UND MED
                fila[5] = t_productos.getValueAt(i, 5);                                         // precio
                frm_reg_venta venta = null;
                int prod = (int) t_productos.getValueAt(i, 0);
                Integer filas_tabla = frm_reg_venta.t_detalle.getRowCount();
                Integer copiado = 0;
                if (filas_tabla > 0) {
                    for (int x = 0; x < filas_tabla; x++) {
                        Integer id_pro_tabla;
                        id_pro_tabla = Integer.parseInt(venta.t_detalle.getValueAt(x, 0).toString());
                        if (id_pro_tabla == prod) {
                            copiado++;
                        }
                    }
                    if (copiado == 0) {
                        frm_reg_venta.detalle.addRow(fila);
                        frm_reg_venta.t_detalle.setModel(frm_reg_venta.detalle);
                        frm_reg_venta.txt_id.requestFocus();
                        frm_reg_venta.subtotal();
                        frm_reg_venta.total();
                        funcion = "material_almacen";
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Se esta escogiendo un producto ya existente");
                    }
                } else {
                    frm_reg_venta.detalle.addRow(fila);
                    frm_reg_venta.t_detalle.setModel(frm_reg_venta.detalle);
                    frm_reg_venta.txt_id.requestFocus();
                    frm_reg_venta.subtotal();
                    frm_reg_venta.total();
                    funcion = "material_almacen";
                    this.dispose();
                }
            }

            //traslado
            if (funcion.equals("traslado")) {
//                Object fila[] = new Object[5];
//                fila[0] = t_productos.getValueAt(i, 0);                                         //COD PRO
//                fila[1] = t_productos.getValueAt(i, 1);                                         // DESCRIPCION
//                fila[2] = t_productos.getValueAt(i, 2);                                         // MARCA
//                fila[3] = "1.00";                                                               // CANTIDAD
//                fila[4] = t_productos.getValueAt(i, 4);                                         // UND MED
//
//                frm_reg_venta venta = null;
//                int prod=(int) t_productos.getValueAt(i, 0);
//                Integer filas_tabla = frm_reg_venta.t_detalle.getRowCount();
//                Integer copiado = 0;
//                if (filas_tabla > 0) {
//                    for (int x = 0; x < filas_tabla; x++) {
//                        Integer id_pro_tabla;
//                        id_pro_tabla = Integer.parseInt(venta.t_detalle.getValueAt(x, 0).toString());
//                        if (id_pro_tabla==prod) {
//                            copiado++;
//                        }
//                    }
//                    if (copiado == 0) {
//                        frm_reg_venta.detalle.addRow(fila);
//                        frm_reg_venta.t_detalle.setModel(frm_reg_venta.detalle);
//                        frm_reg_venta.txt_id.requestFocus();
//                        frm_reg_venta.btn_reg.setEnabled(true);
//                        funcion = "material_almacen";
//                        this.dispose();
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Se esta escogiendo un producto ya existente");
//                    }
//                } else {
//                    frm_reg_venta.detalle.addRow(fila);
//                    frm_reg_venta.t_detalle.setModel(frm_reg_venta.detalle);
//                    frm_reg_venta.txt_id.requestFocus();
//                    frm_reg_venta.btn_reg.setEnabled(true);
//                    funcion = "material_almacen";
//                    this.dispose();
//                }
            }
        }
    }//GEN-LAST:event_t_productosKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        funcion = "material_almacen";
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void btn_karActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_karActionPerformed
        frm_rpt_fechas rpt = new frm_rpt_fechas();
        rpt.rpt = "kardex";
        rpt.pro.setId_pro(Integer.parseInt(t_productos.getValueAt(i, 0).toString()));
        rpt.alm.setId(Integer.parseInt(txt_ida.getText()));
        ven.llamar_ventana(rpt);
    }//GEN-LAST:event_btn_karActionPerformed

    private void t_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_productosMousePressed
        i = t_productos.getSelectedRow();
        btn_kar.setEnabled(true);
    }//GEN-LAST:event_t_productosMousePressed

    private void cbx_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_busKeyPressed
        if (cbx_bus.getSelectedIndex() == 0) {
            String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.estado, c.desc_clas, "
                    + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos "
                    + "inner join clasificacion as c on p.id_clas=c.id_clas inner join und_medida as u on "
                    + "p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + txt_ida.getText() + "' order by p.desc_pro asc";
            pro.mostrar_productos(query);
        } 
        //falta demas oopciones del combo
    }//GEN-LAST:event_cbx_busKeyPressed

    private void txt_busKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyTyped
        String texto = txt_bus.getText();
        String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.estado, c.desc_clas, "
                + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos "
                + "inner join clasificacion as c on p.id_clas=c.id_clas inner join und_medida as u on "
                + "p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + txt_ida.getText() + "' and (p.desc_pro like '%" + texto + "%' or p.modelo "
                + "like '%" + texto + "%' or p.serie like '%" + texto + "%' or p.marca like '%" + texto + "%')  order by p.desc_pro asc";
        pro.mostrar_productos(query);          
    }//GEN-LAST:event_txt_busKeyTyped

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if (!txt_bus.getText().isEmpty()) {
                t_productos.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_busKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_kar;
    private javax.swing.JButton btn_mod;
    private javax.swing.JComboBox cbx_bus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_productos;
    private javax.swing.JTextField txt_bus;
    public static javax.swing.JTextField txt_ida;
    public static javax.swing.JTextField txt_noma;
    // End of variables declaration//GEN-END:variables
}
