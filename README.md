# cat-battle

# About
Simple game written in Kotlin for a job interview. It has no UI, so the inputs must be given by the input console.

The user gives an initial position and orientation for the player and for a bunch of enemies. 
In addition to position and orientation, the user gives the frequency of shooting of each enemy so, for example, if the frequency is 4, that enemy will shoot every 4 secs.

Each command the user gives to the player takes one second to be executed.

# Build instructions
Clone or download the repository
```
git clone https://github.com/lascenify/cat-battle.git
```


# The game
When the game starts, the user can introduce one of these commands:
- right: turn right
- left: turn left
- shoot: shoots to the direction that is facing
- advance: advances one position in the direction that is facing

The user can stop the game after every movement. 
If the user has not been killed yet and stops the game, the game will tell in which position it has ended.


# Future work

## UI Development
Since this project has been developed in few hours, no UI has been implemented. 

- Main game interface: is thought to be a grid with positions with two kind of players: the user player and the enemies. Also, a HUD with the time elapsed and the number of lives left can be included in the HUD.
- Menu: a menu would give the user the opportunity of starting a game or accessing the stats.
- Finish game screen: when the game ends, a screen should be displayed with the stats of that game and buttons to navigate to the stats screen or start a new game.
- Stats screen: very game ended should be stored in a database, so that the statistics could include the time elapsed in every success game, the name of the player and the enemies killed in that time.


## CI
Continuous integration to automate testing in each pull request. Tests ensures the adequate working of characters and game logic.
