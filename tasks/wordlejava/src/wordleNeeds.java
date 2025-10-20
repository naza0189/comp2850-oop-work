import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class wordleNeeds {
    public boolean isValid (String userInput){
        if (userInput.length() != 5){
            return false;
        }else return true;
    }
    public void readWordList(File wordlePossibleWord){
        try (BufferedReader readPossibleWordList = new BufferedReader(new FileReader(wordlePossibleWord))){
            readPossibleWordList.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
