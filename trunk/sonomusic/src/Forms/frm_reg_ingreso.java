/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Clases.Cl_Almacen;
import Clases.Cl_Compra;
import Clases.Cl_Conectar;
import Clases.Cl_Moneda;
import Clases.Cl_Productos;
import Clases.Cl_Proveedor;
import Clases.Cl_Tipo_Documentos;
import Clases.Cl_Varios;
import Clases.render_productos;
import Vistas.frm_ver_ingresos;
import Vistas.frm_ver_productos;
import Vistas.frm_ver_proveedores;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sonomusic.frm_menu;

/**
 *
 * @author luis-d
 */
public class frm_reg_ingreso extends javax.swing.JInternalFrame {
    
    Cl_Conectar con = new Cl_Conectar();
    Cl_Varios ven = new Cl_Varios();
    Cl_Proveedor pro = new Cl_Proveedor();
    Cl_Productos art = new Cl_Productos();
    Cl_Compra com = new Cl_Compra();
    Cl_Almacen alm = new Cl_Almacen();
    Cl_Tipo_Documentos tido = new Cl_Tipo_Documentos();
    Cl_Moneda mon = new Cl_Moneda();
    public static DefaultTableModel detalle;
    Integer i;
    double tc;

    /**
     * Creates new form frm_reg_compra
     */
    public frm_reg_ingreso() {
        initComponents();
        ver_almacen();
        txt_fec_com.setText(ven.fechaformateada(ven.getFechaActual()));
        ver_tido();
        ver_monedas();
        //dar formato a tabla
        detalle = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna == 3 || columna == 5) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        detalle.addColumn("Id");
        detalle.addColumn("Descripcion");
        detalle.addColumn("Marca");
        detalle.addColumn("Cant.");
        detalle.addColumn("Und. Med");
        detalle.addColumn("Precio");
        t_detalle.setModel(detalle);
        t_detalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(1).setPreferredWidth(450);
        t_detalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        detalle.fireTableDataChanged();
    }
    
    private void ver_almacen() {
        try {
            ArrayList almacen = new ArrayList();
            Statement st = con.conexion();
            String query = "select nom_alm from almacen order by idAlmacen asc";
            ResultSet rs = con.consulta(st, query);
            while (rs.next()) {
                almacen.add(rs.getString("nom_alm"));
            }
            if (almacen.size() > 0) {
                for (int j = 0; j < almacen.size(); j++) {
                    cbx_alm.addItem(almacen.get(j));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lista de Almacen no disponible");
            }
            con.cerrar(st);
            con.cerrar(rs);
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, "Lista no disponible");
        }
    }
    
    private void ver_tido() {
        try {
            ArrayList tido = new ArrayList();
            Statement st = con.conexion();
            String query = "select desc_tipd from tipo_doc order by idtipo_doc asc";
            ResultSet rs = con.consulta(st, query);
            while (rs.next()) {
                tido.add(rs.getString("desc_tipd"));
            }
            if (tido.size() > 0) {
                for (int j = 0; j < tido.size(); j++) {
                    cbx_tido.addItem(tido.get(j));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lista no disponible");
            }
            con.cerrar(st);
            con.cerrar(rs);
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
    }
    
    private void ver_monedas() {
        try {
            ArrayList array_mon = new ArrayList();
            Statement st = con.conexion();
            String query = "select nombre from moneda order by idmoneda asc";
            ResultSet rs = con.consulta(st, query);
            while (rs.next()) {
                array_mon.add(rs.getString("nombre"));
            }
            if (array_mon.size() > 0) {
                for (Object object_mon : array_mon) {
                    cbx_mon.addItem(object_mon);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lista no disponible");
            }
            con.cerrar(st);
            con.cerrar(rs);
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
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
        txt_ruc = new javax.swing.JTextField();
        txt_raz = new javax.swing.JTextField();
        btn_busp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbx_alm = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txt_dir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_idp = new javax.swing.JTextField();
        txt_desp = new javax.swing.JTextField();
        btn_busm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_detalle = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_sub = new javax.swing.JTextField();
        txt_igv = new javax.swing.JTextField();
        txt_tot = new javax.swing.JTextField();
        btn_ca = new javax.swing.JButton();
        btn_va = new javax.swing.JButton();
        btn_el = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbx_tido = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txt_ser = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_nro = new javax.swing.JTextField();
        txt_fec_com = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cbx_mon = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txt_tc = new javax.swing.JTextField();

        setBackground(new java.awt.Color(254, 254, 254));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Compra");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("RUC:");
        jLabel1.setFocusable(false);

        txt_ruc.setEditable(false);
        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rucKeyTyped(evt);
            }
        });

        txt_raz.setEditable(false);
        txt_raz.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_raz.setFocusable(false);

        btn_busp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/find.png"))); // NOI18N
        btn_busp.setEnabled(false);
        btn_busp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buspActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Alm. Dest.");
        jLabel3.setFocusable(false);

        cbx_alm.setEnabled(false);
        cbx_alm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_almKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Fecha de Compra:");
        jLabel4.setFocusable(false);

        txt_dir.setEditable(false);
        txt_dir.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txt_dir.setFocusable(false);

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("DETALLE DE COMPRA");
        jLabel8.setFocusable(false);

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("DATOS GENERALES");
        jLabel9.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(212, 2, 2));
        jLabel10.setText("Producto:");
        jLabel10.setFocusable(false);

        txt_idp.setEditable(false);
        txt_idp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idpKeyTyped(evt);
            }
        });

        txt_desp.setEditable(false);
        txt_desp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_desp.setFocusable(false);

        btn_busm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/find.png"))); // NOI18N
        btn_busm.setEnabled(false);
        btn_busm.setFocusable(false);
        btn_busm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busmActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setFocusable(false);

        t_detalle.setModel(new javax.swing.table.DefaultTableModel(
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
        t_detalle.setFocusable(false);
        t_detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_detalleMouseClicked(evt);
            }
        });
        t_detalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_detalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_detalle);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(212, 2, 2));
        jLabel11.setText("Sub Total:");
        jLabel11.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(212, 2, 2));
        jLabel12.setText("IGV");
        jLabel12.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(212, 2, 2));
        jLabel13.setText("Total:");
        jLabel13.setFocusable(false);

        txt_sub.setEditable(false);
        txt_sub.setFocusable(false);

        txt_igv.setEditable(false);
        txt_igv.setFocusable(false);

        txt_tot.setEditable(false);
        txt_tot.setFocusable(false);

        btn_ca.setText("+/-");
        btn_ca.setEnabled(false);
        btn_ca.setFocusable(false);
        btn_ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_caActionPerformed(evt);
            }
        });

        btn_va.setText("S/.");
        btn_va.setEnabled(false);
        btn_va.setFocusable(false);
        btn_va.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaActionPerformed(evt);
            }
        });

        btn_el.setText("X");
        btn_el.setEnabled(false);
        btn_el.setFocusable(false);
        btn_el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elActionPerformed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/accept.png"))); // NOI18N
        btn_reg.setText("Aceptar");
        btn_reg.setEnabled(false);
        btn_reg.setFocusable(false);
        btn_reg.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setFocusable(false);
        btn_cer.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(212, 2, 2));
        jLabel14.setText("Tipo de Documento:");
        jLabel14.setFocusable(false);

        cbx_tido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_tidoKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(212, 2, 2));
        jLabel15.setText("Serie:");
        jLabel15.setFocusable(false);

        txt_ser.setEditable(false);
        txt_ser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_serKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_serKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(212, 2, 2));
        jLabel16.setText("Nro. Doc:");
        jLabel16.setFocusable(false);

        txt_nro.setEditable(false);
        txt_nro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nroKeyTyped(evt);
            }
        });

        txt_fec_com.setEditable(false);
        try {
            txt_fec_com.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fec_com.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fec_com.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fec_comKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(212, 2, 2));
        jLabel5.setText("Moneda");
        jLabel5.setFocusable(false);

        cbx_mon.setEnabled(false);
        cbx_mon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_monKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(212, 2, 2));
        jLabel6.setText("Tc.");
        jLabel6.setFocusable(false);

        txt_tc.setEditable(false);
        txt_tc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_tc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tcKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idp, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_desp, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_busm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_va)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_el)
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbx_tido, 0, 150, Short.MAX_VALUE)
                            .addComponent(txt_ser, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txt_nro, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txt_fec_com))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_raz))
                                    .addComponent(txt_dir)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbx_alm, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbx_mon, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_busp)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_busp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_tido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(txt_raz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_alm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_mon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_fec_com, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_busm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_desp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_ca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_va, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_el, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btn_reg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btn_busp.doClick();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_ruc.getText().length() == 11) {
                pro.setRuc(txt_ruc.getText());
                if (tido.validar_RUC(pro.getRuc()) == true) {
                    try {
                        Statement st = con.conexion();
                        String ver_pro = "select * from proveedor where ruc_pro = '" + pro.getRuc() + "'";
                        ResultSet rs = con.consulta(st, ver_pro);
                        if (rs.next()) {
                            pro.setRaz(rs.getString("raz_soc_pro"));
                            txt_raz.setText(rs.getString("raz_soc_pro"));
                            txt_dir.setText(rs.getString("dir_pro"));
                            cbx_alm.setEnabled(true);
                            cbx_alm.requestFocus();
                        } else {
                            txt_ruc.setText("");
                            txt_ruc.requestFocus();
                            JOptionPane.showMessageDialog(null, "El Proveedor no existe \nPor favor ingrese otro nro de RUC");
                        }
                    } catch (SQLException ex) {
                        System.out.print(ex);
                    }
                } else {
                    txt_ruc.setText("");
                    txt_ruc.requestFocus();
                    JOptionPane.showMessageDialog(null, "EL NRO DE RUC INGRESADO NO ES CORRECTO");
                }
            }
        }
    }//GEN-LAST:event_txt_rucKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        frm_ver_ingresos compra = new frm_ver_ingresos();
        ven.llamar_ventana(compra);
        this.dispose();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void cbx_almKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_almKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbx_mon.setEnabled(true);
            cbx_mon.requestFocus();
        }
    }//GEN-LAST:event_cbx_almKeyPressed

    private void cbx_tidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_tidoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_ser.setEditable(true);
            txt_ser.requestFocus();
        }
    }//GEN-LAST:event_cbx_tidoKeyPressed

    private void txt_serKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_ser.getText().isEmpty()) {
                txt_nro.setEditable(true);
                txt_nro.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_serKeyPressed

    private void txt_nroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_nro.getText().isEmpty()) {
                txt_fec_com.setEditable(true);
                txt_fec_com.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_nroKeyPressed

    private void txt_idpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idpKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_F3) {
//            btn_reg.doClick();
//        }

        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btn_busm.doClick();
        }
    }//GEN-LAST:event_txt_idpKeyPressed

    private void btn_buspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buspActionPerformed
        frm_ver_proveedores proveedor = new frm_ver_proveedores();
        proveedor.funcion = "ingreso_almacen";
        ven.llamar_ventana(proveedor);
    }//GEN-LAST:event_btn_buspActionPerformed

    private void btn_busmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busmActionPerformed
        frm_ver_productos prod = new frm_ver_productos();
        prod.ventana = "compra_prod";
