package eStoreProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import eStoreProduct.DAO.OrderDAO;
import eStoreProduct.DAO.ProductDAO;
import eStoreProduct.model.Category;
import eStoreProduct.model.orderModel;

@Controller

public class ReportController {
    
 
    private OrderDAO odao;
    
    @Autowired
	public ReportController(   @Qualifier("orderDAOImp") OrderDAO odao) {
	this.odao = odao;
	}
    
	@GetMapping("/generateGSTReport")
	public String generateGSTReport(Model model) {
	    List<orderModel> om=odao.getAllOrders();
	    model.addAttribute("orderReport", om);
	    return "Reports";
	}


}
