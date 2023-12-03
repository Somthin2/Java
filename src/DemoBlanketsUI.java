import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoBlanketsUI {
    private Blanket blanket;
    private JTextArea detailsTextArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DemoBlanketsUI demoBlanketsUI = new DemoBlanketsUI();
            demoBlanketsUI.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        blanket = new Blanket();

        JFrame frame = new JFrame("Blanket Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel sizeLabel = new JLabel("Size:");
        JComboBox<String> sizeComboBox = new JComboBox<>(new String[]{"Twin", "Double", "Queen", "King"});
        sizeComboBox.setSelectedItem(blanket.getSize());

        JLabel colorLabel = new JLabel("Color:");
        JTextField colorTextField = new JTextField(blanket.getColor());

        JLabel materialLabel = new JLabel("Material:");
        JComboBox<String> materialComboBox = new JComboBox<>(new String[]{"Cotton", "Wool", "Cashmere"});
        materialComboBox.setSelectedItem(blanket.getMaterial());

        inputPanel.add(sizeLabel);
        inputPanel.add(sizeComboBox);
        inputPanel.add(colorLabel);
        inputPanel.add(colorTextField);
        inputPanel.add(materialLabel);
        inputPanel.add(materialComboBox);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blanket.setSize((String) sizeComboBox.getSelectedItem());
                blanket.setColor(colorTextField.getText());
                blanket.setMaterial((String) materialComboBox.getSelectedItem());
                updateBlanketDetails();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(updateButton);

        JPanel detailsPanel = new JPanel(new BorderLayout());
        JLabel detailsLabel = new JLabel("Blanket Details:");
        detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);
        detailsPanel.add(detailsLabel, BorderLayout.NORTH);
        detailsPanel.add(new JScrollPane(detailsTextArea), BorderLayout.CENTER);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(detailsPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void updateBlanketDetails() {
        detailsTextArea.setText(blanket.toString());
    }
}