package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorMenu;
import javax.swing.JFrame;

/**
 *
 * @author eddyf
 */
public class VMenuSwing extends javax.swing.JPanel implements IVMenu{
    private JFrame frame = new JFrame("Menu Rock Paper Scissor Lizard Spock");
    private Validacion validar = new Validacion();
    private PresentadorMenu presentador;
    
    public VMenuSwing() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenuOpciones = new javax.swing.JPanel();
        btnPartidaJvJ = new javax.swing.JButton();
        btnPartidaJvB = new javax.swing.JButton();
        btnPartidaBvB = new javax.swing.JButton();
        btnCargarPartida = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelTituloMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        btnPartidaJvJ.setText("JUGADOR CONTRA JUGADOR");
        btnPartidaJvJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidaJvJActionPerformed(evt);
            }
        });

        btnPartidaJvB.setText("JUGADOR CONTRA BOT");
        btnPartidaJvB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidaJvBActionPerformed(evt);
            }
        });

        btnPartidaBvB.setText("BOT CONTRA BOT");
        btnPartidaBvB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidaBvBActionPerformed(evt);
            }
        });

        btnCargarPartida.setText("CARGAR PARTIDA");
        btnCargarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarPartidaActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 51, 51));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuOpcionesLayout = new javax.swing.GroupLayout(panelMenuOpciones);
        panelMenuOpciones.setLayout(panelMenuOpcionesLayout);
        panelMenuOpcionesLayout.setHorizontalGroup(
            panelMenuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuOpcionesLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(panelMenuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPartidaJvJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPartidaJvB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPartidaBvB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCargarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(118, 118, 118))
        );
        panelMenuOpcionesLayout.setVerticalGroup(
            panelMenuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuOpcionesLayout.createSequentialGroup()
                .addComponent(btnPartidaJvJ, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnPartidaJvB, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnPartidaBvB, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCargarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ROCK PAPER SCISSORS LIZARD SPOCK THE GAME");

        javax.swing.GroupLayout panelTituloMenuLayout = new javax.swing.GroupLayout(panelTituloMenu);
        panelTituloMenu.setLayout(panelTituloMenuLayout);
        panelTituloMenuLayout.setHorizontalGroup(
            panelTituloMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        panelTituloMenuLayout.setVerticalGroup(
            panelTituloMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTituloMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelTituloMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMenuOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPartidaJvJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidaJvJActionPerformed
        presentador.iniciarPartidaJvJ();
    }//GEN-LAST:event_btnPartidaJvJActionPerformed

    private void btnPartidaJvBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidaJvBActionPerformed
        presentador.iniciarPartidaJvB();
    }//GEN-LAST:event_btnPartidaJvBActionPerformed

    private void btnPartidaBvBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidaBvBActionPerformed
        presentador.iniciarPartidaBvB();
    }//GEN-LAST:event_btnPartidaBvBActionPerformed

    private void btnCargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarPartidaActionPerformed
        presentador.mostrarMenuCargarPartidas();
    }//GEN-LAST:event_btnCargarPartidaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarPartida;
    private javax.swing.JButton btnPartidaBvB;
    private javax.swing.JButton btnPartidaJvB;
    private javax.swing.JButton btnPartidaJvJ;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelMenuOpciones;
    private javax.swing.JPanel panelTituloMenu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setPresentador(PresentadorMenu p) {
       presentador=p;
    }

    @Override
    public void iniciar() {
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(625, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void cerrar() {
        frame.dispose();
    }
    
    @Override
    public String getnombreJugador() {
        return validar.inNombreJugadorOptionPane("Ingrese el Nombre del Jugador");
    }

    @Override
    public int getPuntosMaximos() {
        return validar.inPtosMaximosOptionPane("Ingrese Puntos necesarios para ganar");
    }

    @Override
    public String getTipoVista() {
        return "Swing";
    }
}
