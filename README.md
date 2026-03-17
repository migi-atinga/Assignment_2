# University Department System

## Project Description
This is a university management system i made for my OOP class. It lets you manage a department by adding courses lecturers and students. You can also assign lecturers to courses and calculate payroll.

## How to Run
1. Run the program: java university.Main
2. Follow the prompts to enter data

## What the Program Does
- Creates a department (you enter the name)
- Adds courses with course code name and credit units
- Adds lecturers with ID name email salary and subject
- Adds students with ID name email course and year
- Assigns lecturers to courses
- Displays all information at the end
- Calculates total monthly payroll

## Classes in the Project
- **Person** (abstract) - parent class for Student and Lecturer
- **Student** - inherits from Person has course and year
- **Lecturer** - inherits from Person has salary and subject implements Payable and Teachable
- **Course** - has course code name credits and assigned lecturer
- **Department** - holds lists of courses lecturers and students
- **Payable** (interface) - has calculatePay method
- **Teachable** (interface) - has teach and getSubject methods
- **Main** - runs the program with user input

## Exceptions Handled

### 1. InputMismatchException
Happens when user enters letters instead of numbers. Example typing "five" instead of 5 for number of courses.
- Caught in course lecturer and student input sections
- Program shows error message and continues

### 2. IllegalArgumentException
Used when student year is not between 1 and 4.
- If user enters year 5 or 0 this exception is thrown
- Shows message "year must be between 1 and 4"

### 3. IndexOutOfBoundsException
Happens when user selects a course or lecturer number that doesnt exist.
- Example choosing course number 10 when only 3 courses exist
- Caught in assignment section
- Program lets user try again for next assignment

### 4. NullPointerException
Handled in teaching session section.
- If a lecturer has no subject assigned
- Program shows friendly message instead of crashing

### 5. Exception (general)
Used in payroll calculation as a backup.
- Catches any unexpected errors
- Finally block shows that payroll calculation was attempted

## Try-Catch-Finally Example
In the payroll section: 

try {
// calculate payroll
} catch (Exception e) {
// handle error
} finally {
// this always runs
}
text


## Sample Input/Output
When you run the program you will see prompts like:

---CREATE DEPARTMENT---
enter department name: Computer Science

---ADD COURSES---
how many courses do you want to add? 2

enter details for Course 1:
course Code (e.g., CS101): CS101
course Name: Java Programming
credit Units: 4
text

