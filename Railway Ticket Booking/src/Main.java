import java.util.Scanner;
public class Main {
    public static void bookTicket(Passenger p) {
        BookTicket bt = new BookTicket();
        if (BookTicket.aWL == 0) {
            System.out.println("No Tickets Available");
        } else if (p.age > 60 && BookTicket.aLB > 0) {
            System.out.println("You are a senior citizen, so we arrange a lower berth");
            bt.bookTicket(p, (BookTicket.lBP.get(0)), "L");
            BookTicket.lBP.remove(0);
            BookTicket.aLB--;
        }
        //--------Berths--------
        else if ((p.bp.equals("L") && BookTicket.aLB > 0)
                || (p.bp.equals("M") && BookTicket.aMB > 0)
                || (p.bp.equals("U") && BookTicket.aUB > 0)) {
            if (p.bp.equals("L")) {
                System.out.println("Lower Berth Given");
                bt.bookTicket(p, (BookTicket.lBP.get(0)), "L");
                BookTicket.lBP.remove(0);
                BookTicket.aLB--;
            } else if (p.bp.equals("M")) {
                System.out.println("Middle Berth Given");
                bt.bookTicket(p, (BookTicket.mBP.get(0)), "M");
                BookTicket.mBP.remove(0);
                BookTicket.aMB--;
            } else if (p.bp.equals("L")) {
                System.out.println("Upper Berth Given");
                bt.bookTicket(p, (BookTicket.uBP.get(0)), "U");
                BookTicket.uBP.remove(0);
                BookTicket.aUB--;
            }
        } else if (BookTicket.aLB > 0) {
            System.out.println("Lower Berth Given");
            bt.bookTicket(p, (BookTicket.lBP.get(0)), "L");
            BookTicket.lBP.remove(0);
            BookTicket.aLB--;
        } else if (BookTicket.aMB > 0) {
            System.out.println("Middle Berth Given");
            bt.bookTicket(p, (BookTicket.mBP.get(0)), "M");
            BookTicket.mBP.remove(0);
            BookTicket.aMB--;
        } else if (BookTicket.aUB > 0) {
            System.out.println("Upper Berth Given");
            bt.bookTicket(p, (BookTicket.uBP.get(0)), "U");
            BookTicket.uBP.remove(0);
            BookTicket.aUB--;
        } else if (BookTicket.aRAC > 0) {
            System.out.println("RAC Given");
            bt.racTicket(p, (BookTicket.racP.get(0)), "RAC");
            BookTicket.racP.remove(0);
            BookTicket.aRAC--;
        } else if (BookTicket.aWL > 0) {
            System.out.println("Waiting List is Given");
            bt.waitingListTicket(p, (BookTicket.wlP.get(0)), "WL");
            BookTicket.wlP.remove(0);
            BookTicket.aWL--;
        }
    }
        public static void cancelTicket(int id){
            BookTicket bt=new BookTicket();
            if(!bt.data.containsKey(id)){
                System.out.println("Passenger ID is not Found....!");
            }
            else {
                bt.cancelTicket(id);
            }
        }

    public static void main(String[] args) {
        boolean loop=true;
        Scanner sc=new Scanner(System.in);
        while(loop){
            System.out.println("1.Book\n2.Cancel\n3.Available Tickets\n4.Passenger Details\n5.Exit");
            int choice=sc.nextInt();
            switch (choice){
                case 1: {
                    System.out.println("Enter the passenger Name :");
                    String name = sc.next();
                    System.out.println("Enter the passenger Age :");
                    int age = sc.nextInt();
                    System.out.println("Enter the Gender of the passenger : [M ,F]");
                    String gender = sc.next();
                    if (gender.equals("F")) {
                        System.out.println("If you have a child press 1, otherwise press 2");
                        int gchoice = sc.nextInt();
                        if (gchoice == 1) {
                            System.out.println("Enter Your Child Name : ");
                            String cname = sc.next();
                            System.out.println("Enter Your Child Age : ");
                            int cage = sc.nextInt();
                            if (cage <= 5) {
                                System.out.println("No need to book an extra ticket for your children");
                            }
                            System.out.println("Enter Passenger Berth Preference [L,M,U] : ");
                            String bp = sc.next();
                            Passenger p = new Passenger(name, age, gender, cname, cage, bp);
                            bookTicket(p);
                        } else if (gchoice == 2) {
                            System.out.println("Enter the passenger berth preference [L,M,U] : ");
                            String bp = sc.next();
                            String cname = "null";
                            int cage = 0;
                            Passenger p = new Passenger(name, age, gender, cname, cage, bp);
                            bookTicket(p);
                        }
                    }
                    if (gender.equals("M")) {
                        System.out.println("Enter the passenger berth preference [L,M,U] : ");
                        String bp = sc.next();
                        String cname = "null";
                        int cage = 0;
                        Passenger p = new Passenger(name, age, gender, cname, cage, bp);
                        bookTicket(p);
                    }
                    break;
                }
                case 2:{
                    System.out.println("Enter the PassengerID : ");
                    int id=sc.nextInt();
                    cancelTicket(id);
                    break;
                }
                case 3:{
                    BookTicket bt=new BookTicket();
                    bt.availableTickets();
                    break;
                }
                case 4:{
                    BookTicket bt=new BookTicket();
                    bt.passengerDetails();
                    break;
                }
                case 5:{
                    loop=false;
                    break;
                }
            }
        }
    }
}