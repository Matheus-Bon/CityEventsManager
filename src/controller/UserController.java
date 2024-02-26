package controller;

import java.util.Scanner;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> userList;

    public UserController() {
        userList = new ArrayList<>();
    }

    private void createUser(String name, String lastName, String email) {
        int id = userList.size() + 1;
        User newUser = new User();
        newUser.setId(id);
        newUser.setName(name);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        userList.add(newUser);
    }

    private User readUser(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    private void updateUser(int id, String name, String lastName, String email) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(name);
                user.setLastName(lastName);
                user.setEmail(email);
                break;
            }
        }
    }

    private void deleteUser(int id) {
        userList.removeIf(user -> user.getId() == id);
    }

    private List<User> getAllUsers() {
        return userList;
    }

    public void start() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("--- Selecione uma opção ---");
            System.out.println("1. Criar usuário");
            System.out.println("2. Ler usuário");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Deletar usuário");
            System.out.println("5. Listar todos os usuários");
            System.out.println("6. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            String name;
            String lastName;
            String email;
            int id;

            switch (choice) {
                case 1:
                    System.out.println("Digite o nome:");
                    name = scanner.nextLine();
                    System.out.println("Digite o sobrenome:");
                    lastName = scanner.nextLine();
                    System.out.println("Digite o email:");
                    email = scanner.nextLine();

                    createUser(name, lastName, email);
                    break;
                case 2:
                    System.out.println("Digite o ID do usuário:");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    readUser(id);
                    break;
                case 3:
                    System.out.println("Digite o ID do usuário que deseja atualizar:");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o novo nome:");
                    name = scanner.nextLine();
                    System.out.println("Digite o novo sobrenome:");
                    lastName = scanner.nextLine();
                    System.out.println("Digite o novo email:");
                    email = scanner.nextLine();

                    System.out.println("Usuário atualizado com sucesso.");
                    updateUser(id, name, lastName, email);
                    break;
                case 4:
                    System.out.println("Digite o ID do usuário que deseja deletar:");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Usuário deletado com sucesso.");
                    deleteUser(id);
                    break;
                case 5:
                    System.out.println("Listando todos os usuários:");
                    for (User user : getAllUsers()) {
                        System.out.println("ID: " + user.getId() + ", Nome: " + user.getName() + ", Sobrenome: "
                                + user.getLastName() + ", Email: " + user.getEmail());
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
