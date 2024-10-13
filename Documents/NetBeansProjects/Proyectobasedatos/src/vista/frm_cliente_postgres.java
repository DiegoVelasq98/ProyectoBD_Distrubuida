/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Cliente_postgres;
import modelo.conexion;
import modelo.conexion_postgres;

public class frm_cliente_postgres extends javax.swing.JFrame {
    
    
    //Cliente obj_cliente;
    Cliente_postgres obj_cliente;
    DefaultTableModel tbl_Modelo;
    //
    public frm_cliente_postgres() {
         initComponents();
        
        obj_cliente = new Cliente_postgres();
        tbl_Modelo = new DefaultTableModel();
         String encabezado[]= {"Id","NIT", "DPI","Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Dirección", "Teléfono Casa", "Teléfono Movil", "Salario", "Bonificiacion"};
         tbl_Modelo.setColumnIdentifiers(encabezado);
           tbl_cliente.setModel(obj_cliente.leerpostgres());
         
    }
       
 
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_dpi = new javax.swing.JLabel();
        txt_dpi = new javax.swing.JTextField();
        lbl_nombre1 = new javax.swing.JLabel();
        txt_nombre1 = new javax.swing.JTextField();
        lbl_nombre2 = new javax.swing.JLabel();
        txt_nombre2 = new javax.swing.JTextField();
        lbl_apellido1 = new javax.swing.JLabel();
        txt_apellido1 = new javax.swing.JTextField();
        lbl_apellido2 = new javax.swing.JLabel();
        txt_apellido2 = new javax.swing.JTextField();
        lbl_direccion = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_telcasa = new javax.swing.JLabel();
        txt_telefonocasa = new javax.swing.JTextField();
        lbl_telmovil = new javax.swing.JLabel();
        txt_telefonomovil = new javax.swing.JTextField();
        lbl_salario = new javax.swing.JLabel();
        txt_salario = new javax.swing.JTextField();
        lbl_bonificacion = new javax.swing.JLabel();
        txt_bonificacion = new javax.swing.JTextField();
        btn_ingresar = new javax.swing.JButton();
        lbl_nit = new javax.swing.JLabel();
        txt_nit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cliente = new javax.swing.JTable();
        lbl_identificador = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        btn_actualizar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        btn_bitacoraPostgres = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_dpi.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_dpi.setText("DPI");

        lbl_nombre1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_nombre1.setText("Primer Nombre");

        lbl_nombre2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_nombre2.setText("Segundo Nombre");

