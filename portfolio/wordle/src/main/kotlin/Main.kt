fun main() {
    val wordList = readWordList("C:\\Users\\nazaa\\IdeaProjects\\comp2850-oop-work\\portfolio\\wordle\\data\\words.txt")
    val selectedWord = pickRandomWord(wordList)
    println(selectedWord)
    println("Welcome to Wordle!\nGuess today's word!") //intro message
    for (i in 1..10){
        val userGuess = obtainGuess(GuessCounter.guessCounter, wordList)
        if (!isValid(userGuess, wordList)){
            continue
        }
        val evaluatedGuess = evaluateGuess(userGuess, selectedWord)
        val correct = displayGuess(userGuess, evaluatedGuess)
        if (correct){
            println("You guessed it correctly!")
            break
        }
    }
    println("Better luck next time!")

}
//get random word
//get guess
//compare guess
//display comparison
//if false, repeat loop
//if true congratulate the user and end program