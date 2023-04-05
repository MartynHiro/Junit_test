import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] products = {
                "Diet Pepsi 0,5",
                "Strawberry Donut",     //product array
                "Choco Pie with orange"
        };

        int[] prices = {57, 39, 189}; //price array

        int[] purchases = new int[products.length]; //counts how much money is spent on each product

        int[] counter = new int[products.length]; //counts how many pieces of each product

        int productNumber;
        int productCount;     //variables
        int currentPrice;
        int sum = 0;

        while (true) {
            MethodsShelf.startMessage(products, prices);

            String input = scan.nextLine();

            if ("end".equals(input)) {
                break;
            }

            if (!MethodsShelf.isSpaceSecond(input)) {
                RuntimeException x = new AmountOfInputNumbersException(input);
                MethodsShelf.error(x);
                continue;
            }

            String[] parts = input.split(" ");

            try {
                productNumber = Integer.parseInt(parts[0]) - 1;
                productCount = Integer.parseInt(parts[1]);

                currentPrice = productCount * prices[productNumber];
                sum += currentPrice;
                purchases[productNumber] += currentPrice;
                counter[productNumber] += productCount;

            } catch (Exception x) {
                System.out.println("Вы вводите буквы, а необходимы цифры!!!!!!");
                System.out.println("------------------------------------------");
                continue;
            }

            if (!MethodsShelf.isNumberCorrect(parts[0], parts[1], products)) {
                RuntimeException x = new IncorrectInputNumbersException(input);
                MethodsShelf.error(x);
            }
        }
        MethodsShelf.endMessage(products, counter, prices, purchases, sum);
    }
}