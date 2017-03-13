package com.chemgood.bean;

import org.apache.commons.lang.StringUtils;

import java.util.Map;


public class PageInfoDO {

	// 排序字段及方式 如： "order asc"
	private String orderStr;

	// 当前页码
	private int toPage = 1;

	// 每页显示记录数
	private int perPageSize = 10;

	// 查询出的数据总数
	private int totalItem = 0;

	//当前查询返回结果数
	private int returnCount = 0;

	/**
	 * 判断当前页是否为第一页
	 *
	 * @return boolean
	 */
	public boolean isFirstPage() {
		return toPage == 1;
	}

	public String getOrderStr() {
		return orderStr;
	}

	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}

	public int getToPage() {
		//style 1 (简单分页)
		if (this.totalItem == 0 && (this.returnCount > 0 || toPage > 1)) {
			return toPage;
		}
		//style 2
		if (toPage > getTotalPage()) {
			return getTotalPage();
		} else {
			return toPage;
		}
	}

	public void setToPage(int toPage) {
		this.toPage = toPage;
	}

	public int getPerPageSize() {
		return perPageSize;
	}

	public void setPerPageSize(int perPageSize) {
		this.perPageSize = perPageSize;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	/**
	 * 得到上一页的页数
	 *
	 * @return int 如果当前页没有上一页，返回1
	 */
	public int getPreviousPage() {
		int back = toPage - 1;
		if (back <= 0) {
			back = 1;
		}
		return back;
	}

	/**
	 * 判断当前页是否为最后一页
	 *
	 * @return boolean
	 */
	public boolean isLastPage() {
		return this.getTotalPage() == toPage;
	}

	/**
	 * 得到下一页的页数
	 *
	 * @return int 如果当前也没有下一页，返回总页数
	 */
	public int getNextPage() {
		int back = toPage + 1;
		if (back > this.getTotalPage()) {
			back = this.getTotalPage();
		}
		return back;
	}

	/**
	 * 得到要显示的总页数
	 *
	 * @return int
	 */
	public int getTotalPage() {
		if (totalItem == 0) {
			return 0;
		}
		int result = totalItem / perPageSize;
		if (totalItem % perPageSize != 0) {
			result++;
		}
		return result;
	}

	/**
	 * 验证toPage页数是否合法
	 *
	 * @param toPage
	 * @return 验证后的toPage页数
	 */
	public int validateToPage(int toPage) {
		int pageNum = toPage;
		if (pageNum < 1) {
			pageNum = 1;
		}
		if (pageNum > getTotalPage()) {
			pageNum = getTotalPage();
		}
		return pageNum;
	}

	/**
	 * 构建PageInfo对象数据
	 *
	 * @param params
	 * 总记录数
	 */
	public void buildPageInfo(Map params) {
		String pageSize = (String) params.get("perPageSize");
		String toPage = (String) params.get("toPage");
		String orderStr = (String) params.get("orderStr");
		if (StringUtils.isNotBlank(pageSize)) {
			setPerPageSize(Integer.parseInt(pageSize));
		}
		if (StringUtils.isNotBlank(toPage)) {
			int page = 1;
			try {
				page = Integer.parseInt(toPage);
			} catch (Exception e) {
			}
			setToPage(page);
		}
		if (StringUtils.isNotBlank(orderStr)) {
			setOrderStr(orderStr);
		}
	}

	/**
	 * 构建PageInfo对象数据。 PageInfo的实现类专用，主要是验证当前页数的合法性
	 */
	public void validatePageInfo() {
		setToPage(validateToPage(toPage));
	}

	/**
	 * 得到要检索的结束行数
	 *
	 * @return 如果<code>toPage</code>和<code>perPageSize</code>中任何一个小于等于0， 则返回
	 *         <code>null</code>,用于在分页查询返回所有的数据（即不分页）。
	 */
	public Integer getEndRow() {
		if (toPage > 0 && perPageSize > 0) {
			return new Integer(toPage * perPageSize);
		}
		return new Integer(10);
	}

	/**
	 * 得到要检索的起始行数
	 *
	 * @return 如果<code>toPage</code>和<code>perPageSize</code>中任何一个小于等于0， 则返回
	 *         <code>null</code>,用于在分页查询返回所有的数据（即不分页）。
	 */
	public Integer getStartRow() {
		if (toPage > 0 && perPageSize > 0) {
			return new Integer((toPage - 1) * perPageSize);
		}
		return new Integer(0);
	}

	/**
	 * @param value
	 */
	protected String getSQLBlurValue(String value) {
		if (value == null) {
			return null;
		}
		return value + '%';
	}

	protected String formatDate(String datestring) {
		if (datestring == null || datestring.equals("")) {
			return null;
		} else {
			return (datestring + " 00:00:00");
		}
	}

	/**
	 * 时间查询时,结束时间的 23:59:59
	 */
	protected String addDateEndPostfix(String datestring) {
		if (datestring == null || datestring.equals("")) {
			return null;
		}
		return datestring + " 23:59:59";
	}

	/**
	 * 时间查询时，开始时间的 00:00:00
	 */
	protected String addDateStartPostfix(String datestring) {
		if (datestring == null || datestring.equals("")) {
			return null;
		}
		return datestring + " 00:00:00";
	}

	public int getDesiredPage() {
		return this.toPage;
	}

	public int getReturnCount() {
		return returnCount;
	}

	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	}

}
