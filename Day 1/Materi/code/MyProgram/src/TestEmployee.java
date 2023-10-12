public class TestEmployee {
    public static void main(String[] args) {
        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setId(1);
        contractEmployee.setName("Meng");
        contractEmployee.setPay_per_hour(1000000);
        contractEmployee.setContract_period("1 year");

        System.out.println(contractEmployee.getName());
        System.out.println(contractEmployee);
        contractEmployee.work();
    }
}
