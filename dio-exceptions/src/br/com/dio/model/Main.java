package src.br.com.dio;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import src.br.com.dio.enums.MenuOption;
import src.br.com.dio.model.UserDAO;
import src.br.com.dio.model.UserModel;

public class Main{

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner =  new Scanner(System.in);

    public static void main (String[] args) {

        System.out.println("Cadastro de usuário: Selecione a operação desejada: ");
        System.out.println("1 - Criar usuário");
        System.out.println("2 - Atualizar usuário");
        System.out.println("3 - Excluir usuário");
        System.out.println("4 - Buscar usuário por ID");
        System.out.println("5 - Listar todos os usuários");
        System.out.println("6 - Sair");

        var userOptionSelected = scanner.nextInt();
        
        while(true){
            var selectedOption = MenuOption.values()[userOptionSelected -1];
            switch (selectedOption) {
                case SAVE -> dao.save(requestUserSave());
                    
                case UPDATE -> dao.update(requestUserUpdate());

                case DELETE -> dao.delete(requestId());

                case FIND_BY_ID -> dao.findById(requestId());
                
                case FIND_ALL -> dao.findAll();  

                case EXIT -> System.exit(0);
            }

        }
    
    }

    private static UserModel requestUserSave(){

        System.out.println("Informe o nome do usuário: ");
        var name = scanner.next();
        System.out.println("Informe o email do usuário: ");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário: (dd/MM/yyyy) ");
        var birthdayString = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        
        return new UserModel(0, name, email, birthday);
    }

    private static UserModel requestUserUpdate(){

        System.out.println("Informe o ID: ");
        var id = scanner.nextLong();
        System.out.println("Informe o nome do usuário: ");
        var name = scanner.next();
        System.out.println("Informe o email do usuário: ");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário: (dd/MM/yyyy) ");
        var birthdayString = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);

        return new UserModel(id, name, email, birthday);
    }

    private static long requestId(){
        System.out.println("Informe o ID: ");
        return scanner.nextLong();
    }
}
