import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoBlankets extends JFrame
{
    public Blanket myBlanket;
    private JComboBox DropDown ;
    private JButton btnClick;
    private JPanel MainP;
    private JComboBox comboBox1;
    private JLabel out;
    private JButton clickMeForItemsButton;
    private JLabel LtoString;


    public DemoBlankets() {
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (DropDown.getSelectedIndex() != 0 && comboBox1.getSelectedIndex() != 0)
                {
                    myBlanket = new Blanket(DropDown.getSelectedItem().toString(), comboBox1.getSelectedItem().toString());

                    out.setText("You have selected for Size : " + myBlanket.getSize() + " and for Material : " + myBlanket.getMaterial());
                }
            }
        });
        clickMeForItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (myBlanket != null)
                {
                    LtoString.setText(myBlanket.toString());
                }
            }
        });
    }

    public static void main(String[] args) {

        DemoBlankets Bro = new DemoBlankets();

        Bro.setContentPane(Bro.MainP);
        Bro.setBounds(600,200,400,400);
        Bro.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Bro.setVisible(true);
    }

}
