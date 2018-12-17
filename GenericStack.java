public class GenericStack{
    private Node top;
    
    //Constructors
    public GenericStack(){
        top=null;
    }
       public static GenericStack createStack(){
       return new GenericStack();
   }
  
    
    public boolean isEmpty(){
        return (top==null);
    }//end isEmpty
    
    
    public void push(Object newItem){
        top = new Node(newItem, top);
    }//end top
    
    public Object pop(){
        if(isEmpty()){
            System.out.println("trying to pop when stack is empty");
            return null;
        }else{
            Node temp = top;
            top = top.next;
            return temp.info;
        }
    }//end Pop

    public void popAll(){
        top=null;
    }

    public Object peek(){
        if(isEmpty()){
            System.out.println("");
        return null;
        }else{
            return top.info;
        }
    }//end peek

}//end class