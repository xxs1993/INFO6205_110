import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        taskNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        serversNumber = new javax.swing.JTextField();
        start = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        solutionNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Number of Tasks");

        taskNumber.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        taskNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskNumberActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Number of Servers");

        serversNumber.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        serversNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serversNumberActionPerformed(evt);
            }
        });

        start.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Number of Solutions");

        solutionNumber.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        solutionNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(493, 493, 493)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(serversNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                        .addComponent(solutionNumber))
                    .addComponent(taskNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(solutionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(taskNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serversNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(84, 84, 84)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serversNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serversNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serversNumberActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        start.setEnabled(false);
        start.setText("Processing");
        String task = taskNumber.getText();
        String server = serversNumber.getText();
        String solution = solutionNumber.getText();
        if(task.isEmpty() || server.isEmpty()|| solution.isEmpty()){
            JOptionPane.showMessageDialog(null,"Input can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
         GARun  gaRun ;
         try{
              gaRun = new GARun(Integer.parseInt(task),Integer.parseInt(server),Integer.parseInt(solution));
         }catch(NumberFormatException e){
              JOptionPane.showMessageDialog(null,"Input must be numbers!!","Warining",JOptionPane.WARNING_MESSAGE);
              return;
         }
        System.out.printf("start");
        List<Chromosome> list = gaRun.getSolutions().subList(0,Integer.parseInt(solution));
        System.out.printf("end");
        List<String> list1 = new ArrayList<>();
        list1.add("Task using time:");
        String[] tasks = gaRun.getTasks().stream().map(x->String.valueOf(x.getWorkload()))
                .toArray(size->new String[size]);
        list1.add(Arrays.toString(tasks));
        list1.add("Servers exceeding speeds :");
        gaRun.getServers().stream().forEach(x-> list1.add(x.getId() +" : " + Arrays.toString(x.getExecutingSpeedList().toArray())));
        list1.add(" Server Solutions");

        for(Chromosome chromosome :list){
            int[] idList = chromosome.getGenes().stream().mapToInt(Server ::getId).toArray();

            list1.add(Arrays.toString(idList) + " degree : "+ chromosome.getFitness());
        }
        String fileName = FileUtil.writeData(list1);
        JOptionPane.showMessageDialog(null,"Finished and fileName is : "+fileName ,"Info",JOptionPane.INFORMATION_MESSAGE);
        start.setText("Start");
        start.setEnabled(true);
    }//GEN-LAST:event_startActionPerformed

    private void taskNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskNumberActionPerformed

    private void solutionNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_solutionNumberActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField serversNumber;
    private javax.swing.JTextField solutionNumber;
    private javax.swing.JButton start;
    private javax.swing.JTextField taskNumber;
    // End of variables declaration//GEN-END:variables
}
