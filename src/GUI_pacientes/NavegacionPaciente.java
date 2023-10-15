package GUI_pacientes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Users.Paciente;
import Users.UsersData;

@SuppressWarnings("serial")
public class NavegacionPaciente extends JFrame {

	private JPanel contentPane;
	private static JList<String> list_medicos;
	private static JScrollPane scrollPane_medicos;

	/**
	 * Launch the application.
	 */
	//TODO comment this main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NavegacionPaciente frame = new NavegacionPaciente(UsersData.getInstance().listaPacientes().get(0));
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
	public NavegacionPaciente(Paciente p) {
		setTitle("Navegacion (paciente)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 150, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane_medicos = new JScrollPane();
		scrollPane_medicos.setBounds(0, 0, 150, 130);
		panel.add(scrollPane_medicos);
		
		list_medicos = new JList<>(UsersData.getInstance().listaMedicosNombre());
		scrollPane_medicos.setColumnHeaderView(list_medicos);
		
		JButton btn_turnos = new JButton("Ver turnos disponibles");
		btn_turnos.setBounds(0, 133, 150, 23);
		panel.add(btn_turnos);
		
		JLabel lblSolicitarTurnoCon = new JLabel("Solicitar turno con medico");
		lblSolicitarTurnoCon.setBounds(10, 11, 150, 14);
		contentPane.add(lblSolicitarTurnoCon);
		
		JButton btn_EditarDatos = new JButton("Editar datos de cuenta");
		btn_EditarDatos.setBounds(170, 135, 150, 23);
		contentPane.add(btn_EditarDatos);
		
		JButton btn_eliminar = new JButton("Eliminar cuenta");
		btn_eliminar.setBounds(170, 169, 150, 23);
		btn_eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar tu cuenta "+p.getNombre()+"?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
	            	//Elimino el paciente de forma logica, no de la base de datos
	            	NavegacionPaciente.this.dispose();
            	}
            }
        });
		contentPane.add(btn_eliminar);
		
		JButton btn_citas = new JButton("Ver citas pendientes");
		btn_citas.setBounds(170, 101, 150, 23);
		contentPane.add(btn_citas);
	}
}
