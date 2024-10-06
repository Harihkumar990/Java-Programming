public class Pattern {
    public static void pyramid(int n) {
        /* int num = 1;
         for(int i=0; i<=5; i++) {
            int idx = i % 2 == 0 ? 0 : 1; 
            for(int j=0; j<=i; j++) {
                System.out.print(" " + idx%2 +" ");
                idx++;
            }
            System.out.println();
        }  */
        /* for(int i=0; i<=n; i++) {
            for(int j=0; j< n - i; j++) {
                System.out.print("   ");
            }
            for(int k=0; k<=i; k++) {
                System.out.print(" * ");
            }
            System.out.println();
        } */
       /* for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                if(i==0 || i == n) {
                    System.out.print(" * ");
                } else if(j == 0 || j==n) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
       } */
       /*  int nx = 1;
       for(int i=0; i<=n; i++) {
            int idx = nx;
            nx++;
            boolean reverse = false;
            for(int j=0; j< n - i; j++) {   
                System.out.print("    ");
            }
            for(int k=1; k<=i*2 + 1; k++) {
                System.out.print(" "+ idx + "  ");
                if(idx == 1) {
                    reverse = true;
                }
                if(reverse) {
                    idx++;
                } else {
                    idx--;
                }
            }
            
            System.out.println();
        } 
 */         
        /* for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                System.out.print(" ");
            }
            for(int k=0; k<n; k++) {
                System.out.print("*");
            }
            System.out.println();
        } */
        /* for(int i=0; i<n; i++) {
            for(int j=0; j<n-i; j++) {
                System.out.print("    ");
            }
            for(int k=0; k<2*i+1; k++) {
                System.out.print(" *  ");
            }
            System.out.println();
        }
        
        for(int i=1; i<n; i++) {
            for(int k=0; k<=i; k++) {
                System.out.print("    ");
            }
            for(int j=0; j<2*(n-(i+1))+1; j++) {
                System.out.print(" *  ");
            }
            
            System.out.println();
        } */
      /*  for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) System.out.print(" * ");
            for(int k=1; k<n-i; k++) System.out.print("      ");
            for(int l=0; l<=i; l++) System.out.print(" * ");
            System.out.println();
       }
       for(int i=1; i<=n; i++) {
        for(int j=1; j<=n-i; j++) System.out.print(" * ");
        for(int k=1; k<=i; k++) System.out.print("      ");
        for(int l=1; l<=n-i; l++) System.out.print(" * ");
        System.out.println(); 
   }*/
            for(int i=0; i<n; i++) {
                for(int j=0; j<n-i; j++) {
                    System.out.print("  ");
                }
                for(int k=0; k<2*i+1; k++) {
                    if(i==0) {
                            
                        System.out.print("  *  ");
                    } else if(k==0 || k==2*i) {
                            
                        System.out.print(" *  ");
                    } else {
                        
                       System.out.print("  ");
                    }

                }
                System.out.println();
            }

            for(int i=1; i<n; i++) {
                for(int k=0; k<=i; k++) {
                    System.out.print("  ");
                }
                for(int j=0; j<2*(n-(i+1))+1; j++) {
                    if(i==n-1) {
                            
                        System.out.print("  *  ");
                    } else if(j==0 || j== 2*(n-(i+1))) {
                            
                        System.out.print(" *  ");
                    } else {
                        
                       System.out.print("  ");
                    }
                }
                
                System.out.println();
            }
    }
    public static void main(String[] args) {
        pyramid(5);
    }
}
