/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AppearancePanel.java
 *
 * Created on 14.11.2011, 09:26:30
 */
package com.semantic.swing.preferences;

import com.semantic.swing.MainFrame;
import org.jdesktop.swingx.util.OS;
import static com.semantic.swing.preferences.GlobalKeys.*;

/**
 *
 * @author Christian
 */
class AppearancePanel extends javax.swing.JPanel {

    /** Creates new form AppearancePanel */
    public AppearancePanel() {
        initComponents();
        initOwnComponents();
    }

    private void initOwnComponents() {
        checkDescription.setSelected(MainFrame.PREF.getBoolean(KEY_DRAW_DESCRIPTION, true));
        checkShadow.setSelected(MainFrame.PREF.getBoolean(KEY_DRAW_SHADOW, true));
        checkLF.setSelected(MainFrame.PREF.getBoolean(KEY_BUNDLE_LOOK, OS.isMacOSX() ? false : true));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();
        checkDescription = new javax.swing.JCheckBox();
        checkShadow = new javax.swing.JCheckBox();
        jXTitledSeparator2 = new org.jdesktop.swingx.JXTitledSeparator();
        checkLF = new javax.swing.JCheckBox();

        jXTitledSeparator1.setTitle("Grid View");

        checkDescription.setText("Show Description");
        checkDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDescriptionActionPerformed(evt);
            }
        });

        checkShadow.setText("Show Shadow");
        checkShadow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkShadowActionPerformed(evt);
            }
        });

        jXTitledSeparator2.setScrollableWidthHint(org.jdesktop.swingx.ScrollableSizeHint.NONE);
        jXTitledSeparator2.setTitle("Look & Feel");

        checkLF.setText("Use Bundle Look & Feel (needs restart!)");
        checkLF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(checkLF))
                    .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkShadow)
                            .addComponent(checkDescription)))
                    .addComponent(jXTitledSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkShadow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXTitledSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkLF)
                .addContainerGap(171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkShadowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkShadowActionPerformed
        MainFrame.PREF.putBoolean(KEY_DRAW_SHADOW, checkShadow.isSelected());
    }//GEN-LAST:event_checkShadowActionPerformed

    private void checkDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDescriptionActionPerformed
        MainFrame.PREF.putBoolean(KEY_DRAW_DESCRIPTION, checkDescription.isSelected());
    }//GEN-LAST:event_checkDescriptionActionPerformed

    private void checkLFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLFActionPerformed
        MainFrame.PREF.putBoolean(KEY_BUNDLE_LOOK, checkLF.isSelected());
    }//GEN-LAST:event_checkLFActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkDescription;
    private javax.swing.JCheckBox checkLF;
    private javax.swing.JCheckBox checkShadow;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator2;
    // End of variables declaration//GEN-END:variables
}
