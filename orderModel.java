package eStoreProduct.model;

import java.sql.Timestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "slam_Orders")
public class orderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordr_id")
	private Integer id;

	@JoinColumn(name = "ordr_cust_id")
	private Integer ordr_cust_id;

	@Column(name = "ordr_billno")
	private Long billNumber;

	@Column(name = "ordr_odate")
	private Timestamp orderDate;

	@Column(name = "ordr_total")
	private Double total;

	@Column(name = "ordr_gst")
	private Double gst;

	@Column(name = "ordr_payreference")
	private Integer paymentReference;

	@Column(name = "ordr_paymode")
	private String paymentMode;

	@Column(name = "ordr_paystatus")
	private String paymentStatus;

	@Column(name = "ordr_saddress")
	private String shippingAddress;

	@Column(name = "ordr_sPincode")
	private Integer shippingPincode;


	@Column(name = "ordr_shipment_date")
	private Timestamp shipmentDate;

	@Column(name = "ordr_processedby")
	private Integer ordr_processedby;
	
	@OneToMany(mappedBy = "slamOrder", cascade = CascadeType.ALL)
	    private List<SlamOrderProduct> orderProducts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrdr_cust_id() {
		return ordr_cust_id;
	}

	public void setOrdr_cust_id(Integer ordr_cust_id) {
		this.ordr_cust_id = ordr_cust_id;
	}

	public Long getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Integer getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(Integer paymentReference) {
		this.paymentReference = paymentReference;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Integer getShippingPincode() {
		return shippingPincode;
	}

	public void setShippingPincode(Integer shippingPincode) {
		this.shippingPincode = shippingPincode;
	}

	public Timestamp getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Timestamp shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public Integer getOrdr_processedby() {
		return ordr_processedby;
	}

	public void setOrdr_processedby(Integer ordr_processedby) {
		this.ordr_processedby = ordr_processedby;
	}

	public List<SlamOrderProduct> getOrderProducts() {
	    return orderProducts;
	}

	public void setOrderProducts(List<SlamOrderProduct> orderProducts) {
	    this.orderProducts = orderProducts;
	}

	public orderModel(Integer id, Integer ordr_cust_id, Long billNumber, Timestamp orderDate, Double total, Double gst,
		Integer paymentReference, String paymentMode, String paymentStatus, String shippingAddress,
		Integer shippingPincode, Timestamp shipmentDate, Integer ordr_processedby,
		List<SlamOrderProduct> orderProducts) {
	    super();
	    this.id = id;
	    this.ordr_cust_id = ordr_cust_id;
	    this.billNumber = billNumber;
	    this.orderDate = orderDate;
	    this.total = total;
	    this.gst = gst;
	    this.paymentReference = paymentReference;
	    this.paymentMode = paymentMode;
	    this.paymentStatus = paymentStatus;
	    this.shippingAddress = shippingAddress;
	    this.shippingPincode = shippingPincode;
	    this.shipmentDate = shipmentDate;
	    this.ordr_processedby = ordr_processedby;
	    this.orderProducts = orderProducts;
	}

	public orderModel() {
	    super();
	    // TODO Auto-generated constructor stub
	}
	

	// Constructors, getters, and setters

	// ...
}
