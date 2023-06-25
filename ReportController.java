package eStoreProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import eStoreProduct.DAO.CategoryReportDAO;
import eStoreProduct.DAO.OrderDAO;
import eStoreProduct.DAO.ProductDAO;
import eStoreProduct.model.Category;
import eStoreProduct.model.CategoryReportViewModel;
import eStoreProduct.model.orderModel;

@Controller

public class ReportController {
    
 
    private OrderDAO odao;
    private CategoryReportDAO crd;
    
    @Autowired
	public ReportController(   @Qualifier("orderDAOImp") OrderDAO odao,CategoryReportDAO crd) {
	this.odao = odao;
	this.crd=crd;
	}
    
	@GetMapping("/generateGSTReport")
	public String generateGSTReport(Model model) {
	    List<orderModel> om=odao.getAllOrders();
	    model.addAttribute("orderReport", om);
	    return "Reports";
	}
	@GetMapping("/categoryReport")
	public String categoryReport(Model model) {
	    //List<orderModel> om=odao.getAllOrders();
	    List<CategoryReportViewModel> cl=crd.getCatRep();
	    model.addAttribute("categoryReport", cl);
	    return "catReports";
	}
	/*
	 * @GetMapping("/categoryReportSort") public String categoryReportSort(Model
	 * model) { //List<orderModel> om=odao.getAllOrders();
	 * List<CategoryReportViewModel> cl= model.addAttribute("categoryReport", cl);
	 * return "catReports"; }
	 */
}