//        String query = "select p.idProductos, p.desc_pro, p.marca, p.modelo, p.serie, p.grado, p.precio_venta, c.desc_clas, u.desc_und, p.cant_actual, p.cant_min, p.estado"
//                + " from productos as p inner join und_medida as u on p.idUnd_medida = u.idUnd_medida inner join clasificacion as c on p.id_clas = c.id_clas  order by p.desc_pro asc, p.modelo asc";
//        ver_productos(query);
        //prod.btn_reg.setEnabled(false);
        prod.btn_mod.setEnabled(false);
        prod.btn_eli.setEnabled(false);
        //  prod.btn_enviar.setEnabled(true);
        ven.llamar_ventana(prod);
    }//GEN-LAST:event_btn_busmActionPerformed
    
    private void ver_productos(String query) {
        try {
            frm_ver_productos prod = null;
            prod.mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            Statement st = con.conexion();
            ResultSet rs = con.consulta(st, query);
            //Establecer como cabezeras el nombre de las colimnas
            prod.mostrar.addColumn("Id");
            prod.mostrar.addColumn("Descripcion");//descripcion modelo serie
            prod.mostrar.addColumn("Marca");
            prod.mostrar.addColumn("Precio");
            prod.mostrar.addColumn("Clasificacion");
            prod.mostrar.addColumn("Cant. Actual");
            prod.mostrar.addColumn("Cant. minima");
            prod.mostrar.addColumn("Und. Medida");
            prod.mostrar.addColumn("Grado");
            prod.mostrar.addColumn("Estado");

            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[11];
                fila[0] = rs.getObject("idProductos");
                fila[1] = rs.getObject("desc_pro") + " - " + rs.getObject("modelo") + " - " + rs.getObject("serie");
                fila[2] = rs.getObject("marca");
                fila[3] = rs.getObject("precio_venta");
                fila[4] = rs.getObject("desc_clas");
                fila[5] = rs.getObject("cant_actual");
                fila[6] = rs.getObject("cant_min");
                fila[7] = rs.getObject("desc_und");
                fila[8] = rs.getObject("grado");
                if (rs.getString("estado").equals("1")) {
                    if (rs.getDouble("cant_actual") > rs.getDouble("cant_min")) {
                        fila[9] = "NORMAL";
                    }
                    if (rs.getDouble("cant_actual") <= rs.getDouble("cant_min")) {
                        fila[9] = "POR TERMINAR";
                    }
                    if (rs.getDouble("cant_actual") <= 0) {
                        fila[9] = "NO DISPONIBLE";
                    }
                } else {
                    fila[9] = "-";
                }
                
                prod.mostrar.addRow(fila);
            }
            con.cerrar(st);
            con.cerrar(rs);
            prod.t_productos.setModel(prod.mostrar);
            prod.t_productos.getColumnModel().getColumn(0).setPreferredWidth(10);
            prod.t_productos.getColumnModel().getColumn(1).setPreferredWidth(390);
            prod.t_productos.getColumnModel().getColumn(2).setPreferredWidth(50);
            prod.t_productos.getColumnModel().getColumn(3).setPreferredWidth(20);
            prod.t_productos.getColumnModel().getColumn(4).setPreferredWidth(30);
            prod.t_productos.getColumnModel().getColumn(5).setPreferredWidth(30);
            prod.t_productos.getColumnModel().getColumn(6).setPreferredWidth(40);
            prod.t_productos.getColumnModel().getColumn(7).setPreferredWidth(40);
            prod.t_productos.getColumnModel().getColumn(8).setPreferredWidth(40);
            prod.t_productos.getColumnModel().getColumn(9).setPreferredWidth(40);
            prod.t_productos.setDefaultRenderer(Object.class, new render_productos());
//            prod.mostrar.fireTableDataChanged();
//            prod.t_productos.updateUI();

        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    

    private void btn_caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_caActionPerformed
        Double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Cantidad"));
        t_detalle.setValueAt(cantidad, i, 3);
        txt_sub.setText(ven.formato_numero(subtotal()));
        txt_igv.setText(ven.formato_numero(igv()));
        txt_tot.setText(ven.formato_numero(total()));

    }//GEN-LAST:event_btn_caActionPerformed

    private void btn_vaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaActionPerformed
        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Precio"));
        t_detalle.setValueAt(precio, i, 5);
        txt_sub.setText(ven.formato_numero(subtotal()));
        txt_igv.setText(ven.formato_numero(igv()));
        txt_tot.setText(ven.formato_numero(total()));
    }//GEN-LAST:event_btn_vaActionPerformed

    private void btn_elActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elActionPerformed
        detalle.removeRow(i);
        txt_sub.setText(ven.formato_numero(subtotal()));
        txt_igv.setText(ven.formato_numero(igv()));
        txt_tot.setText(ven.formato_numero(total()));
    }//GEN-LAST:event_btn_elActionPerformed

    private void t_detalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_detalleMouseClicked
        i = t_detalle.getSelectedRow();
        btn_ca.setEnabled(true);
        btn_va.setEnabled(true);
        btn_el.setEnabled(true);
        t_detalle.setFocusable(true);
    }//GEN-LAST:event_t_detalleMouseClicked

    private void t_detalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_detalleKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PLUS) {
            btn_ca.doClick();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_sub.setText(ven.formato_numero(subtotal()));
            txt_igv.setText(ven.formato_numero(igv()));
            txt_tot.setText(ven.formato_numero(total()));
            txt_idp.requestFocus();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            i = t_detalle.getSelectedRow();
            detalle.removeRow(i);
            txt_sub.setText(ven.formato_numero(subtotal()));
            txt_igv.setText(ven.formato_numero(igv()));
            txt_tot.setText(ven.formato_numero(total()));
        }
    }//GEN-LAST:event_t_detalleKeyPressed
    
    private void llenar() {
        pro.setRuc(txt_ruc.getText());
        tido.setId(cbx_tido.getSelectedIndex() + 1);
        com.setSerie(Integer.parseInt(txt_ser.getText()));
        com.setNro(Integer.parseInt(txt_nro.getText()));
        com.setFec_com(ven.fechabase(txt_fec_com.getText()));
        alm.setId(cbx_alm.getSelectedIndex() + 1);
        mon.setId(cbx_mon.getSelectedIndex() + 1);
        tc = Double.parseDouble(txt_tc.getText());
        com.setTotal(total());
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();

        //Registrar Compra
        try {
            Statement st = con.conexion();
            String ins_com = "insert into ingreso Values (null, '" + pro.getRuc() + "', '" + tido.getId() + "', '" + com.getSerie() + "', '" + com.getNro() + "', "
                    + "'" + com.getFec_com() + "', '" + frm_menu.lbl_user.getText() + "','" + alm.getId() + "', '" + mon.getId() + "','" + tc + "', '" + com.getTotal() + "')";
            System.out.println(ins_com);
            con.actualiza(st, ins_com);
            con.cerrar(st);
        } catch (Exception ex) {
            System.out.print(ex);
        }

        //seleccionar ultima compra
        try {
            Statement st = con.conexion();
            String ver_id = "select idingreso from ingreso where ruc_pro = '" + pro.getRuc() + "' and idtipo_doc = '" + tido.getId() + "' and serie_doc = '" + com.getSerie() + "' "
                    + " and nro_doc = '" + com.getNro() + "' and fecha_doc = '" + com.getFec_com() + "' order by idingreso desc limit 1";
            System.out.println(ver_id);
            ResultSet rs = con.consulta(st, ver_id);
            if (rs.next()) {
                com.setId(rs.getInt("idingreso"));
            }
            con.cerrar(rs);
            con.cerrar(st);
        } catch (SQLException ex) {
            System.out.print(ex);
        }

        //Contar filas de tabla
        int filas = t_detalle.getRowCount();
        //Recorrer filas de tabla
        for (int j = 0; j <= (filas - 1); j++) {
            art.setId_pro((int) t_detalle.getValueAt(j, 0));
            art.setCan(Double.parseDouble(t_detalle.getValueAt(j, 3).toString()));
            Double precio_compra = Double.parseDouble(t_detalle.getValueAt(j, 5).toString());
            if (mon.getId() != 2) {
                art.setCos_pro(precio_compra * tc);
            } else {
                art.setCos_pro(precio_compra);
            }
            // buscar precio de prodcuto
            try {
                Statement st = con.conexion();
                String ver_pre_ven = "select precio_venta from productos where idProductos = '" + art.getId_pro() + "'";
                System.out.println(ver_pre_ven);
                ResultSet rs = con.consulta(st, ver_pre_ven);
                if (rs.next()) {
                    art.setPre_pro(rs.getDouble("precio_venta"));
                }
                con.cerrar(rs);
                con.cerrar(st);
            } catch (Exception ex) {
                System.out.print(ex);
            }
            //Registrando detalle de compra
            try {
                Statement st = con.conexion();
                String ins_det_com = "insert into detalle_ingreso Values ('" + com.getId() + "', "
                        + "'" + art.getId_pro() + "', '" + art.getCan() + "', '" + art.getCos_pro() + "')";
                System.out.println(ins_det_com);
                con.actualiza(st, ins_det_com);
                con.cerrar(st);
            } catch (Exception ex) {
                System.out.print(ex);
            }

            //Registrar Movimiento en kardex
            try {
                Statement st = con.conexion();
                String ins_kar = "insert into kardex Values (null, '" + com.getFec_com() + "', '" + art.getId_pro() + "', '" + art.getCan() + "', '" + art.getCos_pro() + "', "
                        + "'0.00', '0.00', '" + com.getSerie() + "', '" + com.getNro() + "', '" + tido.getId() + "', '" + alm.getId() + "', '" + pro.getRuc() + "',"
                        + "'" + pro.getRaz() + "', '2')";
                System.out.println(ins_kar);
                con.actualiza(st, ins_kar);
                con.cerrar(st);
            } catch (Exception ex) {
                System.out.print(ex);
            }

            //Ver Cantidad actual de Material
            try {
                Statement st = con.conexion();
                String bus_pro = "select cant_actual from productos where idProductos = '" + art.getId_pro() + "'";
                System.out.println(bus_pro);
                ResultSet rs = con.consulta(st, bus_pro);
                if (rs.next()) {
                    art.setCan_act_pro(rs.getDouble("cant_actual"));
                }
                con.cerrar(rs);
                con.cerrar(st);
            } catch (SQLException ex) {
                System.out.print(ex);
            }

            //Actualizando cantidad actual de material
            try {
                art.setCan_act_pro(art.getCan_act_pro() + art.getCan());
                Statement st = con.conexion();
                String act_pro = "update productos set cant_actual = '" + art.getCan_act_pro() + "', costo_compra = "
                        + "'" + art.getCos_pro() + "' where idProductos = '" + art.getId_pro() + "' ";
                System.out.println(act_pro);
                con.actualiza(st, act_pro);
                con.cerrar(st);
            } catch (Exception ex) {
                System.out.print(ex);
            }

            //Verificar producto en almacen
            try {
                Statement st = con.conexion();
                String ver_mat_alm = "select idProductos, cant from producto_almacen "
                        + "where idAlmacen = '" + alm.getId() + "' and idProductos = '" + art.getId_pro() + "'";
                System.out.println(ver_mat_alm);
                ResultSet rs = con.consulta(st, ver_mat_alm);
                if (rs.next()) {
                    //seleccionando cantidad
                    art.setCan_act_pro(rs.getDouble("cant"));
                    art.setCan_act_pro(art.getCan_act_pro() + art.getCan());
                    //actualizar cantidad
                    Statement st1 = con.conexion();
                    String act_mat_alm = "update producto_almacen set cant= '" + art.getCan_act_pro() + "', precio = '" + art.getPre_pro() + "' "
                            + "where idProductos = '" + art.getId_pro() + "' and idAlmacen = '" + alm.getId() + "'";
                    con.actualiza(st1, act_mat_alm);
                    con.cerrar(st1);
                } else {
                    //si producto no existe agregar
                    Statement st1 = con.conexion();
                    String add_pro_alm = "insert into producto_almacen Values ('" + art.getId_pro() + "', '" + alm.getId() + "', "
                            + "'" + art.getCan() + "', '" + art.getPre_pro() + "')";
                    con.actualiza(st1, add_pro_alm);
                    con.cerrar(st1);
                }
                con.cerrar(rs);
                con.cerrar(st);
            } catch (Exception ex) {
                System.out.print(ex);
            }
            
        }
        
        frm_ver_ingresos compra = new frm_ver_ingresos();
        ven.llamar_ventana(compra);
        this.dispose();
    }//GEN-LAST:event_btn_regActionPerformed

    private void txt_rucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyTyped
        if (txt_ruc.getText().length() == 11) {
            evt.consume();
        }
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_rucKeyTyped

    private void txt_serKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_serKeyTyped

    private void txt_nroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nroKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nroKeyTyped

    private void txt_idpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idpKeyTyped
