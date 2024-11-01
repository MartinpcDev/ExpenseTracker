package model;

import java.time.LocalDate;

public class Expense {

  private Integer id;
  private String description;
  private Double amount;
  private LocalDate createdAt;

  public Expense(Integer id, String description, Double amount) {
    this.id = id;
    this.description = description;
    this.amount = amount;
    this.createdAt = LocalDate.now();
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return this.id + ";" + this.description + ";" + this.amount + ";" + this.createdAt;
  }

  public static Expense fromTxt(String expenseTxt) {
    String[] parts = expenseTxt.split(";");
    Expense expense = new Expense(Integer.parseInt(parts[0]), parts[1],
        Double.parseDouble(parts[2]));
    expense.setCreatedAt(LocalDate.parse(parts[3]));
    return expense;
  }
}
