import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) {
    System.out.println("SAT DATA!!!!");
    // create data structure to store all total scores
    ArrayList<Integer> totalScore = new ArrayList<Integer>();

    try{
      Scanner s = new Scanner(new File("total.txt"));
      while(s.hasNext()){
        int score = Integer.parseInt(s.nextLine());
        totalScore.add(score);
      }
      s.close();
    }
    catch(Exception e){
      System.out.println("file not found");
    }
    // make sure all data entered the ArrayList
    System.out.println(totalScore);
    System.out.println(totalScore.size());
    int t = 0;
    for(int i: totalScore){
      t += i;
    }
    double a = (double)t/totalScore.size();
    System.out.println("Average score: "+a);
    // find the most common score
    Map<Integer, Integer> scoreCount = new HashMap<>();
    for (int score : totalScore) {
      scoreCount.put(score, scoreCount.getOrDefault(score, 0) + 1);
    }
    int maxCount = 0;
    int mostCommonScore = 0;
    for (Map.Entry<Integer, Integer> entry : scoreCount.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostCommonScore = entry.getKey();
      }
    }
    System.out.println("Most common score: " + mostCommonScore);
    int highestScore = totalScore.get(0);
    for (int score : totalScore) {
      if (score > highestScore) {
        highestScore = score;
      }
    }
    System.out.println("Highest score: " + highestScore);
    int lowestScore = totalScore.get(0);
    for (int score : totalScore) {
      if (score < lowestScore) {
        lowestScore = score;
      }
    }
    System.out.println("Lowest score: " + lowestScore);
  }
}
