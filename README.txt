Jake Erickson jerickson@mymail.mines.edu

Assignment 2: Othello

High Level Description:
This program is basically the game of othello, complete with options to decide who is first and whether you want to reset win totals. The game of othello is quite simple. Basically you start with four pieces on the board, two white and two black. On black's turn a piece is placed such that it makes a sandwich of a white piece in between two black pieces. Then all white pieces inside the sandwich are flipped over to become black pieces. The same applies for white's turn, but for white's pieces. In addition you can have sandwiches in any direction, diagonally, horizontally, and vertically. Chain sandwiches are also possible where you have a sandwich in the vertical, horizontal, or diagonal directions in which case all of the pieces inside the sandwiches must be changed. Then once there are no longer any places available to play for both players, then the pieces on the board are counted. The color with more pieces wins.

Usage Section:
The game overall is pretty self explanatory. Simply tap the buttons you desire for options or playing the game. As for the board in game, just tap on the grid square you want to play on. Nothing happens if you tap a grid square and it is not a valid location.

Instructions:
Simply open android studio and import my project. Then run on your desired emulator or personal device.

Notes:
Game works on orientation change and across different fragments. Most of the code for functionality is found inside the fragment java classes themselves rather than their respective controllers, simply because that is the way I created it.

