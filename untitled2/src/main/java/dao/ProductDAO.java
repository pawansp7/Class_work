package dao;

import entity.Product;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAO {
    public static boolean addProduct(Product p) {
        try (Connection con = DbConnection.getConnection();) {
            String sql = "insert into product(name, price) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,p.getTitle());
            ps.setInt(2,p.getPrice());
            if(ps.executeUpdate() != 0)
                return true;
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
