import java.util.*;

public class Solution {
    public String reorganizeString(String s) {
   
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
 
        PriorityQueue<CharFrequency> maxHeap = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(new CharFrequency(entry.getKey(), entry.getValue()));
        }
        

        StringBuilder result = new StringBuilder();
        CharFrequency prev = null;

        while (!maxHeap.isEmpty()) {
            CharFrequency current = maxHeap.poll();
            
            
            if (prev != null && prev.frequency > 0) {
                maxHeap.offer(prev);
            }
            
            
            result.append(current.character);
            current.frequency--;
            

            prev = current;
        }
        
        
        return result.length() == s.length() ? result.toString() : "";
    }
    
    
    private static class CharFrequency {
        char character;
        int frequency;
        
        CharFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }
    
}
