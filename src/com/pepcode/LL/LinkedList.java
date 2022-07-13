package com.pepcode.LL;

public  class  LinkedList {
    public static void main(String[] args) {
        LinkedList ll= new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addFirst(40);
        ll.removeLastNode();
        ll.getNodeAt(2);
        System.out.println( ll.getNodeAt(1));

    }
    private class Node{
        private int data=0;
        private Node next;

        public Node(int data){
            this.data=data;

        }
    }
    //property of LinkedList Node
    private Node head=null;
    private Node tail=null;
    private int numofNode=0;
    //Method of LinkedList
    public int size(){
        return this.numofNode;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    protected void handlezeroSize(Node node){
      this.head=node;
      this.tail=node;
    }
    //add first element when only data is given to you
    protected void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);

    }
    protected void addFirstNode(Node node){
     if(size()==0){
            handlezeroSize(node) ;
     }else{
       node.next=this.head;//this.head has some address initially where it was pointing earlier so now i will put in new node
       this.head=node; //head ab new node ko point karega
     }
     this.numofNode++;
    }
    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);

    }

    protected void addLastNode(Node node) {
      if(size()==0){
          handlezeroSize(node);
      }else{
          this.tail.next=node;
          this.tail=node;

      }
    }
    protected void addAt(int idx, int data) throws Exception{
      if (idx <0 || idx>this.size()){
          throw new Exception("invalid index");
      }
      Node newNode= new Node(data);
        addNodeAt(idx,newNode);

      }

    private void addNodeAt(int idx,Node newNode) {
        if(idx == 0)
            addFirstNode(newNode);
       else if(idx==size())
               addLastNode(newNode);
       else {
            Node nodeAt = getNodeAt(idx - 1);
            Node forw = nodeAt.next;

            nodeAt.next = newNode;
            newNode.next = forw;
            this.numofNode++;
        }
    }



    public int removeFirst() throws Exception{
        if(size()==0){
            throw new Exception("LinkedList is Empty");
        }
        Node node= removeFirstNode();
      return node.data;
    }

    protected Node removeFirstNode() {
        Node temp=head;
        if(size()==1){
            handleSize1();
        }else{
           this.head=this.head.next;
        }
       temp.next=null;
       this. numofNode--;
       return temp;
    }

    private void handleSize1() {
        this.head=null;
        this.tail=null;
    }
    protected Node getNodeAt(int idx){
        Node temp = this.head;
        while(idx-->0) {       //idx =size-1   -- will work as after idx>0 then idx--
            temp = temp.next;
        }
        return temp;
    }
    protected Node removeLastNode(){

        Node temp=this.tail;
        if(size()==1){
            handleSize1();
        }else {
            Node secondLastNode = getNodeAt(size() - 2);
            secondLastNode.next=null;
            this.tail=secondLastNode;
        }
        return temp;
    }
    protected void removeAt(int idx)throws Exception{
       if(size()==0){
           throw new Exception("Size is Empty");
       }else if(idx <0 ||idx>size()){
           throw new Exception("invalid index");
       }
       Node removingode=removeNodeAt(idx);

      }

    private Node removeNodeAt(int idx) {
        if(idx==0){
          return removeFirstNode();
        }else if (idx== size()-1){
          return  removeLastNode();
        }else {
            Node prevNode= getNodeAt(idx-1);
            Node removeNode= prevNode.next;
            Node forwardNode=removeNode.next;

            prevNode.next=forwardNode;
            removeNode.next=null;
            this.numofNode--;
            return removeNode;
        }

    }
  public int  getFirst() throws Exception{

        if(size()==0)
            throw new Exception("LinkedList is Empty");

        return this.head.data;

    }
    public int  getLast() throws Exception{

        if(size()==0)
            throw new Exception("LinkedList is Empty");

        return this.tail.data;

    }
    public int  getAt(int idx) throws Exception{

        if(size()==0)
            throw new Exception("LinkedList is Empty");
        else if (idx < 0 || idx >= size())
            throw new Exception("Invalid Index");
        else{
            return getNodeAt(idx).data;

        }

    }

}
