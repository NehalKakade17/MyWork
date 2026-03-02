//============================================================================
// Name        : Game.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <iomanip>
#include <algorithm>  // For std::shuffle
#include <random>     // For random engine

using namespace std;

const int SIZE = 4; // Grid size (4x4)
const int NUM_CARDS = SIZE * SIZE; // Total number of cards (16)
int board[SIZE][SIZE]; // The game board
bool revealed[SIZE][SIZE]; // Tracks revealed cards

// Function to initialize the board with pairs of numbers
void initializeBoard() {
    vector<int> cards(NUM_CARDS / 2); // Half the grid size for pairs
    for (int i = 0; i < NUM_CARDS / 2; i++) {
        cards[i] = i + 1; // Assign numbers 1 to 8
    }

    // Duplicate numbers to create pairs
    cards.insert(cards.end(), cards.begin(), cards.end());

    // Shuffle the cards randomly using std::shuffle
    random_device rd;
    mt19937 g(rd());
    shuffle(cards.begin(), cards.end(), g);

    // Fill the board with the shuffled cards
    int index = 0;
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            board[i][j] = cards[index++];
            revealed[i][j] = false; // All cards are face down initially
        }
    }
}

// Function to display the current state of the board
void displayBoard() {
    cout << "\nCurrent Board State:\n";
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (revealed[i][j]) {
                cout << setw(4) << board[i][j]; // Show card if revealed
            } else {
                cout << setw(4) << "*"; // Hide card if not revealed
            }
        }
        cout << "\n";
    }
}

// Function to check if all cards have been revealed (game over condition)
bool isGameOver() {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (!revealed[i][j]) {
                return false; // If any card is still hidden, game is not over
            }
        }
    }
    return true; // All cards revealed, game over
}

// Function to handle the player's move
bool makeMove(int row1, int col1, int row2, int col2) {
    if (board[row1][col1] == board[row2][col2]) {
        revealed[row1][col1] = true;
        revealed[row2][col2] = true;
        return true; // Cards match
    }
    return false; // Cards do not match
}

int main() {
    initializeBoard();
    int row1, col1, row2, col2;
    int moveCount = 0;

    cout << "===== Welcome to the Memory Matching Game =====\n";
    cout << "Match all the pairs to win the game!\n";
    cout << "Enter the coordinates of two cards to flip (row and column)\n";
    cout << "For example, to flip card at row 1, column 2, input: 1 2\n";
    cout << "Good luck!\n";

    while (!isGameOver()) {
        displayBoard();
        cout << "\nMove #" << ++moveCount << "\n";

        // Player's first card selection
        cout << "Enter the coordinates of the first card to flip (row col): ";
        cin >> row1 >> col1;

        // Adjust for 0-based index
        row1--;
        col1--;

        if (row1 < 0 || row1 >= SIZE || col1 < 0 || col1 >= SIZE || revealed[row1][col1]) {
            cout << "Invalid or already revealed card. Try again.\n";
            continue;
        }

        // Player's second card selection
        cout << "Enter the coordinates of the second card to flip (row col): ";
        cin >> row2 >> col2;

        // Adjust for 0-based index
        row2--;
        col2--;

        if (row2 < 0 || row2 >= SIZE || col2 < 0 || col2 >= SIZE || revealed[row2][col2]) {
            cout << "Invalid or already revealed card. Try again.\n";
            continue;
        }

        // Make the move and check if the cards match
        if (makeMove(row1, col1, row2, col2)) {
            cout << "It's a match!\n";
        } else {
            revealed[row1][col1] = false;
            revealed[row2][col2] = false;
            cout << "No match! Try again.\n";
        }
    }

    // Game over - all pairs matched
    cout << "\nCongratulations! You've matched all the pairs and won the game in " << moveCount << " moves!\n";

    return 0;
}