        txt_nombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre2ActionPerformed(evt);
            }
        });

        lbl_apellido1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_apellido1.setText("Primer Apellido");

        lbl_apellido2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_apellido2.setText("Segundo Apellido");

        txt_apellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellido2ActionPerformed(evt);
            }
        });

        lbl_direccion.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_direccion.setText("Direccion");

        lbl_telcasa.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_telcasa.setText("Teléfono Casa");

        lbl_telmovil.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_telmovil.setText("Teléfono Móvil");

        txt_telefonomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonomovilActionPerformed(evt);
            }
        });

        lbl_salario.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_salario.setText("Salario Base");

        lbl_bonificacion.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_bonificacion.setText("Bonificacion");

        txt_bonificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bonificacionActionPerformed(evt);
            }
        });

        btn_ingresar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_ingresar.setText("Ingresar datos");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        lbl_nit.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_nit.setText("Nit");

        txt_nit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Base de Datos Postgress");

        tbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clienteMouseClicked(evt);
            }
        });
        tbl_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_clienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cliente);

        lbl_identificador.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_identificador.setText("Id");

        lbl_id.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl_id.setText("0");

        btn_actualizar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_actualizar.setText("Actualizar datos");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_eliminar.setText("Eliminar datos");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_atras.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_atras.setText("Atrás");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        btn_bitacoraPostgres.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_bitacoraPostgres.setText("Bitacora Postgres");
        btn_bitacoraPostgres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bitacoraPostgresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_nombre2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_nombre1)
                                    .addGap(40, 40, 40)
                                    .addComponent(txt_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_dpi, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addComponent(txt_nit))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(231, 231, 231)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbl_telcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_telefonocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbl_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(106, 106, 106)
                                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_telmovil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_bonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_bonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_telefonomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_identificador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_atras)
                .addGap(210, 210, 210)
                .addComponent(btn_ingresar)
                .addGap(91, 91, 91)
                .addComponent(btn_actualizar)
                .addGap(82, 82, 82)
                .addComponent(btn_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_bitacoraPostgres)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_identificador)
                            .addComponent(lbl_id))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nit)
                            .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_direccion)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_dpi)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_telefonocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telcasa))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(lbl_salario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_bonificacion)
                                    .addComponent(txt_bonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_nombre1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_telmovil)
                                        .addComponent(txt_telefonomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_nombre2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_nombre2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_apellido1)
                                            .addComponent(txt_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_apellido2)))
                                    .addComponent(txt_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_atras)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ingresar)
                            .addComponent(btn_actualizar)
                            .addComponent(btn_eliminar)
                            .addComponent(btn_bitacoraPostgres))
                        .addGap(16, 16, 16))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_apellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido2ActionPerformed

    private void txt_telefonomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonomovilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonomovilActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed

        obj_cliente = new Cliente_postgres (0,txt_nit.getText(),txt_dpi.getText(), txt_nombre1.getText(), txt_nombre2.getText(), txt_apellido1.getText(), txt_apellido2.getText(), txt_direccion.getText(),txt_telefonocasa.getText(), txt_telefonomovil.getText(), txt_salario.getText(), txt_bonificacion.getText() );
        obj_cliente.agregar();
     tbl_cliente.setModel(obj_cliente.leerpostgres());

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void txt_nitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nitActionPerformed

    private void txt_nombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre2ActionPerformed

    private void txt_bonificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bonificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bonificacionActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed

     
        obj_cliente = new Cliente_postgres (Integer.valueOf(lbl_id.getText()),txt_nit.getText(),txt_dpi.getText(), txt_nombre1.getText(), txt_nombre2.getText(), txt_apellido1.getText(), txt_apellido2.getText(), txt_direccion.getText(),txt_telefonocasa.getText(), txt_telefonomovil.getText(), txt_salario.getText(), txt_bonificacion.getText() );
        obj_cliente.actualizar();
        tbl_cliente.setModel(obj_cliente.leerpostgres());
    }//GEN-LAST:event_btn_actualizarActionPerformed

    public void select_datos(){
    
        int fila= tbl_cliente.getSelectedRow();
        lbl_id.setText(tbl_cliente.getValueAt(fila, 0).toString());
        txt_nit.setText(tbl_cliente.getValueAt(fila, 1).toString());
        txt_dpi.setText(tbl_cliente.getValueAt(fila, 2).toString());
        txt_nombre1.setText(tbl_cliente.getValueAt(fila, 3).toString());
        txt_nombre2.setText(tbl_cliente.getValueAt(fila, 4).toString());
        txt_apellido1.setText(tbl_cliente.getValueAt(fila, 5).toString());
        txt_apellido2.setText(tbl_cliente.getValueAt(fila, 6).toString());
        txt_direccion.setText(tbl_cliente.getValueAt(fila, 7).toString());
        txt_telefonocasa.setText(tbl_cliente.getValueAt(fila, 8).toString());
        txt_telefonomovil.setText(tbl_cliente.getValueAt(fila, 9).toString());
        txt_salario.setText(tbl_cliente.getValueAt(fila, 10).toString());
        txt_bonificacion.setText(tbl_cliente.getValueAt(fila,11).toString());
    
    }
    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
        // TODO add your handling code here:
        
        select_datos();
    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void tbl_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_clienteKeyReleased
        // TODO add your handling code here:
                select_datos();

    }//GEN-LAST:event_tbl_clienteKeyReleased

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        
        obj_cliente= new Cliente_postgres();
        obj_cliente.setId(Integer.valueOf(lbl_id.getText()));
        obj_cliente.eliminar();
        tbl_cliente.setModel(obj_cliente.leerpostgres());
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
      
        
        JOptionPane.showMessageDialog(null, "Conexión con Postgres cerrada", "Conexión Cerrada", JOptionPane.INFORMATION_MESSAGE);
        frm_inicio fr= new frm_inicio();
        fr.setVisible (true);
        dispose();
        
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_bitacoraPostgresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bitacoraPostgresActionPerformed
Cliente cliente = new Cliente();  // Asegúrate de tener acceso a los datos del cliente

    cliente.generarBitacoraConInsert();  // Llamada al método que genera la bitácora con el INSERT
    }//GEN-LAST:event_btn_bitacoraPostgresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_cliente_postgres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_cliente_postgres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_cliente_postgres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_cliente_postgres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_cliente_postgres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_bitacoraPostgres;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_apellido1;
    private javax.swing.JLabel lbl_apellido2;
    private javax.swing.JLabel lbl_bonificacion;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_dpi;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_identificador;
    private javax.swing.JLabel lbl_nit;
    private javax.swing.JLabel lbl_nombre1;
    private javax.swing.JLabel lbl_nombre2;
    private javax.swing.JLabel lbl_salario;
    private javax.swing.JLabel lbl_telcasa;
    private javax.swing.JLabel lbl_telmovil;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JTextField txt_apellido1;
    private javax.swing.JTextField txt_apellido2;
    private javax.swing.JTextField txt_bonificacion;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_dpi;
    private javax.swing.JTextField txt_nit;
    private javax.swing.JTextField txt_nombre1;
    private javax.swing.JTextField txt_nombre2;
    private javax.swing.JTextField txt_salario;
    private javax.swing.JTextField txt_telefonocasa;
    private javax.swing.JTextField txt_telefonomovil;
    // End of variables declaration//GEN-END:variables
}
