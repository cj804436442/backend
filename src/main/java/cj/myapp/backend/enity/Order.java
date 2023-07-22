package cj.myapp.backend.enity;

public class Order {
    private Integer id;
    private String food;
    private String orderTime;
    private String remark;
    private String price;

    public Order() {
    }

    public Order(Integer id, String food, String orderTime, String remark, String price) {
        this.id = id;
        this.food = food;
        this.orderTime = orderTime;
        this.remark = remark;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", food='" + food + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", remark='" + remark + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}