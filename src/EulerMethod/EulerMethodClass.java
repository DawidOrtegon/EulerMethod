package EulerMethod;

public class EulerMethodClass
{
    public void eulerMethod(ScalarFunction function, ScalarFunction trueFunction,double h, double begin, double end)
    {
        double numElements = ((end - begin)/h)+1;
        double [] xTrue = new double[(int) numElements];
        double [] xEuler = new double [(int) numElements];
        int iterator = 0;
        double globalError = 0;
        double localError = 0;
        double step = h;
        System.out.printf("%15s %15s %15s %15s %15s%n","t","xTrue", "xEuler", "Global Error", "Local Error");

        do
            {
                if(iterator == 0)
                {
                    xTrue[iterator] = trueFunction.functionValue(begin);
                    xEuler[iterator] = xTrue[iterator];
                    step = 0;
                    System.out.printf("%15g %15g %15g %15g %15g%n",step,xTrue[iterator], xEuler[iterator], globalError, localError);
                    iterator++;
                }

                if (iterator >= 1)
                {
                    // At the beginning to ensure that the function value receives the good argument.
                    begin+=h;
                    xTrue[iterator] = trueFunction.functionValue(begin);
                    xEuler[iterator] = xEuler[iterator-1] + (function.functionValue(begin-h) * h);
                    globalError = Math.abs(((xTrue[iterator] - xEuler[iterator])/xTrue[iterator])*100);
                    // It was added an absolute value to ensure that the subtraction is not an addition in the local error.
                    localError = Math.abs(((xEuler[iterator]-xTrue[iterator]-(Math.abs(xTrue[iterator-1]-xEuler[iterator-1])))/xTrue[iterator])*100);
                    step += h;
                    System.out.printf("%15g %15g %15g %15g %15g%n",step,xTrue[iterator], xEuler[iterator], globalError, localError);
                    // At the end, otherwise will report the wrong value in the previous command.
                    iterator++;
                }

                if (iterator == numElements)
                {
                    break;
                }

            }
        while(iterator <= numElements);
    }
}
