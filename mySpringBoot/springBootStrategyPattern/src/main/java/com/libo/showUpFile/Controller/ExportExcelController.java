package com.libo.showUpFile.Controller;

import com.libo.showUpFile.dto.ApiResponse;
import com.libo.showUpFile.dto.ExportExcelData;
import com.libo.showUpFile.services.ExportExcelServiceImpl;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Excel导出 Controller
 *
 * @author riemann
 * @date 2019/04/28 21:37
 */
@RestController
@RequestMapping(value = "/export")
public class ExportExcelController {

    @Autowired
    private ExportExcelServiceImpl exportExcelService;

    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    public ApiResponse exportExcel(@RequestBody ExportExcelData eeData,  HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse();
        if (eeData == null) {
            return null;
        } else {
            apiResponse = exportExcelService.exportExcel(eeData,response);
        }
        return apiResponse;
    }

}