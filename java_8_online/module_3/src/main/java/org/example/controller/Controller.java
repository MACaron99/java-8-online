package org.example.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.example.entity.*;
import org.example.service.*;
import org.example.service.impl.*;
import org.example.util.CsvUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class Controller {

    private static final UserService userService = new UserServiceImpl();
    private static final AccountService accountService = new AccountServiceImpl();
    private static final OperationService operationService = new OperationServiceImpl();
    private static final CategoryService categoryService = new CategoryServiceImpl();
    private static final HistoryService historyService = new HistoryServiceImpl();

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        initCategories();
        program();
        mainMenu();
        String position;
        while ((position = bufferedReader.readLine()) != null) {
            mainSwitch(position, bufferedReader);
            mainMenu();
        }
    }

    private void program() {
        System.out.println();
        System.out.println("Program BANK");
        System.out.println("Welcome to the program CRUD SQL. CRUD-application for working with two entities, joining them and keeping data in database");
    }

    private void mainMenu() {
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("1. Open user-account editor");
        System.out.println("2. Start a new operation");
        System.out.println("3. Get an account extract");
        System.out.println("0. Close app");
    }

    private void editorMenu() {
        System.out.println();
        System.out.println("Editor Menu");
        System.out.println("1. Create user");
        System.out.println("2. Create account");
        System.out.println("3. Find users and accounts");
        System.out.println("4. Update user");
        System.out.println("5. Delete user");
        System.out.println("6. Delete account");
        System.out.println("0. Back to main menu");
    }

    private void mainSwitch(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> {
                editorMenu();
                String choice;
                while ((choice = reader.readLine()) != null) {
                    editorSwitch(choice, reader);
                    editorMenu();
                }
            }
            case "2" -> {
                Collection<User> users = userService.findAll();
                if (CollectionUtils.isNotEmpty(users)) {
                    printUsers(users);
                    System.out.println("Enter sender account id");
                    Account account1 = accountService.findById(Long.valueOf(reader.readLine()));
                    if (account1 != null) {
                        System.out.println("Enter receiver account id");
                        Account account2 = accountService.findById(Long.valueOf(reader.readLine()));
                        if (account2 != null) {
                            System.out.println("Enter the sum to sent");
                            long sum = Long.parseLong(reader.readLine());
                            if (sum < account1.getSum()) {
                                account1.setSum(account1.getSum() - sum);
                                account2.setSum(account2.getSum() + sum);
                                Operation operation = new Operation();
                                History history1 = new History();
                                History history2 = new History();
                                operation.setDateTime(String.valueOf(LocalDateTime.now()));
                                operation.setAccount1(account1);
                                operation.setAccount2(account2);
                                operation.setSum(sum);
                                operationService.create(operation);
                                history1.setAccount(account1);
                                history1.setOperation(operation);
                                history1.setCategory(categoryService.findById(1L));
                                history2.setAccount(account2);
                                history2.setOperation(operation);
                                history2.setCategory(categoryService.findById(2L));
                                historyService.create(history1);
                                historyService.create(history2);
                                accountService.update(account1);
                                accountService.update(account2);
                                System.out.println("Operation successfully completed");
                            } else {
                                System.out.println("Not enough sum on account");
                            }
                        } else {
                            System.out.println("Account not found");
                        }
                    } else {
                        System.out.println("Account not found");
                    }
                } else {
                    System.out.println("No user found");
                }
            }
            case "3" -> {
                Collection<User> users = userService.findAll();
                if (CollectionUtils.isNotEmpty(users)) {
                    printUsers(users);
                    System.out.println("Enter account id");
                    Long id = Long.valueOf(reader.readLine());
                    if (accountService.findById(id) != null) {
                        CsvUtil.getHistory(id);
                        System.out.println();
                        System.out.println("An account extract issued");
                    } else {
                        System.out.println("Account not found");
                    }
                } else {
                    System.out.println("No user found");
                }
            }
            case "0" -> {
                System.out.println("Bye!");
                System.exit(0);
            }
        }
    }

    private void editorSwitch(String choice, BufferedReader reader) throws IOException {
        switch (choice) {
            case "1" -> {
                userService.create(setUser(new User(), reader));
                System.out.println("User has been created");
            }
            case "2" -> {
                Collection<User> users = userService.findAll();
                if (CollectionUtils.isNotEmpty(users)) {
                    printUsers(users);
                    System.out.println("Enter user id");
                    User user = userService.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (user != null) {
                        Account account = new Account();
                        System.out.println("Enter initial account sum");
                        account.setSum(Long.valueOf(reader.readLine()));
                        account.setUser(user);
                        user.getAccounts().add(account);
                        accountService.create(account);
                        userService.update(user);
                        System.out.println("User '" + user.getName() + "' received new account # " + account.getId());
                    } else {
                        System.out.println("User not found");
                    }
                } else {
                    System.out.println("No user found");
                }
            }
            case "3" -> {
                Collection<User> users = userService.findAll();
                if (CollectionUtils.isNotEmpty(users)) {
                    printUsers(users);
                } else {
                    System.out.println("No user found");
                }
            }
            case "4" -> {
                Collection<User> users = userService.findAll();
                if (CollectionUtils.isNotEmpty(users)) {
                    printUsers(users);
                    System.out.println("Enter user id");
                    User user = userService.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (user != null) {
                        userService.update(setUser(user, reader));
                        System.out.println("User has been updated");
                    } else {
                        System.out.println("User not found");
                    }
                } else {
                    System.out.println("No user found");
                }
            }
            case "5" -> {
                Collection<User> users = userService.findAll();
                if (CollectionUtils.isNotEmpty(users)) {
                    printUsers(users);
                    System.out.println("Enter user id");
                    User user = userService.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (user != null) {
                        userService.delete(user);
                        System.out.println("User has been deleted");
                    } else {
                        System.out.println("User not found");
                    }
                } else {
                    System.out.println("No user found");
                }
            }
            case "6" -> {
                Collection<User> users = userService.findAll();
                if (CollectionUtils.isNotEmpty(users)) {
                    printUsers(users);
                    System.out.println("Enter account id");
                    Account account = accountService.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (account != null) {
                        User user = account.getUser();
                        user.getAccounts().remove(account);
                        userService.update(user);
                        accountService.delete(account);
                        System.out.println("Account has been deleted");
                    } else {
                        System.out.println("Account not found");
                    }
                } else {
                    System.out.println("No user found");
                }
            }
            case "0" -> {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                mainMenu();
                String position;
                while ((position = bufferedReader.readLine()) != null) {
                    mainSwitch(position, bufferedReader);
                    mainMenu();
                }
            }
        }
    }

    private void printUsers(Collection<User> users) {
        for (User user : users) {
            System.out.println("User");
            System.out.println("id = " + user.getId());
            System.out.println("name = " + user.getName());
            Set<Account> accounts = user.getAccounts();
            if (CollectionUtils.isNotEmpty(accounts)) {
                System.out.println("Accounts:");
                for (Account account : accounts) {
                    System.out.println("id = " + account.getId());
                    System.out.println("sum = " + account.getSum());
                }
            } else {
                System.out.println("User don't have accounts");
            }
            System.out.println();
        }
    }

    private User setUser(User user, BufferedReader reader) throws IOException {
        System.out.println("Enter user name");
        user.setName(reader.readLine());
        return user;
    }

    private void initCategories() {
        if (categoryService.findById(1L) == null && categoryService.findById(2L) == null) {
            Category category1 = new Category();
            Category category2 = new Category();
            category1.setName("Spending(-)");
            category2.setName("Income(+)");
            categoryService.create(category1);
            categoryService.create(category2);
        }
    }
}
