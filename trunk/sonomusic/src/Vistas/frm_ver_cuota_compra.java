/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Cl_Compra;
import Clases.Cl_Conectar;
import Clases.Cl_Varios;
import Forms.frm_reg_cuota;
import Forms.frm_reg_pago_compra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dereck
 */
public class frm_ver_cuota_compra extends javax.swing.JInternalFrame {

    Cl_Varios ven = new Cl_Varios();
    Cl_Conectar con = new Cl_Conectar();
    public Cl_Compra com = new Cl_Compra();
    public DefaultTableModel mostrar;
    public static String origen;
    public static String periodo;
    public static int moneda;
    int i;

    /**
     * Creates new form frm_ver_cuota_compra
     */
    public frm_ver_cuota_compra() {
        initComponents();
    }

    public double tot_cuotas() {
        double total = 0;
        int filas = t_cuotas.getRowCount();
        for (int j = 0; j < filas; j++) {
            total += Double.parseDouble(t_cuotas.getValueAt(j, 2).toString());
        }
        return total;
    }

    public double pendiente() {
        double pendiente = 0;
        double total = Double.parseDouble(txt_dtot.getText());
        pendiente = total - tot_cuotas();
        return pendiente;
    }

    public double pagado() {
        double pagado = 0;
        int filas = t_cuotas.getRowCount();
        for (int j = 0; j < filas; j++) {
            if (t_cuotas.getValueAt(j, 4).equals("Pagado")) {
                pagado += Double.parseDouble(t_cuotas.getValueAt(j, 6).toString());
            }
        }
        return pagado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
        txt_raz = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_tipd = new javax.swing.JTextField();
        txt_sndoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fec = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_mon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_tc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btn_addc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_cuotas = new javax.swing.JTable();
        btn_elic = new javax.swing.JButton();
        btn_verd = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        btn_regp = new javax.swing.JButton();
        txt_dtot = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_pag = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_pen = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Ver Cuotas por Pagos de Compras");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Datos del Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.red));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Proveedor.");

        txt_ruc.setEditable(false);
        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_raz.setEditable(false);

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Documento:");

        txt_tipd.setEditable(false);

        txt_sndoc.setEditable(false);
        txt_sndoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Fecha de Compra");

