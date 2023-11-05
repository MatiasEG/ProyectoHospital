package GUI_administradores;

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

import GUI_pacientes.CitasPendientes;
import Users.Paciente;
import Users.UsersData;

public class VisualizadorDeCitasAdmin extends JFrame {

	private JPanel contentPane;
	private JList<String> list_lunes;
	private JList<String> list_martes;
	private JList<String> list_miercoles;
	private JList<String> list_jueves;
	private JList<String> list_viernes;
	private JList<String> list_sabado;
	private JList<String> list_domingo;
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
					VisualizadorDeCitasAdmin frame = new VisualizadorDeCitasAdmin();
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
	public VisualizadorDeCitasAdmin() {
		
		System.out.println(p.getCitas(0));
		System.out.println(p.getCitas(1));
		System.out.println(p.getCitas(2));
		System.out.println(p.getCitas(3));
		System.out.println(p.getCitas(4));
		System.out.println(p.getCitas(5));
		System.out.println(p.getCitas(6));


		setTitle("Citas registradas");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_lunes = new JLabel("Lunes");
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
                    	p.getCitas(0).get(selectedIndex).getHorarios()[0].eliminarTurnoPaciente(p);
                    	p.deleteCita(0, selectedIndex);
                    	list_lunes = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(0)));
    					scrollPane_citasLunes.setViewportView(list_lunes);
                    }
                }
            }
        });
		panel_1.add(btn_eliminarCitaLunes);
		
		scrollPane_citasLunes = new JScrollPane();
		scrollPane_citasLunes.setBounds(0, 0, 150, 130);
		panel_1.add(scrollPane_citasLunes);
		
		list_lunes = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(0)));
		scrollPane_citasLunes.setViewportView(list_lunes);
		
		JLabel lbl_martes = new JLabel("Martes");
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
                    	p.getCitas(1).get(selectedIndex).getHorarios()[1].eliminarTurnoPaciente(p);
    					p.deleteCita(1, selectedIndex);
    					list_martes = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(1)));
    					scrollPane_citasMartes.setViewportView(list_martes);
                    }
                }
            }
        });
		panel_1_1.add(btn_eliminarCitaMartes);
		
		scrollPane_citasMartes = new JScrollPane();
		scrollPane_citasMartes.setBounds(0, 0, 150, 130);
		panel_1_1.add(scrollPane_citasMartes);
		
		list_martes = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(1)));
		scrollPane_citasMartes.setViewportView(list_martes);
		
		JLabel lbl_miercoles = new JLabel("Miercoles");
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
                    	p.getCitas(2).get(selectedIndex).getHorarios()[2].eliminarTurnoPaciente(p);
    					p.deleteCita(2, selectedIndex);
    					list_miercoles = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(2)));
    					scrollPane_citasMiercoles.setViewportView(list_miercoles);
                    }
                }
            }
        });
		panel_1_2.add(btn_eliminarCitaMiercoles);
		
		scrollPane_citasMiercoles = new JScrollPane();
		scrollPane_citasMiercoles.setBounds(0, 0, 150, 130);
		panel_1_2.add(scrollPane_citasMiercoles);
		
		list_miercoles = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(2)));
		scrollPane_citasMiercoles.setViewportView(list_miercoles);
		
		JLabel lbl_jueves = new JLabel("Jueves");
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
                    	p.getCitas(3).get(selectedIndex).getHorarios()[3].eliminarTurnoPaciente(p);
                    	p.deleteCita(3, selectedIndex);
    					list_jueves = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(3)));
    					scrollPane_citasJueves.setViewportView(list_jueves);
                    }
                }
            }
        });
		panel_1_3.add(btn_eliminarCitaJueves);
		
		scrollPane_citasJueves = new JScrollPane();
		scrollPane_citasJueves.setBounds(0, 0, 150, 130);
		panel_1_3.add(scrollPane_citasJueves);
		
		list_jueves = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(3)));
		scrollPane_citasJueves.setViewportView(list_jueves);
		
		JLabel lbl_viernes = new JLabel("Viernes");
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
                    	p.getCitas(4).get(selectedIndex).getHorarios()[4].eliminarTurnoPaciente(p);
                    	p.deleteCita(4, selectedIndex);
    					list_viernes = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(4)));
    					scrollPane_citasViernes.setViewportView(list_viernes);
                    }
                }
            }
        });
		panel_1_4.add(btn_eliminarCitaViernes);
		
		scrollPane_citasViernes = new JScrollPane();
		scrollPane_citasViernes.setBounds(0, 0, 150, 130);
		panel_1_4.add(scrollPane_citasViernes);
		
		list_viernes = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(4)));
		scrollPane_citasViernes.setViewportView(list_viernes);
		
		JLabel lbl_sabado = new JLabel("Sabado");
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
                    	p.getCitas(5).get(selectedIndex).getHorarios()[5].eliminarTurnoPaciente(p);
                    	p.deleteCita(5, selectedIndex);
    					list_sabado = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(5)));
    					scrollPane_citasSabado.setViewportView(list_sabado);
                    }
                }
            }
        });
		panel_1_5.add(btn_eliminarCitaSabado);
		
		scrollPane_citasSabado = new JScrollPane();
		scrollPane_citasSabado.setBounds(0, 0, 150, 130);
		panel_1_5.add(scrollPane_citasSabado);
		
		list_sabado = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(5)));
		scrollPane_citasSabado.setViewportView(list_sabado);
		
		JLabel lbl_domingo = new JLabel("Domingo");
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
                    	p.getCitas(6).get(selectedIndex).getHorarios()[6].eliminarTurnoPaciente(p);
                    	p.deleteCita(6, selectedIndex);
    					list_domingo = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(6)));
    					scrollPane_citasDomingo.setViewportView(list_domingo);
                    }
                }
            }
        });
		panel_1_6.add(btn_eliminarCitaDomingo);
		
		scrollPane_citasDomingo = new JScrollPane();
		scrollPane_citasDomingo.setBounds(0, 0, 150, 130);
		panel_1_6.add(scrollPane_citasDomingo);
		
		list_domingo = new JList<String>(UsersData.getInstance().getNombresMedicos(p.getCitas(6)));
		scrollPane_citasDomingo.setViewportView(list_domingo);
		
	}

}
