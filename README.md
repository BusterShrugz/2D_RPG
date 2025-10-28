# Time Leap

**Time Leap** is a thrilling 2D RPG that fuses **medieval fantasy** with **futuristic sci-fi**. Step into the boots of a hero who can travel through time via mysterious portals—exploring castles, dungeons, and alien landscapes. Level up your skills, master weapons and armor, and carry your hard-earned gear across eras. Every portal opens a new world, but only the clever and skilled will survive and conquer both the past and the future.  

Are you ready to leap through time?

**Time Leap** is a 2D top-down RPG built in Java using **Swing**. The game blends **medieval and sci-fi themes**, allowing players to explore multiple timelines via portals, battle enemies, and level up their character. Weapons and armor can be carried through time if the player has mastered the related skills.

---

## Table of Contents

- [Game Concept](#game-concept)  
- [Features](#features)  
- [Screenshots](#screenshots)  
- [Installation](#installation)  
- [Controls](#controls)  
- [Project Structure](#project-structure)  
- [Future Improvements](#future-improvements)  
- [License](#license)  

---

## Game Concept

In **Time Leap**, players traverse maps that combine medieval and futuristic sci-fi environments. **Portals** allow traveling between time periods. Progression is skill-based: if a player levels up a weapon or armor skill sufficiently, they can carry that equipment across timelines, adding a strategic layer to gameplay.

---

## Features  
(so far)  

- **Tile-based world** with multiple maps and time periods.  
- **Title screen** and smooth game start using `ENTER`.  
- **Player movement** with animated sprites (`WASD`).  
- **Portal system** to switch between medieval and sci-fi maps.  
- **Equipment mastery** allows weapons/armor to persist across timelines.  
- **Game loop** running at 60 FPS for smooth movement.  

---

## Screenshots

![TL_screenshot](https://github.com/user-attachments/assets/459f1eb3-526c-4b64-af3f-92ed77c693b1)

---

## Installation

1. **Clone the repository:**  
    or fork it, ya know?
   
## Controls

- W – Move Up  
- A – Move Left  
- S – Move Down  
- D – Move Right  
- ENTER – Start the game from the title screen  

## Project Structure 
**(Thus Far)**  

TimeLeap/
│  
├─ src/  
│   ├─ main/  
│   │   ├─ Main.java  
│   │   ├─ GamePanel.java  
│   │   └─ KeyHandler.java  
│   ├─ entity/  
│   │   ├─ Entity.java  
│   │   └─ Player.java  
│   └─ tileStart/  
│       ├─ Tile.java  
│       └─ TileManager.java  
│  
├─ res/  
│   ├─ maps/  
│   ├─ gameTiles/  
│   └─ player/  
│  
└─ README.md  

## Future Improvements  

- Add enemies and combat system with time-specific abilities.  
- Inventory system to manage items across timelines.  
- Sound effects and music for immersion.  
- More complex portal mechanics with skill requirements.  
- Save/load system for game progress.  

## License  

- This project is licensed under the MIT License

