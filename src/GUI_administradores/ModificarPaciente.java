package GUI_administradores;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Users.Paciente;
import Users.UsersData;

@SuppressWarnings("serial")
public class ModificarPaciente extends JFrame {

	private JPanel contentPane;
	private JPanel panel_alergias;
	private JTextField campo_nombre;
	private JTextField campo_apellido;
	private JTextField campo_usuario;
	private JTextField campo_correo;
	private JLabel label_alergias;
	private JList<String> lista_alergias;
    private DefaultListModel<String> listModelAlergias;
    private DefaultListModel<String> listModelDiagnosticos;
    private DefaultListModel<String> listModelTratamientos;
    private DefaultListModel<String> listModelMedicamentos;
    private JLabel label_tratamientos;
    private JPanel panel_alergias_1;
    private JList<String> lista_tratamientos;
    private JLabel label_diagnosticos;
    private JPanel panel_alergias_2;
    private JList<String> lista_diagnosticos;
    private JLabel label_medicamentos;
    private JPanel panel_alergias_3;
    private JList<String> lista_medicamentos;

	/**
	 * Launch the application.
	 */
	//TODO comment this main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultListModel<String> alergias = new DefaultListModel<>();
					alergias.addElement("polen");
					DefaultListModel<String> diagnosticos = new DefaultListModel<>();
					diagnosticos.addElement("menso");
					DefaultListModel<String> tratamientos = new DefaultListModel<>();
					tratamientos.addElement("jugar 8hrsxdia");
					DefaultListModel<String> medicamentos = new DefaultListModel<>();
					medicamentos.addElement("asado");
					medicamentos.addElement("coca");
					
