import java.util.*;

public class first{
    public static void countSubArray(int arr[], int k){
        int prefixarray = 0;
        int count = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0, 1);
        for(int i=0;i<arr.length;i++){
            prefixarray+=arr[i];
            int removal = prefixarray - k;
            if(hash.containsKey(removal)){
                count += hash.get(removal);

            }
            if(hash.containsKey(prefixarray)){
                hash.replace(prefixarray, hash.get(prefixarray)+1);
            }else{
                hash.put(prefixarray, 1);
            }
           


        }
        System.out.println(count);
    }
    public static void countNumber(int nums[], int k ){
        for(int i=0 ;i<nums.length ;i++){
            int rem = nums[i] % 2;
            if(rem == 0){
                nums[i] = 0;
            }else{
                nums[i] = 1;
            }
        }
        HashMap<Integer,Integer> hash = new HashMap<>();
        int prefixarray = 0;
        int count = 0;
        hash.put(0,1);
        for(int i=0 ;i<nums.length;i++){
            prefixarray+=nums[i];
            int rem = prefixarray - k;
            if(hash.containsKey(rem)){
                count+=hash.get(rem);
            }
            if(hash.containsKey(prefixarray)){
                hash.replace(prefixarray, hash.get(prefixarray)+1);
            }else{
                hash.put(prefixarray, 1);
            }
        }
        System.out.println(count);
    }
    public static void longestContinu(int nums[], int limit){
        ArrayDeque<Integer> inc = new ArrayDeque<>();
        ArrayDeque<Integer> dec = new ArrayDeque<>();
        int left = 0;
        int res = 0;
        for(int right = 0;right<nums.length;right++){
            while(!inc.isEmpty() && inc.getLast() > nums[right]){
                inc.removeLast();
            }
            while(!dec.isEmpty() && dec.getLast()<nums[right]){
                dec.removeLast();
            }
            inc.addLast(nums[right]);
            dec.addLast(nums[right]);
            while(dec.getFirst() - inc.getFirst() > limit){
                if(dec.getFirst() == nums[left]){
                    dec.removeFirst();
                }
                if(inc.getFirst() == nums[left]){
                    inc.removeFirst();
                }
                left++;
            }
            
            res = Math.max(res,right-left+1);
        }
        System.out.print(res);
    }
    public static void countFlips(int nums[], int k){
        int n = nums.length;
        int flipcount = 0;
        int flips = 0;
        boolean array[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(i>=k && array[i-k] == true){
                flipcount--;
            }
            if(flipcount%2==nums[i]){
                if((i+k) > n ){
                    return;
                }
                flips++;
                flipcount++;
                array[i] = true;
            }
        }
        System.out.println(flips);
    }
    public static int centreNode(int edges[][]){
        return edges[0][0] == edges[1][0]  ? edges[0][0] : edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
    public static void deepcopyList(List<List<Integer>> result,int ancestor, int child){
        
        for(int num : result.get(ancestor)){
            if(!result.get(child).contains(num)){
                result.get(child).add(num);
            }
        }
        Collections.sort(result.get(child));
    } 
    public static void ancestorNode(int edgeNode[][], int n){
        List<List<Integer>> result = new ArrayList<List<Integer>>(n);
        for(int i=0;i<n;i++){
            result.add(Arrays.asList());
        }
        for(int array[] : edgeNode){
            int child = array[1];
            int ancestor = array[0];
            if(result.get(child).size() == 0){
                result.set(child,new ArrayList<Integer>(Arrays.asList(ancestor)));
            }else{

                result.get(child).add(ancestor);

            }
            if(result.get(ancestor).size() != 0){
                deepcopyList(result, ancestor, child);
            }

        }
        System.out.print(result.toString());
    }
    public static void threeConsecutive(int arr[]){
        int count = 0;
        int index = 0;
        while(count != 3 && index != arr.length ){
            int num = arr[index];
            int result = num & 1;
            System.out.println(result);
            if(result == 1){
                count++;
            }else{
                count = 0;
            }
            index++;
        }
        System.err.println(count);

    }
    public static void intersection(int num1[] , int num2[]){
        int arr[] = new int[1001];
        for(int i=0;i<num1.length;i++){
            arr[num1[i]]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<num2.length;i++){
            if(arr[num2[i]] > 0){
                list.add(num2[i]);
                arr[num2[i]]--;
            }
        }
        int result[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        System.out.println(list.toString());
    }
    public static void moveThreeNum(int nums[]){
        Arrays.sort(nums);
        int l = nums.length;
        int min = nums[l-1] - nums[0];
        for(int i=0;i<=3;i++){
            min = Math.min(min,nums[l - (4-i)] - nums[i]);
        }
        System.out.println(min);
    }
    public static void spendtime(int n, int time){
        boolean dir = true;
        int person = n - 1;
        while(time > person){
            time = time - person;
            dir = !dir;
        }
        if(dir){
            System.out.println(time + 1);
            return;
        }else{
            System.out.println(n - time);
            return;
        }
    }
    public static void exchangeBottle(int numBottles, int numExchange){
        if(numBottles < numExchange){
            System.out.println(numBottles);
            return;
        }
        int result = numBottles;
        int emptybott = 0;
        while(numBottles!=1 && numBottles >= numExchange){
            emptybott = 0;
            if(numBottles%numExchange == 0){
                result += numBottles/numExchange;
            }else{
                emptybott = numBottles % numExchange;
                result += (numBottles-emptybott) / numExchange;
            }
            numBottles = ((numBottles-emptybott)/numExchange) + emptybott;
        }
        System.out.println(result);
    }
    public static int solve(int n, int k){
        if(n == 1){
            
            return 0;
        }
        return (solve(n-1, k) + k)%n ;
    }
    public static void circularGame(int n, int k){
        int ans = solve(n, k) + 1;
        System.out.println(ans);
    }
    
    public static void averageWaitingTime(int[][] customers ){
        int totalTime = 0;
        double averagetime = 0;
        int length = customers.length;
        for(int i=0;i<length;i++){
            if(customers[i].length < 2){
                length--;
                continue;
            };
            int arrivalTime =   customers[i][0];
            int waitingTime = customers[i][1];
            if(arrivalTime > totalTime){
                totalTime = arrivalTime + waitingTime;
            }else{
                totalTime +=waitingTime;
            }
            averagetime += totalTime - arrivalTime;

        }
        double result = averagetime / length;
        System.out.println(result);
    }
    public static void folder(String logs[] ){
        int folder = 0;
        for(String operations : logs){
            if(operations.equals("./")){
                continue;
            }else if(operations.equals("../")){
                folder = folder == 0 ? 0 : --folder; 
            }else{
                folder++;
            }
        }
        System.out.println(folder);
    }
    public static String reverseString(String str){
        StringBuilder helper = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--) {
            helper.append(str.charAt(i));
        }
        return helper.toString();

    }
    public static void reverseStringInParath(String s){
        StringBuilder result = new StringBuilder();
        Stack<Integer> bracketsLen = new Stack<>(); 
        
        for(int i=0; i<s.length(); i++){
            char cha = s.charAt(i);
            if(cha == '('){
                bracketsLen.push(result.length());
                
            }else if(cha == ')'){
                
                String helper = result.substring(bracketsLen.peek() , result.length());
                helper = reverseString(helper);
                
                result.replace( bracketsLen.peek() ,result.length() ,helper);
                bracketsLen.pop();
                
                
                

            }else{
                result.append(cha);
            }
        }

        System.out.println(result );
    }
     public static void matchingString(String haystack, String needle){
        if(needle.length() > haystack.length()){
            return;
        }
        for(int i=0 ;i<haystack.length() - needle.length(); i++){
            if(haystack.substring(i,i+ needle.length()).equals(needle)){
                System.out.println(i);
            }
        }
        return ;
     }
     public static void divideTwoInteger(long dividend, int divisor){
        if(dividend == divisor){
            return;
        }
        boolean sign = dividend < 0 ? divisor < 0  ? true : false : divisor < 0 ? false : true;
        
        long div = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        long result = 0;
        while(divs <= div){
            int count = 0;
            while(div >= (divs * (1 << count))){
                count++;
            }
            --count;
            
            result += 1<<count;
            div -= divs * 1<<count; 
        }
        if(result > Math.pow(2,31) && sign == true){
            System.out.println(Integer.MAX_VALUE);
        }
        
        if(result > Math.pow(2,31) && sign == false){
            System.out.println(Integer.MIN_VALUE);
        }
        System.out.println(sign ? result : -result);
     }
    public static void scoreABBA(String str,int x, int y){
        String top1 = "ab",top2 = "ba";
        int top1_score,top2_score;
        if(y > x){
           
            top1_score = x;
            top2_score = y;
        }else{
            
            top1_score = y;
            top2_score = x;
        }
        int result = 0;
        int left = 0;
        int right = 1;
        while(right < str.length()){
            String tempString = str.substring(left, right+1);
            
            if(tempString.equals(top1)){
                result += top1_score;
                
            }else if(tempString.equals(top2)){
                result +=top2_score;
                
            }
            left++;
            right++;
        }
        System.out.println(result);
        
    }

    public static void robotCollision(int[] positions, int[] healths, String directions){
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<positions.length; i++){
            max = Math.max(max, positions[i]);
        }
        int indexing[] = new int[max+1];
        for(int i=0; i<positions.length; i++){
            indexing[positions[i]] = i+1;
        }

        for(int i=0 ;i<indexing.length; i++){
            if(indexing[i] ==0) continue;
            int num = indexing[i] - 1;
            char dir = directions.charAt(num);
            if(dir == 'R'){
                stack.push(num);
            }else{
                if(!stack.isEmpty()){
                    while( healths[num] != 0 && !stack.isEmpty()){
                        int top = stack.peek();
                       
                        if(healths[num] > healths[top]){
                           
                            healths[num]--;
                            healths[top] = 0;
                            stack.pop();
                        }else if(healths[num] < healths[top]){
                           
                            healths[num] = 0;
                            healths[top]--;
                            
                        }else{
                            healths[num] = 0;
                            healths[top] = 0;
                            stack.pop();
                        }
                    }
                }
                
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<healths.length;i++){
            if(healths[i] != 0){
                result.add(healths[i]);
            }
        }
        System.out.println(result.toString());
    }
    public static int helperfunction(SortedMap<String,Integer> tempStack, char ch, int i, String formula){
        i++;
        char cha = formula.charAt(i);
                while(Character.isDigit(cha) ){
                    Integer num = cha - '0';
                    if(tempStack.containsKey(ch+"")){
                        tempStack.replace(ch+"",tempStack.get(ch+"")*10 + num);   
                        i++; 
                        continue;
                    }
                    tempStack.put(ch+"", num);
                    i++;


                }
                while(cha >= 'a' && ch <= 'z'){
                    tempStack.put(ch+cha+"",tempStack.remove(ch+""));
                    i++;
                    cha = formula.charAt(i);
                }
                
                if( !tempStack.containsKey(ch+"") &&  Character.isUpperCase(cha) || cha == '('){
                    tempStack.put(ch+"", 1);
                }
                return i;
                
    }
    public static void chemicalFormula(String formula){
        int n = formula.length();
        Stack<SortedMap<String,Integer>> stack = new Stack<>();
        for(int i=0; i<n; i++){
            SortedMap<String,Integer> tempStack = new TreeMap<String,Integer>();
            char ch = formula.charAt(i);
            if(ch >= 'A' && ch<='Z' ){
                helperfunction(tempStack, ch, i, formula);
                
            }else if(ch == '('){
                i++;
                while(ch != ')'){
                   int index =  helperfunction(tempStack, ch, i,formula);
                    i = index;
                }
                stack.push(tempStack);
            }else{

            }
        }
        
    }
    public static boolean isvalid(String[][] board, int row, int colum,String ch ){
        for(int j=0;j<board.length; j++){
            if(board[row][j] == ch){
                System.out.println("true1");
                return true;
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][colum] == ch){
                System.out.println("true2");
                return true;
            }
        }
        int newrow = (row/3) * 3;
        int newcolum = (colum/3 * 3);
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
              
                if(board[newrow+i][newcolum + j] == ch){
                     
                    return true;
                }
            }
        }
        return false;
    }
    public static void validSudoku(String[][] board){
        for(int i=0;i<board[0].length; i++){
            for(int j=0; j<board[0].length; j++){
                String ch = board[i][j];
                board[i][j] = ".";

                if(!ch.equals(".")){
                    if(isvalid(board,i,j,ch)){
                      
                        System.out.println("false");
                        return;
                    }
                   
                }
                
                board[i][j] = ch;
            }
        }
        System.out.println("true");
    }
    public static void tokenBag(int[] tokens, int power){
        Arrays.sort(tokens);
        int maxscore = 0;
        int left = 0;
        int right = tokens.length - 1;
        while(left <= right){
            int currScore = 0;
            if(power >= tokens[left]){
                currScore++;
                power -= tokens[left++];
            }else{
                currScore--;
                power += tokens[right--];
            }
            if(currScore < 0) break;
            maxscore = Math.max(maxscore,currScore);
        }
        
    }
    public static int binarySearch(int nums[],boolean issearchLeft, int target) {
        int start = 0;
        int end = nums.length - 1;
        int idx = -1;
        int mid = start + (end - start)/2;
        while(start <= end) {
            if(nums[mid] > target) {
                end = mid - 1;
            }else if(nums[mid] < target) {
                start = mid + 1;
            }else{
                idx = mid;
                if(issearchLeft) {
                    end = mid - 1; 
                }else{
                    start = mid + 1;
                } 
            }
            mid = start + (end - start)/2;
        }
        return idx;
    }
    public static int[] findLastAndFirst(int nums[], int target ) {
       if(nums.length == 0) {
        return new int[] {-1,-1};
       }
       int left = binarySearch(nums,true,target);
       int right = binarySearch(nums, false, target);
       return new int[] {left,right};

    }
   
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<=high - 1; j++) {
            if(arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr,low,high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high); 
        }
    }
    public static String[] sortThePeople(String names[], int heights[]) {
        HashMap<Integer,String> hash = new HashMap<>();
        
        for(int i=0; i<heights.length; i++) {
           
            hash.put(heights[i], names[i]);
        }
        quickSort(heights, 0, heights.length-1);
        
        for(int i=0; i<heights.length; i++) {
            names[i] = hash.get(heights[i]);
        }
        
        return names;
    }
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int coin : bills ) {
            if(coin == 5) {
                five++;
            }else if(coin == 10) {
                if(five == 0) {
                    return false;
                }
                five--;
                ten++;
            }
            else if(coin == 20) {
                if(five == 0) {
                    return false;
                }
                if(five >= 1  && ten >= 1)  {
                    five--;
                    ten--;
                }else if(five >= 3){
                    five = five - 3;
                }else{
                 
                    return false;
                }
            } 

        }
        return true;
    }
    public static void main(String[] args) {
        /*int arr[] = {1,2,3,-3,1,1,1,4,2,-3};
        countSubArray(arr, 3);
        int arr1[] = {2,2,2,1,2,2,1,2,2,2};
        countNumber(arr1, 2);
        int arr[] = {0,0,0,1,0,1,1,0};
        countFlips(arr, 3);
        int[][] edgeList = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        ancestorNode(edgeList, 8);
        int arr[] = {1,2,34,3,4,5,7,23,12};
        threeConsecutive(arr);
        int arr1[] = {1,2,2,2,1};
        int arr2[] = {2};
        intersection(arr1, arr2);
        int nums[] = {6,6,0,1,1,4,6};
        moveThreeNum(nums);

        spendtime(3,2);

        exchangeBottle(15, 4);*/
        
        //circularGame(5, 2);
       // int arr[][] = {{5,2},{5,4},{10,3},{20,1}};
       // averageWaitingTime(arr);
     //  String arr[] = {"d1/","d2/","../","../","../"}; 
       //folder(arr);
       //reverseStringInParath("(u(love)i)");
        //matchingString("mississippi", "issip");
        //divideTwoInteger(-21474838, 1);
       // scoreABBA("abcbabcba", 4, 5);
       // int[] positions = {3,5}, healths = {10,12};
        //String directions = "LR";
        //robotCollision(positions, healths, directions);
       /*  String board[][] = {{"5","3",".",".","7",".",".",".","."},
        {"6",".",".","1","9","5",".",".","."},
        {".","9","8",".",".",".",".","6","."},
        {"8",".",".",".","6",".",".",".","3"},
        {"4",".",".","8",".","3",".",".","1"},
        {"7",".",".",".","2",".",".",".","6"},
        {".","6",".",".",".",".","2","8","."},
        {".",".",".","4","1","9",".",".","5"},
        {".",".",".",".","8",".",".","7","9"}};
        validSudoku(board);
        int arr[] = {7,7,7};
        int target = 7;
        System.out.println(Arrays.toString(findLastAndFirst(arr, target)));*/
        /* String names[] = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.toString(sortThePeople(names, heights)));
         */
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}