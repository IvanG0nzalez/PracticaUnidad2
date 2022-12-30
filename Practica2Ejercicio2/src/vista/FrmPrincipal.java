/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControladorCasa;
import controlador.Listas.ListaEnlazada;
import controlador.utilidades.Utilidades;

import javax.swing.JOptionPane;
import modelo.Casa;
import vista.modeloTabla.ModeloTablaCasa;

/**
 *
 * @author Iván González
 */
public class FrmPrincipal extends javax.swing.JFrame {

//    ListaEnlazada<Casa> lista = new ListaEnlazada<>();
    ControladorCasa cc2= new ControladorCasa();
    ControladorCasa cc = new ControladorCasa();
    ModeloTablaCasa mtc = new ModeloTablaCasa();

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        limpiar();
        cargarTablaBusqueda();
        disablePanelOrden();
        disablePanelBusqueda();
        setLocationRelativeTo(this);
    }
    
    private void cargarTablaBusqueda(){
        mtc.setLista(cc2.getListaCasas());
        tablaBusqueda.setModel(mtc);
        tablaBusqueda.updateUI();
    }

    private void cargarTabla() {
        mtc.setLista(cc.getListaCasas());
        tablaCasa.setModel(mtc);
        tablaCasa.updateUI();
    }

    private void limpiar() {
        txtAncho.setText("");
        txtColor.setText("");
        txtLargo.setText("");
        txtNumeroCasa.setText("");
        cbxNumeroPisos.setSelectedIndex(0);
        cargarTabla();
    }

    private void disablePanelOrden() {
        jPanel6.setEnabled(false);
        cbxTipoOrden.setEnabled(false);
        cbxOrdenarPorAtributo.setEnabled(false);
        btnOrdenar.setEnabled(false);
    }

    private void enablePanelOrden() {
        jPanel6.setEnabled(true);
        cbxTipoOrden.setEnabled(true);
        cbxOrdenarPorAtributo.setEnabled(true);
        btnOrdenar.setEnabled(true);
    }

    private void disablePanelBusqueda() {
        jPanel4.setEnabled(false);
        cbxAtributoBusqueda.setEnabled(false);
        cbxTipoBusqueda.setEnabled(false);
        txtDatoABuscar.setEnabled(false);
        btnBuscar.setEnabled(false);
    }

    private void enablePanelBusqueda() {
        jPanel4.setEnabled(true);
        cbxAtributoBusqueda.setEnabled(true);
        cbxTipoBusqueda.setEnabled(true);
        txtDatoABuscar.setEnabled(true);
        btnBuscar.setEnabled(true);
    }

    private void agregarCasa() throws Exception {
        Casa casa = new Casa();
        if (txtAncho.getText().isEmpty() || txtColor.getText().isEmpty()
                || txtLargo.getText().isEmpty() || txtNumeroCasa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            casa.setNumeroCasa(txtNumeroCasa.getText());
            casa.setNumeroPisos(cbxNumeroPisos.getSelectedIndex() + 1);
            casa.setColor(txtColor.getText());
            casa.setAncho(Float.parseFloat(txtAncho.getText()));
            casa.setLargo(Float.parseFloat(txtLargo.getText()));
            cc.getListaCasas().insertar(casa);
            limpiar();
        }
    }

    private void buscar() throws Exception {
        cc2.getListaCasas().vaciar();
        if (txtDatoABuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escribe el dato que deseas buscar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String atributoDebusqueda = "";
            if (cbxAtributoBusqueda.getSelectedIndex() == 0) {
                atributoDebusqueda = "numeroCasa";
                cc.getListaCasas().ordenarShellSort(atributoDebusqueda, ListaEnlazada.ASCENDENTE);
                if (cbxTipoBusqueda.getSelectedIndex() == 0) {
                    Integer posicion = cc.getListaCasas().buscarBinario(atributoDebusqueda, txtDatoABuscar.getText());
                    cc2.getListaCasas().insertar(cc.getListaCasas().obtener(posicion));
                } else {
                    cc2.setListaCasas(cc.getListaCasas().busquedaLinealBinaria(atributoDebusqueda, txtDatoABuscar.getText()));
                }
            } else if (cbxAtributoBusqueda.getSelectedIndex() == 1) {
                atributoDebusqueda = "color";
                cc.getListaCasas().ordenarShellSort(atributoDebusqueda, ListaEnlazada.ASCENDENTE);
                if (cbxTipoBusqueda.getSelectedIndex() == 0) {
                    Integer posicion = cc.getListaCasas().buscarBinario(atributoDebusqueda, txtDatoABuscar.getText());
                    cc2.getListaCasas().insertar(cc.getListaCasas().obtener(posicion));
                } else {
                    cc2.setListaCasas(cc.getListaCasas().busquedaLinealBinaria(atributoDebusqueda, txtDatoABuscar.getText()));
                }
            } else {
                Integer posicion;
                Number aux = Float.parseFloat(txtDatoABuscar.getText());
                if (cbxAtributoBusqueda.getSelectedIndex() == 2) {
                    atributoDebusqueda = "numeroPisos";
                    cc.getListaCasas().ordenarShellSort(atributoDebusqueda, ListaEnlazada.ASCENDENTE);
                    if (cbxTipoBusqueda.getSelectedIndex() == 0) {
                        posicion = cc.getListaCasas().buscarBinario(atributoDebusqueda, aux);
                        cc2.getListaCasas().insertar(cc.getListaCasas().obtener(posicion));
                    } else {
                        cc2.setListaCasas(cc.getListaCasas().busquedaLinealBinaria(atributoDebusqueda, aux));
                    }
                } else if (cbxAtributoBusqueda.getSelectedIndex() == 3) {
                    atributoDebusqueda = "ancho";
                    cc.getListaCasas().ordenarShellSort(atributoDebusqueda, ListaEnlazada.ASCENDENTE);
                    if (cbxTipoBusqueda.getSelectedIndex() == 0) {
                        posicion = cc.getListaCasas().buscarBinario(atributoDebusqueda, aux);
                        cc2.getListaCasas().insertar(cc.getListaCasas().obtener(posicion));
                    } else {
                        cc2.setListaCasas(cc.getListaCasas().busquedaLinealBinaria(atributoDebusqueda, aux));
                    }
                } else if (cbxAtributoBusqueda.getSelectedIndex() == 3) {
                    atributoDebusqueda = "largo";
                    cc.getListaCasas().ordenarShellSort(atributoDebusqueda, ListaEnlazada.ASCENDENTE);
                    if (cbxTipoBusqueda.getSelectedIndex() == 0) {
                        posicion = cc.getListaCasas().buscarBinario(atributoDebusqueda, aux);
                        cc2.getListaCasas().insertar(cc.getListaCasas().obtener(posicion));
                    } else {
                        cc2.setListaCasas(cc.getListaCasas().busquedaLinealBinaria(atributoDebusqueda, aux));
                    }
                }
            }
            cargarTablaBusqueda();
        }
    }

    private void ordenar() throws Exception {
        if (cbxTipoOrden.getSelectedItem().toString().equalsIgnoreCase("Ascendente")) {
            if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Numero de Casa")) {
                cc.getListaCasas().ordenarShellSort("numeroCasa", ListaEnlazada.ASCENDENTE);
                cargarTabla();
            } else if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Numero de Pisos")) {
                cc.getListaCasas().ordenarShellSort("numeroPisos", ListaEnlazada.ASCENDENTE);
                cargarTabla();
            } else if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Color")) {
                cc.getListaCasas().ordenarShellSort("color", ListaEnlazada.ASCENDENTE);
                cargarTabla();
            } else if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Ancho")) {
                cc.getListaCasas().ordenarShellSort("ancho", ListaEnlazada.ASCENDENTE);
                cargarTabla();
            } else if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Largo")) {
                cc.getListaCasas().ordenarShellSort("largo", ListaEnlazada.ASCENDENTE);
                cargarTabla();
            }
        } else {
            if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Numero de Casa")) {
                cc.getListaCasas().ordenarShellSort("numeroCasa", ListaEnlazada.DESCENDENTE);
                cargarTabla();
            } else if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Numero de Pisos")) {
                cc.getListaCasas().ordenarShellSort("numeroPisos", ListaEnlazada.DESCENDENTE);
                cargarTabla();
            } else if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Color")) {
                cc.getListaCasas().ordenarShellSort("color", ListaEnlazada.DESCENDENTE);
                cargarTabla();
            } else if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Ancho")) {
                cc.getListaCasas().ordenarShellSort("ancho", ListaEnlazada.DESCENDENTE);
                cargarTabla();
            } else if (cbxOrdenarPorAtributo.getSelectedItem().toString().equalsIgnoreCase("Largo")) {
                cc.getListaCasas().ordenarShellSort("largo", ListaEnlazada.DESCENDENTE);
                cargarTabla();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroCasa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        cbxNumeroPisos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        txtLargo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCasa = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDatoABuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        cbxAtributoBusqueda = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cbxTipoOrden = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbxOrdenarPorAtributo = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la casa"));
        jPanel2.setLayout(null);

        jLabel2.setText("Numero de pisos:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 80, 110, 20);

        jLabel3.setText("Numero de casa:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 20, 110, 20);

        txtNumeroCasa.setText("jTextField1");
        jPanel2.add(txtNumeroCasa);
        txtNumeroCasa.setBounds(130, 20, 150, 22);

        jLabel6.setText("Ancho:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 110, 110, 20);

        txtAncho.setText("jTextField1");
        txtAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnchoKeyTyped(evt);
            }
        });
        jPanel2.add(txtAncho);
        txtAncho.setBounds(130, 110, 150, 22);

        cbxNumeroPisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jPanel2.add(cbxNumeroPisos);
        cbxNumeroPisos.setBounds(130, 80, 150, 22);

        jLabel4.setText("Color:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 50, 110, 20);

        txtColor.setText("jTextField1");
        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });
        jPanel2.add(txtColor);
        txtColor.setBounds(130, 50, 150, 22);

        txtLargo.setText("jTextField1");
        jPanel2.add(txtLargo);
        txtLargo.setBounds(130, 140, 150, 22);

        jLabel5.setText("Largo:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 140, 110, 20);

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);
        btnAgregar.setBounds(40, 170, 210, 22);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));
        jPanel3.setLayout(null);

        tablaCasa.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCasa.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tablaCasa);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 590, 240);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Dato"));
        jPanel4.setLayout(null);

        jLabel7.setText("Atributo de busqueda:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(10, 20, 130, 20);

        jLabel8.setText("Dato a buscar:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 50, 130, 16);
        jPanel4.add(txtDatoABuscar);
        txtDatoABuscar.setBounds(140, 50, 140, 22);

        jLabel1.setText("Tipo de Busqueda:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(10, 80, 130, 20);

        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Binaria", "Secuencial-Binaria" }));
        jPanel4.add(cbxTipoBusqueda);
        cbxTipoBusqueda.setBounds(140, 80, 140, 22);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar);
        btnBuscar.setBounds(40, 110, 210, 22);

        cbxAtributoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero de Casa", "Color", "Numero de Pisos", "Ancho", "Largo" }));
        jPanel4.add(cbxAtributoBusqueda);
        cbxAtributoBusqueda.setBounds(140, 20, 140, 22);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado Busqueda"));
        jPanel5.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel5.add(jLabel15);
        jLabel15.setBounds(160, 30, 110, 0);

        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaBusqueda);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 22, 590, 170);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar"));

        jLabel16.setText("Tipo de orden:");

        cbxTipoOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));

        jLabel17.setText("Ordenar por:");

        cbxOrdenarPorAtributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero de Casa", "Color", "Numero de Pisos", "Ancho", "Largo" }));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTipoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxOrdenarPorAtributo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbxTipoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbxOrdenarPorAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("GUARDAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("CARGAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (cc.getListaCasas().getSize() != 0) {
            enablePanelOrden();
            enablePanelBusqueda();
        }
        try {
            agregarCasa();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtAnchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnchoKeyTyped

    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtColorKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            // TODO add your handling code here:
            buscar();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        cc = new ControladorCasa();
        cc.setListaCasas(Utilidades.cargarJson().getListaCasas());
        if (cc.getListaCasas().getSize() != 0) {
            limpiar();
            enablePanelBusqueda();
            enablePanelOrden();
        } else
            JOptionPane.showMessageDialog(this, "No se pudo cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (cc.getListaCasas().getSize() != 0) {
            if (Utilidades.guardarJson(cc)) {
                JOptionPane.showMessageDialog(this, "Se ha guardado el archivo", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se genero el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else
            JOptionPane.showMessageDialog(this, "Debe generar una lista de casas primero", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
        try {
            ordenar();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnOrdenarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JComboBox<String> cbxAtributoBusqueda;
    private javax.swing.JComboBox<String> cbxNumeroPisos;
    private javax.swing.JComboBox<String> cbxOrdenarPorAtributo;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JComboBox<String> cbxTipoOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaBusqueda;
    private javax.swing.JTable tablaCasa;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDatoABuscar;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtNumeroCasa;
    // End of variables declaration//GEN-END:variables
}
