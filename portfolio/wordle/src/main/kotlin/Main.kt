const val MAX_GUESSES = 10
const val INITIAL_GUESS_COUNT = 1
const val WORD_LENGTH = 5

fun main() {
    val wordList = readWordList("C:\\Users\\nazaa\\IdeaProjects\\comp2850-oop-work\\portfolio\\wordle\\data\\words.txt")
    val selectedWord = pickRandomWord(wordList)
    var guessedCorrectly = false // flag for whether the user's answer was correct or not
    println("Welcome to Wordle!\nGuess today's word!") // intro message

    while (GuessCounter.guessNumber <= MAX_GUESSES) { // 10 loops for the user to guess the word
        val userGuess = obtainGuess(GuessCounter.guessNumber) // calling the user to guess the word
        if (isValid(userGuess, wordList)) { // checking if the word is valid
            val evaluatedGuess = evaluateGuess(userGuess, selectedWord) // comparing the users word with the answer
            val correct = displayGuess(userGuess, evaluatedGuess) // display the comparison
            if (correct) {
                println("You guessed it correctly!\nThe word was: $selectedWord")
                guessedCorrectly = true
                break
            }
        }
    }

    if (!guessedCorrectly) {
        println("Better luck next time!\nThe word was: $selectedWord")
    }
}

// get random word
// get guess
// compare guess
// display comparison
// if false, repeat loop
// if true congratulate the user and end program
