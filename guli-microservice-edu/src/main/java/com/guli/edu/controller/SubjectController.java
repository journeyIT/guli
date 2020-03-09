package com.guli.edu.controller;


import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.exception.GuliException;
import com.guli.common.vo.R;
import com.guli.edu.service.SubjectService;
import com.guli.edu.vo.SubjectNestedVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author Journey
 * @since 2020-01-31
 */
@Api(description="课程分类管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/edu/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @ApiOperation(value = "Excel批量导入")
    @PostMapping("import")
    public R batchImport(
            @ApiParam(name = "file", value = "Excel文件", required = true)
            @RequestParam("file") MultipartFile file) {

        try{
            List<String> errorMsg = subjectService.batchImport(file);
            if(errorMsg.size() == 0){
                return R.ok().message("批量导入成功");
            }else{
                return R.error().message("部分数据导入失败").data("errorMsgList", errorMsg);
            }

        }catch (Exception e){
            //无论哪种异常，只要是在excel导入时发生的，一律用转成GuliException抛出
            throw new GuliException(ResultCodeEnum.EXCEL_DATA_IMPORT_ERROR);
        }
    }

    @ApiOperation(value = "嵌套数据列表")
    @GetMapping("")
    public R nestedList(){

        List<SubjectNestedVo> subjectNestedVoList = subjectService.nestedList();
        return R.ok().data("items", subjectNestedVoList);
    }
}

