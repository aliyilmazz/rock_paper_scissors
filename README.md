``````                               __       
                              |  \      
  ______    ______    _______ | $$   __ 
 /      \  /      \  /       \| $$  /  \
|  $$$$$$\|  $$$$$$\|  $$$$$$$| $$_/  $$
| $$   \$$| $$  | $$| $$      | $$   $$ 
| $$      | $$__/ $$| $$_____ | $$$$$$\ 
| $$       \$$    $$ \$$     \| $$  \$$\
 \$$        \$$$$$$   \$$$$$$$ \$$   \$$
                                        

  ______    ______    ______    ______    ______  
 /      \  |      \  /      \  /      \  /      \ 
|  $$$$$$\  \$$$$$$\|  $$$$$$\|  $$$$$$\|  $$$$$$\
| $$  | $$ /      $$| $$  | $$| $$    $$| $$   \$$
| $$__/ $$|  $$$$$$$| $$__/ $$| $$$$$$$$| $$      
| $$    $$ \$$    $$| $$    $$ \$$     \| $$      
| $$$$$$$   \$$$$$$$| $$$$$$$   \$$$$$$$ \$$      
| $$                | $$                          
| $$                | $$                          
 \$$                 \$$                          

                     __                                                   
                    |  \                                                  
  _______   _______  \$$  _______   _______   ______    ______    _______ 
 /       \ /       \|  \ /       \ /       \ /      \  /      \  /       \
|  $$$$$$$|  $$$$$$$| $$|  $$$$$$$|  $$$$$$$|  $$$$$$\|  $$$$$$\|  $$$$$$$
 \$$    \ | $$      | $$ \$$    \  \$$    \ | $$  | $$| $$   \$$ \$$    \ 
 _\$$$$$$\| $$_____ | $$ _\$$$$$$\ _\$$$$$$\| $$__/ $$| $$       _\$$$$$$\
|       $$ \$$     \| $$|       $$|       $$ \$$    $$| $$      |       $$
 \$$$$$$$   \$$$$$$$ \$$ \$$$$$$$  \$$$$$$$   \$$$$$$  \$$       \$$$$$$$                                

``````


October 2021 ®
M. Ali Yilmaz

The repository contains rock paper scissors game.



# Dependencies

* Java 16
* Apache Maven 3.8.3+ 

Throughout the project, I used built-in java libraries with only one exception: JUnit5, which I have registered into `pom.xml`.

# How to run


[0] unzip repository (or clone from my public github page)

```
careers@imc:~/$ git clone git@github.com:aliyilmazz/rock_paper_scissors.git
careers@imc:~/$ OR
careers@imc:~/$ unzip rock_paper_scissors.zip
careers@imc:~/$ cd rock_paper_scissors
careers@imc:~/rock_paper_scissors$
```


[1] install project dependencies, compile the code 

```
careers@imc:~/rock_paper_scissors$ mvn clean install -U
```

[2] run the code
```
careers@imc:~/rock_paper_scissors$ mvn exec:java -Dexec.mainClass="Main"
```



# Before you play:

0. The game contains ascii art, so make sure you are playing in full screen terminal, or a terminal that is big enough to avoid ascii art overflow.
If you play in a small terminal, it's very likely that you will see bargled output and have hard time interacting with UI.


1. Provided that you satisfy #0, all instructions can be found during the gameplay on UI. Available keybinds are displayed in every phase of the game.



# Developer's Read

The game employs layered architecture. The layers are positioned under `game.layers` package.

The three main layers are as follows (from bottom to top):
* Runtime Context Layer (GameRuntimeContext.java): Acts as a dumb container class. Holds the game state. Open for reads and writes coming from upper layers.
* Command Layer (CommandLayer.java): The layer where business takes place. All mutations (user actions and corresponding game state changes) are administered and executed in this layer. This layer utilizes `Command` superclasses. 
* Display Layer (DisplayLayer.java): This layer is responsible from reading from runtime context and rendering the display. This layer utilizes `Overlay` superclasses.  

For more information, see docstrings. The code is thoroughly documented in inline manner.