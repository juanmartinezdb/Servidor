public class Main {
    public static void main(String[] args) {

        Matriz<Integer> numMatriz = new Matriz<>(4,2);
        int contador= 0;
        for(int i=0; i<numMatriz.filas(); i++){
            for(int j=0; j<numMatriz.columnas(); j++){
                numMatriz.set(j,i,++contador);
            }
        }
        System.out.println(numMatriz.toString());
        System.out.println(numMatriz);
        System.out.println(numMatriz.get(0,1));
    }
}