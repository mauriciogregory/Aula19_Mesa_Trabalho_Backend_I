import model.Contatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Contatos> contatos = new ArrayList<>();

        Contatos contatos1 = new Contatos("Marcos", "m@fgm.com","5190909");
        Contatos contatos2 = new Contatos("Loan", "l@jmk.com", "289819891");

        // adicionando na lista
        contatos.add(contatos1);
        contatos.add(contatos2);

        FileOutputStream fo = null;

        //
        try {
            fo = new FileOutputStream("Arquivo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(contatos);
        } catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        List<Contatos> recupera = new ArrayList<>();
        FileInputStream fi = null;

        try{
            fi =new FileInputStream("Arquivo_recuperado.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            recupera = (ArrayList) ois.readObject();
        } catch (FileNotFoundException f){
            System.out.println("Error: " + f.getMessage());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        for(Contatos c : recupera){
            System.out.println(
                    " | " + c.getNome()
                            + " | " + c.getNome()
                            + " | " + c.getEmail()
                            + " | " + c.getTelefone()
            );
        }

    }
}
