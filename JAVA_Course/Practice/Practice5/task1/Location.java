package Practice.Practice5.task1;

public class Location<T extends Comparable<T>> {
    private int row;
    private int column;
    private T value;
    
    public Location() {
    }
    
    public Location(int row, int column, T value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public void setColumn(int column) {
        this.column = column;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "Location[row="+row+", column="+column+", value="+value+"]";
    }

    public static <E extends Comparable<E>> Location<E> findMax(E[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return null;
        }
        int maxRow = 0;
        int maxCol = 0;
        E maxValue = matrix[0][0];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j].compareTo(maxValue) > 0){
                    maxValue = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        
        return new Location<E>(maxRow, maxCol, maxValue);
    }

    public static <E extends Comparable<E>> Location<E> findMin(E[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return null;
        }
        int minRow = 0;
        int minCol = 0;
        E minValue = matrix[0][0];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j].compareTo(minValue)<0){
                    minValue=matrix[i][j];
                    minRow=i;
                    minCol=j;
                }
            }
        }
        return new Location<E>(minRow,minCol,minValue);
    }

    public boolean isEmpty(){
        return this.value==null;
    }


}
