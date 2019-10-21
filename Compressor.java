import javax.swing.*;
import java.io.*;
import java.util.*;

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
        int intchar=0;
        char carac;
        while ( (intchar = buffRead.read())!=10) {
            if(intchar == -1){
                System.out.println("====IF=====");
                break;
            }
            carac=(char) intchar;
            //linha=carac+"\n";
            //System.out.println("====HWILE=====");
            //dic.put(carac,0);
            if (dic.containsKey(carac)){
                int valor= (int) dic.get(carac);
                dic.put(carac,valor+1);
            }else {
                dic.put(carac,1);
            }

        }
        buffRead.close();
        System.out.println("====DIC=====");
        FileWriter writer = new FileWriter("saida3.txt");

        
        Heap heap = new Heap();

        TreeMap sorted = new TreeMap(dic);
        sorted.putAll(dic);



        //heap.orderAscHeap(heap.getNodes());
        //Node root=null;
        //for (int i=0;i<dic.size();++i){
        for (Object key : sorted.keySet()) {
            /*if (root==null){
                root= new Node(((char)key),(int)dic.get(key));
            }
            else {
                root.insert(new Node(((char)key),(int)dic.get(key)));
            }*/
            //arvore.insert(new Node(((char)key),(int)dic.get(key)));
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
        if(heap.getSize()!=0){
            writer.write("==============HEAP=============\n");
            System.out.println("==============HEAP=============");
            Node[] tabela= heap.getNodes();
            for (int i=0;i<heap.getSize();++i){
                System.out.println(tabela[i].getCarac()+ " = " + tabela[i].getValue());
                writer.write(tabela[i].getCarac()+ " = " + tabela[i].getValue()+'\n');
            }
            writer.close();
            JFrame frame = new JFrame("Visualizador de ABB");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400,300);
            frame.setVisible(true);

            //JLabel label = new JLabel("dsfshfhsd");
            // label.setVisible(true);
            //frame.add(label);

            //frame.add(view);

            /*for (int i=0;i<heap.getSize();i++){
                int soma = heap.getNodes()[0].getValue()+heap.getNodes()[1].getValue();
                System.out.println("SIZE HEAP: "+heap.getSize());
                if(arvore.isEmpty()){
                    arvore.insert(new Node(-1,soma));
                    arvore.getRaiz().insert(heap.getNodes()[0]);
                    System.out.println("FIRST: "+heap.getNodes()[0].getCarac()+" - " +heap.getNodes()[0].getValue() );
                    arvore.getRaiz().insert(heap.getNodes()[1]);
                    System.out.println("SECOND: "+heap.getNodes()[1].getCarac()+" - " +heap.getNodes()[1].getValue());
                }else if (heap.getSize()>3){
                    Node raiz=arvore.getRaiz();
                    arvore.setRaiz(new Node(-1,soma));
                    arvore.getRaiz().insert(raiz);
                    System.out.println("FIRST: "+heap.getNodes()[0].getCarac()+" - " +heap.getNodes()[0].getValue() );
                    arvore.getRaiz().insert(heap.getNodes()[1]);
                    System.out.println("SECOND: "+heap.getNodes()[1].getCarac()+" - " +heap.getNodes()[1].getValue() );
                }else{
                    Node raiz=arvore.getRaiz(); //5
                    Node irmao=new Node(-1,soma);
                    irmao.insert(heap.getNodes()[0]);
                    irmao.insert(heap.getNodes()[1]);
                    arvore.setRaiz(new Node(-1,raiz.getValue()+irmao.getValue()));
                    arvore.getRaiz().insert(raiz);
                    arvore.getRaiz().insert(irmao);
                }
                System.out.println(i);
                heap.remove();


                tabela=heap.getNodes();
                for (int j=0;j<heap.getSize();++j){
                    System.out.println(tabela[j].getCarac()+ " = " + tabela[j].getValue());
                    //writer.write(tabela[j].getCarac()+ " = " + tabela[j].getValue()+'\n');
                }
                heap.remove();
                tabela=heap.getNodes();
                for (int j=0;j<heap.getSize();++j){
                    System.out.println(tabela[j].getCarac()+ " = " + tabela[j].getValue());
                    //writer.write(tabela[j].getCarac()+ " = " + tabela[j].getValue()+'\n');
                }
                heap.insert(new Node(-1,soma));
                tabela=heap.getNodes();
                for (int j=0;j<heap.getSize();++j){
                    System.out.println(tabela[j].getCarac()+ " = " + tabela[j].getValue());
                    //writer.write(tabela[j].getCarac()+ " = " + tabela[j].getValue()+'\n');
                }
                frame.add(view);

            }*/
            while(heap.getSize()>1){
                int soma = heap.getNodes()[0].getValue()+heap.getNodes()[1].getValue();
                Node novo = new Node(-1,soma);
                Node left =  heap.getNodes()[0];
                Node right =  heap.getNodes()[1];
                novo.insert(left);
                novo.insert(right);

                heap.remove();
                System.out.println("===========");
                tabela=heap.getNodes();
                    for (int j=0;j<heap.getSize();++j){
                        System.out.println(tabela[j].getCarac()+ " = " + tabela[j].getValue());
                        //writer.write(tabela[j].getCarac()+ " = " + tabela[j].getValue()+'\n');
                    }
                    heap.remove();
                    System.out.println("===========");
                    tabela=heap.getNodes();
                    for (int j=0;j<heap.getSize();++j){
                        System.out.println(tabela[j].getCarac()+ " = " + tabela[j].getValue());
                        //writer.write(tabela[j].getCarac()+ " = " + tabela[j].getValue()+'\n');
                    }
                    heap.insert(novo);
                    System.out.println("===========");
                    tabela=heap.getNodes();
                    for (int j=0;j<heap.getSize();++j){
                        System.out.println(tabela[j].getCarac()+ " = " + tabela[j].getValue());
                        //writer.write(tabela[j].getCarac()+ " = " + tabela[j].getValue()+'\n');
                    }

            }
            Arvore arvore = new Arvore();
            arvore.insert(heap.getNodes()[0]);
            ArvoreBinariaView view = new ArvoreBinariaView(arvore);
            frame.add(view);
        }

            BitSet bits = new BitSet();
            bits.set(0);
            System.out.println(bits.get(1));
        
//            System.out.println(arvore.getRaiz().getRight().getBits().get(1));


        //}
    }
}
