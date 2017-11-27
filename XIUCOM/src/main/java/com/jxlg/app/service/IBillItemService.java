package com.jxlg.app.service;

import com.jxlg.app.entity.BillItem;
import com.jxlg.app.results.UtilPage;

public interface IBillItemService {
	
	public UtilPage<BillItem> search(Integer itemId);

	public BillItem saveDetail(BillItem bill);

}
