import java.util.Scanner;
import service.IExpenseService;
import service.impl.ExpenseService;

public class MainApplication {

  public static void main(String[] args) {
    Scanner consola = new Scanner(System.in);
    IExpenseService expenseService = new ExpenseService();
    boolean active = true;
    System.out.println("===Expense Tracker===");
    while (active) {
      System.out.print("> ");
      String opcion = consola.nextLine();
      String[] inputs = opcion.split(" ", 5);
      switch (inputs[0].toLowerCase()) {
        case "add" -> {
          if (inputs[1].equals("--description") && inputs[3].equals("--amount")) {
            String description = inputs[2].replace("\"", "");
            String amount = inputs[4];
            expenseService.saveExpense(description, amount);
          } else {
            System.out.println("es necesario la description y el amount");
          }
          System.out.println("Expense Guardado");
        }
        case "exit" -> active = false;
        default -> System.out.println("Comando no permitido");
      }
    }
  }
}
