fun main() {
    val wordList = readWordList("C:\\Users\\nazaa\\IdeaProjects\\comp2850-oop-work\\portfolio\\wordle\\data\\words.txt")
    val selectedWord = pickRandomWord(wordList)
    println(selectedWord)
    var guessedCorrectly = false
    println("Welcome to Wordle!\nGuess today's word!") //intro message
    for (i in 1..10){
        val userGuess = obtainGuess(GuessCounter.guessCounter, wordList)
        if (!isValid(userGuess, wordList)){
            continue
        }
        val evaluatedGuess = evaluateGuess(userGuess, selectedWord)
        val correct = displayGuess(userGuess, evaluatedGuess)
        if (correct){
            println("You guessed it correctly!\nThe word was: $selectedWord")
            guessedCorrectly = true
            break
        }
    }
    if (!guessedCorrectly){
        println("Better luck next time!\nThe word was: $selectedWord")
    }

}
//get random word
//get guess
//compare guess
//display comparison
//if false, repeat loop
//if true congratulate the user and end program