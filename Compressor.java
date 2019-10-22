import javax.swing.*;
import java.io.*;
import java.util.*;

public class Compressor {
    private static int R = 256;
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
        int count=1;

        while ( (intchar = buffRead.read())!=-1) {

            if(intchar == 10){
                //intchar=32;
                //continue;
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
        FileWriter writer = new FileWriter("saida1.txt");

        
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
            writer.write(key + ";" + dic.get(key)+'\n');
        }

            //arvore.remove((int)arvore.getRaiz().getCarac());


        //Sorter s = new Sorter();
        //s.heapSort((heap));
        //heap.heapSort();
        //heap.orderAscHeap(heap.getNodes());
        if(heap.getSize()!=0){
            writer.write("=\n");
            System.out.println("==============HEAP=============");
            Node[] tabela= heap.getNodes();
            for (int i=0;i<heap.getSize();++i){
                System.out.println(tabela[i].getCarac()+ " = " + tabela[i].getValue());
                writer.write(tabela[i].getCarac()+ ";" + tabela[i].getValue()+'\n');
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


                Node left =  heap.getNodes()[0];
                heap.remove();
                Node right =  heap.getNodes()[0];
                heap.remove();

                int soma = left.getValue()+right.getValue();
                Node novo = new Node(-1,soma);
                novo.insert(left);
                novo.insert(right);


                System.out.println("===========");
                tabela=heap.getNodes();
                    for (int j=0;j<heap.getSize();++j){
                        System.out.println(tabela[j].getCarac()+ " = " + tabela[j].getValue());
                        //writer.write(tabela[j].getCarac()+ " = " + tabela[j].getValue()+'\n');
                    }
                    System.out.println("===========");
                    heap.insert(novo);
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
            String[] st = new String[R];
            buildCode(st,arvore.getRaiz() , "");

            writeTrie(arvore.getRaiz());
        }

            BitSet bits = new BitSet();
            bits.set(0);
            System.out.println(bits.get(1));



//            System.out.println(arvore.getRaiz().getRight().getBits().get(1));
            /*
            public static void expand() {
               Node root = readTrie();        // discutido abaixo
               int N = BinaryStdIn.readInt(); // comprimento da string original

               for (int i = 0; i < N; i++) {  // decodifica próximo caractere
                  Node x = root;
                  while (!x.isLeaf())
                     if (BinaryStdIn.readBoolean())
                          x = x.right;
                     else x = x.left;
                  BinaryStdOut.write(x.ch);
               }
               BinaryStdOut.close();

           }
           private static Node buildTrie(int[] freq) {
               MinPQ<Node> pq = new MinPQ<Node>();
               for (char c = 0; c < R; c++)
                  if (freq[c] > 0)
                     pq.insert(new Node(c, freq[c], null, null));

               while (pq.size() > 1) {
                  Node x = pq.delMin();
                  Node y = pq.delMin();
                  Node parent = new Node('\0', x.freq + y.freq, x, y);
                  pq.insert(parent);
               }
               return pq.delMin();
            }



            String s = BinaryStdIn.readString();
           char[] input = s.toCharArray();

           int[] freq = new int[R];
           for (int i = 0; i < input.length; i++)
              freq[input[i]]++;

           Node root = buildTrie(freq);

           String[] st = new String[R];
           buildCode(st, root, "");

           writeTrie(root);  // discutido abaixo

           BinaryStdOut.write(input.length);

           for (int i = 0; i < input.length; i++) {
              String code = st[input[i]];
              for (int j = 0; j < code.length(); j++)
              if (code.charAt(j) == '1')
                   BinaryStdOut.write(true);
              else BinaryStdOut.write(false);
           }
           BinaryStdOut.close();
             */

        //}
    }

    private static String[] buildCode(Node root) {
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (x.isLeaf()) {
            st[x.getCarac()] = s;
            return;
        }
        buildCode(st, x.getLeft(), s + '0');
        buildCode(st, x.getRight(), s + '1');
    }
    private static void writeTrie(Node x) throws IOException {
        FileWriter writer = new FileWriter("saida.txt");

        if (x.isLeaf()) {
            writer.append((char)x.countChar);
            System.out.println((char)x.countChar);
            writer.append(x.getCarac());
            System.out.println(x.getCarac());
            writer.close();
            return;
        }
        writer.append((char)x.countChar);
        System.out.println((char)x.countChar);
        writer.close();
        writeTrie(x.getLeft());
        writeTrie(x.getRight());

    }
    /*private static Node readTrie() {
        if (buff.readBoolean()) {
            char c = BinaryStdIn.readChar();
            return new Node(c, 0, null, null);
        }
        return new Node('\0', 0, readTrie(), readTrie());
    }*/
}
