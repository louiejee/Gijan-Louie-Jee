public class Student {
        private String studentId;
        private String firstName;
        private String middleName;
        private String lastName;
        private String suffix;
        private int age;
        private int yearLevel;
        private Course course;
        private String phoneNumber;
        private String email;

        public Student(String studentId, String firstName, String middleName, String lastName, String suffix,
                       int age, int yearLevel, Course course, String phoneNumber, String email) {
            this.studentId = studentId;
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.suffix = suffix;
            this.age = age;
            this.yearLevel = yearLevel;
            this.course = course;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getStudentId() {
            return studentId;
        }
        
        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getYearLevel() {
            return yearLevel;
        }

        public void setYearLevel(int yearLevel) {
            this.yearLevel = yearLevel;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
