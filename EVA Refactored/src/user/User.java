package user;

public abstract class User {

    private int id = 0;
    private int authorityLevel;
    //1 to Professor and 2 to Student
    private int cpf;
    private String password = new String();
    private String username = new String();

    private String fullName = new String();
    private String email = new String();
    private int age;

    public String messageBox[][][] = new String[500][500][500];

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }
}
