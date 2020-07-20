package resources;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Account {
    @CsvBindByName(column = "username", required = true)
    @CsvBindByPosition(position = 0)
    private String username;

    @CsvBindByName(column = "password")
    @CsvBindByPosition(position = 1)
    private String password;

    // set as constructor
    public Account() {
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String value) {
        this.username = value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    @Override
    public String toString() {
        return String.format("username=%s , password=%s", this.username, this.password);
    }
}
