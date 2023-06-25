package eStoreProduct.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import eStoreProduct.model.SlamOrderProduct;


import org.springframework.stereotype.Component;

import eStoreProduct.model.CategoryReportViewModel;

@Component
public class CategoryReportDAOImpl implements CategoryReportDAO{
    @PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public List<CategoryReportViewModel> getCatRep() {
	    

	    String hql = "select  new eStoreProduct.model.CategoryReportViewModel(spc.id,spc.prct_title,count(*),sum(sop.price),sum(sop.gst),sum(sop.quantity)) \n"
	    	+ "	    from orderModel so,OrderProds sop,SlamProduct sp,productCategoryModel spc \n"
	    	+ "	    where sop.productId=sp.productId and sp.productCategory=spc.id group by spc.id";
	    
	    
	    
	List<CategoryReportViewModel> result = entityManager.createQuery(hql, CategoryReportViewModel.class).getResultList();

	/*
	 * List<CategoryReportViewModel> report = new ArrayList<>(); for (Object[] row :
	 * result) { CategoryReportViewModel viewModel = new CategoryReportViewModel();
	 * viewModel.setPtct_id((int) row[0]); viewModel.setPtct_name((String) row[1]);
	 * viewModel.setTotal_gst((double) row[2]); viewModel.setTotal_sales(((Long)
	 * row[3]).intValue()); viewModel.setTotal_amount((double) row[4]);
	 * viewModel.setTotal_products((int) row[5]); report.add(viewModel); }
	 */
	System.out.println("in catr dao");
	System.out.println(result);
	return result;

}

	}
