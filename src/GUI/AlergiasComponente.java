package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlergiasComponente extends JFrame {
	private JPanel contentPane;
    private JTextField textField;
    private JList<String> alergiasList;
    private DefaultListModel<String> listModel;

    public AlergiasComponente() {
        setTitle("Gestión de Alergias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Componentes
        textField = new JTextField(20);
        JButton agregarButton = new JButton("Agregar Alergia");
        JButton eliminarButton = new JButton("Eliminar Alergia");
        listModel = new DefaultListModel<>();
        alergiasList = new JList<>(listModel);

        // Agregar componentes al contenedor
        contentPane = new JPanel(new BorderLayout());
        contentPane.add(textField, BorderLayout.PAGE_START);
        contentPane.add(new JScrollPane(alergiasList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(agregarButton);
        buttonPanel.add(eliminarButton);
        contentPane.add(buttonPanel, BorderLayout.PAGE_END);

        setContentPane(contentPane);

        // Manejar eventos
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alergia = textField.getText().trim();
                if (!alergia.isEmpty()) {
                    listModel.addElement(alergia);
                    textField.setText("");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = alergiasList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AlergiasComponente frame = new AlergiasComponente();
                frame.setVisible(true);
            }
        });
    }
    
    public JPanel getPanel() {
    	return contentPane;
    }
}
