import java.util.*;

public class BookTicket {
    static int aLB=2;
    static int aMB=1;
    static int aUB=1;
    static int aRAC=1;
    static int aWL=1;

    static List<Integer>lBP=new ArrayList<>(Arrays.asList(1,2));
    static List<Integer>mBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer>uBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer>racP=new ArrayList<>(Arrays.asList(1));
    static List<Integer>wlP=new ArrayList<>(Arrays.asList(1));

    static Queue<Integer>wlList=new LinkedList<>();
    static Queue<Integer>racList=new LinkedList<>();
    static List<Integer>bookedTicketList=new ArrayList<>();
    static Map<Integer,Passenger>data=new HashMap<Integer,Passenger>();

public void bookTicket(Passenger p,int snumber,String allotedBerth){
    p.number=snumber;
    p.alloted=allotedBerth;
    data.put(p.passengerId,p);
    bookedTicketList.add(p.passengerId);
    System.out.println("Passenger ID : "+p.passengerId);
    System.out.println("Passenger Name : "+p.name);
    System.out.println("Passenger Age : "+p.age);
    System.out.println("Passeneger Gender : "+p.gender);
    System.out.println("Alloted Berth : "+snumber+allotedBerth);
    System.out.println("-----Booked Successfully-----");
}
    public void racTicket(Passenger p,int snumber,String racBerth){
        p.number=snumber;
        p.alloted=racBerth;
        data.put(p.passengerId,p);
        bookedTicketList.add(p.passengerId);
        System.out.println("Passenger ID : "+p.passengerId);
        System.out.println("Passenger Name : "+p.name);
        System.out.println("Passenger Age : "+p.age);
        System.out.println("Passeneger Gender : "+p.gender);
        System.out.println("Alloted Berth : "+snumber+racBerth);
        System.out.println("-----RAC Berth Given----0");
    }
    public void waitingListTicket(Passenger p,int snumber,String wlBerth){
        p.number=snumber;
        p.alloted=wlBerth;
        data.put(p.passengerId,p);
        bookedTicketList.add(p.passengerId);
        System.out.println("Passenger ID : "+p.passengerId);
        System.out.println("Passenger Name : "+p.name);
        System.out.println("Passenger Age : "+p.age);
        System.out.println("Passeneger Gender : "+p.gender);
        System.out.println("Alloted Berth : "+snumber+wlBerth);
        System.out.println("-----You are in WaitingList-----");
    }
    public void cancelTicket(int passengerId){
    Passenger p=data.get(passengerId);
    data.remove(passengerId);
    bookedTicketList.remove(passengerId);
    int psnumber=p.number;
        System.out.println("Ticket has been cancelled successfully-----");
        if(p.alloted.equals("L")){
            lBP.add(psnumber);
            aLB++;
        }
        else if(p.alloted.equals("M")){
            mBP.add(psnumber);
            aMB++;
        }
        else if(p.alloted.equals("U")){
            uBP.add(psnumber);
            aUB++;
        }
        if(racList.size()>0) {
            Passenger pfRac = data.get(racList.poll());
            int pracnum = pfRac.number;
            racP.add(pracnum);
            racList.remove(pfRac.passengerId);
            aRAC++;

            if (wlList.size() > 0) {
                Passenger pfwl = data.get(wlList.poll());
                int pwlnum = pfwl.number;
                wlP.add(pwlnum);
                wlList.remove(pfwl.passengerId);
                pfwl.number = racP.get(0);
                pfwl.alloted = "RAC";
                racP.remove(0);
                racList.add(pfwl.passengerId);
                aWL++;
                aRAC--;
            }
            Main.bookTicket(pfRac);
        }
    }
    public void availableTickets(){
        System.out.println("The Available Lower Berth Tickets are : "+aLB);
        System.out.println("The Available Middle Berth Tickets are : "+aMB);
        System.out.println("The Available Upper Berth Tickets are : "+aUB);
        System.out.println("The Available RAC Berth Tickets are : "+aRAC);
        System.out.println("The Available Waiting List Tickets are : "+aWL);
    }
    public void passengerDetails(){
    if(data.size()==0){
        System.out.println("There is no Passenger Details are available");
    }
    else{
        for (Passenger p: data.values() ){
            System.out.println("Passenger Id : "+p.passengerId);
            System.out.println("Passenger Name : "+p.name);
            System.out.println("Passenger Age : "+p.age);
            System.out.println("Passenger Gender : "+p.gender);
            System.out.println("Passenger Child Name : "+p.cname);
            System.out.println("Passenger Child Age : "+p.cage);
            System.out.println("Alloted Berth : "+p.number+p.alloted);
            System.out.println("---------------------------------");
        }
    }
    }
}
