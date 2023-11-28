import java.util.Scanner;

public class ProveraMailaLozinke {

    static boolean daLiJeMailIspravan(String text){
        if(!text.contains("@") && !text.contains("."))
            return false;

        //Pravilan mail: nidza123@kraj.rs
        //Nepravilna mail:  ni@prov.45
        String []mail = text.split("@");
        String nazivMaila = mail[0];
        String [] domen = mail[1].split("\\.");
        //System.out.println(nazivMaila);
        //System.out.println(domen[0]);
        //System.out.println(domen[1]);

        if(nazivMaila.length()<5)  return false;

        for(int i=0;i<nazivMaila.length();i++){
            if(!Character.isLetterOrDigit(nazivMaila.charAt(i)))
                return  false;
        }

        if(domen[0].length()<4) return false;

        for(int i=0;i<domen[0].length();i++){
            if(!Character.isLetter(domen[0].charAt(i))) {
                return false;
            }
        }

        if(domen[1].length()<2 || domen[1].length()>4)  return false;

        for(int i=0;i<domen[1].length();i++){
            if(!Character.isLetter(domen[1].charAt(i)))
                return  false;
        }

        return true;

        //DZ: refaktorisati kod tako sto cete da napravite dodatne metode npr da proveavate da li tekst sadrzi samo slova

    }

    static boolean daLiJeLozinkaJaka(String tekst){
        if(tekst.length()<12)
            return false;

        /*
        boolean malaSlova = false;
        boolean velikaSlova = false;
        boolean cifre = false;
        boolean specZnakovi = false;
        */
        byte tacno=0; //0000 0000
        //0000 1111 =>15

        for(int i=0;i<tekst.length() && tacno!=15;i++){
            char znak = tekst.charAt(i);
            if(Character.isLowerCase(znak)){
                //malaSlova = true;
                tacno = (byte)(tacno |  1);
                //0000 0001

            }

            else if(Character.isUpperCase(znak)){
                //velikaSlova = true;
                tacno = (byte)(tacno |  2);
                //0000 0010

            }
            else if(Character.isDigit(znak)){
                tacno = (byte)(tacno |  4);
                //0000 0100
            }
            else {
                tacno = (byte)(tacno |  8);
                //0000 1000
            }
        }
        if(tacno==15)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Unesite Vas mail:");
        String mail = scn.nextLine();

/*
        if(daLiJeMailIspravan(mail)){
            System.out.println("Mail je ispravan");
        }
        else{
            System.out.println("Mail nije ispravan!!!");
        }
        */
        while(!daLiJeMailIspravan(mail)){
            System.out.println("Mail nije ispravan!!!");
            System.out.println("Primer ispravnog maila:nidza123@kraj.rs");
            System.out.println("Unesite Vas mail ponovo:");
            mail = scn.nextLine();
        }
        System.out.println("Mail je ispravan");

        System.out.println("Unesite Vasu loziku da bude jaka:");
        String lozinka = scn.nextLine();
        while(!daLiJeLozinkaJaka(lozinka)){
            System.out.println("Lozinka nije ispravan!!!");
            System.out.println("Primer ispravne lozinke:prot123KL!fdsdf");
            System.out.println("Unesite Vasu lozinku ponovo:");
            lozinka= scn.nextLine();
        }
        System.out.println("Lozinka je ispravna");
        System.out.println("Uspesno ste se registrovali");
    }
}
