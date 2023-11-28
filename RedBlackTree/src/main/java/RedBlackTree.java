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
 *Procura o elemento oferecido por parâmetro a partir do nó de destino e retorna a referência
 * para o nó no qual o elemento está armazenado na árvore.
 *
 * @param element O elemento a ser procurado na árvore.
 * @param target O nó de partida para a busca.
 * @return Retorna o próprio nó de destino se o elemento fornecido for igual ao
 *         elemento armazenado no nó de destino. Caso contrário, retorna o nó auxiliar,
 *         que percorre o lado esquerdo se o elemento não estiver lá, e percorre o lado
 *         direito se não estiver no lado esquerdo.
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
 * Retorna o elemento pai do elemento fornecido como parâmetro na árvore.
 *
 * @param element O elemento cujo pai está sendo buscado na árvore.
 * @return O elemento que é o pai do elemento passado como parâmetro.
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
     * @param element O elemento a ser alterado na raiz da arvore.
     */
    public void setRoot(Integer element) {
        if (root != null)
            root.element = element;
    }


/**
 * Adiciona um novo elemento
 *
 * @param element o elemento a ser adicionado na árvore.
 */
    public void add(Integer element)
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
     * @return count
     */
    public int size() {
        return count;
    }

     private void GeraDOT(Node node) {
        if (node != null) {
            if (node.left != null) {
                System.out.println(node.element + " -> " + node.left.element);
            }
            if (node.right != null) {
                System.out.println(node.element + " -> " + node.right.element);
            }
            GeraDOT(node.left);
            GeraDOT(node.right);
        }
    }



    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }
    
    }
    //Retornar os elementos da árvore em uma lista usando (pelo menos) dois diferentes caminhamentos:
    //positionsPre, positionsCentral, positionsPos e positionsWidth;
    //Gerar uma saída no formato DOT para visualizar a árvore no GraphViz: void GeraDOT().

