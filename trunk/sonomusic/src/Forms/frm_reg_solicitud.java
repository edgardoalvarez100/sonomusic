/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Clases.Cl_Almacen;
import Clases.Cl_Conectar;
import Clases.Cl_Productos;
import Clases.Cl_Requerimiento;
import Clases.Cl_Varios;
import Vistas.frm_ver_prod_alm;
import Vistas.frm_ver_solicitudes;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sonomusic.frm_menu;

/**
 *
 * @author luis-d
 */
public class frm_reg_solicitud extends javax.swing.JInternalFrame {

    Cl_Varios ven = new Cl_Varios();
    Cl_Conectar con = new Cl_Conectar();
    Cl_Almacen alm = new Cl_Almacen();
    Cl_Productos pro = new Cl_Productos();
    Cl_Requerimiento req = new Cl_Requerimiento();
    public static DefaultTableModel detalle;
    public static int idsol = 0;

    /**
     * Creates new form frm_reg_solicitud
     */
    public frm_reg_solicitud() {
        initComponents();
        cbx_des.requestFocus();
        detalle = new DefaultTableModel();
// {@Override
//     public boolean isCellEditable (int fila, int columna) {
//         return false;
//     }
// };
        detalle.addColumn("Id");
        detalle.addColumn("Descripcion");
        detalle.addColumn("Marca");
        detalle.addColumn("Cantidad");
        detalle.addColumn("Und. Med.");
        t_solicitud.setModel(detalle);
        t_solicitud.getColumnModel().getColumn(0).setPreferredWidth(30);
        t_solicitud.getColumnModel().getColumn(1).setPreferredWidth(300);
        t_solicitud.getColumnModel().getColumn(2).setPreferredWidth(90);
        t_solicitud.getColumnModel().getColumn(3).setPreferredWidth(60);
        t_solicitud.getColumnModel().getColumn(4).setPreferredWidth(80);
        btn_env.setVisible(false);
        
        cargar_almacen();
    }

    private void cargar_almacen() {
        try {
            Statement st = con.conexion();
            String query = "select * from almacen";
            ResultSet rs = con.consulta(st, query);

            while (rs.next()) {
                String cap;
                cap = rs.getString("nom_alm");
                cbx_des.addItem(cap);
            }

            con.cerrar(st);
            con.cerrar(rs);
        } catch (Exception e) {
            System.out.println("Ocurrio un error " + e.getMessage() + " en :" + e.getLocalizedMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id_ori = new javax.swing.JTextField();
        txt_nom_ori = new javax.swing.JTextField();
        txt_fec = new javax.swing.JFormattedTextField();
        spn_dias = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_id_pro = new javax.swing.JTextField();
        txt_nom_pro = new javax.swing.JTextField();
        btn_bus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_solicitud = new javax.swing.JTable();
        btn_cer = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        btn_env = new javax.swing.JButton();
        cbx_des = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(254, 254, 254));
        setClosable(true);
        setTitle("Crear Pedido");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("DATOS DEL PEDIDO");
        jLabel1.setToolTipText("");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Tienda Origen:");
        jLabel2.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Tienda Destino:");
        jLabel3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Fecha Solicitud:");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(212, 2, 2));
        jLabel5.setText("Dias Plazo:");
        jLabel5.setFocusable(false);

        txt_id_ori.setEditable(false);
        txt_id_ori.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_ori.setFocusable(false);

        txt_nom_ori.setEditable(false);
        txt_nom_ori.setFocusable(false);

        txt_fec.setEditable(false);
        try {
            txt_fec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fec.setFocusable(false);
        txt_fec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fecKeyPressed(evt);
            }
        });

