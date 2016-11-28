package Stack;

/**
 * Created by Aleksey Zhulanov on 26.10.2016.
 */

public class Stack {
    int stck[] = new int[10];
    int tos;

    Stack() {
        tos = -1;
    }

    void push(int item) {
        if (tos == 9) {
            System.out.print("Стек перполнен");
        } else {
            stck[++tos] = item;
        }
    }

    int pop() {
        if (tos < 0) {
            System.out.print("Стек пуст");
            return 0;
        } else {
            return stck[tos--];
                }
        }
    }

    class TestStack {
        public static void main (String[] args){
            Stack myStack1 = new Stack();
            Stack myStack2 = new Stack();

            //Add numbers is Stack
            for (int i=0; i <10; i++) myStack1.push(i);
            for (int i=10; i <20; i++) myStack2.push(i);

            //Pul the numbers from the Stack
            System.out.println("Числа в стеке:");
            for (int i=0; i <10; i++)
            System.out.print(myStack1.pop());

            //Pul the numbers from the Stack
            System.out.println("Числа в стеке 2:");
            for (int i=0; i <10; i++)
            System.out.print(myStack2.pop());
        }
    }

