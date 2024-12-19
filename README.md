This code is a shoppingAPI that uses a database and Springboot to grab products and list them for the user to buy. There is a register and login option for both Users and Admins, in which each get certain permissions for messing with the store code. There is also a shoppingcart feature, but that was not implemented just yet. 
capstone-starter/src/main/resources/ScreenEasyShop.png 
An interesting piece of code I was developing was for the shopping cart feature. In the shoppingCartDao, there needed to be products displayed using the product_id in the shopping cart table. A maprow was created to read each line from the products table and place them in as shopping cart items. 
capstone-starter/src/main/resources/InterestingCodeShoppingCart.png 
