package day0707;

public class Person {
  private String name;
  private int age;
  private int cashAmount;
  private BankAccount account;

  public Person(String name) {
    this(name, 12, 0); // 12살을 기본 나이로 설정, 초기 현금 보유액은 0원.
}

public Person(String name, int age) {
    this(name, age, 0); // 초기 현금 보유액은 0원.
}

public Person(String name, int age, int cashAmount) {
    if (age < 0) {
        this.age = 12;
    } else {
        this.age = age;
    }

    if (cashAmount < 0) {
        this.cashAmount = 0;
    } else {
        this.cashAmount = cashAmount;
    }
    this.name = name;
}

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public void setCashAmount(int cashAmount) {
    this.cashAmount = cashAmount;
  }

  public int getCashAmount() {
    return this.cashAmount;
  }

  public void setAccount(BankAccount account) {
    this.account = account;
  }

  public BankAccount getAccount() {
    return this.account;
  }

  public boolean transfer(Person to, int amount) {
    return this.account.transfer(to.getAccount(), amount);
  }

  public boolean transfer(BankAccount to, int amount) {
    return this.account.transfer(to, amount);
  }
}