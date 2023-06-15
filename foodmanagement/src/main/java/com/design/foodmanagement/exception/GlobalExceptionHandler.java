package com.design.foodmanagement.exception;

import com.design.foodmanagement.pojo.res.Code;
import com.design.foodmanagement.pojo.res.RestFulBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.validation.ConstraintViolationException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * controller 数据校验异常
     * @param exception
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public RestFulBean<Integer> constraintViolationException(ConstraintViolationException exception) {
        RestFulBean<Integer> error = RestFulBean.error(Code.BAD_REQUEST, exception.getMessage());
        return error;
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public RestFulBean<Integer> httpRequestMethodNotSupportedException(HttpMessageNotReadableException exception) {
        RestFulBean<Integer> error = RestFulBean.error(Code.BAD_REQUEST, "参数转换失败");
        return error;
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public RestFulBean<Integer> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        RestFulBean<Integer> error = RestFulBean.error(Code.ERROR, "不支持该请求方式");
        return error;
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public RestFulBean<Integer> nullPointerException(ServletRequest req, NullPointerException exception) throws IOException {
        String uri = "";
        String body = "";
        if (req instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) req;
            body = StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding()));
            uri = wrapper.getRequestURI();
        }
        String message = getException(exception);
        logger.error("uri:{} 发生未知异常{}",uri,message);
        RestFulBean<Integer> error = RestFulBean.error(Code.Null_Pointer, exception.getMessage());
        return error;
    }

    //校验逻辑抛出
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RestFulBean<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            sb.append(error.getDefaultMessage()).append(",");
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        RestFulBean<Map<String, String>> error = RestFulBean.error(Code.BAD_REQUEST, sb.toString(),errors);
        return error;
    }
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public RestFulBean<Integer> SQLException(MethodArgumentNotValidException exception) {
        return RestFulBean.error(Code.BAD_REQUEST, "执行失败请刷新再试",400);
    }
    //HttpRequestMethodNotSupportedException 请求方式异常

    /**
     * 处理，实际为捕捉全局异常
     * @param exception 全局异常
     * @return 具体异常信息 后面那个是500报错内容是服务器内部异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestFulBean<String> Exception(ServletRequest req, Exception exception) throws IOException, ServletException {
        String uri = "";
        String body = "";
        if (req instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) req;
            body = StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding()));
            uri = wrapper.getRequestURI();
        }
        String message = getException(exception);
        logger.error("uri:{} 发生未知异常{}",uri,message);
        return RestFulBean.error(Code.ERROR,"请求异常");
    }
    public static String getException(Exception e) throws IOException {
        String ret = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        e.printStackTrace(pout);
        ret = new String(out.toByteArray());
        pout.close();
        out.close();
        return ret;

    }

}
