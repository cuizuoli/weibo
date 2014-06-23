/*
 * @(#)AbstractExcelView.java $version 2014年6月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.view;

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.LocalizedResourceHelper;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.AbstractView;

/**
 * weibo
 * cn.cuizuoli.weibo.view.AbstractExcelView.java
 * cuizuoli
 * @date 2014年6月23日
 */
public abstract class AbstractExcelView extends AbstractView {

	/** The content type for an Excel response */
	private static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	/** The extension to look for existing templates */
	protected static final String EXTENSION = ".xlsx";

	private String url;

	/**
	 * Default Constructor.
	 * Sets the content type of the view to "application/vnd.ms-excel".
	 */
	public AbstractExcelView() {
		setContentType(CONTENT_TYPE);
	}

	/**
	 * Set the URL of the Excel workbook source, without localization part nor extension.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}

	/**
	 * Renders the Excel view, given the specified model.
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		SXSSFWorkbook wb;
		if (this.url != null) {
			wb = getTemplateSource(this.url, request);
		} else {
			wb = new SXSSFWorkbook();
			logger.debug("Created Excel Workbook from scratch");
		}
		wb.setCompressTempFiles(true);

		buildExcelDocument(model, wb, request, response);

		// Set the content type.
		response.setContentType(getContentType());

		// Should we set the content length here?
		// response.setContentLength(workbook.getBytes().length);

		// Flush byte array to servlet output stream.
		ServletOutputStream out = response.getOutputStream();
		wb.write(out);
		out.flush();

		// dispose of temporary files backing this workbook on disk
		wb.dispose();
	}

	/**
	 * Creates the workbook from an existing XLS document.
	 * @param url the URL of the Excel template without localization part nor extension
	 * @param request current HTTP request
	 * @return the SXSSFWorkbook
	 * @throws Exception in case of failure
	 */
	protected SXSSFWorkbook getTemplateSource(String url, HttpServletRequest request) throws Exception {
		LocalizedResourceHelper helper = new LocalizedResourceHelper(getApplicationContext());
		Locale userLocale = RequestContextUtils.getLocale(request);
		Resource inputFile = helper.findLocalizedResource(url, EXTENSION, userLocale);

		// Create the Excel document from the source.
		if (logger.isDebugEnabled()) {
			logger.debug("Loading Excel workbook from " + inputFile);
		}
		// XSSFWorkbook, InputStream, needs more memory
		OPCPackage pkg = OPCPackage.open(inputFile.getInputStream());
		return new SXSSFWorkbook(new XSSFWorkbook(pkg));
	}

	/**
	 * Subclasses must implement this method to create an Excel XSSFWorkbook document,
	 * given the model.
	 * @param model the model Map
	 * @param workbook the Excel workbook to complete
	 * @param request in case we need locale etc. Shouldn't look at attributes.
	 * @param response in case we need to set cookies. Shouldn't write to it.
	 */
	protected abstract void buildExcelDocument(
			Map<String, Object> model, SXSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * Convenient method to obtain the cell in the given sheet, row and column.
	 * <p>Creates the row and the cell if they still doesn't already exist.
	 * Thus, the column can be passed as an int, the method making the needed downcasts.
	 * @param sheet a sheet object. The first sheet is usually obtained by workbook.getSheetAt(0)
	 * @param row thr row number
	 * @param col the column number
	 * @return the HSSFCell
	 */
	protected Cell getCell(Sheet sheet, int row, int col) {
		Row sheetRow = sheet.getRow(row);
		if (sheetRow == null) {
			sheetRow = sheet.createRow(row);
		}
		Cell cell = sheetRow.getCell((short)col);
		if (cell == null) {
			cell = sheetRow.createCell((short)col);
		}
		return cell;
	}

	/**
	 * Convenient method to set a String as text content in a cell.
	 * @param cell the cell in which the text must be put
	 * @param text the text to put in the cell
	 */
	protected void setText(Cell cell, String text) {
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(text);
	}

	/**
	 * Convenient method to set a String as number content in a cell.
	 * @param cell the cell in which the text must be put
	 * @param number the number to put in the cell
	 */
	protected void setNumber(Cell cell, int number) {
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(number);
	}

	/**
	 * Convenient method to set a String as number content in a cell.
	 * @param cell the cell in which the text must be put
	 * @param bool the bool to put in the cell
	 */
	protected void setBoolean(Cell cell, boolean bool) {
		cell.setCellType(HSSFCell.CELL_TYPE_BOOLEAN);
		cell.setCellValue(bool);
	}

}
