// Written by Chidozie
public class Player {
  Turtle player;
  public Player(double x, double y){
    this.player =  new Turtle(x, y);
  }

  public Player(){
    this.player = new Turtle();
    this.player.up();
  }

  public void turnRight(){
    double turnAngle  = this.player.towards(this.player.getX()+5,this.player.getY())+this.player.getDirection();

    this.player.left(turnAngle);

    double dist=this.player.distance(this.player.getX()+5,this.player.getY());

    this.player.forward(dist);
  }
  
  public void turnLeft(){
    double turnAngle  = this.player.towards(this.player.getX()-5,this.player.getY())-this.player.getDirection();

    this.player.left(turnAngle);

    double dist=this.player.distance(this.player.getX()-5,this.player.getY());
    
    this.player.forward(dist);
  }

  public void goUp(){
    double turnAngle  = this.player.towards(this.player.getX(),this.player.getY()+5)-this.player.getDirection();

    this.player.left(turnAngle);

    double dist=this.player.distance(this.player.getX(),this.player.getY()+5);
    
    this.player.forward(dist);
  }

  public void goDown(){
    double turnAngle  = this.player.towards(this.player.getX(),this.player.getY()-5)+this.player.getDirection();

    this.player.left(turnAngle);

    double dist=this.player.distance(this.player.getX(),this.player.getY()-5);
    
    this.player.backward(dist);
  }

  public double[] getPost(){
    double[] arr =  {this.player.getX(), this.player.getY()};
    return arr;
  }
  
  public boolean is_on_food(double x, double y){
    return this.player.distance(x, y) <= 10.0;
  }
}