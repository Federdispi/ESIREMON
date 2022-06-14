# ESIREMON (Demo)

## Introduction

This is a demo of the game ESIREMON. This game takes place in ESIREM and we will play as a Student who has an exam. To create this game, I imagined the students' work as fights. So the main objective of the player is to defeat the professor who is located in the Steinbrunn amphiteater. In order to do that he has to improve is level by defeating other students.

## Commands
* WASD / ZQSD to walk (I hope that there is no problem for ZQSD, I only tested the game with WASD as I have got a US Layout Keyboard).
* Enter to interact (to talk with sprites you have to press Enter while walking towards them) or Validate.
* Escape to cancel or to go back.

## Locations

* As said before, this game takes place in the ESIREM school, but for this demo version of the game, only a section of the 1st floor is available.
* The player starts his adventure in his apartment.
* Between the school and the apartment, the player will meet some schoolmates on the street.
* In the end, the player will challenge the professor in the Steinbrunn amphitheater.

## Sprites

There are 4 types of sprite :
* Player
* Student
* KFetMan
* Prof
Sprites have a simple AI which moves them randomly and they can interact with the player by talking, fighting or exchanging with him.

## Battles

The player and the students will compete to test their skills. This competition is represented as a turn based fight.
Player can choose to attack his opponent or use the items in his bag to heal himself.
Every attack has a different power and a different limited number of uses.
Every item has a different healing power.
If the player manages to beat his opponent, he won't be able to challenge him again and he will gain 2 levels and 2 euros.
Else a Game over screen is displayed and he has to create a new game or load the previous game.
If the player manages to beat his professor, a You won screen is displayed.

## Healing

After a fight, the player Life points may be few, so he needs to heal himself. There are three ways to do that :
* Use the items in his bag
* Go to the bed
* Go to the toilet

If he goes to the bed or to the toilet, attacks' limit will be restored.

## KFet

The player can spend his money at the KFet, where he can buy three types of item :
* Waffle
* Coffee
* Big Coffee

Each item has a different cost and a different healing power. The KFet has an unlimited stock of items, the only limit is the player bag capacity (20).

## Future updates

* Improving textures.
* Improving sprites images.
* Adding more objects.
* Improve the existing maps.
* Add more maps
    * ESIREM floors
    * ESIREM classes
    * Mirande
    * Real Dijon zones
* Add sounds.
* Improving the battle system.
* Add an EXP system to level up.
