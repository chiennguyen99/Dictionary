package developdic;


public class Dictionary1 { 
    ListWord LWO = new ListWord(2);
    ListWord LWI = new ListWord(); 
    public ListWord SearchKeyWord(String S0){
     
        for (int i = 0; i < LWO.ReturnSizeList(); i++){
            String S1 = LWO.ReturnWordSpelling(i);
            if (S1.indexOf(S0) == 0){
                LWI.AddWordToList(LWO.ReturnWordList(i));
            }
        }
        return LWI; 
        
    }
    
    String ReturnSpellingInList(String S0){
        int size = LWO.ReturnSizeList(); 
        for (int i = 0; i < size; i++){
            if (LWO.ReturnWordExplain(i).equals(S0)){
                return LWO.ReturnWordSpelling(i); 
            }
        }
        return ""; 
    }
    
    String ReturnPhienAMInList (String S0){
        int k = BinarySearch(S0); 
        return LWO.ReturnWordPhienAm(k); 
    }
    
    int BinarySearch(String s){
        int left = 0, right = LWO.ReturnSizeList() - 1; 
        while (left <= right){
            int bet = (left + right)/2; 
            if (LWO.ReturnWordSpelling(bet).equals(s)){
                return bet; 
            }
            else if (LWO.ReturnWordSpelling(bet).compareTo(s) > 0){
                right = bet - 1; 
            }
            else if (LWO.ReturnWordSpelling(bet).compareTo(s) < 0){
                left = bet + 1; 
            }
        }
        return -1; 
    }
    
    public static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
   }
}
