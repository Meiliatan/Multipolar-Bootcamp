public class RegularEmployee extends Employee {
    private float salary;
    private int bonus;
    public RegularEmployee(float salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }
    public RegularEmployee(int id, String name,
                           float salary, int bonus) {
        //memanggil constructor superclass (Employee)
        super(id, name);
        this.salary = salary;
        this.bonus = bonus;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}