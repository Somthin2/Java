import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class DemoBlanket extends JFrame {

    public Blanket myBlanket;
    private JPanel MainPanel;
    private JComboBox DropSize;
    private JComboBox DropMaterial;
    private JButton btnCreate;
    private JPanel DisplayInfo;
    private JLabel txtDisplay;
    private JComboBox DropChange;
    private JTextArea txtChange;
    private JButton updateButton;
    private JButton buyBlanketButton;
    private JButton infoButton;

    public DemoBlanket() {
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (DropMaterial.getSelectedIndex() != 0 && DropSize.getSelectedIndex() != 0)
                {
                    myBlanket = new Blanket(DropSize.getSelectedItem().toString(), DropMaterial.getSelectedItem().toString());
                    txtDisplay.setText("<html>" + myBlanket.toString().replace("\n", "<br>") + "</html>");
                    DropChange.setEnabled(true);
                    txtChange.setEnabled(true);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (DropChange.getSelectedIndex() != 0) {
                    String input;
                    switch (DropChange.getSelectedIndex()) {
                        case 1:
                            input = txtChange.getText().replace("\n", " ");
                            myBlanket.setColor(input);
                            break;
                        case 2:
                            input = txtChange.getText().replace("\n", " ");
                            myBlanket.setBrand(input);
                            break;
                        case 3:
                            input = txtChange.getText().replace("\n", " ");
                            myBlanket.CheckDiscountCode(input);
                            break;

                    }
                    txtChange.setText("");
                    txtDisplay.setText("<html>" + myBlanket.toString().replace("\n", "<br>") + "</html>");
                }
            }
        });
        buyBlanketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myBlanket != null)
                {
                    myBlanket.RemoveOneBlanket();
                    txtDisplay.setText("<html>" + myBlanket.toString().replace("\n", "<br>") + "</html>");
                }
            }
        });
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {

        DemoBlanket View = new DemoBlanket();

        View.setContentPane(View.MainPanel);
        View.setBounds(400,250,600,400);
        View.setDefaultCloseOperation(EXIT_ON_CLOSE);
        View.setVisible(true);

    }
}
