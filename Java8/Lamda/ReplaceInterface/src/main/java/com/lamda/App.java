package com.lamda;


/**
 * Hello world!
 *
 */
public class App 
{

    interface IGreeting
    {
        String sayHello(String to);
    }
    static void sayHello(String to, IGreeting greeting) {
        String message;
        if(to == null || to.isEmpty())
            message = "Need to pass a TO parameter";
        else
            message = greeting.sayHello(to);

        System.out.println(message);
    }

    interface Hello<Employee>{
        void sayHello(Employee employee);
    }
    static void sayHello(Employee employee, Hello hello) {
        hello.sayHello(employee);
    }


    public static void main( String[] args )
    {
        System.out.println( "This application shows how lamda expression replace a single method interface" );

        sayHello("shalabi", (String to) -> "Hello, " + to);

        IGreeting greeting = (String to) -> "Greeting to " + to;
        sayHello("shalabi", greeting);

        Hello<Employee> hello = (employee) -> System.out.println("Greeting to " + employee.getName());
        Employee employee = new Employee();
        sayHello(employee, hello);

    }
}
