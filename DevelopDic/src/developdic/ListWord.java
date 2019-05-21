package developdic;

import java.io.*; 
import java.util.*; 

public final class ListWord {
    private final LinkedList<Word> LIST = new LinkedList<>();
    
    private final MyFile F = new MyFile(); 
   
    public void CreatList(){
        FileInputStream Fr = null; 
        BufferedReader Br = F.OpenFileReader(Fr); 
        try {
           String s1, s2, s3;
           while((s1 = Br.readLine()) != null){
               Word W = new Word(); 
               int k = s1.indexOf("\t"); 
               if(k >= 0 && k < s1.length()){
                   s2 = s1.substring(0, k); 
                   s3 = s1.substring(k + 1); 
                   int k1 = s3.indexOf("\t"); 
                   if (k1 > 0 && k1 < s3.length()){
                        String s4 = s3.substring(0, k1); 
                        String s5 = s3.substring(k1 + 1); 
                        W.setSpelling(s2);
                        W.setExplain(s4);
                        W.setphienam(s5);
                   }
                   else {
                        W.setSpelling(s2);
                        W.setExplain(s3);
                        W.setphienam("");
                   }
                   LIST.add(W); 
               }
           }
        } catch (IOException ex) {
              System.out.println(ex.getMessage()); 
        }
        F.CloseFileReader(Fr,Br);
    }
    ListWord(){}; 
    ListWord(int a){
        if (a == 1){
            this.CreatList();
        }
        else {
            this.CreatList();
            this.Sort();
        }
    }
    
    // sua thanh boolean. 
    void AddWordToList(Word W){
        LIST.add(W); 
    }
    
    void DeleteWordToList(String Spelling){
        int size = LIST.size(), k = -1; 
        for (int i = 0; i < size; i++){
            if (LIST.get(i).getSpelling().equals(Spelling)){
                k = i; 
            }
        }
        if (k >= 0){
            LIST.remove(k); 
        }
    }
    
    void ChangeWord(Word W, int i){     
        LIST.set(i, W); 
    }
    
    void WriteWordToFile(Word W){
        FileOutputStream Fw1 = null; 
        BufferedWriter Bw = F.OpenFileWriter(Fw1);
        try{
           Bw.write(W.getSpelling());
           Bw.write("\t");
           Bw.write(W.getExplain());
           Bw.newLine();
        }catch(IOException ex){
            System.out.println(ex.getMessage()); 
        }
        F.CloseFileWriter(Fw1, Bw);
    }
    void WriteListToFile(){
        F.ResetFile();
        FileOutputStream Fw1 = null; 
        BufferedWriter Bw = F.OpenFileWriter(Fw1); 
        try{      
            for (int i = 0; i < this.LIST.size(); i++) {
                String s1 = LIST.get(i).getSpelling();
                String s2 = LIST.get(i).getExplain(); 
                String s3 = LIST.get(i).getPhienam(); 
                Bw.write(s1);
                Bw.write("\t");
                Bw.write(s2);
                Bw.write("\t");
                Bw.write(s3);
                Bw.newLine();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage()); 
        }
        F.CloseFileWriter(Fw1, Bw);
    }
    
    String ReturnWordSpelling(int i){
        return LIST.get(i).getSpelling(); 
    }
    
    String ReturnWordExplain(int i){
        return LIST.get(i).getExplain(); 
    }
    
    String ReturnWordPhienAm(int i){
        return LIST.get(i).getPhienam(); 
    }
    int ReturnSizeList(){
        return LIST.size(); 
    }
    
    Word ReturnWordList(int i){
        return LIST.get(i); 
    }
      
    public void Sort(){
        Collections.sort(LIST);
    }
    
    void PrintList(){
        for (int i = 0; i < this.LIST.size(); i++){
            System.out.print(LIST.get(i).getSpelling() + "<++++++>");
            System.out.println(LIST.get(i).getExplain() + "<+++++++>" + LIST.get(i).getPhienam());
        }
    }
}
