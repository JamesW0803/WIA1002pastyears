package twozeroonesix;

import java.util.Scanner;

public class Day {
    private static final String[] DAY_OF_THE_WEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private final int dayNumber;
    public Day(int dayNumber){
        this.dayNumber = dayNumber;
    }

    public String getFullName(){
        return DAY_OF_THE_WEEK[dayNumber - 1];
    }

    public String getNextDay(){
        int nextDayNumber = (dayNumber % 7) + 1;
        return DAY_OF_THE_WEEK[nextDayNumber - 1];
    }

    public String getPreviousDay(){
        int previousDayNumber = (dayNumber - 2 + 7) % 7 + 1;
        return DAY_OF_THE_WEEK[previousDayNumber - 1];
    }

    public String addDays(int numDays){
        int futureDayNumber = (dayNumber - 1 + numDays) % 7 + 1;
        return DAY_OF_THE_WEEK[futureDayNumber - 1];
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println("Specify your day in number:");
        System.out.println("1 for Monday");
        System.out.println("2 for Tuesday");
        System.out.println("3 for Wednesday");
        System.out.println("4 for Thursday");
        System.out.println("5 for Friday");
        System.out.println("6 for Saturday");
        System.out.println("7 for Sunday");

        Scanner sc = new Scanner(System.in);
        int dayNumber;

        do{
            while(!sc.hasNextInt()){
                System.out.println("Invalid input. Please enter an integer range from 1 to 7");
                sc.next();
            }
            dayNumber = sc.nextInt();
        }while (dayNumber < 1 || dayNumber > 7);

        Day day = new Day(dayNumber);
        System.out.println("The name of the day is: " + day.getFullName());
        System.out.println("The following day of " + day.getFullName() + " is: " + day.getNextDay());
        System.out.println("The previous day of " + day.getFullName() + " is: " + day.getPreviousDay());

        int numDays;
        do{
            System.out.println("How many days to add to the specified/current day (" + day.getFullName() + ")? :");
            while (!sc.hasNextInt()){
                System.out.println("Invalid input. Please enter a positive integer.");
                sc.next();
            }
            numDays = sc.nextInt();
        }while (numDays <= 0);

        String futureDay = day.addDays(numDays);
        System.out.println("The new day after the addition of " + numDays + " day(s) is : " + futureDay);
    }
}
