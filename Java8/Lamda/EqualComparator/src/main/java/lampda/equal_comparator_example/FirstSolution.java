package lampda.equal_comparator_example;

import lampda.model.Data;
import lampda.model.Employee;
import lampda.model.Output;
import lampda.model.Person;

/**
 * Created by mshalabi on 13.07.17.
 */
public class FirstSolution {

    public static <T> boolean compare(T p1, T p2, Comparator<T> comparator) {
        return comparator.areEqual(p1, p2);
    }

    public static void demo() {
        System.out.println("print Person   -----------------------------------");
        Comparator<Person> function = Comparator.comparing(Person::getAge);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));

        function = (p1, p2) -> p1.getAge().equals(p2.getAge());
        Output.printResult(compare(Data.personOne, Data.personTwo, function));


        function = Comparator.comparing(Person::getFirstName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));

        function = Comparator.comparing(Person::getLastName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));


        System.out.println("print Employee  -------------------------------------------");
        Comparator<Employee> employeeFunction = Comparator.comparing(Employee::getAge);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

        employeeFunction = Comparator.comparing(Employee::getFirstName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

        employeeFunction = Comparator.comparing(Employee::getLastName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

        System.out.println("print  Employee with and -------------------------------------------");
        employeeFunction = Comparator.comparing(Employee::getAge).and(Employee::getFirstName);
        Output.printResult(compare(Data.employeeOne, Data.employeeThree, employeeFunction));
        employeeFunction = Comparator.comparing(Employee::getAge).and(Employee::getLastName);
        Output.printResult(compare(Data.employeeOne, Data.employeeThree, employeeFunction));
        employeeFunction = Comparator.comparing(Employee::getAge).and(Employee::getFirstName).and(Employee::getLastName);
        Output.printResult(compare(Data.employeeOne, Data.employeeThree, employeeFunction));

        System.out.println("print  Employee with or -------------------------------------------");
        employeeFunction = Comparator.comparing(Employee::getAge).or(Employee::getFirstName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction)); //true
        employeeFunction = Comparator.comparing(Employee::getAge).or(Employee::getLastName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));  //false

    }
}
