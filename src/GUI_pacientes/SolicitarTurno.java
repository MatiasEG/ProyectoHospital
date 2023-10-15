package GUI_pacientes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Users.Medico;
import Users.Paciente;
import Users.UsersData;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SolicitarTurno extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarTurno frame = new SolicitarTurno(UsersData.getInstance().listaMedicos().get(0), UsersData.getInstance().listaPacientes().get(0));
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
	public SolicitarTurno(Medico m, Paciente p) {
		setTitle("Turnos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String rangoTurnosLunes = m.getHorarios()[0].getRango();
		int turnosDispLunes = m.getHorarios()[0].getTurnosDisponibles();
		JRadioButton rdbtnNewRadioButton_0 = new JRadioButton("0- Lunes entre "+rangoTurnosLunes+"hs. ("+turnosDispLunes+" turnos libres)");
		rdbtnNewRadioButton_0.setBounds(10, 61, 314, 23);
		contentPane.add(rdbtnNewRadioButton_0);
		
		String rangoTurnosMartes = m.getHorarios()[1].getRango();
		int turnosDispMartes = m.getHorarios()[1].getTurnosDisponibles();
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("1- Martes entre "+rangoTurnosMartes+"hs. ("+turnosDispMartes+" turnos libres)");
		rdbtnNewRadioButton_1.setBounds(10, 87, 314, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		String rangoTurnosMiercoles = m.getHorarios()[2].getRango();
		int turnosDispMiercoles = m.getHorarios()[2].getTurnosDisponibles();
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("2- Miercoles entre "+rangoTurnosMiercoles+"hs. ("+turnosDispMiercoles+" turnos libres)");
		rdbtnNewRadioButton_2.setBounds(10, 113, 314, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		String rangoTurnosJueves = m.getHorarios()[3].getRango();
		int turnosDispJueves = m.getHorarios()[3].getTurnosDisponibles();
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("3- Jueves entre "+rangoTurnosJueves+"hs. ("+turnosDispJueves+" turnos libres)");
		rdbtnNewRadioButton_3.setBounds(10, 139, 314, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		String rangoTurnosViernes = m.getHorarios()[4].getRango();
		int turnosDispViernes = m.getHorarios()[4].getTurnosDisponibles();
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("4- Viernes entre "+rangoTurnosViernes+"hs. ("+turnosDispViernes+" turnos libres)");
		rdbtnNewRadioButton_4.setBounds(10, 165, 314, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		String rangoTurnosSabado = m.getHorarios()[5].getRango();
		int turnosDispSabado = m.getHorarios()[5].getTurnosDisponibles();
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("5- Sabado entre "+rangoTurnosSabado+"hs. ("+turnosDispSabado+" turnos libres)");
		rdbtnNewRadioButton_5.setBounds(10, 191, 314, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		String rangoTurnosDomingo = m.getHorarios()[6].getRango();
		int turnosDispDomingo = m.getHorarios()[6].getTurnosDisponibles();
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("6- Domingo entre "+rangoTurnosDomingo+"hs. ("+turnosDispDomingo+" turnos libres)");
		rdbtnNewRadioButton_6.setBounds(10, 217, 314, 23);
		contentPane.add(rdbtnNewRadioButton_6);
		
		JButton btnConfirmar = new JButton("Confirmar turno");
		btnConfirmar.setBounds(10, 247, 314, 23);
		btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String txt = getSelectedButtonText(group);
            	if (txt != null) {
            		int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres confirmar un turno para el dia "+txt+"?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                    	int dia = getDia(txt);
                    	m.getHorarios()[dia].agendarTurno(p);
                    	SolicitarTurno.this.dispose();
                    }
            	}else {
            		JOptionPane.showMessageDialog(null, "Seleccione un dia valido.");
            	}
            }
        });
		contentPane.add(btnConfirmar);
		
		JLabel lblInfo = new JLabel("Seleccione fecha de turno (duracion: "+m.getMinutosDeCita()+" minutos)");
		lblInfo.setBounds(10, 40, 314, 14);
		contentPane.add(lblInfo);
		
		JLabel lblDoctor = new JLabel("Doctor "+m.getNombre()+" "+m.getApellido());
		lblDoctor.setBounds(10, 15, 314, 14);
		contentPane.add(lblDoctor);
		
		group = new ButtonGroup();
        group.add(rdbtnNewRadioButton_0);
        group.add(rdbtnNewRadioButton_1);
        group.add(rdbtnNewRadioButton_2);
        group.add(rdbtnNewRadioButton_3);
        group.add(rdbtnNewRadioButton_4);
        group.add(rdbtnNewRadioButton_5);
        group.add(rdbtnNewRadioButton_6);
	}
	
	private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	private int getDia(String txt) {
		String[] parts = txt.split("-");
		
		return Integer.parseInt(parts[0]);
	}
}
