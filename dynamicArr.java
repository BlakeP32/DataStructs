

public class dynamicArr <Type> implements Iterable <Type>{
    
    private Type [] arr;
    private int length = 0;
    private int capacity = 0;
    
    //instantiates at 8 capacity if no capacity is given
    public dynamicArr(){
        this(8);
    }
    
    public dynamicArr(int cap){
        if(cap < 0){
            throw new IllegalArgumentException("Size of array cant be less than 0");
        }
        this.capacity = cap;
        this.arr = (Type[]) new Object[capacity];
    }
    
    //increases capacity integer
    private void addCapacity(){
        if(capacity == 0){
            capacity+=1;
            return;
        }
        capacity*=2;
    }
    
    //insertAt
    public void insertAt(int index, Type item){
        if (((length - 1) >= capacity) || capacity == 0){
            addCapacity();
        }
        if(index > length || index < 0){
            throw new IllegalArgumentException("index out of bounds");
        }
        Type [] newArr = (Type[]) new Object[capacity];
        for(int i = 0,int j = 0; i < length; i++,j++){
            if(i == index){
                newArr[j] = item;
                j++;
            }
            newArr[j] = arr[i];
        }
        length++;
        arr = newArr;
    }
    
    //append
    public void append(Type item){
        boolean increase = false;
        if (((length - 1) >= capacity) || capacity == 0){
            addCapacity();
            Type [] newArr = (Type[]) new Object[capacity];
            for(int i = 0; i < length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        arr[length] = item;
        length++;
    }
    
    //deleteAtElement
    public void deleteAt(int index){
        if(index <= 0 || index > length){
            throw new IllegalArgumentException("index out of bounds");
        }
        if((capacity/2) > (length-2)){
            capacity/=2;
        }
        Type [] newArr = (Type[]) new Object[capacity];
        for(int i = 0,int j = 0; i < length; i++,j++){
            if(i == index){
                j--;
            }
            else{
                newArr[j] = arr[i];
            }
        }
        length--;
        arr = newArr;
        
    }
    
    
    //deleteItem returns item deleted or returns null first item that is the same as the argument
    public Type deleteItem(Type item){
        for(int i = 0; i < length; i++){
            if(arr[i] == item){
                deleteAt(i);
                return item;
            }
        }
        return null;
    }
    
    
    //make the array a print *maybe change this to a printable string? could maybe be useful
    public String print(){
        System.out.print("[");
        for(int i = 0; i < length; i++){
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println("[");
    }
    
    
    
    //indexof
    public int indexOf(Type item){
        for(int i = 0; i < length; i++){
            if(arr[i] == item){
                return i;
            }
        }
        return -1;
    }
    
    
    //contains
    public boolean contains(Type item){
        for(int i = 0; i < length; i++){
            if(arr[i] == item){
                return true;
            }
        }
        return false;
    }
    
    
    //clear
    public void clear(){
        capacity = 0;
        length = 0;
        arr = (Type[]) new Object[capacity];
    }
    
    
    //size
    public int size(){
        return length;
    }
    
    //isEmpty
    public boolean isEmpty(){
        return length == 0;
    }
    
}