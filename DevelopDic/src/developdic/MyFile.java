package developdic;

import java.io.*; 

public class MyFile {
    private final String NAMEFILE = "test.txt"; 
 
    BufferedReader OpenFileReader(FileInputStream Fr1){
        BufferedReader Br = null; 
        FileInputStream FIS = null; 
        try{
            FIS = new FileInputStream(NAMEFILE);
            Br = new BufferedReader(new InputStreamReader(FIS, "UTF-8"));            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        Fr1 = FIS; 
        return Br; 
    }
    void CloseFileReader(FileInputStream Fr1, BufferedReader Br){
        try{
            if (Br != null){
                Br.close();
            }
            if (Fr1 != null){
                Fr1.close();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage()); 
        }
    }
    void ResetFile(){
        try{
            File file = new File(NAMEFILE);
            file.delete();
            file.createNewFile();
        }catch(IOException ex){
            System.out.println("Khong reset được");
        }
    }
    BufferedWriter OpenFileWriter(FileOutputStream Fw1){
        BufferedWriter Bw = null; 
        FileOutputStream Fw = null; 
        try{
            Fw = new FileOutputStream(NAMEFILE); 
            Bw = new BufferedWriter(new OutputStreamWriter(Fw,"UTF-8"));             
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        Fw1 = Fw; 
        return Bw; 
    }
    void CloseFileWriter(FileOutputStream Fw1, BufferedWriter Bw){
        try{
            if (Fw1 != null){
                Fw1.close();
            }
            if (Bw != null){
                Bw.close();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage()); 
        }
    }
}
