object Bob {
  def response(statement: String): String = {

    val containsLetters = statement.exists(_.isLetter)
    val isUpperCase = statement == statement.toUpperCase
    val isQuestion = statement.trim.endsWith("?")

    if (containsLetters && isUpperCase && isQuestion) "Calm down, I know what I'm doing!"
    else if (containsLetters && isUpperCase) "Whoa, chill out!"
    else if (isQuestion) "Sure."
    else if (statement.trim.isEmpty) "Fine. Be that way!"
    else "Whatever."
  }
}
