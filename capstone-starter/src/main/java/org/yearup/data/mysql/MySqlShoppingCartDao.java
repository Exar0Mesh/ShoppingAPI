package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao
{

    public MySqlShoppingCartDao(DataSource dataSource) { super(dataSource); }

    @Override
    public ShoppingCart getByUserId(int userId) {
        String sql = "SELECT s.user_id, s.product_id, s.quantity, s.discount_percent, p.* " +
                "FROM shopping_cart AS s " +
                "JOIN products p ON (s.product_id = p.product_id) " +
                "WHERE s.user_id = ;";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet row = statement.executeQuery();
            ShoppingCart shoppingCart = new ShoppingCart();

            if (row.next()) {
                ShoppingCartItem item = mapRow(row);
                shoppingCart.add(item);
            }

            return shoppingCart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        String sql = "INSERT INTO shopping_cart(user_id, product_id, quantity) " +
                " VALUES (?, ?, ?);";
            return null;
        }

    @Override
    public ShoppingCart updateCart(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public ShoppingCart deleteItem(ShoppingCart shoppingCart) {
        return null;
    }

    private ShoppingCartItem mapRow(ResultSet row) throws SQLException {
        int productId = row.getInt("product_id");
        String name = row.getString("name");
        BigDecimal price = row.getBigDecimal("price");

        Product product = new Product();
        product.setProductId(productId);
        product.setName(name);
        product.setPrice(price);

        int quantity = row.getInt("quantity");

        BigDecimal discountPercent = row.getBigDecimal("discount_percent");
        if (discountPercent == null) {
            discountPercent = BigDecimal.ZERO;
        }

        ShoppingCartItem item = new ShoppingCartItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setDiscountPercent(discountPercent);

        return item;
    }



}
