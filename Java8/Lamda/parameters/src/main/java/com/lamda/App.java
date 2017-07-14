package com.lamda;


/**
 * Hello world!
 *
 */
public class App 
{

    private Employee badEmployee = new Employee();

    interface Hello<Employee>{
        void sayHello(Employee employee);
    }

    /**
     * notice: this is not a good design example since we can not change the implementation.
     * thus this is not a strategy pattern.
     * void sayHello(Employee employee, Hello hello) is the good method design
     */
    static void sayHello(Employee employee) {
        Hello<Employee> hello = (emp) -> System.out.println("Greeting to " + emp.getName());
        hello.sayHello(employee);
    }

    /**
     * This method shows how the lambda expression uses the notTo which belongs to the function.
     * now this ties that lambda expression to that function.
     * notice also in this case the notTo is final in this case and can not be re-assigned with the function,
     * but can be changed
     * @param employee
     * @param notTo
     */
    static void sayHelloWithFunctionParam(Employee employee, Employee notTo) {
        Hello<Employee> hello = (emp) ->{
                if(employee.getName().equals(notTo.getName()))
                    System.out.println("no hello");
                else  System.out.println("Greeting to " + emp.getName());
        };
        hello.sayHello(employee);

        //notTo = new Employee(); notTo is final or effective final.
        notTo.setName(""); //this is ok
    }

    /**
     * notice that we can change badEmployee
     * @param employee
     */
    void sayHelloObjectParam(Employee employee) {
        Hello<Employee> hello = (emp) -> {
            if(employee.getName().equals(this.badEmployee.getName()))
                System.out.println("no hello");
            else  System.out.println("Greeting to " + emp.getName());

            badEmployee = new Employee();  //we can change badEmployee
        };
        hello.sayHello(employee);

        badEmployee = new Employee();
    }
    public static void main( String[] args )
    {
        System.out.println( "This application shows how lamda expression will be used with parameters in scope." );
        Employee employee = new Employee();
        sayHello(employee);

        Employee notTOEmployee = new Employee();
        sayHelloWithFunctionParam(employee, notTOEmployee);

        new App().sayHelloObjectParam(employee);

    }
}