        spn_dias.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9, 1));
        spn_dias.setEnabled(false);
        spn_dias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spn_diasKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Detalle de Articulos:");
        jLabel7.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(212, 2, 2));
        jLabel8.setText("Id:");
        jLabel8.setFocusable(false);

        txt_id_pro.setEditable(false);
        txt_id_pro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_proActionPerformed(evt);
            }
        });
        txt_id_pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id_proKeyPressed(evt);
            }
        });

        txt_nom_pro.setEditable(false);
        txt_nom_pro.setFocusable(false);

        btn_bus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/find.png"))); // NOI18N
        btn_bus.setEnabled(false);
        btn_bus.setFocusable(false);
        btn_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busActionPerformed(evt);
            }
        });

        jScrollPane1.setFocusable(false);

        t_solicitud.setModel(new javax.swing.table.DefaultTableModel(
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
        t_solicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_solicitudKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_solicitudKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(t_solicitud);

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setFocusable(false);
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/accept.png"))); // NOI18N
        btn_reg.setText("Solicitar");
        btn_reg.setFocusable(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_env.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/add.png"))); // NOI18N
        btn_env.setText("Enviar Ped.");
        btn_env.setEnabled(false);
        btn_env.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_envActionPerformed(evt);
            }
        });
        btn_env.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_envKeyPressed(evt);
            }
        });

        cbx_des.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_desKeyPressed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_id_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_nom_pro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_bus))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_id_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_nom_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbx_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spn_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_env)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nom_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_des, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spn_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_id_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nom_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_env))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.dispose();

    }//GEN-LAST:event_btn_cerActionPerformed

    private void txt_fecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_fec.getText().trim().length() == 10) {
                spn_dias.setEnabled(true);
                spn_dias.requestFocus();
            } else {
                txt_fec.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_fecKeyPressed

    private void spn_diasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spn_diasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!spn_dias.getValue().equals("0")) {
                txt_id_pro.setEditable(true);
                btn_bus.setEnabled(true);
                txt_id_pro.requestFocus();
            }
        }
    }//GEN-LAST:event_spn_diasKeyPressed

    private void txt_id_proKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_proKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btn_bus.doClick();
        }
    }//GEN-LAST:event_txt_id_proKeyPressed

    private void btn_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busActionPerformed
        // Buscar Productos que estan por terminar
        frm_ver_prod_alm mat = new frm_ver_prod_alm();
        frm_menu menu = null;
        String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.costo_compra, p.estado, c.desc_clas, "
                + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos inner join clasificacion as "
                + "c on p.id_clas=c.id_clas inner join und_medida as u on p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + menu.alm.getId() + "' "
                + "and pa.cant <= p.cant_min and pa.cant = '0' order by p.desc_pro asc";
        pro.mostrar_productos(query, mat.t_productos);
        mat.funcion = "solicitar";
        mat.txt_ida.setText("" + menu.alm.getId());
        mat.txt_noma.setText(menu.alm.getNom());
        ven.llamar_ventana(mat);
    }//GEN-LAST:event_btn_busActionPerformed

    private void t_solicitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_solicitudKeyReleased
    }//GEN-LAST:event_t_solicitudKeyReleased

    private void txt_id_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_proActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_proActionPerformed

    private void llenar() {
        frm_menu menu = null;
        req.setAlm_ori(menu.alm.getId());
        req.setAlm_des(cbx_des.getSelectedIndex() + 1);
        req.setDias(Integer.parseInt(spn_dias.getValue().toString()));
        req.setFec_rea("7000-01-01");
        req.setFec_sol(ven.fechabase(txt_fec.getText()));
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
//grabar pedido
        try {
            Statement st = con.conexion();
            String ins_ped = "insert into solicitud_articulos Values (null, '" + req.getFec_sol() + "', '" + req.getFec_rea() + "','" + req.getDias() + "',"
                    + "'" + req.getAlm_ori() + "','" + req.getAlm_des() + "', '0', '" + frm_menu.usu.getNick() + "')";
            con.actualiza(st, ins_ped);
            con.cerrar(st);
            System.out.println("insertado con exito \n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            System.out.print(ex);
        }

        // consultar id pedido;
        try {
            Statement st = con.conexion();
            String ver_ped = "select idsolicitud from solicitud_articulos where fec_sol = '" + req.getFec_sol() + "' "
                    + "and nick = '" + frm_menu.usu.getNick() + "' order by idsolicitud desc limit 1";
            ResultSet rs = con.consulta(st, ver_ped);
            if (rs.next()) {
                req.setId(rs.getInt("idsolicitud"));
            }
            con.cerrar(rs);
            con.cerrar(st);
            System.out.println("el id es " + req.getId() + " \n");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            int nro_filas = t_solicitud.getRowCount();
            for (int j = 0; j < nro_filas; j++) {
                pro.setId_pro(Integer.parseInt(t_solicitud.getValueAt(j, 0).toString()));
                pro.setCan(Double.parseDouble(t_solicitud.getValueAt(j, 3).toString()));
                Statement st = con.conexion();
                String det_ped = "insert into detalle_solicitud Values ('" + req.getId() + "', '" + pro.getId_pro() + "', '" + pro.getCan() + "', '0')";
                con.actualiza(st, det_ped);
                con.cerrar(st);
                System.out.println("insertado linea " + j + " con exito \n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //grabar detalle pedido
        frm_ver_solicitudes soli = new frm_ver_solicitudes();
        ven.llamar_ventana(soli);
        this.dispose();
    }//GEN-LAST:event_btn_regActionPerformed

    private void t_solicitudKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_solicitudKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int i = t_solicitud.getSelectedRow();
            int idp = Integer.parseInt(t_solicitud.getValueAt(i, 0).toString());
            try {
                Statement st = con.conexion();
                String ver_pro = "select idProductos from producto_almacen where"
                        + " idProductos = '" + idp + "' and idAlmacen = '" + frm_menu.alm.getId() + "'";
                ResultSet rs = con.consulta(st, ver_pro);
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "El Producto no existe en su almacen");
                    t_solicitud.setValueAt("0", i, 5);
                    btn_env.setEnabled(false);
                } else {
                    btn_env.setEnabled(true);
                    btn_env.requestFocus();
                }
                con.cerrar(rs);
                con.cerrar(st);
            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        //RECORRER TABLA Y DETECTA PRODUCTOS
        int nro_filas = t_solicitud.getRowCount();
        for (int j = 0; j < nro_filas; j++) {
            int idp = Integer.parseInt(t_solicitud.getValueAt(j, 0).toString());
            try {
                Statement st = con.conexion();
                String ver_pro = "select idProductos from producto_almacen where"
                        + " idProductos = '" + idp + "' and idAlmacen = '" + frm_menu.alm.getId() + "'";
                ResultSet rs = con.consulta(st, ver_pro);
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "El Producto no existe en su almacen");
                    t_solicitud.setValueAt("0", j, 5);
                    btn_env.setEnabled(false);
                } else {
                    btn_env.setEnabled(true);
                }
                con.cerrar(rs);
                con.cerrar(st);
            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_t_solicitudKeyPressed

    private void btn_envKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_envKeyPressed

    }//GEN-LAST:event_btn_envKeyPressed

    private void btn_envActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envActionPerformed
        frm_reg_traslado_almacen traslado = new frm_reg_traslado_almacen();
        int idalm = Integer.parseInt(txt_id_ori.getText());
        traslado.cbx_alm_de.setEnabled(false);
        traslado.cbx_alm_de.setSelectedIndex(Integer.parseInt(txt_id_ori.getText()) - 1);
        System.out.println(idalm);
        try {
            Statement st = con.conexion();
            String ver_alm = "select ruc, raz_soc from Almacen where idAlmacen = '" + idalm + "'";
            ResultSet rs = con.consulta(st, ver_alm);
            if (rs.next()) {
                traslado.txt_ruc_alm.setText(rs.getString("ruc"));
                traslado.txt_raz_alm.setText(rs.getString("raz_soc"));
            }
            con.cerrar(rs);
            con.cerrar(st);
        } catch (Exception e) {
            System.out.println(e);
        }
        traslado.idsol = idsol;

        traslado.txt_fec.setEditable(true);
        traslado.txt_fec.requestFocus();

        int filas_tabla = t_solicitud.getRowCount();
        for (int j = 0; j < filas_tabla; j++) {
            if (Integer.parseInt(t_solicitud.getValueAt(j, 5).toString()) != 0) {
                Object[] fila = new Object[5];
                fila[0] = t_solicitud.getValueAt(j, 0);
                fila[1] = t_solicitud.getValueAt(j, 1);
                fila[2] = t_solicitud.getValueAt(j, 2);
                fila[3] = t_solicitud.getValueAt(j, 5);
                fila[4] = t_solicitud.getValueAt(j, 4);
                traslado.detalle.addRow(fila);
            }
        }
        traslado.t_detalle.setModel(traslado.detalle);
        traslado.btn_enviar.setEnabled(true);
        traslado.accion = "traslado";
        ven.llamar_ventana(traslado);
        this.dispose();
    }//GEN-LAST:event_btn_envActionPerformed

    private void cbx_desKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_desKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_fec.setText(ven.fechaformateada(ven.getFechaActual()));
            txt_fec.setEditable(true);
            txt_fec.setFocusable(true);
            txt_fec.requestFocus();
        }
    }//GEN-LAST:event_cbx_desKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bus;
    private javax.swing.JButton btn_cer;
    public static javax.swing.JButton btn_env;
    public static javax.swing.JButton btn_reg;
    public static javax.swing.JComboBox cbx_des;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JSpinner spn_dias;
    public static javax.swing.JTable t_solicitud;
    public static javax.swing.JFormattedTextField txt_fec;
    public static javax.swing.JTextField txt_id_ori;
    public static javax.swing.JTextField txt_id_pro;
    public static javax.swing.JTextField txt_nom_ori;
    private javax.swing.JTextField txt_nom_pro;
    // End of variables declaration//GEN-END:variables
}
