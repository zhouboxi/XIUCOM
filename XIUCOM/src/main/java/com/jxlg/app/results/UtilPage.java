package com.jxlg.app.results;

import java.util.List;

public class UtilPage<T> {
	private Integer totalPages;//得到总页数
	private Integer pageNumber;//
	private List<T> all;//得到的集合
	private Long totalElements;//得到总条数
	private Integer numberOfPage;//得到当前页面条数
	public UtilPage() {
		
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public List<T> getAll() {
		return all;
	}
	public void setAll(List<T> all) {
		this.all = all;
	}
	
	public Integer getNumberOfPage() {
		return numberOfPage;
	}
	public void setNumberOfPage(Integer numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	

}
