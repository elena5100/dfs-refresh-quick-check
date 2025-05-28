import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem {
    /**
     * Returns how many salamanders less than 3 years old will be at risk from a
     * serious infection if a given salamander is infected.
     * 
     * When a salamander is infected, it will pass the disease along to all of
     * its contacts. Each of those contacts will pass it on to their contacts
     * and so on. Salamanders of any age can catch and spread the disease, but
     * it is only a serious risk for salamanders strictly less than 3 years old.
     * 
     * Include the initial patient in the count iff the initial patient is less
     * than 3 years old.
     * 
     * @param initialPatient the first salamander to be infected
     * @return the number of salamanders less than 3 years old that may be infected
     */
    public static int countSeriousInfections(Salamander initialPatient) {

               
        
    if (initialPatient == null) return 0;
        
               
    Set<Salamander> alreadySeen = new HashSet<>();   
                
    Queue<Salamander> toCheck = new LinkedList<>();  
        
               
    alreadySeen.add(initialPatient);
               
    toCheck.add(initialPatient);
        
                
    int salamanders = 0;
        
                
    while (!toCheck.isEmpty()) {
                   
        Salamander current = toCheck.poll(); 
        
                   
        if (current.getAge() < 3) {
                    
            
        // this one is under 3 years old

            salamanders++; 
        }   
                    
            for (Salamander check : current.getContacts()) {
             if (!alreadySeen.contains(check)) {
                            alreadySeen.add(check);   
                            toCheck.add(check);       
                        }
                    }
                }
        
     return salamanders;
       

               
    }
}