//        char car = evt.getKeyChar();
//        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txt_idpKeyTyped

    private void txt_fec_comKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fec_comKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_fec_com.getText().length() == 10) {
                txt_ruc.setEditable(true);
                txt_ruc.requestFocus();
                btn_busp.setEnabled(true);
            }
        }
    }//GEN-LAST:event_txt_fec_comKeyPressed

    private void cbx_monKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_monKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            com.setFec_com(txt_fec_com.getText());
            int moneda = cbx_mon.getSelectedIndex() + 1;
            if (moneda != 2) {
                txt_tc.setText(ven.formato_tc(mon.tc_compra(ven.fechabase(com.getFec_com()), moneda)));
            } else {
                txt_tc.setText("1.000");
            }
            txt_tc.setEditable(true);
            txt_tc.requestFocus();
        }
    }//GEN-LAST:event_cbx_monKeyPressed

    private void txt_tcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tcKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Double tc = Double.parseDouble(txt_tc.getText());
            if (tc > 0.0) {
                txt_idp.setEditable(true);
                txt_idp.requestFocus();
                btn_busm.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "EL TIPO DE CAMBIO NO ES CORRECTO");
            }
        }
    }//GEN-LAST:event_txt_tcKeyPressed
    
    public static Double subtotal() {
        int totalRow = t_detalle.getRowCount();
        double suma_sub = 0.00;
        for (int i = 0; i < totalRow; i++) {
            suma_sub += Double.parseDouble(String.valueOf(t_detalle.getValueAt(i, 5))) * Double.parseDouble(String.valueOf(t_detalle.getValueAt(i, 3))) / 1.18;
            
        }
        return suma_sub;
    }
    
    public static Double igv() {
        Double igv = subtotal() * 0.18;
        return igv;
    }
    
    public static Double total() {
        double total = subtotal() + igv();
        return total;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_busm;
    private javax.swing.JButton btn_busp;
    private javax.swing.JButton btn_ca;
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_el;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JButton btn_va;
    public static javax.swing.JComboBox cbx_alm;
    public static javax.swing.JComboBox cbx_mon;
    private javax.swing.JComboBox cbx_tido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_detalle;
    public static javax.swing.JTextField txt_desp;
    public static javax.swing.JTextField txt_dir;
    public static javax.swing.JFormattedTextField txt_fec_com;
    public static javax.swing.JTextField txt_idp;
    public static javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_nro;
    public static javax.swing.JTextField txt_raz;
    public static javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_ser;
    public static javax.swing.JTextField txt_sub;
    private javax.swing.JTextField txt_tc;
    public static javax.swing.JTextField txt_tot;
    // End of variables declaration//GEN-END:variables
}
