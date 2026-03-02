//============================================================================
// Name        : CricketGame.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
#include <iomanip>

class Player {
private:
    std::string name;
    int totalScore;

public:
    Player(const std::string& playerName) : name(playerName), totalScore(0) {}

    void addRuns(int runs) {
        totalScore += runs;
    }

    int getScore() const {
        return totalScore;
    }

    std::string getName() const {
        return name;
    }
};

class CricketGame {
private:
    Player player1;
    Player player2;

public:
    CricketGame() : player1("Player 1"), player2("Player 2") {}

    void play() {
        bool gameOver = false;

        while (!gameOver) {
            // Player 1's turn
            int player1Runs = getPlayerRuns(player1);

            // Player 2's turn
            int player2Runs = getPlayerRuns(player2);

            // Check if runs are the same
            if (player1Runs == player2Runs) {
                determineWinner();
                gameOver = true;
            }
        }
    }

private:
    int getPlayerRuns(Player& currentPlayer) {
        int runs;
        while (true) {
            std::cout << currentPlayer.getName() << ", enter your runs (1-6): ";
            std::cin >> runs;

            // Validate input
            if (runs >= 1 && runs <= 6) {
                currentPlayer.addRuns(runs);
                std::cout << currentPlayer.getName() << "'s total score: " << currentPlayer.getScore() << std::endl;
                return runs;
            } else {
                std::cout << "Invalid input. Please enter runs between 1 and 6." << std::endl;
            }
        }
    }

    void determineWinner() {
        std::cout << "\n--- Game Over ---" << std::endl;
        std::cout << "Player 1 Score: " << player1.getScore() << std::endl;
        std::cout << "Player 2 Score: " << player2.getScore() << std::endl;

        if (player1.getScore() > player2.getScore()) {
            std::cout << player1.getName() << " wins!" << std::endl;
            std::cout << player2.getName() << " is out!" << std::endl;
        } else if (player2.getScore() > player1.getScore()) {
            std::cout << player2.getName() << " wins!" << std::endl;
            std::cout << player1.getName() << " is out!" << std::endl;
        } else {
            std::cout << "It's a tie!" << std::endl;
        }
    }
};

int main() {
    std::cout << "Welcome to the Cricket Batting Game!" << std::endl;
    std::cout << "Rules:" << std::endl;
    std::cout << "1. Each player takes turns entering runs (1-6)." << std::endl;
    std::cout << "2. If both players enter the same runs, the game ends." << std::endl;
    std::cout << "3. The player with the lower score is out." << std::endl;
    std::cout << "\nLet's begin!" << std::endl;

    CricketGame game;
    game.play();

    return 0;
}
