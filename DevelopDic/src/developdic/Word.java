package developdic;

public class Word implements Comparable<Word> {
    private String Spelling; 
    private String explain; 
    private String phienam; 
    
    void setSpelling(String Spelling){
        if ((int)Spelling.charAt(0) > 1000){
            Spelling = Spelling.replace(Spelling.charAt(0), ' '); 
        }
        Spelling = Spelling.trim(); 
        this.Spelling = Spelling;
    }
    void setExplain(String explain){
        explain = explain.trim(); 
        this.explain = explain; 
    }
    void setphienam(String phienam){
        phienam = phienam.trim(); 
        this.phienam = phienam; 
    }
    String getSpelling(){
//        Spelling = Spelling.trim(); 
        return Spelling; 
    }
    String getExplain(){
//        Spelling = Spelling.trim(); 
        return explain; 
    }
    String getPhienam(){
//        phienam = phienam.trim(); 
        return phienam; 
    }

    @Override
    public int compareTo(Word o) {
        return (Spelling.compareTo(o.Spelling)); 
    }
}
