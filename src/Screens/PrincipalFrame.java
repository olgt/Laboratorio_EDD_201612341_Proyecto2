/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Estructura_Arbol_B.ArbolB;
import Estructura_Arbol_B.Factura;
import Estructura_Arbol_B.Usuario;
import Estructura_Arbol_B.Viaje;
import Utilities.JsonFileOpenerLocalidadesConductores;
import Utilities.JsonFileOpenerLocalidadesUsuarios;
import Utilities.JsonFileOpenerUsuarios;
import com.google.common.hash.Hashing;
import java.io.File;
import java.nio.charset.StandardCharsets;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

/**
 *
 * @author Oscar
 */
public class PrincipalFrame extends javax.swing.JFrame {

    private ArbolB<Integer, Usuario> arbolUsuarios = new ArbolB<>(5);
    private ArbolB<Integer, Usuario> arbolConductores = new ArbolB<>(5);
    private ArbolB<Integer, Viaje> arbolViajes = new ArbolB<>(5);
    private ArbolB<Integer, Factura> arbolFacturas = new ArbolB<>(5);
    
    Usuario usuarioActual = null;

    public PrincipalFrame() {
        initComponents();
        comboBoxRoles.addItem("Admin");
        comboBoxRoles.addItem("Usuario");
        comboBoxRoles.addItem("Conductor");
        jPanelRegistro.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdmin = new javax.swing.JPanel();
        cargarUsuariosButton = new javax.swing.JButton();
        cargarLugaresButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cargarConexionesButton = new javax.swing.JButton();
        cargarLocalidadesUsuarios = new javax.swing.JButton();
        cargarLocalidadesConductores = new javax.swing.JButton();
        cargarReportesButton = new javax.swing.JButton();
        cargarMapaButton = new javax.swing.JButton();
        salirAdmin = new javax.swing.JButton();
        panelDetallesUsuario = new javax.swing.JPanel();
        textFieldNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textFieldUsuario = new javax.swing.JTextField();
        textFieldPassword = new javax.swing.JTextField();
        textFieldCorreo = new javax.swing.JTextField();
        textFieldTelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        buttonModificarInfoUsuario = new javax.swing.JButton();
        buttonCerrarCuenta = new javax.swing.JButton();
        buttonSalirDetallesUsuario = new javax.swing.JButton();
        panelMainUsuario = new javax.swing.JPanel();
        buttonPedirViaje = new javax.swing.JButton();
        buttonDetallesUsuario = new javax.swing.JButton();
        buttonSalirMainUsuario = new javax.swing.JButton();
        mensajeBienvenidaUsuario = new javax.swing.JLabel();
        panelDetallesConductor = new javax.swing.JPanel();
        textFieldNombre1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        textFieldUsuario1 = new javax.swing.JTextField();
        textFieldPassword1 = new javax.swing.JTextField();
        textFieldCorreo1 = new javax.swing.JTextField();
        textFieldTelefono1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        buttonModificarInfoConductor = new javax.swing.JButton();
        buttonCerrarCuenta1 = new javax.swing.JButton();
        buttonSalirDetallesConductor = new javax.swing.JButton();
        panelMainConductor = new javax.swing.JPanel();
        buttonDetallesConductor = new javax.swing.JButton();
        buttonSalirMainConductor = new javax.swing.JButton();
        mensajeBienvenidaUsuario1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPasswordField1 = new javax.swing.JPasswordField();
        comboBoxRoles = new javax.swing.JComboBox<>();
        ingresarButton = new javax.swing.JButton();
        registrarseButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buttonRegistrarNuevoUsuario = new javax.swing.JButton();
        jPanelRegistro = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        textFieldNuevoUsuario = new javax.swing.JTextField();
        textFieldNuevoContraseña = new javax.swing.JTextField();
        textFieldNuevoNombre = new javax.swing.JTextField();
        textFieldNuevoTelefono = new javax.swing.JTextField();
        textFieldNuevoCorreo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        rolComboBox = new javax.swing.JComboBox<>();

        panelAdmin.setBackground(new java.awt.Color(102, 204, 0));
        panelAdmin.setMinimumSize(new java.awt.Dimension(734, 730));

        cargarUsuariosButton.setText("Cargar Usuarios");
        cargarUsuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarUsuariosButtonActionPerformed(evt);
            }
        });

        cargarLugaresButton.setText("Cargar Lugares");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel1");

        cargarConexionesButton.setText("Cargar Conexiones");

        cargarLocalidadesUsuarios.setText("Cargar Localidades Usuarios");
        cargarLocalidadesUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarLocalidadesUsuariosActionPerformed(evt);
            }
        });

        cargarLocalidadesConductores.setText("Cargar Localidades Conductores");
        cargarLocalidadesConductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarLocalidadesConductoresActionPerformed(evt);
            }
        });

        cargarReportesButton.setText("Cargar Reportes");

        cargarMapaButton.setText("Cargar Mapa");

        salirAdmin.setText("Salir");
        salirAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargarLugaresButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargarUsuariosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargarConexionesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargarLocalidadesUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargarLocalidadesConductores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargarReportesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargarMapaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salirAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(cargarUsuariosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargarLugaresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargarConexionesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargarLocalidadesUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargarLocalidadesConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cargarReportesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargarMapaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salirAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        panelDetallesUsuario.setBackground(new java.awt.Color(153, 255, 153));
        panelDetallesUsuario.setMinimumSize(new java.awt.Dimension(734, 730));

        jLabel6.setText("Nombre");

        jLabel7.setText("Nombre Usuario");

        jLabel8.setText("Correo");

        jLabel9.setText("Contraseña");

        jLabel10.setText("Telefono");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Detalles");

        buttonModificarInfoUsuario.setText("Modidficar");
        buttonModificarInfoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarInfoUsuarioActionPerformed(evt);
            }
        });

        buttonCerrarCuenta.setText("Cerrar Cuenta");

        buttonSalirDetallesUsuario.setText("Regresar");
        buttonSalirDetallesUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirDetallesUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetallesUsuarioLayout = new javax.swing.GroupLayout(panelDetallesUsuario);
        panelDetallesUsuario.setLayout(panelDetallesUsuarioLayout);
        panelDetallesUsuarioLayout.setHorizontalGroup(
            panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesUsuarioLayout.createSequentialGroup()
                .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDetallesUsuarioLayout.createSequentialGroup()
                                .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelDetallesUsuarioLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(buttonModificarInfoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDetallesUsuarioLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(buttonCerrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDetallesUsuarioLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(buttonSalirDetallesUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(471, Short.MAX_VALUE))
        );
        panelDetallesUsuarioLayout.setVerticalGroup(
            panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesUsuarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(buttonModificarInfoUsuario)
                .addGap(18, 18, 18)
                .addComponent(buttonCerrarCuenta)
                .addGap(18, 18, 18)
                .addComponent(buttonSalirDetallesUsuario)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        panelMainUsuario.setBackground(new java.awt.Color(204, 255, 204));
        panelMainUsuario.setForeground(new java.awt.Color(51, 0, 51));
        panelMainUsuario.setPreferredSize(new java.awt.Dimension(734, 730));

        buttonPedirViaje.setText("Pedir Viaje");

        buttonDetallesUsuario.setText("Detalles de Cuenta");
        buttonDetallesUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetallesUsuarioActionPerformed(evt);
            }
        });

        buttonSalirMainUsuario.setText("Salir");
        buttonSalirMainUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirMainUsuarioActionPerformed(evt);
            }
        });

        mensajeBienvenidaUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeBienvenidaUsuario.setText("jLabel1");

        javax.swing.GroupLayout panelMainUsuarioLayout = new javax.swing.GroupLayout(panelMainUsuario);
        panelMainUsuario.setLayout(panelMainUsuarioLayout);
        panelMainUsuarioLayout.setHorizontalGroup(
            panelMainUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainUsuarioLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(panelMainUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mensajeBienvenidaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSalirMainUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDetallesUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPedirViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        panelMainUsuarioLayout.setVerticalGroup(
            panelMainUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainUsuarioLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(mensajeBienvenidaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(buttonPedirViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonDetallesUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(buttonSalirMainUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        panelDetallesConductor.setBackground(new java.awt.Color(153, 255, 153));
        panelDetallesConductor.setMinimumSize(new java.awt.Dimension(734, 730));

        jLabel12.setText("Nombre");

        jLabel13.setText("Nombre Usuario");

        jLabel14.setText("Correo");

        jLabel15.setText("Contraseña");

        jLabel16.setText("Telefono");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("Detalles");

        buttonModificarInfoConductor.setText("Modidficar");
        buttonModificarInfoConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarInfoConductorActionPerformed(evt);
            }
        });

        buttonCerrarCuenta1.setText("Cerrar Cuenta");

        buttonSalirDetallesConductor.setText("Regresar");
        buttonSalirDetallesConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirDetallesConductorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetallesConductorLayout = new javax.swing.GroupLayout(panelDetallesConductor);
        panelDetallesConductor.setLayout(panelDetallesConductorLayout);
        panelDetallesConductorLayout.setHorizontalGroup(
            panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesConductorLayout.createSequentialGroup()
                .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesConductorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDetallesConductorLayout.createSequentialGroup()
                                .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelDetallesConductorLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(buttonModificarInfoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDetallesConductorLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(buttonCerrarCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDetallesConductorLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(buttonSalirDetallesConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(471, Short.MAX_VALUE))
        );
        panelDetallesConductorLayout.setVerticalGroup(
            panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesConductorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(textFieldNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textFieldUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(textFieldPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textFieldCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textFieldTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(buttonModificarInfoConductor)
                .addGap(18, 18, 18)
                .addComponent(buttonCerrarCuenta1)
                .addGap(18, 18, 18)
                .addComponent(buttonSalirDetallesConductor)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        panelMainConductor.setBackground(new java.awt.Color(204, 255, 204));
        panelMainConductor.setForeground(new java.awt.Color(51, 0, 51));
        panelMainConductor.setPreferredSize(new java.awt.Dimension(734, 730));

        buttonDetallesConductor.setText("Detalles de Cuenta");
        buttonDetallesConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetallesConductorActionPerformed(evt);
            }
        });

        buttonSalirMainConductor.setText("Salir");
        buttonSalirMainConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirMainConductorActionPerformed(evt);
            }
        });

        mensajeBienvenidaUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeBienvenidaUsuario1.setText("jLabel1");

        javax.swing.GroupLayout panelMainConductorLayout = new javax.swing.GroupLayout(panelMainConductor);
        panelMainConductor.setLayout(panelMainConductorLayout);
        panelMainConductorLayout.setHorizontalGroup(
            panelMainConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainConductorLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(panelMainConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mensajeBienvenidaUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSalirMainConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDetallesConductor, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        panelMainConductorLayout.setVerticalGroup(
            panelMainConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainConductorLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(mensajeBienvenidaUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214)
                .addComponent(buttonDetallesConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(buttonSalirMainConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setText("SAFEWAY");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(1);
        jTextArea1.setText("marvin_martinez");
        jScrollPane1.setViewportView(jTextArea1);

        jPasswordField1.setText("admin");
        jPasswordField1.setMinimumSize(new java.awt.Dimension(46, 22));

        comboBoxRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRolesActionPerformed(evt);
            }
        });

        ingresarButton.setText("Ingresar");
        ingresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarButtonActionPerformed(evt);
            }
        });

        registrarseButton.setText("Registrarse");
        registrarseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Usuario");

        buttonRegistrarNuevoUsuario.setText("Registrar");
        buttonRegistrarNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarNuevoUsuarioActionPerformed(evt);
            }
        });

        jPanelRegistro.setBackground(new java.awt.Color(204, 255, 204));

        jLabel18.setText("Nombre");

        jLabel19.setText("Usuario");

        jLabel20.setText("Telefono");

        jLabel21.setText("Contraseña");

        jLabel22.setText("Correo");

        jLabel23.setText("Rol");

        rolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Conductor" }));

        javax.swing.GroupLayout jPanelRegistroLayout = new javax.swing.GroupLayout(jPanelRegistro);
        jPanelRegistro.setLayout(jPanelRegistroLayout);
        jPanelRegistroLayout.setHorizontalGroup(
            jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelRegistroLayout.createSequentialGroup()
                        .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(44, 44, 44)))
                        .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldNuevoContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(textFieldNuevoTelefono)))
                    .addGroup(jPanelRegistroLayout.createSequentialGroup()
                        .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldNuevoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNuevoNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNuevoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        jPanelRegistroLayout.setVerticalGroup(
            jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroLayout.createSequentialGroup()
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistroLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(textFieldNuevoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(rolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelRegistroLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(textFieldNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addGap(28, 28, 28)
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(textFieldNuevoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(textFieldNuevoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(ingresarButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                            .addComponent(registrarseButton))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(comboBoxRoles, 0, 137, Short.MAX_VALUE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(227, 227, 227))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(buttonRegistrarNuevoUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jPanelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresarButton)
                    .addComponent(registrarseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRegistrarNuevoUsuario)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRolesActionPerformed

    private void ingresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarButtonActionPerformed
        // TODO add your handling code here:
        String textoUsuario = jTextArea1.getText();
        String contraseñaUsuario = jPasswordField1.getText();

        String passwordEncrypted = Hashing.sha256().hashString(contraseñaUsuario, StandardCharsets.UTF_8).toString();

        String nombreAdmin = "marvin_martinez";
        String contraseñaAdmin = "admin";

        if (comboBoxRoles.getSelectedItem() == "Admin" && nombreAdmin.equals(textoUsuario) && contraseñaAdmin.equals(contraseñaUsuario)) {

            jPanel1.setVisible(false);
            panelAdmin.setVisible(true);

            this.setContentPane(panelAdmin);
            this.repaint();
        } else if (comboBoxRoles.getSelectedItem() == "Usuario") {
            Usuario actual = arbolUsuarios.encontrarUsuario(textoUsuario, arbolUsuarios.getRaiz());
            usuarioActual = actual;
            if (actual != null && textoUsuario.equals(actual.getUsuario()) && passwordEncrypted.equals(actual.getContraseña())) {
                jPanel1.setVisible(false);
                panelMainUsuario.setVisible(true);

                mensajeBienvenidaUsuario.setText("Bienvenido " + actual.getNombre());
                textFieldUsuario.setText(actual.getUsuario());
                textFieldCorreo.setText(actual.getCorreo());
                textFieldNombre.setText(actual.getNombre());
                textFieldTelefono.setText(actual.getTelefono());

                this.setContentPane(panelMainUsuario);
                this.repaint();

            }
        } else if (comboBoxRoles.getSelectedItem() == "Conductor") {
            Usuario actual = arbolConductores.encontrarUsuario(textoUsuario, arbolConductores.getRaiz());
            usuarioActual = actual;
            if (actual != null && textoUsuario.equals(actual.getUsuario()) && passwordEncrypted.equals(actual.getContraseña())) {
                jPanel1.setVisible(false);
                panelMainConductor.setVisible(true);

                mensajeBienvenidaUsuario1.setText("Bienvenido " + actual.getNombre());
                textFieldUsuario1.setText(actual.getUsuario());
                textFieldCorreo1.setText(actual.getCorreo());
                textFieldNombre1.setText(actual.getNombre());
                textFieldTelefono1.setText(actual.getTelefono());

                this.setContentPane(panelMainConductor);
                this.repaint();
            }
        }

        System.out.println("Ingresar pressed");
        System.out.println(textoUsuario);
        System.out.println(contraseñaUsuario);


    }//GEN-LAST:event_ingresarButtonActionPerformed

    private void registrarseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseButtonActionPerformed
        // TODO add your handling code here:
        jPanelRegistro.setVisible(true);
    }//GEN-LAST:event_registrarseButtonActionPerformed

    private void salirAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirAdminActionPerformed
        // TODO add your handling code here:
        panelAdmin.setVisible(false);
        jPanel1.setVisible(true);
        this.setContentPane(jPanel1);

        jTextArea1.setText("");
        jPasswordField1.setText("");
    }//GEN-LAST:event_salirAdminActionPerformed

    private void cargarUsuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarUsuariosButtonActionPerformed
        JsonFileOpenerUsuarios fileOpener = new JsonFileOpenerUsuarios();

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setSelectedFile(new File(""));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(jPanel1) == JFileChooser.OPEN_DIALOG) {
            fileOpener.abrir(chooser.getSelectedFile().getPath());
            fileOpener.agregarArbolUsuarios(arbolUsuarios, arbolConductores);
            //arbolUsuarios.graficarArbol("Usuarios");
            //arbolConductores.graficarArbol("Conductores");
        } else {
            // do when cancel
        }
    }//GEN-LAST:event_cargarUsuariosButtonActionPerformed

    private void cargarLocalidadesUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarLocalidadesUsuariosActionPerformed
        JsonFileOpenerLocalidadesUsuarios fileOpener = new JsonFileOpenerLocalidadesUsuarios();

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setSelectedFile(new File(""));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(jPanel1) == JFileChooser.OPEN_DIALOG) {
            fileOpener.abrir(chooser.getSelectedFile().getPath());
            fileOpener.asignarLocalidadesUsuarios(arbolUsuarios);

        } else {
            // do when cancel
        }
    }//GEN-LAST:event_cargarLocalidadesUsuariosActionPerformed

    private void cargarLocalidadesConductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarLocalidadesConductoresActionPerformed
        // TODO add your handling code here:
        //asignarLocalidadesUsuarios
        JsonFileOpenerLocalidadesConductores fileOpener = new JsonFileOpenerLocalidadesConductores();

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setSelectedFile(new File(""));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(jPanel1) == JFileChooser.OPEN_DIALOG) {
            fileOpener.abrir(chooser.getSelectedFile().getPath());
            fileOpener.asignarLocalidadesConductores(arbolConductores);

        } else {
            // do when cancel
        }
    }//GEN-LAST:event_cargarLocalidadesConductoresActionPerformed

    private void buttonModificarInfoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarInfoUsuarioActionPerformed
        // TODO add your handling code here:
        String passwordEncrypted = Hashing.sha256().hashString(textFieldPassword.getText(), StandardCharsets.UTF_8).toString();

        mensajeBienvenidaUsuario1.setText("Bienvenido " + usuarioActual.getNombre());
        usuarioActual.setUsuario(textFieldUsuario.getText());
        usuarioActual.setContraseña(passwordEncrypted);
        usuarioActual.setCorreo(textFieldCorreo.getText());
        usuarioActual.setNombre(textFieldNombre.getText());
        usuarioActual.setTelefono(textFieldTelefono.getText());

    }//GEN-LAST:event_buttonModificarInfoUsuarioActionPerformed

    private void buttonSalirMainUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirMainUsuarioActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        panelMainUsuario.setVisible(false);
        this.setContentPane(jPanel1);
        this.repaint();
        usuarioActual = null;
    }//GEN-LAST:event_buttonSalirMainUsuarioActionPerformed

    private void buttonDetallesUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetallesUsuarioActionPerformed
        // TODO add your handling code here:
        panelDetallesUsuario.setVisible(true);
        panelMainUsuario.setVisible(false);

        textFieldUsuario.setText(usuarioActual.getUsuario());
        textFieldCorreo.setText(usuarioActual.getCorreo());
        textFieldNombre.setText(usuarioActual.getNombre());
        textFieldTelefono.setText(usuarioActual.getTelefono());

        this.setContentPane(panelDetallesUsuario);
        this.repaint();


    }//GEN-LAST:event_buttonDetallesUsuarioActionPerformed

    private void buttonSalirDetallesUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirDetallesUsuarioActionPerformed
        // TODO add your handling code here:
        panelDetallesUsuario.setVisible(false);
        panelMainUsuario.setVisible(true);
        this.setContentPane(panelMainUsuario);
        this.repaint();
    }//GEN-LAST:event_buttonSalirDetallesUsuarioActionPerformed

    private void buttonModificarInfoConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarInfoConductorActionPerformed
        // TODO add your handling code here:
        String passwordEncrypted = Hashing.sha256().hashString(textFieldPassword1.getText(), StandardCharsets.UTF_8).toString();

        mensajeBienvenidaUsuario1.setText("Bienvenido " + usuarioActual.getNombre());
        usuarioActual.setUsuario(textFieldUsuario1.getText());
        usuarioActual.setContraseña(passwordEncrypted);
        usuarioActual.setCorreo(textFieldCorreo1.getText());
        usuarioActual.setNombre(textFieldNombre1.getText());
        usuarioActual.setTelefono(textFieldTelefono1.getText());

    }//GEN-LAST:event_buttonModificarInfoConductorActionPerformed

    private void buttonSalirDetallesConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirDetallesConductorActionPerformed
        // TODO add your handling code here:
        panelDetallesConductor.setVisible(false);
        panelMainConductor.setVisible(true);
        this.setContentPane(panelMainConductor);
        this.repaint();
    }//GEN-LAST:event_buttonSalirDetallesConductorActionPerformed

    private void buttonDetallesConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetallesConductorActionPerformed
        // TODO add your handling code here:
        panelDetallesConductor.setVisible(true);
        panelMainConductor.setVisible(false);

        mensajeBienvenidaUsuario1.setText("Bienvenido " + usuarioActual.getNombre());
        textFieldUsuario1.setText(usuarioActual.getUsuario());
        textFieldCorreo1.setText(usuarioActual.getCorreo());
        textFieldNombre1.setText(usuarioActual.getNombre());
        textFieldTelefono1.setText(usuarioActual.getTelefono());
        this.setContentPane(panelDetallesConductor);
        this.repaint();

    }//GEN-LAST:event_buttonDetallesConductorActionPerformed

    private void buttonSalirMainConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirMainConductorActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        panelMainConductor.setVisible(false);
        this.setContentPane(jPanel1);
        this.repaint();
        usuarioActual = null;
    }//GEN-LAST:event_buttonSalirMainConductorActionPerformed

    private void buttonRegistrarNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarNuevoUsuarioActionPerformed
        // TODO add your handling code here:
        int lastIdUsuario = arbolUsuarios.getLastIndex(arbolUsuarios.getRaiz());
        int lastIdConductor = arbolConductores.getLastIndex(arbolConductores.getRaiz());

        String rolSeleccionado = (String) rolComboBox.getSelectedItem();
        String passwordEncrypted = Hashing.sha256().hashString(textFieldNuevoContraseña.getText(), StandardCharsets.UTF_8).toString();

        if (rolSeleccionado.equals("Normal")) {
            Usuario nuevoUsuario = new Usuario(lastIdUsuario + 1, textFieldNuevoNombre.getText(), textFieldNuevoUsuario.getText(),
                    textFieldNuevoCorreo.getText(), passwordEncrypted, textFieldNuevoTelefono.getText(), (String) rolComboBox.getSelectedItem());

            jPanelRegistro.setVisible(false);
            arbolUsuarios.insertar(lastIdUsuario + 1, nuevoUsuario);
            buttonRegistrarNuevoUsuario.setVisible(false);
        } else {
            Usuario nuevoUsuario = new Usuario(lastIdConductor + 1, textFieldNuevoNombre.getText(), textFieldNuevoUsuario.getText(),
                    textFieldNuevoCorreo.getText(), passwordEncrypted, textFieldNuevoTelefono.getText(), (String) rolComboBox.getSelectedItem());

            jPanelRegistro.setVisible(false);
            arbolConductores.insertar(lastIdConductor + 1, nuevoUsuario);
            buttonRegistrarNuevoUsuario.setVisible(false);
        }


    }//GEN-LAST:event_buttonRegistrarNuevoUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCerrarCuenta;
    private javax.swing.JButton buttonCerrarCuenta1;
    private javax.swing.JButton buttonDetallesConductor;
    private javax.swing.JButton buttonDetallesUsuario;
    private javax.swing.JButton buttonModificarInfoConductor;
    private javax.swing.JButton buttonModificarInfoUsuario;
    private javax.swing.JButton buttonPedirViaje;
    private javax.swing.JButton buttonRegistrarNuevoUsuario;
    private javax.swing.JButton buttonSalirDetallesConductor;
    private javax.swing.JButton buttonSalirDetallesUsuario;
    private javax.swing.JButton buttonSalirMainConductor;
    private javax.swing.JButton buttonSalirMainUsuario;
    private javax.swing.JButton cargarConexionesButton;
    private javax.swing.JButton cargarLocalidadesConductores;
    private javax.swing.JButton cargarLocalidadesUsuarios;
    private javax.swing.JButton cargarLugaresButton;
    private javax.swing.JButton cargarMapaButton;
    private javax.swing.JButton cargarReportesButton;
    private javax.swing.JButton cargarUsuariosButton;
    private javax.swing.JComboBox<String> comboBoxRoles;
    private javax.swing.JButton ingresarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelRegistro;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel mensajeBienvenidaUsuario;
    private javax.swing.JLabel mensajeBienvenidaUsuario1;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelDetallesConductor;
    private javax.swing.JPanel panelDetallesUsuario;
    private javax.swing.JPanel panelMainConductor;
    private javax.swing.JPanel panelMainUsuario;
    private javax.swing.JButton registrarseButton;
    private javax.swing.JComboBox<String> rolComboBox;
    private javax.swing.JButton salirAdmin;
    private javax.swing.JTextField textFieldCorreo;
    private javax.swing.JTextField textFieldCorreo1;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldNombre1;
    private javax.swing.JTextField textFieldNuevoContraseña;
    private javax.swing.JTextField textFieldNuevoCorreo;
    private javax.swing.JTextField textFieldNuevoNombre;
    private javax.swing.JTextField textFieldNuevoTelefono;
    private javax.swing.JTextField textFieldNuevoUsuario;
    private javax.swing.JTextField textFieldPassword;
    private javax.swing.JTextField textFieldPassword1;
    private javax.swing.JTextField textFieldTelefono;
    private javax.swing.JTextField textFieldTelefono1;
    private javax.swing.JTextField textFieldUsuario;
    private javax.swing.JTextField textFieldUsuario1;
    // End of variables declaration//GEN-END:variables
}
