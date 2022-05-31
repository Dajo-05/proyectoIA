import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerDatos extends JFrame implements ActionListener {
    private JPanel panel;
     private int fila, col;
    static int[][] matriz;
    private JButton nuevo, resuelve;


    public static void main(String[] args) {


        try {
            // caraga el archivo
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DAVIS\\Documents\\Universidad\\2022-1\\inteligencia Artificial\\proyectoIA\\src\\mundo.txt"));
            String temp = "";
            ArrayList<String> lines = new ArrayList<>();
            while ((temp = br.readLine()) != null) {
                lines.add(temp); // lee las n lineas del archivp
            }
            String[] numeros = lines.get(0).split(" ");
            int numLinea = numeros.length; // se obtiene la cantidad de numeros por lineas
            int cantLinea = lines.size(); // obtenesmos la cantodad de lineas
            matriz = new int[numLinea][cantLinea];

            // se lee la matriz linea por linea
            for (int i = 0; i < numLinea; i++) {
                String[] lin = lines.get(i).split(" ");
                for (int j = 0; j < numLinea; j++) {
                    matriz[i][j] = Integer.parseInt(lin[j]);
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.print("\n");
            }
        }  catch (Exception e) {
            System.out.println("");
        }
        LeerDatos ventana = new LeerDatos();
        ventana.setSize(400, 450);
        ventana.crearPantalla();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics paper = panel.getGraphics();

        if (e.getSource() == nuevo) {

            /**
             *
             */
            paper.setColor(Color.white);
            paper.fillRect(0, 0, matriz[0].length*10-20, matriz.length*10-20);
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[i][j] == 0) {
                        paper.setColor(Color.GRAY);
                        paper.fillRect(i*30,j*30,30,30);
                    } else if (matriz[i][j] ==  2) {
                        paper.setColor(Color.BLUE);
                        paper.fillRect(i*30,j*30,30,30);
                    } else if (matriz[i][j] ==  3) {
                        paper.setColor(Color.MAGENTA);
                        paper.fillRect(i*30,j*30,30,30);
                    } else if (matriz[i][j] ==  4) {
                        paper.setColor(Color.green);
                        paper.fillRect(i*30,j*30,30,30);
                    } else if (matriz[i][j] ==  5) {
                        paper.setColor(Color.yellow);
                        paper.fillRect(i*30,j*30,30,30);
                    } else if (matriz[i][j] ==  6) {
                        paper.setColor(Color.red);
                        paper.fillRect(i*30,j*30,30,30);
                    }else if (matriz[i][j] ==  1) {
                        paper.setColor(Color.BLACK);
                        paper.fillRect(i*30,j*30,30,30);
                    }

                }

            }
        } else if (e.getSource() == resuelve) {

        }

    }
    public void crearPantalla(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container window = getContentPane();
        window.setLayout( new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize( new Dimension(310,370));
        panel.setBackground(Color.WHITE);
        window.add(panel);

        nuevo = new JButton("Nuevo");
        window.add(nuevo);
        nuevo.addActionListener(this);

    }
}
