package service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import model.Expense;
import service.IExpenseService;

public class ExpenseService implements IExpenseService {

  private List<Expense> expenses = new ArrayList<>();
  private static final String FILE_PATH = "src/main/resources/expenses.txt";

  public ExpenseService() {
    this.expenses = loadExpenses();
  }

  private List<Expense> loadExpenses() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
      String line = reader.readLine();
      while (line != null) {
        expenses.add(Expense.fromTxt(line));
        line = reader.readLine();
      }
    } catch (IOException e) {
      System.out.println("No se pudo cargar el archivo: " + e.getMessage());
    }
    return expenses;
  }

  private void saveExpenses() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
      for (Expense expense : expenses) {
        writer.write(expense.toString());
        writer.newLine();
      }
      loadExpenses();
      writer.close();
    } catch (IOException e) {
      System.out.println("No se pudo guardar el archivo: " + e.getMessage());
    }
  }

  @Override
  public List<Expense> allExpenses() {
    return expenses;
  }

  @Override
  public void saveExpense(String descripcion, String amount) {
    int id = expenses.size() + 1;
    int finalId = id;

    Optional<Expense> expenseOptional = expenses.stream()
        .filter(expense -> Objects.equals(expense.getId(), finalId)).findFirst();

    if (expenseOptional.isPresent()) {
      id++;
    }
    Expense expense = new Expense(id, descripcion, Double.parseDouble(amount));
    expenses.add(expense);
    saveExpenses();
  }

  @Override
  public void updateDescription(String id, String description) {

  }

  @Override
  public void updateAmount(String id, String amount) {

  }

  @Override
  public void deleteExpense(String id) {

  }

  @Override
  public Double summary() {
    return 0.0;
  }

  @Override
  public Double summaryByMonth(String month) {
    return 0.0;
  }
}
