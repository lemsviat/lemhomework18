package main.java.com.lemsviat.lemhomework18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserConsole {

    private final SkillController controller = new SkillController();
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private boolean quit = false;
    private String userInput;

    public void renderRepositoryMenu() {
        System.out.println("\nChoose kind of repository we'll work");
        System.out.println("--------------------------------------");
        System.out.println("        - Press button, please -       ");
        System.out.println("1 - Working with repository in txt file;");
        System.out.println("2 - Working with repository in csv file;");
        System.out.println("3 - Quit.");
        System.out.println("--------------------------------------");
    }

    public void handleRepositoryMenuUserInput() {
        final String CREATE_TXT_REPOSITORY = "1";
        final String CREATE_CSV_REPOSITORY = "2";
        final String QUIT = "3";
        switch (userInput) {
            case CREATE_TXT_REPOSITORY:
                controller.createTxtRepo();
                renderMenu();
                readUserInput();
                handleUserInput();
                break;
            case CREATE_CSV_REPOSITORY:
                controller.createCsvRepo();
                renderMenu();
                readUserInput();
                handleUserInput();
                break;
            case QUIT:
                quit = true;
                deleteFiles();
                break;
            default:
                if(quit) {
                    deleteFiles();
                    break;
                }
                else renderRepositoryMenu();
        }
    }

    public void renderMenu() {

        System.out.println("          Menu         ");
        System.out.println("------------------------");
        System.out.println("- Press button, please -");
        System.out.println("1 - Create new Skill;");
        System.out.println("2 - Update Skill;");
        System.out.println("3 - Read Skill;");
        System.out.println("4 - Delete Skill;");
        System.out.println("5 - Quit.");
        System.out.println("------------------------");

    }

    public boolean isQuit() {
        return quit;
    }

    public void readUserInput() {
        userInput = readInput();
    }


    public void handleUserInput() {
        String skillName;
        int skillId;
        Skill skill;

        final String CREATE_NEW_SKILL = "1";
        final String UPDATE_SKILL = "2";
        final String READ_SKILL = "3";
        final String DELETE_SKILL = "4";
        final String QUIT = "5";
        switch (userInput) {
            case CREATE_NEW_SKILL:
                skillId = readSkillId();
                skillName = readSkillName();
                controller.create(skillId, skillName);
                break;
            case UPDATE_SKILL:
                skillId = readSkillId();
                skillName = readSkillName();
                controller.update(skillId, skillName);
                break;
            case READ_SKILL:
                skillId = readSkillId();
                skill = controller.read(skillId);
                displaySkill(skill);
                break;
            case DELETE_SKILL:
                skillId = readSkillId();
                controller.deleteById(skillId);
                break;
            case QUIT:
                quit = true;
                deleteFiles();
                break;
            default:
                renderMenu();

        }
    }
    public void deleteFiles(){
        try {
            Files.deleteIfExists(Paths.get(TxtSkillRepository.FILE_NAME));
            Files.deleteIfExists(Paths.get(CsvSkillRepository.FILE_NAME));
        } catch (IOException e) {
            System.out.println("File of data not exist");
        }
    }

    private void displaySkill(Skill skill) {
        System.out.print("Skill:");
        System.out.print(" Id - " + skill.getSkillId() + ";");
        System.out.println(" Name - " + skill.getSkillName() + ".");
    }

    private int readSkillId() {
        System.out.println("Input SkillId:");
        return readIntInput();
    }

    private String readSkillName() {
        System.out.println("Input SkillName:");
        return readInput();
    }

    private String readInput() {
        String input = null;
        do {
            try {
                input = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Failed to read input. Try again.");
            }
        } while (input == null);
        return input;

    }

    private int readIntInput() {
        int intInput = 0;
        boolean isInt = false;
        do {
            String input = readInput();
            try {
                intInput = Integer.parseInt(input);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number. Try again.");
            }
        } while (!isInt);

        return intInput;

    }
}
