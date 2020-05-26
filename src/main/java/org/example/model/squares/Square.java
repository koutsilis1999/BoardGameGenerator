package org.example.model.squares;


import org.example.games.Game;

public interface Square {
    //na ginei abstract kai na exoume ena String gia ola ?
    void action(Game game);
    String getMessage();

}
