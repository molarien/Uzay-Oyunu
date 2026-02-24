# 🚀 Space Game - Java Swing 🌌

This project is a 2D arcade game developed using Java's **Swing** and **AWT** libraries. It was created to implement core software concepts such as the **Game Loop**, **Collision Detection**, and **Event Handling**.

## 📝 Objective
The goal is to hit the red target ball moving horizontally at the top of the screen using your UFO. Once the target is hit, the game pauses and displays the elapsed time and the total number of shots fired.

## 🛠️ Technical Features & Learning Outcomes
* **Graphical User Interface:** Managed using `JFrame` and `JPanel` structures.
* **Game Loop:** Utilized `javax.swing.Timer` with 10ms intervals for smooth FPS updates.
* **Collision Detection:** Implemented using the `intersects()` method of the `java.awt.Rectangle` class to calculate hits between projectiles and the target.
* **Thread Safety:** Leveraged `CopyOnWriteArrayList` for projectile management to prevent `ConcurrentModificationException` during simultaneous read/write operations.
* **Input Management:** Handled dynamic keyboard controls via the `KeyListener` interface.


## 🎮 Controls
You can control the game using the following keys:
* ⬅️ **Left Arrow Key:** Move the UFO to the left.
* ➡️ **Right Arrow Key:** Move the UFO to the right.
* ⌨️ **CTRL Key:** Fire a projectile.

## 🚀 Installation & Execution

1.  Ensure you have **Java JRE/JDK** installed on your system.
2.  Clone the repository:
    ```bash
    git clone [https://github.com/molarien/Space-Game.git](https://github.com/molarien/Space-Game.git)
    ```
3.  Navigate to the project directory and run the `.jar` file using the following command:
    ```bash
    java -jar SpaceGame.jar
    ```



## 📂 File Structure
* `GameScreen.java`: Contains the main window (`JFrame`) and window configurations.
* `Game.java`: The main panel containing the game engine, rendering logic, controls, and collision detection.
* `ufo.png`: Sprite for the player character.


<p align="center">
  <img width="783" height="591" alt="SpaceGame" src="https://github.com/user-attachments/assets/22fc21ba-8e89-4cd4-9671-9a4dc45aa753" />
</p>
