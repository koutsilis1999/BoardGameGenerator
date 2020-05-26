package org.example.model.squares;


        import com.fasterxml.jackson.annotation.JsonIgnore;
        import org.example.games.Game;

public  class SimpleSquare implements Square {

    public SimpleSquare(){

    }

    public  void action(Game game){}

    @JsonIgnore
    @Override
    public String getMessage() {
        return "";
    }

}
