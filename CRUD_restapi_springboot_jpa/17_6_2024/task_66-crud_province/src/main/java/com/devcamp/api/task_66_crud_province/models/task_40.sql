SELECT credit_limit FROM `customers` WHERE credit_limit >'5000';

Hiển thị toàn bộ thông tin danh sách sản phẩm, với tên của product_line tương ứng
(không hiển thị product_line_id mà hiển thị tên product line)

SELECT pro.product_name, proline.product_line FROM `products` pro INNER JOIN product_lines proline ON pro.product_line_id = proline.id;

Đếm xem ở từng nước, có bao nhiêu khách hàng?
(hiển thị tên nước, số lượng khách hàng)


SELECT country, COUNT(*) as num_customers FROM customers GROUP BY country;


Sắp xếp các sản phẩm theo giá mua tăng dần và lấy ra 10 sản phẩm đầu tiên
SELECT * FROM products ORDER BY buy_price ASC LIMIT 10;

Lấy ra danh sách các đơn hàng được đặt vào tháng 10/2003
SELECT * FROM orders WHERE order_date BETWEEN '2003-10-01' AND '2003-10-31';

Lấy ra danh sách các khách hàng có số lượng đơn hàng > 3
SELECT cus.id, CONCAT(cus.first_name , ' ' , cus.last_name) AS fullname, COUNT(ord.id) AS total_orders FROM customers cus INNER JOIN orders ord ON cus.id = ord.customer_id GROUP BY cus.id HAVING COUNT(ord.id) > 3;

Tính toán xem, mỗi đơn hàng có bao nhiêu sản phẩm được đặt và tổng tiền từng đơn hàng là bao nhiêu
Hiển thị: order_id, tổng số lượng và tổng tiền



SELECT order_id, SUM(ordl.quantity_order) AS total_quantity, SUM(ordl.quantity_order * pro.buy_price) AS total_amount FROM order_details ordl JOIN orders oi ON ordl.order_id = oi.id JOIN products pro ON ordl.product_id = pro.id GROUP BY ordl.id;


Tính toán xem, mỗi đơn hàng có bao nhiêu sản phẩm được đặt và tổng tiền từng đơn hàng là bao nhiêu. Và lấy ra danh sách các đơn có tổng tiền > 100000
Hiển thị: order_id, tổng số lượng và tổng tiền

SELECT orders.id AS order_id, COUNT(order_details.id) AS total_products, SUM(order_details.quantity_order * products.buy_price) AS total_amount FROM orders JOIN order_details ON orders.id = order_details.order_id JOIN products ON order_details.product_id = products.id GROUP BY orders.id HAVING SUM(order_details.quantity_order * products.buy_price) > 30000 ORDER BY total_amount DESC;


Tìm và hiển thị toàn bộ thông tin sản phẩm được đặt nhiều nhất (theo quantity_order) trong năm 2004

SELECT products.*, SUM(order_details.quantity_order) AS total_quantity FROM order_details JOIN orders ON order_details.order_id = orders.id JOIN products ON order_details.product_id = products.id WHERE orders.order_date BETWEEN '2004-01-01' AND '2004-12-31' GROUP BY products.id ORDER BY total_quantity DESC LIMIT 1;