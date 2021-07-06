package day0706;

public class Person {
  private String name;
  private int age;
  private int cashAmount;
  private BankAccount account;

  public Person(String pName, int pAge) {
    if (pAge < 0) {
      age = 12;
    } else {
      age = pAge;
    }
    name = pName;
    cashAmount = 0;
  }

  public Person(String pName, int pAge, int pCashAmount) {
    if (pAge < 0) {
      age = 12;
    } else {
      age = pAge;
    }

    if (pCashAmount < 0) {
      cashAmount = 0;
    } else {
      cashAmount = pCashAmount;
    }
    name = pName;
  }

  public void setName(String pName) {
    name = pName;
  }

  public String getName() {
    return name;
  }

  public void setAge(int pAge) {
    age = pAge;
  }

  public int getAge() {
    return age;
  }

  public void setCashAmount(int pCashAmount) {
    cashAmount = pCashAmount;
  }

  public int getCashAmount() {
    return cashAmount;
  }

  public void setAccount(BankAccount pAccount) {
    account = pAccount;
  }

  public BankAccount getAccount() {
    return account;
  }

  public boolean transfer(Person to, int amount) {
    return account.transfer(to.getAccount(), amount);
  }

  public boolean transfer(BankAccount to, int amount) {
    return account.transfer(to, amount);
  }
}