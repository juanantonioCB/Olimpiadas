/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.ComisarioDAO;
import dao.ComplejoDAO;
import dao.EquipamientoDAO;
import dao.EventoDAO;
import dao.PolideportivoDAO;
import dao.SedeDAO;
import dao.UnideportivoDAO;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelo.Comisario;
import modelo.Complejo;
import modelo.Equipamiento;
import modelo.Evento;
import modelo.Polideportivo;
import modelo.Sede;
import modelo.Unideportivo;

/**
 *
 * @author Juan Antonio
 */
public class VistaPrincipal extends javax.swing.JFrame {

    SedeDAO sedeDao = new SedeDAO();
    ComplejoDAO complejoDao = new ComplejoDAO();
    EquipamientoDAO equipamientoDao = new EquipamientoDAO();
    EventoDAO eventoDao = new EventoDAO();
    ComisarioDAO comisarioDao = new ComisarioDAO();
    PolideportivoDAO polideportivoDao = new PolideportivoDAO();
    UnideportivoDAO unideportivoDao = new UnideportivoDAO();

    public VistaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadTable("Sedes");
        materialesJButton.setVisible(false);

    }

    public void loadTable(String option) {
        switch (option) {
            case "Sedes":
                ArrayList<Sede> sedes = (ArrayList<Sede>) sedeDao.getAll();
                if (sedes != null) {
                    DefaultTableModel model = new DefaultTableModel(new Object[][]{
                        {null, null, null},},
                            new String[]{
                                "ID", "Nombre", "Presupuesto"
                            });
                    contenidoJTable.setModel(model);

                    for (int i = 0; i < sedes.size() - 1; i++) {
                        model.addRow(new Object[][]{{null, null, null}});
                    }
                    for (int x = 0; x < sedes.size(); x++) {
                        contenidoJTable.setValueAt(sedes.get(x).getCod(), x, 0);
                        contenidoJTable.setValueAt(sedes.get(x).getNombre(), x, 1);
                        contenidoJTable.setValueAt(sedes.get(x).getPresupuesto(), x, 2);
                    }
                }
                break;
            case "Complejos":
                ArrayList<Complejo> complejos = (ArrayList<Complejo>) complejoDao.getAllComplejos();

                if (complejos != null) {
                    DefaultTableModel model = new DefaultTableModel(new Object[][]{
                        {null, null, null},},
                            new String[]{
                                "Cod", "Localizacion", "Jefe", "Cod_Sede"
                            });
                    contenidoJTable.setModel(model);

                    for (int i = 0; i < complejos.size() - 1; i++) {
                        model.addRow(new Object[][]{{null, null, null, null}});
                    }
                    for (int x = 0; x < complejos.size(); x++) {
                        contenidoJTable.setValueAt(complejos.get(x).getCod(), x, 0);
                        contenidoJTable.setValueAt(complejos.get(x).getLocalizacion(), x, 1);
                        contenidoJTable.setValueAt(complejos.get(x).getJefe(), x, 2);
                        contenidoJTable.setValueAt(complejos.get(x).getCod_sede(), x, 3);
                    }
                }
                break;
            case "Material":
                ArrayList<Equipamiento> equipamiento = (ArrayList<Equipamiento>) equipamientoDao.getAll();
                if (equipamiento != null) {
                    DefaultTableModel model = new DefaultTableModel(new Object[][]{
                        {null, null},},
                            new String[]{
                                "ID", "Nombre"
                            });
                    contenidoJTable.setModel(model);
                    for (int i = 0; i < equipamiento.size() - 1; i++) {
                        model.addRow(new Object[][]{{null, null, null, null}});
                    }
                    for (int x = 0; x < equipamiento.size(); x++) {
                        contenidoJTable.setValueAt(equipamiento.get(x).getId(), x, 0);
                        contenidoJTable.setValueAt(equipamiento.get(x).getNombre(), x, 1);
                    }
                }
                break;
            case "Eventos":
                this.materialesJButton.setVisible(true);
                ArrayList<Evento> eventos = (ArrayList<Evento>) eventoDao.getAll();

                if (eventos != null) {
                    DefaultTableModel model = new DefaultTableModel(new Object[][]{
                        {null, null, null, null, null, null}},
                            new String[]{
                                "ID", "Nombre", "Fecha", "Localizacion Complejo", "Area",});
                    contenidoJTable.setModel(model);

                    for (int i = 0; i < eventos.size() - 1; i++) {
                        model.addRow(new Object[][]{{null, null, null, null}});
                    }

                    for (int x = 0; x < eventos.size(); x++) {
                        contenidoJTable.setValueAt(eventos.get(x).getId(), x, 0);
                        contenidoJTable.setValueAt(eventos.get(x).getNombre(), x, 1);
                        contenidoJTable.setValueAt(eventos.get(x).getDate(), x, 2);
                        contenidoJTable.setValueAt(eventos.get(x).getLocalizacion_complejo(), x, 3);
                        contenidoJTable.setValueAt(eventos.get(x).getArea_location(), x, 4);
                    }
                }
                break;
            case "Comisarios":
                ArrayList<Comisario> comisarios = (ArrayList<Comisario>) comisarioDao.getAll();
                if (comisarios != null) {
                    DefaultTableModel model = new DefaultTableModel(new Object[][]{
                        {null, null, null}},
                            new String[]{
                                "ID", "DNI", "Nombre"
                            });
                    contenidoJTable.setModel(model);

                    for (int i = 0; i < comisarios.size() - 1; i++) {
                        model.addRow(new Object[][]{{null, null, null}});
                    }

                    for (int x = 0; x < comisarios.size(); x++) {
                        contenidoJTable.setValueAt(comisarios.get(x).getCod(), x, 0);
                        contenidoJTable.setValueAt(comisarios.get(x).getDni(), x, 1);
                        contenidoJTable.setValueAt(comisarios.get(x).getNombre(), x, 2);
                    }
                }
                break;
            case "Polideportivos":
                ArrayList<Polideportivo> polideportivos = (ArrayList<Polideportivo>) polideportivoDao.getAll();
                System.out.println(polideportivos.size());
                if (polideportivos != null) {
                    DefaultTableModel model = new DefaultTableModel(new Object[][]{
                        {null, null, null, null}},
                            new String[]{
                                "ID", "Location", "Jefe", "Informacion"
                            });
                    contenidoJTable.setModel(model);

                    for (int i = 0; i < polideportivos.size() - 1; i++) {
                        model.addRow(new Object[][]{{null, null, null, null}});
                    }

                    for (int x = 0; x < polideportivos.size(); x++) {
                        contenidoJTable.setValueAt(polideportivos.get(x).getCod(), x, 0);
                        contenidoJTable.setValueAt(polideportivos.get(x).getLocalizacion(), x, 1);
                        contenidoJTable.setValueAt(polideportivos.get(x).getJefe(), x, 2);
                        contenidoJTable.setValueAt(polideportivos.get(x).getInfo(), x, 3);
                    }
                }
                break;
            case "Unideportivos":
                ArrayList<Unideportivo> unideportivos = (ArrayList<Unideportivo>) unideportivoDao.getAll();
                System.out.println(unideportivos.size());
                if (unideportivos != null) {
                    DefaultTableModel model = new DefaultTableModel(new Object[][]{
                        {null, null, null, null, null}},
                            new String[]{
                                "ID", "Location", "Jefe", "Deporte", "Informacion"
                            });
                    contenidoJTable.setModel(model);

                    for (int i = 0; i < unideportivos.size() - 1; i++) {
                        model.addRow(new Object[][]{{null, null, null, null, null}});
                    }

                    for (int x = 0; x < unideportivos.size(); x++) {
                        contenidoJTable.setValueAt(unideportivos.get(x).getCod(), x, 0);
                        contenidoJTable.setValueAt(unideportivos.get(x).getLocalizacion(), x, 1);
                        contenidoJTable.setValueAt(unideportivos.get(x).getJefe(), x, 2);
                        contenidoJTable.setValueAt(unideportivos.get(x).getDeporte(), x, 3);
                        contenidoJTable.setValueAt(unideportivos.get(x).getInfo(), x, 4);
                    }
                }

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        optionJComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenidoJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        recargarJButton = new javax.swing.JButton();
        materialesJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Olimpiadas");

        optionJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedes", "Complejos", "Eventos", "Comisarios", "Material", "Polideportivos", "Unideportivos" }));
        optionJComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionJComboBoxMouseClicked(evt);
            }
        });
        optionJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionJComboBoxActionPerformed(evt);
            }
        });

        contenidoJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(contenidoJTable);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        recargarJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recargar.png"))); // NOI18N
        recargarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recargarJButtonMouseClicked(evt);
            }
        });
        recargarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarJButtonActionPerformed(evt);
            }
        });

        materialesJButton.setText("VER MATERIALES");
        materialesJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialesJButtonMouseClicked(evt);
            }
        });
        materialesJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialesJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(optionJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(457, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(424, 424, 424))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(materialesJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recargarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(optionJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(materialesJButton)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(recargarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optionJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionJComboBoxActionPerformed
        loadTable((String) optionJComboBox.getSelectedItem());
    }//GEN-LAST:event_optionJComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String option = (String) optionJComboBox.getSelectedItem();
        switch (option) {
            case "Sedes":
                VistaAddSede vistaAddSede = new VistaAddSede();
                vistaAddSede.setVisible(true);
                break;
            case "Complejos":
                AddComplejo addComplejo = new AddComplejo();
                addComplejo.setVisible(true);
                break;
        }


    }//GEN-LAST:event_jButton1MouseClicked

    private void optionJComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionJComboBoxMouseClicked

    }//GEN-LAST:event_optionJComboBoxMouseClicked

    private void recargarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recargarJButtonMouseClicked
        loadTable((String) optionJComboBox.getSelectedItem());
    }//GEN-LAST:event_recargarJButtonMouseClicked

    private void recargarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recargarJButtonActionPerformed

    private void materialesJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialesJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialesJButtonActionPerformed

    private void materialesJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialesJButtonMouseClicked

        try {
            int id = (int) contenidoJTable.getValueAt(contenidoJTable.getSelectedRow(), 0);
            VerMateriales verMateriales = new VerMateriales(id);
            verMateriales.setVisible(true);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_materialesJButtonMouseClicked

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable contenidoJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton materialesJButton;
    private javax.swing.JComboBox<String> optionJComboBox;
    private javax.swing.JButton recargarJButton;
    // End of variables declaration//GEN-END:variables
}
