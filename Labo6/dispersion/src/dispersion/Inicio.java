package dispersion;
 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JFrame implements ActionListener{
    public Inicio() {
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Dispersión(Hashing)");
        p = new JPanel();
        p.setLayout(null);
        
      

        b1 = new JButton("Reasignación por prueba cuadratica");
        b1.setBounds(150, 100, 280, 20);
        b1.addActionListener(this);
        p.add(b1);

        b2 = new JButton("Reasignación por doble dirección");
        b2.setBounds(150, 150, 280, 20);
        b2.addActionListener(this);
        p.add(b2);

        b3 = new JButton("Por arreglos anidados");
        b3.setBounds(150, 200, 280, 20);
        b3.addActionListener(this);
        p.add(b3);

        b4 = new JButton("Por encadenamiento");
        b4.setBounds(150, 250, 280, 20);
        b4.addActionListener(this);
        p.add(b4);

        add(p);
        setVisible(true);
    }

    private JLabel l, l2;
    private JPanel p;
    private JButton b1, b2, b3, b4;
    private String codigo; ///cmbio
    private String cadena = "<html><body>";

    @Override

    public void actionPerformed(ActionEvent vo) {
         this.setVisible(false);
      
        if (vo.getSource() == b1) {
            this.setVisible(false);
            InterfazCuadratica v1 = new InterfazCuadratica();
            v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (vo.getSource() == b2) {
            this.setVisible(false);
            InterfazDobleDirec v2 = new InterfazDobleDirec();
            v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (vo.getSource() == b3) {
            this.setVisible(false);
            InterfazArreglosAnid v3 = new InterfazArreglosAnid();
            v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        if (vo.getSource() == b4) {
            this.setVisible(false);
            InterfazEncadenamiento v4 = new InterfazEncadenamiento();
            v4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }
}
