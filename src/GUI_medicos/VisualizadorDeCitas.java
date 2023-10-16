package GUI_medicos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Users.Medico;
import Users.UsersData;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class VisualizadorDeCitas extends JFrame {

	private JPanel contentPane;
	private JList<String> list_lunes;
	private JList<String> list_martes;
	private JList<String> list_miercoles;
	private JList<String> list_jueves;
	private JList<String> list_viernes;
	private JList<String> list_sabado;
	private JList<String> list_domingo;
	private JLabel lbl_turnosLunes;
	private JLabel lbl_turnosMartes;
	private JLabel lbl_turnosMiercoles;
	private JLabel lbl_turnosJueves;
	private JLabel lbl_turnosViernes;
	private JLabel lbl_turnosSabado;
	private JLabel lbl_turnosDomingo;
	private JScrollPane scrollPane_citasLunes;
	private JScrollPane scrollPane_citasMartes;
	private JScrollPane scrollPane_citasMiercoles;
	private JScrollPane scrollPane_citasJueves;
	private JScrollPane scrollPane_citasViernes;
	private JScrollPane scrollPane_citasSabado;
	private JScrollPane scrollPane_citasDomingo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizadorDeCitas frame = new VisualizadorDeCitas(UsersData.getInstance().listaMedicos().get(0));
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
	public VisualizadorDeCitas(Medico m) {
		setTitle("Citas registradas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_lunes = new JLabel("Lunes de "+m.getHorarios()[0].getRango());
		lbl_lunes.setBounds(10, 11, 150, 14);
		contentPane.add(lbl_lunes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 36, 150, 157);
		contentPane.add(panel_1);
		
		JButton btn_eliminarCitaLunes = new JButton("Eliminar cita lunes");
		btn_eliminarCitaLunes.setBounds(0, 134, 150, 23);
		btn_eliminarCitaLunes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_lunes.getSelectedIndex();
                if (selectedIndex != -1) {
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar la cita del lunes seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
    					m.getHorarios()[0].eliminarTurno(selectedIndex);
    					list_lunes = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[0].getTurnosAgendados()));
    					scrollPane_citasLunes.setViewportView(list_lunes);
    					lbl_turnosLunes.setText("Turnos disp. lunes: "+m.getHorarios()[0].getTurnosDisponibles());
                    }
                }
            }
        });
		panel_1.add(btn_eliminarCitaLunes);
		
		scrollPane_citasLunes = new JScrollPane();
		scrollPane_citasLunes.setBounds(0, 0, 150, 130);
		panel_1.add(scrollPane_citasLunes);
		
		list_lunes = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[0].getTurnosAgendados()));
		scrollPane_citasLunes.setViewportView(list_lunes);
		
		JLabel lbl_martes = new JLabel("Martes de "+m.getHorarios()[1].getRango());
		lbl_martes.setBounds(170, 11, 150, 14);
		contentPane.add(lbl_martes);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(170, 36, 150, 157);
		contentPane.add(panel_1_1);
		
		JButton btn_eliminarCitaMartes = new JButton("Eliminar cita martes");
		btn_eliminarCitaMartes.setBounds(0, 134, 150, 23);
		btn_eliminarCitaMartes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_martes.getSelectedIndex();
                if (selectedIndex != -1) {
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar la cita del martes seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
    					m.getHorarios()[1].eliminarTurno(selectedIndex);
    					list_martes = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[1].getTurnosAgendados()));
    					scrollPane_citasMartes.setViewportView(list_martes);
    					lbl_turnosMartes.setText("Turnos disp. martes: "+m.getHorarios()[1].getTurnosDisponibles());
                    }
                }
            }
        });
		panel_1_1.add(btn_eliminarCitaMartes);
		
		scrollPane_citasMartes = new JScrollPane();
		scrollPane_citasMartes.setBounds(0, 0, 150, 130);
		panel_1_1.add(scrollPane_citasMartes);
		
		list_martes = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[1].getTurnosAgendados()));
		scrollPane_citasMartes.setViewportView(list_martes);
		
		JLabel lbl_miercoles = new JLabel("Miercoles de "+m.getHorarios()[2].getRango());
		lbl_miercoles.setBounds(330, 11, 150, 14);
		contentPane.add(lbl_miercoles);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(330, 36, 150, 157);
		contentPane.add(panel_1_2);
		
		JButton btn_eliminarCitaMiercoles = new JButton("Eliminar cita miercoles");
		btn_eliminarCitaMiercoles.setBounds(0, 134, 150, 23);
		btn_eliminarCitaMiercoles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_miercoles.getSelectedIndex();
                if (selectedIndex != -1) {
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar la cita del miercoles seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
    					m.getHorarios()[2].eliminarTurno(selectedIndex);
    					list_miercoles = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[2].getTurnosAgendados()));
    					scrollPane_citasMiercoles.setViewportView(list_miercoles);
    					lbl_turnosMiercoles.setText("Turnos disp. miercoles: "+m.getHorarios()[2].getTurnosDisponibles());
                    }
                }
            }
        });
		panel_1_2.add(btn_eliminarCitaMiercoles);
		
		scrollPane_citasMiercoles = new JScrollPane();
		scrollPane_citasMiercoles.setBounds(0, 0, 150, 130);
		panel_1_2.add(scrollPane_citasMiercoles);
		
		list_miercoles = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[2].getTurnosAgendados()));
		scrollPane_citasMiercoles.setViewportView(list_miercoles);
		
		JLabel lbl_jueves = new JLabel("Jueves de "+m.getHorarios()[3].getRango());
		lbl_jueves.setBounds(490, 11, 150, 14);
		contentPane.add(lbl_jueves);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(490, 36, 150, 157);
		contentPane.add(panel_1_3);
		
		JButton btn_eliminarCitaJueves = new JButton("Eliminar cita jueves");
		btn_eliminarCitaJueves.setBounds(0, 134, 150, 23);
		btn_eliminarCitaJueves.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_jueves.getSelectedIndex();
                if (selectedIndex != -1) {
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar la cita del jueves seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
    					m.getHorarios()[3].eliminarTurno(selectedIndex);
    					list_jueves = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[3].getTurnosAgendados()));
    					scrollPane_citasJueves.setViewportView(list_jueves);
    					lbl_turnosJueves.setText("Turnos disp. jueves: "+m.getHorarios()[3].getTurnosDisponibles());
                    }
                }
            }
        });
		panel_1_3.add(btn_eliminarCitaJueves);
		
		scrollPane_citasJueves = new JScrollPane();
		scrollPane_citasJueves.setBounds(0, 0, 150, 130);
		panel_1_3.add(scrollPane_citasJueves);
		
		list_jueves = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[3].getTurnosAgendados()));
		scrollPane_citasJueves.setViewportView(list_jueves);
		
		JLabel lbl_viernes = new JLabel("Viernes de "+m.getHorarios()[4].getRango());
		lbl_viernes.setBounds(650, 11, 150, 14);
		contentPane.add(lbl_viernes);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(650, 36, 150, 157);
		contentPane.add(panel_1_4);
		
		JButton btn_eliminarCitaViernes = new JButton("Eliminar cita viernes");
		btn_eliminarCitaViernes.setBounds(0, 134, 150, 23);
		btn_eliminarCitaViernes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_viernes.getSelectedIndex();
                if (selectedIndex != -1) {
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar la cita del viernes seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
    					m.getHorarios()[4].eliminarTurno(selectedIndex);
    					list_viernes = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[4].getTurnosAgendados()));
    					scrollPane_citasViernes.setViewportView(list_viernes);
    					lbl_turnosViernes.setText("Turnos disp. viernes: "+m.getHorarios()[4].getTurnosDisponibles());
                    }
                }
            }
        });
		panel_1_4.add(btn_eliminarCitaViernes);
		
		scrollPane_citasViernes = new JScrollPane();
		scrollPane_citasViernes.setBounds(0, 0, 150, 130);
		panel_1_4.add(scrollPane_citasViernes);
		
		list_viernes = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[4].getTurnosAgendados()));
		scrollPane_citasViernes.setViewportView(list_viernes);
		
		JLabel lbl_sabado = new JLabel("Sabado de "+m.getHorarios()[5].getRango());
		lbl_sabado.setBounds(810, 11, 150, 14);
		contentPane.add(lbl_sabado);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBounds(810, 36, 150, 157);
		contentPane.add(panel_1_5);
		
		JButton btn_eliminarCitaSabado = new JButton("Eliminar cita sabado");
		btn_eliminarCitaSabado.setBounds(0, 134, 150, 23);
		btn_eliminarCitaSabado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_sabado.getSelectedIndex();
                if (selectedIndex != -1) {
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar la cita del sabado seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
    					m.getHorarios()[5].eliminarTurno(selectedIndex);
    					list_sabado = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[5].getTurnosAgendados()));
    					scrollPane_citasSabado.setViewportView(list_sabado);
    					lbl_turnosSabado.setText("Turnos disp. sabado: "+m.getHorarios()[5].getTurnosDisponibles());
                    }
                }
            }
        });
		panel_1_5.add(btn_eliminarCitaSabado);
		
		scrollPane_citasSabado = new JScrollPane();
		scrollPane_citasSabado.setBounds(0, 0, 150, 130);
		panel_1_5.add(scrollPane_citasSabado);
		
		list_sabado = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[5].getTurnosAgendados()));
		scrollPane_citasSabado.setViewportView(list_sabado);
		
		JLabel lbl_domingo = new JLabel("Domingo de "+m.getHorarios()[6].getRango());
		lbl_domingo.setBounds(970, 11, 150, 14);
		contentPane.add(lbl_domingo);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setLayout(null);
		panel_1_6.setBounds(970, 36, 150, 157);
		contentPane.add(panel_1_6);
		
		JButton btn_eliminarCitaDomingo = new JButton("Eliminar cita domingo");
		btn_eliminarCitaDomingo.setBounds(0, 134, 150, 23);
		btn_eliminarCitaDomingo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list_domingo.getSelectedIndex();
                if (selectedIndex != -1) {
                	int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar la cita del domingo seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
    					m.getHorarios()[6].eliminarTurno(selectedIndex);
    					list_domingo = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[6].getTurnosAgendados()));
    					scrollPane_citasDomingo.setViewportView(list_domingo);
    					lbl_turnosDomingo.setText("Turnos disp. domingo: "+m.getHorarios()[6].getTurnosDisponibles());
                    }
                }
            }
        });
		panel_1_6.add(btn_eliminarCitaDomingo);
		
		scrollPane_citasDomingo = new JScrollPane();
		scrollPane_citasDomingo.setBounds(0, 0, 150, 130);
		panel_1_6.add(scrollPane_citasDomingo);
		
		list_domingo = new JList<String>(UsersData.getInstance().getNombresPacientes(m.getHorarios()[6].getTurnosAgendados()));
		scrollPane_citasDomingo.setViewportView(list_domingo);
		
		
		lbl_turnosLunes = new JLabel("Turnos disp. lunes: "+m.getHorarios()[0].getTurnosDisponibles());
		lbl_turnosLunes.setBounds(10, 204, 150, 14);
		contentPane.add(lbl_turnosLunes);
		
		lbl_turnosMartes = new JLabel("Turnos disp. martes: "+m.getHorarios()[1].getTurnosDisponibles());
		lbl_turnosMartes.setBounds(170, 204, 150, 14);
		contentPane.add(lbl_turnosMartes);
		
		lbl_turnosMiercoles = new JLabel("Turnos disp. miercoles: "+m.getHorarios()[2].getTurnosDisponibles());
		lbl_turnosMiercoles.setBounds(330, 204, 150, 14);
		contentPane.add(lbl_turnosMiercoles);
		
		lbl_turnosJueves = new JLabel("Turnos disp. jueves: "+m.getHorarios()[3].getTurnosDisponibles());
		lbl_turnosJueves.setBounds(490, 204, 150, 14);
		contentPane.add(lbl_turnosJueves);
		
		lbl_turnosViernes = new JLabel("Turnos disp. viernes: "+m.getHorarios()[4].getTurnosDisponibles());
		lbl_turnosViernes.setBounds(650, 204, 150, 14);
		contentPane.add(lbl_turnosViernes);
		
		lbl_turnosSabado = new JLabel("Turnos disp. sabado: "+m.getHorarios()[5].getTurnosDisponibles());
		lbl_turnosSabado.setBounds(810, 204, 150, 14);
		contentPane.add(lbl_turnosSabado);
		
		lbl_turnosDomingo = new JLabel("Turnos disp. domingo: "+m.getHorarios()[6].getTurnosDisponibles());
		lbl_turnosDomingo.setBounds(970, 204, 150, 14);
		contentPane.add(lbl_turnosDomingo);
	}
}
