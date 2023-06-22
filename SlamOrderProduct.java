package eStoreProduct.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "slam_orderproducts")
public class SlamOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ordr_id", referencedColumnName = "ordr_id")
    private orderModel slamOrder;

    @Column(name = "prod_id")
    private Integer productId;

    @Column(name = "orpr_qty")
    private Integer quantity;

    @Column(name = "orpr_gst")
    private BigDecimal gst;

    @Column(name = "orpr_price")
    private BigDecimal price;

    @Column(name = "orpr_shipment_status")
    private String shipmentStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public orderModel getSlamOrder() {
        return slamOrder;
    }

    public void setSlamOrder(orderModel slamOrder) {
        this.slamOrder = slamOrder;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getGst() {
        return gst;
    }

    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public SlamOrderProduct(Integer id, orderModel slamOrder, Integer productId, Integer quantity, BigDecimal gst,
	    BigDecimal price, String shipmentStatus) {
	super();
	this.id = id;
	this.slamOrder = slamOrder;
	this.productId = productId;
	this.quantity = quantity;
	this.gst = gst;
	this.price = price;
	this.shipmentStatus = shipmentStatus;
    }

    public SlamOrderProduct() {
	super();
	// TODO Auto-generated constructor stub
    }

    // Constructors, getters, and setters (omitted for brevity)

    // Add any additional methods or relationships here
}
