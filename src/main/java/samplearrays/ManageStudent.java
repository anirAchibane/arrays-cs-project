package samplearrays;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students){
        Student max = new Student(0,"");
        int maxVar = 0;
        for(Student stud: students){
            if (stud.age > maxVar){
                maxVar = stud.age;
                max = stud;
            }
        }
        return max;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students){
        int count = 0;
        for(Student stud: students){
            if (stud.isAdult()){
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students){
        if (students.length == 0){
            return null;
        }
        else{
            double avg = 0.0;
            for(Student stud: students){
                avg += stud.grade;
            }
            return avg / (double) students.length;
        }
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findByName(String name, Student[] students){
        for (Student stud: students){
            if (Objects.equals(stud.name, name)){
                return stud;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortBygrade(Student[] students){
        Arrays.sort(students,(stud1, stud2) -> Integer.compare(stud1.grade, stud2.grade));
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student student: students){
            if (student.getGrade() >= 15){
                System.out.println(student);
            }
        }

    }

    // 8) Update Student Grade by id
    public static void updateGrade(Student[] students,int id, int newGrade){
        for (Student stud: students){
            if (stud.id == id){
                stud.grade = newGrade;
                System.out.println("Updated grade of student " + id);
                return;
            }
        }
        System.out.println("Invalid: Couldn't find student " + id + " in array");
    }

    // 9) Find Duplicate Names
    public static void duplicateNamesCheck(Student[] students){
        HashSet<String> uniqueNames = new HashSet<>();

        for(Student stud: students){
            if (uniqueNames.contains(stud.name)){
                System.out.println("Duplicates found: " + stud.name + " !!");
                return;
            }
            else{
                uniqueNames.add(stud.name);
            }
        }
        System.out.println("Duplicates not found!");
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] expand(Student[] students, Student newStudent){
        Student[] newArray = Arrays.copyOf(students, students.length + 1);
        newArray[students.length] = newStudent;
        return  newArray;
    }

        // Exercise 4:
    public static void main(String[] args){
        // 1) array of 5 students:
        Student[] array = new Student[5];
        array[0] = new Student(0, "student1");
        array[1] = new Student(1, "student2", 17);
        array[2] = new Student(2, "student3", 20, 20);
        array[3] = new Student(3, "student4", 19, 14);
        array[4] = new Student(4, "student1", 21, 16);

        System.out.println("Array of 5 students:");
        for(Student stud: array){
            System.out.println(stud);
        }
        System.out.println("-------------------------------");

        // 2) Oldest student:
        System.out.println("Oldest student: "+ManageStudent.findOldest(array));

        System.out.println("-------------------------------");
        // 3) countAdults:
        System.out.println("Number of adults: " +ManageStudent.countAdults(array));
        System.out.println("-------------------------------");
        // 4) averageGrade:
        System.out.println("Average grade: "+ ManageStudent.averageGrade(array));
        System.out.println("-------------------------------");
        // 5) search by name:
        System.out.println("finding student1: " +ManageStudent.findByName("student1",array));
        System.out.println("finding student8: " +ManageStudent.findByName("student8",array));
        System.out.println("-------------------------------");
        // 6) sort by grade:
        ManageStudent.sortBygrade(array);
        System.out.println("Array after sorting by grade: ");
        for(Student stud: array){
            System.out.println(stud);
        }
        System.out.println("-------------------------------");
        // 7) High Achievers:
        System.out.println("High Achievers in array: ");

        ManageStudent.printHighAchievers(array);
        
        System.out.println("-------------------------------");
        // 8) Update student grade:
        ManageStudent.updateGrade(array,0,13);
        ManageStudent.updateGrade(array,8,15);
        System.out.println("-------------------------------");
        // 9) Duplicate names:
        ManageStudent.duplicateNamesCheck(array);
        System.out.println("-------------------------------");
        // 10) Expandable array:
        array = ManageStudent.expand(array, new Student(5, "newStudent", 20,20));
        System.out.println("Array after expanding: ");
        for(Student stud: array){
            System.out.println(stud);
        }
        System.out.println("-------------------------------");
        // 11) 2d students array:
            // Creating the 2d array
        Student[][] classes = new Student[2][3];
            // filling array
        Random random = new Random();

        for (int i = 0; i < classes.length; i++){
            for(int j = 0; j < classes[0].length; j++){
                classes[i][j] = new Student(3*i + j, "student" + i + j, 18, random.nextInt(21) );
            }
        }
            // Displaying classes:
        for (int i = 0; i < classes.length; i++){
            System.out.println("Class " + (i + 1)+" : ");
            for (int j = 0; j < classes[0].length; j++){
                System.out.println(classes[i][j]);
            }
        }
            // Top student of each class:
        for(int i = 0; i < classes.length; i++){
            ManageStudent.sortBygrade(classes[i]);
        }
        for(int i = 0; i < classes.length; i++){
            System.out.println("Best student of class " + i +": " + classes[i][classes[i].length-1]);
        }

    }
}

