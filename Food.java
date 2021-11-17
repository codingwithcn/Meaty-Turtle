// Written by Chidozie
public class Food {
  Turtle food;
  public Food(double x, double y) {
    this.food = new Turtle(x, y);
    this.food.shape("1988572.png");
    this.food.shapeSize(25, 25);
  }

  public double[] getPost(){
    double[] arr =  {this.food.getX(), this.food.getY()};
    return arr;
  }

}