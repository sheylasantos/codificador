import javax.swing.*;
import java.io.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

public class Compressor {

    public static void main(String[] args) throws IOException {


        String command = args[0];
        String file = args[1];




        if (command.equals("compress")){

            System.out.println(file);
            try {
                leitor(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("TERMINEI");


        }else if (command.equals("extract")){


        }else {
            System.out.println("COMANDO INVÁLIDO!");
        }



    }

    public static void leitor(String path) throws IOException {
        HashMap dic = new HashMap();
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        //String linha = "";
        int intchar;
        char carac;
        buffRead.read();
        buffRead.read();
        while ( (intchar = buffRead.read())!=-1) {

            carac=(char) intchar;
            //linha=carac+"\n";

            //dic.put(carac,0);
            if (dic.containsKey(carac)){
                int valor= (int) dic.get(carac);
                dic.put(carac,valor+1);
            }else {
                dic.put(carac,1);
            }

        }
        buffRead.close();
        FileWriter writer = new FileWriter("saida3.txt");

        Arvore arvore = new Arvore();
        Heap heap = new Heap();
        Node root=null;
        //for (int i=0;i<dic.size();++i){
        for (Object key : dic.keySet()) {
            /*if (root==null){
                root= new Node(((char)key),(int)dic.get(key));
            }
            else {
                root.insert(new Node(((char)key),(int)dic.get(key)));
            }*/
            arvore.insert(new Node(((char)key),(int)dic.get(key)));
            heap.insert(new Node(((char)key),(int)dic.get(key)));

            //Capturamos o valor a partir da chave

            System.out.println(key + " = " + dic.get(key));
            //System.out.println(car[0]);
            writer.write(key + " = " + dic.get(key)+'\n');
        }

            //arvore.remove((int)arvore.getRaiz().getCarac());


        //Sorter s = new Sorter();
        //s.heapSort((heap));
        //heap.heapSort();
        //heap.orderAscHeap(heap.getNodes());
        writer.write("==============HEAP=============\n");
        Node[] tabela= heap.getNodes();
        for (int i=0;i<heap.getSize();++i){
            //System.out.println(tabela[i].getCarac()+ " = " + tabela[i].getValue());
            writer.write(tabela[i].getCarac()+ " = " + tabela[i].getValue()+'\n');
        }
        writer.close();

        for (int i=0;i<heap.getSize();i++){
            int soma = heap.getNodes()[i].getValue()+heap.getNodes()[i+1].getValue();
            arvore.insert(new Node(-1,soma));
            arvore.getRaiz().insert(heap.getNodes()[i]);
            arvore.getRaiz().insert(heap.getNodes()[i+1]);
            heap.remove();
            heap.remove();
            heap.insert(new Node(-1,soma));
            i++;
        }

        JFrame frame = new JFrame("Visualizador de ABB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);

        //JLabel label = new JLabel("dsfshfhsd");
        // label.setVisible(true);
        //frame.add(label);
        ArvoreBinariaView view = new ArvoreBinariaView(arvore);
        frame.add(view);

        //}
    }
}
