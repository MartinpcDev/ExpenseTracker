import java.time.Month;
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
      active = getOpcions(consola, expenseService);
    }
  }

  private static boolean getOpcions(Scanner consola, IExpenseService expenseService) {
    boolean active = true;
    System.out.print("> ");
    String opcion = consola.nextLine();
    String[] inputs = opcion.split(" ", 5);
    switch (inputs[0].toLowerCase()) {
      case "add" -> {
        if (inputs[1].equals("--description") && inputs[3].equals("--amount")) {
          String description = inputs[2].replace("\"", "");
          String amount = inputs[4];
          expenseService.saveExpense(description, amount);
          System.out.println("Expense Guardado");
        } else {
          System.out.println("es necesario la description y el amount");
        }
      }
      case "list" -> {
        System.out.printf("%-5s %-10s %-15s %s%n", "ID", "Description", "Amount", "CreatedAt");
        expenseService.allExpenses()
            .forEach(
                e -> System.out.printf("%-5s %-10s %-15s %s%n", e.getId(), e.getDescription(),
                    e.getAmount(), e.getCreatedAt()));
      }
      case "summary" -> {
        if (inputs[1].equals("--month")) {
          System.out.println("Summary de " + Month.of(Integer.parseInt(inputs[2])) + " : "
              + expenseService.summaryByMonth(inputs[2]));
        }
        if (inputs[1].equals("--all")) {
          System.out.println("Summary: " + expenseService.summary());
        }
      }
      case "delete" -> {
        if (inputs[1].equals("--id")) {
          expenseService.deleteExpense(inputs[2]);
          System.out.println("Expense eliminado correctamente");
        } else {
          System.out.println("Debe ingresar --id para buscar por id");
        }
      }
      case "update" -> {
        if (inputs[1].equals("--id")) {
          if (inputs[3].equals("--description")) {
            expenseService.updateDescription(inputs[2], inputs[4].replace("\"", ""));
            System.out.println("Description Actualizada");
          }
          if (inputs[3].equals("--amount")) {
            expenseService.updateAmount(inputs[2], inputs[4]);
            System.out.println("Amount Actualizada");
          }
        } else {
          System.out.println("Debe ingresar --id para buscar por id");
        }
      }
      case "exit" -> active = false;
      default -> System.out.println("Comando no permitido");
    }
    return active;
  }
}
