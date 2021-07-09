package dispersion;
 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.*;

public class InterfazEncadenamiento extends JFrame implements ActionListener {

    int pos;
    String cod;
    boolean flag;
    int i = 0;
    public JButton bobuscar;
    public JButton boeliminar;
    public JTextField field1;
    public JLabel l3;
    Instituto miInstituto = new Instituto();
    String codigo[] = {"100820", "100120", "200110", "204530", "100150","100012", "100213", "100250", "100540", "100420"};
    String nombre[] = {"Juan Rosales", "Ana Ramirez", "Rosa Huapaya", "Carlos Arana", "Raul Gonzales", "Pedro Mamani","Rosario Paredes", "Martha Huaman", "Saul Espino", "Karen Mendiola"};
    float pension[] = {320, 400, 300, 400, 350, 320, 450, 320, 450, 300};

    public InterfazEncadenamiento() {

        setSize(630, 730);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Dispersión(Hashing)");
        p = new JPanel();
        p.setLayout(null);

        l = new JLabel("Por arreglos anidados");
        l.setBounds(240, 30, 230, 20);
        p.add(l);

        l2 = new JLabel(mostrarTabla());
        l2.setBounds(40, 60, 600, 600);
        p.add(l2);

        l3 = new JLabel("Ingrese un codigo(6digitos): ");
        l3.setBounds(10, 80, 180, 20);
        p.add(l3);
        field1 = new JTextField();
        field1.setBounds(170, 80, 150, 20);
        p.add(field1);

        bobuscar = new JButton("Buscar");
        bobuscar.setBounds(270, 570, 100, 20);
        bobuscar.addActionListener(new Buscarx(field1));
        p.add(bobuscar);

        boeliminar = new JButton("Eliminar");
        boeliminar.setBounds(270, 600, 100, 20);
        boeliminar.addActionListener(new Eliminarx(field1));
        p.add(boeliminar);

        b1 = new JButton("Volver");
        b1.setBounds(270, 630, 100, 20);
        b1.addActionListener(this);
        p.add(b1);

        add(p);
        setVisible(true);
    }

    class Buscarx implements ActionListener {

        private JTextField field11;

        public Buscarx(JTextField fi) {
            field11 = fi;
        }

        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            String mensaje = " ";

            String texto = field1.getText();
            cod = texto;
            int arrayAnidado[] = new int[2];
            arrayAnidado = miInstituto.Buscar_ArreglosAnidados(cod);

            if (arrayAnidado[0] != -1) {
                mensaje += "\nCodigo del alumno:"
                        + miInstituto.getCodigoDelAlumno(arrayAnidado[0], arrayAnidado[1]) + "\nNombre del alumno: "
                        + miInstituto.getNombreDelAlumno(arrayAnidado[0], arrayAnidado[1]) + "\nPension:"
                        + miInstituto.getPensionDelAlumno(arrayAnidado[0], arrayAnidado[1]);

            } else {
                mensaje = "\n\nEl codigo de alumno no existe";
            }

            JOptionPane.showMessageDialog(null, mensaje);

        }

    }

    class Eliminarx implements ActionListener {

        private JTextField field11;

        public Eliminarx(JTextField fi) {
            field11 = fi;
        }

        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            String mensaje = " ";
            String texto = field1.getText();
            cod =texto;

            flag = miInstituto.Eliminar_ArregloAnidado(cod);

            if (flag) {
                mensaje = "\n\nAlumno eliminado";

                for (int i = 0; i < miInstituto.getNumeroDeAlumnos(); i++) {
                    for (int j = 0; j < miInstituto.getNumeroDeAlumnos(); j++) {
                        if (miInstituto.getCodigoDelAlumno(i, j).compareTo(mensaje) == 0) { //cambio   
                             //ejemplo//alumnos[pos].siguiente.getCodigoDelAlumno().compareTo(codigo) == 0
                            //miInstituto.getCodigoDelAlumno(i, j) != ""

                            mensaje += "\t\nCodigo:" + miInstituto.getCodigoDelAlumno(i, j) + "    \tNombre:" + miInstituto.getNombreDelAlumno(i, j) + "     \tPension" + miInstituto.getPensionDelAlumno(i, j);

                        }
                    }
                }
                System.out.println("0\t\t\t\t0,00");
            } else {
                mensaje = "\n\nEl codigo de alumno no existe";
            }

            JOptionPane.showMessageDialog(null, mensaje);

        }

    }

    public String mostrarTabla() {

        boolean flag;
        for (int i = 0; i < codigo.length; i++) {
            flag = miInstituto.Insertar_ArreglosAnidados(codigo[i], nombre[i], pension[i]);

            if (flag == false) {
                System.out.println("Tabla llena");
            }
        }

        for (int i = 0; i < miInstituto.getNumeroDeAlumnos(); i++) {
            for (int j = 0; j < miInstituto.getNumeroDeAlumnos(); j++) {
                if (miInstituto.getCodigoDelAlumno(i, j) != "0") { //cambio
                    cadena += "<table>";

                    cadena += "<tr style=\"border: hidden\">";

                    cadena += "<td width=\"200\"  rowspan=\"60\"> Código : ";
                    cadena += String.valueOf(miInstituto.getCodigoDelAlumno(i, j));
                    cadena += "</td>";

                    cadena += "<td width=\"200\"  rowspan=\"60\"> Nombre : ";
                    cadena += String.valueOf(miInstituto.getNombreDelAlumno(i, j));
                    cadena += " </td> ";

                    cadena += "<td width=\"200\"  rowspan=\"60\"> Pensión : ";
                    cadena += String.valueOf(miInstituto.getPensionDelAlumno(i, j));
                    cadena += " </td> ";
                    cadena += "</table>";
                    cadena += "</br>";
                }

            }
        }
        return cadena;

    }

    private JLabel l, l2;
    private JPanel p;
    private JButton b1;
    private String cadena = "<html><body>";

    @Override
    public void actionPerformed(ActionEvent vo) {
        this.dispose();
        if (vo.getSource() == b1) {//podemos comparar por el nombre del objeto del boton
            this.setVisible(false);
            Inicio ip = new Inicio();
            ip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cambiamos el tamaño de la ventana
        }

    }

}
