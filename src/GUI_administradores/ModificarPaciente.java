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

public class ModificarPaciente extends JFrame {

	private JPanel contentPane;
	private JPanel panel_alergias;
	private JTextField campo_nombre;
	private JTextField campo_apellido;
	private JTextField campo_usuario;
	private JTextField campo_correo;
	private JTextField campo_alergia;
	private JLabel label_alergias;
	private JList lista_alergias;
    private DefaultListModel<String> listModelAlergias;
    private DefaultListModel<String> listModelDiagnosticos;
    private DefaultListModel<String> listModelTratamientos;
    private DefaultListModel<String> listModelMedicamentos;
    private JButton btn_agregarAlergia;
    private JButton btn_eliminarAlergia;
    private JLabel label_tratamientos;
    private JPanel panel_alergias_1;
    private JTextField campo_Tratamiento;
    private JList lista_tratamientos;
    private JButton btn_agregarTratamiento;
    private JButton btn_eliminarTratamiento;
    private JLabel label_diagnosticos;
    private JPanel panel_alergias_2;
    private JTextField campo_diagnostico;
    private JList lista_diagnosticos;
    private JButton btn_agregarDiagnostico;
    private JButton btn_eliminarDiagnostico;
    private JLabel label_medicamentos;
    private JPanel panel_alergias_3;
    private JTextField campo_medicamento;
    private JList lista_medicamentos;
    private JButton btn_agregarMedicamento;
    private JButton btn_eliminarMedicamento;

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
		DefaultListModel<String> alergiasAux = Main.copyList(paciente.getAlergias());
		DefaultListModel<String> diagnosticosAux = Main.copyList(paciente.getDiagnosticos());
		DefaultListModel<String> tratamientosAux = Main.copyList(paciente.getTratamientos());
		DefaultListModel<String> medicamentosAux = Main.copyList(paciente.getMedicamentos());
		
		setTitle("Registro Paciente");
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
		
		campo_alergia = new JTextField();
		campo_alergia.setBounds(0, 0, 187, 20);
		panel_alergias.add(campo_alergia);
		campo_alergia.setColumns(10);
		
		listModelAlergias = alergiasAux;
		
