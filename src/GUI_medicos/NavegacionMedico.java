package GUI_medicos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Users.UsersData;

@SuppressWarnings("serial")
public class NavegacionMedico extends JFrame {

	private JPanel contentPane;
	private static JList<String> list_pacientes;
	private static JScrollPane scrollPane_pacientes;

	/**
	 * Launch the application.
	 */
	//TODO comment this main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NavegacionMedico frame = new NavegacionMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NavegacionMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 190, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setBounds(14, 15, 150, 14);
		contentPane.add(lblPacientes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 40, 150, 157);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_editarFicha = new JButton("Editar Ficha");
		btn_editarFicha.setBounds(0, 134, 150, 23);
		btn_editarFicha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_pacientes.getSelectedIndex();
                if (selectedIndex != -1) {
                	try {
    					ModificarFichaPaciente frame = new ModificarFichaPaciente(UsersData.getInstance().listaPacientes().get(selectedIndex));
    					frame.setVisible(true);
    				} catch (Exception e1) {
    					e1.printStackTrace();
    				}
                }
            }
        });
		panel_1.add(btn_editarFicha);
		
		scrollPane_pacientes = new JScrollPane();
		scrollPane_pacientes.setBounds(0, 0, 150, 130);
		panel_1.add(scrollPane_pacientes);
		
		list_pacientes = new JList<>(UsersData.getInstance().listaPacientesNombre());
		scrollPane_pacientes.setViewportView(list_pacientes);
	}

}