        txt_fec.setEditable(false);
        try {
            txt_fec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fec.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Moneda.");

        txt_mon.setEditable(false);
        txt_mon.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("TC");

        txt_tc.setEditable(false);
        txt_tc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_raz, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tipd, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mon, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_tc))
                            .addComponent(txt_sndoc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_raz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tipd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sndoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuotas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.red));

        btn_addc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/add.png"))); // NOI18N
        btn_addc.setText("Agregar Cuotas");
        btn_addc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcActionPerformed(evt);
            }
        });

        t_cuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nro. Cuota", "Fec. Pago", "Fec. Venc.", "Monto", "Estado"
            }
        ));
        t_cuotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_cuotasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_cuotas);

        btn_elic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cross.png"))); // NOI18N
        btn_elic.setText("Eliminar");
        btn_elic.setEnabled(false);
        btn_elic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elicActionPerformed(evt);
            }
        });

        btn_verd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/clipboard_text.png"))); // NOI18N
        btn_verd.setText("Ver Detalle de Pago");

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        btn_regp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/coins.png"))); // NOI18N
        btn_regp.setText("Registrar Pago");
        btn_regp.setEnabled(false);
        btn_regp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regpActionPerformed(evt);
            }
        });

        txt_dtot.setEditable(false);
        txt_dtot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Deuda Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_regp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_addc))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_elic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_verd)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_dtot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cer)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_regp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_dtot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_elic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_verd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total Cuotas:");

        txt_tot.setEditable(false);
        txt_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Monto Pagado:");

        txt_pag.setEditable(false);
        txt_pag.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Monto Pendiente:");

        txt_pen.setEditable(false);
        txt_pen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcActionPerformed
        frm_reg_cuota reg = new frm_reg_cuota();
        frm_reg_cuota.periodo = periodo;
        frm_reg_cuota.moneda= moneda;
        frm_reg_cuota.com.setTotal(com.getTotal());
        reg.com.setId(com.getId());
        ven.llamar_ventana(reg);
    }//GEN-LAST:event_btn_addcActionPerformed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        frm_ver_compras compras = new frm_ver_compras();
        ven.llamar_ventana(compras);
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void t_cuotasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cuotasMousePressed
        i = t_cuotas.getSelectedRow();
        String estado = t_cuotas.getValueAt(i, 7).toString();
        if (estado.equals("Pendiente")) {
            btn_regp.setEnabled(true);
            btn_elic.setEnabled(true);
            btn_verd.setEnabled(true);
        } else {
            btn_regp.setEnabled(false);
        }

    }//GEN-LAST:event_t_cuotasMousePressed

    private void btn_regpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regpActionPerformed
        frm_reg_pago_compra pagar = new frm_reg_pago_compra();
        pagar.txt_ruc.setText(txt_ruc.getText());
        pagar.txt_raz.setText(txt_raz.getText());
        pagar.txt_tido.setText(txt_tipd.getText());
        pagar.txt_ser.setText(txt_sndoc.getText());
        pagar.txt_deu.setText(txt_dtot.getText());
        pagar.idpago = t_cuotas.getValueAt(i, 0).toString();

        Double actual = 0.0;
        Double pagado = 0.0;
        actual = Double.parseDouble(txt_dtot.getText());
        try {
            Statement st = con.conexion();
            String ver_pagos = "select sum(monto) as pagos from pago_compras where idCompra = '" + com.getId() + "' and estado = '1'";
            ResultSet rs = con.consulta(st, ver_pagos);
            if (rs.next()) {
                pagado = rs.getDouble("pagos");
                pagar.pagado = rs.getDouble("pagos");
                pagar.txt_pag.setText(ven.formato_numero(rs.getDouble("pagos")));
            } else {
                pagar.txt_pag.setText("0.00");
            }
        } catch (SQLException es) {
            System.out.print(es);
        }
        Double restante = 0.0;
        restante = actual - pagado;
        pagar.txt_fec.setText(ven.fechaformateada(ven.getFechaActual()));
        pagar.txt_sal.setText(ven.formato_numero(restante));
        pagar.restante = restante;
        pagar.com.setId(com.getId());
        pagar.glosa = "PAGO DE COMPRA - " + txt_tipd.getText() + " / " + txt_sndoc.getText() + " - " + txt_ruc.getText();
        ven.llamar_ventana(pagar);
        this.dispose();
    }//GEN-LAST:event_btn_regpActionPerformed

    private void btn_elicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elicActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar la compra?");
        if (JOptionPane.OK_OPTION == confirmado) {
            int id = Integer.parseInt(t_cuotas.getValueAt(i, 0).toString());
            if (t_cuotas.getValueAt(i, 4).equals("Pendiente")) {
                try {
                    Statement st = con.conexion();
                    String query = "delete from pago_compras where idpago = '" + id + "'";
                    con.actualiza(st, query);
                    con.cerrar(st);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            //CARGAR REGISTROS EN TABLA
            try {

                mostrar = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int fila, int columna) {
                        return false;
                    }
                };
                mostrar.addColumn("Nro Cuota");
                mostrar.addColumn("Fecha Pago");
                mostrar.addColumn("Fec. Venc.");
                mostrar.addColumn("Monto");
                mostrar.addColumn("Estado");
                Statement st = con.conexion();
                String ver_cuotas = "select * from pago_compras where idCompra = '" + com.getId() + "'";
                ResultSet rs = con.consulta(st, ver_cuotas);
                while (rs.next()) {
                    Object fila[] = new Object[5];
                    fila[0] = rs.getString("idpago");
                    if (rs.getString("fec_pago").equals("7000-01-01")) {
                        fila[1] = "-";
                    } else {
                        fila[1] = ven.fechaformateada(rs.getString("fec_pago"));
                    }
                    fila[2] = ven.fechaformateada(rs.getString("fec_venc"));
                    fila[3] = ven.formato_numero(rs.getDouble("monto"));
                    if (rs.getString("estado").equals("0")) {
                        fila[4] = "Pendiente";
                    } else {
                        fila[4] = "Pagado";
                    }
                    mostrar.addRow(fila);
                }
                t_cuotas.setModel(mostrar);
                ven.centrar_celda(t_cuotas, 1);
                ven.centrar_celda(t_cuotas, 2);
                ven.derecha_celda(t_cuotas, 3);
                ven.centrar_celda(t_cuotas, 4);
                con.cerrar(rs);
                con.cerrar(st);
            } catch (Exception e) {
                System.out.println(e);
            }
            txt_dtot.setText(ven.formato_numero(com.getTotal()));
            txt_tot.setText(ven.formato_numero(tot_cuotas()));
            txt_pen.setText(ven.formato_numero(pendiente()));
            txt_pag.setText(ven.formato_numero(pagado()));
        }
    }//GEN-LAST:event_btn_elicActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_addc;
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_elic;
    private javax.swing.JButton btn_regp;
    private javax.swing.JButton btn_verd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_cuotas;
    public static javax.swing.JTextField txt_dtot;
    public static javax.swing.JFormattedTextField txt_fec;
    public static javax.swing.JTextField txt_mon;
    public static javax.swing.JTextField txt_pag;
    public static javax.swing.JTextField txt_pen;
    public static javax.swing.JTextField txt_raz;
    public static javax.swing.JTextField txt_ruc;
    public static javax.swing.JTextField txt_sndoc;
    public static javax.swing.JTextField txt_tc;
    public static javax.swing.JTextField txt_tipd;
    public static javax.swing.JTextField txt_tot;
    // End of variables declaration//GEN-END:variables
}
