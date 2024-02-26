import controller.UserController;

public class App {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();

        userController.start();
    }
}
