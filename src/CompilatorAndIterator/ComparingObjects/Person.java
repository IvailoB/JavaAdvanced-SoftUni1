package CompilatorAndIterator.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        if (this.name.equals(other.getName())) {
            if (this.getAge() == other.getAge()) {
                return this.getTown().compareTo(other.getTown());
            }
            return Integer.compare(this.getAge(), other.getAge());
        }
        return this.getName().compareTo(other.getName());

    }
}
