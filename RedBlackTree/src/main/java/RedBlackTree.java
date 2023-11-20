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

    public void add(Integer element) {

    }

    /**
     * Adicione um elemento na raíz, caso esta não esteja nula.
     *
     * @param element O elemento a ser adicionado como raíz
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

    /**
 * Adiciona um novo elemento como filho à esquerda do elemento pai fornecido na árvore.
 * 
 * @param element  O elemento a ser adicionado como filho à esquerda.
 * @param elementFather O elemento pai ao qual será adicionado um filho à esquerda.
 * @return true se o elemento foi adicionado com sucesso como filho à esquerda do elemento pai,
 *         false se não foi possível adicionar (por exemplo, se o elemento pai não existe,
 *         já possui um filho à esquerda ou se o elemento pai é nulo).
 */

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

    /**
 * Adiciona um novo elemento como filho à direita do elemento pai fornecido na árvore.
 *
 * @param element      O elemento a ser adicionado como filho à direita.
 * @param elementFather O elemento pai ao qual será adicionado um filho à direita.
 * @return true se o elemento foi adicionado com sucesso como filho à direita do elemento pai,
 *         false se não foi possível adicionar (por exemplo, se o elemento pai não existe,
 *         já possui um filho à direita ou se o elemento pai é nulo).
 */

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
     * @return count
     */
    public int size() {
        return count;
    }
    }
    //Retornar os elementos da árvore em uma lista usando (pelo menos) dois diferentes caminhamentos:
    //positionsPre, positionsCentral, positionsPos e positionsWidth;
    //Gerar uma saída no formato DOT para visualizar a árvore no GraphViz: void GeraDOT().

