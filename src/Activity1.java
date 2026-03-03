public class Activity1 extends IntegerManager implements PrintPretty{
    public static void main(String[] args) throws Exception {
        Activity1 thingy = new Activity1();
        thingy.buildList();
        thingy.printPretty();
        thingy.shuffle();
        thingy.printPretty();
    }

    @Override
    void buildList() {
        nums = new int[20];
        for (int i = 0; i < nums.length; i++){
            nums[i] = (int)(Math.random () *101); //Math.random(61)+10;
        }
    }
    public void printPretty(){
        System.out.println("\n ====== ARRAY ====== (size : " + nums.length + ")");
        for(int num : nums){
            System.out.print (num + " ");
        }

    }

    @Override
    void shuffle() {
        for ( int i = 0; i < nums.length; i ++){
            int r = (int)(Math.random()*nums.length);

            int temp = nums[i];
            nums[i] = nums[r];
            nums[r] = temp;


        }
    }

    @Override
    void insertionSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertionSort'");
    }

    @Override
    void selectionSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectionSort'");
    }

    @Override
    void mergeSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mergeSort'");
    }

    @Override
    int pickRandom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickRandom'");
    }
}
