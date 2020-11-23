
import org.joda.time.DateTime;

public class Main {
    public static void main( String[] args ) {
        // Create students
        Student student1 = new Student( 101, "Eric Gilroy", new DateTime( 1999, 3, 4, 0, 0 ) );
        Student student2 = new Student( 102, "Caoimhe Donohoe", new DateTime( 1998, 5, 14, 0, 0 ) );
        Student student3 = new Student( 103, "Jack Kennedy", new DateTime( 1999, 4, 16, 0, 0 ) );
        Student student4 = new Student( 104, "Rachel Griffin", new DateTime( 2000, 11, 21, 0, 0 ) );
        Student student5 = new Student( 105, "Louis Dunleavy", new DateTime( 2001, 9, 5, 0, 0 ) );
        Student student6 = new Student( 106, "Laura Quinlivan", new DateTime( 1998, 7, 8, 0, 0 ) );

        // Create modules
        Module algorithms = new Module( "CT215" );
        Module mathematics = new Module( "MA102" );
        Module databases = new Module( "CT216" );
        Module electronics = new Module( "EE304" );

        // Create courses
        final Course computerScience = new Course( "CS & IT", new DateTime(2017, 9, 1,0,0), new DateTime(2021, 5, 20,0,0));
        Course electronicEngineering = new Course( "ECE", new DateTime(2016, 9, 1,0,0), new DateTime(2020, 5, 20,0,0));

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
        computerScience.addStudent( student1 );
        computerScience.addStudent( student2 );
        computerScience.addStudent( student3 );
        electronicEngineering.addStudent( student4 );
        electronicEngineering.addStudent( student5 );
        electronicEngineering.addStudent( student6 );

        // Add courses to students
        for (Student student: computerScience.getStudentsEnrolled()) {
            student.addCourse( computerScience );
        }
        for (Student student: electronicEngineering.getStudentsEnrolled()) {
            student.addCourse( electronicEngineering );
        }

        // Add computer science students to computer science modules
        for (Student student: computerScience.getStudentsEnrolled()) {
            for ( Module module: computerScience.getModules()) {
                module.addStudent( student );
            }
        }

        // Add electronic engineering students to electronic engineering modules
        for (Student student: electronicEngineering.getStudentsEnrolled()) {
            for ( Module module: electronicEngineering.getModules()) {
                module.addStudent( student );
            }
        }
    }
}
