public class MyHeap(){
  int heapArray[];
  int size;
  int capacity;

  public MyHeap(){
    this.size=0;
    this.capacity=50;
    //default capacity is 50
    this.heapArray=new int[51];
  }
  public MyHeap(int initCapacity){
    this.size=0;
    this.capacity=initCapacity;
    this.heapArray=new int[initCapacity+1];
  }
//TODO
  public Boolean buildHeap(int[] A){
    //if it fits it sits
    if(A.length>capacity){
      return false;
    }
    else{
      //satisfy shape property
      System.arraycopy(A,0,heapArray,0,A.length);
      for(int i=size/2;i>=1;i--){
        driftDown(i);
      }
      return true;
    }
    //copy array from A to heapArray
  }
  public int getHeapCap(){
    return this.capacity;
  }
  public int getHeapSize(){
    return this.size;
  }
  public Boolean isEmpty(){
    if(size==0){
      return true;
    }
    return false;
  }
  public Boolean isFull(){
    if(size==capacity){
      return true;
    }
    return false;
  }
  public int deleteMin(){
    //delete and return root
    int min=heapArray[1];
    heapArray[1]=heapArray[size];
    size--;
    //drift root down to restore parental dominance
    driftDown(1);
    return min;
  }
  public Boolean insert(int toInsert){
    if(size==capacity){
      return false;
    }
    else{
      heapArray[++size]=toInsert;
      driftUp(size);
      return true;
    }
  }
  public void driftDown(int index){
    int tmp=heapArray[index];
    while(index*2<=size){
      int child=index*2;
      //if there exists another child which is smaller
      if(child!=size && (heapArray[child+1]<heapArray[child])){
        child++;
      }
      //find the smaller child
      // child is smaller than parent
      if(heapArray[child]<tmp){
        heapArray[index]=heapArray[child];//move child up
        index=child;//promise to move parent down
      }
      else{
        break;
      }
    }
    //put parent in it's proper place restoring parental dominance
    heapArray[index]=tmp;
  }
  public int findMin(){
    return heapArray[1];
  }
  public void driftUp(int index){
    int tmp=heapArray[index];
    //swap child with parent if it's smaller than the parent
    while(index>1&& tmp<heapArray[index/2]){
      heapArray[index]=heapArray[index/2];
      index=index/2;
    }
    heapArray[index]=tmp;
  }
  public static int[] heapSortDecreasing()

}
