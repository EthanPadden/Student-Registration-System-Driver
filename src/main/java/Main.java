
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;

public class Main {
    public static void main( String[] args ) {
        // Create students
        ArrayList< Student > students = new ArrayList< Student >();
        students.add( new Student( 101, "Eric Gilroy", new DateTime( 1999, 3, 4, 0, 0 ) ) );
        students.add( new Student( 102, "Caoimhe Donohoe", new DateTime( 1998, 5, 14, 0, 0 ) ) );
        students.add( new Student( 103, "Jack Kennedy", new DateTime( 1999, 4, 16, 0, 0 ) ) );
        students.add( new Student( 104, "Rachel Griffin", new DateTime( 2000, 11, 21, 0, 0 ) ) );
        students.add( new Student( 105, "Louis Dunleavy", new DateTime( 2001, 9, 5, 0, 0 ) ) );
        students.add( new Student( 106, "Laura Quinlivan", new DateTime( 1998, 7, 8, 0, 0 ) ) );

        // Create modules
        Module algorithms = new Module( "CT215" );
        Module mathematics = new Module( "MA102" );
        Module databases = new Module( "CT216" );
        Module electronics = new Module( "EE304" );

        // Create courses
        Course computerScience = new Course( "CS & IT", new DateTime( 2017, 9, 1, 0, 0 ), new DateTime( 2021, 5, 20, 0, 0 ) );
        Course electronicEngineering = new Course( "ECE", new DateTime( 2016, 9, 1, 0, 0 ), new DateTime( 2020, 5, 20, 0, 0 ) );
        ArrayList<Course> courses = new ArrayList< Course >();
        courses.add( computerScience );
        courses.add( electronicEngineering );

        // Add modules to courses
        computerScience.addModule( algorithms );
        computerScience.addModule( mathematics );
        computerScience.addModule( databases );
        electronicEngineering.addModule( mathematics );
        electronicEngineering.addModule( databases );
        electronicEngineering.addModule( electronics );

        // Add courses to modules
        for ( Module module : computerScience.getModules() ) {
            module.addAssociatedCourse( computerScience );
        }
        for ( Module module : electronicEngineering.getModules() ) {
            module.addAssociatedCourse( electronicEngineering );
        }

        // Add students to courses
        computerScience.addStudent( students.get( 0 ) );
        computerScience.addStudent( students.get( 1 ) );
        computerScience.addStudent( students.get( 2 ) );
        electronicEngineering.addStudent( students.get( 3 ) );
        electronicEngineering.addStudent( students.get( 4 ) );
        electronicEngineering.addStudent( students.get( 5 ) );

        // Add courses to students
        for ( Student student : computerScience.getStudentsEnrolled() ) {
            student.addCourse( computerScience );
        }
        for ( Student student : electronicEngineering.getStudentsEnrolled() ) {
            student.addCourse( electronicEngineering );
        }

        // Add computer science students to computer science modules
        for ( Student student : computerScience.getStudentsEnrolled() ) {
            for ( Module module : computerScience.getModules() ) {
                module.addStudent( student );
            }
        }

        // Add electronic engineering students to electronic engineering modules
        for ( Student student : electronicEngineering.getStudentsEnrolled() ) {
            for ( Module module : electronicEngineering.getModules() ) {
                module.addStudent( student );
            }
        }

        // Output computer science course information
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern( "MM/dd/yyyy" );
        System.out.println( "COURSE INFORMATION" );
        for(Course course : courses) {
            System.out.println(
                    String.format( "Course name: %s\nStart date: %s\nEnd date: %s",
                            course.getName(),
                            dateTimeFormatter.print( course.getStartDate() ),
                            dateTimeFormatter.print( course.getEndDate() )
                    )
            );

            // Output computer science modules
            System.out.println( "Modules:" );
            for ( Module module : course.getModules() ) {
                System.out.println( module.getName() );
            }

            // Print new line
            System.out.println();
        }
    }
}
