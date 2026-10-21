public class ArrayList {
    private int[] listaArray;
    private int last;
    private int size;
   
    public ArrayList(int capacidadeInicial) {
        this.listaArray = new int[capacidadeInicial];
        this.last = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.last == -1;
    }

    private void swap(int i, int j) {
        int aux = this.listaArray[i];
        this.listaArray[i] = this.listaArray[j];
        this.listaArray[j] = aux;
    }

    private void shiftRight(int fim) {
        for (int i = last; i > fim; i--) {
            swap(i, i-1);
        }
    }

    private void shiftLeft(int inicio) {
        for (int i = inicio; i < last; i++) {
            swap(i, i+1);
        }
    }

    public void addFirst(int valor) {
        if (last + 1 == listaArray.length) resize((listaArray.length+1) * 2);
        last++;
        shiftRight(0);
        listaArray[0] = valor;
        size++;
    }

    public void addLast(int valor) {
        if (last + 1 == listaArray.length) resize((listaArray.length+1) * 2);
        listaArray[++last] = valor;
        size++;
    }

    // adiciona um valor no índice passado como parâmetro
    // OBSERVAÇÃO: o add vai colocar um valor numa posição válida que o usuário deve saber
    // previamente que existe. Porém, se essa nova adição fizer o array "estourar" de posições,
    // então é dever da lista se reajustar (resize) para que contenha o novo valor.
    public void add(int index, int valor) {
        if (index < 0 || index > listaArray.length) throw new IndexOutOfBoundsException("Índice inválido!");
        if (last + 1 == listaArray.length) resize((listaArray.length+1)*2);
        last++;
        shiftRight(index);
        listaArray[index] = valor;
        size++;
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
       int[] aux = new int[novaCapacidade];

       for (int i = 0; i < listaArray.length; i++) {
            aux[i] = listaArray[i];
       }

       this.listaArray = aux;
    }

    public void assegureCapacidade(int capacidadePretendida) {
       if (capacidadePretendida > listaArray.length) resize(capacidadePretendida);
    }

    public int getFirst() {
        if (isEmpty()) throw new RuntimeException("Lista vazia!");
        return listaArray[0];
    }

    public int getLast() {
       if (isEmpty()) throw new RuntimeException("Lista vazia!");
       return listaArray[last];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if (index < 0 || index > last) throw new IndexOutOfBoundsException("Índice inválido!");
        return listaArray[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("Lista vazia!");
        shiftLeft(0);
        size--;
        return listaArray[last--];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        if (isEmpty()) throw new RuntimeException("Lista vazia!");
        size--;
        last--;
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        if (index < 0 || index > listaArray.length-1) throw new RuntimeException("Índice inválido!");
        shiftLeft(index);
        size--;
        last--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        int firstIndex = indexOf(value);
        if (firstIndex > -1) remove(firstIndex);
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        for (int i = 0; i <= last; i++) {
            if (listaArray[i] == value) {
                return i;
            }
        }
        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        for (int i = last; i >= 0; i--) {
            if (listaArray[i] == valor) {
                return i;
            }
        }
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        String out = "";
        
        if (!isEmpty()) {
            out += listaArray[0];

            for (int i = 1; i <= last; i++) {
                out += ", "+listaArray[i];
            }
        }

        return out;
    }
    
    public int size() {
        return this.size;
    }
}
