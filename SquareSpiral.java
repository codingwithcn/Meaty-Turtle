// This code is not written by Chidozie, but rather it is an example code, gotten from the turtle documentation http://sites.asmsa.org/java-turtle/tutorial/1-getting-started 
public class SquareSpiral
{
    public static void main(String[] args) 
    {
	Turtle bob = new Turtle();
        for(int i=0;i<360;i++)
        {		
            bob.forward(i*1.25);
            bob.left(90.25);
        }
    }
}