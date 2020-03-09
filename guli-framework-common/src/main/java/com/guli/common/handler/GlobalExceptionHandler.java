package com.guli.common.handler;

import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.exception.GuliException;
import com.guli.common.util.ExceptionUtil;
import com.guli.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.SizeLimitExceededException;

/**
 * @author helen
 * @since 2019/6/25
 * 统一异常处理器
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 异常处理方法
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public R error(Exception e){
		//e.printStackTrace();//输出异常堆栈信息
		log.error(e.getMessage());
		return R.error();
	}

	@ExceptionHandler(BadSqlGrammarException.class)
	@ResponseBody
	public R error(BadSqlGrammarException e){
		//e.printStackTrace();//输出异常堆栈信息
		log.error(e.getMessage());
		//return R.error().code(20003).message("SQL语法错误");
		return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public R error(HttpMessageNotReadableException e){
		//e.printStackTrace();//输出异常堆栈信息
		log.error(e.getMessage());
		return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
	}


	@ExceptionHandler(SizeLimitExceededException.class)
	@ResponseBody
	public R error(SizeLimitExceededException e){
		//e.printStackTrace();//输出异常堆栈信息
		//log.error(e.getMessage());
		log.info("错误信息----------------------------");
		log.error(e.getMessage());
		return R.setResult(ResultCodeEnum.FILE_UPLOAD_ERROR);
	}

	@ExceptionHandler(GuliException.class)
	@ResponseBody
	public R error(GuliException e){
		//e.printStackTrace();//输出异常堆栈信息
		//log.error(e.getMessage());
		log.error(ExceptionUtil.getMessage(e));
		return R.error().message(e.getMessage()).code(e.getCode());
	}
}
