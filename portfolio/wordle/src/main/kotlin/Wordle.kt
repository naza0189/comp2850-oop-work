import java.io.File

// Implement the six required functions here

fun isValid(word: String, wordList: MutableList<String>): Boolean {
    return when {
        word.length != WORD_LENGTH -> {
            println("Word must be 5 letters")
            false
        }

        word !in wordList -> {
            println("Invalid word")
            false
        }

        else -> {
            GuessCounter.guessNumber += 1
            true
        }
    }
}

fun readWordList(filename: String): MutableList<String> { // returns the list of words
    val wordList = File(filename)
        .bufferedReader()
        .readLines()
        .toMutableList() // reading the txt file and putting all the words into a mutable list
    return wordList
}

fun pickRandomWord(wordList: MutableList<String>): String { // returns the random word
    val selectedWord = wordList.random() // selecting a random word from the list
    return selectedWord
}

fun obtainGuess(attempt: Int): String {
    println("Guess no: ${attempt}\n")
    val userGuess = readln().uppercase() // parsing user's input to all caps to match the format of the txt file
    return userGuess.toString() // returns the user's guess
}

fun evaluateGuess(guess: String, target: String): List<Int> { // returns a list about the evaluation of the user's guess
    val guessWordGuesser = mutableListOf<Int>()
    for (i in guess.indices) {
        if (guess[i] == target[i]) { // 1 = correct letter AND position
            guessWordGuesser.add(1)
        } else {
            guessWordGuesser.add(0) // 0 = incorrect letter AND position
        }
    }
    return guessWordGuesser
}

fun displayGuess(guess: String, matches: List<Int>): Boolean { // returns a boolean for the flag
    println("Your guess: $guess\nCorrect guesses: $matches")
    if (matches == listOf(1, 1, 1, 1, 1)) {
        return true
    } else {
        return false
    }
}

object GuessCounter { // global variable for the guess counter (like a static variable in Java)
    var guessNumber: Int = INITIAL_GUESS_COUNT
}
