package com.pepcode.array;

public class pushDominos {
    public String pushDominoes_Sol(String dominoes) {
        dominoes = "L" + dominoes + "R";
        int pi = 0;

        char[] arr = dominoes.toCharArray();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 'R'){
                if(arr[pi] == 'L'){
                    // nothing to do
                } else if(arr[pi] == 'R'){
                    for(int x = pi + 1; x < i; x++){
                        arr[x] = 'R';
                    }
                }

                pi= i;
            } else if(arr[i] == 'L'){
                if(arr[pi] == 'L'){
                    for(int x = pi + 1; x < i; x++){
                        arr[x] = 'L';
                    }
                } else if(arr[pi] == 'R'){
                    int left = pi + 1;
                    int right = i - 1;
                    while(left < right){
                        arr[left] = 'R';
                        arr[right] = 'L';
                        left++;
                        right--;
                    }
                }

                pi = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length - 1; i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public String pushDominoes(String dominoes) {

//         convert into array and assign left in left side and right in right side
        int n = dominoes.length();
        char[] arr = new char[n+2];
        arr[0] ='L';
        arr[arr.length-1] = 'R';

//         Preparing the array
        for(int i =1 ;i<arr.length -1; i++){
            arr[i] = dominoes.charAt(i-1);
        }

//         there are 4 cases:
//         assign two pointers
        int j =0;
        int k =1;
        while(k < arr.length){
            while(arr[k] == '.'){
                k++;
            }
            if(k-j >1){
                solveConfiguration(arr,j,k);
            }

            j=k;
            k=k+1;
        }

        StringBuilder res = new StringBuilder();
        for(int i =1; i< arr.length -1 ;i++){
            res.append(arr[i]);
        }
        return res.toString();

    }

    public void solveConfiguration(char[] arr,int i,int j){
//         these are the 4 cases
        if(arr[i] == 'L' && arr[j] == 'L'){
//             Make all dots as L
            for(int k =i+1 ;k<j ;k++){
                arr[k] = 'L';
            }

        }
        else if(arr[i] == 'R' && arr[j] == 'R'){
//             make all dots R
            for(int k =i+1 ;k<j ;k++){
                arr[k] = 'R';
            }

        }
        else if(arr[i] =='L' && arr[j] == 'R'){
//              do nothing
            return;
        }
        else{
//             solve acc. to odd or even
            int diff = j-i;
            int mid = (i+j)/2;
            if(diff%2 ==0){
//                 odd dots in between

                for(int k =i+1 ;k < mid;k++){
                    arr[k] ='R';
                }
                for(int k =mid+1; k< j ;k++){
                    arr[k] ='L';
                }
            }
            else{
//                 even dots
                for(int k =i+1 ;k <= mid;k++){
                    arr[k] ='R';
                }
                for(int k =mid+1; k< j ;k++){
                    arr[k] ='L';
                }

            }

        }

    }
}
