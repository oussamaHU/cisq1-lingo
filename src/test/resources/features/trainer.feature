Feature: lingo trainer
  As a lingo trainer,
  I want to train lingo users
  So that they can be better at the game

  Scenario: start new game
    Given user wants to start a game
    When user starts a game
    Then user can start guessing words

    Scenario Outline: guess a word
      Given the user is playing a game
      And the word is "<word>"
      When user takes a guess: "<guess>"
      Then the game gives the user feedback: "<feedback>"
      Examples:
        | word | guess | feedback            |
        | car  | dog   | no matching letters |


