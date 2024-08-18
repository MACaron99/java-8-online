package org.example.util;

import au.com.bytecode.opencsv.CSVWriter;
import org.example.entity.Account;
import org.example.entity.Category;
import org.example.entity.History;
import org.example.entity.Operation;
import org.example.factory.JdbcFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class CsvUtil {

    private static final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    public static void getHistory(Long id) {
        writeCsv(findByAccountId(id));
    }

    private static Collection<History> findByAccountId(Long id) {
        Collection<History> histories = new ArrayList<>();

        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement("select * from histories where account_id = " + id)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                History history = new History();
                history.setId(rs.getLong("id"));
                history.setCategory(findCategoryById(rs.getLong("category_id")));
                history.setOperation(findOperationById(rs.getLong("operation_id")));
                histories.add(history);
            }
            return histories;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void writeCsv(Collection<History> histories) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("history.csv"))) {
            List<String[]> list = new ArrayList<>();

            for (History history : histories) {
                String[] strings = new String[] {
                        history.getOperation().getDateTime(),
                        history.getCategory().getName(),
                        String.valueOf(history.getOperation().getAccount1().getId()),
                        String.valueOf(history.getOperation().getAccount2().getId()),
                        String.valueOf(history.getOperation().getSum())
                };
                list.add(strings);
            }
            csvWriter.writeAll(list);
            csvWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static Account findAccountById(Long id) {
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement("select * from accounts where id = " + id)) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getLong("id"));
                return account;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    private static Operation findOperationById(Long id) {
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement("select * from operations where id = " + id)) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Operation operation = new Operation();
                operation.setDateTime(rs.getString("date_time"));
                operation.setAccount1(findAccountById(rs.getLong("from_account_id")));
                operation.setAccount2(findAccountById(rs.getLong("to_account_id")));
                operation.setSum(rs.getLong("amount"));
                return operation;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    private static Category findCategoryById(Long id) {
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement("select * from categories where id = " + id)) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Category category = new Category();
                category.setName(rs.getString("name"));
                return category;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }
}
