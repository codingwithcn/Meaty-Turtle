import java.util.Random;
// Written by Chidozie
public class Game {
  static private Random random = new Random();
  static Player player;
  static Food food;
  static String direction; // Left, Right, Up, Down
  static int score;

  public Game() {
    player = new Player();

    int new_x = random.nextInt(270);
    int new_y = random.nextInt(270);

    // To randomize the food position while also making sure it is in user view
    while (true) {
      if ((new_x >= -260 && new_x <= 260) && (new_y >= -260 && new_y <= 260)) {
        break;
      } else {
        new_x = random.nextInt(270);
        new_y = random.nextInt(270);
      }
    }
    food = new Food(new_x, new_y);
    direction = "";
    score = 0;
  }

  public String get_method_name(String name) {
    try {
      java.lang.reflect.Method method = this.getClass().getMethod(name);
      return method.getName();
    } catch (SecurityException e) {
      System.out.println(e);
    } catch (NoSuchMethodException e) {
      System.out.println(e);
    }
    return "";
  }

  static public void on_a() {
    direction = "left";
  }

  static public void on_d() {
    direction = "right";
  }

  static public void on_w() {
    direction = "up";
  }

  static public void on_s() {
    direction = "down";
  }

  static public void running() {
    while (true) {
      // Listens for key press by user to switch the direction the turtle is going
      if (Turtle.isKeyDown("a")) {
        on_a();
      }

      if (Turtle.isKeyDown("d")) {
        on_d();
      }

      if (Turtle.isKeyDown("s")) {
        on_s();
      }

      if (Turtle.isKeyDown("w")) {
        on_w();
      }

      // Based on the current direction, it turns the turtle a certain way
      if (direction.equals("left")) {
        player.turnLeft();
      } else if (direction.equals("right")) {
        player.turnRight();
      } else if (direction.equals("up")) {
        player.goUp();
      } else if (direction.equals("down")) {
        player.goDown();
      }

      double[] post = player.getPost();

      // Checks if user is touching view border so it can declare game over
      if (post[0] <= -270) {
        Turtle.exit();
        break;
      }

      if (post[0] >= 270) {
        Turtle.exit();
        break;
      }

      if (post[1] >= 270) {
        Turtle.exit();
        break;
      }

      if (post[1] <= -270) {
        Turtle.exit();
        break;
      }

      double[] food_post = food.getPost();
      // Checks if user is in contact with food, to generate new food and give user
      // their score.
      if (player.is_on_food(food_post[0], food_post[1])) {
        score++;
        System.out.println("You ate the food so your score now is: " + score);
        int new_x = random.nextInt(270);
        int new_y = random.nextInt(270);

        // To randomize the food position while also making sure it is in user view
        while (true) {
          if ((new_x >= -260 && new_x <= 260) && (new_y >= -260 && new_y <= 260)) {
            break;
          } else {
            new_x = random.nextInt(270);
            new_y = random.nextInt(270);
          }
        }

        food.food.hide();
        food = null;
        food = new Food(new_x, new_y);
      }

      // Updates the screen of the turtle
      Turtle.update();
    }
    System.out.println("GAME OVER");
    System.out.println("Your Score: " + score);
  }

  public void run() {
    // Creates thread for game, to continuesly run the backround game events without
    // disrupting the program.
    Thread thread = new Thread(new Runnable() {
      @Override
      // Loop running in thread
      public void run() {
        Game.running();
      }
    });
    thread.start();

  }
}