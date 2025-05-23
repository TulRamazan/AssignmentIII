public class MyTestingClass {
     int id;
     String name;
    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + id;
        for (char c : name.toCharArray()) {
            hash = 31 * hash + c;
        }
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return id == that.id && name.equals(that.name);
    }
    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }
}
