## Rock-Paper-Scissors
Good old rock-paper-scissors game as a single microservice without UI.

## System requirements:

The following is required to be configured before running the project:
* Java ( with JAVA_HOME defined )
* Maven ( with MAVEN_HOME defined )

## Sample requests:

### Play single round:

* Url: http://localhost:5000/api/v1/rockpaperscissors/usd123 where `usd123` is unique user ID
* Request type: POST
* Content-Type: application/json
* Request body variations:
    * `"ROCK"`
    * `"PAPER"`
    * `"SCISSORS"`

* Sample outcome:
    ```json
  {
      "userId": "usd123",
      "attack": "PAPER",
      "computer": "ROCK",
      "outcome": "VICTORY"
  }
  ```

### Finish game and get statistics:

* Url: http://localhost:5000/api/v1/rockpaperscissors/usd123
* Request type: GET
* Content-Type: application/json
* Sample outcome:
  ```json
  {
      "userId": "usd123",
      "wins": 3,
      "losses": 2,
      "draws": 3
  }
  ```
Getting statistics for user will also clean statistics for this user.