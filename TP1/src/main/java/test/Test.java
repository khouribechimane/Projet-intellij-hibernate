//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package test;
import entities.Machine;
import entities.Salle;
import java.util.Date;
import java.util.Iterator;
import services.MachineService;
import services.SalleService;
public class Test {
    public Test() {
    }
    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();
        Salle salle1 = new Salle("A1");
        Salle salle2 = new Salle("B2");
        salleService.create(salle1);
        salleService.create(salle2);
        Machine machine1 = new Machine("M123", new Date(), salleService.findById(1));
        Machine machine2 = new Machine("M124", new Date(), salleService.findById(2));
        machineService.create(machine1);
        machineService.create(machine2);
        Iterator var7 = salleService.findAll().iterator();
        Iterator var9;
        Machine m;
        while(var7.hasNext()) {
            Salle salle = (Salle)var7.next();
            System.out.println("Salle: " + salle.getCode());
            var9 = salle.getMachines().iterator();

            while(var9.hasNext()) {
                m = (Machine)var9.next();
                System.out.println("Machine: " + m.getRef());
            }
        }
        Date d1 = new Date(110, 0, 1);
        Date d2 = new Date();
        System.out.println("Machine achetées entre " + d1 + " et " + d2 + " :");
        var9 = machineService.findBetweenDate(d1, d2).iterator();

        while(var9.hasNext()) {
            m = (Machine)var9.next();
            System.out.println(m.getRef() + " achetée le " + m.getDateAchat());
        }

    }
}

