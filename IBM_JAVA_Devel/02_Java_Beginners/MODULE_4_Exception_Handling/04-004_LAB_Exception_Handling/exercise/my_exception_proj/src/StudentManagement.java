/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 4 > 04-004 'Exception Handling'
 * 
 * 03 - CHECKED EXCEPTIONS
 * 
 * Student Management: 
 *  Student CLass implementing CLONE (clonEable) interface
 *  Errors Expected:
 *      - error: unreported exception CloneNotSupportedException;
 * 
 * - Then, add USER-DEFINED StudentUnderAgeException handler through 'throws - exteneds' & StudentUnderAgeException class
 * 
 * - Finally, add USER-DEFINED Invalid name Exception handler > InvalidNameException class
*/


import java.util.Scanner;

class Student implements Cloneable {

    // 1. Init fields
    // As PRIVATE elements, this scope, inner
    private String name;
    private int age;
    private String major;


    // 2. Constructor
    // As PUBLIC, as it's accessed by "all", in order to create instances of Student
    // Part 2, Add StudentUnderAge user-defined exception
    public Student(String name, int age, String major) throws InvalidNameException, StudentUnderAgeException {

        String allowedRegexString = "^[a-zA-Z' áéíóúÁÉÍÓÚ.,ëïËÏ -]+$";

        if (!name.matches(allowedRegexString)) { 

            throw new InvalidNameException("User-Defined Exc. Handling -> InvalidNameException] -> Sorry, NAME value MUST follow alphanumeric a-Z/A-Z/0-9 pattern");
        }
        this.name = name;

        if ( age < 18) {

            throw new StudentUnderAgeException("[User-Defined Exc. Handling -> StudentUnderAgeException] Sorry, student's age must be above 18!");
        }
        this.age = age;

        this.major = major;

    }

    // 3. GETTER / SETTER
    // As PUBLIC AGAIN -  Get/Set for each this vars
    /*
     * === GETTERs ===
     * public <DataType> get<Varname>() {
     *      return <Varname>;
     * }
     * 
     * === SETTERs ===
     * public void set<Varname>(DataType <varname>) {
     *     this.<varname> = <varname> 
     * }
     * 
     * 
     */
    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {

        return age;

    }

    public void setAge(int age){

        this.age = age;

    }

    public String getMajor(){

        return major;

    }

    public void setMajor(String major) {

        this.major = major;

    }


    // @override toString() -> RETURNS String REPRESENTATION OF AN OBJECT
    /*
     * @Override
     * [visibility] DataType method(){
     * 
     *      return <return, what need to be overridden> 
     * 
     * }
     */
    @Override
    public String toString() {

        return "Student [name = " + name + ", age = " + age + ", major = " + major + "]";

    }

    // @override clone() -> Support cloning
    @Override
    public Student clone() throws CloneNotSupportedException {

        // Invokes clone() method of the main Java Object class
        return (Student) super.clone();
    }

}

// MAIN CLASS
public class StudentManagement {

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Part 2 - Try - catch (captures CloneNotSupportedException)
        try {

            System.out.println("   - (1) Enter new Student Name: ");
            String name = sc.nextLine();

            System.out.println("   - (2) Enter new Student Age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.println("   - (3) Enter new Student Major: ");
            String major = sc.nextLine();



            // Init 
            // Create Student object
            Student studentOriginal = new Student(name, age, major);
            Student studentCloned = studentOriginal.clone();

            System.out.println("Student Original: " + studentOriginal + "succesfully created!");
            System.out.println("Student Cloned: " + studentCloned + " succesfully created!");




            // Print both opriginal and cloned after edit
            System.out.println("\n - ORIGINAL STUDENT (after edits; same): " + studentOriginal);
            System.out.println("\n - CLONED STUDENT (after edits; modified): " + studentCloned);


        } catch (CloneNotSupportedException cnse) {

            System.out.println(" [CHECKED -> CNSE Handling] - You cannot clone this object!");

        } catch (InvalidNameException ine) {

            System.out.println(" [CHECKED -> INE Handling] - Student name MUST follow [a-zA-Z -]+$  regex pattern");

        } catch (NumberFormatException nfe) {

            System.out.println(" [CHECKED -> NumberFormatExc Handling] - Age must be a numeric value! (an Integer!)");

        // Also, added  catch StudentUnderAgeException 
        } catch (StudentUnderAgeException suae) {

            System.out.println(suae.getMessage());
        
        
        } finally {
            
            sc.close();
        }
    }

}