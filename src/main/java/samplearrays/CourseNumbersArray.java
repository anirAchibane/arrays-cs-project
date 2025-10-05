package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        // Initializing variables
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int newCourse = 1034;

        // Creating updatedCourses: a copy of registeredCourses with a bigger length
        int[] updatedCourses = Arrays.copyOf(registeredCourses, registeredCourses.length + 1);

        // Adding the new course to updatedCourses
        updatedCourses[registeredCourses.length] = newCourse;

        // displaying updatedCourses
        System.out.println("Updated_list = {");
        for(int i = 0; i < updatedCourses.length; i++){
            System.out.println(updatedCourses[i] + ",");
        }
        System.out.println(" }");

        // Checks if updatedCourses contains course number 1000
        int numberToFind = 1000;
        for(int i = 0; i < updatedCourses.length; i++){
            if (updatedCourses[i] == numberToFind){
                System.out.println("Number Found at index: " + i + " !!");
                break;
            }
            else if (i == updatedCourses.length-1){
                System.out.println("Number not found!");
            }
        }
    }
}
