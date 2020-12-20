package EulerMethod;

public class Main {

    public static void main(String[] args)
    {
        EulerMethodClass eulerMethodClass = new EulerMethodClass();
        // ScalarFunction function = (double x) -> -2*Math.pow(x,3)+12*Math.pow(x,2)-20*x+8.5;
        // ScalarFunction functionD = (double x) -> -0.75*Math.pow(x,2)+3*Math.pow(x,1)-2.5;
        eulerMethodClass.eulerMethod((double x) -> -2*Math.pow(x,3)+12*Math.pow(x,2)-20*x+8.5,(double x) ->-0.5*Math.pow(x,4)+4*Math.pow(x,3)-10*Math.pow(x,2)+8.5*x+1,0.01,0,5);
    }
}
