import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File

class WordleTest : StringSpec({


    "isValid should return true only for valid 5-letter words in list" {
        val wordList = mutableListOf("APPLE", "BERRY", "CHAIR")

        isValid("APPLE", wordList) shouldBe true   // valid and in list
        isValid("DOG", wordList) shouldBe false    // too short
        isValid("HELLO!", wordList) shouldBe false // contains invalid character
        isValid("MANGO", wordList) shouldBe false  // 5 letters but not in list
    }

    "readWordList should read file contents correctly" {
        // create a temporary file with known content
        val tempFile = File.createTempFile("words", ".txt")
        tempFile.writeText("APPLE\nBERRY\nCHAIR\n")

        val words = readWordList(tempFile.absolutePath)
        words shouldBe mutableListOf("APPLE", "BERRY", "CHAIR")

        tempFile.deleteOnExit()
    }

    "pickRandomWord should pick and return a word from the list" {
        val wordList = mutableListOf("APPLE", "BERRY", "CHAIR")
        val word = pickRandomWord(wordList)

        (word in listOf("APPLE", "BERRY", "CHAIR")) shouldBe true
        // In your code, pickRandomWord doesn't remove the word — so we just test that it exists
        wordList.contains(word) shouldBe true
    }

    "evaluateGuess should correctly mark exact matches with 1 and others 0" {
        evaluateGuess("APPLE", "APRON") shouldBe listOf(1, 1, 0, 0, 0)
        evaluateGuess("CHAIR", "BERRY") shouldBe listOf(0, 0, 0, 0, 0)
        evaluateGuess("BERRY", "BERRY") shouldBe listOf(1, 1, 1, 1, 1)
    }



})
