public class Arvore {

    private Node raiz = null;

    public Node getRaiz(){
        return raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(Node node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(char carac,int value) {
        Node n = new Node(carac,value);
        insert(n);
    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }

    public void remove(int value) {
        Node n = search(value);
        n.remove(value);
    }

}
