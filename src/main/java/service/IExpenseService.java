package service;

import java.util.List;
import model.Expense;

public interface IExpenseService {

  List<Expense> allExpenses();

  void saveExpense(String descripcion, String amount);

  void updateDescription(String id, String description);

  void updateAmount(String id, String amount);

  void deleteExpense(String id);

  Double summary();

  Double summaryByMonth(String month);
}
