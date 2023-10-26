public class Course {
        private String courseName;
        private String courseCode;
        private String department;

        public Course(String courseName, String courseCode, String department) {
            this.courseName = courseName;
            this.courseCode = courseCode;
            this.department = department;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public String getDepartment() {
            return department;
        }
    }