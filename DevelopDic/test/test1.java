import java.awt.Color;
import java.awt.FlowLayout;
import java.util.LinkedList;
 
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class test1 {
    public static void main(String [] args){
        LinkedList<String> LIST = new LinkedList<>();
        LIST.add("chien"); 
        LIST.add("nguyen"); 
        System.out.println(LIST.get(0));
        LIST.remove(0); 
        System.out.println(LIST.get(0));
    }
}
