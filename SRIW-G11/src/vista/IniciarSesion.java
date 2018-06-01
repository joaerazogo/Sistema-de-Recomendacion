package vista;

public class IniciarSesion extends javax.swing.JFrame {

    /**
     * Creates new form IniciarSesion
     */
    public IniciarSesion() {
        initComponents();
        errorLabel.setVisible(false);
        setLocationRelativeTo(null);
    }
                             
    private void initComponents() {

        labelUserName = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        TextUserName = new javax.swing.JTextField();
        TextPassword = new javax.swing.JPasswordField();
        signUpButton = new javax.swing.JButton();
        IniciarSesionButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelUserName.setText("Nombre de usuario");

        labelPassword.setText("Contrase�a");

        labelTitle.setText("SRIW-G11");

        signUpButton.setText("Registrarse");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        IniciarSesionButton.setText("Iniciar sesion");
        IniciarSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(signUpButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IniciarSesionButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelTitle)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TextUserName)
                                        .addComponent(TextPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUserName)
                    .addComponent(TextUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPassword)
                    .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IniciarSesionButton)
                    .addComponent(signUpButton))
                .addGap(18, 18, 18)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
                                        

    private void IniciarSesionButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        if(TextUserName.getText().equals("") || TextPassword.getPassword().length == 0){
            errorLabel.setText("Campos vacios");
            errorLabel.setVisible(true);
        }else{
            if(controlador.IniciarSesion.autenticacion(TextUserName.getText(), String.valueOf(TextPassword.getPassword()) )){
                System.out.println("check, usuario logeado");
                //(new interfaz()).setVisible(true);
            }else{
                errorLabel.setText("Usuario no registrado");
                errorLabel.setVisible(true); 
            }
        }
    }                                                   

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        (new RegistrarUsuario()).setVisible(true);
        this.setVisible(false);
    }                                            

    // Variables declaration - do not modify                     
    private javax.swing.JButton IniciarSesionButton;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JTextField TextUserName;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JButton signUpButton;
    // End of variables declaration                   
}
