public class RedBlackTree {

    /**
     * Representação de um nó na lista.
     */
    private class Node {
        public Node father;
        public Integer element;
        public String color;
        public Node left;
        public Node right;
        public Node(Integer element) {
            this.father = null;
            this.element = element;
            left = null;
            right = null;
            color = null;
        }
    }

    /**
     Atributos da classe
     */
    private Node root;
    private int count;
    private int blackHeight;

    public RedBlackTree() {
        root = null;
        count = 0;
        blackHeight = 0;
    }

    /**
     *
     * Metodo privado que procura por elemento a partir de target
     * e retorna a referencia para o nodo no qual element está
     * armazenado.
     * @param element
     * @param target
     * @return target caso o elemento dado no parameto for o mesmo do target,
     * retorna aux caso contrário, que percorre o lado esquerdo e se não estiver lá, percorre o direito.
     */
    private Node searchNodeRef(Integer element, Node target) {
        if (element != null) {
            if (target.element.equals(element))
                return target;
            Node aux = searchNodeRef(element, target.left);
            if (aux == null)
                aux = searchNodeRef(element, target.right);
            return aux;
        }
        return null;
    }

    /**
     * Retorna quem é o elemento pai do elemento passado por parametro.
     * @param element
     * @return o elemento do pai do elemento passado.
     */
    public Integer getParent(Integer element) {
        Node n = this.searchNodeRef(element, root);
        if (n == null) {
            return null;
        } else if (n.father==null) {
            return null;
        }else {
            return n.father.element;
        }
    }

    /**
     * Altera o elemento da raiz da arvore.
     *
     * @param element a ser colocado na raiz da arvore.
     */
    public void setRoot(Integer element) {
        if (root != null)
            root.element = element;
    }

    public void add(Integer element) {

    }

    /**
     * Adicione um elemento na raíz, caso esta não esteja nula.
     *
     * @param element
     * @return true se for possível inserir.
     */
    public boolean addRoot(Integer element) {
        if (root != null) {
            return false;
        }
        root = new Node(element);
        count++;
        return true;
    }

    public boolean addLeft(Integer element, Integer elementFather) {
        Node aux = searchNodeRef(elementFather, root);
        if (aux == null)
            return false;
        if (aux.father == null && aux != root)
            return false;
        if (aux.left != null)
            return false;
        Node n = new Node(element);
        aux.left = n;
        n.father = aux;
        count++;
        return true;
    }

    public boolean addRight(Integer element, Integer elementFather) {
        Node aux = searchNodeRef(elementFather, root);
        if (aux == null)
            return false;
        if (aux.father == null && aux != root)
            return false;
        if (aux.right != null)
            return false;
        Node n = new Node(element);
        aux.right = n;
        n.father = aux;
        count++;
        return true;
    }
    public int height() {
        return 0;
    }

    /**
     * Verifica se a árvore esta vazia ou não.
     *
     * @return true se a árvore vazia e false caso contrario.
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Retorna o total de elementos da árvore.
     *
     * @return total de elementos
     */
    public int size() {
        return count;
    }
    }
    //Retornar os elementos da árvore em uma lista usando (pelo menos) dois diferentes caminhamentos:
    //positionsPre, positionsCentral, positionsPos e positionsWidth;
    //Gerar uma saída no formato DOT para visualizar a árvore no GraphViz: void GeraDOT().

