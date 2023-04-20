import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HospitalQuery {
    static Connection connection = null;
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("/Users/benhardy/Desktop/DB2/checkpoint_4/src/queries.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {

            HashMap<Float, String> queries = new HashMap<>();  //maps query numbers to the string query
            String line;
            while ((line = br.readLine()) != null) { // reads from file to store query number and the string in a hashmap
                Float num = Float.parseFloat(line.substring(0, 3));
                String query = line.substring(5, line.length() - 1);
                queries.put(num, query);
            }


            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Hospital"; // connection string
            String username = "root"; // mysql username
            String password = "public_password"; // mysql password
            connection = DriverManager.getConnection(url, username, password);

            Scanner scan = new Scanner(System.in);
            String userInput = "";

            while (!userInput.equals("q")) {
                /*
                    Program loop. Accepts a number from user and then calls the
                 */
                System.out.print("Enter the number of the query to execute (or 'q' to quit): ");
                userInput = scan.nextLine().trim();

                if (userInput.equals("q")) {
                    break;
                }
                try {
                    if (!queries.containsKey(Float.parseFloat(userInput))) {
                        System.out.println("NOT A VALID QUERY #");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only");
                    continue;
                }

                Float qNum = Float.parseFloat(userInput);
                String test_query = queries.get(qNum);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(test_query,
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData rsMetaData = resultSet.getMetaData();

                int numColumns = rsMetaData.getColumnCount();

                // Print information about each column
                ArrayList<String> columns = new ArrayList<>();
                for (int i = 1; i <= numColumns; i++) {
                    columns.add(rsMetaData.getColumnName(i));
                }

                // Print Header
                StringBuilder header = new StringBuilder();
                for (int i = 0; i < columns.size(); i++) {
                    header.append(columns.get(i));
                    if (i < columns.size() - 1) {
                        header.append(", "); // Add a comma and a space after each column name
                    }
                }
                System.out.println(header);

                // Print the Rows
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    StringBuilder entity = new StringBuilder();
                    for (int j = 1; j <= numColumns; j++) {
                        entity.append(resultSet.getString(j));
                        if (j < numColumns) {
                            entity.append(", "); // Add a comma and a space after each value
                        }
                    }
                    System.out.println(entity);
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Unable to load MySQL JDBC driver. " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error occurred. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Unable to read file. " + e.getMessage());
        }
    }
}