					ModificarPaciente frame = new ModificarPaciente(new Paciente("Pepe", "Segundo", "user_aps", "mail@mail.com", "pass", alergias, diagnosticos, tratamientos, medicamentos));
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
	public ModificarPaciente(Paciente paciente) {
		DefaultListModel<String> alergiasAux = UsersData.getInstance().copyList(paciente.getAlergias());
		DefaultListModel<String> diagnosticosAux = UsersData.getInstance().copyList(paciente.getDiagnosticos());
		DefaultListModel<String> tratamientosAux = UsersData.getInstance().copyList(paciente.getTratamientos());
		DefaultListModel<String> medicamentosAux = UsersData.getInstance().copyList(paciente.getMedicamentos());
		
		setTitle("Modificar datos paciente");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campo_nombre = new JTextField();
		campo_nombre.setBounds(23, 39, 187, 20);
		campo_nombre.setText(paciente.getNombre());
		campo_nombre.setEditable(false);
		contentPane.add(campo_nombre);
		campo_nombre.setColumns(10);
		
		campo_apellido = new JTextField();
		campo_apellido.setBounds(220, 39, 187, 20);
		campo_apellido.setText(paciente.getApellido());
		campo_apellido.setEditable(false);
		contentPane.add(campo_apellido);
		campo_apellido.setColumns(10);
		
		JLabel label_nombre = new JLabel("Nombre/s");
		label_nombre.setBounds(23, 26, 187, 14);
		contentPane.add(label_nombre);
		
		JLabel label_apellido = new JLabel("Apellido/s");
		label_apellido.setBounds(220, 26, 187, 14);
		contentPane.add(label_apellido);
		
		JLabel label_usuario = new JLabel("Usuario");
		label_usuario.setBounds(23, 70, 187, 14);
		contentPane.add(label_usuario);
		
		campo_usuario = new JTextField();
		campo_usuario.setColumns(10);
		campo_usuario.setText(paciente.getUsuario());
		campo_usuario.setBounds(23, 83, 187, 20);
		contentPane.add(campo_usuario);
		
		campo_correo = new JTextField();
		campo_correo.setColumns(10);
		campo_correo.setText(paciente.getCorreo());
		campo_correo.setBounds(220, 83, 187, 20);
		contentPane.add(campo_correo);
		
		JLabel label_correo = new JLabel("Correo");
		label_correo.setBounds(220, 70, 187, 14);
		contentPane.add(label_correo);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(318, 408, 89, 23);
		btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ModificarPaciente.this.dispose();
            }
        });
		contentPane.add(btn_cancelar);
		
		JButton btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(220, 408, 89, 23);
		btn_guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(!campo_usuario.getText().equals(paciente.getUsuario()) || !campo_correo.getText().equals(paciente.getCorreo()) ||
            			!alergiasAux.equals(paciente.getAlergias()) || !diagnosticosAux.equals(paciente.getDiagnosticos()) ||
            			!tratamientosAux.equals(paciente.getTratamientos()) || !medicamentosAux.equals(paciente.getMedicamentos())) {

            		if(correoValido(campo_correo.getText())) {
            			paciente.setUsuario(campo_usuario.getText());
        				paciente.setCorreo(campo_correo.getText());
        				paciente.setAlergias(alergiasAux);
        				paciente.setDiagnosticos(diagnosticosAux);
        				paciente.setTratamientos(tratamientosAux);
        				paciente.setMedicamentos(medicamentosAux);
        				JOptionPane.showMessageDialog(null, "Los datos del paciente se han actualizado correctamente.");
        				ModificarPaciente.this.dispose();
            		}else {
            			JOptionPane.showMessageDialog(null, "El correo no es valido.");
            		}
            		
            	}else{
        			JOptionPane.showMessageDialog(null, "No se realizaron cambios para guardar.");
            	}
            }
        });
		contentPane.add(btn_guardar);
		
		panel_alergias = new JPanel();
		panel_alergias.setBounds(23, 127, 187, 123);
		contentPane.add(panel_alergias);
		panel_alergias.setLayout(null);
		
		listModelAlergias = alergiasAux;
		
		JScrollPane scrollPane_alergias = new JScrollPane();
		scrollPane_alergias.setBounds(0, 0, 187, 123);
		panel_alergias.add(scrollPane_alergias);
		lista_alergias = new JList<>(listModelAlergias);
		scrollPane_alergias.setViewportView(lista_alergias);
		
		label_alergias = new JLabel("Alergias");
		label_alergias.setBounds(23, 114, 187, 14);
		contentPane.add(label_alergias);
		
		label_tratamientos = new JLabel("Tratamientos");
		label_tratamientos.setBounds(23, 261, 187, 14);
		contentPane.add(label_tratamientos);
		
		panel_alergias_1 = new JPanel();
		panel_alergias_1.setLayout(null);
		panel_alergias_1.setBounds(23, 274, 187, 123);
		contentPane.add(panel_alergias_1);
		
        listModelTratamientos = tratamientosAux;
		
		JScrollPane scrollPane_tratamientos = new JScrollPane();
		scrollPane_tratamientos.setBounds(0, 0, 187, 123);
		panel_alergias_1.add(scrollPane_tratamientos);
		lista_tratamientos = new JList<>(listModelTratamientos);
		scrollPane_tratamientos.setViewportView(lista_tratamientos);
		
		label_diagnosticos = new JLabel("Diagnosticos");
		label_diagnosticos.setBounds(220, 114, 187, 14);
		contentPane.add(label_diagnosticos);
		
		panel_alergias_2 = new JPanel();
		panel_alergias_2.setLayout(null);
		panel_alergias_2.setBounds(220, 127, 187, 123);
		contentPane.add(panel_alergias_2);
		
        listModelDiagnosticos = diagnosticosAux;
		
		JScrollPane scrollPane_diagnosticos = new JScrollPane();
		scrollPane_diagnosticos.setBounds(0, 0, 187, 123);
		panel_alergias_2.add(scrollPane_diagnosticos);
		lista_diagnosticos = new JList<>(listModelDiagnosticos);
		scrollPane_diagnosticos.setViewportView(lista_diagnosticos);
		
		label_medicamentos = new JLabel("Medicamentos");
		label_medicamentos.setBounds(220, 261, 187, 14);
		contentPane.add(label_medicamentos);
		
		panel_alergias_3 = new JPanel();
		panel_alergias_3.setLayout(null);
		panel_alergias_3.setBounds(220, 274, 187, 123);
		contentPane.add(panel_alergias_3);
		
        listModelMedicamentos = medicamentosAux;
		
		JScrollPane scrollPane_medicamentos = new JScrollPane();
		scrollPane_medicamentos.setBounds(0, 0, 187, 123);
		panel_alergias_3.add(scrollPane_medicamentos);
		lista_medicamentos = new JList<>(listModelMedicamentos);
		scrollPane_medicamentos.setViewportView(lista_medicamentos);
		
		JButton btn_vaciarFicha = new JButton("Vaciar ficha medica");
		btn_vaciarFicha.setBounds(23, 408, 187, 23);
		btn_vaciarFicha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	listModelAlergias.removeAllElements();
            	listModelTratamientos.removeAllElements();
            	listModelDiagnosticos.removeAllElements();
            	listModelMedicamentos.removeAllElements();
            	//lista_alergias = new JList<>(listModelAlergias);
            	//lista_tratamientos = new JList<>(listModelTratamientos);
            	//lista_diagnosticos = new JList<>(listModelDiagnosticos);
                //lista_medicamentos = new JList<>(listModelMedicamentos);
            }
        });
		contentPane.add(btn_vaciarFicha);
		
	}
	
	// Función para validar el formato de un correo electrónico utilizando una expresión regular
    private boolean correoValido(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

}
