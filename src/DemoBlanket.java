import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoBlanket extends JFrame {

    private Blanket myBlanket;
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
    private JComboBox DropBlanket;
    private JButton infoButton;
    private JButton availableMaterialsButton;

    public DemoBlanket() {
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (DropMaterial.getSelectedIndex() != 0 && DropSize.getSelectedIndex() != 0 && DropBlanket.getSelectedIndex() == 0)
                {
                    myBlanket = new Blanket(DropSize.getSelectedItem().toString(), DropMaterial.getSelectedItem().toString());
                    txtDisplay.setText("<html>" + myBlanket.toString().replace("\n", "<br>") + "</html>");
                    DropChange.setEnabled(true);
                    txtChange.setEnabled(true);
                    if (DropChange.getItemCount() != 4)
                    {
                        DropChange.removeItem("Number of Heat Settings");
                        DropChange.removeItem("Has Automatic ShutOff");
                    }
                }
                else if (DropMaterial.getSelectedIndex() != 0 && DropSize.getSelectedIndex() != 0 && DropBlanket.getSelectedIndex() == 1)
                {
                    myBlanket = new ElectricBlanket(DropSize.getSelectedItem().toString(), DropMaterial.getSelectedItem().toString());
                    txtDisplay.setText("<html>" + myBlanket.toString().replace("\n", "<br>") + "</html>");
                    DropChange.setEnabled(true);
                    txtChange.setEnabled(true);
                    if (DropChange.getItemCount() == 4)
                    {
                        DropChange.addItem("Number of Heat Settings");
                        DropChange.addItem("Has Automatic ShutOff");
                    }
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
                        case 4:
                            input = txtChange.getText().replace("\n", " ");
                            int number = 0;
                            try
                            {
                                number = Integer.parseInt(input);
                            }
                            catch(NumberFormatException ex)
                            {
                                JOptionPane.showMessageDialog(null,"Invalid Input");
                            }
                            finally
                            {
                                ((ElectricBlanket) myBlanket).setNumberOfHeatSettings(number);
                            }

                            break;
                        case 5:
                            input = txtChange.getText().replace("\n", " ");
                            if (input.equalsIgnoreCase("yes"))
                            {
                                ((ElectricBlanket) myBlanket).setHasAutomaticShutOff(true);
                            }
                            else if(input.equalsIgnoreCase("no"))
                            {
                                ((ElectricBlanket) myBlanket).setHasAutomaticShutOff(false);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Invalid input (yes/no)");
                            }
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


    }

    public static void main(String[] args) {

        DemoBlanket View = new DemoBlanket();

        View.setContentPane(View.MainPanel);
        View.setBounds(400,250,600,400);
        View.setDefaultCloseOperation(EXIT_ON_CLOSE);
        View.setVisible(true);

    }
}
