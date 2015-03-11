/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storybook.importCharacter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
import storybook.model.hbn.entity.Gender;
import storybook.model.hbn.entity.Person;

/**
 *
 * @author Max
 */
public class DlgImportCharacter extends javax.swing.JDialog {

    private File file;
    ArrayList<CharacterImportModel> characterList;

    /**
     * Creates new form DlgImportCharacter
     */
    public DlgImportCharacter(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Map findGender(String[] input) {
        Map genderMap = new HashMap();
        int position = 0;
        for (String s : input) {
            if (isMale(s)) {
                genderMap.put(position, "M");
            } else if (isFemale(s)) {
                genderMap.put(position, "F");
            }
            position++;
        }

        return genderMap;
    }

    public boolean isMale(String input) {
        boolean result = false;
        input = input.toLowerCase();
        if (input.equals("boy") || input.equals("male") || input.equals("man") || input.equals("he") || input.equals("his")) {
            result = true;
        }
        return result;
    }

    public boolean isFemale(String input) {
        boolean result = false;
        input = input.toLowerCase();
        if (input.equals("girl") || input.equals("female") || input.equals("woman") || input.equals("she") || input.equals("her")) {
            return true;
        }
        return result;
    }
    
    public ArrayList<CharacterImportModel> getCharacterList() {
        return characterList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txFolder = new javax.swing.JTextField();
        btFolder = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        btImport = new javax.swing.JButton();
        importLabel = new javax.swing.JLabel();
        scanButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        characterTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/open.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("storybook/msg/messages"); // NOI18N
        btFolder.setText(bundle.getString("msg.common.choose.folder")); // NOI18N
        btFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFolderActionPerformed(evt);
            }
        });

        btClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/close.png"))); // NOI18N
        btClose.setText(bundle.getString("msg.common.cancel")); // NOI18N
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        btImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/export.png"))); // NOI18N
        btImport.setLabel("Import");
        btImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportActionPerformed(evt);
            }
        });

        importLabel.setText("Import From:");

        scanButton.setText("Scan");
        scanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanButtonActionPerformed(evt);
            }
        });

        characterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Gender"
            }
        ));
        jScrollPane1.setViewportView(characterTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btImport, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(importLabel)
                                .addGap(40, 40, 40)
                                .addComponent(txFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btFolder))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(scanButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFolder)
                    .addComponent(importLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btImport)
                    .addComponent(btClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFolderActionPerformed
        JFileChooser chooser = new JFileChooser(txFolder.getText());
        chooser.setFileSelectionMode(2);
        int i = chooser.showOpenDialog(this);
        if (i != 0) {
            return;
        }
        file = chooser.getSelectedFile();
        txFolder.setText(file.getAbsolutePath());
    }//GEN-LAST:event_btFolderActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed

        dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    private void btImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportActionPerformed
        if (characterList.isEmpty() || characterList == null) {
            JOptionPane.showMessageDialog(this, "No characters loaded, select a file.", "Error:", JOptionPane.WARNING_MESSAGE);
        }

        dispose();
        

    }//GEN-LAST:event_btImportActionPerformed

    
    private void scanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanButtonActionPerformed
        // TODO add your handling code here:

        if (file == null || txFolder.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No file found.", "Error:", JOptionPane.WARNING_MESSAGE);
        } else {
            InputStream modelIn = null;
            try {

                // ArrayList of Characters
                characterList = new ArrayList<CharacterImportModel>();

                URL url = getClass().getResource("/storybook/resources/en-ner-person.bin");
                File enPerson = new File(url.getPath());
                modelIn = new FileInputStream(enPerson);
                TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
                modelIn.close();
                NameFinderME nameFinder = new NameFinderME(model);
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                StringBuffer stringBuffer = new StringBuffer();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] sentence = line.split(" ");
                    Map genderMap = findGender(sentence);
                    Span nameSpans[] = nameFinder.find(sentence);
                    for (Span s : nameSpans) {
                        System.out.println(s.toString());
                        CharacterImportModel character = new CharacterImportModel();
                        character.setFirstName(sentence[s.getStart()]);
                        if(s.getStart()+1==sentence.length){
                            character.setLastName("unknown");    
                        } else{
                            character.setLastName(sentence[s.getStart()+1]);
                        }
                        for (Object k : genderMap.keySet()) {
                            int position = (int) k;
                            if (s.getStart() + 20 > position && position > s.getStart()) {
                                character.setGender((String) genderMap.get(k));
                            }
                        }
                        boolean add = true;
                        for(CharacterImportModel ci : characterList) {
                            if(ci.getFirstName().equals(character.getFirstName()) && ci.getLastName().equals(character.getLastName())) {
                                add = false;
                                if(ci.getGender() == null && character.getGender() != null) {
                                    ci.setGender(character.getGender());
                                    
                                }
                            }
                        }
                        if(add && !character.getFirstName().equals("unknown") && !character.getLastName().equals("unknown")) {
                            characterList.add(character);
                        }
                    }
                }
                fileReader.close();
                DefaultTableModel tableModel = (DefaultTableModel) characterTable.getModel();
                for (CharacterImportModel c : characterList) {
                    tableModel.addRow(new Object[]{c.getFirstName(), c.getLastName(), c.getGender()});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.toString(), "Error:", JOptionPane.WARNING_MESSAGE);
                System.out.println(e.getStackTrace().toString());
            } finally {
                if (modelIn != null) {
                    try {
                        modelIn.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }//GEN-LAST:event_scanButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DlgImportCharacter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgImportCharacter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgImportCharacter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgImportCharacter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgImportCharacter dialog = new DlgImportCharacter(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btFolder;
    private javax.swing.JButton btImport;
    private javax.swing.JTable characterTable;
    private javax.swing.JLabel importLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton scanButton;
    private javax.swing.JTextField txFolder;
    // End of variables declaration//GEN-END:variables
}
