public class ContractEmployee extends Employee implements Employable{
    private float pay_per_hour;
    private String contract_period;

    public ContractEmployee(){
    }

    public ContractEmployee(int id, String name, float pay_per_hour, String contract_period) {
        super(id,name);
        this.pay_per_hour = pay_per_hour;
        this.contract_period = contract_period;
    }

    public float getPay_per_hour() {
        return pay_per_hour;
    }

    public void setPay_per_hour(float pay_per_hour) {
        this.pay_per_hour = pay_per_hour;
    }

    public String getContract_period() {
        return contract_period;
    }

    public void setContract_period(String contract_period) {
        this.contract_period = contract_period;
    }


    @Override
    public String toString() {
        return "ContractEmployee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", pay_per_hour=" + pay_per_hour +
                ", contract_period='" + contract_period + '\'' +
                '}';
    }

    @Override
    public void work() {
        System.out.println("Tugasnya");
    }

}
