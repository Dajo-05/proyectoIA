import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Stack;
public class LabProfundidad extends JFrame implements ActionListener {
    private JButton nuevo, resuelve;
    private JPanel panel;
    private int f, c;
    int[][]lab={{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,00,00,00,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,00,-1},
            {-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,-1,00,-1,-1},
            {-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,-1,00,-1,-1},
            {-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,00,00,00,00,00,00,00,-1},
            {-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,-1,00,-1,-1},
            {-1,00,-1,-1,-1,00,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,00,00,00,00,00,-1},
            {-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,00,-1,00,-1,00,-1,00,-1,00,-1,-1},
            {-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,-1,-1,-1},
            {-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1},
            {-1,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,00,-1,00,-1,-1,00,00,-1,00,-1,-1,00,-1},
            {-1,00,-1,-1,-1,-1,00,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,-1,00,00,00,00,-1},
            {-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,00,-1,-1,-1,-1,-1,00,-1},
            {-1,00,-1,00,00,00,00,-1,-1,00,-1,-1,00,-1,-1,00,00,-1,-1,-1,00,-1,-1,00,00,-1,-1,-1,-1,00,-1},
            {-1,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,00,-1},
            {-1,00,-1,-1,00,00,-1,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,00,00,00,-1,-1},
            {-1,00,00,-1,-1,00,00,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,00,00,00,00,00,00,-1,-1,-1,00,-1,-1},
            {-1,-1,00,-1,00,00,-1,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1},
            {-1,-1,00,00,00,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,00,00,-1},
            {-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,-1,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,-1,00,-1,-1},
            {-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,-1,-1},
            {-1,-1,-1,-1,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,-1},
            {-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,00,00,00,00,-1},
            {-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,00,00,00,-1,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,-1,-1},
            {-1,-1,-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,-1,-1,00,-1,-1,-1},
            {-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,00,00,00,00,-1,-1,-1},
            {-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,-1,-1,00,00,-1,-1},
            {-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,0,00,-1,-1,-1,00,-1,-1},
            {-1,-1,-1,00,-1,-1,-1,-1,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,00,00,00,-1,00,00,-1},
            {-1,00,00,00,-1,-1,-1,-1,-1,00,00,00,00,-1,00,-1,00,-1,-1,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,-1},
            {-1,00,-1,00,-1,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,-1,-1,-1,00,-1,00,-1},
            {-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,00,00,00,00,-1,00,-1},
            {-1,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,-1,-1,-1,00,-1,-1,-1,00,-1},
            {-1,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,00,00,00,00,00,-1,00,00,-1},
            {-1,00,00,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1},
            {-1,-1,00,-1,00,00,-1,00,-1,00,-1,00,-1,00,-1,00,00,00,00,00,00,-1,00,00,00,-1,00,00,00,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
    };
    public static void main(String[] args) {
        LabProfundidad demo = new LabProfundidad();
        demo.setSize(400,450);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(310, 370));
        panel.setBackground(Color.white);
        window.add(panel);

        nuevo = new JButton("Nuevo");
        window.add(nuevo);
        nuevo.addActionListener(this);

        resuelve = new JButton("Resuelve");
        window.add(resuelve);
        resuelve.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Graphics paper = panel.getGraphics();
        if(e.getSource() == nuevo){
            /**
             * Esto limpia la pantalla cada vez que le damos click a nuevo.
             */
            paper.setColor(Color.white);
            paper.fillRect(0, 0, lab[0].length*10, lab.length*10);
            /**
             * Cada vez que le demos a nuevo después de la primera vez algunas celdas de lab[][] serán diferentes a 0 o a -1; esto las regresa a 0 y -1.
             */
            for(int i=0;i<lab.length;i++){
                for(int j=0;j<lab[0].length;j++){
                    if(lab[i][j]==-2 || lab[i][j]==-3){
                        lab[i][j]=-1;
                    }
                    if(lab[i][j]!=00 && lab[i][j] !=-1){
                        lab[i][j]=00;
                    }
                }
            }

            /**
             * Este ciclo crea dos coordenadas aleatorias de una de las orillas dos veces y les asigna un -2.
             */
            for(int i =1;i<=2;i++){
                while(true){
                    f= ThreadLocalRandom.current().nextInt(0,4);
                    c= ThreadLocalRandom.current().nextInt(0,lab[0].length);
                    /**
                     * IF 1: Fila de arriba; columna aleatoria.
                     *
                     * IF 2: Fila aleatoria; columna de la izquierda.
                     *
                     * IF 3: Fila de abajo; columna aleatoria.
                     *
                     * IF 4: Fila aleatoria; columna de la derecha.
                     */
                    if (f==0 && (lab[1][c]==0 && lab[f][c]!=-2)){
                        break;
                    }else if (f==1){
                        f= ThreadLocalRandom.current().nextInt(0,lab.length);
                        c=0;
                        if (lab[f][1]==0 && lab[f][c]!=-2){
                            break;
                        }
                    }else if (f==2){
                        f=lab.length-1;
                        if (lab[f-1][c]==0 && lab[f][c]!=-2){
                            break;
                        }
                    }else if (f==3){
                        f= ThreadLocalRandom.current().nextInt(0,lab.length);
                        c=lab[0].length-1;
                        if (lab[f][c-1]==0 && lab[f][c]!=-2){
                            break;
                        }
                    }
                }
                lab[f][c]=-2;
            }

            /**
             * Esto pinta los -1 de negro, los -2 de rojo (los 0 no porque el fondo ya es blanco).
             */
            for(int i=0;i<lab[0].length;i++){
                for(int j=0;j<lab.length;j++){
                    if(lab[j][i]==-1){
                        paper.setColor(Color.black);
                        paper.fillRect(i*10,j*10,10,10);
                    }else if(lab[j][i]==-2){
                        paper.setColor(Color.red);
                        paper.fillRect(i*10,j*10,10,10);
                    }
                }
            }
        }else if(e.getSource() == resuelve){
            /**
             * Crea un pila de Strings a la que más adelante añadiremos la primera y segunda coordenadas (en un solo elemento) de una celda separadas por una coma.
             */
            Stack<String> pila = new Stack<String>();

            /**
             * Crea un arreglo de Strings a la más adelante añadiremos la primera y segunda coordenadas (cada uno siendo su propio elemento) de una celda.
             */
            String[] dato;
            /**
             * Este ciclo se repite hasta que encontramos un -2 en cuyo caso ocurre un break;
             */
            while(true){

                /**
                 * El primer pila.push y 2 if se encargan de ir marcando las casillas
                 *
                 *Los otros 4 if se encargan de añadir coordenadas de casillas libres como Strings a la pila y de cambiar los 0 de esas casillas
                 *a un número una unidad inferior al actual (si lab[f][c]== -5 entonces le asigna un -6 a la casilla libre adyacente).
                 */

                paper.setColor(Color.pink);

                pila.push(f+","+c);
                if(lab[f][c]!=-2){
                    lab[f][c]=-4;
                    paper.fillRect(c*10,f*10,10,10);
                }
                else{
                    lab[f][c]=-3;
                }
                if (f-1>=0 && lab[f-1][c]==0){
                    f=f-1;
                }
                else if(c-1>=0 && lab[f][c-1]==0){
                    c=c-1;
                }
                else if (lab[f+1][c]==0){
                    f=f+1;
                }
                else if (lab[f][c+1]==0){
                    c=c+1;
                }else if(pila.size()!=0){
                    /**Elimina el elemento añadido por  pila.push(f+","+c); en la línea 190.
                     */
                    pila.pop();
                    //Cambia el color para ver el espacio recorrido
                    paper.setColor(Color.white);
                    paper.fillRect(c*10,f*10,10,10);
                    try{
                        dato = pila.pop().split(",");
                        lab[f][c]=-5;
                        f   = Integer.parseInt(dato[0]);
                        c   = Integer.parseInt(dato[1]);
                    } catch(java.util.EmptyStackException od){
                        System.out.println("Dale a nuevo de nuevo");
                    }
                }
                paper.fillRect(c*10,f*10,10,10);
                /**
                 *Este if busca si alguna casilla alrededor es la final y detiene el ciclo.
                 */
                if (f-1>=0 && lab[f-1][c]==-2 ||
                        c-1>=0 && lab[f][c-1]==-2 ||
                        lab[f+1][c]==-2 || lab[f][c+1]==-2){
                    break;
                }
                /**
                 * Detiene por la cantidad determinada de milisegundos (velocidad)
                 */
                try {
                    Thread.sleep(5);
                } catch(InterruptedException pu) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }


}