		btn_agregarAlergia = new JButton("Agregar");
		btn_agregarAlergia.setBounds(0, 100, 89, 23);
		btn_agregarAlergia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alergia = campo_alergia.getText().trim();
                if (!alergia.isEmpty()) {
                	listModelAlergias.addElement(alergia);
                    campo_alergia.setText("");
                }
            }
        });
		panel_alergias.add(btn_agregarAlergia);
		
		btn_eliminarAlergia = new JButton("Eliminar");
		btn_eliminarAlergia.setBounds(98, 100, 89, 23);
		btn_eliminarAlergia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = lista_alergias.getSelectedIndex();
                if (selectedIndex != -1) {
                	listModelAlergias.remove(selectedIndex);
                }
            }
        });
		panel_alergias.add(btn_eliminarAlergia);
		
		JScrollPane scrollPane_alergias = new JScrollPane();
		scrollPane_alergias.setBounds(0, 22, 187, 78);
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
		
		campo_Tratamiento = new JTextField();
		campo_Tratamiento.setColumns(10);
		campo_Tratamiento.setBounds(0, 0, 187, 20);
		panel_alergias_1.add(campo_Tratamiento);
		
        listModelTratamientos = tratamientosAux;
		
		btn_agregarTratamiento = new JButton("Agregar");
		btn_agregarTratamiento.setBounds(0, 100, 89, 23);
		btn_agregarTratamiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alergia = campo_Tratamiento.getText().trim();
                if (!alergia.isEmpty()) {
                	listModelTratamientos.addElement(alergia);
                    campo_Tratamiento.setText("");
                }
            }
        });
		panel_alergias_1.add(btn_agregarTratamiento);
		
		btn_eliminarTratamiento = new JButton("Eliminar");
		btn_eliminarTratamiento.setBounds(98, 100, 89, 23);
		btn_eliminarTratamiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = lista_tratamientos.getSelectedIndex();
                if (selectedIndex != -1) {
                	listModelTratamientos.remove(selectedIndex);
                }
            }
        });
		panel_alergias_1.add(btn_eliminarTratamiento);
		
		JScrollPane scrollPane_tratamientos = new JScrollPane();
		scrollPane_tratamientos.setBounds(0, 21, 187, 78);
		panel_alergias_1.add(scrollPane_tratamientos);
		lista_tratamientos = new JList<>(paciente.getTratamientos());
		scrollPane_tratamientos.setViewportView(lista_tratamientos);
		
		label_diagnosticos = new JLabel("Diagnosticos");
		label_diagnosticos.setBounds(220, 114, 187, 14);
		contentPane.add(label_diagnosticos);
		
		panel_alergias_2 = new JPanel();
		panel_alergias_2.setLayout(null);
		panel_alergias_2.setBounds(220, 127, 187, 123);
		contentPane.add(panel_alergias_2);
		
		campo_diagnostico = new JTextField();
		campo_diagnostico.setColumns(10);
		campo_diagnostico.setBounds(0, 0, 187, 20);
		panel_alergias_2.add(campo_diagnostico);
		
        listModelDiagnosticos = diagnosticosAux;
		
		btn_agregarDiagnostico = new JButton("Agregar");
		btn_agregarDiagnostico.setBounds(0, 100, 89, 23);
		btn_agregarDiagnostico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alergia = campo_diagnostico.getText().trim();
                if (!alergia.isEmpty()) {
                	listModelDiagnosticos.addElement(alergia);
                	campo_diagnostico.setText("");
                }
            }
        });
		panel_alergias_2.add(btn_agregarDiagnostico);
		
		btn_eliminarDiagnostico = new JButton("Eliminar");
		btn_eliminarDiagnostico.setBounds(98, 100, 89, 23);
		btn_eliminarDiagnostico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = lista_diagnosticos.getSelectedIndex();
                if (selectedIndex != -1) {
                	listModelDiagnosticos.remove(selectedIndex);
                }
            }
        });
		panel_alergias_2.add(btn_eliminarDiagnostico);
		
		JScrollPane scrollPane_diagnosticos = new JScrollPane();
		scrollPane_diagnosticos.setBounds(0, 21, 187, 78);
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
		
		campo_medicamento = new JTextField();
		campo_medicamento.setColumns(10);
		campo_medicamento.setBounds(0, 0, 187, 20);
		panel_alergias_3.add(campo_medicamento);
		
        listModelMedicamentos = medicamentosAux;
		
		btn_agregarMedicamento = new JButton("Agregar");
		btn_agregarMedicamento.setBounds(0, 100, 89, 23);
		btn_agregarMedicamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alergia = campo_medicamento.getText().trim();
                if (!alergia.isEmpty()) {
                	listModelMedicamentos.addElement(alergia);
                    campo_medicamento.setText("");
                }
            }
        });
		panel_alergias_3.add(btn_agregarMedicamento);
		
		btn_eliminarMedicamento = new JButton("Eliminar");
		btn_eliminarMedicamento.setBounds(98, 100, 89, 23);
		btn_eliminarMedicamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = lista_medicamentos.getSelectedIndex();
                if (selectedIndex != -1) {
                	listModelMedicamentos.remove(selectedIndex);
                }
            }
        });
		panel_alergias_3.add(btn_eliminarMedicamento);
		
		JScrollPane scrollPane_medicamentos = new JScrollPane();
		scrollPane_medicamentos.setBounds(0, 21, 187, 78);
		panel_alergias_3.add(scrollPane_medicamentos);
		lista_medicamentos = new JList<>(listModelMedicamentos);
		scrollPane_medicamentos.setViewportView(lista_medicamentos);
		
		
		
	}
	
	// Función para validar el formato de un correo electrónico utilizando una expresión regular
    private boolean correoValido(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

}
