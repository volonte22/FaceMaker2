import java.util.Random;

public class Face {
    //initalizing variables
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    //inital constructor
    public Face(int skin, int eye, int hair, int style) {
        this.skinColor = skin;
        this.eyeColor = eye;
        this.hairColor = hair;
        this.hairStyle = style;
    }

    //randomize function, randomly assigns an int value to the instance variables
    public void randomize(){
        Random random = new Random();
        int upper = 100;
        this.skinColor = random.nextInt(256);
        this.eyeColor = random.nextInt(256);
        this.hairColor = random.nextInt(256);
        this.hairStyle = random.nextInt(3);
    }

}
