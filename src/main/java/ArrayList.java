public class ArrayList {
    private int[] arr;
    private int last;
    private int size;
   
    public ArrayList(int capacidadeInicial) {
        this.arr = new int[capacidadeInicial];
        this.last = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.last == -1;
    }

    private void swap(int i, int j) {
        int aux = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = aux;
    }

    private void shiftRight() {
        for (int i = last; i > 0; i--) {
            swap(i, i-1);
        }
    }

    private void shiftLeft() {
        for (int i = 0; i < last; i++) {
            swap(i, i+1);
        }
    }

    public void addFirst(int valor) {
        if (last + 1 == arr.length) resize((arr.length+1) * 2);
        last++;
        shiftRight();
        arr[0] = valor;
        size++;
    }

    public void addLast(int valor) {
        // TODO
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        //TODO
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
       int[] aux = new int[novaCapacidade];

       for (int i = 0; i < arr.length; i++) {
            aux[i] = arr[i];
       }

       this.arr = aux;

    //    arr = new int[novaCapacidade];

    //    for (int i = 0; i < aux.length; i++) {
    //         arr[i] = aux[i];
    //    }
    }

    public void assegureCapacidade(int capacidadePretendida) {
       // TODO
    }

    public int getFirst() {
        // TODO
        return -1;
    }

    public int getLast() {
        //TODO
        return -1;
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        // TODO
        return -1;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        shiftLeft();
        size--;
        return arr[last--];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        //TODO
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        // TODO
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        // TODO
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        // TODO
        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        return "";
    }
    
    public int size() {
        return this.size;
    }
}
