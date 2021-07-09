package day0707;

public class BankAccount {
  private int balance;
  private Person owner;

  public BankAccount(int balance) {
    if (balance < 0) {
      this.balance = 0;
    } else {
      this.balance = balance;
    }
  }

  public BankAccount(Person owner) {
    this.owner = owner;
    owner.setAccount(this);
    this.balance = 0;
  }

  public BankAccount(int balance, Person owner) {
    if (balance < 0) {
      this.balance = 0;
    } else {
      this.balance = balance;
    }
    this.owner = owner;
  }

  public int getBalance() {
    return this.balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public Person getOwner() {
    return this.owner;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  boolean deposit(int amount) {
    if (amount < 0 || this.owner.getCashAmount() < amount) {
      System.out.println("입금 실패입니다. 잔고: " + this.balance + "원, 현금: " + this.owner.getCashAmount() + "원");
      return false;
    }

    balance += amount;
    this.owner.setCashAmount(this.owner.getCashAmount() - amount);

    System.out.println(amount + "원 입금하였습니다 잔고: " + this.balance + "원, 현금: " + this.owner.getCashAmount() + "원");

    return true;
  }

  boolean withdraw(int amount) {
    if (amount < 0 || amount > this.balance) {
      System.out.println("출금 실패입니다 잔고: " + this.balance + "원, 현금: " + this.owner.getCashAmount() + "원");
      return false;
    }

    this.balance -= amount;
    this.owner.setCashAmount(this.owner.getCashAmount() + amount);

    System.out.println(amount + "원 출금하였습니다 잔고: " + this.balance + "원, 현금: " + owner.getCashAmount() + "원");

    return true;
  }

  public boolean transfer(Person to, int amount) {
    return transfer(to.getAccount(), amount);
  }

  public boolean transfer(BankAccount to, int amount) {
    if (amount < 0 || amount > this.balance) {
      System.out.println("false - from: " + this.owner.getName() + ", to: " + to.owner.getName() + ", amount: " + amount + ", balance: " + this.balance);
      return false;
    } else {
      this.balance -= amount;
      to.balance += amount;
      System.out.println("true - from: " + this.owner.getName() + ", to: " + to.owner.getName() + ", amount: " + amount + ", balance: " + this.balance);
      return true;
    }
  }
}