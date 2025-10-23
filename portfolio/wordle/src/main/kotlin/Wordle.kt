import java.io.File
// Implement the six required functions here
fun isValid(word: String, wordList: MutableList<String>): Boolean{
    if (word.length != 5) { //checking whether the word is 5 letters
        println("Word must be 5 letters")
        return false
    } else if (word !in wordList){ //checking whether the guess is included in the list
        println("Invalid word")
        return false
    } else { //adding the guess counter by one if the word
        GuessCounter.guessCounter = GuessCounter.guessCounter + 1
        return true
    }
}
fun readWordList(filename: String): MutableList<String>{
    val wordList = File(filename).bufferedReader().readLines().toMutableList()
    return wordList
}
fun pickRandomWord(wordList: MutableList<String>): String{
    val selectedWord = wordList.random()
    return selectedWord
}
fun obtainGuess(attempt: Int, wordList: MutableList<String>): String{
    println("Guess no: ${GuessCounter.guessCounter.toString()}\n")
    val userGuess = readln().uppercase()
    return userGuess.toString()
}

fun evaluateGuess(guess: String, target: String): List<Int>{
    val guessWordGuesser = mutableListOf<Int>()
    for (i in guess.indices){
        if (guess[i] == target[i]){
            guessWordGuesser.add(1)
        }else {
            guessWordGuesser.add(0)
        }
    }
    return guessWordGuesser
}
fun displayGuess(guess: String, matches: List<Int>): Boolean{
    println("Your guess: $guess\nCorrect guesses: $matches")
    for (i in guess.indices){

    }
    if (matches == listOf(1, 1, 1, 1, 1)){
        return true
    }else{
        return false
    }
}
class GuessCounter{
    companion object{
        var guessCounter: Int = 1
    }
}